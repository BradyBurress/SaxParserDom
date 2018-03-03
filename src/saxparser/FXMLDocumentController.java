/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author extre
 */
public class FXMLDocumentController implements Initializable {
    static File file = null;
    private int level = 0;

            
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Button fileBtn;
    
    @FXML
    private Pane DOMbox;
    
    
    
    @FXML
    private void handleParseButtonAction(ActionEvent event) {
       //DOMBuilder.buildDom(tree);
       // TreeItem root = new TreeItem<>("Item 1");
        //tree.getChildren().add(root);
        
        DOMBuilder.buildDom(DOMbox);
        
    }
    
    @FXML
    private void handleFileButtonAction(ActionEvent event) {
        
        Scene scene = fileBtn.getScene();
        if (scene != null) {
            Window window = scene.getWindow();

            final FileChooser fileChooser = new FileChooser();
            file = fileChooser.showOpenDialog(window);
            if (file != null) {
                System.out.println(file);
                System.out.println("Good File");   
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
