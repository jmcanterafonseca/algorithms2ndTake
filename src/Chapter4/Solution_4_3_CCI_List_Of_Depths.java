package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// list of depths CCI 4.3
public class Solution_4_3_CCI_List_Of_Depths {
    public static List<LinkedList<BinaryTreeNode<Integer>>> solution(BinaryTreeNode<Integer> root) {
        List<LinkedList<BinaryTreeNode<Integer>>> out = new ArrayList<>();

        listNodes(root, 1, out);

        return out;
    }

    public static void listNodes(BinaryTreeNode<Integer> start, int level, List<LinkedList<BinaryTreeNode<Integer>>> list) {
        if (start != null) {
            LinkedList<BinaryTreeNode<Integer>> nodeList = null;
            if (list.size() > level - 1) {
                nodeList = list.get(level - 1);
            } else {
                nodeList = new LinkedList<>();
                list.add(level - 1, nodeList);
            }

            nodeList.add(start);
            listNodes(start.left, level + 1, list);
            listNodes(start.right, level + 1, list);
        }
    }
}
