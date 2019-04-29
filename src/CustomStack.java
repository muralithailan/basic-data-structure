import java.util.Stack;

public class CustomStack extends Stack<Integer>{

	Stack<Integer> min = null;
	
	CustomStack(){
		min = new Stack<>();
	}
	
	public void add(int data) {
		int value = getMin();
		if(data<value) {
			min.push(data);
		}
		super.push(data);
	}

	public Integer pop() {
		int data = super.pop();
		
		int value = getMin();
		if(data == value) {
			min.pop();
		}
		
		return data;
	}
	public int getMin() {
		if(min.isEmpty()) {
			return Integer.MAX_VALUE;
		}else {
			return min.peek();
		}
	}
	
	
	
	
}
