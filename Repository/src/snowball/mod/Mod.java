package snowball.mod;

import java.io.File;

import snowball.mod.load.PreInitializer;
import snowball.utils.Utils;

public interface Mod {
	public void preInitializer(PreInitializer preInit);
	
	default ModInfo getModInfo() {
		return this.getClass().getDeclaredAnnotation(ModInfo.class);
	}
	
	public static File parseFile(Mod mod) {
		return new File(Utils.getClassPath(mod.getClass()));
	}
}
