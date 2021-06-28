package edu.nchu.cloudhis.model;

import edu.nchu.cloudhis.utils.IdGen;
import lombok.Data;

import java.util.Date;

@Data
public class RegisterInfo extends BaseModel {
    private String chargeStatus;
    private Double registerFee;
    private Date chargeTime;
    private PatientInfo patientInfo; //关联patient——id
    private EmployeeInfo doctor; //关联doctorid
    private DepartInfo departInfo; //关联部门id
    private EmployeeInfo operator; //关联operator_id

}
