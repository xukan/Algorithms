package com.xk;
/*
 * shell�����ڿ�ʼʱ����d�ϴ󣬷���϶࣬��ÿ���Ԫ�ؽ��٣��ʸ�����ֱ�Ӳ���Ͽ죬��������d����С���������𽥼��٣�
 * �������Ԫ����Ŀ�����࣬������֮ǰ�Ź���ʹ���нϽӽ�������״̬�������µ�һ���������Ҳ�Ͽ졣��ˣ�shell������Ч���Ͻ�ֱ�Ӳ��������нϴ�ĸĽ���
 * shell����ܹؼ���һ����ǲ������е�ѡ�����������е�ѡ�������������Ч�ʡ�һ��Ľ�����d(1) = [ n / 2 ]��d(i+1) = [ (d(i) - 1) / 3 ]��
 * һ����Ϊd��ȡ�����һ���Ϊ�ã����Ⲣû�еõ������ϵ�֤�������һ������һ��Ϊ1�����Ǳ�Ȼ�ġ�
 * ����shell�����ʱ�临�ӶȾ�˵���ѷ�У��������û�þ�����ۣ�ֻ���������ΪO(nlgn)~O(n^2)֮�䣬���ΪO(n^1.3)
 * 
 * */
public class Solution {
	//����ע�Ͱ�shell sort
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
				//��һ��ѭ���Ǵ�λ��0�ߵ�λ��0+gap
				//�����о���0, gap, 2gap... 1, 1+gap, 1+2gap... 2, 2+gap, 2+2gap...
				//��������,gap=6ʱ��
				//  45,23,11,89,77,98,4,28,65,43, 1,7,15
				//   |  _  _  _  _  _�������ߡ��ߡ��ߡ�  _  _ |
				//      |  _  _  _  _ _  | 
				//         |  _  _  _  _ _  | 
				//            |  _  _  _  _ _ | 
				//               |  _  _  _  _ _  | 
				//                  |  _  _  _  _ _ | 
				//��Ȼ�Ǵ�λ��0��ʼ��gap������ѭ����j+=gap��֤�˺����Ԫ��Ҳ�ܱ�����
				for(int j=i+gap;j<=high;j+=gap){
					/*
					 * ���ѭ���ǲ������� 
					 * �Ӻ���ǰ��,����gap = 1, j= 4, ��ʱ������ 4,11,23,43,1,7,15,28,65,89,77,98,45
					 * Ԫ����1�� ��ô43��1��43���ƣ�4,11��23�� null�� 43
					 *          23��1��23���ƣ�4,11��null,23,43
					 *          11��1��11���ƣ�4,null, 11,23,43
					 *          4��1��   4���ƣ�  null, 4, 11,23,43
					 *          ��1����λ��1�� �õ�1,4,11,23,43 
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
