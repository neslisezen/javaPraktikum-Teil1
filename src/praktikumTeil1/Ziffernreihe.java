package praktikumTeil1;
import praktikumTeil1.*;

public class Ziffernreihe {
	private VerketteteListe zufaelligeZahlen = new VerketteteListe();
	private VerketteteListe userZahlen = new VerketteteListe();
	public Ziffernreihe() {

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean userEingabe(int userNummer){

	}

	public void spielGenerator(){
		int zufallsziffer=zufallszahlengenerator.nextInt(10);
		zufaelligeZahlen.fuege_ein_nach(zufallsziffer);

		try {

			for(int i=0; i < feld.laenge()-1; i++)
			{// um altere Ziffern auszugeben
				zuf.ausgabe(i);
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

}
