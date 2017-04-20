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
	SequentialTransition st = new SequentialTransition();
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
public SequentialTransition startMerge(int input[],ArrayList<Pane> list) {
	SequentialTransition st = new SequentialTransition();
	array = input;
    length = array.length;
    tempMergArr = new int[length];
    mergeSort(0, length - 1);
  return st;
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

//Merge w/o animation
public int[] startMerge(int input[]) {
	array = input;
    length = array.length;
    tempMergArr = new int[length];
    mergeSort(0, length - 1);
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
public SequentialTransition qSort(int[] values, ArrayList<Pane> list)
{
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
            st.getChildren().add(swapSelect(list.get(i), list.get(j), list));
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
public SequentialTransition heapSort(int array[],ArrayList<Pane> list) {
	SequentialTransition st = new SequentialTransition();
	heapify(array);
	for (int i = N; i > 0; i--) {
		swap(array, 0, i);
		N = N - 1;
		maxHeap(array, 0);
	}
	return st;
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

private ParallelTransition swapMe(Pane l1, Pane l2, ArrayList<Pane> list) {
	TranslateTransition t1 = new TranslateTransition();
    TranslateTransition t2 = new TranslateTransition();
    t1.setDuration(Duration.millis(100));
    t2.setDuration(Duration.millis(100));
    ParallelTransition pl = new ParallelTransition();
    t1.setNode(l1);
    t2.setNode(l2);
    t1.setByX(43);
    t2.setByX(-43);
    pl.getChildren().addAll(t1, t2);
    Collections.swap(list, list.indexOf(l1), list.indexOf(l2));
    return pl;
}

private ParallelTransition swapSelect(Pane l1, Pane l2, ArrayList<Pane> list) {
    int num = 1;
    Pane sp1 = null, sp2 = null, fSp = null;
    TranslateTransition t1 = new TranslateTransition();
    TranslateTransition t2 = new TranslateTransition();
    ParallelTransition pl = new ParallelTransition();
    t1.setNode(l1);
    t2.setNode(l2);
    t1.setDuration(Duration.millis(1000));
    t2.setDuration(Duration.millis(1000));
   
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
    num *= 43;
    t1.setByX(num);
    t2.setByX(-num);
    Collections.swap(list, list.indexOf(l1), list.indexOf(l2));
    pl.getChildren().addAll(t1, t2);
    return pl;
}
}
