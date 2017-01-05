package uchidb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author aelmore
 */
public class HW0Runner {
	
	private static class MyContainers<S, T> implements Containers<S, T> {
		
		private Set<S> set = null;
		private List<S> list = null;
		private Map<T, S> map = null;

		@Override
		public Set<S> initSet(S[] tArray) {
			set = new HashSet<S>();
			for (S s : tArray) {
				set.add(s);
			}
			return set;
		}

		@Override
		public List<S> initList(S[] tArray) {
			list = new ArrayList<S>();
			for (S s : tArray) {
				list.add(s);
			}
			return list;
		}

		@Override
		public Map<T, S> initEmptyMap() {
			map = new HashMap<T, S>();
			return map;
		}

		@Override
		public void storeMap(Map<T, S> mapToStoreInClass) {
			map = new HashMap<T, S>(mapToStoreInClass);
		}

		@Override
		public boolean addToMap(T key, S value, boolean overwriteExistingKey) {
			if (!map.containsKey(key) || overwriteExistingKey) {
				map.put(key, value);
				return true;
			} else {
				return false;
			}
		}

		@Override
		public S getValueFromMap(T key) {
			if (map.containsKey(key)) {
				return map.get(key);
			} else {
				return null;
			}
		}

		@Override
		public S getValueFromMap(T key, S defaultValue) {
			if (map.containsKey(key)) {
				return map.get(key);
			} else {
				return defaultValue;
			}
		}
		
	}
	
	private static Containers<Integer, String> containersInstance = null;

	// This class is a factory for a singleton containers class.
	// https://www.tutorialspoint.com/java/java_using_singleton.htm
	public static synchronized Containers<Integer, String> getContainers() {
		if (containersInstance == null) {
			containersInstance = new MyContainers<Integer, String>();
		}
		return containersInstance;
	}

	public static void main(String[] args){
		
	}
}
