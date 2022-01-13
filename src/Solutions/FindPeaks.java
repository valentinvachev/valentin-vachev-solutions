package Solutions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindPeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] numbersArray = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.println(findPeaks(numbersArray));
    }

    public static String findPeaks(long[] inputArray) {
        Map<Integer, Long> indexNumberPair = new LinkedHashMap<>();

        if (inputArray.length == 1) {
            indexNumberPair.put(0, inputArray[0]);
        } else {
            if (inputArray[0] > inputArray[1]) {
                indexNumberPair.put(0, inputArray[0]);
            }

            int lastIndex = inputArray.length - 1;
            int beforeLastIndex = inputArray.length - 2;

            for (int i = 1; i < lastIndex; i++) {
                if (inputArray[i] > inputArray[i - 1] && inputArray[i] > inputArray[i + 1]) {
                    indexNumberPair.put(i, inputArray[i]);
                }
            }

            if (inputArray[lastIndex] > inputArray[beforeLastIndex]) {
                indexNumberPair.put(lastIndex, inputArray[lastIndex]);
            }
        }

        return indexNumberPair.entrySet()
                .stream()
                .map(e -> String.format("%d, %d", e.getKey(), e.getValue()))
                .collect(Collectors.joining("; "));
    }
}
