import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
 private Label MergeTimeO;
 @FXML
 private Label BubbleTimeO;
 @FXML
 private Label QuickTimeO;
 @FXML
 private Label HeapTimeO;
 @FXML
 private Label InsertionTimeO;
 @FXML
 private Label MergeMemO;
 @FXML
 private Label BubbleMemO;
 @FXML
 private Label QuickMemO;
 @FXML
 private Label HeapMemO;
 @FXML
 private Label InsertionMemO;
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
					MergeTimeO.setVisible(true);
					MergeMemO.setVisible(true);
					MergeTime.setVisible(true);
					StartT();
					sort.startMerge(data);
					EndT();
					MergeTimeO.setText("Big O Time: O(n log(n))");
					MergeMemO.setText("Big O Memory: O(n)");
					MergeTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Merge.isSelected()) {
					MergeTimeO.setVisible(false);
					MergeMemO.setVisible(false);
					MergeTime.setVisible(false);
				}
				
				if(Bubble.isSelected()) {
					BubbleTimeO.setVisible(true);
					BubbleMemO.setVisible(true);
					BubbleTime.setVisible(true);
					StartT();
					sort.bubbleSort(data);
					EndT();
					BubbleTimeO.setText("Big O Time: O(n^2)");
					BubbleMemO.setText("Big O Memory: O(1)");
					BubbleTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Bubble.isSelected()) {
					BubbleTimeO.setVisible(false);
					BubbleMemO.setVisible(false);
					BubbleTime.setVisible(false);
				}
				
				if(Quick.isSelected()) {
					QuickTimeO.setVisible(true);
					QuickMemO.setVisible(true);
					QuickTime.setVisible(true);
					StartT();
					sort.qSort(data);
					EndT();
					QuickTimeO.setText("Big O Time: O(n^2)");
					QuickMemO.setText("Big O Memory: O(log(n))");
					QuickTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Quick.isSelected()) {
					QuickTimeO.setVisible(false);
					QuickMemO.setVisible(false);
					QuickTime.setVisible(false);
				}
				
				if(Heap.isSelected()) {
					HeapTimeO.setVisible(true);
					HeapMemO.setVisible(true);
					HeapTime.setVisible(true);
					StartT();
					sort.heapSort(data);
					EndT();
					HeapTimeO.setText("Big O Time: O(n log(n))");
					HeapMemO.setText("Big O Memory: O(1)");
					HeapTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Heap.isSelected()) {
					HeapTimeO.setVisible(false);
					HeapMemO.setVisible(false);
					HeapTime.setVisible(false);
				}
				
				if(Insertion.isSelected()) {
					InsertionTimeO.setVisible(true);
					InsertionMemO.setVisible(true);
					InsertionTime.setVisible(true);
					StartT();
					sort.insertion(data);
					EndT();
					InsertionTimeO.setText("Big O Time: O(n^2)");
					InsertionMemO.setText("Big O Memory: O(1)");
					InsertionTime.setText("Time: " + totalTime + "ns");
				}
				else if(!Insertion.isSelected()) {
					InsertionTimeO.setVisible(false);
					InsertionMemO.setVisible(false);
					InsertionTime.setVisible(false);
				}
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
	//Starting time of algorithm
	public void StartT() {
		startTime = System.nanoTime();
	}
	
	//Ending time of algorithm
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
				al.clear();
				data = null;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Text file must only contain integers.");
				alert.showAndWait();
				break;
			}
		s.close();
		
		if(al.size() != 0){
			data = new int[al.size()];
			
			for(int x = 0; x<al.size();x++){
				data[x] = al.get(x);
			}
		}
	}
}