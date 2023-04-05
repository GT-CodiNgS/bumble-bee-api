package com.icbt.bumblebeeapi.service.impl;

import com.icbt.bumblebeeapi.repo.AdminRepo;
import com.icbt.bumblebeeapi.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 4/3/2023
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo adminRepo;


    @Autowired
    ModelMapper mapper;
    @Override
    public Boolean searchUser(String username, String password) {

        return adminRepo.existsAdminByUsernameAndPassword(username,password);

    }
}
