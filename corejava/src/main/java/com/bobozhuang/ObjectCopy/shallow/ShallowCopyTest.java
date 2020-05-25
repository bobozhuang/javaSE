package main.java.com.bobozhuang.ObjectCopy.shallow;

/**
 * description：想对一个对象进行处理，又想保留原有的数据进行接下来的操作，就需要克隆了。
 *  但是浅克隆的方式，还是
 * author Hubery
 * date 2020-04-27
 * version v0.0.1
 * since v0.0.1
 **/
public class ShallowCopyTest {


    public static void main(String[] args) {
        Student student = new Student("cyy", 20, true);
        System.out.println("student: " + student);

        Student studentNew;
        try {
            studentNew = (Student) student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return;
        }
        student.name = "yt";
        student.age = 10;
        student.isBoy = false;

        System.out.println("studentNew: " + studentNew);

        // 输出
        // student: Student{name='cyy', age=20, isBoy=true}
        // studentNew: Student{name='cyy', age=20, isBoy=true}

        /*  ------------ */
        Student student1 = new Student("cyy", 20, true);
        ClassRoom classRoom = new ClassRoom("一年级", 100, student1);
        System.out.println("classRoom: " + classRoom);

        ClassRoom classRoomNew;
        try {
            classRoomNew = (ClassRoom) classRoom.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return;
        }

        classRoom.name = "二年级";
        classRoom.studentNum = 200;
        classRoom.student.age = 10;
        classRoom.student.name = "yt";
        classRoom.student.isBoy = false;

        System.out.println("classRoomNew: " + classRoomNew);

        // 输出
        // classRoom: ClassRoom{name='一年级', studentNum=100, student=Student{name='cyy', age=20, isBoy=true}}
        // classRoomNew: ClassRoom{name='一年级', studentNum=100, student=Student{name='yt', age=10, isBoy=false}}

        /*
        从打印结果可以发现classroom的name,studentNum内容被拷贝classroomNew对象，而student对象没有被拷贝过来（这时就需要使用深拷贝）。
         */

    }
}
