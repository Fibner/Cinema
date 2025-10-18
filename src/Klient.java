//Klasa Klient (nazwisko, imię, mail, telefon, seans, miejsce/miejsca - kolekcja)

public class Klient {
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
}

