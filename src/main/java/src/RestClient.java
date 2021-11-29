package src;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/chf/");

        InputStreamReader reader = new InputStreamReader(url.openStream());

        CurrencyValue currencyValue = new Gson().fromJson(reader, CurrencyValue.class);

        System.out.println(currencyValue.getRates().get(0).getMid());


    }

}
