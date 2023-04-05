package com.icbt.bumblebeeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 4/3/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO implements SuperDTO{
    private int id;
    private String username;
    private String email;
    private String password;
}
