/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.IOException;
import java.util.Stack;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import static saxparser.FXMLDocumentController.file;

/**
 *
 * @author extre
 */
public class DOMBuilder {
    private static int level = 0;
   
    
    public static void buildDom(Pane DOMbox){
        
        TreeItem<String> root = new TreeItem<>("DOM");
        root.setExpanded(true);
        TreeView<String> treeView = new TreeView<>(root);
        DOMbox.getChildren().add(treeView);
    
        Stack<TreeItem> stack = new Stack();
        stack.push(root);
        
        //System.out.println(stack.peek().getClass());
        
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            SAXParser saxParser = factory.newSAXParser();

            
            DefaultHandler handler = new DefaultHandler() {
                
                @Override
                public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
                    
                    TreeItem node = new TreeItem<>(qName);
                    
                    stack.peek().getChildren().add(node);
                    stack.push(node);
                    level++;

                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    
                    stack.pop();
                    level--;

                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    String data = new String(ch, start, length);

                    TreeItem thing = new TreeItem<>(data);
                    stack.peek().getChildren().add(thing);
                
                }
                
                @Override
                public void ignorableWhitespace(char ch[], int start, int length){
                    
                }
                
            };
            
            if(file != null)
            saxParser.parse(file, handler);
            
            } catch (IOException | ParserConfigurationException | SAXException e) {
                System.out.println("Parse Error");
            }
        }
         
    public int getLevel(){
        return level;
    }
    public void setLevel(int input){
        level = input;
    }
}
