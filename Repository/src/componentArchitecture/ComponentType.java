package componentArchitecture;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import aiComponent.AiCompLoader;
import baseMovement.MovementCompLoader;
import beavers.BeaverCompLoader;
import beavers.WoodCompLoader;
import biomes.SpreaderCompLoader;
import birdHunt.BirdHuntCompLoader;
import blueprints.Blueprint;
import building.BuildCompLoader;
import building.BuilderCompLoader;
import building.DecomposeCompLoader;
import carnivorePlant.FlyTrapCompLoader;
import carnivorePlant.TongueShootCompLoader;
import components.CustomInformationCompLoader;
import components.InformationComponent;
import components.LilyComponent;
import components.NameComponent;
import eating.EatingCompLoader;
import equipping.EquipCompLoader;
import equipping.ItemCompLoader;
import fighting.FightCompLoader;
import fighting.HostileCompLoader;
import fishHunt.FishHuntCompLoader;
import flinging.FlingingCompLoader;
import food.FoodCompLoader;
import fruit.DecayCompLoader;
import fruit.FruitFallLoader;
import fruit.FruiterCompLoader;
import growth.GrowthCompLoader;
import healer.HealerCompLoader;
import health.LifeCompLoader;
import hiveComponents.BeeCompLoader;
import hiveComponents.HiveCompLoader;
import hunting.FleeCompLoader;
import hunting.HuntCompLoader;
import loot.DropCompLoader;
import materials.MaterialComponent;
import meerkats.BurrowCompLoader;
import meerkats.TimeOutCompLoader;
import monkeys.ClingCompLoader;
import monkeys.TreeSwingCompLoader;
import nesting.NestingCompLoader;
import nightBloom.BloomCompLoader;
import panic.PanicCompLoader;
import particleComponent.ParticleCompLoader;
import peacock.PeacockCompLoader;
import perching.PerchCompLoader;
import perching.PercherCompLoader;
import simpleAnimations.AnimationCompLoader;
import sleeping.SleepCompLoader;
import snowball.embroider.component.blueprint.CustomComponentType;
import snowball.utils.Utils;
import sound.RandomSounderLoader;
import sound.SoundCompLoader;
import sound.SoundLooperLoader;
import spitting.ProjectileCompLoader;
import spitting.SpitCompLoader;
import stinging.StingingCompLoader;
import sunFacer.SunFaceCompLoader;
import toolbox.Transformation;
import treeCharging.TreeChargeCompLoader;
import utils.CSVReader;

public class ComponentType {
	public static final ComponentType TRANSFORM = new ComponentType((ComponentLoader)new Transformation.TransformLoader(), false, false);
	public static final ComponentType MESH = new ComponentType(null, false, false);
	public static final ComponentType MATERIAL = new ComponentType((ComponentLoader)new MaterialComponent.MaterialCompLoader(), false, false);
	public static final ComponentType SOUND = new ComponentType((ComponentLoader)new SoundCompLoader(), false, true);
	public static final ComponentType NAME = new ComponentType((ComponentLoader)new NameComponent.NameCompLoader(), false, false);
	public static final ComponentType INFO = new ComponentType((ComponentLoader)new InformationComponent.InformationCompLoader(), false, false);
	public static final ComponentType CUSTOM_INFO = new ComponentType((ComponentLoader)new CustomInformationCompLoader(), false, false);
	public static final ComponentType LIFE = new ComponentType((ComponentLoader)new LifeCompLoader(), false, true);
	public static final ComponentType ANIMATION = new ComponentType((ComponentLoader)new AnimationCompLoader(), true, true);
	public static final ComponentType PARTICLES = new ComponentType((ComponentLoader)new ParticleCompLoader(), false, true);
	public static final ComponentType HEALER = new ComponentType((ComponentLoader)new HealerCompLoader(), false, false);
	public static final ComponentType SPREADER = new ComponentType((ComponentLoader)new SpreaderCompLoader(), false, false);
	public static final ComponentType MOVEMENT = new ComponentType((ComponentLoader)new MovementCompLoader(), true, true);
	public static final ComponentType AI = new ComponentType((ComponentLoader)new AiCompLoader(), false, true);
	public static final ComponentType EATING = new ComponentType((ComponentLoader)new EatingCompLoader(), false, true);
	public static final ComponentType FOOD = new ComponentType((ComponentLoader)new FoodCompLoader(), false, false);
	public static final ComponentType FRUITER = new ComponentType((ComponentLoader)new FruiterCompLoader(), false, true);
	public static final ComponentType GROWTH = new ComponentType((ComponentLoader)new GrowthCompLoader(), false, true);
	public static final ComponentType LILY = new ComponentType((ComponentLoader)new LilyComponent.LilyCompLoader(), true, true);
	public static final ComponentType RANDOM_SOUNDER = new ComponentType((ComponentLoader)new RandomSounderLoader(), false, true);
	public static final ComponentType FLEE = new ComponentType((ComponentLoader)new FleeCompLoader(), true, false);
	public static final ComponentType FRUIT_FALL = new ComponentType((ComponentLoader)new FruitFallLoader(), false, true);
	public static final ComponentType DECAY = new ComponentType((ComponentLoader)new DecayCompLoader(), true, true);
	public static final ComponentType BUILD = new ComponentType((ComponentLoader)new BuildCompLoader(), false, false);
	public static final ComponentType BUILDER = new ComponentType((ComponentLoader)new BuilderCompLoader(), false, true);
	public static final ComponentType HIVE = new ComponentType((ComponentLoader)new HiveCompLoader(), false, true);
	public static final ComponentType PERCH = new ComponentType((ComponentLoader)new PerchCompLoader(), false, false);
	public static final ComponentType BEAVER = new ComponentType((ComponentLoader)new BeaverCompLoader(), true, true);
	public static final ComponentType EQUIP = new ComponentType((ComponentLoader)new EquipCompLoader(), false, true);
	public static final ComponentType WOOD = new ComponentType((ComponentLoader)new WoodCompLoader(), false, false);
	public static final ComponentType SLEEP = new ComponentType((ComponentLoader)new SleepCompLoader(), true, true);
	public static final ComponentType CHARGE = new ComponentType((ComponentLoader)new TreeChargeCompLoader(), true, true);
	public static final ComponentType PANIC = new ComponentType((ComponentLoader)new PanicCompLoader(), true, true);
	public static final ComponentType HUNT = new ComponentType((ComponentLoader)new HuntCompLoader(), true, true);
	public static final ComponentType FIGHT = new ComponentType((ComponentLoader)new FightCompLoader(), true, false);
	public static final ComponentType DROP = new ComponentType((ComponentLoader)new DropCompLoader(), false, false);
	public static final ComponentType ITEM = new ComponentType((ComponentLoader)new ItemCompLoader(), true, true);
	public static final ComponentType NESTING = new ComponentType((ComponentLoader)new NestingCompLoader(), false, false);
	public static final ComponentType DECOMPOSE = new ComponentType((ComponentLoader)new DecomposeCompLoader(), false, true);
	public static final ComponentType PERCHER = new ComponentType((ComponentLoader)new PercherCompLoader(), false, false);
	public static final ComponentType FLINGING = new ComponentType((ComponentLoader)new FlingingCompLoader(), true, true);
	public static final ComponentType CLING = new ComponentType((ComponentLoader)new ClingCompLoader(), true, true);
	public static final ComponentType TREE_SWING = new ComponentType((ComponentLoader)new TreeSwingCompLoader(), true, true);
	public static final ComponentType HOSTILE = new ComponentType((ComponentLoader)new HostileCompLoader(), true, true);
	public static final ComponentType BEE = new ComponentType((ComponentLoader)new BeeCompLoader(), false, false);
	public static final ComponentType FISH_HUNT = new ComponentType((ComponentLoader)new FishHuntCompLoader(), true, true);
	public static final ComponentType PEACOCK = new ComponentType((ComponentLoader)new PeacockCompLoader(), true, true);
	public static final ComponentType SOUND_LOOPER = new ComponentType((ComponentLoader)new SoundLooperLoader(), false, true);
	public static final ComponentType SUN_FACER = new ComponentType((ComponentLoader)new SunFaceCompLoader(), true, true);
	public static final ComponentType SPITTING = new ComponentType((ComponentLoader)new SpitCompLoader(), true, true);
	public static final ComponentType PROJECTILE = new ComponentType((ComponentLoader)new ProjectileCompLoader(), true, true);
	public static final ComponentType STINGING = new ComponentType((ComponentLoader)new StingingCompLoader(), true, true);
	public static final ComponentType BLOOM = new ComponentType((ComponentLoader)new BloomCompLoader(), false, true);
	public static final ComponentType BIRD_HUNT = new ComponentType((ComponentLoader)new BirdHuntCompLoader(), true, true);
	public static final ComponentType TONGUE_SHOOT = new ComponentType((ComponentLoader)new TongueShootCompLoader(), true, true);
	public static final ComponentType FLY_TRAP = new ComponentType((ComponentLoader)new FlyTrapCompLoader(), false, true);
	public static final ComponentType BURROW = new ComponentType((ComponentLoader)new BurrowCompLoader(), true, true);
	public static final ComponentType TIME_OUT = new ComponentType((ComponentLoader)new TimeOutCompLoader(), false, true);
	
	private static List<Field> fields = new ArrayList<>();
	private static List<ComponentType> types;
	
	private ComponentLoader loader;
	
	private boolean dynamic;
	private boolean active;
	
	private String constantName;
	
	private ComponentType(ComponentLoader loader, boolean dynamic, boolean active) {
		this.constantName = this.getClass().getTypeName().toUpperCase();
		this.dynamic = dynamic;
		this.active = active;
		this.loader = loader;
		types.add(this);
	}
	
	public ComponentType(CustomComponentType type, ComponentLoader loader, boolean dynamic, boolean active) {
		Field[] fieldArray = type.getClass().getDeclaredFields();
		List<Field> fieldList = new ArrayList<>();
		for (Field field : fieldArray) {
			int modifiers = field.getModifiers();
			if (Utils.checkUpperCase(field.getName()) && Modifier.isStatic(modifiers) &&
					Modifier.isPrivate(modifiers) && Modifier.isFinal(modifiers)) {
				fieldList.add(field);
			}
		}
		
		ComponentType.fields.add(fieldList.get(0));
		this.constantName = fieldList.get(0).getName();
		
		new ComponentType(loader, dynamic, active);
	}
	
	protected ComponentType() {}
	
	public ComponentBlueprint loadComponent(CSVReader reader, Blueprint blueprint) {
		return this.loader.load(reader, blueprint);
	}
	
	public Requirement loadRequirement(CSVReader reader) {
		 return this.loader.loadRequirement(reader);
	}
	
	protected boolean isDynamic() {
		return this.dynamic;
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public static ComponentType valueOf(String s) {
		ComponentType type = null;
		
		Field[] fields = Stream.concat(Arrays.stream(ComponentType.class.getDeclaredFields()),
			Arrays.stream(ComponentType.fields.toArray())).toArray(Field[]::new);
		try {
			for (Field field : fields) {
				int modifiers = field.getModifiers();
				if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) &&
						ComponentType.class.isAssignableFrom(field.getClass()) && field.getName().equals(s))
					type = (ComponentType) field.get(ComponentType.class);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return type;
	}
	
	public static ComponentType getType(int id) {
		return types.get(id);
	}
	
	@Override
	public String toString() {
		return constantName;
	}
}
