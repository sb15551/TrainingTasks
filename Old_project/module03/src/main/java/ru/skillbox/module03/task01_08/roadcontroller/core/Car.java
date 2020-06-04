package ru.skillbox.module03.task01_08.roadcontroller.core;

public class Car
{
    private String number;
    private int height;
    private double weight;
    private boolean hasVehicle;
    private boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    /**
     * Getter variable number.
     * @return String number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter variable number.
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter variable height.
     * @return int height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter variableheight.
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Getter variable weight.
     * @return double weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setter variable weight.
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Getter variable hasVehicle.
     * @return boolean hasVehicle.
     */
    public boolean isHasVehicle() {
        return hasVehicle;
    }

    /**
     * Setter variable hasVehicle.
     * @param hasVehicle
     */
    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    /**
     * Getter variable isSpecial.
     * @return boolean isSpecial.
     */
    public boolean isSpecial() {
        return isSpecial;
    }

    /**
     * Setter variable isSpecial.
     * @param isSpecial
     */
    public void setSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }
}