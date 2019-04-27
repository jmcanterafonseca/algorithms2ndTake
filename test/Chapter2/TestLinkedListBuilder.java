package Chapter2;

public class TestLinkedListBuilder {
    // Builds a new Linked List from a String serialization
    // Example: 12->34->56
    public static IntegerLinkedList build(String serialization) {
        IntegerLinkedList out = new IntegerLinkedList();

        if (serialization == null || serialization.length() == 0) {
            // Empty list is returned
            return out;
        }
        String[] nodes = serialization.split("->");

        if (nodes.length == 0 || nodes[0].length() == 0) {
            // Empty list is returned
            return out;
        }

        try {
            out.head = new LinkedListNode<>(Integer.parseInt(nodes[0]));

            LinkedListNode<Integer> previous = out.head;

            for (int j = 1; j < nodes.length; j++) {
                if (nodes[j].length() > 0) {
                    LinkedListNode<Integer> node = new LinkedListNode<>(Integer.parseInt(nodes[j]));
                    previous.next = node;
                    previous = node;
                }
            }
        } catch (NumberFormatException ne) {
            throw new RuntimeException("Only numbers can be list values");
        }

        return out;
    }
}
