package week4;

import java.util.HashSet;
import java.util.List;

public class homework4_basicQuickSort {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();

        // 4.1. set을 이용해 정렬되지 않은 배열에 넣기
        List<List<String>> a = csvReader.readCSV();
        csvReader = new CSVReader();

        // 4.2.1 Basic Quick Sort : Pivot X = A[0] or A[n-1]
        // 여기에서는 Pivot을 A[0]으로 설정
        long startTime = System.currentTimeMillis(); // 정렬 시작 시각
        basicQuickSort(a, 0, a.size() - 1); // Basic Quick Sort
        long endTime = System.currentTimeMillis(); // 코드 끝난 시각
        long durationTimeSec = endTime - startTime;

        System.out.println("<Basic Quick Sort>");
        System.out.println("실행 시간 : " + durationTimeSec + "m/s"); // 밀리세컨드 출력
    }

    // a[idx1]과 a[idx2]의 값을 바꾸는 함수
    static void swap(List<List<String>> a, int idx1, int idx2) {
        List<String> t = a.get(idx1);
        a.add(idx1, a.get(idx2));
        a.remove(idx1+1);
        a.add(idx2, t);
        a.remove(idx2 + 1);
    }

    // 4.2.1 Basic Quick Sort
    static void basicQuickSort(List<List<String>> a, int left, int right) {
        if (left >= right)
            return;

        int pl = left;            // 왼쪽 커서
        int pr = right;           // 오른쪽 커서
        List<String> x = a.get(left); // 피벗

        do {
            while (Double.parseDouble(a.get(pl).get(2)) < Double.parseDouble(x.get(2)) && pl <= pr) pl++;
            while (Double.parseDouble(a.get(pr).get(2)) > Double.parseDouble(x.get(2)) && pl <= pr) pr--;

            swap(a, pl++, pr--);
        } while (pl <= pr);

        swap(a, pl, left); // 피벗과 pl을 교환
        // 교환된 후에는 피벗이었던 요소는 이제 pl에 위치함

        basicQuickSort(a, left, pl - 1);
        basicQuickSort(a, pl + 1, right);
    }
}
