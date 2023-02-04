package com.icbt.bumblebeeapi.service;

import com.icbt.bumblebeeapi.dto.UserDTO;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/4/2023
 */
public interface UserService {

    String SaveUser(UserDTO dto);
}
