package main.java.com.bobozhuang.basic.chap08Nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:    Java 中调用 JavaScript    nashorn: 自行反坦克炮 犀牛
 * @date: 2019/4/29 14:32
 * @Package main.java.com.bobozhuang.basic.chap08Nashorn
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TesterA {

    public static void main(String args[]){

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Hubery";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");

        }catch(ScriptException e){
            System.out.println("执行脚本错误: "+ e.getMessage());
        }

        System.out.println(result.toString());
    }

}
