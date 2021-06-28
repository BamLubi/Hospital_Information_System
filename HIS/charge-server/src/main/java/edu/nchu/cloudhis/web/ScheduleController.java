package edu.nchu.cloudhis.web;

import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.model.Schedule;
import edu.nchu.cloudhis.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("")
    public Result<List<Schedule>> findList(@RequestBody Schedule condition){
        return Result.okResult(scheduleService.findList(condition));
    }
}
