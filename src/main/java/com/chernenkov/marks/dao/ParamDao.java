package com.chernenkov.marks.dao;

import com.chernenkov.marks.domain.Param;


public interface   ParamDao {
    Param getParam(Integer attrId, String byWhat, String value);
    void updateParam(Integer attrId, String byWhat, String value, String newValue);
}
