package com.oulam.service.impl;

import com.oulam.bean.FMForm;
import com.oulam.dao.FMFormMapper;
import com.oulam.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oulam on 2018/12/18.
 */
@Service("formService")
public class FormServiceImpl implements FormService{
    @Autowired
    FMFormMapper mapper;

    public int insert(FMForm form) {
        return mapper.insertSelective(form);
    }
}
