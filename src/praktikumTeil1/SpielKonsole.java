package praktikumTeil1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
//Line Mroue 544552

public class SpielKonsole {
	
	public static void Testen() throws InterruptedException {
		
		Scanner input = new Scanner (System.in);
		Ergebnisliste ergebnisListe = new Ergebnisliste();
		Datenspeicher datenSpeicher = new Datenspeicher();
		Ergebnis ergebnis;
		long totalTime;
		
		 // Name eingeben
	       // startzeit nehmen
	       // anzeige von zufallszahl --> speichern in egebnis
	       // nach 2 sekunden verschwindet diese
	       // clear console 
		
        Scanner scanner = new Scanner(System.in);
        System.out.println("Herzlich Willkommen zum Spiel Ziffernfolgen\n"
        		+ "********************************************");
        System.out.print("Bitte geben Sie Ihren Name ein: ");
        String name = scanner.next();
        System.out.println("Hi " + name +"\r\n"+
        "Moechtest du das Spiel Zahlenreihe spielen: [J]/[N] ?");
        String s1 = scanner.next();
        
        datenSpeicher.laden();
        
        while(s1.equalsIgnoreCase("J")){
        	Ziffernreihe reihe = new Ziffernreihe();
        	System.out.println("Die erste Zahl ist: ");
        	here: while(true) {	
        		long startTime = System.nanoTime();
        		reihe.spielGenerator();
        		reihe.userEingabe();
        		for(int i=0;i<100;i++) System.out.println();
        			System.out.println("****************************************");
        	
        		if(reihe.vergleichen() == true) {
        			System.out.println("Richtige Eingabe!");
        			System.out.println("*************************************");
        		}
        		
        		else { 
        			System.out.println("Falsche Antwort. GAME OVER :(");
        			long endTime   = System.nanoTime();
        			System.out.println("*************************************");
        			totalTime = (endTime - startTime)/1000000000;
        			ergebnis = new Ergebnis(name,totalTime,reihe.laenge());
        			ergebnisListe.setzeErgebnis(ergebnis);
        			ergebnisListe.ausgabeErgebnis();
        			break here;
        		}
        	
        	}
        	datenSpeicher.speichern(ergebnis);
        	System.out.println("\nMoechten Sie das Spiel Zahlenreihe noch einmal spielen: [J]/[N] ?");
            s1 = scanner.next();
        }
     
	}
		public static void main(String[] args) throws InterruptedException {
			Testen();
		}

}
