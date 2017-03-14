import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class TestingController extends main {
	
@FXML 
private Button backToMain;
@FXML 
private CheckBox Merge, Bubble, Quick, Heap, Insertion;

public void toMainScreen() {
	    {
	        try {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(main.class.getResource("MainScreen.fxml"));
	            AnchorPane backToMain = (AnchorPane) loader.load();

	            main.rootLayout.setCenter(backToMain);
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	    }
}
}
