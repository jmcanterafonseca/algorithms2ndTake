package Chapter3;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution_3_6_CCI_AnimalShelter {
    public Solution_3_6_CCI_AnimalShelter() {

    }

    private LinkedList<Animal> animalQueue = new LinkedList<>();

    private Dog firstDog;
    private Cat firstCat;

    public void addCat(Cat c) {
        animalQueue.add(c);

        if (firstCat == null) {
            firstCat = c;
        }
    }

    public void addDog(Dog d) {
        animalQueue.add(d);

        if (firstDog == null) {
            firstDog = d;
        }
    }

    public Animal adoptAnimal() {
        if (animalQueue.isEmpty()) {
            throw new RuntimeException("Shelter is empty");
        }

        Animal out = animalQueue.removeFirst();

        if (out instanceof Dog) {
            firstDog = null;
            updateFirstDog();
        }

        return out;
    }

    public Dog adoptDog() {
        if (firstDog == null) {
            throw new RuntimeException("No dogs in shelter");
        }

        Dog out = firstDog;

        firstDog = null;

        updateFirstDog();

        return out;
    }

    public Cat adoptCat() {
        if (firstCat == null) {
            throw new RuntimeException("No cats in shelter");
        }

        Cat out = firstCat;

        firstCat = null;

        updateFirstCat();

        return out;
    }

    public boolean isEmpty() {
        return animalQueue.isEmpty();
    }

    private void updateFirstDog() {
        Iterator<Animal> it = animalQueue.descendingIterator();

        while (it.hasNext() && firstDog == null) {
            Animal next = it.next();
            if (next instanceof Dog) {
                firstDog = (Dog) next;
            }
        }
    }

    private void updateFirstCat() {
        Iterator<Animal> it = animalQueue.descendingIterator();

        while (it.hasNext() && firstCat == null) {
            Animal next = it.next();
            if (next instanceof Cat) {
                firstCat = (Cat) next;
            }
        }
    }

    public static abstract class Animal {
        public String name;

        public Animal(String name) {
            this.name = name;
        }
    }


    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }

    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

}
