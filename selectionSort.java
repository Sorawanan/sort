class SelectionSort {
    void sort(int array[]){
        int number=array.length;
        // One by one move boundary of unsorted subArray
        for (int i=0;i<number-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx=i;
            for(int j=i+1;j<number;j++){
                if(array[j]<array[min_idx]){
                    min_idx=j;
                }
            }
            // Swap the found minimum element with the first
            // element
            int temp=array[min_idx];
            array[min_idx]=array[i];
            array[i]=temp;
        }
    }
    // Prints the array
    void printArray(int array[]) {
        int n = array.length;
        for(int i=0; i<n; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[]) {
        SelectionSort ob = new SelectionSort();
        int array[] = {64,25,12,22,11};
        ob.sort(array);
        System.out.println("Sorted array");
        ob.printArray(array);
    }
}