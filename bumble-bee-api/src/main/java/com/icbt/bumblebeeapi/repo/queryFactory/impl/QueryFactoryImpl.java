package com.icbt.bumblebeeapi.repo.queryFactory.impl;


import com.icbt.bumblebeeapi.entity.User;
import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.Type;
import com.icbt.bumblebeeapi.repo.UserRepo;
import com.icbt.bumblebeeapi.repo.queryFactory.QueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble_bee
 * @since 2/12/2023
 */
@Component
public class QueryFactoryImpl implements QueryFactory {

    @Autowired
    UserRepo userRepo;
    @Override
    public List<User> GenerateSearchQuery(Type type, String value) {
        System.out.println(type);
        switch (type.toString()){
            case "ID" :
                return userRepo.findByIdLike(Integer.parseInt(value));
            case "NAME" :
                return userRepo.findByNameLike(value);
            case "ADDRESS" :
                return userRepo.findByAddressContaining(value);
            case "EMAIL" :
                return userRepo.findByEmailLike(value);
            case "NIC" :
                return userRepo.findByNiclLike(value);
            case "DELETE" :
                return userRepo.findByIsDeleted(Integer.parseInt(value));
            case "AMOUNT" :
                return userRepo.findByAmount(Double.parseDouble(value));
            case "ANY" :
                return userRepo.findByAny(value,value,value,value);
            default:
                return null;
        }
    }
}
