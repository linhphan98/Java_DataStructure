import java.util.HashMap;

public class HashMapDemo {
	public static void main(String args[]) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(100, "john@gmail.com");
		hashMap.put(200, "linh@gmail.com");
		hashMap.put(300, "maia@gmail.com");
		hashMap.put(400, "max@gmail.com");
		hashMap.put(500, "danielle@gmail.com");
		hashMap.put(600, "noah@gmail.com");
		
		String value = hashMap.get(200);
		System.out.print(value);
	}
}
