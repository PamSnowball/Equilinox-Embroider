package snowball.embroider.util.component;

import java.util.ArrayList;
import java.util.List;

import snowball.utils.Utils;

public class Death {
	public static class FadeDeath implements IDeath {
		float fadeTime;
			
		public FadeDeath(float fadeTime) {
			this.fadeTime = fadeTime;
		}

		public void death(List<String> death) {
			death.add(Utils.value("FADE_DEATH", fadeTime + ';'));
		}
	}
	
	public static class FallDeath implements IDeath {
		Particle particle;
		
		boolean hasParticleEffect;
		boolean useEntityColour;
		
		float explodeTime;
		float fallTime;
		float totalTime;
		float angle;
		
		int[] modelCount;
				
		public FallDeath(float fallTime, float totalTime, float fallAngle) {
			this.fallTime = fallTime;
			this.totalTime = totalTime;
			this.angle = fallAngle;
		}
		
		public FallDeath(float fallTime, float totalTime, float fallAngle, float explodeTime, 
				Particle particle, boolean useEntityColour) {
			this.fallTime = fallTime;
			this.totalTime = totalTime;
			this.angle = fallAngle;
			this.explodeTime = explodeTime;
			this.useEntityColour = useEntityColour;
			this.particle = particle;
		}
			
		public void death(List<String> component) {
			List<String> death = new ArrayList<>();
			
			death.add(Utils.value("FALL_DEATH", "fallTime", fallTime, "totalTime", totalTime, "fallAngle", angle));
			if (hasParticleEffect) {
				death.add(Utils.value("explodeTime", explodeTime, "useMaterial", useEntityColour ? 1 : 0));
				particle.deathPrint(death);
				death.add(Utils.value("Stages", modelCount.length));
				for (int model : modelCount) death.add(Utils.value(model));
			}
			
			Utils.append(death, component);
		}
	}
	
	public static class FloatDeath implements IDeath {
		float deathRot = 180;
		
		public FloatDeath() {}
		
		public FloatDeath(float deathRotation) {
			this.deathRot = deathRotation;
		}
			
		public void death(List<String> death) {
			death.add("FLOAT_DEATH;deathRot;" + deathRot + ';');
		}
	}

	public static class SpawnDeath implements IDeath {
		boolean growth;
		int min;
		int max;
		int id;
			
		public SpawnDeath(int entityId, int minCount, int maxCount, boolean growth) {
			this.growth = growth;
			this.min = minCount;
			this.max = maxCount;
			this.id = entityId;
		}
			
		public void death(List<String> death) {
			death.add(Utils.value(id, min, max, growth ? 1 : 0));
		}
	}
	
	public static class UpDownDeath implements IDeath {
		Particle particle;
		
		float speed;
		
		public UpDownDeath(float speed, Particle particle) {
			this.speed = speed;
			this.particle = particle;
		}
			
		public void death(List<String> component) {
			List<String> death = new ArrayList<>();
			
			death.add(Utils.value("UP_DOWN_DEATH", "speed", speed));
			particle.deathPrint(death);
			
			Utils.append(death, component);
		}
	}
	
	public static class ParticleDeath implements IDeath {
		Particle particle;
		
		public ParticleDeath(Particle particle) {
			this.particle = particle;
		}
		
		public void death(List<String> component) {
		 	List<String> death = new ArrayList<>();
			
			death.add("PARTICLE_DEATH;");
			particle.deathPrint(death);
			
			Utils.append(death, component);
		}
	}
}
