/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode after=head;
        ListNode curr=head;

        while(curr!=null)
        {
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }

    public static ListNode midelement(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;

        while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
        return slow;
    }

    public int pairSum(ListNode head) {
       if(head==null)
        return 0;
        ListNode slow=midelement(head);
        ListNode again = reverse(slow.next);
        ListNode temp=head;
        int max=Integer.MIN_VALUE;
        while(again!=null)
        {
            if(max<temp.val+again.val)
            {
                max=temp.val+again.val;
            }
            else
            {
                temp=temp.next;
                again=again.next;
            }
        }
        return max;
    } 
}



