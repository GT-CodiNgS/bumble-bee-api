package com.icbt.bumblebeeapi.util.mapper;



import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/5/2023
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<UserDTO> pageToUserDTO(List<User> userList);
}
