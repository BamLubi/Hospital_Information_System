package edu.nchu.cloudhis.service;

import edu.nchu.cloudhis.dao.PrescriptionDao;
import edu.nchu.cloudhis.model.Prescription;
import edu.nchu.cloudhis.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PrescriptionService extends BaseService<PrescriptionDao, Prescription> {


    @Autowired
    private IdGen<String> idGen;

    /**
     * 用于插入处方以及处方详情
     * @param prescription
     */
    @Transactional //开启事务
    public void insertPrescription(Prescription prescription){
        //前置步骤，生成snowFlakeid，并且设置到prescription对象和presDetails对象中 // 设置updateTime
        prescription.preInsert(idGen);
        prescription.getPresDetailsList().forEach(pd->pd.setPresId(prescription.getId()));

        //1. 通过dao的insert方法插入prescription对象
        dao.insert(prescription);
        //2. 通过dao插入处方详情对象presDetails
        dao.insertPresDetails(prescription.getPresDetailsList());
    }

    /**
     * 更新处方与处方详情
     * @param prescription
     */
    @Transactional
    public void update(Prescription prescription) {
        prescription.preUpdate();
        //更新处方
        dao.update(prescription);
        //更具是否有处方详情来更新
        if(prescription.getPresDetailsList()!=null && !"".equals(prescription.getPresDetailsList())){
            //删除原处方详情
            dao.deletePresDetails(prescription.getId());
            //插入新处方详情
            dao.insertPresDetails(prescription.getPresDetailsList());
        }
    }
}
