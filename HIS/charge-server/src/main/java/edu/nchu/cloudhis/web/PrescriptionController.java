package edu.nchu.cloudhis.web;

import edu.nchu.cloudhis.model.Prescription;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.remote.DoctorServerRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController

public class PrescriptionController {

    @Autowired
    private DoctorServerRemoteService doctorServerRemoteService;


    /**
     * 处方收费，基于处方id
     * PUT
     * @param prescription
     * @return
     */
    @PutMapping("/pres")
    public Result<Void> pres(@RequestBody Prescription prescription){
        prescription.setChargeTime(new Date());
        doctorServerRemoteService.update(prescription);
        return Result.SUCCESS_RESULT;
    }

}
