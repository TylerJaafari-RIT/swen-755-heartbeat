import java.util.Random;
public class Monitor {  
    private Random RNG = new Random();

    public String checksHeart(Heartbeat heart) {
        final int TIMEOUT_MS = 5000; // 5 seconds
        boolean alive = heart.isAlive();
        if (RNG.nextDouble() < 0.25) { // 25% chance of failure
            int delay = RNG.nextInt(TIMEOUT_MS); // System.out.println("Simulating delay of " + delay + " ms");
            long start = System.currentTimeMillis();
            long duration = 0;
            while (duration < delay && alive) { // busy-wait loop
                duration = System.currentTimeMillis() - start;
            } 
            if (duration > delay) {
                System.out.println("Critical error! Heartbeat not detected within 5 secs");
                return "Critical error";
            }
            System.out.println("Heartbeat received in " + duration + " ms");
        }
        return "normal";
    }

}
