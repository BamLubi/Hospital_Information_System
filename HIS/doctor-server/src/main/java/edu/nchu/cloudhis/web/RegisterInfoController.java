package edu.nchu.cloudhis.web;

import com.alibaba.fastjson.JSON;
import edu.nchu.cloudhis.model.RegisterInfo;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.model.UserInfo;
import edu.nchu.cloudhis.service.RegisterInfoService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
@Slf4j
public class RegisterInfoController {

    @Autowired
    private RegisterInfoService registerInfoService;

    /**
     * 根据病人姓名或挂号或病人id，查询病人的挂号以及基本信息
     * @param condition 包含挂号或者病人姓名
     */
    @PostMapping("")
    public Result<RegisterInfo> find(@RequestBody RegisterInfo condition){
        log.info("获取的信息:{}", JSON.toJSONString(condition));
        return Result.okResult(registerInfoService.find(condition));
    }

}
