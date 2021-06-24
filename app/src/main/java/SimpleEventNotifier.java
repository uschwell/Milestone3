import java.util.Observable;
import java.util.Observer;

public class SimpleEventNotifier{

    public static void main(String[]args){
        MyNotifier my = new MyNotifier();
        my.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
            }
        });
        my.setChanged();
        Object arg = "Event has Occured";
        my.notifyObservers(arg);
    }
}
