package edu.nchu.cloudhis.model;

import lombok.Data;

@Data
public class DepartInfo extends BaseModel {
    private String departName;
    private String departCode;
    private String departType;
}
