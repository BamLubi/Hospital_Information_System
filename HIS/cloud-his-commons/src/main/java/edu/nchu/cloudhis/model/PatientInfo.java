package edu.nchu.cloudhis.model;

import lombok.Data;

@Data
public class PatientInfo extends BaseModel {

    private String name;
    private String gender;
    private String identity;
    private Integer age;
    private String phoneNum;
    private String wxAccount;
}
