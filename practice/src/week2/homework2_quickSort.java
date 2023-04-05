package week2;

import java.util.List;

public class homework2_quickSort {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> list = csvReader.readCSV();

        long startTime = System.currentTimeMillis(); // 정렬 시작 시각
        quickSort(list, 0, list.size() - 1); // 퀵 정렬
        long endTime = System.currentTimeMillis(); // 코드 끝난 시각
        long durationTimeSec = endTime - startTime;

        System.out.println("<퀵 정렬>");
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

    // 퀵 정렬
    static void quickSort(List<List<String>> a, int left, int right) {
        int pl = left;            // 왼쪽 커서
        int pr = right;           // 오른쪽 커서
        List<String> x = a.get((pl + pr) / 2); // 피벗

        do {
            while (Double.parseDouble(a.get(pl).get(2)) < Double.parseDouble(x.get(2))) pl++;
            while (Double.parseDouble(a.get(pr).get(2)) > Double.parseDouble(x.get(2))) pr--;

            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }
}

