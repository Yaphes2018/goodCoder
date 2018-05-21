/*
-Q4：请写出作用域public、private、protected及其区别？并请编写代码Demo说明。
 */
public class Java04_05_Q4 extends Region {
    public static void main(String[] args){
        /*
        1、public：public表明该数据成员、成员函数是对所有用户开放的，所有用户都可以直接进行调用
        2、private：private表示私有，私有的意思就是除了class自己之外，任何人都不可以直接使用，私有财产神圣不可侵犯嘛，即便是子女，朋友，都不可以使用。
        3、protected：protected对于子女、朋友来说，就是public的，可以自由使用，没有任何限制，而对于其他的外部class，protected就变成private。

                作用域       当前类    同一package   子孙类     其他package

                public        √          √           √           √

                protected     √          √           √           ×

                friendly      √          √           √           ×

                private       √          ×           ×           ×

        注：不写时默认为friendly
         */
        Java04_05_Q4 t1 = new Java04_05_Q4();
        System.out.println(t1.test1);
        System.out.println(t1.test2);
        System.out.println(t1.test3);
        //System.out.println(t1.test4); 子类不能访问父类的private变量
    }

}

class Region {
    public String test1 = "public";
    protected String test2 = "protected";
    String test3 = "friendly";
    private String test4 = "private";


}