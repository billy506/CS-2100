package priorityqueue;

import java.util.ArrayList;

public class HeapSort {
	
	/* Accepts a list of type T and updates that list to be in sorted order. */
	public static <T extends Comparable<T>> void heapSort(T[] list) {
		int child;
		T father; 
		for (int i = list.length / 2; i >= 0; i--){ 
			for (father = list[i]; leftChild(i) < list.length; i = child) {
				child = leftChild(i);
				
				// 如果左子树小于右子树，则需要比较右子树和父节点
				if (child != list.length - 1 && list[child].compareTo(list[child + 1])<0) {
					child++; // 序号增1，指向右子树
				}
				
				// 如果父节点小于孩子结点，则需要交换
				if (father.compareTo(list[child])<0) {
					list[i] = list[child];
				} else {
					break; // 大顶堆结构未被破坏，不需要调整
				}
			}
			list[i] = father;
		}
	}
	
	private static int leftChild(int i) {
		return 2 * i + 1;
	}

}
