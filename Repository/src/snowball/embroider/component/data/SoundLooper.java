package snowball.embroider.component.data;

import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.embroider.enumerator.sound.ISound;
import snowball.utils.Utils;

public class SoundLooper implements IComponent {
	ISound sound;
	
	float volume;
	float range;
	
	public SoundLooper(ISound sound, float range, float volume) {
		this.volume = volume;
		this.range = range;
		this.sound = sound;
	}
	
	@Override
	public void load(List<String> loader) {
		sound.loadSound().loadSound();
		loader.add(Utils.value("SOUND_LOOPER;sound", sound.getSound(), "range", range, "volume", volume));
	}
	
	@Override
	public int getId() {
		return 35;
	}
}
