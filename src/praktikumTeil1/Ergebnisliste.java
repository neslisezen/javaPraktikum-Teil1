package praktikumTeil1;
public class Ergebnisliste {
//Neslihan Sezen 556493	
	
	public void setzeErgebnis(Ergebnis ergebnis) {
		Datenspeicher.ergebnisListe.setze_an_Anfang(ergebnis);
	}
	
	public void ausgabeErgebnis() {
		Datenspeicher.ergebnisListe.ausgabeKnoten();
	}
	

}
