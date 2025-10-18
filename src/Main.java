import com.sun.tools.jconsole.JConsoleContext;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            ArrayList<Seans> seanse = wczytajSeanse();
            ArrayList<Klient> klienci = wczytajKlientow();

            Scanner scanner = new Scanner(System.in);
            System.out.println("------------------------------");
            System.out.println("Witaj w Systemie obsługi kina.");
            System.out.println("Wybierz co chcesz zrobić:");
            System.out.println("1 - Przeglądaj seanse i zarezerwuj");
            System.out.println("2 - Wyświetl listę klientów (Admin)");
            System.out.println("3 - Utwórz seans (Admin)");
            System.out.println("0 - Wyjście z programu");

            int answear = Integer.parseInt(scanner.nextLine());
            switch (answear) {
                case 1:
                    wyswietlSeanse(seanse);
                    System.out.print("Wybierz seans do zarezerwowania: ");
                    int idSeansu = scanner.nextInt();
                    rezerwujSeans(seanse.get(idSeansu), klienci);
                    zapiszKlientow(klienci);
                    zapiszSeanse(seanse);
                    break;
                case 2:
                    wyswietlKlientow(klienci);
                    break;
                case 3:
                    utworzSeans(seanse);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    private static void wyswietlSeanse(ArrayList<Seans> seanse) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < seanse.size(); i++) {
            System.out.println(i+ ". " + seanse.get(i).toString());
        }
    }
    private static void rezerwujSeans(Seans wybranySeans, ArrayList<Klient> klienci) {
        Scanner scanner = new Scanner(System.in);
        String nazwisko = "";
        String imie = "";
        String email = "";
        int telefon = 0;
        Seans seans = wybranySeans;
        String zarezerwowane_miejsce = "";

        System.out.print("Podaj Nazwisko: ");
        nazwisko = scanner.nextLine();
        System.out.print("Podaj Imie: ");
        imie = scanner.nextLine();
        System.out.print("Podaj Email: ");
        email = scanner.nextLine();
        System.out.print("Podaj Telefon: ");
        telefon = Integer.parseInt(scanner.nextLine());
        System.out.print("Podaj miejsce do zarezerowania: ");
        zarezerwowane_miejsce = scanner.nextLine();
        char zarezerwowane_miejsceChar = zarezerwowane_miejsce.charAt(0);
        int zarezerwowane_miejsceInt = Character.getNumericValue(zarezerwowane_miejsce.charAt(1));
        if(!wybranySeans.czyWolneMiejsce(zarezerwowane_miejsceChar, zarezerwowane_miejsceInt)) {
            wybranySeans.zarezerwujMiejsce(zarezerwowane_miejsceChar, zarezerwowane_miejsceInt);
        }
        Klient klient = new Klient(nazwisko, imie, email, telefon, seans, zarezerwowane_miejsce);
        klienci.add(klient);
    }
    private static void wyswietlKlientow(ArrayList<Klient> klienci){
        for (int i = 0; i < klienci.size(); i++) {
            System.out.println(klienci.get(i).toString());
        }
    }
    private static void utworzSeans(ArrayList<Seans> seanse){
        Scanner scanner = new Scanner(System.in);
        String nazwa = "";
        LocalDate data = LocalDate.now();
        LocalTime godzina = LocalTime.now();
        int ograniczeniaWiekowe = 0;
        Character ostatniRzad = 'A';
        Integer miejscaWRzedzie = 0;

        System.out.print("Podaj nazwe seansu: ");
        nazwa = scanner.nextLine();
        System.out.print("Podaj date seansu (RRRR-MM-DD): ");
        data = LocalDate.parse(scanner.nextLine());
        System.out.print("Podaj godzine seansu (HH:MM): ");
        godzina = LocalTime.parse(scanner.nextLine());
        System.out.print("Podaj ograniczenie wiekowe filmu: ");
        ograniczeniaWiekowe = Integer.parseInt(scanner.nextLine());
        System.out.print("Jaki jest ostatni rzad w sali, w której odbędzie się seans? (A-Z): ");
        ostatniRzad = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Ile jest miejsc w rzędzie w sali?: ");
        miejscaWRzedzie = Integer.parseInt(scanner.nextLine());
        Seans seans = new Seans(nazwa, data, godzina, ograniczeniaWiekowe, ostatniRzad, miejscaWRzedzie);
        seanse.add(seans);
        zapiszSeanse(seanse);
    }

    private static ArrayList<Seans> wczytajSeanse() {
        ArrayList<Seans> seanse = new ArrayList<>();
        try{
            ObjectInputStream we = new ObjectInputStream(new FileInputStream("seanse.dat"));
            while(true) {
                try{
                    seanse.add((Seans) we.readObject());
                }catch (EOFException eof){
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie istnieje.");
        } catch(Exception e){
            System.out.println("Wystąpił błąd: " + e);
        }
        return seanse;
    }
    private static void zapiszSeanse(ArrayList<Seans> seanse) {
        try{
            ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream("seanse.dat"));
            for (int i = 0; i < seanse.size(); i++) {
                wy.writeObject(seanse.get(i));
            }
            wy.close();
        }catch(Exception e){
            System.out.println("Wystąpił błąd: " + e);
        }
    }

    private static ArrayList<Klient> wczytajKlientow() {
        ArrayList<Klient> klienci = new ArrayList<>();
        try{
            ObjectInputStream we = new ObjectInputStream(new FileInputStream("klienci.dat"));
            while(true) {
                try{
                    klienci.add((Klient) we.readObject());
                }catch (EOFException eof){
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie istnieje, zostanie utworzony przy zapisie.");
        } catch(Exception e){
            System.out.println("Wystąpił błąd: " + e);
        }
        return klienci;
    }
    private static void zapiszKlientow(ArrayList<Klient> klienci) {
        try{
            ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream("klienci.dat"));
            for (int i = 0; i < klienci.size(); i++) {
                wy.writeObject(klienci.get(i));
            }
            wy.close();
        }catch(Exception e){
            System.out.println("Wystąpił błąd: " + e);
        }
    }
}