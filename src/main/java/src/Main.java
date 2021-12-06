package src;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws IOException, SQLException {
//tworzenie tabeli
    CreateTable.execute();

//główny program
        String onceAgain;
        do{
            System.out.println("Wybierz operację, której chcesz dokonać: ");
            System.out.println("-> Poznać kurs waluty: wybierz 1");
            System.out.println("-> Wymienić zadaną kwotę: wybierz 2");
            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    ChooseCurrency.exchangeRate();
                    break;
                case 2:
                    ExchangeCurrency.chooseAmoutOfCurrency();
                    break;
                default:
                    System.out.println("Podano niewłaściwe dane");
            }

            System.out.println("Czy chcesz wykonać kolejną operację? Y/N");
            Scanner scan = new Scanner(System.in);
            onceAgain = scan.next();
            
        } while (onceAgain.equalsIgnoreCase("Y"));
        System.out.println("Dziękujemy za skorzystanie z naszego kantora");
    }
}


