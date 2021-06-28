package edu.nchu.cloudhis.remote;

import edu.nchu.cloudhis.model.DrugInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 用于远程范文GlobalServer
 */
@FeignClient(value = "global-server")
public interface GlobalServerRemoteService {

    @PostMapping("/internal/drug")
    public List<DrugInfo> findList(@RequestBody DrugInfo condition1);
}
