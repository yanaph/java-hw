package ua.fan.module2.util;

import ua.fan.module2.model.Invoice;
import ua.fan.module2.model.InvoiceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyticalRequests {
    public static final int AGE_LIMIT = 18;

    public int soldAmountSortedByCategory(ArrayList<Invoice> invoices, String type){
        return (int) invoices.stream()
                .map(Invoice::getItems)
                .flatMap(devices -> Arrays.stream(devices)
                        .filter(device -> device.getClass().getSimpleName().equals(type)))
                .count();
    }

    public Invoice minSumInvoiceInfo (ArrayList<Invoice> invoices){
        return invoices.stream()
                .min(Comparator.comparing(Invoice::getTotalPrice))
                .get();
    }

    public int getTotalPriceOfAllInvoices(ArrayList<Invoice> invoices){
        return invoices.stream()
                .mapToInt(Invoice::getTotalPrice)
                .sum();
    }

    public int getRetailInvoicesNumber(ArrayList<Invoice> invoices){
        return (int) invoices.stream()
                .filter(invoice -> invoice.getType().equals(InvoiceType.RETAIL))
                .count();
    }

    public List<Invoice> getOneDeviceTypeInvoices(ArrayList<Invoice> invoices){
        return invoices.stream()
                .filter(invoice -> Arrays.stream(invoice.getItems())
                                .allMatch(device -> device.getClass().getSimpleName().equals("Telephone")
                                || device.getClass().getSimpleName().equals("Television")))
                .collect(Collectors.toList());
    }

    public List<Invoice> getFirstThreeInvoices (ArrayList<Invoice> invoices){
        return invoices.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Invoice> getLowAgeInvoices(ArrayList<Invoice> invoices){
        return invoices.stream()
                .filter(invoice -> invoice.getCustomer().getAge()<AGE_LIMIT)
                .peek(invoice -> invoice.setType(InvoiceType.LOW_AGE))
                .collect(Collectors.toList());
    }

    public List<Invoice> sortInvoicesByCondition (ArrayList<Invoice> invoices){
        Comparator<Invoice> comparator = (obj1, obj2) -> obj2.getCustomer().getAge() - obj1.getCustomer().getAge();
        return invoices.stream()
                .sorted(comparator
                        .thenComparing(Invoice::getAmountOfItems)
                        .thenComparing(Invoice::getTotalPrice))
                .collect(Collectors.toList());
    }
}