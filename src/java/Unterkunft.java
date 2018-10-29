public class Unterkunft {
    public int id;
    public String angebotName;
    public int preis;
    public String beschreibung;
    public int bewertung;
    public String name;
    public String stadt;
    public String unterkunftForm;
    
    public Unterkunft(){
        
    }
    
    public Unterkunft(String angebotName, int preis, String beschreibung, int bewertung, String name, String stadt, String unterkunftForm){
        this.angebotName = angebotName;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.bewertung = bewertung;
        this.name = name;
        this.stadt = stadt;
        this.unterkunftForm = unterkunftForm;
    }
    
    public Unterkunft getCopyOfMe(){
        Unterkunft copyUnterkunft = new Unterkunft();
        
        copyUnterkunft.id = this.id;
        copyUnterkunft.angebotName = this.angebotName;
        copyUnterkunft.preis = this.preis;
        copyUnterkunft.beschreibung = this.beschreibung;
        copyUnterkunft.bewertung = this.bewertung;
        copyUnterkunft.name = this.name;
        copyUnterkunft.stadt = this.stadt;
        copyUnterkunft.unterkunftForm = this.unterkunftForm;
        
        return copyUnterkunft;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getAngebotName(){
        return this.angebotName;
    }
    
    public int getPreis(){
        return this.preis;
    }
    
    public String getBeschreibung(){
        return this.beschreibung;
    }
    
    public int getBewertung(){
        return this.bewertung;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getStadt(){
        return this.stadt;
    }
    
    public String getUnterkunftForm(){
        return this.unterkunftForm;
    }
}
