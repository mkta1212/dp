import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class DisplayObject {
    private List<Application> observers;
    
    public DisplayObject(){
        observers = new ArrayList<Application>();
    }
    public DisplayObject(Application app){
        observers = new ArrayList<Application>();
        this.observers.add(app);
    }

    public void registerObserver(Application app){
        observers.add(app);
    }

    public void depict(Map<String, Data> dataMap){

    }

    public void change(){
        for(Application observer: observers){
            observer.update();
        }
    }

}
