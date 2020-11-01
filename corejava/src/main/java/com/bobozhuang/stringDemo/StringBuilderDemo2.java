package main.java.com.bobozhuang.stringDemo;

/**
 * description：     10_000_000 次循环拼接，在循环内使用 String 和 StringBuilder 的效率是一样的！为什么呢？
 * <p>
 * 使用 javap -c StringTest.class 反编译查看两个方法编译后的文件：
 * 可以发现 String 方法拼接字符串编译器优化后使用的就是 StringBuilder、因此用例1 和用例2 的效率是一样的。
 * author Hubery
 * date 2020-10-09
 * version v0.0.1
 * since v0.0.1
 **/
public class StringBuilderDemo2 {
    public static final int CYCLE_NUM_BIGGER = 10_000_000;
    public static final int CYCLE_NUM_LOWER = 10_000;
    public static final String str1 = "张三";
    public static final String str2 = "李四";
    public static final String str3 = "王五";
    public static final String str4 = "赵六";


    public static void main(String[] args) throws InterruptedException {
        int time = 0;
        int num = 5;

        time = executeSometime(1, num);
        System.out.println("String拼接 " + CYCLE_NUM_BIGGER + " 次，" + num + "次平均时间：" + time + " ms");

        time = executeSometime(2, num);
        System.out.println("StringBuilder拼接 " + CYCLE_NUM_BIGGER + " 次，" + num + "次平均时间：" + time + " ms");

        time = executeSometime(3, num);
        System.out.println("String拼接单个字符串 " + CYCLE_NUM_LOWER + " 次，" + num + "次平均时间：" + time + " ms");

        time = executeSometime(4, num);
        System.out.println("StringBuilder拼接单个字符串 " + CYCLE_NUM_LOWER + " 次，" + num + "次平均时间：" + time + " ms");

    }

    /**
     * 循环内 String 拼接字符串，一次循环后销毁
     */
    public static void useString() {
        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
            String str = str1 + i + str2 + i + str3 + i + str4;
        }
    }
    /**
     * 循环内 使用 StringBuilder 拼接字符串，一次循环后销毁
     *
     * 循环外创建 StringBuilder 每次循环开始的时候清空 StringBuilder 的内容然后拼接。这种写法无论使用 sb.setLength(0);
     * 还是 sb.delete(0, sb.length()); 效率都比直接在循环内使用 String / StringBuilder 慢
     */
    public static void useStringBuilderOut(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
            //sb.setLength(0);
            sb.delete(0, sb.length());
            String s = sb.append(str1).append(i).append(str2).append(i).append(str3).append(i).append(str4).toString();
        }
    }

    /**
     * 结果是 cleanStringBuider 更快
     */
    public static void createStringBuider() {
        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
            StringBuilder sb = new StringBuilder();
        }
    }

    public static void cleanStringBuider() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
            sb.delete(0, sb.length());
        }
    }

    /**
     * 循环内 使用 StringBuilder 拼接字符串，一次循环后销毁
     */
    public static void useStringBuilder() {
        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
            StringBuilder sb = new StringBuilder();
            String s = sb.append(str1).append(i).append(str2).append(i).append(str3).append(i).append(str4).toString();
        }
    }

    /**
     * 多次循环拼接成一个字符串 用 String
     */
    public static void useStringSpliceOneStr() {
        String str = "";
        for (int i = 0; i < CYCLE_NUM_LOWER; i++) {
            str += str1 + str2 + str3 + str4 + i;//这里每次都创建对象
        }
    }

    /**
     * 多次循环拼接成一个字符串 用 StringBuilder
     *
     * 这种方式的优势就体现出来了
     */
    public static void useStringBuilderSpliceOneStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CYCLE_NUM_LOWER; i++) {
            sb.append(str1).append(str2).append(str3).append(str4).append(i);
        }
    }

    public static int executeSometime(int kind, int num) throws InterruptedException {
        Thread.sleep(2000);
        int sum = 0;

        for (int i = 0; i < num + 5; i++) {//空跑 5 次热身
            long begin = System.currentTimeMillis();

            switch (kind) {
                case 1:
                    useString();
                    break;
                case 2:
                    useStringBuilder();
                    break;
                case 3:
                    useStringSpliceOneStr();
                    break;
                case 4:
                    useStringBuilderSpliceOneStr();
                    break;
                default:
                    return 0;
            }

            long end = System.currentTimeMillis();
            if (i<5){
                sum += (end - begin);
            }
        }
        return sum / num;
    }
}
