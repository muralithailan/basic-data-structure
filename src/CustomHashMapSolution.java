import java.util.HashMap;

public class CustomHashMapSolution {

	public static void main(String[] args) {
		
		CustomHashMap<String, String> map = new CustomHashMap<>();
		
		HashMap<String, String> mapss = new HashMap<>();
		
		map.put("bala", "1");
		
		map.put("bala", "2");
		
		map.put("murali", "3");
		
		System.out.println(map.get("bala"));
		
		System.out.println(map.get("murali"));
		
	}

}
