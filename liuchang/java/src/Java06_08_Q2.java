/*
-Q2：继承与组合的优势分别是？应该如何选择？
 */

/*
一、组合
1、优点：
（1）不破坏封装，整体类与局部类之间松耦合，彼此相对独立
（2）具有较好的可扩展性
（3）支持动态组合。在运行时，整体对象可以选择不同类型的局部对象
（4）整体类可以对局部类进行包装，封装局部类的接口，提供新的接口
2、缺点：
（1）整体类不能自动获得和局部类同样的接口
（2）创建整体类的对象时，需要创建所有局部类的对象
二、继承
1、缺点：
（1）破坏封装，子类与父类之间紧密耦合，子类依赖于父类的实现，子类缺乏独立性
（2）支持扩展，但是往往以增加系统接口的复杂度为代价
（3）不支持动态继承。在运行时，子类无法选择不同的父类
（4）子类不能改变父类的接口
2、优点：
（1）子类能自动继承父类的接口
（2）创建子类的对象时，无需创建父类的对象
3、如何使用继承：
（1）精心设计专门用于被继承的类，继承树的抽象层应该比较稳定，一般不要多于三层
（2）对于不是专门用于被继承的类，禁止其被继承
（3）优先考虑用组合关系来提高代码的可重用性
（4）子类是一种特殊的类型，而不只是父类的一个角色
（5）子类扩展，而不是覆盖或者使父类的功能失效

总的来讲，组合通常优于继承
1、考虑使用多态，可以用继承
2、考虑复用父类方法，而父类很少改动，可以用继承
其他情况请慎重使用继承
 */

//基类
public class Java06_08_Q2 {
    public static void main(String[] args) {
        //继承

        Son son = new Son();
        son.eat();  //重载父类方法
        son.say();  //重载父类方法
        son.car();  //直接继承父类方法

        //组合
        Mother mother = new Mother();
        mother.eat();
        mother.sayhi();
        mother.cook();

    }
}
class Father {
    public void eat(){}
    public void say(){
        System.out.println("father say I'm your baba");
    }
    public void car(){
        System.out.println("father is driving");
    }
}

//子类继承
class Son extends Father{
    @Override
    public void eat() {
        super.eat();
        System.out.println("son eat food");
    }

    @Override
    public void say() {
        super.say();
        System.out.println("son say hello baba");
    }
}

//组合类
class Mother {
    private Father husband;
    public Mother(){
        husband = new Father();
    }
    public void eat(){
        System.out.println("mother eat food");
    }
    //只需要使用到father的say方法
    public void sayhi(){
        this.husband.say();
        System.out.println("mother say gun");
    }
    //特有方法
    public void cook(){
        System.out.println("mother id cooking");
    }
}

