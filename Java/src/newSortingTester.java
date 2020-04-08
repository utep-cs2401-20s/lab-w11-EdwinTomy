import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class newSortingTester {

    //1st Test Case
    //Testing with duplicate numbers
    //test: PASSED
    @Test
    public void test1(){
        newSorting ns = new newSorting();
        int[] arr = new int[] {2, 2, 3, 5, 4, 3};
        int[] exp = new int[] {2, 2, 3, 3, 4, 5};

        ns.newSorting(arr, 3);
        assertArrayEquals(exp, arr);
    }

    //2nd Test Case
    //Testing with negative numbers
    //test: PASSED
    @Test
    public void test2(){

        newSorting ns = new newSorting();
        int[] arr = new int[] {2, -8, 3, 5, 4, -1};
        int[] exp = new int[] {-8, -1, 2, 3, 4, 5};

        ns.newSorting(arr, 3);
        assertArrayEquals(exp, arr);

    }

    //3rd Test Case
    //Testing with size greater than array length,
    //meaning using only quickSort
    //test: PASSED
    @Test
    public void test3(){

        newSorting ns = new newSorting();
        int[] arr = new int[] {2, 8, 3, 5, 4, 1};
        int[] exp = new int[] {1, 2, 3, 4, 5, 8};

        ns.newSorting(arr, 7);
        assertArrayEquals(exp, arr);

    }

    //4th Test Case
    //Testing with size 0,
    //meaning using only mergeSort
    //test: PASSED
    @Test
    public void test4(){

        newSorting ns = new newSorting();
        int[] arr = new int[] {2, 5, 7, 1, 0};
        int[] exp = new int[] {0, 1, 2, 5, 7};

        ns.newSorting(arr, 0);
        assertArrayEquals(exp, arr);

    }

    //5th Test Case
    //Testing worst case, in reverse order
    //test: PASSED
    @Test
    public void test5(){

        newSorting ns = new newSorting();
        int[] arr = new int[] {6, 5, 4, 3, 2, 1};
        int[] exp = new int[] {1, 2, 3, 4, 5, 6};

        ns.newSorting(arr, 2);
        assertArrayEquals(exp, arr);

    }
}
