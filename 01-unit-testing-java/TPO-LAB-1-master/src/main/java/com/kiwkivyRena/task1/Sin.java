package com.kiwkivyRena.task1;

public class Sin {

    // https://function-x.ru/chapter9-4/rows4_clip_image063.gif

    public static double calc(double x, int n){
        double PI2 = Math.PI * 2;

        if (x >= 0) {
            while (x > PI2) {
                x -= PI2;
            }
        } else if (x < 0){
            while (x < PI2) {
                x += PI2;
            }
        }

        double result = 1;   // Начальное значение для sec(x)
        double xx = x * x;   // x^2
        double fact = 1;     // Факториал
        int sign = 1;        // Смена знака при добавлении слагаемых

        for (int i = 2; i < n; i += 2){
            fact *= i * (i - 1); // Факториал для знаменателя
            result += sign * Math.pow(x, i) / fact;  // Добавление очередного слагаемого
            sign = -sign;
        }

        return result;
    }
}

//
//public class Sec {
//
//    public static double calc(double x, int n){
//        double PI2 = Math.PI * 2;
//
//        if (x >= 0) {
//            while (x > PI2) {
//                x -= PI2;
//            }
//        } else if (x < 0){
//            while (x < PI2) {
//                x += PI2;
//            }
//        }
//
//        double result = 1;   // Начальное значение для sec(x)
//        double xx = x * x;   // x^2
//        double fact = 1;     // Факториал
//        int sign = 1;        // Смена знака при добавлении слагаемых
//
//        for (int i = 2; i < n; i += 2){
//            fact *= i * (i - 1); // Факториал для знаменателя
//            result += sign * Math.pow(x, i) / fact;  // Добавление очередного слагаемого
//            sign = -sign;
//        }
//
//        return result;
//    }
//}
//
