package spielKonsole;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import datenStrukturen.Ziffernreihe;

public class SpielKonsole {
	
	public static void Testen() throws InterruptedException {
		Ziffernreihe reihe = new Ziffernreihe();
		Scanner input = new Scanner (System.in);
		
		 // Name eingeben
	       // startzeit nehmen
	       // anzeige von zufallszahl --> speichern in egebnis
	       // nach 2 sekunden verschwindet diese
	       // clear console 
		
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name eingeben:");
        String name = scanner.next();
        System.out.println("Hi " + name +"\r\n" 
        + "Herzlich Willkommen zum Spiel Ziffernfolgen\n"
        + "*****************************************************");
        System.out.println("Möchtest du das Spiel Zahlenreihe spielen: [J]/[N] ?");
        String s1 = scanner.next();

		
        if (s1.equals("J")) {
        System.out.println("Die erste Zahl ist: ");
        while(true) {
        	reihe.spielGenerator();
        	reihe.userEingabe();
        	for(int i=0;i<100;i++) System.out.println();
    		System.out.println("****************************************");
        	if(reihe.vergleichen1()==true) {
        		System.out.println("Richtige Eingabe!");
        		System.out.println("*************************************");
        	}
        	else { 
        		System.out.println("Falsche Antwort. GAME OVER :(");
        		System.out.println("*************************************");
        		break;
        	}
        	
        }
   	 }

      /*long startTime = System.nanoTime();
		long endTime   = System.nanoTime();
		long totalTime = (endTime - startTime)/1000000000;
		
		Ergebnis newplayer = new Ergebnis(name, totalTime, reihe.laenge());
		System.out.println("Spielername: "+ newplayer.getName());
		System.out.println("Spielzeit: "+ newplayer.spielZeit(null) + " seconds");
//		System.out.println("Länge des Arrays: "+ newplayer.getLaenge());
		*/

}
		public static void main(String[] args) throws InterruptedException {
		Testen();
		}

}
