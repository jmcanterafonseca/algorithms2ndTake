package Misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_VanishCodes {
    @Test
    void test1() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-894546-34");

        assertEquals(1, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test2() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356937-34");

        assertEquals(1, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test3() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIOX");
        codes.add("FLOWERX");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356937-34");

        assertEquals(0, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test6() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356937");

        assertEquals(1, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test4() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356937-894546");

        assertEquals(2, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test7() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356937-8945467");

        assertEquals(2, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test8() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356937-");

        assertEquals(1, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test9() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-3569378945467");

        assertEquals(2, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test10() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356894");

        assertEquals(0, VanishCodes.vanishCodes(codes, phoneNumbers));
    }

    @Test
    void test11() {
        List<String> codes = new ArrayList<>();

        codes.add("TWILIO");
        codes.add("FLOWER");

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1-356");

        assertEquals(0, VanishCodes.vanishCodes(codes, phoneNumbers));
    }
}
