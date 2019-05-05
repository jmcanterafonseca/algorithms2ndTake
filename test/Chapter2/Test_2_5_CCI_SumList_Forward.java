package Chapter2;

import org.junit.jupiter.api.Test;

import static utils.Utils.assertList;


public class Test_2_5_CCI_SumList_Forward {

    @Test
    void test0() {
        String slist1 = "1->5->6";
        String slist2 = "0->0->0";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 5, 6});
    }

    @Test
    void test1() {
        String slist1 = "1->5->6";
        String slist2 = "0->0->2";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 5, 8});
    }

    @Test
    void test2() {
        String slist1 = "1->5->6";
        String slist2 = "0->8->2";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{2, 3, 8});
    }

    @Test
    void test3() {
        String slist1 = "7->1->6";
        String slist2 = "5->9->2";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 3, 0, 8});
    }

    @Test
    void test4() {
        String slist1 = "2->7";
        String slist2 = "9->5";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 2, 2});
    }

    @Test
    void test5() {
        String slist1 = "0";
        String slist2 = "9->5";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{9, 5});
    }

    @Test
    void test6() {
        String slist1 = "1->0";
        String slist2 = "5";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 5});
    }

    @Test
    void test7() {
        String slist1 = "9->9";
        String slist2 = "9->9";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 9, 8});
    }

    @Test
    void test8() {
        String slist1 = "0->9->9";
        String slist2 = "9->9";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 9, 8});
    }

    @Test
    void test9() {
        String slist1 = "0->9->9";
        String slist2 = "0->9->9";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 9, 8});
    }

    @Test
    void test10() {
        String slist1 = "1->0->9->9";
        String slist2 = "0->9->9";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{1, 1, 9, 8});
    }


    @Test
    void test30() {
        String slist1 = "";
        String slist2 = "8->2->0";

        IntegerLinkedList list1 = TestLinkedListBuilder.build(slist1);
        IntegerLinkedList list2 = TestLinkedListBuilder.build(slist2);

        IntegerLinkedList result = Solution_2_5_CCI_SumList_Forward.solution(list1, list2);

        assertList(result, new int[]{8, 2, 0});
    }

}
