package edu.nchu.cloudhis.model;

import lombok.Data;

@Data
public class DrugInfo extends BaseModel {
    private String drugCode;
    private String drugName;
    private String unit;
    private Double price;
    private String details;
    private Integer stocks;
}
