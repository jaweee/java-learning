package com.jaweee.basic.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author: me
 * @title: ReflectTest
 * @description:
 * @date: 2023/2/14 20:38
 */

public class ReflectTest {


    /**
     * 通过没有参数的构造函数
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    @Test
    public void generateNonParamConstructorInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // 1. 获取Class类：使用类的class静态变量
        Class c = HelloService.class;
        HelloService hs1 = (HelloService) c.newInstance();
        hs1.sayHello();

        // 2. 获取Class类：根据类实例的getClass方法来r
        Class c2 = hs1.getClass();
        HelloService hs2 = (HelloService) c2.newInstance();
        hs2.sayHello();

        // 3. 获取Class类：根据Class类的静态函数
        Class c3 = Class.forName("com.jaweee.basic.reflect.HelloService");
        HelloService hs3 = (HelloService) c3.newInstance();
        hs3.sayHello();
    }

    @Test
    public void generateWithParamConstructorInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取Class类：使用类的class静态变量
        Class c = Student.class;

        // 2. 获取Constructor类，获取类的构造函数
        Constructor cons1 = c.getConstructor(String.class, Integer.class, Integer.class);
        Constructor cons2 = c.getConstructor();

        // 3. 创建实例
        Student student1 = (Student) cons1.newInstance("小明", 23, 1);
        System.out.println(student1.toString());

        Student student2 = (Student) cons2.newInstance();
        System.out.println(student2.toString());

    }

    @Test
    public void getFieldFromStudent() throws NoSuchFieldException, IllegalAccessException {
        // 1. 获取Class类实例（类静态变量、实例getClass方法、Class类静态方法）
        // Class clazz = Student.class;
        Student student = new Student("小米", 23, 1);
        Class clazz = student.getClass();
        // 2. 获取Field、DeclareField、Fields、DeclareFields
        //    一般是私有的，所以直接使用
        Field field = clazz.getDeclaredField("name");
        Field[] fields = clazz.getDeclaredFields();

        System.out.println(field);
        System.out.println(fields);

        // 3. 修改字段值
        field.setAccessible(true);
        field.set(student, "小红");

        /*for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fields[i].set(student, "hj");
        }*/

    }
}
