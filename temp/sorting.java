package temp;
import java.util.*;
public class sorting {
    //O(n^2) time complexity
    public int[] bubbleSort(int[] originalArray){
        int n = originalArray.length;
        for(int i = 0; i < n - 1; ++i){
            for(int j = 0; j < n - i - 1; ++j){
                if(originalArray[j] > originalArray[j + 1]){
                    int temp = originalArray[j];
                    originalArray[j] = originalArray[j + 1];
                    originalArray[j + 1] = temp;
                }
            }
        }
        return originalArray;
    }

    //O(n^2) time complexity
    public int[] selectionSort(int[] originalArray){
        int n = originalArray.length;
        for(int i = 0; i < n - 1; ++i){
            int minIndex = i;
            for(int j = i + 1; j < n; ++j){
                if(originalArray[j] < originalArray[minIndex]){
                    minIndex = j;
                }
            }
            int temp = originalArray[i];
            originalArray[i] = originalArray[minIndex];
            originalArray[minIndex] = temp;
        }
        return originalArray;
    }

    //O(n) time complexity
    public boolean lineerSearch(int[] originalArray, int target){
        for(int i = 0; i < originalArray.length; ++i){
            if(originalArray[i] == target){
                return true;
            }
        }
        return false;
    }

    //O(log n) time complexity
    public int binarySearch(int[] originalArray, int target){
        int left = 0;
        int right = originalArray.length - 1;
        while(left <= right){
            int mid = (right + left) / 2;
            if(originalArray[mid] == target){
                return mid;
            }
            else if(originalArray[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
