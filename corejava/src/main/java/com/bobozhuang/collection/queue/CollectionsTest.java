package main.java.com.bobozhuang.collection.queue;

import java.util.*;

/**
 * description：
 * author Hubery    工具类Collectons用于操作集合类，如list，set。提供的所有方法都是静态的。常用方法如下
 *
 * (1)、排序操作（主要针对List接口）
 *
 *     reverse(List list)：反转指定List集合中元素的顺序
 *
 *     shuffle(List list)：对List中的元素进行随机排序（洗牌）
 *
 *     sort(List list)：对List里的元素根据自然升序排序
 *
 *     sort(List list, Comparator c)：自定义比较器进行排序
 *
 *     swap(List list, int i, int j)：将指定List集合中i处元素和j出元素进行交换
 *
 *     rotate(List list, int distance)：将所有元素向右移位指定长度
 *
 * (2)、查找和替换（主要针对Collection接口）
 *
 *     binarySearch(List list, Object key)：使用二分搜索法，以获得指定对象在List中的索引，前提是集合已经排序
 *
 *     max(Collection coll)：返回最大元素
 *
 *     max(Collection coll, Comparator comp)：根据自定义比较器，返回最大元素
 *
 *     min(Collection coll)：返回最小元素
 *
 *     min(Collection coll, Comparator comp)：根据自定义比较器，返回最小元素
 *
 *     fill(List list, Object obj)：使用指定对象填充
 *
 *     frequency(Collection Object o)：返回指定集合中指定对象出现的次数
 *
 *     replaceAll(List list, Object old, Object new)：替换
 *
 * date 2020-08-29
 * version v0.0.1
 * since v0.0.1
 **/
public class CollectionsTest {


    public static void main(String[] args) {

        //sort方法的使用（对集合进行排序,默认按照升序排序，列表中所有元素必须实现Comparable接口）
        List<String> list = new ArrayList<String>();
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("a");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        //reverse方法的使用（对集合中元素进行反转）
        List<String> list2 = Arrays.asList("a b c d e f".split(" "));
        Collections.reverse(list2);
        System.out.println(list2);

        //shuffle方法的使用（对集合中元素进行随机排序）
        List<String> list3 = new ArrayList<String>();
        list3.add("c");
        list3.add("d");
        list3.add("b");
        list3.add("a");
        Collections.shuffle(list3);
        System.out.println(list3);

        //fill(list list,Object o)方法的适用（用对象 o 替换list中的所有元素）
        List<String> list4 = Arrays.asList("a b c d e f".split(" "));
        System.out.println(list4);
        Collections.fill(list4, "我");

        System.out.println(list4);

        //copy（List m，List n）方法的使用（将集合n中的元素全部复制到m中，并且覆盖相应索引的元素）。
        // 就是原来的位置，在新的集合还是这个位置，覆盖新集合中的位置
        List<String> m = Arrays.asList("a b c d e f".split(" "));
        List<String> n = Arrays.asList("我 我 我".split(" "));
        Collections.copy(m, n);
        System.out.println(m);

        //min/max（Collection）,min/max（Collection,Comparator）方法的使用（前者采用Collection的自然比较法，后者采用Comparator进行比较)
        List<String> list5 = Arrays.asList("a b c d e f".split(" "));

        System.out.println(Collections.min(list5));
        System.out.println(Collections.min(list5, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;//这里写比较规则
            }
        }));

        //    indexOfSubList（List m,List m）方法的使用（查找n在m中首次出现位置的索引）
        //lastIndexOfSubList（List m,List m）方法的使用（查找n在m中最后出现位置的索引）
        List<String> m1 = Arrays.asList("a b b c b d e f".split(" "));
        List<String> n1 = Arrays.asList("b");
        System.out.println(Collections.indexOfSubList(m1, n1));
        System.out.println(Collections.lastIndexOfSubList(m1, n1));

        //rotate(List list,int m)方法的使用
        // （集合中的元素向后移动m个位置，在后面被覆盖的元素循环到前面。m是负数表示向左移动，m是正数表示向右移动）
        List<String> list6 = Arrays.asList("a b c d e f".split(" "));
        Collections.rotate(list6, 1);
        System.out.println(list6);
        Collections.rotate(list6, -1);
        System.out.println(list6);

        //swap(List list,int i,int j)方法的使用（交换集合中指定元素索引位置的元素）
        List<String> list7 = Arrays.asList("a b c d e f".split(" "));
        Collections.swap(list7, 2, 3);
        System.out.println(list7);

        //binarySearch(Collection,Object)方法的使用（查找指定集合中的元素，返回所查找元素位置的索引）
        List<String> list8 = Arrays.asList("a b c d e f".split(" "));
        int index = Collections.binarySearch(list8, "d");
        System.out.println(index);

        //replaceAll(List list,Object old,Object new)方法的使用（替换指定元素为新元素，若被替换的元素存在返回true，反之返回false）
        List<String> list9 = Arrays.asList("a b c d e f".split(" "));
        System.out.println(Collections.replaceAll(list9, "e", "我"));
        System.out.println(Collections.replaceAll(list9, "ee", "我"));
        System.out.println(list9);



    }
}
