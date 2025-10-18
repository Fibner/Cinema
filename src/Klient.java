//Klasa Klient (nazwisko, imię, mail, telefon, seans, miejsce/miejsca - kolekcja)
import java.io.Serializable;
public class Klient implements Serializable {
    String nazwisko;
    String imie;
    String email;
    int telefon;
    String seans;
    int zarezerwowane_miejsce;


    public Klient(String nazwisko, String imie, String email, int telefon, String seans, int zarezerwowane_miejsce) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.email = email;
        this.telefon = telefon;
        this.seans = seans;
        this.zarezerwowane_miejsce = zarezerwowane_miejsce;
    }

    @Override
    public String toString() {
        return "Klient [nazwisko=" + nazwisko + ", imie=" + imie + ", email=" + email + ", telefon=" + telefon + ", seans=" + seans + ", zarezerwowane_miejsce=" + zarezerwowane_miejsce + "]";
    }
}

