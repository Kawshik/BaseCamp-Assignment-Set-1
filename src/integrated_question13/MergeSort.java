package integrated_question13;

public class MergeSort {
	
	void merge(Movie[] arr,int startIndex,int midIndex,int endIndex){
		//declare two temp arrays sizes
		int arr_size_left = midIndex - startIndex + 1;
		int arr_size_right = endIndex - midIndex;
		
		//create two temp arrays
		Movie[] leftArray = new Movie[arr_size_left];
		Movie[] rightArray = new Movie[arr_size_right];
		
		//fill the left array with left values
		for(int i=0;i<arr_size_left;++i) {
			leftArray[i] = arr[startIndex+i];
		}
		
		//fill the right array with right values
		for(int i=0;i<arr_size_right;++i) {
			rightArray[i] = arr[midIndex+i+1];
		}
		
		//check each value for both the arrays and add the to the main array
		int i=0,j=0,k=startIndex;
		while(i<arr_size_left && j<arr_size_right) {
			if(leftArray[i].getRating()<=rightArray[j].getRating()) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		//put the left over items into the main array form the left array
		while(i<arr_size_left) {
			arr[k] = leftArray[i];
			i++;
			k++;
		} 
		
		//put the left over items into the main array form the right array
		while(j<arr_size_right) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	void mergeSort(Movie[] arr, int startIndex, int endIndex) {
		if(startIndex<endIndex) {
			int midIndex =  (endIndex + startIndex)/2;
			mergeSort(arr, startIndex, midIndex);
			mergeSort(arr, midIndex+1, endIndex);			
			
			merge(arr,startIndex,midIndex,endIndex);
		}
	}
}
