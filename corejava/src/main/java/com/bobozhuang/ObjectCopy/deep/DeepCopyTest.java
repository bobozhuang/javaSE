package main.java.com.bobozhuang.ObjectCopy.deep;

/**
 * description：
 * author Hubery
 * date 2020-04-27
 * version v0.0.1
 * since v0.0.1
 **/
public class DeepCopyTest {

    public static void main(String[] args) {
        Student student = new Student("cyy", 20, true);
        ClassRoom classRoom = new ClassRoom("一年级", 100, student);
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
        // classRoomNew: ClassRoom{name='一年级', studentNum=100, student=Student{name='cyy', age=20, isBoy=true}}
    }

}
