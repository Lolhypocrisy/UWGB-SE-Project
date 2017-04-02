
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController extends main {
	
	@FXML
	private Button Tester, btnSort;
	@FXML
	private ComboBox selectAlgo, Lang;
	@FXML
	private Label lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14;
	@FXML
	private TextArea code;
	@FXML
	private Rectangle r0;
	@FXML
	public Rectangle r1; 
	@FXML
	public Rectangle r2; 
	@FXML
	public Rectangle r3;
	@FXML
	public Rectangle r4;
	@FXML
	public Rectangle r5;
	@FXML
	public Rectangle r6;
	@FXML
	public Rectangle r7;
	@FXML
	public Rectangle r8;
	@FXML
	public Rectangle r9;
	@FXML
	public Rectangle r10;
	@FXML
	public Rectangle r11;
	@FXML
	public Rectangle r12;
	@FXML
	public Rectangle r13;
	@FXML
	public Rectangle r14;
	private String lang;
	private Sorter sort = new Sorter();
	private CodeHelper ch =  new CodeHelper();
	private int[] array = {2,34,53,23,122,5,0,6,32,43,22,46,1000,3,452};
	

	public void initialize() {
		
		Label[] texts = {lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14 };
		Rectangle[] rect = {r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14};
		for(int i = 0; i < texts.length; i++) {
			texts[i].setText(Integer.toString(array[i]));
		}
		
		selectAlgo.setValue("Select Algorithm");
		
		ObservableList<String> algoOptions = 
			    FXCollections.observableArrayList(
			        "Bubble",
			        "Heap",
			        "Merge",
			        "Quick",
			        "Insertion"
			    );
			 selectAlgo.getItems().addAll(algoOptions);
			 
		Lang.setValue("Select Language");
		
		ObservableList<String> langOptions = 
			    FXCollections.observableArrayList(
			        "Java",
			        "JavaScript",
			        "Python",
			        "C++",
			        "Pseudo code"
			    );
		 Lang.getItems().addAll(langOptions);
		 
		 code.setText("");
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
	//TODO: Fully implement putting correct code text on screen
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
			code.setText(ch.python("quick"));
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
				array = sort.startMerge(array);
				setText();
				break;
			case "Bubble" :
				array = sort.bubbleSort(array);
				setText();
				break;
			case "Quick" :
				array = sort.qSort(array);
				setText();
				break;
			case "Heap":
				array = sort.heapSort(array);
				setText();
				break;
			case "Insertion" :
				array = sort.insertion(array);
				setText();
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
	
	public void setText() {
		Label[] texts = {lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14 };
		for(int i = 0; i < texts.length; i++) {
			texts[i].setText(Integer.toString(array[i]));
		}
	}
}
