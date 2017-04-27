import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

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
private int[] data = null;
private File selectedFile;
private long totalTime, startTime, endTime;
	
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
		try{
			if(data != null){
				Sorter sort = new Sorter();
				
				if(Merge.isSelected()) {
					MergeTime.setVisible(true);
					StartT();
					sort.startMerge(data);
					EndT();
					MergeTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Merge.isSelected()) MergeTime.setVisible(false);
				
				if(Bubble.isSelected()) {
					BubbleTime.setVisible(true);
					StartT();
					sort.bubbleSort(data);
					EndT();
					BubbleTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Bubble.isSelected()) BubbleTime.setVisible(false);
				
				if(Quick.isSelected()) {
					QuickTime.setVisible(true);
					StartT();
					sort.qSort(data);
					EndT();
					QuickTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Quick.isSelected()) QuickTime.setVisible(false);
				
				if(Heap.isSelected()) {
					HeapTime.setVisible(true);
					StartT();
					sort.heapSort(data);
					EndT();
					HeapTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Heap.isSelected()) HeapTime.setVisible(false);
				
				if(Insertion.isSelected()) {
					InsertionTime.setVisible(true);
					StartT();
					sort.insertion(data);
					EndT();
					InsertionTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Insertion.isSelected()) InsertionTime.setVisible(false);
			}
					
				if(!(Insertion.isSelected() || Merge.isSelected() || Bubble.isSelected() || Heap.isSelected() || Quick.isSelected())) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("Please select at least one algorithm");
					alert.showAndWait();
					}
		}
		catch(NullPointerException e) {}
		
		if(data == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("No data has been loaded");
			alert.showAndWait();
		}
	}
	
	//Timing mechaism
	public void StartT() {
		startTime = System.nanoTime();
	}
	
	public void EndT() {
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
	}
	
	//Text file w/ list of ints must be loaded before testing can be done
	public void getFile() throws IOException {
		FileChooser fc = new FileChooser();
		fc.setTitle("Select file");
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Text Files", "*.txt"));
		selectedFile = fc.showOpenDialog(primaryStage);
		
		Scanner s = new Scanner(selectedFile);
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		while(s.hasNextLine())
			try{
				al.add(s.nextInt());
			}catch(NoSuchElementException e){
				
			}
		s.close();
		
		data = new int[al.size()];
		
		for(int x = 0; x<al.size();x++){
			data[x] = al.get(x);
		}
	}
}