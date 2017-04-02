import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TestingController extends main {
	
@FXML 
private Button backToMain;
@FXML 
private CheckBox Merge;
@FXML
private CheckBox Bubble; 
@FXML
private CheckBox Quick; 
@FXML
private CheckBox Heap;
@FXML
private CheckBox Insertion;
@FXML
private Label MergeTime;
@FXML
private Label BubbleTime;
@FXML
private Label QuickTime;
@FXML
private Label HeapTime;
@FXML
private Label InsertionTime;
@FXML
private Label MergeSec; 
@FXML
private Label BubbleSec; 
@FXML
private Label QuickSec; 
@FXML
private Label HeapSec;
@FXML
private Label InsertionSec;
@FXML
private Button Sort;
//TODO: file chooser will implement user's data
private int[] data = {2,34,53,23,122,5,0,6,32,43,22,46,1000,3,452};
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

public void sort() {
	Sorter sort = new Sorter();
	
	if(Merge.isSelected()) {
	MergeTime.setVisible(true);
	sort.startMerge(data);
	}
	if(Bubble.isSelected()) {
	BubbleTime.setVisible(true);
	sort.bubbleSort(data);
	}
	if(Quick.isSelected()) {
	QuickTime.setVisible(true);
	sort.qSort(data);
	}
	if(Heap.isSelected()) {
	HeapTime.setVisible(true);
	sort.heapSort(data);
	}
	if(Insertion.isSelected()) {
	InsertionTime.setVisible(true);
	sort.insertion(data);
	}
}
}
