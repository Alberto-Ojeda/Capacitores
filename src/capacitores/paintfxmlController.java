/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author cesarjohn
 */
public class paintfxmlController implements Initializable {
    
//    @FXML
//    private Label label;
    @FXML
    private ColorPicker colorpicker;
    
    
    @FXML
    private TextField bsize;
    
    
    @FXML
    private Canvas canvas;
    
    
    boolean toolSelected = false;
    
    GraphicsContext brushTool;
    
     
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
////        System.out.println("You clicked me!");
////        label.setText("Hello World!");
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        brushTool = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged( e -> {
        double size = Double.parseDouble(bsize.getText());
        double x = e.getX() - size /2;
        double y = e.getY() - size /2;
        
        if(toolSelected && !bsize.getText().isEmpty()){
            brushTool.setFill(colorpicker.getValue());
            brushTool.fillRoundRect(x, y, size, size, size, size);
        }
        
        });
    }    
    @FXML
    public void toolselected(ActionEvent e){
        toolSelected = true;
    }
}
