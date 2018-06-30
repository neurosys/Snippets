import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lists {
	
	public static List<String> listBuild() {
		List<String> strList = new ArrayList<String>();
		strList.add("Ana");
		strList.add("are");
		strList.add("mere");
		strList.add("mari");
		strList.add("si");
		strList.add("frumoase");
		
		return strList;
	}
	public static String buildStringFromList(List<String> list) {
		return String.join(" ", list);
	}
	public static List<String> listBuildFromArray() {
		String[] str = "Ana are mere mari si frumoase dar nu sunt de vanzare".split(" ");
		List<String> list = new ArrayList<String>(Arrays.asList(str));
		return list;
	}

	public static void printWithForeach(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
	
	public static void printWithIterator(List<String> list) {
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			System.out.println(s);
		}
	}
	
	public static void deleteWithFor(List<String> list) {
		int found = -1;
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (s.equals("mari")) {
				found = i;
			}
		}
		
		if (found != -1) {
			list.remove(found);
		}
	}
	
	public static void removeSpecificItemWithIterator(List<String> list) {
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			if (s.equals("are")) {
				itr.remove();
				continue;
			}
		}
	}
	
	public static void RemoveSpecificItemWithForeach(List<String> list) {
		String found = null;
		for (String s : list) {
			if (s.equals("mere")) {
				found = s;
			}
		}
		
		list.remove(found);
	}

	public static void main(String[] args) {
		List<String> list = listBuild();
		removeSpecificItemWithIterator(list);
		printWithIterator(list);
	}

}
