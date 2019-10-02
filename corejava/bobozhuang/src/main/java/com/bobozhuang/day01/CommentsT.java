package main.java.com.bobozhuang.day01;

public class CommentsT {
    public static void main(String[] args) {
        int i;
        i = 100;
        System.out.println(i);
		int a = 10;
		int b = 20;
		System.out.println
			(new CommentsT().sum(a,b));
    }

    /**
     * 这是一个方法，用来求两个数的和
     *
     * @param a:第一个数
     * @param b:第二个数
     * @return 返回两数之和
     */
    public int sum(int a, int b) {
        int i = a + b;
        return i;
    }
}

