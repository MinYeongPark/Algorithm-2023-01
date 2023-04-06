package week4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class homework4_tupleSortMonthFirst {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();

        // 4.1. set을 이용해 정렬되지 않은 배열에 넣기
        List<List<String>> a = csvReader.readCSV();
        csvReader = new CSVReader();

        // 4.2.4 Tuple sort : 첫 번째 원소부터 정렬
        // 1) month - First, date - Second
        long startTime = System.currentTimeMillis(); // 정렬 시작 시각
        tupleSort_monthFirst(a); // Tuple Quick Sort
        long endTime = System.currentTimeMillis(); // 코드 끝난 시각
        long durationTimeSec = endTime - startTime;

        System.out.println("<Tuple Sort - 1) Month First>");
        System.out.println("실행 시간 : " + durationTimeSec + "m/s"); // 밀리세컨드 출력
    }

    // 4.2.3 Intelligent Quick Sort
    // 1) month - First, date - Second
    public static void tupleSort_monthFirst(List<List<String>> a) {
        Collections.sort(a, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int o1_month = Integer.parseInt(o1.get(2).substring(0, 2));
                int o1_day = Integer.parseInt(o1.get(2).substring(3));
                int o2_month = Integer.parseInt(o2.get(2).substring(0, 2));
                int o2_day = Integer.parseInt(o2.get(2).substring(3));

                if (o1_month == o2_month) {
                    return o1_day - o2_day;
                }
                return o1_month - o2_month;
            }
        });
    }

    // 2) date - First, month - Second
    public static void tupleSort_dateFirst(List<List<String>> a) {
        Collections.sort(a, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int o1_month = Integer.parseInt(o1.get(2).substring(0, 3));
                int o1_day = Integer.parseInt(o1.get(2).substring(3));
                int o2_month = Integer.parseInt(o2.get(2).substring(0, 3));
                int o2_day = Integer.parseInt(o2.get(2).substring(3));

                if (o1_day == o2_day) {
                    return o1_month - o2_month;
                }
                return o1_day - o2_day;
            }
        });
    }
}
