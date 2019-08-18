package Misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_Treasure {
    @Test
    void test0() {
        char[][] map = {
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };

        int result = Treasure.minSteps(map);

        assertEquals(5, result);
    }

}
