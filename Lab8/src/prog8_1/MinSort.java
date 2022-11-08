package prog8_1;

import java.util.Arrays;

public class MinSort {
	public MinSort(String[] input) {
		this.arr = input;
	}
	private String[] arr;

//	public void sort() {
//		if (arr == null || arr.length <= 1)
//			return;
//		int len = arr.length;
//		for (int i = 0; i < len; ++i) {
//			// find position of min value from arr[i] to arr[len-1]
//			int nextMinPos = minpos(i, len - 1);
//
//			// place this min value at position i
//			swap(i, nextMinPos);
//		}
//	}

	
	public void minsort()
	{
		if(arr==null || arr.length<=1) return;
		for(int i=0;i<arr.length;++i)
		{
			int nextMinPos=minpos(i,arr.length-1);
			swap(i,nextMinPos);
		}
	}
	// Swaps values arr[i], arr[j]
	void swap(int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Returns pos of min value from
	// positions i to j
	int minpos(int i, int j) {
		int pos = i;
		String min = arr[i];
		for (int k = i + 1; k <= j; ++k) {
			if (arr[k].compareTo(min)<0) {
				pos = k;
				min = arr[k];
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		String[] arr = {"Karna","Arjun","Pukar","Navraj"};
		MinSort ms = new MinSort(arr);
		ms.minsort();
		System.out.println(Arrays.toString(arr));
		
	}

}
