import java.util.Stack;

public class QueueFromStack {

	Stack<Integer> out;
	Stack<Integer> buffer;

	QueueFromStack() {
		out = new Stack<>();
		buffer = new Stack<>();
	}

	public void add(int data) {
		while (!out.isEmpty()) {
			buffer.add(out.pop());
		}
		out.add(data);
		while (!buffer.isEmpty()) {
			out.add(buffer.pop());
		}
	}

	public int get() {
		return out.pop();
	}
	
	public boolean isEmpty() {
		return out.isEmpty();
	}
}
