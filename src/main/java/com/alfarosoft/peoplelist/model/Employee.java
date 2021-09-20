package com.alfarosoft.peoplelist.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
    private String dateHired;
    private boolean isActiveEmployee;
}
