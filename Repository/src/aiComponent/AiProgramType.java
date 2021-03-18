package aiComponent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import ai.BeeAiBlueprint;
import ai.DolphinAiBlueprint;
import ai.MeerkatAi;
import ai.PatrolAiBlueprint;
import ai.PatrolWithSwimAi;
import ai.SwimAiBlueprint;
import ai.TortoiseAi;
import ai.WalkingBirdAiBlueprint;
import birds.BirdAiBlueprint;
import utils.CSVReader;

public abstract class AiProgramType {
	public static final AiProgramType PATROL = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new PatrolAiBlueprint();
		}
	};
	public static final AiProgramType SWIM = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new SwimAiBlueprint();
		}
	};
	public static final AiProgramType BIRD = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new BirdAiBlueprint();
		}
	};
	public static final AiProgramType WALKING_BIRD = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new WalkingBirdAiBlueprint();
		}
	};
	public static final AiProgramType BEE = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new BeeAiBlueprint();
		}
	};
	public static final AiProgramType PATROL_WITH_SWIM = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new PatrolWithSwimAi();
		}
	};
	public static final AiProgramType TORTOISE = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new TortoiseAi();
		}
	};
	public static final AiProgramType MEERKAT = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new MeerkatAi();
		}
	};
	public static final AiProgramType DOLPHIN = new AiProgramType() {
		protected AiProgramBlueprint createProgramBlueprint() {
			return new DolphinAiBlueprint();
		}	
	};
	
	public static List<AiProgramBlueprint> customAis = new ArrayList<>();
	
	public static AiProgramType valueOf(String s) {
		AiProgramType type = null;
		
		List<Field> customFields = new ArrayList<>();
		
		customAis.forEach(ai -> customFields.add(ai.getClass().getDeclaredFields()[0]));
		
		Field[] fields = Stream.concat(Arrays.stream(AiProgramType.class.getDeclaredFields()), 
			Arrays.stream(AiProgramType.customAis.toArray())).toArray(Field[]::new);
		try {
			for (Field field : fields) {
				int modifiers = field.getModifiers();
				if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && 
						field.getClass().isAssignableFrom(AiProgramType.class) && field.getName().equals(s))
					type = (AiProgramType) field.get(AiProgramType.class);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return type;
	}
	
	public AiProgramBlueprint loadProgramBlueprint(CSVReader reader) {
		AiProgramBlueprint program = createProgramBlueprint();
		program.loadSettings(reader);
		return program;
	}
  
	protected abstract AiProgramBlueprint createProgramBlueprint();
}
