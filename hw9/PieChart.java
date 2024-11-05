import java.util.Map;


public class PieChart extends DisplayObject{
    public PieChart(){
        super();
    }
    public PieChart(Application app){
        super(app);
    }

    @Override
    public void depict(Map<String, Data> dataMap){
        int sum = 0;
        for(Data data: dataMap.values()){
            sum += data.getValue();
        }
        for(Data data: dataMap.values()){
            String output = data.getItem();
            output += " ";
            output += Math.round(1000*data.getValue()/sum)/10.0;
            output += "%";
            System.out.println(output);
        } 
    }
}
