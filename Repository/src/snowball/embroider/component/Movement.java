package snowball.embroider.component;

import java.util.ArrayList;
import java.util.List;

import snowball.embroider.component.utils.IComponent;
import snowball.utils.Utils;

public class Movement {
	private static final String S = "speed";
	private static final String B = "bounce";
	private static final String H = "height";
	private static final String R = "rotSpeed";
	private static final String M = "MOVEMENT";
	
	public static class BaseMovement implements IComponent {
		float speed;
		float bouncePower;
		int id;
		
		public BaseMovement(float speed, float bounce, int id) {
			this.speed = speed;
			this.bouncePower = bounce;
			this.id = id;
		}

		@Override
		public void load(List<String> move) {
			move.add(M + ';' + id + ';');
		}
		
		@Override
		public int getId() {
			return 38;
		}
	}
	
	public static class FrogMovement extends BaseMovement {
		float waitTime;
		float bounciness;
		
		public FrogMovement(float speed, float bounce, float wait, float bounciness) {
			super(speed, bounce, 6);
			this.waitTime = wait;
			this.bounciness = bounciness;
		}
		
		@Override
		public void load(List<String> component) {
			List<String> move = new ArrayList<>();
			
			super.load(move);
			move.add(Utils.value(S, speed, B, bouncePower, "wait", waitTime, "bounciness", bounciness));
			
			Utils.append(move, component);
		}
	}
	
	public static class RabbitMovement extends BaseMovement {
		float upRotSpeed;
		float downRotSpeed;
		float front0;
		float front1;
		float back0;
		float back1;
		
		public RabbitMovement(float speed, float bounce, float upRot, float downRot, float front0, float front1, float back0, float back1) {
			super(speed, bounce, 7);
			this.upRotSpeed = upRot;
			this.downRotSpeed = downRot;
			this.front0 = front0;
			this.front1 = front1;
			this.back0 = back0;
			this.back1 = back1;
		}

		@Override
		public void load(List<String> component) {
			List<String> move = new ArrayList<>();
			
			super.load(move);
			move.add(Utils.value(S, speed, B, bouncePower, "upRot", upRotSpeed, "downRot", downRotSpeed));
			move.add(Utils.value("frontZ", 2, front0, front1, "backZ", 2, back0, back1));
			
			Utils.append(move, component);
		}
	}
	
	public static class FlouncerMovement extends BaseMovement {
		float rotationSpeed;
		float bounceRotation;
		float height;
		
		public FlouncerMovement(float speed, float rotSpeed, float bounce, float bounceRot, float height) {
			super(speed, bounce, 8);
			this.rotationSpeed = rotSpeed;
			this.bounceRotation = bounceRot;
			this.height = height;
		}

		@Override
		public void load(List<String> component) {
			List<String> move = new ArrayList<>();
			
			super.load(move);
			move.add(Utils.value(S, speed, R, rotationSpeed, B, bouncePower, "bounceRot", bounceRotation, H, height));

			Utils.append(move, component);
		}
	}
	
	public static class BaseWalkingMovement implements IComponent {
		float speed;
		int xRot;
		float minRot;
		float maxRot;
		float rotationSpeed;
		int id;
		
		public BaseWalkingMovement(float speed, int xRot, float minRot, float maxRot, float rotSpeed) {
			this.speed = speed;
			this.xRot = xRot;
			this.minRot = minRot;
			this.maxRot = maxRot;
			this.rotationSpeed = rotSpeed;
		}
		
		@Override
		public void load(List<String> move) {
			move.add(Utils.value(M, 9, S, speed, "xRot", xRot, "minRot", minRot, "maxRot", maxRot, R, rotationSpeed));
		}
		
		@Override
		public int getId() {
			return 38;
		}
	}
	
	public static class SwimmerMovement extends BaseWalkingMovement {
		boolean eggStage;
		
		float swimHeight;
		float swimFactor;
		
		float swimInnertia = 0.25F;
		
		public SwimmerMovement(float speed, int xRot, float minRot, float maxRot, float rotSpeed, float height, boolean hasEgg, float swimFactor) {
			super(speed, xRot, minRot, maxRot, rotSpeed);
			this.swimHeight = height;
			this.eggStage = hasEgg;
			this.swimFactor = swimFactor;
		}
		
		public IComponent setInertia(float innertia) {
			this.swimInnertia = innertia;
			return this;
		}
		
		@Override
		public void load(List<String> component) {
			List<String> move = new ArrayList<>();
			
			super.load(move);
			move.add(Utils.value(H, swimHeight, "hasEgg", (eggStage ? 1 : 0), "swimFactor", swimFactor, "swimInnertia" + swimInnertia));

			Utils.append(move, component);
		}
	}
	
	public static class ButterflyMovement {
		public void load(List<String> move) {
			move.add(M + ';' + 10);
		}
	}
	
	public static class BeeMovement {
		float height;
		
		public BeeMovement(float height) {
			this.height = height;
		}
		
		public void load(List<String> move) {
			move.add(Utils.value(M, 11, H, height));
		}
	}
	
	public static class FlyingBirdMovement {
		private final float glideDown;
		
		public FlyingBirdMovement(float glideDown) {
			this.glideDown = glideDown;
		}
		
		public FlyingBirdMovement() {
			this.glideDown = -0.6F;
		}
		
		public void load(List<String> component) {
			List<String> move = new ArrayList<>();
			
			move.add(M + ';' + 11);
			if (glideDown != -0.6F) move.add("glideDown" + glideDown);

			Utils.append(move, component);
		}
	}
	
	public static class GallopMovement extends BaseMovement {
		float upRotSpeed;
		float gravityFactor;
		float front0;
		float front1;
		float back0;
		float back1;
		
		public GallopMovement(float speed, float bounce, float upRot, float gravFactor, float front0, float front1, float back0, float back1) {
			super(speed, bounce, 13);
			this.upRotSpeed = upRot;
			this.gravityFactor = gravFactor;
			this.front0 = front0;
			this.front1 = front1;
			this.back0 = back0;
			this.back1 = back1;
		}

		@Override
		public void load(List<String> component) {
			List<String> move = new ArrayList<>();
			
			move.add(Utils.value(S, speed, B, bouncePower, "upRot", upRotSpeed, "gravFactor", gravityFactor));
			move.add(Utils.value("frontZ", 2, front0, front1, "backZ", 2, back0, back1));

			Utils.append(move, component);
		}
	}
	
	public static class SheepMovement extends BaseMovement {
		float rotationSpeed;
		
		public SheepMovement(float speed, float bounce, float rotSpeed) {
			super(speed, bounce, 14);
			this.rotationSpeed = rotSpeed;
		}

		@Override
		public void load(List<String> move) {
			move.add(Utils.value(S, speed, R, rotationSpeed, B, bouncePower));
		}
	}
	
	public static class WaddleMovement extends SheepMovement {
		BaseMovement movement;
		
		public WaddleMovement(float speed, float bounce, float rotSpeed) {
			super(speed, bounce, rotSpeed);
		}
		
		@Override
		public void load(List<String> move) {
			move.add(Utils.value(M, 15, S, speed, R, rotationSpeed, B, bouncePower));
		}
	}
	
	public static class JellyfishMovement implements IComponent {
		@Override
		public void load(List<String> move) {
			move.add(M + ';' + 21);
		}
		
		@Override
		public int getId() {
			return 38;
		}
	}
	
	public static class DolphinMovement extends BaseWalkingMovement {
		public DolphinMovement(float speed, int xRot, float minRot, float maxRot, float rotSpeed) {
			super(speed, xRot, minRot, maxRot, rotSpeed);
			this.id = 45;
		}
	}
}
