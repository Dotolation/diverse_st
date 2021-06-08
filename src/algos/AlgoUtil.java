package algos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlgoUtil {
	
	public static <K,V> void appendToListValueInMap(Map<K,List<V>> map, K key, V value) {
		List<V> listValue = map.get(key);
		listValue.add(value);
	}
	
	public static <K,V> void newListValueInMap(Map<K,List<V>> map, K key, V value) {
		List<V> newArrayList= new ArrayList<>();
		newArrayList.add(value);
		map.put(key, newArrayList);
	}

}
