package snowball.embroider.component.blueprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import snowball.embroider.util.Vector;
import snowball.utils.Utils;
import utils.CSVReader;

public class BlueprintUtils {
	static void readMap(List<Object> os, Map<Object, Boolean> map, CSVReader reader) {
		map.forEach((o, b) -> {
			if (Boolean.TRUE.equals(b) && !(o instanceof Float[]) && !(o instanceof Integer[]) && !(o instanceof Long)) reader.getNextString();
			
			else if (o instanceof float[]) {
				os.add(reader.getNextLabelFloatArray()); b = true;
			} else if (o instanceof int[]) {
				os.add(reader.getNextLabelIntArray()); b = true;
			} else if (o instanceof Vector) os.add(reader.getNextVector());
			else if (o instanceof String) os.add(reader.getNextString());
			else if (o instanceof Boolean) os.add(reader.getNextBool());
			else if (o instanceof Float) os.add(reader.getNextFloat());
			else if (o instanceof Integer) os.add(reader.getNextInt());
			else if (o instanceof Long) {
				os.add(reader.getNextLong()); b = false;
			}
		});
	}
	

	static void load(List<String> loader, List<Object> os, Map<Boolean, String> labels, String name) {
		List<String> component = new ArrayList<>();
		
		AtomicInteger counter = new AtomicInteger(0);
		os.forEach(o -> {
			List<Boolean> hasLabel = labels.keySet().stream().collect(Collectors.toList());
			List<String> label = new ArrayList<>(labels.values());
				
			component.add(name.toUpperCase());
			
			if (Boolean.TRUE.equals(hasLabel.get(counter.get())) && label.get(counter.get()) != null) component.add(label.get(counter.get()));
			
			loadObjects(o, component);
			counter.getAndIncrement();
		});
		
		Utils.append(component, loader);
	}
	
	private static void loadObjects(Object o, List<String> component) {
		if (o instanceof float[]) {
			component.add(((int[]) o).length + ";");
			for (int i : ((int[]) o)) component.add(i + ";");
		} else if (o instanceof int[]) {
			component.add(((float[]) o).length + ";");
			for (float f : (float[]) o) component.add(f + ";");
		}
		
		else if (o instanceof Boolean) component.add((Boolean.TRUE.equals(o) ? 1 : 0) + ";");
		else if (o instanceof Integer) component.add((Integer) o + ";");
		else if (o instanceof String) component.add((String) o + ";");
		else if (o instanceof Vector) component.add((Vector) o + ";");
		else if (o instanceof Float) component.add((Float) o + ";");
		else if (o instanceof Long) component.add((Long) o + ";");
	}
	
	public static Map<Boolean, String> mapLabels(Map<Object, Boolean> map, List<String> labels) {
		Map<Boolean, String> labelMap = new HashMap<>();
		
		AtomicInteger counter = new AtomicInteger(0);
		map.forEach((o, b) -> {
			if (Boolean.TRUE.equals(b)) { 
				labelMap.put(b, labels.get(counter.get()));
				counter.getAndIncrement();
			} else {
				labelMap.put(b, null);
			}
		});
		
		return labelMap;
	}
}
