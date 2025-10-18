import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w Systemie obsługi kina.");
        System.out.println("Dostępne seanse:");
        //Tu będie wypisana lista seansów
        System.out.println("Wybierz seans na który chcesz iść: ");
        int answear = Integer.parseInt(scanner.nextLine());
    }
}