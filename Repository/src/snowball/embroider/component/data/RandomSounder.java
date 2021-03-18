package snowball.embroider.component.data;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.ModelConverter;
import snowball.embroider.component.utils.IComponent;
import snowball.embroider.enumerator.sound.ISound;
import snowball.utils.Utils;

public class RandomSounder implements IComponent {
	ISound[] sounds;

	float[] ranges;

	float volume = 0;
	float random = 0;
	float time = 0;
	
	int stage = 0;
	
	public RandomSounder(float waitTime, float random, ISound[] sounds, float[] ranges) {
		for (ISound sound : sounds) sound.loadSound().loadSound();
		
		if (waitTime + random > 0) {
			this.time = waitTime;
			this.random = random;
		}
		
		if (sounds.length > 0) this.sounds = sounds;
		if (ranges.length > 0) this.ranges = ranges;
	}
	
	public RandomSounder(float waitTime, float random, ISound[] sounds, float[] ranges, int stageRequirement) {
		for (ISound sound : sounds) sound.loadSound().loadSound();
		
		if (waitTime + random > 0) {
			this.time = waitTime;
			this.random = random;
		}
		
		if (stageRequirement > 0) this.stage = stageRequirement;
		if (sounds.length > 0) this.sounds = sounds;
		if (ranges.length > 0) this.ranges = ranges;
	}
	
	public RandomSounder(float waitTime, float random, ISound[] sounds, float[] ranges, int stageRequirement, float volume) {
		for (ISound sound : sounds) sound.loadSound().loadSound();
		
		if (waitTime + random > 0) {
			this.time = waitTime;
			this.random = random;
		}
		
		if (stageRequirement > 0) this.stage = stageRequirement;
		if (sounds.length > 0) this.sounds = sounds;
		if (ranges.length > 0) this.ranges = ranges;
		if (volume > 0.1F) this.volume = volume;
	}
	
	public void load(List<String> loader) {
		if (ranges != null || sounds != null) {
			List<String> sounder = new ArrayList<>();
		
			sounder.add(Utils.value("RANDOM_SOUNDER", time, random, sounds.length));
		
			if (ranges.length < sounds.length) {
				Utils.print("Entity " + ModelConverter.getCurrentlyConvertingEntity().getName() + " has more sounds than ranges");
			} else {
				if (ranges.length > sounds.length) {
					Utils.print("Entity " + ModelConverter.getCurrentlyConvertingEntity().getName() + " has more ranges than sounds");
				}
				
				for (int i = 0; i < sounds.length; i++) {
					sounder.add(sounds[i].getSound()  + ';');
					sounder.add(ranges[i] + ";");
				}
			}
		
			if (volume != 0) sounder.add(volume + ";");
			if (stage != 0) sounder.add(stage + ";");
			
			Utils.append(sounder, loader);
		}
	}

	@Override
	public int getId() {
		return 2;
	}
}
