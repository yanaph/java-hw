package ua.fan.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.fan.hw26.entity.Customer;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class CustomerDao extends AbstractDao<Customer> {
    private final static String COLLECTION_NAME = "customers";
    private final static String ID = "id";
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";
    private final static String STATUS = "status";

    public CustomerDao(MongoDatabase db) {
        super(db, COLLECTION_NAME);
    }

    public List<Customer> findAll() {
        return super.findAll(Customer.class);
    }

    public List<Customer> findByName(String name) {
        return super.findAll(Customer.class, or(eq(FIRST_NAME, name), eq(LAST_NAME, name)));
    }

    public List<Customer> findById(String id) {
        return super.findAll(Customer.class, eq(ID, id));
    }

    public List<Customer> findManyInAgeRange(Integer from, Integer to) {
        String more = "this.age > " + from;
        String less = "this.age < " + to;
        return super.findAll(Customer.class, and(where(less), where(more)));
    }

    public void updateStatus() {
        String query = "this.age < " + 18;

        final Document update = new Document();
        update.append(STATUS, "underage");

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateMany(where(query), doc);
    }
}
