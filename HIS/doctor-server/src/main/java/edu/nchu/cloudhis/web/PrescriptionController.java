package edu.nchu.cloudhis.web;


import edu.nchu.cloudhis.model.Prescription;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pres")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    /**
     * 新增处方
     * POST
     * 新增处方时：默认处方为未付款
     * @param prescription 处方信息
     * @return
     */
    @PostMapping("")
    public Result<Void> insert(@RequestBody Prescription prescription){
        prescriptionService.insertPrescription(prescription);
        return Result.SUCCESS_RESULT;
    }

    /**
     * 更新处方，基于处方ID
     * @param prescription
     * @return
     */
    @PutMapping("")
    public Result<Void> update(@RequestBody Prescription prescription){
        prescriptionService.update(prescription);
        return Result.SUCCESS_RESULT;
    }

    /**
     * 根据挂号id查询处方和处方详情
     * @param condition
     * @return
     */
    @PostMapping("find")
    public Result<Prescription> find(@RequestBody Prescription condition){
        return Result.okResult(prescriptionService.find(condition));
    }


}
