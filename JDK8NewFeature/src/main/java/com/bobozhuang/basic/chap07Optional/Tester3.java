package main.java.com.bobozhuang.basic.chap07Optional;

import main.java.com.bobozhuang.Exception.exceptionlearn.FdevException;
import main.java.com.bobozhuang.util.Tuple;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/**
 * description：
 * author Hubery
 * date 2020-10-02
 * version v0.0.1
 * since v0.0.1
 **/
public class Tester3 {



    public static void main(String[] args) {

        testFilter();

    }


    /**
     *
     * flatMap：如果有值，为其执行mapping函数返回Optional类型返回值，
     * 否则返回空Optional。与map不同的是，flatMap 的返回值必须是Optional，
     * 而map的返回值可以是任意的类型T
     */
    public static void testFlatMap(){
        Optional<String> optional = Optional.of("xiaoming");
        Optional<String> s = optional.flatMap(e -> Optional.of(e.toUpperCase()));
        System.out.println(s.get()); //输出：XIAOMING
    }

    public static void testFilter(){

        List<String> strings = Arrays.asList("rmb", "doller", "ou");
        for (String s : strings) {
            Optional<String> o = Optional.of(s).filter(s1 -> !s1.contains("o"));
            System.out.println(o.orElse("包含o的"));
        }
    }

    /**
     * 一个开中的使用例子
     * 1、appInfo不为空的时候执行ifPresent中的代码，获取appInfo中的id为projectId赋值
     * 2、获取projectId的值，如果没有就抛出异常
     */
    public static void pp(){

        Map appInfo = null;
        AtomicReference<String> projectId = new AtomicReference<>();
        try {
            // 根据应用名 获取项目project Id
            //appInfo = iAppApi.queryAppInfoByAppName(app_name);
            Optional.ofNullable(appInfo).ifPresent(map -> {
                projectId.set(appInfo.get("gitlab_project_id").toString());
            });
            Optional.ofNullable(projectId.get())
                    .orElseThrow(() -> new FdevException(ErrorConstants.PARAM_ERROR, new String[]{"项目id为空"}));
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, true));
            //log.info("调用app服务失败app_name:{}Error Trace:{}",app_name,sw.toString());
            //return Tuple.tuple(0, 0, Collections.emptyList());
        }
    }

}
