package spielKonsole;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ergebnis {
	
	private String name;
	private LocalDateTime spielzeit;
	public int laenge;
	
	/**
	 * @param name
	 * @param totalTime
	 * @param laenge
	 */
	
	public Ergebnis(String name, long totalTime, int laenge) {
		super();
		this.name = name;
		this.laenge = laenge;
	}

	/**
	 * gibt der Name des Spielers zurück 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gibt die Länge der Reihe zurück
	 * @return
	 */
	
	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}
	
	/**
	 * gibt das Spielzeit zurück
	 * @param startZeit
	 */
	
	public LocalDateTime spielZeit(LocalDateTime beginn) {
        LocalDateTime zeit = LocalDateTime.now();
        Duration spielzeitDauer = Duration.between(beginn, zeit);
        this.spielzeit = beginn.plusSeconds(spielzeitDauer.getSeconds());
        return spielzeit;
    }

}
