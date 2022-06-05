package ua.fan.hw24.dao;

import ua.fan.hw24.model.Factory;

public class FactoryDao extends AbstractDao<Factory> {
    @Override
    protected void init() {
        aClass = Factory.class;
    }
}
