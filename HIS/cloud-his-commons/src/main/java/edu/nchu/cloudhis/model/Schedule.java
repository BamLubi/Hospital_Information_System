package edu.nchu.cloudhis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Schedule extends BaseModel{
    private EmployeeInfo doctor;
    private String doctorName;
    private DepartInfo departInfo;
    private String level;
    private String scheduleDay;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date scheduleDate;
    private Integer remainAm;
    private Integer remainPm;
}
