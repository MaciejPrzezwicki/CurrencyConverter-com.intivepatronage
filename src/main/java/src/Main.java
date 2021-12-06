package src;

import java.util.Scanner;




public class Main {

    public static void main(String[] args) {
//tworzenie tabeli
    CreateTable.execute();

//główny program
        String onceAgain;
        do{
//try-catch'owanie wprowadzenia char'a lub String'a do scannera oczekującego Integera
            try{
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
                if ((onceAgain.compareToIgnoreCase("y") != 0) && (onceAgain.compareToIgnoreCase("n") != 0)){
                    System.out.println("Podaj literę 'Y' lub 'N', w przeciwnym razie program zostanie zakończony");
                    onceAgain = scan.next();
                }


            } catch (Exception e) {
                System.out.println("Podano niewłaściwe dane");
                System.out.println("Czy chcesz wykonać kolejną operację? Y/N");
                Scanner scan = new Scanner(System.in);
                onceAgain = scan.next();
                if ((onceAgain.compareToIgnoreCase("y") != 0) && (onceAgain.compareToIgnoreCase("n") != 0)){
                    System.out.println("Podaj literę 'Y' lub 'N', w przeciwnym razie program zostanie zakończony");
                    onceAgain = scan.next();
                }

            }

            
        } while (onceAgain.equalsIgnoreCase("Y"));
        System.out.println("Dziękujemy za skorzystanie z naszego kantora");
    }
}


