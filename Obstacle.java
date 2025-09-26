public class Obstacle {
	private ObstacleType type;
	private double distance; // in feet
	private double size; // in approximate square feet.

	public ObstacleType getType() {	return type; }
	public double getDistance() { return distance; }
	public double getSize() { return size; }

	public Obstacle(ObstacleType type, double distance, double size) {
		this.type = type;
		this.distance = distance;
		this.size = size;
	}
}
