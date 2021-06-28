package edu.nchu.cloudhis.service;

import edu.nchu.cloudhis.dao.DrugInfoDao;
import edu.nchu.cloudhis.model.DrugInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DrugInfoService extends BaseService<DrugInfoDao, DrugInfo> {
    /**
     * 更新药品
     * @param drugInfo
     */
//    @Transactional
//    public void update(DrugInfo drugInfo) {
//        drugInfo.preUpdate();
//        dao.update(drugInfo);
//    }

//    @Transactional
//    public void insertDrugInfo(DrugInfo drugInfo){
//        drugInfo.preInsert(idGen);
//        dao.insert(drugInfo);
//    }
}
