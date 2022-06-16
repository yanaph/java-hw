package ua.fan.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.fan.hw26.entity.Item;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class ItemDao extends AbstractDao<Item>{
    private static final String COLLECTION_NAME = "items";
    public ItemDao(MongoDatabase db) {
        super(db, COLLECTION_NAME);
    }

    public List<Item> findAll() {
        return super.findAll(Item.class);
    }

    public List<Item> findById( String id){
        return super.findAll(Item.class, eq("id", id));
    }

    public void updateItemPrice(String itemName, int newPrice) {
        final Document filter = new Document();
        filter.append("name", itemName);

        final Document update = new Document();
        update.append("price", newPrice);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }
}
