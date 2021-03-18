package snowball.mod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import snowball.mod.load.PreInitializer;
import snowball.utils.Utils;

public class ModLoader {
	private static final List<Mod> loadedMods = new ArrayList<>();

	public static final List<File> modJars = new ArrayList<>();
	
	private static boolean isMod = false;
	
	public static void load() {
		loadMods();
		initializeMods();
	}
	
	private static void loadMods() {
		try {
			URLClassLoader loader = (URLClassLoader) ClassLoader.getSystemClassLoader();
			
			Method url = URLClassLoader.class.getDeclaredMethod("addUrl", URL.class);
			
			for (File file : new File("mods").listFiles()) {
				String name = file.getName();
				
				if (name.endsWith(".jar")) {
					System.out.println("Getting file " + name);
					
					url.invoke(loader, file.toURI().toURL());
					
					JarFile jar = new JarFile(file);
					
					for (JarEntry entry : Collections.list(jar.entries())) addMods(entry);
					
					if (isMod) modJars.add(file);
					
					jar.close();
				}
			}
		} catch (IOException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | InstantiationException e) {
			e.printStackTrace();
		}
	}

	private static void addMods(JarEntry entry) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		String entryName = entry.getName();
		
		if (entryName.endsWith("class")) {
			Class<?> clazz = Class.forName(entryName.replace(".class", "").replace("/", "."));
			
			if (clazz.getSuperclass().equals(Mod.class)) {
				Mod mod = createInstance(clazz);
				
				isMod = true;
				
				if (mod != null) {
					ModInfo info = mod.getModInfo();
				
					System.out.println("Loading " + info.modName());
				
					loadedMods.add(mod);
				}
			}
		}
	}
	
	//Mods must have a zero args constructor
	private static Mod createInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		for (Constructor<?> constructor : clazz.getConstructors()) {
			if (constructor.getParameterCount() == 0) {
				return (Mod) constructor.newInstance();
			} else {
				System.out.println(clazz.getName() + " must have a constuctor with no args");
			}
		}
		
		return null;
	}
	
	private static void initializeMods() {
		if (Utils.directory != null) {
			PreInitializer preInit = new PreInitializer(loadedMods);
			
			loadedMods.forEach(mod -> mod.preInitializer(preInit));
		}
	}
}
