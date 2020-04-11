package main.java.com.bobozhuang.day03.chap06;

public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int m = 10;
        System.out.println(i == j);
        System.out.println(i == m);
        Student s1 =
                new Student
                        (101, "张三", true);
        Student s2 =
                new Student
                        (102, "李四", true);
        Student s3 =
                new Student
                        (101, "张三", true);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s1.equals(s2));
        System.out.println("-----------");
        System.out.println(s1.equals(s3));
        System.out.println("-----------");
        System.out.println(s1);
        System.out.println(s1.toString());
        System.out.println(s2);
    }
}

class Student {
    private int id;
    private String name;
    private boolean gender;

    public Student() {
    }

    public Student(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Student s = (Student) o;
        if (this.id == s.id
                && this.name.equals(s.name)) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
    }

}



