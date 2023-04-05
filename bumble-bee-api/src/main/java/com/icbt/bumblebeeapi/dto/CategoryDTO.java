package com.icbt.bumblebeeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements SuperDTO {

    private int cid;
    private String name;
    private int isDelete;
    private Date createdDate;
    private Date modifiedDate;
    private String modifiedBy;
}
