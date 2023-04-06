package week4;

import java.util.List;

public class homework4_intelligentQuickSort {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();

        // 4.1. set을 이용해 정렬되지 않은 배열에 넣기
        List<List<String>> a = csvReader.readCSV();
        csvReader = new CSVReader();
        List<List<String>> b = csvReader.readCSV();
        csvReader = new CSVReader();
        List<List<String>> c = csvReader.readCSV();

        // 4.2.2 Intelligent Quick Sort : Pivot X = median of A
        long startTime = System.currentTimeMillis(); // 정렬 시작 시각
        intelligentQuickSort(a, 0, a.size() - 1); // Intelligent Quick Sort
        long endTime = System.currentTimeMillis(); // 코드 끝난 시각
        long durationTimeSec = endTime - startTime;

        System.out.println("<Intelligent Quick Sort>");
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

    // 4.2.2 Intelligent Quick Sort
    static void intelligentQuickSort(List<List<String>> a, int left, int right) {
        int pl = left;            // 왼쪽 커서
        int pr = right;           // 오른쪽 커서
        List<String> x = a.get((pl + pr) / 2); // 피벗

        do {
            while (Double.parseDouble(a.get(pl).get(2)) < Double.parseDouble(x.get(2))) pl++;
            while (Double.parseDouble(a.get(pr).get(2)) > Double.parseDouble(x.get(2))) pr--;

            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) intelligentQuickSort(a, left, pr);
        if (pl < right) intelligentQuickSort(a, pl, right);
    }
}
