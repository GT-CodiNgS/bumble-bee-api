package com.icbt.bumblebeeapi.service.impl;

import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.entity.User;
import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.Type;
import com.icbt.bumblebeeapi.exception.ValidateException;
import com.icbt.bumblebeeapi.repo.UserRepo;
import com.icbt.bumblebeeapi.repo.queryFactory.QueryFactory;
import com.icbt.bumblebeeapi.service.UserService;
import com.icbt.bumblebeeapi.util.mapper.UserMapper;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/4/2023
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    QueryFactory queryFactory;

    @Override
    public UserDTO save(UserDTO dto,String siteURL) throws MessagingException, UnsupportedEncodingException {

        if (!userRepo.existsByNicNumber(dto.getNicNumber())) {
            dto.setCreatedDate(new Date());
            dto.setVerificationCode(RandomString.make(64));
            User user = userRepo.save(userMapper.toUser(dto));
            sendVerificationEmail(user, siteURL);
            return modelMapper.map(user,UserDTO.class);
        }
        throw new ValidateException("User is already exists with this NIC number");

    }

    @Override
    public List<UserDTO> search(Type searchBy, String value) throws Exception {

//        try {
            List<User> users = queryFactory.GenerateSearchQuery(searchBy, value);
            if (!users.isEmpty()) {
                return modelMapper.map(users, new TypeToken<ArrayList<UserDTO>>() {
                }.getType());
            }
            return null;
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }

    }

    @Override
        public void sendVerificationEmail(User user, String siteURL)
            throws UnsupportedEncodingException, MessagingException{
            String toAddress = user.getEmail();
            String fromAddress = "gayasthasmika.w1@gmail.com";
            String senderName = "gayasthasmika";
            String subject = "Please verify your registration";
            String content = "Dear [[name]],<br>"
                    + "Please click the link below to verify your registration:<br>"
                    + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                    + "Thank you,<br>"
                    + "Bumble Bee.";

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);

            content = content.replace("[[name]]", user.getFirstName());
            String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
            content = content.replace("[[URL]]", verifyURL);

            helper.setText(content, true);

            mailSender.send(message);

        }


    @Override
    public boolean verify(String verificationCode) {
        User user = userRepo.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepo.save(user);

            return true;
        }

    }

    @Override
    public List<UserDTO> getAllCustomers() {

        List<User> userList = userRepo.findAll();
        if (!userList.isEmpty()) {
            return modelMapper.map(userList, new TypeToken<ArrayList<UserDTO>>() {
            }.getType());
        }
        return null;

    }

}
