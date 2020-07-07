import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(read.readLine());
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(read.readLine());
        }
        TimSort obj = new TimSort();
        obj.timsort(arr, arrSize);
        System.out.println(Arrays.toString(arr));

    }
}
