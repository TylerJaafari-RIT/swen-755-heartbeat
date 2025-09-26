import java.util.Random;

public class ObstacleSpawner {
	public Obstacle randomObstacle() {
		Random rng = new Random();

		ObstacleType t = ObstacleType.values()[rng.nextInt(ObstacleType.values().length)];
		double distance = rng.nextDouble() * 1000;
		double size = rng.nextDouble() * 10;

		return new Obstacle(t, distance, size);
	}

	public void sendObstacle(Obstacle ob, Detector detector) {
		detector.detectObstacle(ob);
	}

	public void flood(Detector detector) {
		int mobSize = 1000;
		Obstacle [] mob = new Obstacle[mobSize];

		for(int i = 0; i < mobSize; i++) {
			mob[i] = randomObstacle();
		}

		for(int i = 0; i < mobSize; i++) {
			sendObstacle(mob[i], detector);
		}
	}
}
