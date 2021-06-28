package edu.nchu.cloudhis.web;

import edu.nchu.cloudhis.model.DrugInfo;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.remote.GlobalServerRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugInfoController {

    @Autowired
    private GlobalServerRemoteService globalServerRemoteService;

    /**
     * 实际通过feign接口访问远程global-server查询药品信息
     * @param condition
     * @return
     */
    @PostMapping("")
    public Result<List<DrugInfo>> findList(@RequestBody DrugInfo condition){
        return Result.okResult(globalServerRemoteService.findList(condition));
    }
}
