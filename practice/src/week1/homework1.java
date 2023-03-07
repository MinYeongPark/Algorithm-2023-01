package week1;

import java.io.*;
import java.util.*;

public class homework1 {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> list = csvReader.readCSV();

        // 생일이 같은 사람을 수동으로 결정하기
        boolean same_birth = false;
        HashMap<Double, HashSet<String>> same_birth_and_name;
        HashSet<String> same_people;
        ArrayList<HashMap<Double, HashSet<String>>> same_list = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            double p1_birth = Double.parseDouble(list.get(i).get(2));
            same_birth_and_name = new HashMap<>();
            same_people = new HashSet<String>();
            for (int j = i + 1; j < list.size(); j++) {
                double p2_birth = Double.parseDouble(list.get(j).get(2));
                if (p1_birth == p2_birth) {
                    same_birth = true;
                    same_people.add(list.get(i).get(0));
                    same_people.add(list.get(j).get(0));
                    same_birth_and_name.put(p1_birth, same_people);
                    same_list.add(same_birth_and_name);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (same_birth) {
            for (int i = 0; i < same_list.size(); i++) {
                for (Double birthday : same_list.get(i).keySet()) {
                    sb.append(birthday).append("\n");
                    sb.append(same_list.get(i).get(birthday)).append("\n");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        } else {
            System.out.println("생일이 같은 사람이 없습니다.");
        }
    }
}

class CSVReader {
    public List<List<String>> readCSV() {
        List<List<String>> csvList = new ArrayList<List<String>>();
        File csv = new File("D:\\Github\\Algorithm-2023-01\\practice\\src\\week1\\Algorithms - Birthday Data.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                List<String> aLine = new ArrayList<>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return csvList;
    }
}
