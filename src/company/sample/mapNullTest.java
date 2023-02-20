package company.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class mapNullTest {

	public static void main(String[] args) {
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		Map<String, Object> map3 = new HashMap<>();
		map.put("skuName", "a");
		map.put("sapCode", "b");
		map.put("etc", "abc");
		result.add(map);
		map2.put("skuName", "");
		map2.put("sapCode", "");
		map2.put("etc", "");
		result.add(map2);
		map3.put("skuName", "c");
		map3.put("sapCode", "d");
		map3.put("etc", "");
		result.add(map3);
		//test

		for (Map<String, Object> entry : result) {
			for (Entry<String, Object> entrySet : entry.entrySet()) {
//				System.out.println(entrySet.getValue());
				if (entrySet.getKey().equals("skuName") && !"".equals(entrySet.getValue())
						|| entrySet.getKey().equals("sapCode") && !"".equals(entrySet.getValue())
						|| entrySet.getKey().equals("etc")) {
				  System.out.println(entrySet.getKey());
				  System.out.println(entrySet.getValue());
				}
			}
		}

	}
}
