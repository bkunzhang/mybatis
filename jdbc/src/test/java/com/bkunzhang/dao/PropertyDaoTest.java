package com.bkunzhang.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyDaoTest {

    @Test
    public void getValue() {
        PropertyDao propertyDao = new PropertyDao();
        System.out.println(propertyDao.getValue("aes1.pass"));
    }
}