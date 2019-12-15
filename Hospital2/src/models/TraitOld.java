package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TraitOld {
    private String name;
    private int modifier;
    private int weight;
    private ArrayList<TraitOld> smoke = new ArrayList<>();
    private int smokeWeight = 0;
    private ArrayList<TraitOld> exercise = new ArrayList<>();
    private int exerciseWeight = 0;

    public String getTraitName() { return this.name; }
    public int getModifier() { return this.modifier; }
    public int getWeight() { return this.weight; }

    public TraitOld() {
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader("objectGenerator/traits.json");
            JSONObject json = (JSONObject) parser.parse(reader);
            JSONArray smokeJson = (JSONArray) json.get("smoke");
            JSONArray exerciseJson = (JSONArray) json.get("exercise");
            System.out.println(json.get("smoke").getClass());
            System.out.println(smokeJson.getClass());

            for (Object value : smokeJson) {
                JSONObject o = (JSONObject) value;
                smokeWeight += ((Long)o.get("weight")).intValue();
                smoke.add(new TraitOld(
                        (String)o.get("name"),
                        ((Long)o.get("modifier")).intValue(),
                        ((Long)o.get("weight")).intValue()
                ));
            }

            for (Object value : exerciseJson) {
                JSONObject o = (JSONObject) value;
                exerciseWeight += ((Long)o.get("weight")).intValue();
                exercise.add(new TraitOld(
                        (String)o.get("name"),
                        ((Long)o.get("modifier")).intValue(),
                        ((Long)o.get("weight")).intValue()
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TraitOld> generateTraits() {
        ArrayList<TraitOld> list = new ArrayList<>();
        Random random = new Random();
        int countWeight = 0;
        if (random.nextInt(100) < 21) {
            int r = random.nextInt(smokeWeight);
            for (TraitOld t : smoke) {
                countWeight += t.getWeight();
                if (countWeight >= r) {
                    list.add(t);
                    countWeight = 0;
                    break;
                }
            }
        }
        if (random.nextInt(100) < 55) {
            int r = random.nextInt(exerciseWeight);
            for (TraitOld t : exercise) {
                countWeight += t.getWeight();
                if (countWeight >= r) {
                    list.add(t);
                    break;
                }
            }
        }
        return list;
    }

    private TraitOld(String name, int modifier, int weight) {
        this.name = name;
        this.modifier = modifier;
        this.weight = weight;
    }
}
