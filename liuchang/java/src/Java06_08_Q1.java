/*
-Q1：请问Java中接口与抽象类的区别是什么？应该如何从二者中做选择？请编写代码Demo说明。
 */

/*
一、抽象类：
含有abstract修饰符的class即为抽象类，并不是说抽象类必须有抽象方法（可以一个也没有，目的是不让该类创建对象，注：接口和抽象类都不能创建对象，但是均可定义对象，通过实现子类实例化父类），但是含有abstract方法的类必须定义为abstract class ，abstract类不能创建实例（对象），抽象类中定义抽象方法必须放在具体子类中实现，所以不能有抽象的构造方法或抽象的静态方法，如果子类没有实现抽象父类中的所有方法，那么，子类也必须定义为抽象类。

二、接口：
接口（interface）可以说成是抽象类的特例。接口中的所有方法都必须是抽象的，接口中的方法定义默认为public  abstract 。接口中的变量是全局常量，即public static final修饰的。

三、二者在语法上的差别：

   1，抽象类里可以有构造方法，而接口内不能有构造方法。（构造器用于初始化成员变量，接口没有成员变量）

   2，抽象类中可以有普通成员变量，而接口中不能有普通成员变量。

   3，抽象类中可以包含非抽象的普通方法，而接口中所有的方法必须是抽象的，不能有非抽象的普通方法。

   4，抽象类中的抽象方法的访问类型可以是public ，protected和默认类型，但接口中的抽象方法只能是public类型的，并且默认即为public abstract类型。

   5，抽象类中可以包含静态方法，接口内不能包含静态方法。

   6，抽象类和接口中都可以包含静态成员变量（接口中不能有普通成员变量，也不能具有非抽象函数），抽象类中的静态成员变量的访问类型可以任意，但接口中定义的变量只能是public  static类型，并且默认为public static类型。

   7，一个类可以实现多个接口，但只能继承一个抽象类。

再补充点两者在应用上的区别：

   接口更多的是在系统框架设计方法发挥作用，主要定义模块之间的通信，而抽象类在代码实现方面发挥作用，可以实现代码的重用

四、抽象关键字abstract不可以与那些关键字共存：

   1、final修饰最终类，没有子类。而抽象类必须要有子类继承。

   2、private是私有的，子类的函数要实现对父类成员函数的全面覆盖，故抽象类中不能有私有成员。

   3、static修饰的函数可以用类名调用，但是调用抽象函数没有意义。
 */

/*
接口和抽象类的选择：
一、interface的应用场合
     A. 类与类之前需要特定的接口进行协调，而不在乎其如何实现。
     B. 作为能够实现特定功能的标识存在，也可以是什么接口方法都没有的纯粹标识。
     C. 需要将一组类视为单一的类，而调用者只通过接口来与这组类发生联系。
     D. 需要实现特定的多项功能，而这些功能之间可能完全没有任何联系。

     即接口主要针对与功能、动作，体现了代码的扩展性。

二、abstract class的应用场合
      一句话，在既需要统一的接口，又需要实例变量或缺省的方法的情况下，就可以使用它。最常见的有：
      A. 定义了一组接口，但又不想强迫每个实现类都必须实现所有的接口。可以用abstract class定义一组方法体，甚至可以是空方法体，然后由子类选择自己所感兴趣的方法来覆盖。
      B. 某些场合下，只靠纯粹的接口不能满足类与类之间的协调，还必需类中表示状态的变量来区别不同的关系。abstract的中介作用可以很好地满足这一点。
      C. 规范了一组相互协调的方法，其中一些方法是共同的，与状态无关的，可以共享的，无需子类分别实现；而另一些方法却需要各个子类根据自己特定的状态来实现特定的功能

     将拥有共同属性特征的类继承抽象类，父类中添加新方法时子类将全部拥有而不用逐一去新增，体现了代码的复用性。
*/
public class Java06_08_Q1 {
    public static void main(String[] args){
        Test test = new Test();
        System.out.println(test.n1);
        System.out.println(test.n2);
        test.func1();
        test.func2();
        test.func3();
        test.interfunc1();
        test.interfunc2();
    }


}

class Test extends AbstractClass implements InterClass{

    @Override
    public void func1() {
        System.out.println("子类实现抽象类的抽象方法--func1");
    }

    //子类必须覆盖抽象类中的所有抽象方法
    @Override
    public void func3() {
        System.out.println("子类实现抽象类的抽象方法--func3");
    }

    @Override
    public void interfunc1() {
        System.out.println("子类实现接口的抽象方法--interfunc1");
    }

    @Override
    public void interfunc2() {
        System.out.println("子类实现接口的抽象方法--interfunc2");
    }
}

abstract class AbstractClass {
    //final abstract int n1 = 2; abstract不能与final共存
    //private abstract int n1 = 2; abstract不能与private共存
    //static abstract int n1 = 2;  abstract不能与static共存
    static String n1 = "公有静态变量";
    public String n2 = "公有非静态变量";

    AbstractClass(){
        System.out.println("抽象类中的构造器");
    }
    /*
    抽象类中不能定义抽象的构造器
    abstract AbstractClass(String str){
        System.out.println("抽象类中的抽象构造器");
    }
    */
    abstract void func1();

    public void func2(){
        System.out.println("抽象类中的公共方法");
    }

    abstract void func3();
}

interface InterClass{
    public int num = 0;
    public void interfunc1();
    public abstract void interfunc2();
}
