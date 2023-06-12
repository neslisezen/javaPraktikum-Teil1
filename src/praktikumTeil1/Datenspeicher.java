/**
* Waldemar Friesen Matrikelnummer: 531682
*/

package praktikumTeil1;

import java.io.*;

public class Datenspeicher {
    /**
     * Speichert das übergebene Ergebnis in einer Datei.
     *
     * @param ergebnis das zu speichernde Ergebnis
     */
    public void speichern(Ergebnis ergebnis) {
        try (FileWriter writer = new FileWriter("Ergebnisliste.txt", true)) {
            // Die Informationen des Ergebnisses werden in einer Zeile der Datei gespeichert
            writer.write(ergebnis.getReihenLaenge() + "," + ergebnis.getSpielzeit() + "," + ergebnis.getSpielerName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static VerketteteListe ergebnisListe = new VerketteteListe();
    /**
     * Lädt gespeicherte Ergebnisse aus einer Datei und gibt sie als VerketteteListe zurück.
     *
     * @return eine VerketteteListe mit den geladenen Ergebnissen
     */
    public void laden() {
     

        try {
        	BufferedReader reader = new BufferedReader(new FileReader("Ergebnisliste.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Jede Zeile in der Datei enthält Informationen zu einem Ergebnis
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int reihenLaenge = Integer.parseInt(parts[0]);
                    long spielzeit = Long.parseLong(parts[1]);
                    String spielerName = parts[2];
                    Ergebnis ergebnis = new Ergebnis(spielerName, spielzeit, reihenLaenge);
                    ergebnisListe.setze_am_Ende(ergebnis);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
   
    }
}
