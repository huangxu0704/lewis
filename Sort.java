package demo;

public class Sort {
	
	public static void main(String[] args) {
		int[] arr = {6,2,88,32,3,45,9,1};
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
//		System.out.println("Ñ¡ÔñÅÅÐò£º");
//		selectSort(arr);
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}
		
//		System.out.println("²åÈëÅÅÐò£º");
//		insertSort(arr);
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}

//		System.out.println("Ã°ÅÝÅÅÐò£º");
//		insertSort(arr);
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}
		
//		System.out.println("¿ìËÙÅÅÐò£º");
//		quickSort(arr, 0,arr.length-1 );
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}
		
//		System.out.println("¹é²¢ÅÅÐò£º");
//		mergeSort(arr, 0, arr.length-1);
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}
		
		System.out.println("Ï£¶ûÅÅÐò£º");
		shellSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void shellSort(int[] a) {
		int len=a.length;
		int i,j,h;
		int temp;
		for(h=len/2;h>0;h=h/2) {
			for(i=h;i<len;i++) {
				temp=a[i];
				for(j=i-h;j>=0;j-=h) {
					if(temp<a[j]) {
						a[j+h]=a[j];
					}
					else {
						break;
					}
				}
				a[j+h]=temp;
			}
		}
	}
	
	public static void mergeSort(int[] a,int p,int r) {
		if(p<r) {
			int q=(p+r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void merge(int[] arr,int p,int q,int r) {
		int i,j,k,n1,n2;
		n1=q-p+1;
		n2=r-q;
		int[] left=new int[n1];
		int[] right=new int[n2];
		for(i=0,k=p;i<n1;i++,k++) {
			left[i]=arr[k];
		}
		for(i=0,k=q+1;i<n2;i++,k++) {
			right[i]=arr[k];
		}
		for(k=p,i=0,j=0;i<n1&&j<n2;k++) {
			if(left[i]>right[j]) {
				arr[k]=left[i];
				i++;
			}
			else {
				arr[k]=right[j];
				j++;
			}
		}
		if(i<n1) {
			for(int m=i;m<n1;m++,k++) {
				arr[k]=left[m];
			}
		}
		if(j<n2) {
			for(int n=j;n<n2;n++,k++) {
				arr[k]=right[n];
			}
		}
	}
	
	public static void quickSort(int[] a,int low,int high) {
		int i,j;
		int index;
		if(low>=high) {
			return;
		}
		
		i=low;
		j=high;
		index=a[i];
		while(i<j) {
			while(i<j&&a[j]<=index) {
				j--;
			}
			if(i<j) {
				a[i++]=a[j];
			}
			while(i<j&&a[i]>=index) {
				i++;
			}
			if(i<j) {
				a[j--]=a[i];
			}
		}
		a[i]=index;
		quickSort(a, low, i-1);
		quickSort(a, i+1, high);
	}
	
	public static void selectSort(int[] a) {
		int temp=0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	
	public static void insertSort(int[] a) {
		if(a!=null) {
			for(int i=1;i<a.length;i++) {
				int temp=a[i];
				int j=i;
				if(a[j-1]>temp) {
					while(j>=1&&a[j-1]>temp) {
						a[j]=a[j-1];
						j--;
					}
				}
				a[j]=temp;
			}
		}
	}
	
	public static void bubbleSort(int[] a) {
		int temp=0;
		for(int i=0;i<a.length-1;i++) {
			for(int j=0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
}
