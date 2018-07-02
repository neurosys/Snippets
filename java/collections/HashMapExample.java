import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	
	public static HashMap<String, String> buildHashMap() {
		HashMap<String, String> hmap = new HashMap<>();
		hmap.put("param",  "value");
		hmap.put("param2",  "value2");
		hmap.put("param3",  "value3");
		
		return hmap;
	}

	public static void printHashMap0(HashMap<String, String> hmap) {
		System.out.println("\nprintHashMap0(OBSOLETE) (using an iterator) size = " + hmap.size());
		
		Iterator it = hmap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> e = (Map.Entry<String, String>)it.next();
			System.out.println("'" + e.getKey() + "' = '" + e.getValue() + "'");
		}
	}
	
	public static void printHashMap1(HashMap<String, String> hmap) {

		System.out.println("\nprintHashMap1() (using foreach) size = " + hmap.size());
		Set<String> keys = hmap.keySet();
		for (String key : keys) {
			System.out.println("'" + key + "' = '" + hmap.get(key));
		}
	}
	
	public static void printHashMap2(HashMap<String, String> hmap) {
		System.out.println("\nprintHashMap2() (using Map.Entry) size = " + hmap.size());
		for (Map.Entry<String, String> entry : hmap.entrySet()) {
			System.out.println("'" + entry.getKey() + "' = '" + entry.getValue() + "'");
		}
	}

	// Java 8 Lambda
	public static void printHashMap3(HashMap<String, String> hmap) {
		System.out.println("\nprintHashMap3() (using forEach and lambda) size = " + hmap.size());
		hmap.forEach((k,v) -> System.out.println("'" + k + "' = '" + v + "'"));
	}
	
	public static void removeFromHashMap(HashMap<String, String> hmap) {
		System.out.println("\nremoveFromhashMap() (remove pair with key 'param') size = " + hmap.size());
		hmap.remove("param");
	}

	public static void main(String[] args) {
		HashMap<String, String> hmap = buildHashMap();
		printHashMap0(hmap);
		removeFromHashMap(hmap);
		printHashMap1(hmap);
		printHashMap2(hmap);
		printHashMap3(hmap);
	}

}
