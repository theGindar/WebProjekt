
import java.util.ArrayList;

public class ArrayListDatabaseManager {

    private static ArrayList<Unterkunft> unterkuenfte = new ArrayList<>();
    private static int lastID = -1;
    private static boolean unterkuenfteLoaded = false;

    public ArrayListDatabaseManager() {
        if (!unterkuenfteLoaded) {
            addUnterkunft(new Unterkunft("Vollpension", 40,
                    "Viele umweltfreundliche Details und ein Fahrradverleih in der Unterkunft erwarten Sie in diesem Hotel in Berlin. Das Landmark Eco Hotel befindet sich nur 5 Gehminuten von der beliebten Einkaufsmeile Kurfürstendamm entfernt. WLAN nutzen Sie kostenfrei. Alle komfortablen energieeffizienten Zimmer im Hotel verfügen über ausgewählte Bettwäsche, Kabel-TV und ein eigenes Bad mit einem Haartrockner. Die umweltfreundliche Sanierung des Landmark Eco Hotel wurde im Jahr 2014 fertiggestellt.", 4, "Landmark Eco Hotel", "Berlin", "Hotel"));
            addUnterkunft(new Unterkunft("Vollpension", 45, "Das Hotel befindet sich direkt neben der East Side Gallery im angesagten Berliner Bezirk Friedrichshain. Das im August 2018 neu eröffnete Hotel bietet kostenfreies WLAN und einen Biergarten direkt an der Mauer.", 3, "Schulz Hotel Berlin Wall", "Berlin", "Hotel"));
            addUnterkunft(new Unterkunft("Halbpension", 20, "Dieses Hotel befindet sich nur 200 m vom Aachener Dom entfernt und bietet geräumige Zimmer, ein tägliches Frühstücksbuffet und eine Tiefgarage. Die Bar und die Rezeption sind rund um die Uhr geöffnet.", 4, "Aquis Grana City Hotel", "Aachen", "Jugendherberge"));
            addUnterkunft(new Unterkunft("Vollpension", 65, "Dieses 4-Sterne-Hotel erwartet Sie mit einem Restaurant und kostenfreiem WLAN in allen Bereichen im Zentrum von Dessau, jeweils 10 Gehminuten vom Bahnhof, dem Rathaus und der Elbe entfernt.", 5, " NH Dessau", "Dessau", "Hostel"));

            unterkuenfteLoaded = true;
        }
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
