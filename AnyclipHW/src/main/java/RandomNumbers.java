import java.util.*;

public class RandomNumbers {
    static int counter = 0;
    static Integer[] arr = new Integer[1000];

    public static int getNumber () {
        if (counter ==0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i+1;
            }
            Collections.shuffle(Arrays.asList(arr));
        }

        if (counter == 1000) return 0;

        counter++;
        return arr[counter-1];
    }
}
