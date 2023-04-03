package com.icbt.bumblebeeapi.dto;

import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/4/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements SuperDTO{
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
    private BigDecimal amount;
    private String verificationCode;
    private boolean enabled;
}
