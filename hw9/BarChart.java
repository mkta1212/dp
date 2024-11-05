import java.util.Map;

public class BarChart extends DisplayObject{
    public BarChart(){
        super();
    }
    public BarChart(Application app){
        super(app);
    }

    @Override
    public void depict(Map<String, Data> dataMap){
        for(Data data: dataMap.values()){
            String output = "";
            for(int i=0; i<data.getValue(); i++){
                output += "=";
            }
            output += " ";
            output += data.getItem();
            System.out.println(output);
        }
    }
}
