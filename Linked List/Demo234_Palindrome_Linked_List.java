import java.util.ArrayList;

public class Demo234_Palindrome_Linked_List {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-129);
		ListNode l2 = new ListNode(-129);
		l1.next = l2;
		System.out.println(new Solution_234().isPalindrome(l1));
	}
}

class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        boolean flag = true;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        // System.out.println(list);
        
        for(int i = 0; i < list.size() / 2; i++) {
        	// System.out.println(list.get(i));
        	// System.out.println(list.get(list.size() - 1 - i));
        	// System.out.println(list.get(i).equals(list.get(list.size() - 1 - i)));
            if(!list.get(i).equals(list.get(list.size() - 1 - i)))
                flag = false;
        }
        
        return flag;
    }
}