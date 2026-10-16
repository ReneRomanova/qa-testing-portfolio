import org.help.FirstFunction;
import org.help.Function;
import org.junit.jupiter.api.Test;

import java.io.*;

public class IntegrationTest {
    double eps = 0.001;

    @Test
    public void testAll() {
        String csvFile = "src/main/resources/all.csv";
        String line;
        String cvsSplitBy = ",";

        String outputFile = "src/main/resources/results.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Input Value, Expected Result, Actual Result\n");
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(cvsSplitBy);
                    double x = Double.parseDouble(values[0]);
                    double expected = FirstFunction.calculate(x, 0.001);
                    double actual = Function.startFunction(x);

                    bw.write(String.format("%.1f,   %.3f, %.3f%n", x, expected, actual));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSin() {
        String csvFile = "src/main/resources/sin.csv";
        String line;
        String cvsSplitBy = ",";

        String outputFile = "src/main/resources/results_sin.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Input Value, Expected Result, Actual Result\n");
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(cvsSplitBy);
                    double x = Double.parseDouble(values[0]);
                    double expected = Math.sin(x);
                    double actual = FirstFunction.sin(x, eps);

                    bw.write(String.format("%.1f,   %.3f, %.3f%n", x, expected, actual));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCos() {
        String csvFile = "src/main/resources/cos.csv";
        String line;
        String cvsSplitBy = ",";

        String outputFile = "src/main/resources/results_cos.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Input Value, Expected Result, Actual Result\n");
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(cvsSplitBy);
                    double x = Double.parseDouble(values[0]);
                    double expected = Math.cos(x);
                    double actual = FirstFunction.cos(x, eps);

                    bw.write(String.format("%.1f,   %.3f, %.3f%n", x, expected, actual));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTan() {
        String csvFile = "src/main/resources/tan.csv";
        String line;
        String cvsSplitBy = ",";

        String outputFile = "src/main/resources/results_tan.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Input Value, Expected Result, Actual Result\n");
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(cvsSplitBy);
                    double x = Double.parseDouble(values[0]);
                    double expected = Math.tan(x);
                    double actual = FirstFunction.tan(x, eps);

                    bw.write(String.format("%.1f,   %.3f, %.3f%n", x, expected, actual));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCot() {
        String csvFile = "src/main/resources/cot.csv";
        String line;
        String cvsSplitBy = ",";

        String outputFile = "src/main/resources/results_cot.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Input Value, Expected Result, Actual Result\n");
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(cvsSplitBy);
                    double x = Double.parseDouble(values[0]);
                    double expected = 1 / Math.tan(x);
                    double actual = FirstFunction.cot(x, eps);

                    bw.write(String.format("%.1f,   %.3f, %.3f%n", x, expected, actual));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCsc() {
        String csvFile = "src/main/resources/csc.csv";
        String line;
        String cvsSplitBy = ",";

        String outputFile = "src/main/resources/results_csc.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Input Value, Expected Result, Actual Result\n");
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(cvsSplitBy);
                    double x = Double.parseDouble(values[0]);
                    double expected = 1 / Math.sin(x);
                    double actual = FirstFunction.csc(x, eps);

                    bw.write(String.format("%.1f,   %.3f, %.3f%n", x, expected, actual));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSec() {
        String csvFile = "src/main/resources/sec.csv";
        String line;
        String cvsSplitBy = ",";

        String outputFile = "src/main/resources/results_sec.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Input Value, Expected Result, Actual Result\n");
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(cvsSplitBy);
                    double x = Double.parseDouble(values[0]);
                    double expected = 1 / Math.cos(x);
                    double actual = FirstFunction.sec(x, eps);

                    bw.write(String.format("%.1f,   %.3f, %.3f%n", x, expected, actual));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
