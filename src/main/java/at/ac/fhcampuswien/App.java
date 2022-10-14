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
        Scanner scan = new Scanner(System.in);

        System.out.print("n: ");
        int inputRows = scan.nextInt(); //Fragt Benutzer nach der gewünschten Zeilenanzahl.

        if (inputRows <= 0) {
            System.out.println("Invalid number!");
            return;
        }
        int count = 0; // Muss 0 sein. Bei Startwert 1 würde man mit Wert "2" in der Pyramide starten.

        for (int i = 1; i <= inputRows; i++) {
            for (int row = 1; row <= i ; row++) { //Fixierung row = 1, damit sich Spalentenazahl laufend erhöht.
                count++;
                System.out.print(count + " ");
            }
            System.out.println(); //Zeilenumbruch.
        }
    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here

        int rows = 6; //Anzahl Reihen lt. Angabe.
        //int count = 0;

        for (int i = 0; i < rows; i++) { //Übernimmt Anzahl vorgegebener Reihen
            for (int space = 4; space >= i; space--) //Verringert die Anzahl der Leerzeichen für Zentrierung.
                System.out.print(" ");
            for (int star = 0; star < i*2 +1 ; star++) //Erhöht Anzahl Sterne um i*2 +1 (da 1 Leerzeichen weniger)
                System.out.print("*");
            System.out.println(); //Zeilenumbruch
        }
    }

    //todo Task 4
    public void printRhombus() {
        // input your solution here
        Scanner scan = new Scanner(System.in);

        System.out.print("h: ");
        int h = scan.nextInt(); //Höhe (Anzahl Zeilen)
        System.out.print("c: ");
        char c = scan.next().charAt(0); //.charAt() erlaubt char über Scanner einzulesen

        if (h % 2 != 0) {
            System.out.println("Invalid number!");
        }
        //int spaces =0;
        for (int length = 0; length <= (h / 2); length++) { //length = Anzahl Zeilen
            for (int spaces = (h / 2) - 1; spaces > 0; spaces--) { //Space-Loop (Spaces -1, da an dieser Stelle char sein soll)
                System.out.print(" ");
            }
            for (int outputChar = 0; outputChar <= length; outputChar++) {//Char-Loop
                System.out.print(c);
            }
            System.out.println();
        }
        for (double length = h; length > (h/2); length--) {
            for (int spaces = 0; spaces > 0; spaces++) {
                System.out.print(" ");
            }
            for (int outputChar = h; outputChar > length; outputChar--) {
                System.out.println(c);
            }
            System.out.println();
        }
    }

    //todo Task 5
    public void marks() {
        // input your solution here
        Scanner scan = new Scanner(System.in);

        System.out.print("Mark 1: ");
        int mark = scan.nextInt();
        int count = 1;
        double sum = 0;
        int fives = 0;

        while (true) {
            if (mark > 5) {
                System.out.println("Invalid mark!");
                System.out.print("Mark " + count + ": ");
                mark = scan.nextInt();
            } else if (mark > 0 && mark < 5) {
                count++;
                System.out.print("Mark " + count + ": ");
                sum = sum + mark;
                mark = scan.nextInt();
            } else if (mark == 5) {
                count++;
                System.out.print("Mark " + count + ": ");
                sum = sum + mark;
                fives++;
                mark = scan.nextInt();
            } else {
                if (sum == 0) {
                    System.out.println("Average: " + String.format(Locale.US, "%.2f", sum));
                    System.out.println("Negative marks: " + fives);
                    return;
                } else {
                    System.out.println("Average: " + String.format(Locale.US, "%.2f", (sum / (count - 1))));
                    // String.format --> Locale.US für Ausgabe mit "." statt ","
                    // count-1, da die letzte Note (0) Durchschnitt verfälschen würde.
                    System.out.println("Negative marks: " + fives);
                    return;
                }
            }

        }
    }

    //todo Task 6
    public void happyNumbers() {
        // input your solution here
        Scanner scan = new Scanner(System.in);

        System.out.print("n: ");
        int number = scan.nextInt();

        int sum = 0; //Speichert Zwischensumme
        int x = 0; //Bedingung für Endlosschleife


        while (x == 0) { //Endlosschleife
            while (number != 0) {
                int lastDigit = number % 10; //Speichert letzte Stelle
                sum = (lastDigit * lastDigit) + sum; //Quadriert letzte Stelle + addiert zu Summe
                number = number / 10; //--> Nächste Zahl von r.n.l. wird behandelt.
            }

            if (sum == 4) { //Bedingung für sad number.
                System.out.println("Sad number!");
                return;
            }

            if (sum == 1) { //Bedingung für happy number.
                System.out.println("Happy number!");
                return;
            }
            number = sum;
            sum = sum - sum;
        }

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