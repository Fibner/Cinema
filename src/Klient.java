//Klasa Klient (nazwisko, imię, mail, telefon, seans, miejsce/miejsca - kolekcja)

public class Klient {
    String nazwisko;
    String imie;
    String email;
    Integer telefon;
    String seans;
    Integer zarezerwowane_miejsce;

}





public class Pracownik implements Serializable {
    private static final long serialVersionUID = -7887612267521882048L;
    String imie;
    String nazwisko;
    String email;

    public Pracownik(String imie, String nazwisko, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pracownik [imie=" + imie + ", nazwisko=" + nazwisko
                + ", email=" + email + "]";
    }

}