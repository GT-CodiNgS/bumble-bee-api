package com.icbt.bumblebeeapi.service;

import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.entity.User;
import com.icbt.bumblebeeapi.entity.enums.Type;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/4/2023
 */
public interface UserService {

    UserDTO save(UserDTO dto,String siteURL) throws MessagingException, UnsupportedEncodingException;
    List<UserDTO> search(Type searchBy, String value) throws Exception;
    public void sendVerificationEmail(User user, String siteURL) throws UnsupportedEncodingException, MessagingException;
    public boolean verify(String verificationCode);

}
