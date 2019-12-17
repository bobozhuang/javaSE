package main.java.com.bobozhuang.day07;

import java.io.File;
import java.io.IOException;

/**
 * description：
 * author Hubery
 * date 2019-11-11
 * version v0.0.1
 * since v0.0.1
 **/
public class FilesTest {
    public static void main(String[] args) throws IOException {

        File fileCreate = new File("D:\\coco_xu\\study\\files\\file.txt");
        // 创建单级文件夹
        System.out.println("单级文件夹创建：" + fileCreate.mkdir());
        // 创建多级文件夹
        System.out.println("多级文件夹创建：" + fileCreate.mkdirs());
//创建文件
        System.out.println("创建文件：" + fileCreate.createNewFile());
//文件重命名
        File toFile = new File("D:\\coco_xu\\study\\files\\toFile.txt");
        System.out.println("文件重命名：" + fileCreate.renameTo(toFile));

        // 删除方法

        File file = new File("D:\\coco_xu\\study\\files\\toFile.tx");
        System.out.println("删除文件：" + file.delete());
        file.deleteOnExit();

        // 判断方法
        /*
         * File file = new File("F:\\a.txt");
         * System.out.println("文件或者文件夹存在吗？"+file.exists());
         * System.out.println("是一个文件吗？"+file.isFile());
         * System.out.println("是一个文件夹吗？"+file.isDirectory());
         * System.out.println("是隐藏文件吗？"+file.isHidden());
         * System.out.println("此路径是绝对路径名？"+file.isAbsolute());
         */

        // 获取方法
        /*
         * File file = new File("f:\\a.txt");
         * System.out.println("文件或者文件夹得名称是："+file.getName());
         * System.out.println("绝对路径是："+file.getPath());
         * System.out.println("绝对路径是："+file.getAbsolutePath());
         * System.out.println("文件大小是（以字节为单位）:"+file.length());
         * System.out.println("父路径是"+file.getParent()); //使用日期类与日期格式化类进行获取规定的时间 long
         * lastmodified= file.lastModified(); Date data = new Date(lastmodified);
         * SimpleDateFormat simpledataformat = new
         * SimpleDateFormat("YY年MM月DD日 HH:mm:ss");
         * System.out.println("最后一次修改的时间是："+simpledataformat.format(data));
         */

        // 文件或者文件夹的方法
        /*
         * File[] file = File.listRoots(); System.out.println("所有的盘符是："); for (File item
         * : file) { System.out.println("\t" + item); } File filename = new
         * File("D:\\coco_xu"); String[] name = filename.list();
         * System.out.println("指定文件夹下的文件或者文件夹有："); for (String item : name) {
         * System.out.println("\t" + item); } File[] f = filename.listFiles();
         * System.out.println("获得该路径下的文件或文件夹是："); for (File item : f) {
         * System.out.println("\t" + item.getName()); }
         */
    }
}
