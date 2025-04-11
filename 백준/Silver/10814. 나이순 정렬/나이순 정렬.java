import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Member {
    int age;
    String name;
    int index; // 가입 순서

    public Member(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members.add(new Member(age, name, i));  // index로 순서 기억
        }

        // 정렬: 나이 오름차순, 같으면 index(가입 순서) 오름차순
        members.sort((m1, m2) -> {
            if (m1.age != m2.age) {
                return m1.age - m2.age;
            } else {
                return m1.index - m2.index;
            }
        });

        for (Member m : members) {
            System.out.println(m.age + " " + m.name);
        }

        sc.close();
    }
}
