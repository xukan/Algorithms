package com.xk;
//���������ʱ�临�Ӷ�ΪO(N+K)���ռ临�Ӷ�ΪO(N+K)����K���Ǻܴ�ʱ������һ������Ч�����������㷨��
//����Ҫ���ǣ�����һ���ȶ������㷨������������ֵͬ��Ԫ��ԭ�е����λ�ò��ᷢ���ı�(������Order��)�����Ǽ����������Ҫ��һ�����ʣ�
//���Ǹ���������ʣ����ǲ��ܰ���Ӧ�õ���������
public class Solution {
	 public static void main(String[] argv) {
	        int[] A = countingSort(new int[]{16, 4, 7, 14, 7, 9, 3, 2, 8, 7});
	        for(int i:A)
	        System.out.print(i+" ");
	    }
	 
	    public static int[] countingSort(int[] A) {
	        int[] B = new int[A.length]; 
	        // ����A�е�����a'�У�0<=a' && a' < k����k=100
	        int k = 17;
	        countingSort(A, B, k);
	        return B;
	    }
	 
	    private static void countingSort(int[] A, int[] B, int k) {
	        int[] C = new int[k];
	        // ����
	        for (int j = 0; j < A.length; j++) {
	            int a = A[j];
	            C[a] += 1;
	        }
	        System.out.println(C);
	        // �������
	        for (int i = 1; i < k; i++) {
	            C[i] = C[i] + C[i - 1]; 
	        }
	        System.out.println(C);
	        // ����
	        for (int j = A.length - 1; j >= 0; j--) {
	            int a = A[j];
	            B[C[a] - 1] = a;
	            C[a] -= 1;
	        }
	    }
}
