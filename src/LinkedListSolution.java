import java.util.HashSet;
import java.util.Set;

public class LinkedListSolution {

	public static void main(String[] args) {

		LinkedListCustom linkedListCustom = new LinkedListCustom();

		linkedListCustom.add(1);
		linkedListCustom.add(2);
		linkedListCustom.add(3);
		linkedListCustom.add(4);
		linkedListCustom.add(5);
		linkedListCustom.add(6);
		linkedListCustom.add(7);

		linkedListCustom.display();
		System.out.println("*********************** get index ***********************");
		System.out.println(linkedListCustom.get(2));

		Integer n = linkedListCustom.getMiddleNode();
		System.out.println("*********************** Middle node ***********************");
		System.out.println(n);

		System.out.println("*********************** Overlap node ***********************");
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		Node head1 = new Node(10);
		head1.next = new Node(20);
		head1.next.next = head.next.next.next;

		Node node = getStartOfOverlapNode(head, head1);

		System.out.println(node.data);

		System.out.println("*********************** Loop in linked list ***********************");
		Node loopHead = new Node(1);
		loopHead.next = new Node(2);
		loopHead.next.next = new Node(3);
		loopHead.next.next.next = new Node(4);
		loopHead.next.next.next.next = new Node(5);
		loopHead.next.next.next.next.next = loopHead.next.next; // adding the loop to linked list

		Node out = loopInLinkedList(loopHead);
		System.out.println(out.data);
		removeLoopInLinkedList(loopHead); //////////////remove loop in linked list
		System.out.println("**********");
		while (loopHead != null) {
			System.out.println(loopHead.data);
			loopHead = loopHead.next;
		}

		

		System.out.println("*********************** Reverse linked list ***********************");
		Node headR = new Node(1);
		headR.next = new Node(2);
		headR.next.next = new Node(3);
		Node rev = reverseList(headR);

		while (rev != null) {
			System.out.println(rev.data);
			rev = rev.next;
		}
		System.out.println("*********************** Kth element from last in linked list ***********************");
		Node headK = new Node(1);
		headK.next = new Node(2);
		headK.next.next = new Node(3);
		headK.next.next.next = new Node(4);
		headK.next.next.next.next = new Node(5);
		headK.next.next.next.next.next = new Node(6);

		//Node nodeK = getKthElementFromLast(headK, new Len(3));
		
		Node nodeK = getKthNodefromLast(headK,3);
		System.out.println("Result ------------- "+nodeK.data);

		Node nodeK1 = getKthElementFromLastTwoPointer(headK, 3);
		System.out.println(nodeK1.data);

		// Rearrange linked list from middle
		System.out.println(
				"*********************** swap every elemnt from middle last in linked list ***********************");
		Node headRE = new Node(1);
		headRE.next = new Node(2);
		headRE.next.next = new Node(3);
		headRE.next.next.next = new Node(10);
		headRE.next.next.next.next = new Node(20);
		headRE.next.next.next.next.next = new Node(30);

		reArrangeLinkedist(headRE);
		while (headRE != null) {
			System.out.println(headRE.data);
			headRE = headRE.next;
		}

		System.out.println("*********************** Remove duplicate in linked list ***********************");

		Node headDup = new Node(1);
		headDup.next = new Node(2);
		headDup.next.next = new Node(3);
		headDup.next.next.next = new Node(2);
		headDup.next.next.next.next = new Node(3);
		headDup.next.next.next.next.next = new Node(2);
		deleteDuplicate(headDup);

		while (headDup != null) {
			System.out.println(headDup.data);
			headDup = headDup.next;
		}
		System.out.println("*********************** Remove duplicate in linked list No buffer ***********************");
		Node headDup2 = new Node(1);
		headDup2.next = new Node(2);
		headDup2.next.next = new Node(3);
		headDup2.next.next.next = new Node(2);
		headDup2.next.next.next.next = new Node(3);
		headDup2.next.next.next.next.next = new Node(2);
		deleteDuplicateNoBuffer(headDup2);
		while (headDup2 != null) {
			System.out.println(headDup2.data);
			headDup2 = headDup2.next;
		}
		System.out.println("*********************** Delete a node when only have acces to that node in linked list ***********************");
		Node headdel = new Node(1);
		headdel.next = new Node(2);
		headdel.next.next = new Node(3);
		headdel.next.next.next = new Node(4);
		headdel.next.next.next.next = new Node(5);
		headdel.next.next.next.next.next = new Node(6);
		deleteNodeInmid(headdel.next.next.next);
		while (headdel != null) {
			System.out.println(headdel.data);
			headdel = headdel.next;
		}
		
		System.out.println("*********************** Sum two linked list ***********************");
		Node num1 = new Node(7);
		num1.next = new Node(1);
		num1.next.next = new Node(6);

		Node num2 = new Node(5);
		num2.next = new Node(9);
		num2.next.next = new Node(2);
		
		Node sum = sumLinkedListRec(num1,num2,0);
		
		while(sum!=null) {
			System.out.println(sum.data +" ");
			sum = sum.next;
		}
		System.out.println("*********************** Partation around a number linked list ***********************");
		Node headPar = new Node(8);
		headPar.next = new Node(9);
		headPar.next.next = new Node(7);
		headPar.next.next.next = new Node(1);
		headPar.next.next.next.next = new Node(3);
		headPar.next.next.next.next.next = new Node(2);
		Node partSol = partation(headPar,2);
		
		while(partSol!=null) {
			System.out.print(partSol.data + "  ");
			partSol = partSol.next;
		}
		System.out.println("");
		System.out.println("*********************** Is a palindrome linked list ***********************");
		Node headPalindrome = new Node(1);
		headPalindrome.next = new Node(2);
		headPalindrome.next.next = new Node(3);
		headPalindrome.next.next.next = new Node(2);
		headPalindrome.next.next.next.next = new Node(1);
		boolean b = isPalindrome(headPalindrome);
		
		System.out.println(b); 
		
	}

	static class Len {
		int k;

		Len(int k) {
			this.k = k;
		}
	}

	public static void reArrangeLinkedist(Node head) {
		if (head != null) {

			Node fast = head.next;
			Node slow = head;

			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}

			Node p2 = slow.next;
			slow.next = null;

			fast = head;

			while (fast != null && p2 != null) {
				Node node1 = fast.next;
				Node node2 = p2.next;

				fast.next = p2;
				p2.next = node1;
				fast = node1;
				p2 = node2;

			}

		}
	}

	public static void deleteDuplicate(Node node) {

		Set<Integer> sets = new HashSet<>();

		Node prev = null;
		while (node != null) {

			if (!sets.contains(node.data)) {
				sets.add(node.data);
				prev = node;
			} else {
				prev.next = node.next;
			}
			node = node.next;
		}
	}
	
	public static void deleteDuplicateNoBuffer(Node node) {
		Node prev =null;
		while (node != null) {

			Node curr = node.next;
			prev = node;
			while(curr!=null) {
				
				if(curr.data == node.data) {
					prev.next = curr.next;
				}else {
					prev = curr;
					
				}
				curr = curr.next;
			}
			node = node.next;
		}
	}

	public static Node getKthElementFromLast(Node node, Len k) {
		if (node == null) {
			return null;
		}

		Node next = getKthElementFromLast(node.next, k);
		k.k = k.k - 1;

		if (k.k == 0) {
			return node;
		}
		return next;
	}

	public static Node getKthElementFromLastTwoPointer(Node head, int k) {
		if (head == null) {
			return null;
		}

		Node n1 = head;
		Node n2 = head;
		int i = 0;
		while (n1.next != null && i < k) {
			n1 = n1.next;
			i++;
		}

		if (i < k && n1.next == null) {
			return null;
		}
		while (n1 != null) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n2;
	}

	public static Node reverseList(Node head) {
		Node current = head;
		Node prev = null;
		while (current.next != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
		return prev;
	}

	public static Node getStartOfOverlapNode(Node head1, Node head2) {

		int size1 = 0;
		int size2 = 0;
		
		Node l1 = head1;
		Node l2 = head2;
		while(head1.next!=null) {
			head1 = head1.next;
			size1++;
		}
		while(head2.next!=null) {
			head2 = head2.next;
			size2++;
		}
		
		if(head1 != head2) {
			return null;
		}
		
		int size = Math.abs(size1-size2);
		Node small = size1< size2? l1:l2;
		Node large = size1<size2?l2:l1;
		
		while(large.next!=null && size>0) {
			large = large.next;
			size--;	
		}
		
		while(large!=small) {
			large = large.next;
			small = small.next;
				
		}
		return small;

	}

	public static Node loopInLinkedList(Node head) {
		
		Node fast = head;
		Node slow = head;
		boolean loop = false;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow==fast) {
				loop = true;
				break;
			}
			
		}
		
		if(!loop) {
			return null;
		}
		slow = head;
		while(fast!=slow) {
			fast = fast.next;
			slow = slow.next;
			
		}
		
		return slow;
		

	}
	
public static void removeLoopInLinkedList(Node head) {
		
		Node fast = head;
		Node slow = head;
		boolean loop = false;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow==fast) {
				loop = true;
				break;
			}
			
		}
		
		if(!loop) {
			return;
		}
		slow = head;
		Node prev = null;
		while(fast!=slow) {
			prev = fast;
			fast = fast.next;
			slow = slow.next;
			
		}
		prev.next = null;
		

	}


	private static Node getSize(Node head1, int size1) {
		while (head1.next != null) {
			head1 = head1.next;
			size1++;
		}
		return head1;
	}

	public void deleteNode(Node node, Node toDelete) {

		if (node == toDelete) {
			node = node.next;
		} else {
			while (node != null && node.next != toDelete) {
				node = node.next;
			}

			if (node != null) {
				Node n = node.next;
				node.next = n.next;
			}
		}

	}

	static class LinkedListCustom {
		Node head;
		Node tail;
		int size;

		public void add(int data) {
			if (head == null) {
				head = new Node(data);
				tail = head;
			} else {
				Node node = new Node(data);
				tail.next = node;
				tail = node;

			}

			size++;
		}

		public int get(int i) {
			int idx = 0;
			if (i > size) {
				throw new RuntimeException("Index out of bount exception");
			}
			Node node = head;
			while (idx < size && idx < i) {
				node = node.next;
				idx++;
			}
			return node.data;
		}

		public Integer getMiddleNode() {
			if (head == null) {
				return null;
			}
			Node fastNode = head.next;
			Node slowNode = head;
			while (fastNode != null && fastNode.next != null) {
				fastNode = fastNode.next.next;
				slowNode = slowNode.next;
			}

			if (slowNode != null) {
				return slowNode.data;
			} else {
				return null;
			}
		}

		public void display() {
			Node node = head;

			while (node != null) {
				System.out.println(node.data);
				node = node.next;
			}
		}
	}
	
	
	/////////////
	
	public static Node getKthNodefromLast(Node head,int k) {
		
		Node p1 = head;
		Node p2 = head;
		
		while(p1!=null && k>0) {
			p1 = p1.next;
			k--;
		}
		
		while(p1!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
		
	}
	
	//////////////////
	/**
	 * Node is not first or last node
	 * @param node
	 * @return
	 */
	public static boolean deleteNodeInmid(Node node) {
		if(node==null || node.next == null) {
			return false;
		}
		
		Node n = node.next;
		node.data = n.data;
		node.next = n.next;
		n.next = null;
		return true;
	}
	
	public static Node claculateSum(Node num1,Node num2) {
		Node sum = null;
		if(num1==null) {
			return num2;
		}else if(num2 == null) {
			return num1;			
		}
		int carry =0;
		Node head = null;
		while(num1!=null && num2!=null) {
			
			int sm = num1.data + num2.data + carry;
			if(sm >9) {
				carry = sm /10;
				sm = sm % 10;
			}else {
				carry = 0;
			}
			if(sum == null) {
				sum = new Node(sm);
				head = sum;
			}else {
				sum.next = new Node(sm);
				sum = sum.next;
			}
			num1 = num1.next;
			num2 = num2.next;
		}
		
		while(num1!=null) {
			int sm = num1.data + carry;
			if(sm >9) {
				carry = sm /10;
				sm = sm % 10;
			}else {
				carry = 0;
			}
			sum.next = new Node(sm);
			sum = sum.next;
			
			num1 = num1.next;
			
		}
		
		while(num2!=null) {
			int sm = num2.data + carry;
			if(sm >9) {
				carry = sm /10;
				sm = sm % 10;
			}else {
				carry = 0;
			}
			sum.next = new Node(sm);
			sum = sum.next;
			num2 = num2.next;
			
		}
		
		if(carry != 0) {
			sum.next = new Node(carry);
		}
		
		return head;
	}
	
	public static Node sumLinkedListRec(Node l1, Node l2,int carry) {
		if(l1==null && l2 == null && carry == 0) {
			return null;
		}
		
		int value = carry;
		if(l1!=null) {
			value += l1.data;
		}
		if(l2!=null) {
			value += l2.data;
		}
		carry = value /10;
		value = value %10;
		Node list = new Node(value);
		
		if(l1!=null || l2!=null) {
			Node next = sumLinkedListRec(l1!=null?l1.next:null,l2!=null?l2.next:null,carry);
			list.next = next;
		}
		
		return list;
		
	}
	
	public static Node partation(Node head,int x) {
		
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		while(head!=null) {
			Node next = head.next;
			head.next = null;
			if(head.data < x) {
				if(beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				}else {
					beforeEnd.next = head;
					beforeEnd = head;
				}
			}else {
				if(afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				}else {
					afterEnd.next = head;
					afterEnd = head;
				}
			}
			head = next;
		}
		
		if(beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	public static boolean isPalindrome(Node node) {
		Node reverse = null;
		
		Node head = node;
		while(node!=null) {
			
			Node n =  new Node(node.data);
			
			if(reverse == null) {
				reverse = n;
			}else {
				n.next = reverse;
				reverse = n;
			}
			node = node.next;
		}	
		
		while(head!=null) {
			if(head.data!=reverse.data) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
		}
		
		return true;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
}
