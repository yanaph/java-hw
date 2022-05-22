package ua.fan.module2.service;

import ua.fan.module2.model.Device;
import ua.fan.module2.model.Invoice;
import ua.fan.module2.util.AnalyticalRequests;
import ua.fan.module2.util.FileHandling;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ua.fan.module2.Main.RANDOM;

public class ShopService {
    private final ArrayList<Invoice> invoices = new ArrayList<>();

    public void processInvoicesData(String fileName) {
        FileHandling fileHandling = new FileHandling();
        List<Device> catalogue = fileHandling.readFile(fileName);
        generateListOfInvoices(catalogue);
        fileHandling.writeLog(invoices);
    }

    private void generateListOfInvoices(List<Device> catalogue) {
       try {
           System.out.print("\nSeconds left: ");
           for (int i = 0; i < 2; i++) {
               invoices.add(generateInvoice(catalogue));
               Thread.sleep(10);
               System.out.print(15-(i+1) +  "...");
           }
           System.out.println();
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }

    private Invoice generateInvoice(List<Device> catalogueOfDevices){
        int number = RANDOM.nextInt(5) + 1;
        Device[] items = new Device[number];
        for (int i = 0; i < number; i++) {
            items[i] = catalogueOfDevices.get(RANDOM.nextInt(catalogueOfDevices.size()));
        }
        return new Invoice(items, PersonService.createPerson(), new Date());
    }

    public void analyticRequestsResult(){
        final AnalyticalRequests analyticalRequests = new AnalyticalRequests();
        System.out.println("\n---> Number of items sold by category: \n" +
                "Televisions: " + analyticalRequests.soldAmountSortedByCategory(invoices, "Television") +
                "\nTelephones: " + analyticalRequests.soldAmountSortedByCategory(invoices, "Telephone"));

        System.out.println("\n---> Customer info of invoice with minimum total price: \n" +
                "Total: " + analyticalRequests.minSumInvoiceInfo(invoices).getTotalPrice() +
                "\n Customer info: \n" + analyticalRequests.minSumInvoiceInfo(invoices).getCustomer());

        System.out.println("\n---> Total price of all invoices: \n" +
                "Total: " + analyticalRequests.getTotalPriceOfAllInvoices(invoices));

        System.out.println("\n---> Number of invoices with retail type:\n" +
                analyticalRequests.getRetailInvoicesNumber(invoices));

        System.out.println("\n---> Invoices that contain only one type of devices:\n" +
                analyticalRequests.getOneDeviceTypeInvoices(invoices));

        System.out.println("\n---> Low age invoices:\n " +
                analyticalRequests.getLowAgeInvoices(invoices));

         System.out.println("\n---> Sorting invoices by condition:\n " +
                analyticalRequests.sortInvoicesByCondition(invoices));
    }
}
