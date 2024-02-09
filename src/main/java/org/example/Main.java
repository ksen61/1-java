package org.example;//это объявление пакета для организации и структурирования кода и также чтобы предотвратить конфликты имен между классами
import java.util.Scanner; // это оператор импорта для считываания ввода с клавиатуры

public class Main { //объявление класса Main
    public static final double EARTH_RADIUS_KM = 6371.0; // объявление EARTH_RADIUS_KM, которая хранит радиус Земли в километрах

    public static void main(String[] args) { // объявление метода main, которая запускает программу
        Scanner input = new Scanner(System.in); // создаем объект Scanner для считывания ввода с клавиатуры

        System.out.println("Введите первую широту и долготу:"); // выводиться сообщение пользователю с просьбой ввести первую широту и долготу
        double latitude1 = Math.toRadians(input.nextDouble());// считывается значение широты, происходит преобразование его в радианы и сохраняется
        // в переменной
        double longitude1 = Math.toRadians(input.nextDouble());// считывается значение долготы, происходит преобразование его в радианы и сохраняется
        // в переменной

        System.out.println("Введите вторую широту и долготу:");// выводиться сообщение пользователю с просьбой ввести вторую широту и долготу
        double latitude2 = Math.toRadians(input.nextDouble());// считывается значение широты, происходит преобразование его в радианы и сохраняется
        // в переменной
        double longitude2 = Math.toRadians(input.nextDouble());// считывается значение долготы, происходит преобразование его в радианы и сохраняется
        // в переменной

        double distance = Distance(latitude1, longitude1, latitude2, longitude2);// вычисляем расстояние между двумя точками и сохранить
        // результаты в переменную
        System.out.println("Расстояние между двумя точками составляет: " + distance + " километров");// вывод рассчитанного расстояния между двумя
        // точками в километрах
    }

    public static double Distance(double latitude1, double longitude1, double latitude2, double longitude2) { //объявление метода Distance,
        // который принимает широту и долготу двух точек и вохвращает расстояние между ними
        double result1 = latitude2 - latitude1;// разница между широтами точек сохраняется в переменной
        double result2 = longitude2 - longitude1;// разница между долготами точек сохраняется в переменной

        double a = Math.pow(Math.sin(result1 / 2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(result2 / 2), 2);// вычисляем
        // промежуточное значение для формулы гаверсинуса, в которая используется для расчета расстояния между двумя точками на Земле
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));// вычисляем угол для формулы гаверсинуса

        return EARTH_RADIUS_KM * c;// возвращаем рассчитанное расстояние в километрах
    }
}