public class Detector {
	public void sendReaction(String action) {
		System.out.println(action);
	}

	public void detectObstacle(Obstacle ob) {
		switch (ob.getType()) {
			case PEDESTRIAN:
				if(ob.getDistance() > 500) {
					sendReaction("Slow down.");
				} else if(ob.getDistance() > 200) {
					sendReaction("Stop!");
				} else {
					sendReaction("Take evasive action!");
				}
				break;
		
			case VEHICLE:
				if(ob.getDistance() > 500) {
					sendReaction("Slow down.");
				} else if(ob.getDistance() > 200) {
					sendReaction("Stop!");
				} else {
					sendReaction("Take evasive action!");
				}
				break;
			
			case ANIMAL:
				if(ob.getSize() < 5) {
					sendReaction("Keep going.");
				} else if(ob.getDistance() > 500) {
					sendReaction("Slow down.");
					sendReaction("Keep going.");
				} else if(ob.getDistance() > 200) {
					sendReaction("Stop!");
				} else {
					sendReaction("Take evasive action!");
				}
				break;

			case TRAFFIC_CONE:
				sendReaction("Slow down.");
				sendReaction("Take evasive action!");
				break;

			case DEBRIS:
				if(ob.getSize() < 2) {
					sendReaction("Keep going.");
				} else if(ob.getDistance() > 500) {
					sendReaction("Slow down.");
					sendReaction("Keep going.");
				} else if(ob.getDistance() > 200) {
					sendReaction("Stop!");
				} else {
					sendReaction("Take evasive action!");
				}
				break;
		}
	}
}
