public class Controller {
    
    public static void main(String [] args) { 
        Heartbeat heart = new Heartbeat();
        Monitor monitor = new Monitor(); 

        while (true) { 
            monitor.checksHeart(heart);
        }
    }

}
