
public class CodeHelper {
private String pBubble = "" + 
"def BubbleSort(numArray):\n" +
"		for i in range (0, len(numArray) - 1):\n" +
"			for j in range(0, len(numArray) - 1 - i):\n" +
"				if numArray[j] > numArray[j + 1]:\n" +
"					numArray[j], numArray[j + 1] = numArray[j + 1], numArray[j]\n" +
"		return numArray";

private String pquick = "" + 
"def QuickSort(numbers):\n" +
"	QuickSort2(numbers, 0, len(numbers) - 1)\n" +
"\n" +
"def QuickSort2(numbers, low, high):\n" +
"	if low < high:\n" +
"		p = Partition(numbers, low, high)\n" +
"		QuickSort2(numbers, low, p - 1)\n" +
"		QuickSort2(numbers, p + 1, high)\n" +
"		\n" +
"def GetPivot(numbers, low, high):\n" +
"	middle = (high + low)\n" +
"	pivot = high\n" +
"	if numbers[low] < numbers[middle]:\n" +
"		if numbers[middle] < numbers[high]:\n" +
"			pivot = middle\n" +
"	elif numbers[low] < numbers[high]:\n" +
"		pivot = low\n" +
"	return pivot\n" +
"	\n" +
"def Partition(numbers, low, high):\n" +
"	pivotIndex = GetPivot(numbers, low, high)\n" +
"	pivotValue = numbers[pivotIndex]\n" +
"	numbers[pivotIndex], numbers[low] = numbers[low], numbers[pivotIndex]\n" +
"	border = low\n" +
"	for i in range(low, high + 1):\n" +
"		if numbers[i] < pivotValue:\n" +
"			border += 1\n" +
"			numbers[i], numbers[border] = numbers[border], numbers[i]\n" +
"	numbers[low], numbers[border] = numbers[border], numbers[low]\n" +
"	return (border)";

private String pmerge = "" + 
"def mergeSort(alist):\n" +
"    if len(alist)>1:\n" +
"       mid = len(alist)//2\n" +
"        lefthalf = alist[:mid]\n" +
"        righthalf = alist[mid:]\n" +
"\n" +
"        mergeSort(lefthalf)\n" +
"        mergeSort(righthalf)\n" +
"\n" +
"        i=0\n" +
"        j=0\n" +
"        k=0\n" +
"        while i < len(lefthalf) and j < len(righthalf):\n" +
"            if lefthalf[i] < righthalf[j]:\n" +
"                alist[k]=lefthalf[i]\n" +
"                i=i+1\n" +
"            else:\n" +
"                alist[k]=righthalf[j]\n" +
"                j=j+1\n" +
"            k=k+1\n" +
"\n" +
"        while i < len(lefthalf):\n" +
"            alist[k]=lefthalf[i]\n" +
"            i=i+1\n" +
"            k=k+1\n" +
"\n" +
"       while j < len(righthalf):\n" +
"            alist[k]=righthalf[j]\n" +
"            j=j+1\n" +
"            k=k+1";

private String pheap = "" + 
"def Init(self, items = []):\n" +
"	super().Init()\n" +
"	self.heap = [0]\n" +
"	for i in items:\n" +
"		self.heap.append(i)\n" +
"		self.FloatUp(len(self.heap) - 1)\n" +
"		\n" +
"def Push(self, data):\n" +
"	self.heap.append(data)\n" +
"	self.FloatUp(len(self.heap) - 1)\n" +
"	\n" +
"def Peek(self):\n" +
"	if self.heap[1]:\n" +
"		return self.heap[1]\n" +
"	else:\n" +
"		return False\n" +
"		\n" +
"def Pop(self):\n" +
"	if len(self.heap) > 2:\n" +
"		self.Swap(1, len(self.heap) - 1)\n" +
"		max = self.heap.Pop()\n" +
"		self.BubbleDown(1)\n" +
"	elif len(self.heap) == 2:\n" +
"		max = self.heap.Pop()\n" +
"	else:\n" +
"		max = False\n" +
"	return max\n" +
"	\n" +
"def Swap(self, i, j):\n" +
"	self.heap[i], self.heap[j] = self.heap[j], self.heap[i]\n" +
"	\n" +
"def FloatUp(self, index):\n" +
"	parent = index//2\n" +
"	if index <= 1:\n" +
"		return\n" +
"	elif self.heap[index] > self.heap[parent]:\n" +
"		self.Swap(index, parent)\n" +
"		self.FloatUp(parent)\n" +
"		\n" +
"def BubbleDown(self, index):\n" +
"	left = index * 2\n" +
"	right = index * 2 + 1\n" +
"	largest = index\n" +
"	if len(self.heap) > left and self.heap[largest] < self.heap[left]:\n" +
"		largest = left\n" +
"	if len(self.heap) > right and self.heap[largest] < self.heap[right]:\n" +
"		largest = right\n" +
"	if largest != index:\n" +
"		self.Swap(index, largest)\n" +
"		self.BubbleDown(largest)";

private String pinsert = "" + 
"def insertionSort(alist):\n" +
"	   for index in range(1,len(alist)):\n" +
"\n" +
"	     currentvalue = alist[index]\n" +
"	     position = index\n" +
"\n" +
"	     while position>0 and alist[position-1]>currentvalue:\n" +
"	         alist[position]=alist[position-1]\n" +
"	         position = position-1\n" +
"\n" +
"	     alist[position]=currentvalue";

//TODO: Put rest of text in here
String jbubble = "" + 
"public int[] bubbleSort(int[] numArray) {\n" +
"	array = numArray;\n" +
"	length = array.length;\n" +
"	int n = numArray.length;\n" +
"   int temp;\n" +
"  for (int i = 0; i < n; i++)\n" +
"    {\n" +
"        for (int j = 1; j < (n - i); j++)\n" +
"        {\n" +
"            if (numArray[j - 1] > numArray[j])\n" +
"            {\n" +
"                temp = numArray[j - 1];\n" +
"                numArray[j - 1] = numArray[j];\n" +
"                numArray[j] = temp;\n" +
"            }\n" +
"        }\n" +
"    }\n" +
"	return array;\n" +
"}";

private String jinsert = "" + 
"public int[] insertion(int[] input){\n" +
"    \n" +
"    int temp;\n" +
"    for (int i = 1; i < input.length; i++) {\n" +
"        for(int j = i ; j > 0 ; j--){\n" +
"            if(input[j] < input[j-1]){\n" +
"                temp = input[j];\n" +
"                input[j] = input[j-1];\n" +
"                input[j-1] = temp;\n" +
"            }\n" +
"        }\n" +
"    }\n" +
"    return input;\n" +
"}";

private String jheap = ""+
"public int[] heapSort(int array[]) {\n" +
"	heapify(array);\n" +
"	for (int i = N; i > 0; i--) {\n" +
"		swap(array, 0, i);\n" +
"		N = N - 1;\n" +
"		maxHeap(array, 0);\n" +
"	}\n" +
"	return array;\n" +
"}\n" +
"\n" +
"public void heapify(int array[]) {\n" +
"	N = array.length - 1;\n" +
"	for (int i = N / 2; i >= 0; i--) {\n" +
"		maxHeap(array, i);\n" +
"	}\n" +
"}\n" +
"\n" +
"public void maxHeap(int array[], int i) {\n" +
"	int left = 2 * i;\n" +
"	int right = 2 * i + 1;\n" +
"	int max = i;\n" +
"	if (left <= N && array[left] > array[i]) {\n" +
"		max = left;\n" +
"	}\n" +
"	if (right <= N && array[right] > array[max]) {\n" +
"		max = right;\n" +
"	}\n" +
"	if (max != i) {\n" +
"		swap(array, i, max);\n" +
"		maxHeap(array, max);\n" +
"	}\n" +
"}\n" +
"\n" +
"public void swap(int array[], int i, int j) {\n" +
"	int temp = array[i];\n" +
"	array[i] = array[j];\n" +
"	array[j] = temp;\n" +
"}";

private String jmerge = "" + 
"public int[] startMerge(int input[]) {\n" +
"    array = input;\n" +
"    length = array.length;\n" +
"    tempMergArr = new int[length];\n" +
"    mergeSort(0, length - 1);\n" +
"  return array;\n" +
"}\n" +
"\n" +
"public void mergeSort(int lowerIndex, int higherIndex) {\n" +
"    \n" +
"   if (lowerIndex < higherIndex) {\n" +
"       int middle = lowerIndex + (higherIndex - lowerIndex) / 2;\n" +
"       // Below step sorts the left side of the array\n" +
"       mergeSort(lowerIndex, middle);\n" +
"       // Below step sorts the right side of the array\n" +
"       mergeSort(middle + 1, higherIndex);\n" +
"       // Now merge both sides\n" +
"      array = mergeParts(lowerIndex, middle, higherIndex);\n" +
"   }\n" +
"}\n" +
"\n" +
"public int[] mergeParts(int lowerIndex, int middle, int higherIndex) {\n" +
"	 \n" +
"    for (int i = lowerIndex; i <= higherIndex; i++) {\n" +
"        tempMergArr[i] = array[i];\n" +
"    }\n" +
"    int i = lowerIndex;\n" +
"    int j = middle + 1;\n" +
"    int k = lowerIndex;\n" +
"    while (i <= middle && j <= higherIndex) {\n" +
"        if (tempMergArr[i] <= tempMergArr[j]) {\n" +
"            array[k] = tempMergArr[i];\n" +
"            i++;\n" +
"        } else {\n" +
"            array[k] = tempMergArr[j];\n" +
"            j++;\n" +
"        }\n" +
"        k++;\n" +
"    }\n" +
"    while (i <= middle) {\n" +
"        array[k] = tempMergArr[i];\n" +
"        k++;\n" +
"        i++;\n" +
"    }\n" +
"    return array;\n" +
"}";

private String jquick = "" +
"public int[] qSort(int[] values)\n" +
"{\n" +
"	array = values;\n" +
"	length = array.length;\n" +
"	return quickSort(0, length - 1);\n" +
"}\n" +
"\n" +
"public int[] quickSort(int lowerIndex, int higherIndex) {\n" +
"	int i = lowerIndex;\n" +
"	int j = higherIndex;\n" +
"	int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];\n" +
"	while (i <= j) {\n" +
"		while (array[i] < pivot) {\n" +
"			i++;\n" +
"		}\n" +
"		while (array[j] > pivot) {\n" +
"			j--;\n" +
"		}\n" +
"		if (i <= j) {\n" +
"			exchangeNumbers(i , j);\n" +
"			i++;\n" +
"			j--;\n" +
"		}\n" +
"	}\n" +
"	if (lowerIndex < j) {\n" +
"		quickSort(lowerIndex, j);\n" +
"	}\n" +
"	if (i < higherIndex) {\n" +
"		quickSort(i, higherIndex);\n" +
"	}\n" +
"	return array;\n" +
"}\n" +
"\n" +
"public void exchangeNumbers(int i, int j) {\n" +
"	int temp = array[i];\n" +
"	array[i] = array[j];\n" +
"	array[j] = temp;\n" +
"}";

private String cheap = "" + 
"void MaxHeapify(int *a, int i, int n)\n" + 
"{\n" +
"	int j, temp;\n" +
"	temp = a[i];\n" +
"	j = 2 * i;\n" +
"	while (j <= n)\n" +
"	{\n" +
"		if (j < n && a[j + 1] > a[j])\n" +
"		{\n" +
"			j = j + 1;\n" +
"		}\n" +
"		if (temp > a[j])\n" +
"		{\n" +
"			break;\n" +
"		}\n" +
"		else if (temp <= a[j])\n" +
"		{\n" +
"			a[j / 2] = a[j];\n" +
"			j = 2 * j;\n" +
"		}\n" +
"	}\n" +
"	a[j / 2] = temp;\n" +
"	return;\n" +
"}\n" +
"\n" +
"void HeapSort(int *a, int n)\n" +
"{\n" +
"	int i, temp;\n" +
"	for (i = n; i >= 2; i--)\n" +
"	{\n" +
"		temp = a[i];\n" +
"		a[i] = a[1];\n" +
"		a[1] = temp;\n" +
"		MaxHeapify(a, 1, i - 1);\n" +
"	}\n" +
"}\n" +
"\n" +
"void BuildMaxHeap(int *a, int n)\n" +
"{\n" +
"	int i;\n" +
"	for (i = n / 2; i >= 1; i--)\n" +
"	{\n" +
"		MaxHeapify(a, i, n);\n" +
"	}\n" +
"}";

private String cquick = "" + 
"void QuickSort(int numbers[], int left, int right)\n" +
"{\n" +
"	int i = left, j = right;\n" +
"	int temp;\n" +
"	int pivot = numbers[(left + right) / 2];\n" +
"	while (i <= j)\n" +
"	{\n" +
"		while (numbers[i] < pivot)\n" +
"		{\n" +
"			i++;\n" +
"		}\n" +
"		while (numbers[j] > pivot)\n" +
"		{\n" +
"			j--;\n" +
"		}\n" +
"		if (i <= j)\n" +
"		{\n" +
"			temp = numbers[i];\n" +
"			numbers[i] = numbers[j];\n" +
"			numbers[j] = temp;\n" +
"			i++;\n" +
"			j--;\n" +
"		}\n" +
"	};\n" +
"	if (left < j)\n" +
"	{\n" +
"		QuickSort(numbers, left, j);\n" +
"	}\n" +
"	if (i < right)\n" +
"	{\n" +
"		QuickSort(numbers, i, right);\n" +
"	}\n" +
"}";

private String cbubble = "" + 
"void BubbleSort(int *a, int n)\n" +
"{\n" +
"	int temp, j, bound = n - 1, new_bound = 0;\n" +
"	for (int i = 0; i < n - 1; i++)\n" +
"	{\n" +
"		for (j = 0; j < bound; j++)\n" +
"		{\n" +
"			if (a[j] > a[j + 1])\n" +
"			{\n" +
"				temp = a[j];\n" +
"				a[j] = a[j + 1];\n" +
"				a[j + 1] = temp;\n" +
"				new_bound = j;\n" +
"			}\n" +
"		}\n" +
"		bound = new_bound;\n" +
"	}\n" +
"}";

private String cinsert = "" + 
"public vector<int> doInsertionSort(vector<int> input) {\n" +
"\n" +
"	int temp;\n" +
"	for (int i = 1; i < input.size; i++) {\n" +
"		for (int j = i; j > 0; j--) {\n" +
"			if (input[j] < input[j - 1]) {\n" +
"				temp = input[j];\n" +
"				input[j] = input[j - 1];\n" +
"				input[j - 1] = temp;\n" +
"			}\n" +
"		}\n" +
"	}\n" +
"	return input;\n" +
"}";

private String cmerge = "" + 
"public void sort(vector<int> inputArr) {\n" +
"	arrays = inputArr;\n" +
"	length = inputArr.size;\n" +
"	tempMergArr.reserve(length);\n" +
"	doMergeSort(0, length - 1);\n" +
"}\n" +
"\n" +
"public void doMergeSort(int lowerIndex, int higherIndex) {\n" +
"\n" +
"	if (lowerIndex < higherIndex) {\n" +
"		int middle = lowerIndex + (higherIndex - lowerIndex) / 2;\n" +
"		// Below step sorts the left side of the array\n" +
"		doMergeSort(lowerIndex, middle);\n" +
"		// Below step sorts the right side of the array\n" +
"		doMergeSort(middle + 1, higherIndex);\n" +
"		// Now merge both sides\n" +
"		mergeParts(lowerIndex, middle, higherIndex);\n" +
"	}\n" +
"}\n" +
"\n" +
"public void mergeParts(int lowerIndex, int middle, int higherIndex) {\n" +
"\n" +
"		for (int i = lowerIndex; i <= higherIndex; i++) {\n" +
"			tempMergArr[i] = arrays[i];\n" +
"		}\n" +
"		int i = lowerIndex;\n" +
"		int j = middle + 1;\n" +
"		int k = lowerIndex;\n" +
"		while (i <= middle && j <= higherIndex) {\n" +
"			if (tempMergArr[i] <= tempMergArr[j]) {\n" +
"				arrays[k] = tempMergArr[i];\n" +
"				i++;\n" +
"			}\n" +
"			else {\n" +
"				arrays[k] = tempMergArr[j];\n" +
"				j++;\n" +
"			}\n" +
"			k++;\n" +
"		}\n" +
"		while (i <= middle) {\n" +
"			arrays[k] = tempMergArr[i];\n" +
"			k++;\n" +
"			i++;\n" +
"		}\n" +
"}";

private String jsinsert = "" + 
"function insertionSort(items) {\n" +
"\n" +
"   var len     = items.length,\n" +    
"        value,                     \n" +
"        i,                          \n" +
"        j;                          \n" +
"\n" +
"    for (i=0; i < len; i++) {\n" +
"\n" +
"     \n" + 
"        value = items[i];\n" +
"\n" +
"       for (j=i-1; j > -1 &#038;&#038; items[j] > value; j--) {\n" +
"            items[j+1] = items[j];\n" +
"        }\n" +
"\n" +
"        items[j+1] = value;\n" +
"    }\n" +
"\n" +
"    return items;\n" +
"}";

private String jsmerge = "" + 
"var a;\n" +
"\n" +
"function seta(var x){\n" +
"	a = x;\n" +
"}\n" +
"function mergeSort(arr)\n" +
"{\n" +
"    if (arr.length < 2)\n" +
"        return arr;\n" +
" \n" +
"    var middle = parseInt(arr.length / 2);\n" +
"    var left   = arr.slice(0, middle);\n" +
"    var right  = arr.slice(middle, arr.length);\n" +
" \n" +
"    return merge(mergeSort(left), mergeSort(right));\n" +
"}\n" +
" \n" +
"function merge(left, right)\n" +
"{\n" +
"    var result = [];\n" +
" \n" +
"    while (left.length && right.length) {\n" +
"        if (left[0] <= right[0]) {\n" +
"            result.push(left.shift());\n" +
"        } else {\n" +
"            result.push(right.shift());\n" +
"        }\n" +
"    }\n" +
" \n" +
"    while (left.length)\n" +
"        result.push(left.shift());\n" +
" \n" +
"    while (right.length)\n" +
"        result.push(right.shift());\n" +
" \n" +
"    return result;\n" +
"}";

private String jsbubble = "" + 
"function BubbleSort(numArray)\n" +
"{\n" +
"	var i, j;\n" +
"	for (i = numArray.length - 1; i >= 0; i--)\n" +
"	{\n" +
"		for (j = 0; j <= i; j++)\n" +
"		{\n" +
"			if (numArray[j + 1] < numArray[j])\n" +
"			{\n" +
"				var temp = numArray[j];\n" +
"				numArray[j] = numArray[j + 1];\n" +
"				numArray[j + 1] = temp;\n" +
"			}\n" +
"		}\n" +
"	}\n" +
"	return numArray;\n" +
"}";

private String jsquick = "" + 
"function QuickSort(numbers, left, right)\n" +
"{\n" +
"	var length = numbers.length,\n" +
"	pivot,\n" +
"	partitionIndex;\n" +
"	\n" +
"	if (left < right)\n" +
"	{\n" +
"		pivot = right;\n" +
"		partitionIndex = partition(numbers, pivot, left, right);\n" +
"		QuickSort(numbers, left, partitionIndex - 1);\n" +
"		QuickSort(numbers, partitionIndex + 1, right);\n" +
"	}\n" +
"	return numbers;\n" +
"}\n" +
"\n" +
"function partition(numbers, pivot, left, right)\n" +
"{\n" +
"	var pivotValue = numbers[pivot],\n" +
"	partitionIndex = left;\n" +
"	\n" +
"	for (var i = left; i < right; i++)\n" +
"	{\n" +
"		if (numbers[i] < pivotValue)\n" +
"		{\n" +
"			SwapQuick(numbers, i, partitionIndex);\n" +
"			partitionIndex++;\n" +
"		}\n" +
"	}\n" +
"	SwapQuick(numbers, right, partitionIndex);\n" +
"	return partitionIndex;\n" +
"}\n" +
"\n" +
"function SwapQuick(numbers, i, j)\n" +
"{\n" +
"	var temp = numbers[i];\n" +
"	numbers[i] = numbers[j];\n" +
"	numbers[j] = temp;\n" +
"}";

private String jsheap = "" + 
"var arrayLength;\n" +
"function HeapRoot(input, i)\n" +
"{\n" +
"	var left = 2 * i + 1;\n" +
"	var right = 2 * i + 2;\n" +
"	var max = i;\n" +
"	if (left < arrayLength && input[left] > input[max])\n" +
"	{\n" +
"		max = left;\n" +
"	}\n" +
"	if (right < arrayLength && input[right] > input[max])\n" +
"	{\n" +
"		max = right;\n" +
"	}\n" +
"	if (max != i)\n" +
"	{\n" +
"		SwapHeap(input, i, max);\n" +
"		HeapRoot(input, max);\n" +
"	}\n" +
"}\n" +
"\n" +
"function SwapHeap(input, indexA, indexB)\n" +
"{\n" +
"	var temp = input[indexA];\n" +
"	input[indexA] = input[indexB];\n" +
"	input[indexB] = temp;\n" +
"}\n" +
"\n" +
"function HeapSort(input)\n" +
"{\n" +
"	arrayLength = input.length;\n" +
"	for (var i = Math.floor(arrayLength / 2); i >= 0; i -= 1)\n" +
"	{\n" +
"		HeapRoot(input, i);\n" +
"	}\n" +
"	for (i = input.length - 1; i > 0; i--)\n" +
"	{\n" +
"		swap(input, 0, i);\n" +
"		arrayLength--;\n" +
"		HeapRoot(input, 0);\n" +
"	}\n" +
"}";

private String pseudobubble = "" + 
"func BubbleSort(var a as array) \n" +
"	bound = N - 1\n" +
"	for i from 1 to N\n" +
"		newbound = 0\n" +
"		for j from 0 to bound\n" +
"			if a[j] > a[j + 1]\n" +
"				swap(a[j], a[j + 1])\n" +
"				newbound = j - 1\n" +
"		bound = newbound\n" +
"end func";

private String pseudoquick = "" + 
"QuickSort(double[] a)\n" +
"if (a.length <= 1)\n" +
"	return;\n" +
"Select a pivot;\n" +
"Partition a[] in 2 halves:\n" +
"	left[]: elements <= pivot\n" +
"	right[]: elements > pivot\n" +
"Sort left[];\n" +
"Sort right[];\n" +
"Concatenate: left[] pivot right[]";
		
private String pseudoheap = "" + 
"procedure heapsort(a, count) is\n" +
"    input: an unordered array a of length count\n" +
"	heapify(a, count)\n" +
"	end ← count - 1\n" +
"   while end > 0 do\n" +
"		swap(a[end], a[0])\n" +
"		end ← end - 1\n" +
"		siftDown(a, 0, end)\n" +
"procedure heapify(a, count) is\n" +
"	start ← iParent(count-1)\n" +
"	while start ≥ 0 do\n" +
"		siftDown(a, start, count - 1)\n" +
"		start ← start - 1\n" +
"procedure siftDown(a, start, end) is\n" +
"    root ← start\n" +
"	while iLeftChild(root) ≤ end do\n" +
"	child ← iLeftChild(root)\n" +
"	swap ← root\n" +
"	if a[swap] < a[child]\n" +
"		swap ← child\n" +
"	if child+1 ≤ end and a[swap] < a[child+1]\n" +
"		swap ← child + 1\n" +
"	if swap = root\n" +
"		return\n" +
"	else\n" +
"		swap(a[root], a[swap])\n" +
"		root ← swap\n" +
"		\n" +
"procedure siftUp(a, start, end) is\n" +
"	input:\n" +
"	child := end\n" +
"	while child > start\n" +
"		parent := iParent(child)\n" +
"		if a[parent] < a[child] then\n" +
"			swap(a[parent], a[child])\n" +
"			child := parent\n" +
"		else\n" +
"			return";

//TODO: Still need pseudo merge and insert
private String pseudoinsert;
private String pseudomerge;

public String python(String algo) {
	switch(algo) {
	case "bubble":
		return pBubble;
	case "merge":
		return pmerge;
	case "quick":
		return pquick;
	case "heap":
		return pheap;
	case "insertion":
		return pinsert;
	default:
		System.out.println("This shouldn't happen");
	}
	return null;
}

public String cpp(String algo) {
	switch(algo) {
	case "bubble":
		return cbubble;
	case "merge":
		return cmerge;
	case "quick":
		return cquick;
	case "heap":
		return cheap;
	case "insertion":
		return cinsert;
	default:
		System.out.println("This shouldn't happen");
	}
	return null;
}

public String java(String algo) {
	switch(algo) {
	case "bubble":
		return jbubble;
	case "merge":
		return jmerge;
	case "quick":
		return jquick;
	case "heap":
		return jheap;
	case "insertion":
		return jinsert;
	default:
		System.out.println("This shouldn't happen");
	}
	return null;
}

public String jscript(String algo) {
	switch(algo) {
	case "bubble":
		return jsbubble;
	case "merge":
		return jsmerge;
	case "quick":
		return jsquick;
	case "heap":
		return jsheap;
	case "insertion":
		return jsinsert;
	default:
		System.out.println("This shouldn't happen");
	}
	return null;
}

public String pseudo(String algo) {
	switch(algo) {
	case "bubble":
		return pseudobubble;
	case "merge":
		return pseudomerge;
	case "quick":
		return pseudoquick;
	case "heap":
		return pseudoheap;
	case "insertion":
		return pseudoinsert;
	default:
		System.out.println("This shouldn't happen");
	}
	return null;
}
}
