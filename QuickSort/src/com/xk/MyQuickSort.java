package com.xk;
//快排是不稳定的排序算法
public class MyQuickSort {
	//不带注释版
//	public static void quickSort(int[] array, int low, int high){
//		if(low>=high)
//			return;
//		int pivot = QuickSort_Partition(array, low, high);
//		quickSort(array, low, pivot-1);
//		quickSort(array, pivot+1, high);
//	}
//	
//	public static int QuickSort_Partition(int[] array, int low, int high){
//		int pivot = array[low];
//		int i=low+1;
//		int j=high;
//		while(i<=j){
//			while(i<=j && pivot>=array[i])
//				i++;
//			while(i<=j && pivot<=array[j])
//				j--;
//			if(i<j){
//				swap(array, i, j);
//				i++;
//				j--;
//			}
//		}
//		array[low] = array[j];
//		array[j] = pivot;
//		return j;
//	}
//	
//	private static void swap(int[] array, int i, int j) {
//		int temp = array[i];
//		array[i] = array[j];
//		array[j] = temp;
//	}
	
    public static void quickSort(int[] array, int low, int high) {
    	if(low>=high)
    		return;
        int pivot = QuickSort_Partition(array, low, high);  
        quickSort(array, low, pivot - 1);  
        quickSort(array, pivot + 1, high);  
    }
 
    public static int QuickSort_Partition(int[] array, int lowerIndex, int higherIndex) {
        // calculate pivot number, I am taking pivot as leftmost index number
        int pivot = array[lowerIndex];
        
        int i = lowerIndex+1;
        int j = higherIndex;
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (i<=j&& array[i] <= pivot) {
                i++;
            }
            while (i<=j&&array[j] >= pivot) {
                j--;
            }
            if (i < j) {//注意这里是<
                swap(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        
        array[lowerIndex] = array[j];  //每次到这里,j=i-1
        array[j] = pivot;  //到这里，数组中index<j的数都比pivot小，index>j的数都比pivot大
        return j;
    }
 
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        quickSort(input, 0, input.length-1);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}

