package com.crownp.morethanjavacoding.mongoDB;

import java.util.List;

public interface CnnvdService {
    /**
     * 根据参数查询
     *
     * @param cnnvd
     * @return
     */
    Cnnvd listAllByCondition(Cnnvd cnnvd);

    /**
     * 查询所有数据
     *
     * @return
     */
    List<Cnnvd> findAll();

    /**
     * 用于分页查询
     * @param cnnvd
     * @param skip （第一个坐标为0）
     * @param limit
     * @return
     */
    List<Cnnvd> findList(Cnnvd cnnvd, int skip, int limit);

    /**
     *
     * @param cnnvd
     * @param skip （第一个坐标为0）
     * @param limit
     * @param order  asc-升序 desc-降序
     * @param sortBy  排序字段
     * @return
     */
    List<Cnnvd> findList(Cnnvd cnnvd,int skip,int limit,String order,String sortBy);

    /**
     * 保存实体
     * @param cnnvd
     */
    void save(Cnnvd cnnvd);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Cnnvd findOne(String id);

}
