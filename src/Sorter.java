import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Sorter {
	
	private int[] tempMergArr;
	private int N;
	private int[] array;
	private int length;
	private Pane[] helperNodes;
    private static final double SPACING = 42;
    private static final int SORT_GROUP_MOVE_DELTA = 200;
    private static final Duration SPEED = Duration.millis(350);
	
	//Insertion w/ animation
	public SequentialTransition insertion(int[] input, ArrayList<Pane> list){
	    int temp;
		SequentialTransition st = new SequentialTransition();
	    for (int i = 1; i < input.length; i++) {
	        for(int j = i ; j > 0 ; j--){
	            if(input[j] < input[j-1]){
	                temp = input[j];
	                input[j] = input[j-1];
	                input[j-1] = temp;
	                st.getChildren().add(swapMe(list.get(j - 1), list.get(j), list));
	            }
	        }
	    }
	    return st;
	}
	
	//Insertion w/o animation
	public int[] insertion(int[] input){
	    int temp;
	    for (int i = 1; i < input.length; i++) {
	        for(int j = i ; j > 0 ; j--){
	            if(input[j] < input[j-1]){
	                temp = input[j];
	                input[j] = input[j-1];
	                input[j-1] = temp;
	            }
	        }
	    }
	    return input;
	}
	
	//Merge w/ animation
	public SequentialTransition startMerge(int input[], ArrayList<Pane> list) {
		SequentialTransition st = new SequentialTransition();
		 	array = input;
	    length = array.length;
	    tempMergArr = new int[length];
	    this.helperNodes = new Pane[length];
	    mergeSort(0, length - 1, st, list);
	  return st;
	}
	
	public void mergeSort(int lowerIndex, int higherIndex, SequentialTransition st, ArrayList<Pane> list) {
	   if (lowerIndex < higherIndex) {
	       int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	       // Below step sorts the left side of the array
	       mergeSort(lowerIndex, middle, st, list);
	       // Below step sorts the right side of the array
	       mergeSort(middle + 1, higherIndex, st, list);
	       // Now merge both sides
	      mergeParts(lowerIndex, middle, higherIndex, st, list);
	   }
	}
	
	public void mergeParts(int lowerIndex, int middle, int higherIndex, SequentialTransition st, ArrayList<Pane> list) {
	    for (int i = lowerIndex; i <= higherIndex; i++) {
	        tempMergArr[i] = array[i];
	        helperNodes[i] = list.get(i);
	    }
	    
	    int i = lowerIndex;
	    int j = middle + 1;
	    int k = lowerIndex;
	    
	    while (i <= middle && j <= higherIndex) {
	        if (tempMergArr[i] <= tempMergArr[j]) {
	            array[k] = tempMergArr[i];
	            list.set(k, helperNodes[i]);
	            st.getChildren().add(move(helperNodes[i], k * SPACING));
	            i++;
	        } else {
	            array[k] = tempMergArr[j];
	            list.set(k, helperNodes[j]);
	            st.getChildren().add(move(helperNodes[j],k * SPACING));
	            j++;
	        }
	        k++;
	    }
	    while (i <= middle) {
	        array[k] = tempMergArr[i];
	        list.set(k, helperNodes[i]);
	        st.getChildren().add(move(helperNodes[i], k * SPACING));
	        k++;
	        i++;
	    }
	    
	  while (j <= higherIndex) {
	        st.getChildren().add(move(helperNodes[j], k * SPACING));
	        k++;
	        j++;
	    }
	  
	  	//Moves bars back down
	    ParallelTransition moveDown = new ParallelTransition();
	
	    for (int z = lowerIndex; z <= higherIndex; z++) {
	        TranslateTransition moveNodeDown = new TranslateTransition();
	        moveNodeDown.setNode(helperNodes[z]);
	        moveNodeDown.setDuration(SPEED);
	        moveNodeDown.setByY(SORT_GROUP_MOVE_DELTA);
	        moveDown.getChildren().add(moveNodeDown);
	
	    }
	
	    st.getChildren().add(moveDown);
	}
	//Adds new single transition animation to full animation
	//Moves bars up and either left or right
	public TranslateTransition move(Pane p, double X) {
	    TranslateTransition t = new TranslateTransition();
	    t.setNode(p);
	    t.setDuration(SPEED);
	    t.setToX(X - p.getLayoutX());
	    t.setToY(-SORT_GROUP_MOVE_DELTA);
	    return t;
	}
	
	//Merge w/o animation
	public int[] startMerge(int input[]) {
		array = input;
	    length = array.length;
	    tempMergArr = new int[length];
	    mergeSort(0, length - 1);
	  return array;
	}
	
	public void mergeSort(int lowerIndex, int higherIndex) {
		   if (lowerIndex < higherIndex) {
		       int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
		       // Below step sorts the left side of the array
		       mergeSort(lowerIndex, middle);
		       // Below step sorts the right side of the array
		       mergeSort(middle + 1, higherIndex);
		       // Now merge both sides
		      array = mergeParts(lowerIndex, middle, higherIndex);
		   }
		}
	
	public int[] mergeParts(int lowerIndex, int middle, int higherIndex) {
	    for (int i = lowerIndex; i <= higherIndex; i++) {
	        tempMergArr[i] = array[i];
	    }
	    int i = lowerIndex;
	    int j = middle + 1;
	    int k = lowerIndex;
	    
	    while (i <= middle && j <= higherIndex) {
	        if (tempMergArr[i] <= tempMergArr[j]) {
	            array[k] = tempMergArr[i];
	            i++;
	        } else {
	            array[k] = tempMergArr[j];
	            j++;
	        }
	        k++;
	    }
	    while (i <= middle) {
	        array[k] = tempMergArr[i];
	        k++;
	        i++;
	    }
		return array;
	    }
	
	//Bubble w/ animation
	public SequentialTransition bubbleSort(int[] numArray, ArrayList<Pane> list) {
		SequentialTransition st = new SequentialTransition();
		array = numArray;
		length = array.length;
		int n = numArray.length;
	    int temp;
	    for (int i = 0; i < n; i++)
	    {
	        for (int j = 1; j < (n - i); j++)
	        {
	            if (numArray[j - 1] > numArray[j])
	            {
	                temp = numArray[j - 1];
	                numArray[j - 1] = numArray[j];
	                numArray[j] = temp;
	                st.getChildren().add(swapMe(list.get(j-1),list.get(j),list));
	            }
	        }
	    }
		return st;
	}
	
	//Swap two adjacent bars
	private ParallelTransition swapMe(Pane l1, Pane l2, ArrayList<Pane> list) {
		TranslateTransition t1 = new TranslateTransition();
	    TranslateTransition t2 = new TranslateTransition();
	    t1.setDuration(Duration.millis(350));
	    t2.setDuration(Duration.millis(350));
	    ParallelTransition pl = new ParallelTransition();
	    
	    t1.setNode(l1);
	    t2.setNode(l2);
	    t1.setByX(42);
	    t2.setByX(-42);
	    pl.getChildren().addAll(t1, t2);
	    Collections.swap(list, list.indexOf(l1), list.indexOf(l2));
	    return pl;
	}
	
	//Bubble w/o animation
	public int[] bubbleSort(int[] numArray) {
		array = numArray;
		length = array.length;
		int n = numArray.length;
	    int temp;
	    for (int i = 0; i < n; i++)
	    {
	        for (int j = 1; j < (n - i); j++)
	        {
	            if (numArray[j - 1] > numArray[j])
	            {
	                temp = numArray[j - 1];
	                numArray[j - 1] = numArray[j];
	                numArray[j] = temp;
	            }
	        }
	    }
		return numArray;
	}
	
	//Quick w/ animation
	public SequentialTransition qSort(int[] values, ArrayList<Pane> list) {
		SequentialTransition st = new SequentialTransition();
		array = values;
		length = array.length;
		quickSort(0, length - 1, st, list);
		return st;
	}
	
	public int[] quickSort(int lowerIndex, int higherIndex, SequentialTransition st, ArrayList<Pane> list) {
		int i = lowerIndex;
		int j = higherIndex;
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i , j);
				if(i != j)
				{	
					st.getChildren().add(swapSelect(list.get(i), list.get(j), list));
				}
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			quickSort(lowerIndex, j, st, list);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex, st, list);
		}
		return array;
	}
	
	public void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//Swaps non-adjacent bars
	private ParallelTransition swapSelect(Pane l1, Pane l2, ArrayList<Pane> list) {
	    int num = 1;
	    Pane fSp = null;
	    TranslateTransition t1 = new TranslateTransition();
	    TranslateTransition t2 = new TranslateTransition();
	    ParallelTransition pl = new ParallelTransition();
	    t1.setNode(l1);
	    t2.setNode(l2);
	    t1.setDuration(Duration.millis(350));
	    t2.setDuration(Duration.millis(350));
	    
	    boolean outerBreak = false;
	    for (int i = 0; i < list.size(); i++) {
	        if (outerBreak) break;
	        if (list.get(i) == l1 || list.get(i) == l2) {
	            fSp = list.get(i);
	            for (int j = list.indexOf(fSp) + 1; j < list.size(); j++) {
	                if ((list.get(j) == l1 && list.get(j) != fSp) || (list.get(j) == l2 && list.get(j) != fSp)) {
	                    outerBreak = true;
	                    num = j - i;
	                    break;
	                }
	            }
	        }
	    }
	    num *= 42;
	    t1.setByX(num);
	    t2.setByX(-num);
	    Collections.swap(list, list.indexOf(l1), list.indexOf(l2));
	    pl.getChildren().addAll(t1, t2);
	    return pl;
	}
	
	//Quick w/o animation
	public int[] qSort(int[] values)
	{
		array = values;
		length = array.length;
		return quickSort(0, length - 1);
	}
	
	public int[] quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i , j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex);
		}
		return array;
	}
	
	//Heap w/ animation
	public SequentialTransition heapSort(int array[], ArrayList<Pane> list) {
		SequentialTransition st = new SequentialTransition();
		heapify(array, list, st);
		for (int i = N; i > 0; i--) {
			swap(array, 0, i);
			st.getChildren().add(swapSelect(list.get(0), list.get(i), list));
			N = N - 1;
			maxHeap(array, 0, list, st);
		}
		return st;
	}
	
	public void heapify(int array[], ArrayList<Pane> list, SequentialTransition st) {
		N = array.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			maxHeap(array, i, list, st);
		}
	}
	
	public void maxHeap(int array[], int i, ArrayList<Pane> list, SequentialTransition st) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && array[left] > array[i]) {
			max = left;
		}
		if (right <= N && array[right] > array[max]) {
			max = right;
		}
		if (max != i) {
			swap(array, i, max);
			st.getChildren().add(swapSelect(list.get(i), list.get(max), list));
			maxHeap(array, max, list, st);
		}
	}
	
	public void swap(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//Heap w/o animation
	public int[] heapSort(int array[]) {
		heapify(array);
		for (int i = N; i > 0; i--) {
			swap(array, 0, i);
			N = N - 1;
			maxHeap(array, 0);
		}
		return array;
	}
	public void heapify(int array[]) {
		N = array.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			maxHeap(array, i);
		}
	}
	
	public void maxHeap(int array[], int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && array[left] > array[i]) {
			max = left;
		}
		if (right <= N && array[right] > array[max]) {
			max = right;
		}
		if (max != i) {
			swap(array, i, max);
			maxHeap(array, max);
		}
	}
}
