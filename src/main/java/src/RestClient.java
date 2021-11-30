package src;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;


public class RestClient {

    public static void main(String[] args) throws IOException {

        exchangeRate();


    }

//Wybieranie waluty do przeliczenia
    public static int chooseCurrency() {
        System.out.println("Wybierz walutę, której aktualny kurs chcesz poznać:");
        System.out.println("1. BAT (THB)\n2. EURO (EUR)\n3. FRANK SZWAJCARSKI (CHF)\n4. FORINT (HUF)\n5. FUNT SZTERLING (GBP)\n6. JEN (JPY)\n7. KORONA CZESKA (CZK)\n8. KORONA NORWESKA (NOK)\n9. NOWY IZRAELSKI SZEKIEL (ILS)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadź numer waluty: ");
        int number = scanner.nextInt();
        return number;

    }


//Metody prowadzące do podania kursu wybranej waluty
    public static void exchangeRate() throws IOException {
        int number = chooseCurrency();
        String properCurrency = " ";
        switch (number) {
            case 1:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/thb/";
                break;
            case 2:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/eur";
                break;
            case 3:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/chf/";
                break;
            case 4:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/huf/";
                break;
            case 5:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/";
                break;
            case 6:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/jpy/";
                break;
            case 7:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/czk/";
                break;
            case 8:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/nok/";
                break;
            case 9:
                properCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/ils/";
                break;
            default:
                System.out.println("nie wybrano żadnej waluty");
        }


        URL url = new URL(properCurrency);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        CurrencyValue currencyValue = new Gson().fromJson(reader, CurrencyValue.class);
        //System.out.println(currencyValue.getRates().get(0).getMid());
//zmienna zapisująca kurs średni wybranej waluty
        double choosenCurrency = currencyValue.getRates().get(0).getMid();
//ściągnięcie stream readerem nazwy wybranej waluty
        String name = currencyValue.getCode();


        String[] isoCodes = {"usd", "thb", "eur", "chf", "huf", "gbp", "jpy", "czk", "nok", "ils"};
        for (int i = 0; i < isoCodes.length; i++) {
            String insideCode = isoCodes[i];
            URL urlIso = new URL("http://api.nbp.pl/api/exchangerates/rates/a/" + insideCode);
            InputStreamReader readerIso = new InputStreamReader(urlIso.openStream());
            CurrencyValue currencyValueIso = new Gson().fromJson(readerIso, CurrencyValue.class);
            double isoCurrency = currencyValueIso.getRates().get(0).getMid();
            String isoName = currencyValueIso.getCode();

            System.out.println("Kurs " + name + " wynosi: " + (choosenCurrency / isoCurrency) + " " + isoName);
        }


    }
}


