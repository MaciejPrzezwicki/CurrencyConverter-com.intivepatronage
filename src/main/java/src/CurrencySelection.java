package src;

import static src.ChooseCurrency.chooseCurrency;

public class CurrencySelection {
    public static String currencySelection() {

        String properCurrency = " ";

        int number = chooseCurrency();
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

            }

            return properCurrency;
        }
}







