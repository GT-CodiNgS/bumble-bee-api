package com.icbt.bumblebeeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
public class Category implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private int cid;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(columnDefinition = "INT default '0'")
    private int isDelete;
    @JsonIgnore
    @OneToMany(mappedBy = "pId", cascade = {CascadeType.ALL})
    private List<Product> product = new ArrayList<>();
}
