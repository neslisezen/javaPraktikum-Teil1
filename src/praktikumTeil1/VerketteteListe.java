/**
* Waldemar Friesen Matrikelnummer: 531682
*/

package datenspeicher;

public class VerketteteListe {
    private Knoten kopf = new Knoten();
    private Knoten ende = new Knoten();
    private Knoten aktueller_knoten = null;

    public VerketteteListe() {
        kopf.nachfolger = ende;
        ende.nachfolger = ende;
    }

    public void setze_an_Anfang(Object element) {
        Knoten neuer_knoten = new Knoten();
        neuer_knoten.element = element;
        neuer_knoten.nachfolger = kopf.nachfolger;
        kopf.nachfolger = neuer_knoten;
        aktueller_knoten = neuer_knoten;
    }

    public void fuege_ein_nach(Object element) {
        if (aktueller_knoten == null) {
            setze_an_Anfang(element);
        } else {
            Knoten neuer_knoten = new Knoten();
            neuer_knoten.element = element;
            neuer_knoten.nachfolger = aktueller_knoten.nachfolger;
            aktueller_knoten.nachfolger = neuer_knoten;
            aktueller_knoten = neuer_knoten;
        }
    }

    public Object loesche_erstes_Element() {
        if (kopf.nachfolger == ende) {
            throw new leer_Ausnahme();
        }

        Knoten geloeschter_knoten = kopf.nachfolger;
        kopf.nachfolger = geloeschter_knoten.nachfolger;

        if (aktueller_knoten == geloeschter_knoten) {
            aktueller_knoten = null;
        }

        return geloeschter_knoten.element;
    }

    public Object loesche_nach() {
        if (kopf.nachfolger == ende || aktueller_knoten == ende) {
            throw new leer_Ausnahme();
        }

        Knoten geloeschter_knoten = aktueller_knoten.nachfolger;

        if (geloeschter_knoten == ende) {
            throw new ende_Ausnahme();
        }

        aktueller_knoten.nachfolger = geloeschter_knoten.nachfolger;

        return geloeschter_knoten.element;
    }

    public Object erstes_Element() {
        if (kopf.nachfolger == ende) {
            throw new leer_Ausnahme();
        }

        aktueller_knoten = kopf.nachfolger;
        return aktueller_knoten.element;
    }

    public Object aktuelles_Element() {
        if (aktueller_knoten == null) {
            throw new leer_Ausnahme();
        }

        return aktueller_knoten.element;
    }

    public Object naechstes_Element() {
        if (aktueller_knoten == null || aktueller_knoten.nachfolger == ende) {
            throw new ende_Ausnahme();
        }

        aktueller_knoten = aktueller_knoten.nachfolger;
        return aktueller_knoten.element;
    }

    public boolean ende_erreicht() {
        return aktueller_knoten == ende || aktueller_knoten == null;
    }

    public class leer_Ausnahme extends RuntimeException {
        private static final long serialVersionUID =  1L;

        public leer_Ausnahme() {
            super("Die Liste ist leer.");
        }
    }

    public class ende_Ausnahme extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public ende_Ausnahme() {
            super("Das Ende der Liste wurde erreicht.");
        }
    }

    private class Knoten {
        private Object element;
        private Knoten nachfolger;
    }
}



