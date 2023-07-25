package uned;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class CurrencyConverterTests {

    @Test
    public void ARG() {
        int a = 10;
        int b = 4;
        double c;
        c = a / b;
        Assertions.assertEquals(2, c);
    }

    @Test
    public void convertEURtoUSD() {
        CurrencyExchangeRateApi api = createMockedApi();
        CurrencyConverter converter = new CurrencyConverter(api);
        double result = converter.convert(5, "EUR", "USD");
        Assertions.assertEquals(2.5, result);
    }

    private static CurrencyExchangeRateApi createMockedApi() {
        CurrencyExchangeRateApi api =
                Mockito.mock(CurrencyExchangeRateApi.class);
        BDDMockito
                .given(api.getRate(Mockito.anyString(), Mockito.anyString()))
                .willReturn(0.5);
        return api;
    }
}
