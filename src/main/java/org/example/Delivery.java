package org.example;

import java.util.List;

class Delivery implements Runnable {
    private String location;
    private String date;
    private List<Package> packages;
    private static int totalPackageValue = 0;
    private static int totalRevenue = 0;

    public Delivery(String location, String date, List<Package> packages) {
        this.location = location;
        this.date = date;
        this.packages = packages;
    }

    public static int getTotalRevenue() {
        return totalRevenue;
    }

    public static int getTotalPackageValue() {
        return totalPackageValue;
    }

    @Override
    public void run() {
        int distance = 0;
        distance = packages.get(0).distance;
        int totalValue = 0;
        for (Package p : packages) {
            totalValue += p.value;
            int revenue = distance;

            System.out.println("[Delivering for " + location + " and date " + date + " in " + distance + " seconds]");

            try {
                Thread.sleep(distance * 5000);
            } catch (InterruptedException e) {
                e.getMessage();
            }

            totalPackageValue += totalValue;
            totalRevenue += revenue;

        }

    }
}