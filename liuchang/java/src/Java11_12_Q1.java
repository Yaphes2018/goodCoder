/*
-Q1：String类的==与equals区别是什么？StringBuffer与StringBuilder的区别是什么？如何选用？
 */
public class Java11_12_Q1 {
/*
(1)对于字符串变量来说，使用==是比较两个变量本身的值，即两个对象在内存中的首地址；equals()是比较字符串中包含的内容是否相同
(2)对于非字符串变量来说，==和equals()方法作用相同，都是用来比较其对象在对内存中的首地址，即用来比较两个引用变量是否指向同一个内存区域
 */
    public static void main(String[] args){
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println("字符串==： "+(s1==s2));
        System.out.println("字符串equals： "+s1.equals(s2));

        Aobj obj1 = new Aobj();
        Aobj obj2 = new Aobj();
        Aobj obj3 = obj1;
        System.out.println("对象==："+(obj1==obj2));
        System.out.println("对象equals："+obj1.equals(obj2));
        System.out.println("对象==："+(obj1==obj3));
        System.out.println("对象equals："+obj1.equals(obj3));
    }
/*
1、StringBuffer 与 StringBuilder 中的方法和功能完全是等价的，

2、只是StringBuffer 中的方法大都采用了 synchronized 关键字进行修饰，因此是线程安全的，

而 StringBuilder 没有这个修饰，可以被认为是线程不安全的。

3、在单线程程序下，StringBuilder效率更快，因为它不需要加锁，不具备多线程安全

而StringBuffer则每次都需要判断锁，效率相对更低
 */
}

class Aobj{}
