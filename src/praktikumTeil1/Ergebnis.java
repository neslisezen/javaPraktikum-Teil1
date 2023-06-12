package praktikumTeil1;
//Line Mroue 544552

public class Ergebnis {
	private String spielerName;
	private long spielzeit;
	private int reihenLaenge;
	
	public Ergebnis(String spielerName, long spielzeit, int ziffernLaenge) {
		this.spielerName = spielerName;
		this.spielzeit = spielzeit;
		this.reihenLaenge = ziffernLaenge;
	}
	
	public String getSpielerName() {
		return spielerName;
	}
	public long getSpielzeit() {
		return spielzeit;
	}
	public int getReihenLaenge() {
		return reihenLaenge;
	}

//	@Override
	public String toString() {
		return "Ergebnis: " + (spielerName != null ? "spielerName = " + spielerName + " " : "") + "spielzeit = "
				+ spielzeit + " ziffernLange = " + reihenLaenge;
	}
	
	
	

}
