package heap;

import java.util.PriorityQueue;

import data.ListNode;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null)
                pq.offer(list);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] values = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
        ListNode[] lists = new ListNode[values.length];

        for (int i = 0; i < values.length; i++) {
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            for (int value : values[i]) {
                tail.next = new ListNode(value);
                tail = tail.next;
            }
            lists[i] = dummy.next;
        }

        ListNode merged = mergeKLists(lists);
        StringBuilder output = new StringBuilder("[");
        while (merged != null) {
            if (output.length() > 1) {
                output.append(", ");
            }
            output.append(merged.val);
            merged = merged.next;
        }
        System.out.println(output.append("]"));
    }
}
