package com.poc_swagger3_security.service;

import jakarta.transaction.Transactional;

import java.util.List;

public interface ICRUD<REQUEST, RESPONSE>{

    @Transactional
    RESPONSE save(REQUEST request);

    RESPONSE findByOne(String id);

    List<RESPONSE> findAll();

    @Transactional
    RESPONSE update(REQUEST request);

    @Transactional
    RESPONSE delete(String id);
}
