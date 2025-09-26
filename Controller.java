public class Controller {
    
    public static void Receiver(String status) { // detects failures, obstacles etc.
        if (status.equals("Critical error"))
            System.exit(-1); // or maybe a fix instead of exiting prgram?? 
        System.out.println("Operating as normal...");
    }

    public static void main(String [] args) { 
        Heartbeat heart = new Heartbeat();
        Monitor monitor = new Monitor(); 
        Detector detector = new Detector();
        ObstacleSpawner spawner = new ObstacleSpawner();
        while (true) { 
            Controller.Receiver(monitor.checksHeart(heart));
            spawner.flood(detector);
        }

    }

}
