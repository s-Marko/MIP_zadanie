package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Disease {
    private String name;
    private int weight;
    private int combinedWeight = 0;
    private ArrayList<String> symptoms;			///PH
    private ArrayList<Disease> diseases = new ArrayList<Disease>();


    public Disease generateDisease() {
        Random random = new Random();
        int r = random.nextInt(combinedWeight);
        for (Disease disease: diseases) {
            if (r > disease.weight)
                return disease;
        }
        return diseases.get(0);
    }

    public String getName() {
        return this.name;
    }

    public Disease() {
        try {
            File diseaseFile = new File("objectGenerator/disease.txt");
            Scanner scanner = new Scanner(diseaseFile);
            String[] line;
            int weightIns;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().split(",", 2);
                weightIns = Integer.parseInt(line[1]);
                combinedWeight += weightIns;
                diseases.add(new Disease(line[0], weightIns));
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found - " + e);
            e.printStackTrace();
        }
    }

    private Disease(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
