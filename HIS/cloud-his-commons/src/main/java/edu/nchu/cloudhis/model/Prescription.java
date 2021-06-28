package edu.nchu.cloudhis.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Prescription extends BaseModel {

    private String description;
    private String detail;
    private Double drugFee;
    private String presStatus;
    private Date chargeTime;
    private Date receiveTime;
    private EmployeeInfo doctor; //关联开处方的医生id
    private RegisterInfo registerInfo;//关联mr_id:就是关联挂号表register_info表的id
    private List<PresDetails> presDetailsList; //关联的处方详情对象
}
