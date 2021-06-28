package edu.nchu.cloudhis.service;

import edu.nchu.cloudhis.dao.PatientInfoDao;
import edu.nchu.cloudhis.model.PatientInfo;
import org.springframework.stereotype.Service;

@Service
public class PatientInfoService extends BaseService<PatientInfoDao, PatientInfo> {
    public PatientInfo findByWxAccount(String wxAccount) {
        return dao.findByWxAccount(wxAccount);
    }
}
