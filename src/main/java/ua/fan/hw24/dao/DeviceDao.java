package ua.fan.hw24.dao;

import ua.fan.hw24.entity.Device;
import ua.fan.hw24.entity.Factory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;


public class DeviceDao extends AbstractDao<Device> {
    @Override
    protected void init() {
        aClass = Device.class;
    }

    public void doubleDevicePrice(Integer id) {
        Device deviceToUpdate = ENTITY_MANAGER.find(Device.class, id);
        deviceToUpdate.setPrice(deviceToUpdate.getPrice() * 2);
        ENTITY_MANAGER.merge(deviceToUpdate);
    }

    public List<Object[]> getTotalInfoAboutEachFactory(){
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        final Root<Device> deviceRoot = criteriaQuery.from(Device.class);
        Join<Device, Factory> factoryJoin = deviceRoot.join("factory");

        criteriaQuery.multiselect(
                factoryJoin.get("id"),
                criteriaBuilder.count(deviceRoot.get("id")),
                criteriaBuilder.sum(deviceRoot.get("price")));

        criteriaQuery.groupBy(factoryJoin.get("id"), factoryJoin.get("name"));
        Query query = ENTITY_MANAGER.createQuery(criteriaQuery);
         return query.getResultList();
//        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
//        final CriteriaQuery<Object[]> criteriaBuilderQuery = criteriaBuilder.createQuery(Object[].class);
//        final Root<Device> entity = criteriaBuilderQuery.from(Device.class);
//        criteriaBuilderQuery.multiselect(entity.get("factory"), criteriaBuilder.count(entity.get("id")), criteriaBuilder.sum(entity.get("price"))).groupBy());
//        return ENTITY_MANAGER.createQuery(criteriaBuilderQuery).getResultList();


//        Query criteriaQuery = ENTITY_MANAGER.createQuery(
//                "SELECT device.factory, COUNT(device.id), SUM(price) FROM Device device GROUP BY device.factory"
//        );
//        List<Object[]> resultList = criteriaQuery.getResultList();
//        resultList.forEach(objects -> System.out.println(Arrays.toString(objects)));

//        try (Session session = HibernateFactoryUtil.getSessionFactory().openSession()){
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//
//            CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
//            final Root<Device> from = criteriaQuery.from(Device.class);
//            criteriaQuery.multiselect(from.get("factory"), builder.sum(from.get("price")));
//            criteriaQuery.groupBy(from.get("factory"));
//            Query<Object[]> criteriaQuery = session.createQuery(criteriaQuery);
//
//            List<Object[]> resultList = criteriaQuery.getResultList();
//            resultList.forEach(factory -> System.out.printf("Factory ID: %s%n Count: %s%n Sum: %s%n",
//                    factory[0], factory[1], factory[2]));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }

}
