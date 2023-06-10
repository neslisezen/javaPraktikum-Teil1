package praktikumTeil1;
import java.lang.String;

/** Diese Klasse stellt einfach verkettete Listen (Vorw�rtsverkettung) 
    zur Verfuegung.
    Zur Navigation durch die Liste wird ein Zeiger "aktuelles Element" 
    bereitgestellt, der mit den Navigationsfunktionen "erstes_Element" und
    "naechstes_Element" bedient werden kann. */
public class VerketteteListe
{ 
  private Knoten kopf=new Knoten();
  private Knoten ende=new Knoten();
  private Knoten aktueller_knoten=null; // diese Initialisierung ist nicht optimal.
  
  /** Erzeugt eine leere vorwaertsverkettete Liste.*/
  public VerketteteListe()
  { kopf.nachfolger=ende;
  	ende.nachfolger=null; 
  }
  
  /** Ein Element wird an den Anfang der Liste gesetzt.
      Das neue Element wird zum aktuellen Element.
      @param element das Element, das an den Anfang der Liste 
      gesetzt werden soll.*/
  public void setze_an_Anfang(Object element)
  { 
	Knoten neuer_knoten = new Knoten();
    neuer_knoten.element = element;
    if(kopf.nachfolger != ende) {
    	neuer_knoten.nachfolger = kopf;
    	kopf = neuer_knoten;
    }
    else
    	kopf.element = neuer_knoten.element;
    
    aktueller_knoten = kopf;
  }
  
  /** 
      Einfuegen eines neuen Elements nach dem aktuellen Element.
      Das neue Element wird zum aktuellen Element.
      Ist die Liste noch leer, wird das neue Element das erste Element.
      @param element das Element, das in die Liste eingefuegt werden soll.*/    
  public void fuege_ein_nach(Object element)
  {  
	  if(aktueller_knoten==null) {
			setze_an_Anfang(element);
		  }
	  else {
		  
		  Knoten neuer_Knoten = new Knoten();
		  neuer_Knoten.element = element;
		  neuer_Knoten.nachfolger = aktueller_knoten.nachfolger;
		  aktueller_knoten.nachfolger= neuer_Knoten;
		  aktueller_knoten = neuer_Knoten;
		  
	  }
  }
  
//  /** Das erste Element wird geloescht.
//      Das zweite Element wird aktuelles Element, sofern es vorhanden ist.
//      @return Zeiger auf das geloeschte Element.
//      @throws leer_Ausnahme wird ausgeloest, wenn die Liste leer ist.*/
  public Object loesche_erstes_Element(){
	  try
	  { 
	  istListeLeer();
	  
	  Knoten geloeschter_Knoten = new Knoten();
	  geloeschter_Knoten = kopf;	  
	  kopf = geloeschter_Knoten.nachfolger;
	  aktueller_knoten = geloeschter_Knoten.nachfolger;
	  //es wird am Ende sein, wenn das Element letztes Element ist.
	  return geloeschter_Knoten.element;
	  
	  }
	  catch (leer_Ausnahme e) {
		  e.printStackTrace();
		  return null;
	  }
	  
  }
  

//  /** Das Element nach dem aktuellen Element wird geloescht.
//  @return Zeiger auf das geloeschte Element.        
//  @throws leer_Ausnahme wird ausgeloest, wenn die Liste leer ist.
//  @throws ende_Ausnahme wird ausgeloest, wenn das aktuelle Element     
//  das letzte Element der Liste ist.*/
  	public Object loesche_nach() {
  		 try
  		  { 
  		  istListeLeer();
  		  istEsLetztesElement();
  		  Knoten geloeschter_Knoten = new Knoten();
  		  
  		  geloeschter_Knoten = aktueller_knoten.nachfolger;
  		  
  		  aktueller_knoten.nachfolger = geloeschter_Knoten.nachfolger;
  		  
  		  return geloeschter_Knoten.element;
  		  }
  		  catch (leer_Ausnahme e) {
  			  e.printStackTrace();
  			  return null;
  		  }
  		 catch (ende_Ausnahme e) {
  			 System.out.println(e.getMessage());
  			return new Knoten().element;
  		 }
  		
  	}
  
  /** Das erste Element der Liste wird aktuelles Element.
      @return Zeiger auf das erste Element.
      @throws leer_Ausnahme wird ausgeloest, wenn die Liste leer ist.*/
  public Object erstes_Element()
  { 
	  try {
		  istListeLeer();
		  aktueller_knoten = kopf;
		  return aktueller_knoten.element;
	  }
	  catch(leer_Ausnahme e) {
		  e.printStackTrace();
		  return e.getMessage();
		   }
	 
  }


//  /** Das aktuelle Element der Liste wird zurueckgegeben.
//      @return Zeiger auf das aktuelle Element.
//      @throws leer_Ausnahme wird ausgeloest, wenn die Liste leer ist.*/
  public Object aktuelles_Element() {
	 
	  try {
		  istListeLeer();
		  return aktueller_knoten.element;
	  }
	  catch (leer_Ausnahme leer) {
		  leer.printStackTrace();
		  return leer.getMessage();
	  }
	
  }
  public void ausgabeKnoten(){
	  Knoten neuer_knoten = new Knoten();
	  neuer_knoten = aktueller_knoten;
	  erstes_Element();
	  for(int i=1; i<=laenge() ; i++) {
		  System.out.print(aktuelles_Element()+" ");
		  naechstes_Element();
	  }
	 
  }
  
  /** Der Nachfolger des aktuellen Elements wird aktuelles Element.
      @return Zeiger auf das neue aktuelle Element.
      @throws leer_Ausnahme wird ausgeloest, wenn die Liste leer ist.
      @throws ende_Ausnahme wird ausgeloest, wenn das aktuelle Element 
      das letzte Element der Liste ist.*/
  public Object naechstes_Element()
  { try {
	    istListeLeer();
	    istEsLetztesElement();
	    aktueller_knoten = aktueller_knoten.nachfolger;
	    return aktueller_knoten.element;
  }
  catch(leer_Ausnahme leer) {
	  return leer.getMessage();
  }
  catch(ende_Ausnahme ende) {
    return ende.getMessage();
    }
  
  }
  
  /** Prueft, ob das aktuelle Element 
      das letzte Element der Liste ist.*/
  public boolean ende_erreicht()
  {		try {
	  		istEsLetztesElement();
	  		return false;
  		}
  		catch (ende_Ausnahme e) {
  			return true;
  		}
  }
	
  public int laenge (){
	  int i=1;
	  var Temp = aktueller_knoten;
	  erstes_Element();
	  while(kopf.nachfolger != ende && aktueller_knoten.nachfolger != ende){
		  ++i;
		  naechstes_Element();
	  }
	  aktueller_knoten =Temp;
		  return i;
  }

  
  
  /** Ausnahme, wird ausgeloest, wenn versucht wird, Elemente in 
      einer leeren Liste anzusprechen.*/
  public class leer_Ausnahme extends RuntimeException
  { 	private static final long serialVersionUID = 1L;
  		public leer_Ausnahme(String message){
  			super(message);
  		}
  };    
  
  /** Ausnahme, wird ausgeloest, wenn versucht wird, Elemente nach 
      dem letzten Element der Liste anzusprechen.*/
  public class ende_Ausnahme extends RuntimeException
  { private static final long serialVersionUID = 1L;
  		public ende_Ausnahme(String message){
  			super(message);
  		}
  
  }; 
  
  private void istListeLeer() throws leer_Ausnahme {
	  
	if(kopf.element == null || aktueller_knoten == ende) 
		throw new leer_Ausnahme("Die Liste ist leer.");
  }
  
  private void istEsLetztesElement() throws ende_Ausnahme {
	  
		if( aktueller_knoten.nachfolger==ende || kopf.nachfolger == ende) 
			throw new ende_Ausnahme("Das aktuelle Element ist das letzte Element der Liste!!!");
		  
	  }

	public boolean equals(Object object) {
		if ((int)this.aktuelles_Element() == (int)object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		VerketteteListe that = (VerketteteListe) object;
		return aktueller_knoten.equals(that.aktueller_knoten);
	}

	public int hashCode() {
		return java.util.Objects.hash(super.hashCode(), aktueller_knoten);
	}

	// Diese eingebettete Klasse stellt Knotenobjekte zur Verf�gung
  // Knoten sind ausserhalb der Klasse VerketteteListe nicht sichtbar.
  private class Knoten
  { private Object element;
    private Knoten nachfolger;
  };

}


