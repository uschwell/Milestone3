import java.util.*;
class MyNotifier extends Observable {
    public synchronized void setChanged() {
        super.setChanged();
    }
    public synchronized void notifyObservers(Object args){
        System.out.println(args);
    }
}
