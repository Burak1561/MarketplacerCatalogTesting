package com.albertsons.POJO.samplePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = "id" ,allowSetters = true, ignoreUnknown = true)

public class Student {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("id")
    private int id;
    @JsonProperty("section")
    private int section;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("company")
    private Company company;

}
