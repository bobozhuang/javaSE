package main.java.com.bobozhuang.basic.chap06Stream;

import main.java.com.bobozhuang.util.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description：
 * author Hubery
 * date 2020-10-03
 * version v0.0.1
 * since v0.0.1
 **/
public class UseExample {


    //获取最早开发时间
    public String getEstInitRealDate(List<FdevTask> collect) {
        List<String> list = collect.stream()
                .flatMap(task -> Arrays.asList(task.getStart_time()).stream())
                .collect(Collectors.toList());
        Collections.sort(list);
        return StringUtil.dateParse2(list.get(0));
    }

    // 获取uat业务测试时间
    public String getUatTestTime(List<FdevTask> collect){
        // 特殊情况 业务测试 当所有sit均有业务测试时间
        //logger.info("进入getUatTestTime");
        List<String> uatList = collect.stream()
                .flatMap(task -> Arrays.asList(task.getUat_test_time()).stream())
                .filter(str -> StringUtil.isNotNullOrEmpty(str) && "null" != str)
                .collect(Collectors.toList());
        //logger.info("进入getUatTestTime");
        List<String> starList = collect.stream()
                .flatMap(task -> Arrays.asList(task.getStart_uat_test_time()).stream())
                .filter(str -> StringUtil.isNotNullOrEmpty(str) && "null" != str)
                .collect(Collectors.toList());
        uatList.addAll(starList);
        Collections.sort(uatList);
        return StringUtil.dateParse2(uatList.get(uatList.size() - 1));
    }

}
