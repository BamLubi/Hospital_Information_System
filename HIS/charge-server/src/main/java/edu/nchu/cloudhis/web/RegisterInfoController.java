package edu.nchu.cloudhis.web;

import edu.nchu.cloudhis.model.RegisterInfo;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.service.RegisterInfoService;
import edu.nchu.cloudhis.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RegisterInfoController {

    @Autowired
    private RegisterInfoService registerInfoService;

    @Autowired
    private IdGen idGen;

    /**
     * 挂号收费与新增挂号信息
     * 新增挂号信息：默认未缴费
     * PUT
     * @param registerInfo
     * @return
     */
    @PutMapping("/register")
    public Result<Void> registry(@RequestBody RegisterInfo registerInfo){
        registerInfo.setChargeTime(new Date());
        registerInfoService.save(registerInfo,idGen);
        return Result.SUCCESS_RESULT;
    }
}
