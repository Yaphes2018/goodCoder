/*
-Q3：请问 final类、final方法与普通类、普通方法的区别是什么？
 */
/*
一、final
根据程序上下文环境，java关键字final有"这是无法改变的"或者"终态"的含义，它可以修饰非抽象类、非抽象类成员方法和变量。

1、final类
final类不能被继承，因此final类的成员方法没有机会被覆盖，默认都是final的。在设计类的时候，如果这个类不需要子类，类的实现细节不允许改变，并且确信这个类不会被覆盖，那么就设计为final类。

2、final方法
如果一个类不允许其子类覆盖某个方法，则可以把这个方法声明为final方法。
使用final方法的原因有二：
（1）把方法锁定，防止任何继承类修改它的意义和实现；
（2）高效。编译器在遇到final方法的时候会转入内嵌机制，大大提高执行效率。

3、final变量（常量）
用final修饰的成员变量表示常量，一旦给值就无法改变！
final修饰的变量有三种：静态变量、实例变量和局部变量，分别表示三种类型的常量。
另外，final变量定义的时候，可以先声明，二不给初始值，这种变量也成为final空白，无论什么情况，编译器都能确保空白final在使用之前必须初始化。但是，final空白在final关键字final的使用上提供了更大的灵活性，为此，一个类中的final数据成员就可以实现依对象而有所不同，却又保持其恒定不变的特征。

4、final参数
当函数参数为final类型时，你可以读取使用该参数，但是无法改变该参数的值。

二、final变量和普通变量的区别
1、类的final变量和普通变量的区别
当用final作用于类的成员变量时，成员变量（注意是成员变量，局部变量只需要保证在使用之前被初始化赋值即可）必须在定义时或者构造器中进行初始化赋值，而且final变量一旦被初始化赋值之后，就不能再被赋值了。

 */
public class Java06_08_Q3 {
    public static void main(String[] args){
        B test = new B();
        //test.i = 2; 无法给final修饰的变量赋值
        final B ttt = new B();
        //ttt = new B();  无法给final修饰的变量实例化新的对象
        test.f(2);

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b+2;
        String e = d+2;
        System.out.println(a==c); //返回true
        System.out.println(a==e); //返回false
    }
}

final class B{
    final int i = 1;
    public void f(final int i){
        //i++; 不能改变final修饰的参数的值
        System.out.println(i);
    }
}

// class A extends B{} 无法继承final修饰的类
class A {
    final void func() {
        System.out.println("I'm final function");
    }
}

class C extends A{
   // void func(){}  不允许覆盖final修饰的方法
}