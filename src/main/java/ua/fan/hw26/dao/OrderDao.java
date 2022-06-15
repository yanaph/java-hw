package ua.fan.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.fan.hw26.entity.Order;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class OrderDao extends AbstractDao<Order> {
    private static final String COLLECTION_NAME = "orders";
    private final static String CUSTOMER = "customerId";

    public OrderDao(MongoDatabase db) {
        super(db, COLLECTION_NAME);
    }

    public List<Order> findAll() {
        return super.findAll(Order.class);
    }

    public void updateCustomer(String orderId, String customerId) {
        final Document filter = new Document();
        filter.append("id", orderId);

        final Document update = new Document();
        update.append("customerId", customerId);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }

    public void updateItem(String orderId, List<String> itemsId) {
        final Document filter = new Document();
        filter.append("id", orderId);

        final Document update = new Document();
        update.append("itemsId", itemsId);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }

    public List<Order> findManyByItemsCount(int count) {
        String query = "this.itemsId.length > " + count;
        return super.findAll(Order.class, where(query));
    }

    public List<Order> findManyByCustomer(String name, CustomerDao customerDao) {
        final String customerId = customerDao.findByName(name).get(0).getId();
        return super.findAll(Order.class, eq(CUSTOMER, customerId));
    }

    public void deleteFirstOrderByCustomersName(String name, CustomerDao customerDao){
        collection.deleteOne(eq(CUSTOMER, customerDao.findByName(name).get(0).getId()));
    }
}
