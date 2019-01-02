package view;

import java.util.Map;
import java.util.TreeMap;

/**
 * Sorgt für die Ausgabe des TreeMaps
 */
public class TreeMapPrinter {

    /**
     * Bekommt eine TreeMap übergeben und druckt diese aus
     * @param map
     */
    public static void print(TreeMap<String, Integer> map){
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }
    }
}
