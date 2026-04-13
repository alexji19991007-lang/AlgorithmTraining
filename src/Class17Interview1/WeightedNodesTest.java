package Class17Interview1;

import java.util.*;

public class WeightedNodesTest {

    public static void main(String[] args) {
        testExample1_singleNode();
        testExample2_twoTerminalNodes();
        testExample3_multiplePaths();
        testExample4_complexGraph();
        testTieBreakByLexicographicalOrder();
        testSingleStartWithSharedTerminal();
        testTerminalAndInternalMix();
    }

    private static void printResult(String testName, List<String> expected, List<String> actual) {
        System.out.println("==== " + testName + " ====");
        System.out.println("Expected: " + expected);
        System.out.println("Actual  : " + actual);
        System.out.println();
    }

    public static void testExample1_singleNode() {
        Map<String, List<String>> dag = new HashMap<>();
        dag.put("A", Collections.emptyList());

        List<String> actual = WeightedNodes.sortTerminalNodes(dag);
        List<String> expected = Collections.singletonList("A");

        printResult("testExample1_singleNode", expected, actual);
    }

    public static void testExample2_twoTerminalNodes() {
        Map<String, List<String>> dag = new HashMap<>();
        dag.put("A", Arrays.asList("B", "C", "D"));
        dag.put("B", Collections.singletonList("D"));
        dag.put("C", Collections.emptyList());
        dag.put("D", Collections.emptyList());

        List<String> actual = WeightedNodes.sortTerminalNodes(dag);
        List<String> expected = Arrays.asList("D", "C");

        printResult("testExample2_twoTerminalNodes", expected, actual);
    }

    public static void testExample3_multiplePaths() {
        Map<String, List<String>> dag = new HashMap<>();
        dag.put("A", Arrays.asList("B", "C", "D"));
        dag.put("B", Arrays.asList("E", "F", "G"));
        dag.put("C", Collections.singletonList("G"));
        dag.put("D", Arrays.asList("G", "H"));
        dag.put("E", Collections.singletonList("F"));
        dag.put("F", Collections.emptyList());
        dag.put("G", Collections.emptyList());
        dag.put("H", Collections.emptyList());

        List<String> actual = WeightedNodes.sortTerminalNodes(dag);
        List<String> expected = Arrays.asList("G", "F", "H");

        printResult("testExample3_multiplePaths", expected, actual);
    }

    public static void testExample4_complexGraph() {
        Map<String, List<String>> dag = new HashMap<>();
        dag.put("A", Arrays.asList("H", "M"));
        dag.put("B", Collections.emptyList());
        dag.put("C", Collections.singletonList("B"));
        dag.put("D", Collections.emptyList());
        dag.put("E", Collections.singletonList("K"));
        dag.put("F", Collections.singletonList("E"));
        dag.put("G", Arrays.asList("J", "M", "L"));
        dag.put("H", Collections.emptyList());
        dag.put("I", Collections.emptyList());
        dag.put("J", Arrays.asList("I", "F", "A"));
        dag.put("K", Collections.singletonList("C"));
        dag.put("L", Collections.singletonList("D"));
        dag.put("M", Collections.singletonList("D"));

        List<String> actual = WeightedNodes.sortTerminalNodes(dag);
        List<String> expected = Arrays.asList("B", "D", "H", "I");

        printResult("testExample4_complexGraph", expected, actual);
    }

    public static void testTieBreakByLexicographicalOrder() {
        Map<String, List<String>> dag = new HashMap<>();
        dag.put("A", Arrays.asList("B", "C"));
        dag.put("B", Collections.emptyList());
        dag.put("C", Collections.emptyList());

        List<String> actual = WeightedNodes.sortTerminalNodes(dag);
        List<String> expected = Arrays.asList("B", "C");

        printResult("testTieBreakByLexicographicalOrder", expected, actual);
    }

    public static void testSingleStartWithSharedTerminal() {
        Map<String, List<String>> dag = new HashMap<>();
        dag.put("A", Arrays.asList("B", "C"));
        dag.put("B", Collections.singletonList("D"));
        dag.put("C", Collections.singletonList("D"));
        dag.put("D", Collections.emptyList());

        List<String> actual = WeightedNodes.sortTerminalNodes(dag);
        List<String> expected = Collections.singletonList("D");

        printResult("testSingleStartWithSharedTerminal", expected, actual);
    }

    public static void testTerminalAndInternalMix() {
        Map<String, List<String>> dag = new HashMap<>();
        dag.put("A", Arrays.asList("B", "C"));
        dag.put("B", Arrays.asList("D", "E"));
        dag.put("C", Collections.singletonList("E"));
        dag.put("D", Collections.emptyList());
        dag.put("E", Collections.emptyList());

        List<String> actual = WeightedNodes.sortTerminalNodes(dag);
        List<String> expected = Arrays.asList("E", "D");

        printResult("testTerminalAndInternalMix", expected, actual);
    }
}