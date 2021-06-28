package edu.nchu.cloudhis.dao;

import edu.nchu.cloudhis.model.PresDetails;
import edu.nchu.cloudhis.model.Prescription;

import java.util.List;

public interface PrescriptionDao extends BaseDao<Prescription> {

    /**
     * 插入处方对应的详情信息
     * @param presDetailsList
     */
    void insertPresDetails(List<PresDetails> presDetailsList);

    /**
     * 删除关联的处方详情
     * @param id
     */
    void deletePresDetails(String id);
}
