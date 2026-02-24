package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClassifyingObject {
    static class Student{
        int num;
        int score;
        int time;

        Student(int num, int score, int time){
            this.num = num;
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //일정기간 동안 전체학생의 투표
        //사진틀 = 후보 수
        //최초 비어있음, 추천 시 사진 게시
        //비어있는 사진틀이 없다면 추천횟수가 가장 적은 학생 탈락(동일 시 가장 오래된 순), 그 자리를 대체
        //삭제 시 삭제대상 학생은 추천수가 0
        //최종출력 = 학생번호 오름차순

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, Student> map = new HashMap<>();
        List<Student> list = new ArrayList<>();

        StringTokenizer token = new StringTokenizer(br.readLine());
        int time = 0;
        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(token.nextToken());

            if(map.containsKey(num)){
                map.get(num).score++;
            }else{
                if(list.size() == N){
                    Student remove = list.get(0);

                    //리스트 내의 모든 학생들을 순회하면서 후보 탐색 및 비교
                    for(Student student : list){
                        if(student.score < remove.score){
                            remove = student;
                        }else if(student.score == remove.score){
                            if(student.time < remove.time){
                                remove = student;
                            }
                        }
                    }

                    list.remove(remove);
                    map.remove(remove.num);
                }

                Student s = new Student(num, 1, time++);
                list.add(s);
                map.put(num, s);
            }
        }

        //번호순 정렬
        Collections.sort(list, (a,b) -> {
            return a.num - b.num;
        });

        StringBuilder sb = new StringBuilder();
        for(Student s : list){
            sb.append(s.num).append(" ");
        }

        System.out.print(sb);
    }
}
