package cn.horizon.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

	/**
	 * 快速排序
	 * 
	 * @param a
	 *            数组a
	 * @param start
	 *            开始位置
	 * @param end
	 *            结束位置
	 */
	private static void quickSort(Integer[] a, int start, int end) {

		int left = start; // 左边界
		int right = end - 1; // 右边界

		int pivot = a[end]; // 中枢值

		while (left < right) {// 确保left < right ，退出：left == right
			if (a[left] <= pivot) { // 如果a[left]< pivot，那么左边界 left++
				left++;
				continue;
			}
			if (a[right] > pivot) { // 如果 a[right] > pivot ,那么右边界 right --
				right--;
				continue;
			}
			/*
			 * 交换位置。 注意： left++ ： 因为交换后的left 就是 a[right] 对应的值，a[right] 是<=
			 * pivot。 right--：因为 a[right] 对应的值是 a[left] 是> pivot
			 */
			swap(a, left++, right--);
		}

		// 如果left的值 小于 pivot,那么可以确认a[left]
		// 在pivot之前，那么left++,就可以把left++的值和pivot交换了
		if (a[left] < pivot) {
			left++;
		}
		swap(a, left, end); // 把中枢值放到 left的位置 ，把left现在这个较大的值放到最后面去吧。

		if (left - 1 > start) { // pivot 的左侧排序
			quickSort(a, start, left - 1);
		}
		if (left + 1 < end) { // pivot 的右侧排序
			quickSort(a, left + 1, end);
		}
	}

	public static void swap(Integer[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	private static Integer[] initUnSortData(int size) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(new Random(i).nextInt(i + 1));
		}
		return list.toArray(new Integer[list.size()]);
	}
	
	
    public static void main(String[] args) {  
        Integer[] arr = initUnSortData(10);  
        quickSort(arr);  
        for (int i = 0; i < arr.length; i++) {  
            System.out.print(arr[i] + "  ");  
        }  
    }  
  
    public static void quickSort(Integer[] a) {  
        quickSort(a, 0, a.length - 1);  
    }  

}
