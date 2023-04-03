package com.icbt.bumblebeeapi.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 4/3/2023
 */
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column(columnDefinition = "VARCHAR(10)")
    private String password;
}
