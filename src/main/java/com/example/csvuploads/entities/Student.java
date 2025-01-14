package com.example.csvuploads.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Builder(builderClassName = "Builder", toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
//    @GeneratedValue(generator = "UUID")
//    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    @JdbcTypeCode (SqlTypes.CHAR)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(length = 50)
    private String name;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private Integer age;
}
