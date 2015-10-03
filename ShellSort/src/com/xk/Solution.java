package com.xk;
/*
 * shell排序在开始时步长d较大，分组较多，但每组的元素较少，故各组内直接插入较快，后来步长d逐渐缩小，分组数逐渐减少，
 * 而各组的元素数目逐渐增多，但由于之前排过序，使序列较接近于有序状态，所以新的一趟排序过程也较快。因此，shell排序在效率上较直接插人排序有较大的改进。
 * shell排序很关键的一点就是步长序列的选定，步长序列的选定决定着排序的效率。一般的建议是d(1) = [ n / 2 ]，d(i+1) = [ (d(i) - 1) / 3 ]，
 * 一般认为d都取奇数且互素为好，但这并没有得到理论上的证明。最后一个步长一定为1，这是必然的。
 * 关于shell排序的时间复杂度据说很难分校，理论上没用具体结论，只是提出大致为O(nlgn)~O(n^2)之间，大概为O(n^1.3)
 * 
 * */
public class Solution {
	//不带注释版shell sort
//	public static void shellSort(int[] array){
//		int len = array.length;
//		int high = len-1;
//		int gap = len/2;
//		while(gap>=1){
//			for(int i=0;i<gap;i++){
//				for(int j=i+gap;j<=high;j+=gap){
//					int temp = array[j];
//					int k=j;
//					while(k>i&&temp<array[k-gap]){
//						array[k] = array[k-gap];
//						k-=gap;
//					}
//					array[k] = temp;
//				}
//			}
//			if(gap ==2||gap ==3)
//				gap =1;
//			else
//				gap= (gap-1)/3;
//		}
//	}
	
	
	public static void shellSort(int[] array){
		int len = array.length;
		int high = len-1;
		int gap = len/2;
		while(gap>=1){
			for(int i=0;i<gap;i++){
				//第一层循环是从位置0走到位置0+gap
				//数组中就是0, gap, 2gap... 1, 1+gap, 1+2gap... 2, 2+gap, 2+2gap...
				//这道题就是,gap=6时，
				//  45,23,11,89,77,98,4,28,65,43, 1,7,15
				//   |  _  _  _  _  _　｜　＿　＿　＿　  _  _ |
				//      |  _  _  _  _ _  | 
				//         |  _  _  _  _ _  | 
				//            |  _  _  _  _ _ | 
				//               |  _  _  _  _ _  | 
				//                  |  _  _  _  _ _ | 
				//虽然是从位置0开始到gap，下面循环中j+=gap保证了后面的元素也能遍历到
				for(int j=i+gap;j<=high;j+=gap){
					/*
					 * 这层循环是插入排序， 
					 * 从后往前排,比如gap = 1, j= 4, 此时数组是 4,11,23,43,1,7,15,28,65,89,77,98,45
					 * 元素是1， 那么43比1大，43后移，4,11，23， null， 43
					 *          23比1大，23后移，4,11，null,23,43
					 *          11比1大，11后移，4,null, 11,23,43
					 *          4比1大，   4后移，  null, 4, 11,23,43
					 *          把1插入位置1， 得到1,4,11,23,43 
					 * */
					int temp = array[j];
					int k=j;
					while(k>i&&temp<array[k-gap]){
						array[k]= array[k-gap];
						k-=gap;
					}
					array[k] = temp;
				}
			}
			if(gap ==2 || gap ==3)
				gap =1;
			else
				gap = (gap-1)/3;
		}
	}
	
	public static void main(String a[]){
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43,1,7,15};
        shellSort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
