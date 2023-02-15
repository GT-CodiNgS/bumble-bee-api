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
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    QueryFactory queryFactory;

    @Override
    public String SaveUser(UserDTO dto) {

        if (!userRepo.existsByNicNumber(dto.getNicNumber())) {
            dto.setCreatedDate(new Date());
            User user = userRepo.save(userMapper.toUser(dto));
            return user.getUserName();
        }
        throw new ValidateException("User is already exists with this NIC number");

    }

    @Override
    public List<UserDTO> searchUser(Type searchBy, String value) throws Exception {

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
}
