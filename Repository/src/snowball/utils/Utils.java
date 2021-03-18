package snowball.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import snowball.embroider.ModelConverter;

public class Utils {
	public static String gameJar;

	public static File directory;
	
	public static boolean check(Object o, Object... os) {
		for (Object obj : os) if (obj != o) return true;
		return false;
	}
	
	public static String getClassPath(Class<?> clazz) {
		return clazz.getProtectionDomain().getCodeSource().getLocation().getPath();
	}

	public static String value(Object... os) {
		StringBuilder builder = new StringBuilder();
		for (Object o : os) builder.append(o.toString() + ';');
		return builder.toString();
	}
	
	public static void print(String log) {
		ModelConverter.output.add(log + " \n");
	}

	public static void append(List<String> src, List<String> dest) {
		StringBuilder builder = new StringBuilder();
		for (String s : src) builder.append(s);
		dest.add(builder.toString());
	}
	
	public static void checkForEquilinoxJar() {
		File directory = new File(Utils.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		
		File[] files = directory.listFiles();
		
		for (File file : files) {
			String windows = "EquilinoxWindows.jar";
			String input = "input.jar";
			String mac = "EquilinoxMac.jar";
			
			String name = file.getName();
			
			if (name.equals(windows)) gameJar = windows;
			if (name.equals(input)) gameJar = input;
			if (name.equals(mac)) gameJar = mac;
		}
	}
	
	public static void checkForEquilinoxDir() {
		File directory = new File(Utils.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		
		Utils.directory = new File(directory + "../");
	}
	
	public static String toSpecial(List<String> src, List<String> special) {
		String srcText = src.toString();
		
		Map<Integer, String> indexes = new HashMap<>();
		
		for (String s : special) {
			int index = srcText.indexOf(s);
			
			indexes.put(index, s);
			
			srcText = srcText.replace(s, "");
		}
		
		srcText = srcText.replace(",", "").replace(" ", "");
		
		StringBuilder builder = new StringBuilder(srcText);
		
		indexes.forEach(builder::insert);
		
		return builder.toString().replace("[", "").replace("]", "");
	}
	
	public static void printCmd(List<String> cmds) {
		cmds.forEach(cmd -> {
			try {
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
				System.out.println(cmd);
				builder.redirectErrorStream(true);
				BufferedReader r = new BufferedReader(new InputStreamReader(builder.start().getInputStream()));
				String line;
				while (true) {
					line = r.readLine();
					if (line == null) break;
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	public static <T> Map<T, Integer> organizeList(Map<T, Integer> compMap) {
		return compMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (pastValue, newValue) -> pastValue, LinkedHashMap::new));
	}
	
	public static void convertAll(List<List<Object>> oListsList) {
		oListsList.forEach(Collections::reverse);
	}
	
	public static boolean checkUpperCase(String str) {
		for (char c : str.toCharArray()) { 
			if(Character.isLetter(c) && !Character.isUpperCase(c)) return false;
		}
		
        return true;
    }
}
