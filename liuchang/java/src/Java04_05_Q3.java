/*
-Q3：编写一个程序，验证（静态变量、静态初始化块、变量、初始化块、构造器）的初始化顺序。
 */
public class Java04_05_Q3 {
    public static void main(String[] args){
        InitialInner test01 = new InitialInner();
        InitialInner test02 = new InitialInner();
    }
}

class InitialOrder {
    public static String staticFather = "父类静态变量";{System.out.println(staticFather);}
    //public static int a = 2;{System.out.println(a);}
    public String father = "父类变量";{System.out.println(father);}

    //静态代码块
    static {
        //staticFather = "父类静态变量";{System.out.println(staticFather);}
        System.out.println("父类静态代码块");
    }
    //初始化块
    {
        System.out.println("父类初始化块");
    }
    //构造器
    InitialOrder(){
        System.out.println("父类构造器");
    }
}

class InitialInner extends InitialOrder{
    public static String staticSon = "子类静态变量";{System.out.println("子类静态变量");}
    public String son = "子类变量";{System.out.println("子类变量");}

    //静态代码块
    static{
        System.out.println("子类静态代码块");
    }
    //初始化块
    {
        System.out.println("子类初始化块");
    }
    //构造器
    InitialInner(){
        System.out.println("子类构造器");
    }

}
/*
类的初始化顺序：
静态代码块->静态变量->变量->初始化块->构造器
继承关系的类初始化顺序：
  父类静态代码块
  子类静态代码块
  父类静态变量
  父类变量
  父类初始化块
  父类构造器
  子类静态变量
  子类变量
  子类初始化块
  子类构造器

需要注意的是，不管类被实例化多少次，类的静态代码块只会执行一次：
  父类静态代码块   只执行了一次
  子类静态代码块   只执行了一次
  父类静态变量
  父类变量
  父类初始化块
  父类构造器
  子类静态变量
  子类变量
  子类初始化块
  子类构造器
  父类静态变量
  父类变量
  父类初始化块
  父类构造器
  子类静态变量
  子类变量
  子类初始化块
  子类构造器
 */

