package ua.fan.hw24.dao;

import org.hibernate.Metamodel;
import org.hibernate.query.criteria.internal.compile.CriteriaCompiler;
import ua.fan.hw24.config.HibernateFactoryUtil;
import ua.fan.hw24.model.Device;
import ua.fan.hw24.model.Factory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

public class DeviceDao extends AbstractDao<Device> {
    @Override
    protected void init() {
        aClass = Device.class;
    }

    public void doubleDevicePrice(Integer id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Device deviceToUpdate = entityManager.find(Device.class, id);
        deviceToUpdate.setPrice(deviceToUpdate.getPrice() * 2);
        entityManager.merge(deviceToUpdate);
    }

//    public List<Device> getAllDevicesOfCertainFactory() {
//
//    }
}
