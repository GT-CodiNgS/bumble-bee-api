package com.icbt.bumblebeeapi.service;

import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.Type;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/4/2023
 */
public interface UserService {

    String save(UserDTO dto);
    List<UserDTO> search(Type searchBy, String value) throws Exception;
}
