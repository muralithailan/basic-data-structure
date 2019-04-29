import java.util.Stack;

public class SolutionCustomStack {

	public static void main(String[] args) {

		CustomStack customStack = new CustomStack();

		customStack.add(2);
		customStack.add(3);
		customStack.add(1);
		customStack.add(20);
		customStack.add(0);
		customStack.add(10);

		while (!customStack.isEmpty()) {
			System.out.println("value : " + customStack.getMin() + "***************" + customStack.pop());
		}

		QueueFromStack queueFromStack = new QueueFromStack();

		queueFromStack.add(1);
		queueFromStack.add(2);
		queueFromStack.add(3);
		queueFromStack.add(4);
		queueFromStack.add(5);

		while (!queueFromStack.isEmpty()) {
			System.out.println(queueFromStack.get());
		}
		System.out.println("**************************** Sorted Stack ****************************");
		SortedStack sortedStack = new SortedStack();
		sortedStack.add(20);
		sortedStack.add(3);
		sortedStack.add(1);
		sortedStack.add(12);
		sortedStack.add(5);

		while (!sortedStack.isEmpty()) {
			System.out.println(sortedStack.pop());
		}
		System.out.println("**************************** Sort Stack with buffer****************************");
		Stack<Integer> stackSort = new Stack<>();
		stackSort.add(20);
		stackSort.add(3);
		stackSort.add(1);
		stackSort.add(12);
		stackSort.add(5);
		sortStack(stackSort);
		
		while (!stackSort.isEmpty()) {
			System.out.println(stackSort.pop());
		}
		
		

	}
	
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> buffer = new Stack<>();
		while(!stack.isEmpty()) {
			
			int data = stack.pop();
			while (!buffer.isEmpty() && buffer.peek() > data) {
				stack.add(buffer.pop());
			}
			buffer.add(data);
		}
		
		while (!buffer.isEmpty()) {
			stack.add(buffer.pop());
		}
	}

}
