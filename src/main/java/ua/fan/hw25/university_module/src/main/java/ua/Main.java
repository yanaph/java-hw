package ua;

import ua.config.HibernateFactoryUtil;
import ua.service.InfrastructureService;
import ua.service.UniversityService;

public class Main {
    private final static  InfrastructureService INFRASTRUCTURE_SERVICE = new InfrastructureService();

    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        INFRASTRUCTURE_SERVICE.createUniversityInfrastructure();
        INFRASTRUCTURE_SERVICE.print();
    }
}