package com.icbt.bumblebeeapi.service.impl;

import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.entity.User;
import com.icbt.bumblebeeapi.exception.ValidateException;
import com.icbt.bumblebeeapi.repo.UserRepo;
import com.icbt.bumblebeeapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @Override
    public String SaveUser(UserDTO dto) {

        if (!userRepo.existsByNicNumber(dto.getNicNumber())) {
            dto.setCreatedDate(new Date());
            User user = userRepo.save(modelMapper.map(dto, User.class));
            return user.getUserName();
        }

        throw new ValidateException("User is already exists with this NIC number");

    }
}
