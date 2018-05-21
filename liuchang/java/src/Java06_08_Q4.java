/*
-Q4：请问 overload和override的区别？overload的方法是否可以改变返回值的类型？
 */
/*
一、重载（overload）
表示同一个类中可以有多个名称相同的方法，但这些方法的参数列表各不相同（即参数个数、类型或顺序不同）
通过定义不同的输入参数来区分这些方法，在调用时，根据不同的参数格式来选择符合的方法执行，需要注意：
1、在使用重载时只能通过不同的参数样式，例如：不同的参数类型，不同的参数个数，不同的参数顺序（同一方法内的几个参数类型必须不一样，例如可以func(int,float)，但是不能func(int,int)）
2、不能通过访问权限、返回类型、抛出的异常进行重载
3、方法的异常类型和数目不会对重载造成影响
4、对于继承来说，如果某一方法在父类中的访问权限是private，那么就不能在子类中对其进行重载，如果定义的话，也只是定义了一个新的方法，同父类方法没关系

二、重写（override）
表示子类中的方法可以与父类中的某个方法名称和参数完全相同，通过子类创建的实例对象调用这个方法时，将调用子类中的定义方法，这相当于把父类中定义的那个完全相同的方法给覆盖了，这也是面向对象编程中多态的一种表现。
需要注意：
1、覆盖的方法的名称和参数必须要和被覆盖的方法的名称和参数完全匹配，才能达到覆盖的效果
2、覆盖的方法的返回值必须和被覆盖方法的返回值一致
3、覆盖的方法所抛出的异常必须和被覆盖的方法所抛出的异常一致，或者是其子类
4、被覆盖的方法不能为private，否则在其子类只能是新定义了一个方法。子类的访问权限只能比父类更大。

三、overload的方法是否可以改变返回值的类型？
可以，因为同返回值类型无关
 */
public class Java06_08_Q4 {
    public static void main(String[] args){
        Overload o = new Overload();
        System.out.println(o.func("test",123));
        System.out.println(o.func(456,"ttt"));
    }
}

class Overload{
    public String func(String str, int num){
        return str;
    }
    public int func(int num, String str){
        return num;
    }
}
