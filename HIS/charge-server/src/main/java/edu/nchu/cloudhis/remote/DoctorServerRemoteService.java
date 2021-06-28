package edu.nchu.cloudhis.remote;

import edu.nchu.cloudhis.model.Prescription;
import edu.nchu.cloudhis.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "doctor-server")
public interface DoctorServerRemoteService {

    @PutMapping("/pres")
    public Result<Void> update(@RequestBody Prescription prescription);

    @PostMapping("/pres/find")
    public Result<Prescription> find(@RequestBody Prescription condition);
}
