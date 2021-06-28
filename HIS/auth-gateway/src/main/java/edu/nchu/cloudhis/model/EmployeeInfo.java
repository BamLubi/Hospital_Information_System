package edu.nchu.cloudhis.model;

import lombok.Data;

@Data
public class EmployeeInfo extends BaseModel {
    private String name;
    private String phone;
    private Integer age;
    private String jobType;
    private String doctorRanker;
    private String introduce;
    private DepartInfo departInfo; //映射depart_id字符
}
