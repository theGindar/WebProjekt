
import java.util.ArrayList;

public class ArrayListDatabaseManager {

    private static ArrayList<Unterkunft> unterkuenfte = new ArrayList<>();
    private static int lastID = 0;
    
    public ArrayListDatabaseManager(){
        addUnterkunft(new Unterkunft("Vollpension", 40, "cool", 3, "Hotel am Graben", "Grabenstadt", "Hotel"));
        addUnterkunft(new Unterkunft("Vollpension", 30, "cool", 3, "Hotel am Graben", "Grabenstadt", "Hotel"));
        addUnterkunft(new Unterkunft("Halbpension", 20, "sehr cool", 4, "Herberge am Graben", "Grabenstadt", "Herberge"));
        addUnterkunft(new Unterkunft("Vollpension", 50, "cool", 5, "Luxushotel für Schluffis", "Schluffistadt", "Hotel"));
    }
    
    public ArrayList<Unterkunft> getAllUnterkuenfte(){
        return unterkuenfte;
    }

    public int addUnterkunft(Unterkunft newUnterkunft) {
        if(newUnterkunft == null){
            return -1;
        }
        
        newUnterkunft.id = lastID + 1;
        lastID += 1;

        unterkuenfte.add(newUnterkunft);
        return newUnterkunft.id;
    }

    public Unterkunft getCopyOfUnterkunft(int id) {
        Unterkunft unterkunft = this.getRealUnterkunft(id);
        
        if(unterkunft == null){
            return null;
        }
        return unterkunft.getCopyOfMe();
    }
    
    public boolean updateUnterkunft(int id, Unterkunft unterkunft){
        Unterkunft dbUnterkunft = this.getRealUnterkunft(id);
        
        if(dbUnterkunft == null){
            return false;
        }
        
        dbUnterkunft = unterkunft;
        
        return true;
    }
    
    private Unterkunft getRealUnterkunft(int id){
        for (Unterkunft unterkunft : unterkuenfte) {
            if (unterkunft.id == id) {
                return unterkunft;
            }
        }
        return null;
    }

}
