import org.help.FirstFunction;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;

public class FirstTest {

    private static final double EPSILON = 1e-10;
    @Test
    public void testSin_() {
        assertEquals(0.0, FirstFunction.sin(0, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.sin(Math.PI / 2, EPSILON), EPSILON);
        assertEquals(0.0, FirstFunction.sin(Math.PI, EPSILON), EPSILON);
        assertEquals(-1.0, FirstFunction.sin(3 * Math.PI / 2, EPSILON), EPSILON);
        assertEquals(0.0, FirstFunction.sin(2 * Math.PI, EPSILON), EPSILON);

        assertEquals(Math.sin(1), FirstFunction.sin(1, EPSILON), EPSILON);
        assertEquals(Math.sin(-1), FirstFunction.sin(-1, EPSILON), EPSILON);
    }

    @Test
    public void testCos_() {
        assertEquals(1.0, FirstFunction.cos(0, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.cos(Math.PI / 2, EPSILON), EPSILON);
        assertEquals(-1.0, FirstFunction.cos(Math.PI, EPSILON), EPSILON);
        assertEquals(1.0, FirstFunction.cos(2 * Math.PI, EPSILON), EPSILON);

        assertEquals(Math.cos(1), FirstFunction.cos(1, EPSILON), EPSILON);
        assertEquals(Math.cos(-1), FirstFunction.cos(-1, EPSILON), EPSILON);
    }

    @Test
    public void testSec_() {
        assertEquals(1.0, FirstFunction.sec(0, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.sec(Math.PI / 2, EPSILON), EPSILON); // Так как cos(π/2) = 0
        assertEquals(-1.0, FirstFunction.sec(Math.PI, EPSILON), EPSILON);
        assertEquals(1.0, FirstFunction.sec(2 * Math.PI, EPSILON), EPSILON);

        assertEquals(1 / Math.cos(1), FirstFunction.sec(1, EPSILON), EPSILON);
        assertEquals(1 / Math.cos(-1), FirstFunction.sec(-1, EPSILON), EPSILON);
    }

    @Test
    public void testCsc_() {
        assertEquals(Double.NaN, FirstFunction.csc(0, EPSILON), EPSILON); // Так как sin(0) = 0
        assertEquals(Double.NaN, FirstFunction.csc(Math.PI / 2, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.csc(Math.PI, EPSILON), EPSILON); // Так как sin(π) = 0
        assertEquals(-1.0, FirstFunction.csc(3 * Math.PI / 2, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.csc(2 * Math.PI, EPSILON), EPSILON); // Так как sin(2π) = 0

        assertEquals(1 / Math.sin(1), FirstFunction.csc(1, EPSILON), EPSILON);
        assertEquals(1 / Math.sin(-1), FirstFunction.csc(-1, EPSILON), EPSILON);
    }

    @Test
    public void testTan_() {
        assertEquals(0.0, FirstFunction.tan(0, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.tan(Math.PI / 2, EPSILON), EPSILON); // Так как cos(π/2) = 0
        assertEquals(0.0, FirstFunction.tan(Math.PI, EPSILON), EPSILON);
        assertEquals(0.0, FirstFunction.tan(2 * Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testCot_() {
        assertEquals(Double.NaN, FirstFunction.cot(0, EPSILON), EPSILON); // Так как sin(0) = 0
        assertEquals(Double.NaN, FirstFunction.cot(Math.PI / 2, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.cot(Math.PI, EPSILON), EPSILON); // Так как sin(π) = 0
        assertEquals(0.0, FirstFunction.cot(3 * Math.PI / 2, EPSILON), EPSILON);
        assertEquals(Double.NaN, FirstFunction.cot(2 * Math.PI, EPSILON), EPSILON); // Так как sin(2π) = 0
    }

    @Test
    public void testSin() {
        double x = Math.PI / 6; // 30 градусов
        double eps = 0.001;

        FirstFunction firstFunction = Mockito.spy(new FirstFunction());

        double expectedValue = 0.5;
        doReturn(expectedValue).when(firstFunction).sin(eq(x), eq(eps));
        double expected = expectedValue;
        double actual = firstFunction.sin(x, eps);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCos() {
        double x = Math.PI / 3; // 60 degrees
        double eps = 0.001;

        // Создание заглушки для cos
        FirstFunction firstFunction = Mockito.spy(new FirstFunction());
        doReturn(0.5).when(firstFunction).cos(eq(x), eq(eps));

        double expected = 0.5;
        double actual = firstFunction.cos(x, eps);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSec() {
        double x = Math.PI / 4; // 45 degrees
        double eps = 0.001;

        // Создание заглушки для sec
        FirstFunction firstFunction = Mockito.spy(new FirstFunction());
        doReturn(1.4142).when(firstFunction).sec(eq(x), eq(eps));

        double expected = 1.4142;
        double actual = firstFunction.sec(x, eps);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCsc() {
        double x = Math.PI / 6; // 30 degrees
        double eps = 0.001;

        FirstFunction firstFunction = Mockito.spy(new FirstFunction());
        doReturn(2.0).when(firstFunction).csc(eq(x), eq(eps));

        double expected = 2.0;
        double actual = firstFunction.csc(x, eps);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testTan() {
        double x = Math.PI / 4; // 45 degrees
        double eps = 0.001;

        FirstFunction firstFunction = Mockito.spy(new FirstFunction());
        doReturn(1.0).when(firstFunction).tan(eq(x), eq(eps));

        double expected = 1.0;
        double actual = firstFunction.tan(x, eps);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCot() {
        double x = Math.PI / 4; // 45 градусов
        double eps = 0.001;

        FirstFunction firstFunction = Mockito.spy(new FirstFunction());
        double expectedValue = 1.0;
        doReturn(expectedValue).when(firstFunction).cot(eq(x), eq(eps));

        double expected = expectedValue;
        double actual = firstFunction.cot(x, eps);

        assertEquals(expected, actual, 0.001);
    }
}
