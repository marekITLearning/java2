package sk.itlearning.java2.j.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtField;

    @FXML
    private Button btnPresun;

    @FXML
    private TextArea txtArea;

    @FXML
    public void presunPopisDoTextArea() {
    	txtArea.appendText(txtField.getText().toUpperCase()+"\n");
    }

}
