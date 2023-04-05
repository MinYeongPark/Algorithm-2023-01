package week2;

import java.util.List;

public class homework2_insertionSort {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> list = csvReader.readCSV();

        long startTime = System.currentTimeMillis(); // 정렬 시작 시각
        insertionSort(list, list.size()); // 삽입 정렬
        long endTime = System.currentTimeMillis(); // 코드 끝난 시각
        long durationTimeSec = endTime - startTime;

        System.out.println("<삽입 정렬>");
        System.out.println("1. 실행 시간 : " + durationTimeSec + "m/s"); // 밀리세컨드 출력

        System.out.println("\n2. 정렬 결과");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)+"\n");
        }
        System.out.println(sb);
    }

    // 삽입 정렬
    static void insertionSort(List<List<String>> a, int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            List<String> tmp = a.remove(i);
            while (j > 0 && Double.parseDouble(a.get(j-1).get(2)) > Double.parseDouble(tmp.get(2)))
                j--;

            a.add(j, tmp);
        }
    }
}

