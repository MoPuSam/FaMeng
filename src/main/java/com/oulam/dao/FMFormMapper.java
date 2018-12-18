package com.oulam.dao;

import com.oulam.bean.FMForm;

public interface FMFormMapper {
    int deleteByPrimaryKey(Long fId);

    int insert(FMForm record);

    int insertSelective(FMForm record);

    FMForm selectByPrimaryKey(Long fId);

    int updateByPrimaryKeySelective(FMForm record);

    int updateByPrimaryKey(FMForm record);
}