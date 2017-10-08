package MinimumCoinChange.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class CoinArrayUtils {
    public static Integer[] convertToIntegerArray(ArrayList<Integer> array) {
        Object[] arr = array.toArray();
        return Arrays.copyOf(arr, arr.length, Integer[].class);
    }

    public static Optional<Integer> sumArray(ArrayList<Integer> array) {
        return sumArray(convertToIntegerArray(array));
    }

    public static Optional<Integer> sumArray(Integer[] array) {
        Stream<Integer> stream = Arrays.stream(array);
        Optional<Integer> sum = stream.reduce((left, right) -> {
            return left + right;
        });

        return sum;
    }
}
