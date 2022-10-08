package at.ac.fhcampuswien;

import java.util.Locale;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber() {
        // input your solution here
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US); //Erlaubt Dezimaleingaben mit "." statt "," (US-Standard).
        // Source: https://stackoverflow.com/questions/49478968/input-double-with-dot-instead-of-comma

        double largestNumber = 0;
        double numbers; //Variable zur Speicherung der Benutzereingaben.
        int counter = 1; //Speicherung fortlaufender Nummerierung.

        System.out.print("Number " + counter + ": ");
        counter ++; //Zählt counter +1, da bei Ausführung der Schleife bereits Eingabe für Nummer 1 erforderlich.

        numbers = scan.nextDouble();

        if (numbers <= 0) { //Erste Prüfung, ob Zahl > 0 eingegeben.
            System.out.println("No number entered.");
            return;
        }

        while (true) {

            if (numbers > largestNumber) {
                largestNumber = numbers; //Speichert größte Zahl
            }
            if (numbers <= 0) {
                System.out.println("The largest number is " + String.format(Locale.US, "%.2f", largestNumber));
                //Gibt die größte Zahl aus. String.format -->.2f für Dezimalzahl mit 2 Nachkommerstellen.
                return; //Ausbruch aus endlos-Schleife
            }
            System.out.print("Number " + counter + ": ");
            counter++; //Erhöht Counter +1 in der Schleife
            numbers = scan.nextDouble(); //Liest nächste Zahl ein.
        }

    }


    //todo Task 2
    public void stairs(){
        // input your solution here
    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
    }

    //todo Task 4
    public void printRhombus(){
        // input your solution here
    }

    //todo Task 5
    public void marks(){
        // input your solution here
    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}