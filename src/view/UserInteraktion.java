package view;

import control.DateiManager;
import control.Konstanten;

import java.util.Scanner;


/**
 * Die Klasse verwaltet sämtliche Interaktion mit dem Nutzer
 */
public class UserInteraktion {


    public static void start(){
        System.out.println("Hallo, dieses Programm, zählt die Anzahl der Wörter in einem Text.");
        System.out.println("Bitte geben Sie Ihren Text in die file.txt ein.");

        Scanner scanner = new Scanner(System.in);

        String entscheidung="";
        boolean grossSchreibungBeachten=false;

        //Der Nutzer wird so oft nach der Eingabe gefragt, bis er die richtige Eingabe tätigt (j oder n)
        do{
            System.out.println("Soll bei der Groß- und Kleinschreibung unterschieden werden? (j/n)");

            entscheidung = scanner.nextLine();

            switch (entscheidung) {
            case "j":
                    grossSchreibungBeachten = true;
                    break;
            case "n":
                grossSchreibungBeachten = false;
                break;
            }

        }while (!entscheidung.equals("j")&&!entscheidung.equals("n"));
        //Der TreeMap wird gedruckt.
        TreeMapPrinter.print(DateiManager.leseDatei(Konstanten.DATEIPFAD, grossSchreibungBeachten));
    }
}
