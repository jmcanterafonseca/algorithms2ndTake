package Chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_1_3_CCI_URLify {
    @Test
    void test0() {
        String str1 = "hola que tal";
        char[] buffer = new char[str1.length() + 4];
        char[] strChars = str1.toCharArray();

        System.arraycopy(strChars,0,buffer,0,strChars.length);

        assertEquals("hola%20que%20tal", Solution_1_3_CCI_URLify.solution(buffer,str1.length()));
    }

    @Test
    void test1() {
        String str1 = "word";
        char[] buffer = new char[str1.length()];
        char[] strChars = str1.toCharArray();

        System.arraycopy(strChars,0,buffer,0,strChars.length);

        assertEquals("word", Solution_1_3_CCI_URLify.solution(buffer,str1.length()));
    }

    @Test
    void test2() {
        String str1 = "";
        char[] buffer = new char[str1.length()];
        char[] strChars = str1.toCharArray();

        System.arraycopy(strChars,0,buffer,0,strChars.length);

        assertEquals("", Solution_1_3_CCI_URLify.solution(buffer,str1.length()));
    }

    @Test
    void test3() {
        String str1 = " ";
        char[] buffer = new char[str1.length() + 2];
        char[] strChars = str1.toCharArray();

        System.arraycopy(strChars,0,buffer,0,strChars.length);

        assertEquals("%20", Solution_1_3_CCI_URLify.solution(buffer,str1.length()));
    }

    @Test
    void test4() {
        String str1 = "  h";
        char[] buffer = new char[str1.length() + 4];
        char[] strChars = str1.toCharArray();

        System.arraycopy(strChars,0,buffer,0,strChars.length);

        assertEquals("%20%20h", Solution_1_3_CCI_URLify.solution(buffer,str1.length()));
    }

    @Test
    void test5() {
        String str1 = "  h ";
        char[] buffer = new char[str1.length() + 6];
        char[] strChars = str1.toCharArray();

        System.arraycopy(strChars,0,buffer,0,strChars.length);

        assertEquals("%20%20h%20", Solution_1_3_CCI_URLify.solution(buffer,str1.length()));
    }
}
