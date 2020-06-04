package ru.skillbox.module03.task01_08.cat;

public class Loader {
    public static void main(String[] args) {
        System.out.println(System.lineSeparator() +
                "------------------------------------- TASK01 -------------------------------------" +
                System.lineSeparator());


        Cat asya = new Cat();
        Cat murka = new Cat();
        Cat mashka = new Cat();
        Cat vasya = new Cat();
        Cat katya = new Cat();
        Cat barsik = new Cat();

        System.out.println("Asya: " + asya.getWeight() + " Status: " + asya.getStatus());
        System.out.println("Murka: " + murka.getWeight() + " Status: " + murka.getStatus());
        System.out.println("Mashka: " + mashka.getWeight() + " Status: " + mashka.getStatus());
        System.out.println("Vasya: " + vasya.getWeight() + " Status: " + vasya.getStatus());
        System.out.println("Katya: " + katya.getWeight() + " Status: " + katya.getStatus());
        System.out.println("Barsik: " + barsik.getWeight() + " Status: " + barsik.getStatus());

        System.out.println(System.lineSeparator() + "------------Cats ate and exploded------------" + System.lineSeparator());

        /*
        Здесь некоторые кошки рандомно едят, некоторые из них переедают и взрываются
         */
        asya.feed(10000.0 * Math.random());
        murka.feed(10000.0 * Math.random());
        mashka.feed(10000.0 * Math.random());
        vasya.feed(10000.0 * Math.random());
        katya.feed(10000.0 * Math.random());
        barsik.feed(10000.0 * Math.random());

        System.out.println("Asya: " + asya.getWeight() + " Status: " + asya.getStatus());
        System.out.println("Murka: " + murka.getWeight() + " Status: " + murka.getStatus());
        System.out.println("Mashka: " + mashka.getWeight() + " Status: " + mashka.getStatus());
        System.out.println("Vasya: " + vasya.getWeight() + " Status: " + vasya.getStatus());
        System.out.println("Katya: " + katya.getWeight() + " Status: " + katya.getStatus());
        System.out.println("Barsik: " + barsik.getWeight() + " Status: " + barsik.getStatus());

        System.out.println(System.lineSeparator() + "------------Cats deaded of meow------------" + System.lineSeparator());

        if (asya.getStatus() != "Exploded"){
            while (asya.getStatus() != "Dead") {
                asya.meow();
            }
        }
        if (murka.getStatus() != "Exploded"){
            while (murka.getStatus() != "Dead") {
                murka.meow();
            }
        }
        if (mashka.getStatus() != "Exploded"){
            while (mashka.getStatus() != "Dead") {
                mashka.meow();
            }
        }
        if (vasya.getStatus() != "Exploded"){
            while (vasya.getStatus() != "Dead") {
                vasya.meow();
            }
        }
        if (katya.getStatus() != "Exploded"){
            while (katya.getStatus() != "Dead") {
                katya.meow();
            }
        }
        if (barsik.getStatus() != "Exploded"){
            while (barsik.getStatus() != "Dead") {
                barsik.meow();
            }
        }

        System.out.println("Asya: " + asya.getWeight() + " Status: " + asya.getStatus());
        System.out.println("Murka: " + murka.getWeight() + " Status: " + murka.getStatus());
        System.out.println("Mashka: " + mashka.getWeight() + " Status: " + mashka.getStatus());
        System.out.println("Vasya: " + vasya.getWeight() + " Status: " + vasya.getStatus());
        System.out.println("Katya: " + katya.getWeight() + " Status: " + katya.getStatus());
        System.out.println("Barsik: " + barsik.getWeight() + " Status: " + barsik.getStatus());

        System.out.println(System.lineSeparator() +
                "------------------------------------- TASKk02 -------------------------------------" +
                System.lineSeparator());

        Cat pee = new Cat();
        pee.feed(150.00);
        pee.pee();
        pee.pee();
        System.out.println("Pee: " + pee.getWeight() + ", Status: " + pee.getStatus() + ", Ate Feed: " + pee.getAteFeed());
        pee.feed(9000.0);

        System.out.println(System.lineSeparator() +
                "------------------------------------- TASK03 -------------------------------------" +
                System.lineSeparator());

        System.out.println("Кол-во кошек на начало теста: " + Cat.getCount());
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        System.out.println("Кошек создано: " + Cat.getCount());
        cat1.feed(9000.0);
        System.out.println("Одну кошку перекормили, осталось: " + Cat.getCount());
        barsik.feed(450.00);

        System.out.println(System.lineSeparator() +
                "------------------------------------- TASK05 -------------------------------------" +
                System.lineSeparator());

        Cat cat = catGenerate(3520);

        System.out.println(System.lineSeparator() +
                "------------------------------------- TASK07 -------------------------------------" +
                System.lineSeparator());

        Cat kot = new Cat();
        Cat copyKot = Cat.copy(kot);

        System.out.println("Kot: " + kot.getWeight() + ", Status: " + kot.getStatus());
        System.out.println("CopyKot: " + copyKot.getWeight() + ", Status: " + copyKot.getStatus());
    }

    public static Cat catGenerate(double weight) {
        Cat cat = new Cat(weight);
        return cat;
    }
}