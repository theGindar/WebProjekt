
import java.util.ArrayList;

public class ArrayListDatabaseManager {

    private static ArrayList<Unterkunft> unterkuenfte = new ArrayList<>();
    private static int lastID = -1;

    public ArrayListDatabaseManager() {
        addUnterkunft(new Unterkunft("Vollpension", 40, "cool", 3, "Hostel am Graben", "Aachen", "Hostel"));
        addUnterkunft(new Unterkunft("Vollpension", 70, "cool", 3, "Hotel am Erisee", "Berlin", "Luxushotel"));
        addUnterkunft(new Unterkunft("Halbpension", 20, "sehr cool", 4, "Herberge am Graben", "Aachen", "Jugendherberge"));
        addUnterkunft(new Unterkunft("Vollpension", 250, "cool", 5, "Luxushotel für Schluffis", "Dessau", "Luxushotel"));
    }

    public ArrayList<Unterkunft> getAllUnterkuenfte() {
        return unterkuenfte;
    }

    public ArrayList<Unterkunft> getFilteredUnterkuenfte(String chosenStadtKategorie, String chosenUnterkunftKategorie, String chosenBudgetKategorie) {
        ArrayList<Unterkunft> returnUnterkuenfte = (ArrayList<Unterkunft>) getAllUnterkuenfte().clone();
        ArrayList<Unterkunft> helpUnterkunftList = (ArrayList<Unterkunft>) returnUnterkuenfte.clone();

        if (chosenStadtKategorie != null && !chosenStadtKategorie.equals("") && !chosenStadtKategorie.equals("Stadt")) {
            for (Unterkunft unterkunft : returnUnterkuenfte) {
                if (!unterkunft.getStadt().equals(chosenStadtKategorie)) {
                    helpUnterkunftList.remove(unterkunft);
                }
            }
            returnUnterkuenfte = (ArrayList<Unterkunft>) helpUnterkunftList.clone();
        }

        if (chosenUnterkunftKategorie != null && !chosenUnterkunftKategorie.equals("") && !chosenUnterkunftKategorie.equals("Unterkunft")) {
            for (Unterkunft unterkunft : returnUnterkuenfte) {
                if (!unterkunft.getUnterkunftForm().equals(chosenUnterkunftKategorie)) {
                    helpUnterkunftList.remove(unterkunft);
                }
            }
            returnUnterkuenfte = (ArrayList<Unterkunft>) helpUnterkunftList.clone();
        }

        int chosenBudgetKategorieParsed;

        try {
            chosenBudgetKategorieParsed = Integer.parseInt(chosenBudgetKategorie);

            for (Unterkunft unterkunft : returnUnterkuenfte) {
                if (unterkunft.getPreis() >= chosenBudgetKategorieParsed) {
                    helpUnterkunftList.remove(unterkunft);
                }
                returnUnterkuenfte = (ArrayList<Unterkunft>) helpUnterkunftList.clone();
            }
        } catch (NumberFormatException e) {
            
        }

        return returnUnterkuenfte;
    }

    public int addUnterkunft(Unterkunft newUnterkunft) {
        if (newUnterkunft == null) {
            return -1;
        }

        newUnterkunft.id = lastID + 1;
        lastID += 1;

        unterkuenfte.add(newUnterkunft);
        return newUnterkunft.id;
    }

    public Unterkunft getCopyOfUnterkunft(int id) {
        Unterkunft unterkunft = this.getRealUnterkunft(id);

        if (unterkunft == null) {
            return null;
        }
        return unterkunft.getCopyOfMe();
    }

    public boolean updateUnterkunft(int id, Unterkunft unterkunft) {
        Unterkunft dbUnterkunft = this.getRealUnterkunft(id);

        if (dbUnterkunft == null) {
            return false;
        }

        dbUnterkunft = unterkunft;

        return true;
    }

    private Unterkunft getRealUnterkunft(int id) {
        for (Unterkunft unterkunft : unterkuenfte) {
            if (unterkunft.id == id) {
                return unterkunft;
            }
        }
        return null;
    }

}
