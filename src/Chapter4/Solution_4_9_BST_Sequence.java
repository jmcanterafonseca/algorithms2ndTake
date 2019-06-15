package Chapter4;

import java.util.ArrayList;
import java.util.List;

// CCI Print all arrays that could have led to a binary tree given
public class Solution_4_9_BST_Sequence {

    public static List<List<Integer>> solution(BinaryTreeNode<Integer> root) {
        return bstSequence(root);
    }

    private static List<List<Integer>> bstSequence(BinaryTreeNode<Integer> node) {
        List<List<Integer>> out = new ArrayList<>();

        if (node == null) {
            return out;
        }

        List<List<Integer>> first = bstSequence(node.left);
        List<List<Integer>> second = bstSequence(node.right);

        if (second.size() == 0) {
            for (List<Integer> list : first) {
                list.add(0, node.value);
                out.add(list);
            }
        }

        for (List<Integer> list : first) {
            for (List<Integer> rest : second) {
                List<Integer> newList = new ArrayList<>();

                newList.add(node.value);
                newList.addAll(list);
                newList.addAll(rest);

                out.add(newList);
            }
        }

        if (first.size() == 0) {
            for (List<Integer> list : second) {
                list.add(0, node.value);
                out.add(list);
            }
        }

        for (List<Integer> list : second) {
            for (List<Integer> rest : first) {
                List<Integer> newList = new ArrayList<>();

                newList.add(node.value);
                newList.addAll(list);
                newList.addAll(rest);

                out.add(newList);
            }
        }

        if (out.size() == 0) {
            List<Integer> outList = new ArrayList<>();
            outList.add(node.value);
            out.add(outList);
        }

        return out;
    }
}
