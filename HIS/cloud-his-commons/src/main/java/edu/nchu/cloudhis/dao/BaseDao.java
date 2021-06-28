package edu.nchu.cloudhis.dao;

import edu.nchu.cloudhis.model.BaseModel;

import java.util.List;

public interface BaseDao<M extends BaseModel> {

    void insert(M m);
    void insertMany(List<M> list);
    void delete(M condition);
    void deleteById(String id);
    void update(M m);
    M find(M condition);
    M findById(String id);
    List<M> findList(M condition);
    List<M> findAll();

}
