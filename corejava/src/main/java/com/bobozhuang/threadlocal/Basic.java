package main.java.com.bobozhuang.threadlocal;

/**
 * description：     在进行get之前，必须先set，否则会报空指针异常；
 * 　　           如果想在get之前不需要调用set就能正常访问的话，必须重写initialValue()方法。
 * 　　　          因为在上面的代码分析过程中，我们发现如果没有先set的话，即在map中查找不到对应的存储，
 *                  则会通过调用setInitialValue方法返回i，而在setInitialValue方法中，
 *                  有一个语句是T value = initialValue()， 而默认情况下，initialValue方法返回的是null。
 * author Hubery
 * date 2020-04-19
 * version v0.0.1
 * since v0.0.1
 **/
public class Basic {

    // ThreadLocal<T>
    //public static ThreadLocal<Long> x = new ThreadLocal<Long>();
    public static ThreadLocal<Long> x = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            System.out.println("Initial Value run..");
            return Thread.currentThread().getId();//负值
        }
    };

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                System.out.println(x.get());
            }
        }.start();
        x.set(107L);
        // 移除当前线程上的ThreadLocal的值
        x.remove();
         /*
            get操作会延迟加载，如果不get,不会触发initialValue
         */
        System.out.println(x.get());//获取到主线程的 id


    }

}