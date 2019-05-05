package Chapter2;

// Cracking the coding interview exercise 2.1
public class Solution_2_4_CCI_Partition {
    public static void solution(IntegerLinkedList list, int partitionValue) {
        if (list.isEmpty()) {
            return;
        }

        LinkedListNode<Integer> headLeftPartition = null;
        LinkedListNode<Integer> tailLeftPartition = null;

        LinkedListNode<Integer> headRightPartition = null;
        LinkedListNode<Integer> tailRightPartition = null;

        LinkedListNode<Integer> partitionNodes = null;
        LinkedListNode<Integer> tailPartitionNodes = null;

        LinkedListNode<Integer> current = list.head;

        while (current != null) {
            if (current.value < partitionValue) {
                if (headLeftPartition == null) {
                    headLeftPartition = tailLeftPartition = current;
                }
                else {
                    tailLeftPartition.next = current;
                    tailLeftPartition = tailLeftPartition.next;
                }
            }
            else if (current.value > partitionValue) {
                if (headRightPartition == null) {
                    headRightPartition = tailRightPartition = current;
                }
                else {
                    tailRightPartition.next = current;
                    tailRightPartition = tailRightPartition.next;
                }
            }
            else if (current.value == partitionValue) {
                if (partitionNodes == null) {
                    partitionNodes = tailPartitionNodes = current;
                }
                else {
                    tailPartitionNodes.next = current;
                    tailPartitionNodes = tailPartitionNodes.next;
                }
            }

            current = current.next;
        }

        if (headLeftPartition != null) {
            list.head = headLeftPartition;
            tailLeftPartition.next = partitionNodes;
            tailPartitionNodes.next = headRightPartition;
            if (tailRightPartition != null) {
                tailRightPartition.next = null;
            }
        }
        else {
            list.head = headRightPartition;
            tailRightPartition.next = partitionNodes;
            if (tailPartitionNodes != null) {
                tailPartitionNodes.next = null;
            }
        }
    }
}
