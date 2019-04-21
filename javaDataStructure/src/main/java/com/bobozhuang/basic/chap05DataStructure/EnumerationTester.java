package main.java.com.bobozhuang.basic.chap05DataStructure;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/21 16:57
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class EnumerationTester {

    public static void main(String args[]) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }

}
