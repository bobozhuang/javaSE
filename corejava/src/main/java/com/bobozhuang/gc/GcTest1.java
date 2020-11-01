package main.java.com.bobozhuang.gc;

/**
 * description：     添加 VM 参数 -XX:+PrintGCDetails
 *
 *  新生代内存够用的日志
 *  Heap
 *  PSYoungGen      total 76288K, used 36143K [0x000000076ab00000, 0x0000000770000000, 0x00000007c0000000)
 *   eden space 65536K, 55% used [0x000000076ab00000,0x000000076ce4bd48,0x000000076eb00000)
 *   from space 10752K, 0% used [0x000000076f580000,0x000000076f580000,0x0000000770000000)
 *   to   space 10752K, 0% used [0x000000076eb00000,0x000000076eb00000,0x000000076f580000)
 *  ParOldGen       total 175104K, used 0K [0x00000006c0000000, 0x00000006cab00000, 0x000000076ab00000)
 *   object space 175104K, 0% used [0x00000006c0000000,0x00000006c0000000,0x00000006cab00000)
 *  Metaspace       used 3092K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 339K, capacity 388K, committed 512K, reserved 1048576K
 *
 *
 * author Hubery
 * date 2020-10-27
 * version v0.0.1
 * since v0.0.1
 **/
public class GcTest1 {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        //allocation1 = new byte[30900*1024];
        allocation1 = new byte[70900*1024];
        //allocation2 = new byte[900*1024];
    }

}
