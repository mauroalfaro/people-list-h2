package com.alfarosoft.peoplelist.model.patch;

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
public class EmployeePatch {
    private String id;
    private String address;
    private String phone;
    private String email;
    private boolean isActiveEmployee;
}