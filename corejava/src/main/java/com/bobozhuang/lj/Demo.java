package main.java.com.bobozhuang.lj;

import java.util.ArrayList;
import java.util.List;

/**
 * description：
 * author Hubery
 * date 2020-11-21
 * version v0.0.1
 * since v0.0.1
 **/


public class Demo {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<Person>();
        list1.add(new Person("li", "2", 23));
        list1.add(new Person("wang", "1", 30));
        list1.add(new Person("zhang", "2", 40));
        list1.add(new Person("hu", "2", 35));
        list1.add(new Person("chen", "3", 60));

        List<Person> list2 = new ArrayList<Person>();
        //list2.addAll(list1);
        //list2.get(0).setName("hanmeimei");

        //list1.get(1).setName("kkkk");


        for (Person person : list1) {
            if (person.getSex() == "3") {
                person.setName("ccc");
            }

            //System.out.println(person.name);
        }
        for (Person person : list1) {
            System.out.println(person.name);
        }

       /* for(Person person:list2){
            System.out.println(person.name);
        }*/
    }


    static class Person {
        private String name;
        private String sex;
        private Integer age;

        public Person(String name, String sex, Integer age) {
            super();
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

    }

}
