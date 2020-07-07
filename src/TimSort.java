import java.util.Arrays;

public class TimSort {
    static int run = 32;

    public static void insertionsort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void mergesort(int[] arr, int left, int mid, int right) {
        int leftArraySize = mid - left + 1;
        int rightArraySize = right - mid;
        int[] leftarr = new int[leftArraySize];
        int[] rightarr = new int[rightArraySize];
        for (int i = 0; i < leftArraySize; i++) {
            leftarr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArraySize; i++) {
            rightarr[i] = arr[mid + 1 + i];
        }
        int l = 0;
        int r = 0;
        int main = left;
        while (l < leftArraySize && r < rightArraySize) {
            if (leftarr[l] < rightarr[r]) {
                arr[main] = leftarr[l];
                l++;
            } else if (leftarr[l] >= rightarr[r]) {
                arr[main] = rightarr[r];
                r++;
            }
            main++;
        }
        System.out.println("after merging " + Arrays.toString(arr));

        while (l < leftArraySize) {
            arr[main] = leftarr[l];
            l++;
            main++;
        }

        while (r < rightArraySize) {
            arr[main] = rightarr[r];
            r++;
            main++;
        }
        System.out.println("appending leftover elemets " + Arrays.toString(arr));


    }

    public static void timsort(int[] arr, int arrSize) {
        for (int i = 0; i < arrSize; i += run) {
            System.out.println("part1");
            int left = i;
            int right = Math.min((i + run - 1), arrSize - 1);
            //sorting the part of array using insertion sort
            insertionsort(arr, left, right);
            System.out.println("insertion sorting is good: " + Arrays.toString(arr));
        }
        //whent the part of array equal to the size of run is sorted individually using insertion sort
        //then we merge these sorted parts using merge sortKk
        for (int size = run; size < arrSize; size = size * 2) {
            for (int left = 0; left < arrSize; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), arrSize - 1);
//                int mid=(left+right)/2;
                System.out.println(left + " " + mid + " " + right);
                mergesort(arr, left, mid, right);
            }
        }
    }
}
