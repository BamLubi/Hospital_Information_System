package edu.nchu.cloudhis.api;

import edu.nchu.cloudhis.model.DrugInfo;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/drug")
public class DrugInfoApi {

    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * 服务之间的接口，根据药品名和药品id查询药品相关信息
     * POST
     * @param condition
     * @return
     */
    @PostMapping("")
    public List<DrugInfo> findList(@RequestBody DrugInfo condition){
        return drugInfoService.findList(condition);
    }

    /**
     * 新增药品或更新药品
     * PUT
     * @param drugInfo
     * @return
     */
    @PutMapping("")
    public Result<Void> insert(@RequestBody DrugInfo drugInfo){
        drugInfoService.save(drugInfo);
        return Result.SUCCESS_RESULT;
    }

    /**
     * 删除药品，基于药品id
     * DELETE
     * @param drugInfo
     * @return
     */
    @DeleteMapping("")
    public Result<Void> delete(@RequestBody DrugInfo drugInfo){
        drugInfoService.delete(drugInfo);
        return Result.SUCCESS_RESULT;
    }
}
