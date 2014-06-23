package Data_structure_basic;
public class Sorting {

	public static void main(String[] args)	{
		int[] a = {5,4,7,8,6};
		printArr(a);
		selectionSort(a);
		printArr(a);
		
	}		
	
	// or bucketSort
	public static void countingSort(int[] a, int max)	{
		int[] bucket=new int[max+1];	
		for(int i = 0; i < max+1; i ++)
		System.out.println("bucket value:" + bucket[i]);
		for(int i = 0; i < a.length; i++)	{
			bucket[a[i]]++;
		}	
		// for a[]
		int aPos = 0; 
		
		// j for t[]
		for(int j = 0; j < bucket.length; j++)	{					
			for(int times = 0; times < bucket[j]; times++)	{
				a[aPos] = j;
				aPos++;				
			}
		}
		
	}
	
	public static void insertionSort(int[] a)	{
		System.out.println("Insertion sort:");
		for(int i=1; i<a.length; i++)	{
			
			// k = i;  k>0 && a[k] < a[k-1]  are the most important part
			for(int k=i; k>0 && a[k] < a[k-1]; k--)	{
				int temp = a[k-1];
				a[k-1] = a[k];
				a[k] = temp;
			}
		}
	}
	
	
	public static void bubbleSort(int[] a)	{
		System.out.println("Bubble sort:");
		for(int i = 0; i<a.length; i++)	{
			boolean isSwapped = false;
			
			// j starts from 1 and ends at a.length - i
			for(int j = 1; j < a.length - i; j++)	{
				if(a[j] < a[j-1])	{
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
					isSwapped = true;
				}				
			}
			if(!isSwapped)	break;
		}
	}

	
	public static void selectionSort(int a[])	{
		System.out.println("Selection sort:");
		int min = 0;
		for(int i = 0; i<a.length; i++)	{
			min = i;
			
			// important: initialization j = i+1
			for(int j = i+1; j< a.length;j++)	{
				if(a[min] > a[j])
					min = j;
			}
			
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;	
		}	
	}
	
	public static void printArr(int arr[]){
		String sum="";
		for(int a : arr){
			sum+=a+" ";
		}
		System.out.println("Now arr: "+sum); 
	}	
	
}
