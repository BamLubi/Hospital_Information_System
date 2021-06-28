package edu.nchu.cloudhis.dao;

import edu.nchu.cloudhis.model.PatientInfo;

public interface PatientInfoDao extends BaseDao<PatientInfo> {
    PatientInfo findByWxAccount(String wxAccount);
}