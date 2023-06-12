package praktikumTeil1;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Scanner;
import praktikumTeil1.*;
//Neslihan Sezen 556493

public class Ziffernreihe {
	
	static VerketteteListe zufaelligeZahlen = new VerketteteListe();
	static VerketteteListe userZahlen = new VerketteteListe();
	static Scanner input = new Scanner (System.in);
	static Random zufallszahlengenerator=new Random();
	
	public void spielGenerator(){
		
		int zufallsziffer=zufallszahlengenerator.nextInt(10);
		zufaelligeZahlen.fuege_ein_nach(zufallsziffer);

		try {
			zufaelligeZahlen.erstes_Element();
			for(int i=1; i<=zufaelligeZahlen.laenge(); i++){
				System.out.print(zufaelligeZahlen.aktuelles_Element()+ " ");
				Thread.sleep(2000);
				zufaelligeZahlen.naechstes_Element();
				
			}
				
		}

		catch (InterruptedException e) {}
		finally {
			for(int i=0;i<100;i++) System.out.println();
		}

	}
	public void userEingabe(){
		
		int spielerEingabe=0;

		do {
			System.out.println("Geben Sie die Ziffer/n einzel ein: "); //test 
			for(int i=1; i<=zufaelligeZahlen.laenge(); i++)
				spielerEingabe = input.nextInt();
				userZahlen.fuege_ein_nach(spielerEingabe);
			}
		while(zufaelligeZahlen.ende_erreicht() != true);
	}

	public boolean vergleichen(){
		
		if(vergleichenKnoten() == true)
			return true;
		else {
			Toolkit.getDefaultToolkit().beep();
			int ziffernLange = zufaelligeZahlen.laenge();
			System.out.println("Laenge der Ziffernfolge ist "+ ziffernLange);
			zufaelligeZahlen.ausgabeKnoten();
			return false;
		}
	}


	private boolean vergleichenKnoten() {
		zufaelligeZahlen.erstes_Element();
		userZahlen.erstes_Element();
		int temp = 1, i=1;
		  for( ; i<=zufaelligeZahlen.laenge() ; i++){
			  Integer zufaelligeZahl = (Integer) zufaelligeZahlen.aktuelles_Element();
			  Integer userZahl = (Integer) userZahlen.aktuelles_Element();
			  if(zufaelligeZahl == userZahl) {
				  zufaelligeZahlen.naechstes_Element();
				  userZahlen.naechstes_Element();
				  temp++;
			  }
			  else
				  return false;
		  }
		  if(temp == i) {
			  return true;
		  }
		  else
			  return false;
	}
	
	public int laenge (){
		return zufaelligeZahlen.laenge();
	}
	
    }
