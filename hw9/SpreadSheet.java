import java.util.Map;

public class SpreadSheet extends DisplayObject{
    public SpreadSheet(){
        super();
    }
    public SpreadSheet(Application app){
        super(app);
    }

    @Override
    public void depict(Map<String, Data> dataMap){
        for(Data data: dataMap.values()){
            String output = data.getItem();
            output += " ";
            output +=  data.getValue();
            System.out.println(output);
        } 
    }
}