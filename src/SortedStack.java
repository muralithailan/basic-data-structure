import java.util.Stack;

public class SortedStack {

	Stack<Integer> out;
	Stack<Integer> buffer;

	SortedStack() {
		out = new Stack<>();
		buffer = new Stack<>();
	}

	public void add(int data) {

		while (!out.isEmpty() && out.peek() < data) {
			buffer.add(out.pop());
		}

		out.add(data);
		while (!buffer.isEmpty()) {
			out.add(buffer.pop());
		}
	}
	
	public int pop() {
		return out.pop();
	}
	
	public int peek() {
		return out.peek();
	}
	
	public boolean isEmpty() {
		return out.isEmpty();
	}

}
