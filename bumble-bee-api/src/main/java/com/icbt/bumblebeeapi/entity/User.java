package com.icbt.bumblebeeapi.entity;
/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/2/2023
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.RoleType;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private int id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String userName;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "VARCHAR(100) unique", nullable = false)
    private String nicNumber;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String contactNumber;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATETIME")
    private Date dateOfBirth;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(columnDefinition = "DATETIME")
    private Date createdDate;

    @Column(columnDefinition = "DATETIME")
    private Date modifiedDate;

    @Column(columnDefinition = "VARCHAR(100)")
    private String modifiedBy;

    @Column(columnDefinition = "INT default '0'" )
    private int isDeleted;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "roleType is mandatory")
    private RoleType roleType;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList address;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "gender is mandatory")
    private Gender gender;

    private BigDecimal amount;

}
