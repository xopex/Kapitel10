package control;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Verwaltet den Umgang mit der Datei
 */
public class DateiManager {

    /**
     * Bekommt den absoluten Pfad zu einer Textdatei übergeben und einen boolean der festlegt,
     * ob die Großschreibung beachtet werden soll.
     * Die einzelnen Worte aus der Datei werden als Keys im TreeMap gespeichert.
     * Der Value ist die Häufigkeit
     * Zurückgelifert wird das TreeMap mit allen Worten des Textes
     * @param dateiPfad
     * @param grossSchreibungBeachten
     * @return
     */
    public static TreeMap<String, Integer> leseDatei(String dateiPfad, boolean grossSchreibungBeachten){
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        BufferedReader reader =null;
        try {
            reader = new BufferedReader(new FileReader(dateiPfad));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {

            if(reader!=null) {
                String zeile ="";
                //Iteriert durch den Text Zeile für Zeile
                while ((zeile=reader.readLine())!=null){
                    //Spaltet den Text an jedem Leerzeichen in ein String Array
                    String woerter []= zeile.split(" ");
                    //Iteriert durch jedes Wort des Wort Arrays
                    for (String wort:woerter){
                        //Die Sonderzeichen, die häufig direkt am Wort anliegen, sollen entfernt werden
                        wort=wort.replace(" ","");
                        wort=wort.replace(".","");
                        wort=wort.replace(",","");
                        wort=wort.replace(":","");
                        wort=wort.replace("\"","");
                        wort=wort.replace("\'","");
                        wort=wort.replace("(","");
                        wort=wort.replace(")","");
                        wort=wort.replace("-","");
                        //Wenn die Großschreibung nicht beachtet werden soll, werden alle Worte kleingeschrieben
                        if(!grossSchreibungBeachten)
                            wort=wort.toLowerCase();
                        if(!wort.equals("")) {
                            //wenn das Wort nicht in der Map enthalten ist, soll es mit dem value 1 eingefügt werden
                            if (!map.containsKey(wort))
                                map.put(wort, 1);
                            //ansonsten, soll es mit dem aktuellen Wert + 1 eingefügt werden
                            else
                                map.put(wort, map.get(wort) + 1);
                        }
                    }
                }

                reader.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

       return map;

    }


}
