
public class CodeHelper {
private String lang;
private String algo;
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
//TODO: Put rest of text in here
CodeHelper() {
	this.lang = lang;
	this.algo = algo;
}

public String python(String algo) {
	switch(algo) {
	case "bubble":
		break;
	case "merge":
		break;
	case "quick":
		return pquick;
	case "heap":
		break;
	case "insertion":
		break;
	default:
		System.out.println("This shouldn't happen");
	}
	return null;
}

public String cpp() {
	switch(algo) {
	case "bubble":
		break;
	case "merge":
		break;
	case "quick":
		break;
	case "heap":
		break;
	case "insertion":
		break;
	default:
		System.out.println("This shouldn't happen");
	}
	return algo;
}

public String java() {
	switch(algo) {
	case "bubble":
		break;
	case "merge":
		break;
	case "quick":
		break;
	case "heap":
		break;
	case "insertion":
		break;
	default:
		System.out.println("This shouldn't happen");
	}
	return algo;
}

public String jscript() {
	switch(algo) {
	case "bubble":
		break;
	case "merge":
		break;
	case "quick":
		break;
	case "heap":
		break;
	case "insertion":
		break;
	default:
		System.out.println("This shouldn't happen");
	}
	return algo;
}

public String pseudo() {
	switch(algo) {
	case "bubble":
		break;
	case "merge":
		break;
	case "quick":
		break;
	case "heap":
		break;
	case "insertion":
		break;
	default:
		System.out.println("This shouldn't happen");
	}
	return algo;
}
}
