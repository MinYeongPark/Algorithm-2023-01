package week2;

import week3.CSVReader;

import java.util.List;

public class homework2_bubbleSort {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> list = csvReader.readCSV();

        long startTime = System.currentTimeMillis(); // 정렬 시작 시각
        bubbleSort(list, list.size()); // 버블 정렬
        long endTime = System.currentTimeMillis(); // 코드 끝난 시각
        long durationTimeSec = endTime - startTime;

        System.out.println("<버블 정렬>");
        System.out.println("1. 실행 시간 : " + durationTimeSec + "m/s"); // 밀리세컨드 출력

        System.out.println("\n2. 정렬 결과");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)+"\n");
        }
        System.out.println(sb);
    }

    // a[idx1]과 a[idx2]의 값을 바꾸는 함수
    static void swap(List<List<String>> a, int idx1, int idx2) {
        List<String> t = a.get(idx1);
        a.add(idx1, a.get(idx2));
        a.remove(idx1+1);
        a.add(idx2, t);
        a.remove(idx2 + 1);
    }

    // 버블 정렬
    static void bubbleSort(List<List<String>> a, int n) {
        int k = 0; // a[k]보다 앞쪽은 정렬을 마친 상태
        while (k < n - 1) {
            int last = n - 1; // 마지막으로 요소를 교환한 위치
            for (int j = n - 1; j > k; j--)
                if (Double.parseDouble(a.get(j-1).get(2)) > Double.parseDouble(a.get(j).get(2))) {
                    swap(a, j-1, j);
                    last = j;
                }
            k = last;
        }
    }
}

