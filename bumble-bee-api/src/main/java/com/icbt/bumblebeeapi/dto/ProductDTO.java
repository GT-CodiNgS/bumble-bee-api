package com.icbt.bumblebeeapi.dto;

import com.icbt.bumblebeeapi.entity.Category;
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
public class ProductDTO implements SuperDTO {
    private int pId;
    private String name;
    private int isDeleted;
    private Date createdDate;
    private Date modifiedDate;
    private String modifiedBy;
    private Category cid;
}
