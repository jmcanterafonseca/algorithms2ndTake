package Chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


// Test 4.7 Build Order
public class Test_4_7_CCI_BuildOrder {

    // Asserts that the dependencies are properly met
    private static void assertResult(String[] result, String[] projects, String[][] dependencies) {

        assertEquals(result.length, projects.length);

        for (String[] dependency : dependencies) {
            // Project that depends on another project
            String dependent = dependency[0];
            // Project from which the other project depends on
            String dependsOn = dependency[1];

            int dependentIndex = -1;
            // Search for dependent
            for (int j = 0; j < result.length; j++) {
                if (result[j].equals(dependent)) {
                    dependentIndex = j;
                    break;
                }
            }
            assertTrue(dependentIndex != -1);

            int dependsOnIndex = -1;
            // Search for dependsOn
            for (int j = 0; j < result.length; j++) {
                if (result[j].equals(dependsOn)) {
                    dependsOnIndex = j;
                    break;
                }
            }
            assertTrue(dependsOnIndex != -1);

            assertTrue(dependsOnIndex < dependentIndex);
        }

    }

    @Test
    void test10() {
        String[] projects = {"a", "b", "c", "d", "e", "f"};

        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};

        assertResult(Solution_4_7_CCI_BuildOrder.solution(projects, dependencies), projects, dependencies);
    }

    @Test
    void test11() {
        String[] projects = {"a", "b"};

        String[][] dependencies = {{"a", "b"}};

        assertResult(Solution_4_7_CCI_BuildOrder.solution(projects, dependencies), projects, dependencies);
    }

    @Test
    void test12() {
        String[] projects = {"a", "b", "c"};

        String[][] dependencies = {};

        assertResult(Solution_4_7_CCI_BuildOrder.solution(projects, dependencies), projects, dependencies);
    }

    @Test
    void test13() {
        String[] projects = {"a", "b", "c"};

        String[][] dependencies = {{"a", "c"}};

        assertResult(Solution_4_7_CCI_BuildOrder.solution(projects, dependencies), projects, dependencies);
    }

    @Test
    void test14() {
        String[] projects = {"a", "b", "c"};

        String[][] dependencies = {{"c", "a"}, {"a", "b"}};

        assertResult(Solution_4_7_CCI_BuildOrder.solution(projects, dependencies), projects, dependencies);
    }

    @Test
    void test15() {
        String[] projects = {"a", "b", "c"};

        String[][] dependencies = {{"c", "a"}, {"a", "b"}, {"a", "c"}};

        // The graph has loops thus a runtime exception shall be
        try {
            Solution_4_7_CCI_BuildOrder.solution(projects, dependencies);
        }
        catch(CircularDependencyDetected cdr) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    @Test
    void test16() {
        String[] projects = {"a", "b", "c", "d", "e"};

        String[][] dependencies = {{"e", "d"}, {"d", "b"}, {"a", "b"}, {"a", "e"}};

        assertResult(Solution_4_7_CCI_BuildOrder.solution(projects, dependencies), projects, dependencies);
    }

    @Test
    void test17() {
        String[] projects = {"a", "b", "c", "d", "e"};

        String[][] dependencies = {{"e", "d"}, {"d", "b"}, {"a", "b"}, {"a", "e"}, {"b", "e"}};

        try {
            Solution_4_7_CCI_BuildOrder.solution(projects, dependencies);
        }
        catch(CircularDependencyDetected cdr) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }
}
