
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController extends main {
	
	@FXML
	private Button Tester, btnSort;
	@FXML
	private ComboBox selectAlgo, Lang;
	@FXML
	private Label lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14;
	private String lang;
	private Sorter sort = new Sorter();
	private int[] array = {2,34,53,23,122,5,0,6,32,43,22,46,1000,3,452};

	public void initialize() {
		Label[] texts = {lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14 };
		for(int i = 0; i < texts.length; i++) {
			texts[i].setText(Integer.toString(array[i]));
		}
		selectAlgo.setValue("Select Algorithm");
		
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Bubble",
			        "Heap",
			        "Merge",
			        "Quick",
			        "Insertion"
			    );
			 selectAlgo.getItems().addAll(options);
	}
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
	
	public void selectLang() {
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
	
	public void sort() {
			switch(selectAlgo.getValue().toString()) {
			case "Merge" :
				sort.startMerge(array);
				break;
			case "Bubble" :
				sort.bubbleSort(array);
				break;
			case "Quick" :
				sort.qSort(array);
				break;
			case "Heap":
				sort.heapSort(array);
				break;
			case "Insertion" :
				sort.insertion(array);
				break;
			case "Select Algorithm":
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Please select an algorithm");
				alert.showAndWait();
				break;
			default:
				System.out.println("This should never happen");
			}
		}
}
