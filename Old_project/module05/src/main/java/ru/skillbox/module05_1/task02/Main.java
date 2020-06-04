package ru.skillbox.module05_1.task02;

public class Main {
    public static void main(String[] args) {
        float[] patients = new float[30];

        for (int i = 0; i < patients.length; i++) {
            patients[i] = 32 + roundFloat((float)((8 * Math.random())), 1);
            System.out.print(patients[i] + "  ");
        }

        System.out.println();
        System.out.println("Средняя температура по больнице - " + averageTemperature(patients));
        System.out.println("Количество здоровых пациентов - " + countHealthy(patients));
    }

    /**
     * Округление числа float после запятой до нужного количества знаков.
     * @param d Число коорое нужно округлить.
     * @param precise Количество знаков после запятой.
     * @return Получаем округленное число float.
     */
    public static float roundFloat(float d, int precise) {
        int accurate = (int) Math.pow(10, precise);
        d = d * accurate;
        int i = (int) d;
        return (float) i/accurate;
    }

    /**
     * Вычисление средней температуры по больнице.
     * @param patients
     * @return
     */
    public static float averageTemperature(float[] patients) {
        float averageTemperature = 0;
        for (float temperature : patients) {
            averageTemperature += roundFloat(temperature, 1);
        }
        return roundFloat(averageTemperature / patients.length, 1);
    }

    /**
     * Подсчет количества здоровых пациентов.
     * @param patients
     * @return
     */
    public static int countHealthy(float[] patients) {
        int countHealthy = 0;
        for (float temperature : patients) {
            if (temperature >= 36.2 && temperature <= 36.9) countHealthy++;
        }
        return countHealthy;
    }
}
