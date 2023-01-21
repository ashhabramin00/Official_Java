
public class ReverseList 
{
	public ListNode reverseList(ListNode head)
	{
		ListNode prev = null;
		
		while (head != null)
		{
			ListNode next_node = head.next;
			head.next = prev;
			prev = head;
			head = next_mode;
			
		}
		return prev
	}

}
