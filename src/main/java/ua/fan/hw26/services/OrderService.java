package ua.fan.hw26.services;


import ua.fan.hw26.dao.CustomerDao;
import ua.fan.hw26.dao.ItemDao;
import ua.fan.hw26.dao.OrderDao;
import ua.fan.hw26.entity.Customer;
import ua.fan.hw26.entity.Item;
import ua.fan.hw26.entity.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[93m";

    private final CustomerDao customerDao;
    private final OrderDao orderDao;
    private final ItemDao itemDao;

    public OrderService(CustomerDao customerDao, OrderDao orderDao, ItemDao itemDao) {
        this.customerDao = customerDao;
        this.orderDao = orderDao;
        this.itemDao = itemDao;
    }

    public void run() {
        createCustomers();
        createOrders();
        createItems();
        bindItems();

        System.out.println(ANSI_YELLOW + "SHOW ALL ITEMS" + ANSI_RESET);
        itemDao.findAll().forEach(this::printItemsInfo);

        System.out.println(ANSI_YELLOW + "ALL ORDERS OF CERTAIN CUSTOMER (BY NAME):" + ANSI_RESET);
        orderDao.findManyByCustomer("Masha", customerDao).forEach(this::printFormattedOrderInfo);

        System.out.println(ANSI_YELLOW + "SHOW CUSTOMERS IN AGE RANGE FROM 18 TO 25" + ANSI_RESET);
        customerDao.findManyInAgeRange(16, 18).forEach(this::printCustomerInfo);

        System.out.println(ANSI_YELLOW + "CHANGE STATUS OF UNDERAGE CUSTOMERS" + ANSI_RESET);
        customerDao.updateStatus();
        customerDao.findAll().forEach(this::printCustomerInfo);

        System.out.println(ANSI_YELLOW + "DELETE FIRST ORDER OF CERTAIN CUSTOMER" + ANSI_RESET);
        System.out.println("--- BEFORE ---");
        orderDao.findAll().forEach(this::printFormattedOrderInfo);
        System.out.println("--- AFTER ---");
        orderDao.deleteFirstOrderByCustomersName("Masha", customerDao);
        orderDao.findAll().forEach(this::printFormattedOrderInfo);

        System.out.println(ANSI_YELLOW + "ORDERS WITH ITEMS COUNT > 2" + ANSI_RESET);
        orderDao.findManyByItemsCount(2).forEach(this::printFormattedOrderInfo);

        System.out.println(ANSI_YELLOW + "UPDATE PIZZA PRICE:" + ANSI_RESET);
        itemDao.updateItemPrice("pizza", 20);
        orderDao.findAll().forEach(this::printFormattedOrderInfo);
    }

    private void bindItems() {
        List<Customer> customers = customerDao.findAll();
        List<Item> items = itemDao.findAll();
        List<Order> orders = orderDao.findAll();

        final Item item1 = items.get(0);
        final Item item2 = items.get(1);
        final Item item3 = items.get(2);
        final Item item4 = items.get(3);
        final Item item5 = items.get(4);

        final Customer customer1 = customers.get(0);
        final Customer customer2 = customers.get(1);

        final Order order1 = orders.get(0);
        final Order order2 = orders.get(1);
        final Order order3 = orders.get(2);

        orderDao.updateCustomer(order1.getId(), customer1.getId());
        orderDao.updateCustomer(order2.getId(), customer2.getId());
        orderDao.updateCustomer(order3.getId(), customer2.getId());

        orderDao.updateItem(order1.getId(), Arrays.asList(item1.getId(), item2.getId(), item4.getId()));
        orderDao.updateItem(order2.getId(), Arrays.asList(item3.getId(), item5.getId()));
        orderDao.updateItem(order3.getId(), Arrays.asList(item1.getId(), item4.getId()));
    }

    private void createItems() {
        final Item item1 = new Item("pizza", 14.49, 1);
        final Item item2 = new Item("knife", 10.99, 1);
        final Item item3 = new Item("bacon", 2.99, 2);
        final Item item4 = new Item("spoon", 0.35, 2);
        final Item item5 = new Item("fanta", 2.99, 2);
        itemDao.insertMany(Arrays.asList(item1, item2, item3, item4, item5));
    }

    private void createOrders() {
        final Order order1 = new Order(2022,2,12);
        final Order order2 = new Order(2022,3,15);
        final Order order3 = new Order(2022,5,16);
        orderDao.insertMany(Arrays.asList(order1, order2, order3));
    }

    private void createCustomers() {
        final Customer customer1 = new Customer("Sarah", "Johnson", 20, "new");
        final Customer customer2 = new Customer("Masha", "Do", 17, "new");
        customerDao.insertMany(Arrays.asList(customer1, customer2));
    }

    private void printFormattedOrderInfo(Order order) {
        Customer customer = customerDao.findById(order.getCustomerId()).get(0);
        List<Item> items = new ArrayList<>();
        if (order.getItemsId() != null) {
            order.getItemsId().forEach(itemId -> items.add(itemDao.findById(itemId).get(0)));
        }

        System.out.printf("Order ID: %s%n Date:%s%n Customer: %s %s%n Items: %n",
                order.getId(), order.getDate(), customer.getFirstName(), customer.getLastName());
        items.forEach(item -> System.out.printf("  %s - %s × %s€%n",
                item.getName(), item.getQuantity(), item.getPrice()));
        System.out.println();
    }

    private void printItemsInfo(Item item) {
        System.out.printf("Name: %s%n Price: %s%n ID: %s%n%n", item.getName(), item.getPrice(), item.getId());
    }

    private void printCustomerInfo(Customer customer) {
        System.out.printf("Name: %s %s%n Age: %s%n Status: %s%n%n",
                customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getStatus());
    }


}
