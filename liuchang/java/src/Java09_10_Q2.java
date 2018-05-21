/*
-Q2：请解释this和super关键字的使用场景和作用？请编写代码Demo说明。
 */
/*
一、this关键字
this是指向对象本身的一个指针。this只能在类中的非静态方法中使用，静态方法和静态代码块中绝对不能出现this。
1、调用本类的构造方法
仅仅在类的构造函数中调用本类的其他构造函数。用法是this(参数列表)，这一句必须处于构造函数的第一句，同时一个构造函数内部只能调用另一个构造函数

2、表示类中的属性和方法
用this来访问类中的属性和方法。比如函数参数或者参数中的局部变量和成员变量同名的情况下，成员变量被屏蔽，此时要访问成员变量则需要用"this.成员变量"来访问成员变量

3、表示当前对象
在函数中，需要引用该函数所属类的当前对象时，直接使用this

4、匿名和内部类
在匿名类或者内部类中用this时，这个this指的是匿名类或内部类本身，这是如果我们要使用外部类的方法和变量的话，应该加上外部类的类名。

二、super关键字
super同this类似，是使被屏蔽的成员变量或者成员方法变为可见，或者说用来引用被屏蔽的成员变量和成员方法。不过super是用在子类中，目的是访问直接父类中被屏蔽的成员
1、在子类构造方法中调用父类的构造方法
用super(参数列表)的方式调用，参数不是必须的，同时还需要注意这条语句只能在子类构造方法的第一行

2、访问父类中被覆盖的同名变量或者方法
当子类方法中的局部变量或者子类的成员变量与父类的成员变量同名时，也就是子类变量覆盖同名父类变量时，可以使用super.成员变量名引用父类成员变量，覆盖方法时也可以使用这种方式
 */

public class Java09_10_Q2 {
    public static void main(String[] args){
        ThisDemo thisDemo = new ThisDemo("this调用本类的其他构造函数");
        ThisDemo thisPr = new ThisDemo();
        thisPr.Out();
        thisPr.call();

        ThisDemo.ThisOut thisOut = new ThisDemo().new ThisOut();

    }
}

class ThisDemo extends SuperDemo{
    private String thistest = "test";
    ThisDemo(){
        super();
        System.out.println("无参数构造函数");
    }
    ThisDemo(String a){
        this();
        thistest = a;
        System.out.println(thistest);
    }
    public void Out(){
        String thistest = "重名的变量";
        System.out.println(this.thistest);
    }
    public void call(){
        System.out.println(this);
        System.out.println(super.superStr);
        super.superFunc();
    }
    public void outfunc(){
        System.out.println("外部类的方法");
    }

    class ThisOut{
        ThisDemo testdemo = new ThisDemo(){
          public void funcDemo(){
              ThisDemo.this.outfunc();
          }
        };
    }
}

class SuperDemo{
    public String superStr = "父类的变量";
    SuperDemo(){
        System.out.println("父类的构造方法");
    }
    public void superFunc(){
        System.out.println("父类的方法");
    }
}

