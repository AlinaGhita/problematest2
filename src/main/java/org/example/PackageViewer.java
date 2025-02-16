package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class PackageViewer {
    public static List<Package> viewPackages(String fileName) {
        List<Package> packages = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    packages.add(new Package(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]));
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return packages;
    }
}