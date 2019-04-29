import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class NumberInterval {

	public static void main(String[] args) {

		Interval interval1 = new Interval(6,8);
		Interval interval2 = new Interval(1,9);
		Interval interval3 = new Interval(2,4);
		Interval interval4 = new Interval(4,7);
		
		Interval[] intervals = {interval1,interval2,interval3,interval4};
		NumberInterval numberInterval = new NumberInterval();
		for(Interval in : numberInterval.getMergerd(intervals)) {
			System.out.println(in.start +"   "+in.end);
		}

	}
	
	public List<Interval> getMergerd(Interval[] intervals){
		
		Stack<Interval> intervalStack = new Stack<>();
		
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {

				return o1.start - o2.start;
			}

		});
		
		intervalStack.push(intervals[0]);
		for(int i=0;i<intervals.length;i++) {
			
			Interval top = intervalStack.peek();
			if(top.end < intervals[i].start) {
				intervalStack.push(intervals[i]);
			}else if(top.end < intervals[i].end ){
				top.end = intervals[i].end;
				intervalStack.pop();
				intervalStack.push(top);
			}
		}
		
		return intervalStack;
		
		
	}
	
	static class Interval{
		int start;
		int end;
		Interval(int start,int end){
			this.start = start;
			this.end = end;
		}
	}

}
