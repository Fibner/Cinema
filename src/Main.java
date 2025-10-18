import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try{
            ObjectInputStream we = new ObjectInputStream(new FileInputStream(".\\klienci.dat"));
        }catch (Exception e){}
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w Systemie obsługi kina.");
        System.out.println("Wybierz co chcesz zrobić:");
        //Tu będie wypisana lista seansów
        System.out.println("1 - Przeglądaj seanse");
        System.out.println("2 - Wyświetl listę klientów (Admin)");
        int answear = Integer.parseInt(scanner.nextLine());
    }
}