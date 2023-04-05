package week2;

import java.util.List;

public class homework2_selectionSort {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> list = csvReader.readCSV();

        long startTime = System.currentTimeMillis(); // 정렬 시작 시각
        selectionSort(list, list.size()); // 선택 정렬
        long endTime = System.currentTimeMillis(); // 코드 끝난 시각
        long durationTimeSec = endTime - startTime;

        System.out.println("<선택 정렬>");
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

    // 선택 정렬
    static void selectionSort(List<List<String>> a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;      // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록
            for (int j = i + 1; j < n; j++)
                if (Double.parseDouble(a.get(j).get(2)) < Double.parseDouble(a.get(min).get(2)))
                    min = j;
            swap(a, i, min);  // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
        }
    }
}

