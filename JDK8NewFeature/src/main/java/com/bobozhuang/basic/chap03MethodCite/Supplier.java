package main.java.com.bobozhuang.basic.chap03MethodCite;

import java.util.Arrays;
import java.util.List;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/23 15:12
 * @Package main.java.com.bobozhuang.basic.chap03MethodCite
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
@FunctionalInterface
public interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {// collide   碰撞；抵触，冲突
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {//follow      跟随；遵循；追求；密切注意
        System.out.println("Following the " + another.toString());
    }

    public void repair() {//repair  修复
        System.out.println("Repaired " + this.toString());
    }
}

class test {
    public static void main(String[] args) {
        // 构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        //静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(Car::collide);
        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(Car::repair);
        //特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
