package edu.nchu.cloudhis.model;

import lombok.Data;


@Data
public class PageCondition<M extends BaseModel> {

    private M condition;
    private Integer pageNum;
    private Integer pageSize;
}
