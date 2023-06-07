package praktikumTeil1;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Scanner;
import praktikumTeil1.*;

public class Ziffernreihe {
	
	static VerketteteListe zufaelligeZahlen = new VerketteteListe();
	static VerketteteListe userZahlen = new VerketteteListe();
	static Scanner input = new Scanner (System.in);
	static Random zufallszahlengenerator=new Random();
	
	
	public static void main(String[] args) {
		spielGenerator();
		userEingabe();
		boolean returnValue = vergleichen();
		System.out.println(returnValue);

	}

	public static void userEingabe(){
		
		int temp=0, spielerEingabe=0;

		do {

			spielerEingabe = input.nextInt();
			userZahlen.fuege_ein_nach(spielerEingabe);
			++temp;  		//speichert Zahl der Eingabe

		}
		while(zufaelligeZahlen.laenge()!=temp);
	}

	public static boolean vergleichen1(){

		for(int i=0;i<100;i++) System.out.println();
		System.out.println("****************************************");

		if(vergleichen() == true)
			return true;
		else {
			Toolkit.getDefaultToolkit().beep();
			System.out.println("Laenge der Ziffernfolge ist "+ zufaelligeZahlen.laenge());
			zufaelligeZahlen.ausgabeKnoten();
			return false;
		}
	}

	public static void spielGenerator(){
		
		int zufallsziffer=zufallszahlengenerator.nextInt(10);
		zufaelligeZahlen.fuege_ein_nach(zufallsziffer);

		try {

			while(zufaelligeZahlen.naechstes_Element() != null)
			{// um altere Ziffern auszugeben
				zufaelligeZahlen.aktuelles_Element();
				Thread.sleep(2000);
			}
			System.out.println(zufallsziffer);
			Thread.sleep(2000);
		}

		catch (InterruptedException e) {}
		finally {
			for(int i=0;i<100;i++) System.out.println();
		}

	}
	public static boolean vergleichen() {
		zufaelligeZahlen.erstes_Element();
		userZahlen.erstes_Element();
	
		  for(int i=1; i<=userZahlen.laenge();i++){
			  if(zufaelligeZahlen.aktuelles_Element().equals(userZahlen.aktuelles_Element())) {
				  zufaelligeZahlen.naechstes_Element();
				  userZahlen.naechstes_Element();
			  }
			  else
				  return false;
		  }
		return false;
	}

}
