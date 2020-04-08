public class newSorting {

    //Starting method, calls helper recursive method
    public static void newSorting(int[] A, int size){
        newSortingHelper(A, 0, A.length - 1, size);
    }

    //'start' and 'end' represent the start and end indexes of the array currently being sorted
    private static void newSortingHelper(int[] A, int start, int end, int size){

        //Base case to enter quickSort()
        if(end - start + 1 <= size){
            quickSort(A, 0, A.length - 1);
            return;
        }

        //Base case for mergeSort()
        if(end - start == 0)
            return;

        //Sorting right half, then left half, then merging them
        newSortingHelper(A, start, (start + end)/2, size);
        newSortingHelper(A, (start + end)/2 + 1, end, size);
        mergeSortedHalves(A, start, (start+ end)/2, (start + end)/2 + 1, end);

    }

    //Inside parameter are start and end indexes of the two halves being merged
    private static void mergeSortedHalves(int[] A, int start1, int end1, int start2, int end2){

        //Creating array where result will be stored
        int[] arr3 = new int[end2 - start1 + 1];

        //i1 and i2 represent current indexes of the pair of numbers being compared from both halves,
        //choosing which one is smaller to go inside arr3
        int i1 = start1;
        int i2 = start2;
        for(int i = 0; i < arr3.length; i++){

            //When all elements of the 1st half have been sorted into arr3
            if(i1 > end1 && i2 <= end2){
                arr3[i] = A[i2];
                i2++;
            }
            //When all elements of the 2nd half have been sorted into arr3
            else if(i2 > end2 && i1 <= end1){
                arr3[i] = A[i1];
                i1++;
            }

            //Choosing which one is smaller to go inside arr3
            else if(i1 <= end1 && i2 <= end2){
                if(A[i1] < A[i2]){
                    arr3[i] = A[i1];
                    i1++;
                }else{
                    arr3[i] = A[i2];
                    i2++;
                }
            }
        }

        //Copying everything from arr3 back to the original
        for(int i = start1; i <= end2; i++) {
            A[i] = arr3[i - start1];
        }
    }

    //Base case to quickSort
    private static void quickSort(int[] A, int i, int j){

        //Base case
        if(j - i == 1){
            if(A[j] < A[i]){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }if(j - i < 2)
            return;

        //Choosing the number of which the partition is based of
        int pivot = A[i];

        //cStart and cEnd are the indexes of the elements currently being compared
        int cStart = i + 1;
        int cEnd = j;

        //Until everything is sorted
        while(cStart < cEnd){

            //Until you reach when the numbers are on the wrong side of the partition
            while(cStart <= cEnd && A[cStart] <= pivot)
                cStart++;
            while(cStart <= cEnd && A[cEnd] > pivot)
                cEnd--;

            //Switch the wrong numbers
            if(cStart < cEnd){
                int temp = A[cStart];
                A[cStart] = A[cEnd];
                A[cEnd] = temp;
            }
        }

        //Swap the pivot, so you don't make the same comparison
        A[i] = A[cEnd];
        A[cEnd] = pivot;

        //Recursive call for the partitioned sections
        quickSort(A, i, cEnd);
        quickSort(A, cStart, j);
    }
}
