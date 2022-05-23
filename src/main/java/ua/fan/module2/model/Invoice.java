package ua.fan.module2.model;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import java.util.stream.Collectors;

import static ua.fan.module2.model.InvoiceType.*;

@Getter
public class Invoice {
    private static int limit;
    private final Device[] items;
    private final Customer customer;
    private final Date dateTime;
    private InvoiceType type;

    public Invoice(Device[] items, Customer customer, Date dateTime) {
        this.items = items;
        this.customer = customer;
        this.dateTime = dateTime;
        type = setInvoiceType();
    }

    private InvoiceType setInvoiceType() {
        int summaryPrice = getTotalPrice();
        if (summaryPrice > limit) {
            return WHOLE_SALE;
        } else {
            return RETAIL;
        }
    }

    public void setType(InvoiceType type) {
        this.type = type;
    }

    public static void setLimit(int limit) {
        if (limit < 0){
            throw new IllegalArgumentException("Limit can't be less than 0");
        }
        Invoice.limit = limit;
    }

    private String dateFormatting(){
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(this.dateTime);
    }

    @Override
    public String toString() {
        return "---> DATE: " + dateTime +
                "\n---> CUSTOMER: \n" + customer +
                "\n---> INVOICE TYPE: " + type +
                "\n---> ITEMS: \n " +
                Arrays.stream(items)
                        .map(Device::toString)
                        .collect(Collectors.joining(" ")) + "\n";
    }

    public int getTotalPrice(){
        return Arrays.stream(items)
                .mapToInt(Device::getPrice)
                .sum();
    }

    public int getAmountOfItems(){
        return items.length;
    }
}
