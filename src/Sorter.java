
public class Sorter {
	
	private int[] tempMergArr;
	private int N;
	private int[] array;
	private int length;
	
	
//Insertion
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
	
//Merge
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

//Bubble
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
	return array;
}

//Quick
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

public void exchangeNumbers(int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
}

//Heap
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

public void swap(int array[], int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
}

}
