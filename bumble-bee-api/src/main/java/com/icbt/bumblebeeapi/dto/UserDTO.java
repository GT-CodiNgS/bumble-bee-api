package com.icbt.bumblebeeapi.dto;

import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/4/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String nicNumber;
    private String contactNumber;
    private Date dateOfBirth;
    private Date createdDate;
    private Date modifiedDate;
    private String modifiedBy;
    private int isDeleted;
    private RoleType roleType;
    private String address;
    private Gender gender;
}
