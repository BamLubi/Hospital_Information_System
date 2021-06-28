package edu.nchu.cloudhis.web;

import edu.nchu.cloudhis.model.DepartInfo;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.service.DepartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartInfoController {

    @Autowired
    private DepartInfoService departInfoService;

    @GetMapping("all")
    public Result<List<DepartInfo>> findAll(){
        return Result.okResult(departInfoService.findAll());
    }
}
