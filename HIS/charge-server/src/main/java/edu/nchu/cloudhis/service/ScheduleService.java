package edu.nchu.cloudhis.service;

import edu.nchu.cloudhis.dao.ScheduleDao;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.model.Schedule;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ScheduleService extends BaseService<ScheduleDao, Schedule> {
}