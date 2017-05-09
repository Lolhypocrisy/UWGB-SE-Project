
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController extends main {
	
	@FXML
  	private Button Tester;
  	@FXML
  	private Button btnSort;
  	@FXML
 	private Button btnReset;
 	@FXML
  	private ComboBox selectAlgo;
  	@FXML
  	private ComboBox Lang;
  	@FXML
  	private Label lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14;
 	@FXML
 	public Pane p0;
 	@FXML
 	public Pane	p1; 
 	@FXML
 	public Pane p2; 
 	@FXML
 	public Pane p3; 
 	@FXML
 	public Pane p4; 
 	@FXML
 	public Pane p5; 
 	@FXML
 	public Pane p6; 
 	@FXML
 	public Pane p7; 
 	@FXML
 	public Pane p8; 
 	@FXML
 	public Pane p9;
 	@FXML
 	public Pane p10; 
 	@FXML
 	public Pane p11; 
 	@FXML
 	public Pane p12; 
 	@FXML
 	public Pane p13; 
 	@FXML
 	public Pane p14;
 	@FXML
 	private TextArea code;
 	@FXML
 	private Rectangle r0;
 	@FXML
 	private Rectangle r1; 
 	@FXML
 	private Rectangle r2; 
 	@FXML
 	private Rectangle r3;
 	@FXML
 	private Rectangle r4;
 	@FXML
 	private Rectangle r5;
 	@FXML
 	private Rectangle r6;
 	@FXML
 	private Rectangle r7;
 	@FXML
 	private Rectangle r8;
 	@FXML
 	private Rectangle r9;
 	@FXML
 	private Rectangle r10;
 	@FXML
 	private Rectangle r11;
 	@FXML
 	private Rectangle r12;
 	@FXML
 	private Rectangle r13;
 	@FXML
 	private Rectangle r14;
	
	private String lang, algo;
	private Sorter sort = new Sorter();
	private CodeHelper ch =  new CodeHelper();
	private int[] array = {2,34,53,23,122,5,0,6,32,43,22,46,1000,3,452};
	private ArrayList<Pane> panes = new ArrayList<>();
	
	public void initialize() {
		Label[] texts = {lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14 };
	
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
		
		 panes.add(p0);
		 panes.add(p1);
		 panes.add(p2);
		 panes.add(p3);
		 panes.add(p4);
		 panes.add(p5);
		 panes.add(p6);
		 panes.add(p7);
		 panes.add(p8);
		 panes.add(p9);
		 panes.add(p10);
		 panes.add(p11);
		 panes.add(p12);
		 panes.add(p13);
		 panes.add(p14);
		 
		 Lang.setDisable(true);
		 }
	
	public void toTestScreen() {
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

	public void selectLang() {
		switch(Lang.getValue().toString()) {
		case "Java" :
			lang = "java";
			code.setText(ch.java(algo));
			break;
		case "C++" :
			lang = "cpp";
			code.setText(ch.cpp(algo));
			break;
		case "Python" :
			lang = "python";
			code.setText(ch.python(algo));
			break;
		case "JavaScript" :
			lang = "js";
			code.setText(ch.jscript(algo));
			break;
		case "Pseudo code" :
			lang = "pseudo";
			code.setText(ch.pseudo(algo));
			break;
		}
	}
	
	public void setAlgo(){
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
		
		Lang.setDisable(false);
	}
	
	public void sort() {
		SequentialTransition st = new SequentialTransition();
		
			switch(algo) {
			case "merge" :
				st = sort.startMerge(array, panes);
				break;
			case "bubble" :
				st = sort.bubbleSort(array, panes);
				break;
			case "quick" :
				st = sort.qSort(array, panes);
				break;
			case "heap":
				st = sort.heapSort(array, panes);
				break;
			case "insertion" :
				st = sort.insertion(array, panes);
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
			btnSort.setDisable(true);
			st.play();
		}
	
	public void setText() {
		Label[] texts = {lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14 };
		
		for(int i = 0; i < texts.length; i++) {
			texts[i].setText(Integer.toString(array[i]));
		}
	}
	
	public void reset() {
   	    {
   	        try {
   	            FXMLLoader loader = new FXMLLoader();
   	            loader.setLocation(main.class.getResource("MainScreen.fxml"));
   	            AnchorPane Main = (AnchorPane) loader.load();

   	            main.rootLayout.setCenter(Main);
   	        } catch (IOException e) 
   	        {
   	            e.printStackTrace();
   	        }
   	    }
	}
}
