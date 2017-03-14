
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MainController extends main {
	
	@FXML
	private Button Tester;
	@FXML
	private ComboBox selectAlgo, Lang;
	private String algo;
	private String lang;
	
	public void toTestScreen() {
   	    {
   	        try {
   	            FXMLLoader loader = new FXMLLoader();
   	            loader.setLocation(main.class.getResource("TesterScreen.fxml"));
   	            AnchorPane Tester = (AnchorPane) loader.load();

   	            main.rootLayout.setCenter(Tester);
   	        } catch (IOException e) 
   	        {
   	            e.printStackTrace();
   	        }
   	    }
	}
	
	public void SelectAlgo() {
		switch(selectAlgo.getValue().toString()) {
		case "Merge" :
			algo = "merge";
			break;
		case "Bubble" :
			algo = "bubble";
			break;
		case "Quick" :
			algo = "quick";
			break;
		case "Heap":
			algo = "heap";
			break;
		case "Insertion" :
			algo = "insertion";
			break;
		}
	}
	
	public void SelectLang() {
		switch(Lang.getValue().toString()) {
		case "Java" :
			lang = "java";
			break;
		case "C++" :
			lang = "cpp";
			break;
		case "Python" :
			lang = "python";
			break;
		case "JavaScript" :
			lang = "js";
			break;
		case "Pseudo Code" :
			lang = "pseudo";
			break;
		}
	}
}
