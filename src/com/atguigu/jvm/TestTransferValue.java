package com.atguigu.jvm;

/**
 * Created by zld on 2019/9/28 0028.
 *
 * 基本类型传复印件
 */
public class TestTransferValue {

    public void changeValue1(int age){          //方法结束出栈
        age=30;
    }
    public  void changeValue2(Person p){
        p.setPersonName("xxx");
    }
    public  void changeValue3(String str){
        str = "xxx";
    }



    public static void main(String[] args) {

        TestTransferValue testTransferValue = new TestTransferValue();
        int age =20;
        testTransferValue.changeValue1(age);                        //基本类型传复印件
        System.out.println("age----"+age);

        Person person = new Person("abc");              //引用类型传地址
        testTransferValue.changeValue2(person);
        System.out.println(person.getPersonName());


        String str = "abc";
        testTransferValue.changeValue3(str);                        //字符串常量池  有就复用 没有就创建

        System.out.println("str--------"+str);
    }


}


class Person{
    private String PersonName;

    public Person(String personName) {
        PersonName = personName;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }
}