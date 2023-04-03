package com.icbt.bumblebeeapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private int pId;
    private String name;
    @Column(columnDefinition = "INT default '0'")
    private int isDeleted;

    @CreationTimestamp
    @Column(columnDefinition = "DATETIME")
    private Date createdDate;

    @Column(columnDefinition = "DATETIME")
    private Date modifiedDate;

    @Column(columnDefinition = "VARCHAR(100)")
    private String modifiedBy;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category cid;
}
