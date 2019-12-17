package main.java.com.bobozhuang.day07;

import java.io.File;
import java.io.IOException;

/**
 * description��
 * author Hubery
 * date 2019-11-11
 * version v0.0.1
 * since v0.0.1
 **/
public class FilesTest {
    public static void main(String[] args) throws IOException {

        File fileCreate = new File("D:\\coco_xu\\study\\files\\file.txt");
        // ���������ļ���
        System.out.println("�����ļ��д�����" + fileCreate.mkdir());
        // �����༶�ļ���
        System.out.println("�༶�ļ��д�����" + fileCreate.mkdirs());
//�����ļ�
        System.out.println("�����ļ���" + fileCreate.createNewFile());
//�ļ�������
        File toFile = new File("D:\\coco_xu\\study\\files\\toFile.txt");
        System.out.println("�ļ���������" + fileCreate.renameTo(toFile));

        // ɾ������

        File file = new File("D:\\coco_xu\\study\\files\\toFile.tx");
        System.out.println("ɾ���ļ���" + file.delete());
        file.deleteOnExit();

        // �жϷ���
        /*
         * File file = new File("F:\\a.txt");
         * System.out.println("�ļ������ļ��д�����"+file.exists());
         * System.out.println("��һ���ļ���"+file.isFile());
         * System.out.println("��һ���ļ�����"+file.isDirectory());
         * System.out.println("�������ļ���"+file.isHidden());
         * System.out.println("��·���Ǿ���·������"+file.isAbsolute());
         */

        // ��ȡ����
        /*
         * File file = new File("f:\\a.txt");
         * System.out.println("�ļ������ļ��е������ǣ�"+file.getName());
         * System.out.println("����·���ǣ�"+file.getPath());
         * System.out.println("����·���ǣ�"+file.getAbsolutePath());
         * System.out.println("�ļ���С�ǣ����ֽ�Ϊ��λ��:"+file.length());
         * System.out.println("��·����"+file.getParent()); //ʹ�������������ڸ�ʽ������л�ȡ�涨��ʱ�� long
         * lastmodified= file.lastModified(); Date data = new Date(lastmodified);
         * SimpleDateFormat simpledataformat = new
         * SimpleDateFormat("YY��MM��DD�� HH:mm:ss");
         * System.out.println("���һ���޸ĵ�ʱ���ǣ�"+simpledataformat.format(data));
         */

        // �ļ������ļ��еķ���
        /*
         * File[] file = File.listRoots(); System.out.println("���е��̷��ǣ�"); for (File item
         * : file) { System.out.println("\t" + item); } File filename = new
         * File("D:\\coco_xu"); String[] name = filename.list();
         * System.out.println("ָ���ļ����µ��ļ������ļ����У�"); for (String item : name) {
         * System.out.println("\t" + item); } File[] f = filename.listFiles();
         * System.out.println("��ø�·���µ��ļ����ļ����ǣ�"); for (File item : f) {
         * System.out.println("\t" + item.getName()); }
         */
    }
}
