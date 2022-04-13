package sorting;

public class AdvancedSorts {

	
	
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		if(i>=j) {return ;}
		int mid = (i+j)/2;
		mergeSort(list, i, mid);
		mergeSort(list, mid + 1, j);
        merge(list, i, mid, j);
	}
	
	private static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		T[] tmp = (T[]) new Comparable[list.length];
        int r1 = mid + 1;
        int tIndex = i;
        int cIndex=i;
        //����鲢
        while(i <=mid && r1 <= j) {
            if (list[i].compareTo(list[r1])<=0)
                tmp[tIndex++] = list[i++];
            else
                tmp[tIndex++] = list[r1++];
        }
            //�����ʣ��Ĺ鲢
            while (i <=mid) {
                tmp[tIndex++] = list[i++];
            }
            //���ұ�ʣ��Ĺ鲢
            while ( r1 <= j ) {
                tmp[tIndex++] = list[r1++];
            }
            //����ʱ���鿽����ԭ����
            while(cIndex<=j){
                list[cIndex]=tmp[cIndex];
                cIndex++;
            }
	}
	
	
	
	
	
	
	
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		if (i >= j) {return;}
        // ��ȡ������
		
        int q = partition(list, i, j);
        quickSort(list, i, q - 1);
        quickSort(list, q + 1, j);
	}
	private static<T extends Comparable<T>> int partition(T[] list, int i, int j) {
		T pivot = list[j];
        int p = i;
        for (int x = i; x < j; x++) {
            if (list[x].compareTo(pivot)<0) {
                T temp = list[p];
                list[p] = list[x];
                list[x] = temp;
                p++;
            }
        }
        	T temp = list[p];
        	list[p] = list[j];
        	list[j] = temp;
        	return p;
    	}
	}
	
