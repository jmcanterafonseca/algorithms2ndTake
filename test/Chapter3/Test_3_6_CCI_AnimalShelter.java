package Chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_3_6_CCI_AnimalShelter {

    @Test
    void test10() {
        Solution_3_6_CCI_AnimalShelter shelter = new Solution_3_6_CCI_AnimalShelter();

        Solution_3_6_CCI_AnimalShelter.Dog d = new Solution_3_6_CCI_AnimalShelter.Dog("Bob");

        Solution_3_6_CCI_AnimalShelter.Cat c = new Solution_3_6_CCI_AnimalShelter.Cat("kitty");

        shelter.addDog(d);
        shelter.addCat(c);

        assertEquals(d.name, shelter.adoptAnimal().name);
        assertEquals(c.name, shelter.adoptCat().name);

        assertTrue(shelter.isEmpty());
    }

    @Test
    void test11() {
        Solution_3_6_CCI_AnimalShelter shelter = new Solution_3_6_CCI_AnimalShelter();

        assertTrue(shelter.isEmpty());
    }

    @Test
    void test12() {
        Solution_3_6_CCI_AnimalShelter shelter = new Solution_3_6_CCI_AnimalShelter();

        Solution_3_6_CCI_AnimalShelter.Dog d = new Solution_3_6_CCI_AnimalShelter.Dog("Bob");
        Solution_3_6_CCI_AnimalShelter.Cat c = new Solution_3_6_CCI_AnimalShelter.Cat("kitty");
        Solution_3_6_CCI_AnimalShelter.Dog d2 = new Solution_3_6_CCI_AnimalShelter.Dog("John");

        shelter.addDog(d);
        shelter.addCat(c);
        shelter.addDog(d2);

        assertEquals(c.name, shelter.adoptCat().name);
    }

    @Test
    void test13() {
        Solution_3_6_CCI_AnimalShelter shelter = new Solution_3_6_CCI_AnimalShelter();

        Solution_3_6_CCI_AnimalShelter.Cat c = new Solution_3_6_CCI_AnimalShelter.Cat("kitty");
        Solution_3_6_CCI_AnimalShelter.Dog d = new Solution_3_6_CCI_AnimalShelter.Dog("Bob");
        Solution_3_6_CCI_AnimalShelter.Dog d2 = new Solution_3_6_CCI_AnimalShelter.Dog("John");

        shelter.addCat(c);
        shelter.addDog(d);
        shelter.addDog(d2);

        assertEquals(d.name, shelter.adoptDog().name);
        assertEquals(d2.name, shelter.adoptDog().name);

        assertEquals(c.name, shelter.adoptCat().name);

        assertTrue(shelter.isEmpty());
    }
}
