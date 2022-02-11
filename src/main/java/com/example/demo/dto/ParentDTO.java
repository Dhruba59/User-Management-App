package com.example.demo.dto;

import com.example.demo.model.Parent;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParentDTO {
    public ParentDTO(Parent parent) {
        id = parent.getId();
        firstName = parent.getFirstName();
        lastName = parent.getLastName();
        city = parent.getAddress().getCity();
        state = parent.getAddress().getState();
        street = parent.getAddress().getStreet();
        zip = parent.getAddress().getZip();
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String street;
    private Integer zip;
}
