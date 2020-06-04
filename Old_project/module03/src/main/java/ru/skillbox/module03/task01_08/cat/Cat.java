package ru.skillbox.module03.task01_08.cat;

public class Cat
{
    public static final int QUANTITY_EYES = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    private static int count = 0;

    private double originWeight;
    private double weight;
    private CatsColor color;

    private double ateFeed;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(double weight) {
        this.weight = weight;
        originWeight = weight;
        count++;
    }

    /**
     * Метод создания глубокой копии.
     * @param that
     */
    public static Cat copy(Cat that) {
        return new Cat(that.getWeight());
    }

    public void meow()
    {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            System.out.println("Cat dead or exploded");
        } else {
            weight = weight - 1;
            System.out.println("Meow");
            if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) count--;
        }
    }

    public void feed(Double amount)
    {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            System.out.println("Cat dead or exploded");
        } else {
            ateFeed += amount;
            weight = weight + amount;
            if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) count--;
        }
    }

    /**
     * Возвращает сумму съеденной еды.
     * @return ateFeed
     */
    public Double getAteFeed() {
        return ateFeed;
    }

    /**
     * Сходить в туалет.
     */
    public void pee()
    {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            System.out.println("Cat dead or exploded");
        } else {
            weight = weight - 3;
            System.out.println("Im pee pee");
            if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) count--;
        }
    }

    public void drink(Double amount)
    {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            System.out.println("Cat dead or exploded");
        } else {
            ateFeed += amount;
            weight = weight + amount;
            if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) count--;
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    /**
     * Getter variable color.
     * @return CatsColor color.
     */
    public CatsColor getColor() {
        return color;
    }

    /**
     * Setter variable color.
     * @param color
     */
    public void setColor(CatsColor color) {
        this.color = color;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    /**
     * Возвращает количество выживших кошек.
     * @return count
     */
    public static int getCount() {
        return count;
    }
}