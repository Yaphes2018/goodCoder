/*
-Q5：请问Java匿名内部类怎样创建？有什么作用和优点？请编写代码Demo说明。
 */
public class Java09_10_Q5 {
/*
匿名内部类的定义：没有名字的内部类。表面上看起来那是它的名字，实际上不是它的名字。

使用匿名内部类的前提：必须继承父类或实现一个接口

匿名内部类的分类：
1.继承式的匿名内部类
2.接口式的匿名内部类
3.参数式的匿名内部类

特点：匿名内部类一定是跟在new的后面，用其隐含实现一个接口或一个类，没有类名，根据多态，我们使用其父类名。
     因为匿名内部类属于局部类，所以局部类的所有限制对其生效。匿名内部类是唯一一种无构造方法的类。
     匿名内部类在编译时，系统自动起名Out$1.class。如果一个对象编译时的类型是接口，那么其运行的类型为实现这个接口的类。

注意点：
1.不能有构造方法
2.不能定义任何静态成员、方法或类
3.不能是public,protected,private,static。
4.只能创建匿名内部类的一个实例。

匿名内部类的优点：
可以使命名变得简洁
使代码更加紧凑，简洁,封装性比内部类更优
一个类用于继承其他类或是实现接口，无需增加其他的方法，只是对继承方法实现   覆盖。

内部类：在一个类的内部还有另一个类。那么匿名类，如果一个类在整个操作中，只使用一次的话，就可以将其定义成匿名内部类。
       匿名内部类是在接口及抽象类的基础上发展起来的。
 */
    public static void main(String[] args){
        new x().fun1();
    }
}

interface Aaa{
    public void printInfo();
}

/*
如果Bbb只使用一次，不需要封装成一独立的类，作为x的匿名内部类即可。但是一般不建议这么用，因为代码可读性差，我们宁可抛弃代码的简洁性来换取高可读性
class Bbb implements Aaa{
    public void printInfo(){
        System.out.println("hello world");
    }
}
*/

class x{
    public void fun1(){
        this.fun2(new Aaa(){
            public void printInfo(){
                System.out.println("hello world");
            }
        });
    }
    public void fun2(Aaa a){
        a.printInfo();
    }
}