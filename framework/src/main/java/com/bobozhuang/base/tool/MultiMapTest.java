package com.bobozhuang.base.tool;

import com.sun.deploy.util.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Set;

/**
 * description：
 * author Hubery
 * date 2020-08-28
 * version v0.0.1
 * since v0.0.1
 **/
public class MultiMapTest {

    public static void main(String[] args) {

        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();

        stringMultiValueMap.add("早班 9:00-11:00", "周一");
        stringMultiValueMap.add("早班 9:00-11:00", "周二");
        stringMultiValueMap.add("中班 13:00-16:00", "周三");
        stringMultiValueMap.add("早班 9:00-11:00", "周四");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周五");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周六");
        stringMultiValueMap.add("中班 13:00-16:00", "周日");
        //打印所有值
        Set<String> keySet = stringMultiValueMap.keySet();
        for (String key : keySet) {
            List<String> values = stringMultiValueMap.get(key);
            System.out.println(StringUtils.join(values," ")+":"+key);
        }
        System.out.println();
        stringMultiValueMap.set("早班 9:00-11:00","都冲洗到数据");
        //打印所有值
        Set<String> keySet1 = stringMultiValueMap.keySet();
        for (String key : keySet1) {
            List<String> values = stringMultiValueMap.get(key);
            System.out.println(StringUtils.join(values," ")+":"+key);
        }

    }
}
