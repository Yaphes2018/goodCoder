/*
 -Q1：静态内部类与非静态内部类的区别是什么？
 */
public class Java04_05_Q1 {
    public static void main(String[] args) {
        /*
        一、非静态内部类
        1、变量和方法不能声明为静态的；
        2、实例化的时候需要依附在外部类上面，比如B是A的非静态内部类，实例化：A.B b = new A().new B();
        3、内部类可以引用外部类的静态或者非静态属性或方法。
        二、静态内部类
        1、属性和方法都可以声明为静态的或者是非静态的；
        2、实例化静态内部类，不依赖于外部类可以直接实例化，A.B b = new A.B();
        3、内部类只能引用外部的静态属性或者方法；
        4、如果属性或者方法声明为静态的，那么可以直接通过类名调用。A.B.b().
         */
        Java04_05_Q1.Persion outTest = new Java04_05_Q1.Persion(); //实例化静态内部类
        Persion persion = new Persion(); //实例化静态内部类的另一种写法
        persion.display();  //调用静态内部类的静态方法
        System.out.println(outTest.address); //调用静态内部类的非静态私有变量
        System.out.println(outTest.x);  //调用静态内部类的静态私有变量
        System.out.println(outTest.email); //调用静态内部类的公有变量
        outTest.display();  //调用静态内部类的静态方法

        Java04_05_Q1.Inner inner = new Java04_05_Q1().new Inner(); //实例化非静态内部类
        System.out.println(inner.ade);
        System.out.println(inner.age);
        inner.print();
    }
        private static String name = "testout-static";
        private String num = "X001";

        private static void OutStatic(){
            System.out.println("调用外部类的静态方法");
        }

        private void Out(){
            System.out.println("调用外部类的非静态方法");
        }


        //静态内部类可以用public、protected、private修饰
        static class Persion {
            //静态内部类中可以定义静态或者非静态成员
            private String address = "China";
            private static String x = "as";
            public String email = "123@qq.com"; //内部类公有成员

            public void display(){
                System.out.println(name);  //可以引用外部类的静态变量
                //System.out.println(num);  静态内部类不能引用外部类的非静态成员
                OutStatic();  //可以访问外部类的非静态方法
                //Out();  不能访问外部类的非晶态方法
            }
        }

        //非静态内部类
        class Inner {
            //非静态内部类中不可以定义静态成员
            private String ade = "pro";
            //private static String pro = "water";
            public Integer age = 28;

            public void print(){
                //非静态内部类中可以引用外部类中的静态或非静态成员
                System.out.println(name);
                System.out.println(num);
                OutStatic();
                Out();
            }

        }

}
