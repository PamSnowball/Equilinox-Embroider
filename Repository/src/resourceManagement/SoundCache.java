package resourceManagement;

import audio.Sound;
import audio.SoundMaestro;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import utils.MyFile;

public class SoundCache {
	public static final SoundCache CACHE = new SoundCache();

	private Map<String, CachedSound> cachedSounds = new HashMap<>();
	
	public synchronized Sound requestSound(String id, boolean loadNow) {
		return requestSound(id, loadNow, false);
	}
	
	public synchronized Sound requestSound(String id, boolean loadNow, boolean oggFile) {
		CachedSound cachedSound = this.cachedSounds.get(id);
		if (cachedSound == null) return loadNewSound(id, loadNow, oggFile); 
		cachedSound.timesUsed = cachedSound.timesUsed + 1;
		return cachedSound.sound;
	}
	
	public synchronized Sound requestSound(String id, InputStream stream) {
		CachedSound sound = this.cachedSounds.get(id);
		if (sound == null) {
			return loadCustomSound(id, stream);
		}
		
	    sound.timesUsed += 1;
	    return sound.sound;
	}
	
	private Sound loadCustomSound(String name, InputStream stream) {
		Sound sound = Sound.loadSoundNow(new MyFile(stream, name));
		CachedSound cachedSound = new CachedSound(sound);
		this.cachedSounds.put(name, cachedSound);
		return sound;
	}

	public void releaseSound(Sound sound) {
		CachedSound cachedSound = this.cachedSounds.get(sound.getId());
		cachedSound.timesUsed = cachedSound.timesUsed - 1;
		if (cachedSound.timesUsed == 0) removeSoundFromCache(sound.getId()); 
	}
	
	private Sound loadNewSound(String id, boolean loadNow, boolean oggFile) {
		Sound sound;
		String ext = oggFile ? ".ogg" : ".wav";
		if (!loadNow) {
			sound = Sound.loadSoundInBackground(new MyFile(SoundMaestro.SOUND_FOLDER, String.valueOf(id) + ext));
		} else {
			sound = Sound.loadSoundNow(new MyFile(SoundMaestro.SOUND_FOLDER, String.valueOf(id) + ext));
		} 
		CachedSound cachedSound = new CachedSound(sound);
		this.cachedSounds.put(id, cachedSound);
		return sound;
	}
	
	private void removeSoundFromCache(String id) {
		CachedSound cachedSound = this.cachedSounds.remove(id);
		cachedSound.sound.delete();
	}
	
	private static class CachedSound {
		private int timesUsed = 1;
		
		private Sound sound;
		
		private CachedSound(Sound sound) {
			this.sound = sound;
		}
	}
}
