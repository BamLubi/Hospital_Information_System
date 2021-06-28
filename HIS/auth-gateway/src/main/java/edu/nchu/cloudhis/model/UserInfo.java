package edu.nchu.cloudhis.model;

import lombok.Data;

@Data
public class UserInfo extends BaseModel {
    private String username;
    private String password;
    private EmployeeInfo employeeInfo; //关联的雇员信息
}
