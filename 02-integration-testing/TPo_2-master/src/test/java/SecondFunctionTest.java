import org.help.FirstFunction;
import org.help.Function;
import org.help.SecondFunction;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SecondFunctionTest {
    // Тест для положительного значения ln
    @Test
    public void testLn_PositiveValue() {
        assertEquals(SecondFunction.ln(2.0, 0.001), Math.log(2.0), 0.001);
    }

    // Тест для нулевого значения ln
    @Test
    public void testLn_ZeroValue() {
        assertEquals(SecondFunction.ln(0.0, 0.001), Double.NEGATIVE_INFINITY, 0.001);
    }

    // Тест для значения NaN в ln
    @Test
    public void testLn_NaNValue() {
        assertEquals(SecondFunction.ln(Double.NaN, 0.001), Double.NaN, 0.001);
    }

    // Тест для значения бесконечности в ln
    @Test
    public void testLn_InfinityValue() {
        assertEquals(SecondFunction.ln(Double.POSITIVE_INFINITY, 0.001), Double.POSITIVE_INFINITY, 0.001);
    }

    // Тест для log с правильным вычислением
    @Test
    public void testLog_CorrectCalculation() {
        assertEquals(2.0, SecondFunction.log(10, 100.0, 0.001), 0.01);
    }

    // Тест проверки вывода в файл log
    @Test
    public void testLogOutput_FileWriting() {
        SecondFunction secondFunction = new SecondFunction();
        double expectedValue = Math.log(100.0) / Math.log(10);
        double result = secondFunction.Log(10, 100.0);
        assertEquals(expectedValue, result, 0.01);
    }

    // Тест проверки вывода в файл ln
    @Test
    public void testLnOutput_FileWriting() {
        SecondFunction secondFunction = new SecondFunction();
        double x = 100.0;
        double expectedValue = Math.log(x);
        double result = secondFunction.Ln(x);
        assertEquals(expectedValue, result, 0.1);
    }

    // Тест c использованием mockito
    @Test
    public void testLog() {
        double x = 10.0;
        int n = 2;
        double eps = 0.0001;

        // Создание заглушки для ln
        SecondFunction secondFunction = Mockito.spy(new SecondFunction());
        // Ожидаемый результат ln(10)
        double ln10 = Math.log(10.0);
        doReturn(ln10).when(secondFunction).ln(anyDouble(), anyDouble());

        double expected = Math.log(x) / Math.log(n);
        double actual = SecondFunction.log(n, x, eps);

        assertEquals(expected, actual, 0.001);
    }
}
