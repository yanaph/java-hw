package ua.fan.hw26;

import com.mongodb.client.MongoDatabase;
import ua.fan.hw26.dao.CustomerDao;
import ua.fan.hw26.dao.ItemDao;
import ua.fan.hw26.dao.OrderDao;
import ua.fan.hw26.services.OrderService;
import ua.fan.hw26.util.MongoUtil;

public class Main {
    private static final MongoDatabase db = MongoUtil.connect("shop");

    public static void main(String[] args) {
        final CustomerDao customerDao = new CustomerDao(db);
        final OrderDao orderDao = new OrderDao(db);
        final ItemDao itemDao = new ItemDao(db);
        final OrderService service = new OrderService(customerDao, orderDao, itemDao);
        service.run();
    }
}