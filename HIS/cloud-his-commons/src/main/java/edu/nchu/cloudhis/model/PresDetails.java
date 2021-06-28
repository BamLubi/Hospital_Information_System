package edu.nchu.cloudhis.model;

import lombok.Data;

@Data
public class PresDetails{
    private DrugInfo drugInfo;//关联的药品信息
    private Integer drugCount;//开具的药品数量
    private String presId; //处方id
}
