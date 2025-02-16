package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        List<Package> packages = PackageViewer.viewPackages("packages.txt");
        Map<String, Map<String, List<Package>>> groupedPackages = PackageOrganizer.groupPackages(packages);

        List<Thread> threads = new ArrayList<>();

        //aici m am ajutat de internet
        for (Map.Entry<String, Map<String, List<Package>>> locationEntry : groupedPackages.entrySet()) {
            for (Map.Entry<String, List<Package>> dateEntry : locationEntry.getValue().entrySet()) {
                Thread thread = new Thread(new Delivery(locationEntry.getKey(), dateEntry.getKey(), dateEntry.getValue()));
                threads.add(thread);
                thread.start();
            }
        }

        System.out.println("Total value of packages: " + Delivery.getTotalPackageValue());
        System.out.println("Total revenue " + Delivery.getTotalRevenue());
    }
}