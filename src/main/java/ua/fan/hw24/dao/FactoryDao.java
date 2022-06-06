package ua.fan.hw24.dao;

import ua.fan.hw24.entity.Factory;

public class FactoryDao extends AbstractDao<Factory> {
    @Override
    protected void init() {
        aClass = Factory.class;
    }
}
