package edu.nchu.cloudhis.web;

import edu.nchu.cloudhis.model.PatientInfo;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.service.PatientInfoService;
import edu.nchu.cloudhis.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientInfoController {

    @Autowired
    private PatientInfoService patientInfoService;

    @Autowired
    private IdGen idGen;

    /**
     * 获取病人信息，基于微信号
     * GET
     * @param wxAccount
     * @return
     */
    @GetMapping(value = "/patient/{wxAccount}")
    public Result<PatientInfo> getPatientInfo(@PathVariable String wxAccount){
        return Result.okResult(patientInfoService.findByWxAccount(wxAccount));
    }

    /**
     * 保存病人信息
     * @param patientInfo
     * @return
     */
    @PostMapping(value = "/patient/save")
    public Result<Void> savePatient(@RequestBody PatientInfo patientInfo){
        patientInfoService.save(patientInfo,idGen);
        return Result.SUCCESS_RESULT;
    }
}
