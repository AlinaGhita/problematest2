package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PackageOrganizer extends Package{
    public PackageOrganizer(String location, int distance, int value, String deliveryDate) {
        super(location, distance, value, deliveryDate);
    }

    public static Map<String, Map<String, List<Package>>> groupPackages(List<Package> packages) {
        return packages.stream()
                //se grupeaza pachetele in functie de locatie si data
                .collect(Collectors.groupingBy(p -> p.location, Collectors.groupingBy(p -> p.deliveryDate)));
    }
}
