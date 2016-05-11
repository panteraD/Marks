package com.chernenkov.marks.service;


import com.chernenkov.marks.domain.Param;

public interface ParamService {
    Param getParam(Integer attrId, String byWhat, String value);

    /**
     *
     * @param attrId
     * @param byWhat
     * @param value
     * @param newValue
     */
    void updateParam(Integer attrId, String byWhat, String value, String newValue);
}
