package src;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

public class ChooseCurrency {
//Wybieranie waluty do przeliczenia
    public static int chooseCurrency() {

        System.out.println("1. BAT (THB)\n2. EURO (EUR)\n3. FRANK SZWAJCARSKI (CHF)\n4. FORINT (HUF)\n5. FUNT SZTERLING (GBP)\n6. JEN (JPY)\n7. KORONA CZESKA (CZK)\n8. KORONA NORWESKA (NOK)\n9. NOWY IZRAELSKI SZEKIEL (ILS)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadź numer waluty: ");
        int number = scanner.nextInt();
        return number;

    }

    public static void exchangeRate() throws IOException, SQLException {
        System.out.println("Wybierz walutę, której aktualny kurs chcesz poznać:");
        String properCurrency = CurrencySelection.currencySelection();


        URL url = new URL(properCurrency);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        CurrencyValue currencyValue = new Gson().fromJson(reader, CurrencyValue.class);

//zmienna zapisująca kurs średni wybranej waluty
        double choosenCurrency = currencyValue.getRates().get(0).getMid();

//pobieranie kursu dolara

        String usdLink = "http://api.nbp.pl/api/exchangerates/rates/a/usd/";
        URL urlUSD = new URL(usdLink);
        InputStreamReader readerUSD = new InputStreamReader(urlUSD.openStream());
        CurrencyValue currencyValueUSD = new Gson().fromJson(readerUSD, CurrencyValue.class);
        double usdRates = currencyValueUSD.getRates().get(0).getMid();
        double endRateUSD = choosenCurrency / usdRates;
//ściągnięcie stream readerem nazwy wybranej waluty
        String name = currencyValue.getCode();
//dodawanie do bazy danych kursu wybranej waluty w przeliczeniu na USD
        ClientDB.addToDB(name, endRateUSD);
        System.out.println("kurs " + name + " wynosi: ");



//podawanie kursu wybranej waluty w przeliczeniu na różne inne z zaokrągleniem kursu do 4 miejsc po przecinku

        String[] isoCodes = {"thb", "eur", "chf", "huf", "gbp", "jpy", "czk", "nok", "ils"};
        for (String insideCode : isoCodes) {
            URL urlIso = new URL("http://api.nbp.pl/api/exchangerates/rates/a/" + insideCode);
            InputStreamReader readerIso = new InputStreamReader(urlIso.openStream());
            CurrencyValue currencyValueIso = new Gson().fromJson(readerIso, CurrencyValue.class);
            double isoCurrency = currencyValueIso.getRates().get(0).getMid();
            String isoName = currencyValueIso.getCode();

            double endRate = (choosenCurrency / isoCurrency);
            endRate = new BigDecimal(endRate).setScale(4, RoundingMode.HALF_UP).doubleValue();
            System.out.println(endRate + " " + isoName);


        }



    }
}
