package main.java.com.bobozhuang.morethread;

import main.java.com.bobozhuang.util.Tuple;
import main.java.com.bobozhuang.util.tool.Util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * description：
 * author Hubery
 * date 2020-09-23
 * version v0.0.1
 * since v0.0.1
 **/
public class FutureTaskDemo2 {

    public static void main(String[] args) {

        Tuple.Tuple3 afterCommits = commits();
        HashMap<String,Object> result = new HashMap();
        result.put("commits",afterCommits.first());
        result.put("conflict",afterCommits.second());
        result.put("fileList",afterCommits.third());
        System.out.println(result);
    }


    public static Tuple.Tuple3 commits(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        String commits = "back code init";
        Future<Map> commit = executorService.submit(() -> {
            System.out.println("获取commit: " + commits);
            Map result = new HashMap<>();
            result.put("aa","11");
            result.put("bb","22");
            return result;
        });

        //等待结果
        Map mapCommit = null;
        try {
            mapCommit = commit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        //生产上存在git偶尔404问题
        if (Util.isNullOrEmpty(mapCommit)) {

            return Tuple.tuple(0, 0, Collections.emptyList());
        }
        Map mapconflit = new HashMap<>();
        mapconflit.put("diffs","12");
        //替换
        mapCommit.put("diffs", mapconflit.get("diffs"));

        return Tuple.tuple(0, 0, Collections.emptyList());
    }
}
