public class Unterkunft {
    public String angebotName;
    public int preis;
    public String beschreibung;
    public int bewertung;
    public String name;
    public String stadt;
    public String unterkunftForm;
    
    public Unterkunft(String angebotName, int preis, String beschreibung, int bewertung, String name, String stadt, String unterkunftForm){
        this.angebotName = angebotName;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.bewertung = bewertung;
        this.name = name;
        this.stadt = stadt;
        this.unterkunftForm = unterkunftForm;
    }
}
