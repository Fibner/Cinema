import java.io.Serializable;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.HashMap;

public class Seans implements Serializable {

    private String nazwa;
    private LocalDate dzien;
    private LocalTime godzina;
    private int ograniczeniaWiekowe;
    private HashMap<Character, HashMap<Integer, Boolean>> miejsca;

    public Seans(String nazwa, LocalDate dzien, LocalTime godzina, int ograniczeniaWiekowe, Character ostatniRzad, Integer miejscaWRzedzie) {
        this.nazwa = nazwa;
        this.dzien = dzien;
        this.godzina = godzina;
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
        this.miejsca = new HashMap<>();
        inicjalizujMiejsca(ostatniRzad, miejscaWRzedzie);
    }

    //inicjalizacja miejsc na sali
    private void inicjalizujMiejsca(Character ostatniRzad, Integer miejscaWRzedzie) {
        for (char r = 'A'; r <= ostatniRzad; r++) {
            HashMap<Integer, Boolean> rzadMap = new HashMap<>();
            for (int m = 1; m <= miejscaWRzedzie; m++) {
                rzadMap.put(m, false); //false = wolne miejsce
            }
            miejsca.put(r, rzadMap);
        }
    }

    //gettery i settery
    public String getNazwa() { return nazwa; }
    public LocalDate getDzien() { return dzien; }
    public LocalTime getGodzina() { return godzina; }
    public int getOgraniczeniaWiekowe() { return ograniczeniaWiekowe; }

    public boolean czyWolneMiejsce(char rzad, int nrMiejsca) {
        if (!miejsca.containsKey(rzad)) return false;
        HashMap<Integer, Boolean> rzadMap = miejsca.get(rzad);
        return rzadMap.get(nrMiejsca);
    }

    public boolean zarezerwujMiejsce(char rzad, int nrMiejsca) {
        /*
        false - nie udało się zarezerwować miejsca
        true - udało się zarezerwować miejsce
         */

        if (!miejsca.containsKey(rzad)) {
            return false;
        }
        else {
            HashMap<Integer, Boolean> rzadMap = miejsca.get(rzad);

            if (!rzadMap.containsKey(nrMiejsca) || !rzadMap.get(nrMiejsca)) {
                return false;
            }
            else {
                rzadMap.replace(nrMiejsca, true);
                miejsca.replace(rzad, rzadMap);
                return true;
            }
        }
    }

    public boolean zwolnijMiejsce(char rzad, int nrMiejsca) {
        if (!miejsca.containsKey(rzad)) {
            return false;
        }
        else {
            HashMap<Integer, Boolean> rzadMap = miejsca.get(rzad);
            rzadMap.replace(nrMiejsca, false);
            miejsca.replace(rzad, rzadMap);
            return true;
        }
    }


}
