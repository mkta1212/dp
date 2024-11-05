import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws Exception{
        if (args.length != 1) {
            System.out.println("Input Error");
            return;
        }
        String inputFile = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        String line;
        Application app = new Application();
        Map<String, DisplayObject> availableObject = new HashMap<String, DisplayObject>();
        availableObject.put("Spreadsheet", new SpreadSheet());
        availableObject.put("BarChart", new BarChart());
        availableObject.put("PieChart", new PieChart());
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            String command = line.split(" ")[0];
            if(command.equals("data")){
                String item = line.split(" ")[1];
                int value = Integer.parseInt(line.split(" ")[2]);
                Data data = new Data(item, value);
                app.addData(data);
            }
            else if(command.equals("addChart")){
                String chart = line.split(" ")[1];
                DisplayObject object = availableObject.get(chart);
                object.registerObserver(app);
                app.addDisplayObject(object);
            }
            else if(command.equals("change")){
                String chart = line.split(" ")[1];
                String item = line.split(" ")[2];
                int value = Integer.parseInt(line.split(" ")[3]);
                Data data = new Data(item, value);
                app.addData(data);
                System.out.println(String.format("%s change %s %d.", chart, item, value));
                DisplayObject object = availableObject.get(chart);
                object.change();
                
            }
        }
        reader.close();
    }
}