import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.*;
public class Main {
    public static void main(String[] args){
        try{
            String inputFile = args[0];
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File xmlFile = new File(inputFile);
            Document document = builder.parse(xmlFile);
            Element root = document.getDocumentElement();
            Composite tree = (Composite)traverseNodes(root);
            for(Component component: tree.getComponents()){
                System.out.println(component.draw());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private static Component traverseNodes(Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element)node;
            String tagName = element.getTagName();
            Component component;
            if(tagName == "Question"){
                component = new Composite();
            }
            else if(tagName == "Group"){
                component = new Composite();
            }
            else if(tagName == "Line"){
                component = new Line();
            }
            else if(tagName == "Text"){
                component = new Text();
            }
            else if(tagName == "Rectangle"){
                component = new Rectangle();
            }
            else{
                component = null;
            }
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Component components = traverseNodes(childNodes.item(i));
                if(components != null){
                    component.addComponent(components);
                }
            }
            return component;
        }
        return null;
       
    }
}
