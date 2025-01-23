// Searching Algorithms¶

/*
 * Sequential/Linear search - typically starts at the first element in an array or ArrayList and looks through all the items 
 * one by one until it either finds the desired value 
 *
 * Binary search - can only be used on data that has been sorted or stored in order. It checks the middle of the data to see if 
 * that middle value is less than, equal, or greater than the desired value and then based on the results of that it narrows 
 * the search. It cuts the search space in half each time.
*/



// Sequential/Linear search 
/*
 * You can also look for a String in an array or list, but be sure to use equals rather than ==. Remember that == is only true 
 * when the two references refer to the same String object, while equals returns true if the characters in the two String 
 * objects are the same.
*/
public static int sequentialSearch(int[] elements, int target) { // Array
    for (int j = 0; j < elements.length; j++) {
        if (elements[j] == target) {
            return j;
        }
    }
    return -1;
}

public static int sequentialSearch(ArrayList<Integer> elements, int target) { // ArrayList
    for (int j = 0; j < elements.size(); j++) {
        if (elements.get(j) == target) {
            return j;
        }
    }
    return -1;
}



// Binary Search
/*
 * You can also use binary search with a String array. But, when you look for a String, be sure to use compareTo method rather 
 * than < or > which can only be used with primitive types. 
 */
public static int binarySearch(int[] elements, int target) {
    int left = 0;
    int right = elements.length - 1;
    while (left <= right) {
        int middle = (left + right) / 2;
        if (target < elements[middle]) {
            right = middle - 1;
        } else if (target > elements[middle]) {
            left = middle + 1;
        } else {
            return middle;
        }
    }
    return -1;
}



/**
 * @return a count of how many words checked before returning.
*/
public int linearSearch(String word) {
    for(int n = 0; n < dictionary.size(); n++) {
        if(dictionary.get(n).equals(word)) {
            return n+1; 
        }
    }
    return -1;
}

/**
 * @return a count of how many words checked before returning.
*/
public int binarySearch(String word) {
    int left = 0;
    int right = dictionary.size()-1;
    int count = 0;
    while(left <= right) { 
        count++;
        int middle = (right+left)/2;
        if(word.compareTo(dictionary.get(middle)) < 0) {
            right = middle - 1;
        } else if(0 < word.compareTo(dictionary.get(middle))) {
            left = middle + 1;
        } else {
            return count;
        }
    }
    return -1;
}



/*
 * Selection Sort - Select the smallest item from the current location on to the end of the array and swap it with the value at
 * the current position. Do this from index 0 to the array length - 2. You don’t have to process the last element in the array, 
 * it will already be sorted when you compare the prior element to the last element.
 *
 * Insertion Sort - Insert the next unsorted element in the already sorted part of the array by moving larger values to the right.
 * Start at index 1 and loop through the entire array.
 *
 * Merge sort - Break the elements into two parts and recursively sort each part. An array of one item is sorted (base case). 
 * Then merge the two sorted arrays into one. 
*/

// Selection Sort
/*
 * A selection sort always does the same number of comparisons and always 
 * takes the same time to execute regardless of the order of the data.
*/
public static void selectionSort(int[] elements) {
    for (int j = 0; j < elements.length - 1; j++) {
        int minIndex = j;
        for (int k = j + 1; k < elements.length; k++) {
            if (elements[k] < elements[minIndex]) {
                minIndex = k;
            }
        }
        int temp = elements[j];
        elements[j] = elements[minIndex];
        elements[minIndex] = temp;
    }
}


// insertion sort
/*
 * If the data is already sorted in the correct order you don't need to move any values.
 */
public static void insertionSort(int[] elements) {
    for (int j = 1; j < elements.length; j++) {
        int temp = elements[j];
        int possibleIndex = j;
        while (possibleIndex > 0 && temp < elements[possibleIndex - 1]) {
            elements[possibleIndex] = elements[possibleIndex - 1];
            possibleIndex--; 
        }
        elements[possibleIndex] = temp;
    }
}
