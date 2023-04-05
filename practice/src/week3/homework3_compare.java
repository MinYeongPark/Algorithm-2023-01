package week3;

import java.util.*;

public class homework3_compare {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> list = csvReader.readCSV();

        // 4.1. set을 이용해 정렬되지 않은 배열에 넣기
        HashSet<List<String>> set = new HashSet<>();
        for (List<String> node : list) {
            set.add(node);
        }

        // 4.2. 정렬된 배열 집합에 넣기
        // 정렬된 배열 집합 자동으로 정렬해주는 우선순위 큐에 저장했습니다.
        // 틀릴 수도 있지만 자동으로 정렬해준다는 점에서 이용해 보았습니다.
        PriorityQueue<List<String>> pq = new PriorityQueue<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return (int) (Double.parseDouble(o1.get(2)) - Double.parseDouble(o2.get(2)));
            }
        });
        for (List<String> node : list) {
            pq.add(node);
        }

        // 4.3. Direct Access Array set에 넣기
        // 직접 접근할 수 있는 것은 ArrayList라고 판단해 ArrayList를 이용해 보았습니다.
        ArrayList<List<String>> al = new ArrayList();
        for (List<String> node : list) {
            al.add(node);
        }

        // 4.5. 크기 비교
        System.out.println("1) set : " + set.size());
        System.out.println("2) PriorityQueue : " + pq.size());
        System.out.println("3) ArrayList : " + al.size());
    }
}
