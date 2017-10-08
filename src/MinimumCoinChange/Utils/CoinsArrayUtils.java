package MinimumCoinChange.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoinsArrayUtils {
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

    public static void elementsFrequency(Integer[] array, BiConsumer<Integer, Integer> action) {
        Arrays.stream(array)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((key, value) -> {
                    action.accept(key, value.size());
                });
    }
}
