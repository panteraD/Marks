package com.chernenkov.marks.service;


import com.chernenkov.marks.dao.ParamDao;
import com.chernenkov.marks.domain.Param;

public class ParamServiceImpl implements ParamService {
    private ParamDao paramDao;

    @Override
    public Param getParam(Integer attrId, String byWhat, String value) {
        return paramDao.getParam(attrId, byWhat, value);
    }

    @Override
    public void updateParam(Integer attrId, String byWhat, String value, String newValue) {
        paramDao.updateParam(attrId, byWhat, value, newValue);
    }

    public void setParamDao(ParamDao paramDao) {
        this.paramDao = paramDao;
    }
}
