package src;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.Scanner;

public class ExchangeCurrency {

    //przeliczanie zadanej ilości waluty
    public static void chooseAmoutOfCurrency() throws IOException {
        System.out.println("Wybierz walutę, której przeliczenia chcesz dokonać:");
        int number = ChooseCurrency.chooseCurrency();
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

//zmienna zapisująca kurs średni wybranej waluty
        double choosenCurrency = currencyValue.getRates().get(0).getMid();
//ściągnięcie stream readerem nazwy wybranej waluty
        String name = currencyValue.getCode();

//zadawanie ilości waluty do wymiany
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilość waluty jaką chcesz wymienić: ");
        int exchangeAmount = scanner.nextInt();

//wymiana wybranej ilości podanej waluty w przeliczeniu na różne inne z zaokrągleniem kursu do 4 miejsc po przecinku
        String[] isoCodes = {"usd", "thb", "eur", "chf", "huf", "gbp", "jpy", "czk", "nok", "ils"};
        System.out.println("Kwotę w wysokości " + exchangeAmount + " " + name + " możesz wymienić na: ");
        for (String insideCode : isoCodes) {
            URL urlIso = new URL("http://api.nbp.pl/api/exchangerates/rates/a/" + insideCode);
            InputStreamReader readerIso = new InputStreamReader(urlIso.openStream());
            CurrencyValue currencyValueIso = new Gson().fromJson(readerIso, CurrencyValue.class);
            double isoCurrency = currencyValueIso.getRates().get(0).getMid();
            String isoName = currencyValueIso.getCode();

            double exchangedAmount = ((choosenCurrency * exchangeAmount) / isoCurrency);
            exchangedAmount = new BigDecimal(exchangedAmount).setScale(4, RoundingMode.HALF_UP).doubleValue();
            System.out.println(exchangedAmount + " " + isoName);

        }

    }


}
