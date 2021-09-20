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
@Entity(name = "Customer")
public class Customer {

    @Id
    private String id;
    private String name ;
    private String surname;
    private String loyaltyId ;
    private String address;
    private String phone ;
    private String email;
}
