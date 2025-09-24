public class Heartbeat {
    String heart = "thump";

    public void changeHeart(String word){
        this.heart = word;
    }

    public boolean isAlive() {
        if (heart.equals("thump"))
            return true;
        return false; 
    }

    public static void main (String [] args) { 

    }

}
