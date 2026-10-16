package org.help;

import java.io.FileWriter;
import java.io.IOException;

public class Function {

//    x <= 0 : (((((sec(x) ^ 2) / (sin(x) * cos(x))) - tan(x)) ^ 2) / (csc(x) + (cot(x) * csc(x))))
//    x > 0 : (((((log_10(x) * log_3(x)) + log_3(x)) / (ln(x) + log_10(x))) / log_2(x)) * ((log_5(x) / log_2(x)) - (ln(x) - log_10(x))))

    public static double System(double x){
        double eps = 0.001;
        if (x <= 0) return Math.pow(Math.pow(FirstFunction.sec(x, eps),2) / (FirstFunction.sin(x, eps) * FirstFunction.cos(x, eps) -
                FirstFunction.tan(x, eps))/ (FirstFunction.csc(x, eps) + (FirstFunction.cot(x, eps)* FirstFunction.csc(x, eps))),2);
        else return (((((SecondFunction.log(10, x, eps) * SecondFunction.log(3, x, eps)) +
                SecondFunction.log(3, x, eps)) / (SecondFunction.ln(x, eps) + SecondFunction.log(10, x, eps))) /
                SecondFunction.log(2, x, eps)) * ((SecondFunction.log(5, x, eps) / SecondFunction.log(2, x, eps)) -
                (SecondFunction.ln(x, eps) - SecondFunction.log(10, x, eps))));
    }

    public static double startFunction(double x){
        double result = System(x);
        try (FileWriter fileWriter = new FileWriter("src/test/java/output_sys_function.csv")) {
            fileWriter.append(String.valueOf(x)).append(",").append(String.valueOf(result)).append("\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
        return result;
    }
}
