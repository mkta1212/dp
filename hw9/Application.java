import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Application {
    private Map<String,Data> dataMap;
    private Set<DisplayObject> displayObjects;

    public Application(){
        dataMap = new LinkedHashMap<String, Data>();
        displayObjects = new LinkedHashSet<DisplayObject>();
    }

    public void addData(Data data){
        dataMap.put(data.getItem(),data);
    }

    public void addDisplayObject(DisplayObject object){
        displayObjects.add(object);
    }

    public void present(){
        for(DisplayObject object: displayObjects){
            object.depict(dataMap);
        }
    }

    public void update(){
        present();
    }
}
