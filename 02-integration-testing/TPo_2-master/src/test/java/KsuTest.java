import org.help.FirstFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class KsuTest {

    @ParameterizedTest
    @CsvSource({"-3.0, 1e-6", "-2.0, 1e-6", "-1.0, 1e-6", "-0.5, 1e-6", "-7.4, 1e-6"})
    void testSin(double x, double eps) {
        double expectedResult = Math.sin(x);
        double actualResult = FirstFunction.sin(x, eps);
        assertEquals(expectedResult, actualResult, eps);
    }

    @ParameterizedTest
    @CsvSource({"-3.0, 1e-6", "-2.0, 1e-6", "-1.0, 1e-6", "-0.5, 1e-6", "-7.4, 1e-6"})
    void testCos(double x, double eps) {
        double expectedResult = Math.cos(x);
        double actualResult = FirstFunction.cos(x, eps);
        assertEquals(expectedResult, actualResult, eps);
    }

    @ParameterizedTest
    @CsvSource({"-3.0, 1e-6", "-2.0, 1e-6", "-1.0, 1e-6", "-0.5, 1e-6", "-7.4, 1e-6"})
    void testSec(double x, double eps) {
        double expectedResult = 1 / Math.cos(x);
        double actualResult = FirstFunction.sec(x, eps);
        assertEquals(expectedResult, actualResult, eps);
    }

    @ParameterizedTest
    @CsvSource({"-3.0, 1e-6", "-2.0, 1e-6", "-1.0, 1e-6", "-0.5, 1e-6", "-7.4, 1e-6"})
    void testCsc(double x, double eps) {
        double expectedResult = 1 / Math.sin(x);
        double actualResult = FirstFunction.csc(x, eps);
        assertEquals(expectedResult, actualResult, eps);
    }

    @ParameterizedTest
    @CsvSource({"-3.0, 1e-6", "-2.0, 1e-6", "-1.0, 1e-6", "-0.5, 1e-6", "-7.4, 1e-6"})
    void testTan(double x, double eps) {
        double expectedResult = Math.tan(x);
        double actualResult = FirstFunction.tan(x, eps);
        assertEquals(expectedResult, actualResult, eps);
    }

    @ParameterizedTest
    @CsvSource({"-3.0, 1e-6", "-2.0, 1e-6", "-1.0, 1e-6", "-0.5, 1e-6", "-7.4, 1e-6"})
    void testCot(double x, double eps) {
        double expectedResult = 1 / Math.tan(x);
        double actualResult = FirstFunction.cot(x, eps);
        assertEquals(expectedResult, actualResult, eps);
    }

    @ParameterizedTest
    @CsvSource({"-3.0, 1e-6", "-2.0, 1e-6", "-1.0, 1e-6", "-0.5, 1e-6", "-7.4, 1e-6"})
    void testCalculate(double x, double eps) {
        double expectedResult = Math.pow(Math.pow(1/Math.cos(x), 2) / (Math.sin(x) * Math.cos(x) -
                Math.tan(x)) / (1/Math.sin(x) + (1/Math.tan(x) * 1/Math.sin(x))), 2);
        double actualResult = FirstFunction.calculate(x, eps);
        assertEquals(expectedResult, actualResult, 0.1);
    }
}
