import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> components;

    public Composite(){
        components = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getComponents(){
        return components;
    }

    @Override
    public String draw() {
        String output = "Group:{%s}";
        if (components.size()==0){
            return String.format(output, "");
        }
        else{
            String childern = "";
            for(Component component: components){
                childern += component.draw()+" ";
            }
            return String.format(output, childern);
        }
        

    }
    
}
