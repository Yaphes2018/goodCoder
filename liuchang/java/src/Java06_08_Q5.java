/*
-Q5：请问 final, finally, finalize的区别？请编写代码Demo说明。
 */
/*
1、final可以修饰类、不能被继承；可以修饰方法，不能被重写；可以修饰变量，只能赋值一次
2、finally是try语句中的语句体，不能单独使用，用来释放资源
3、finalize是一个方法，当垃圾回收确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法
 */
public class Java06_08_Q5 {
    public static void main(String[] args){
        FinalTest test = new FinalTest();
        System.out.println(test.t);
        System.out.println(test.method());

        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);

        c2 = c3 = null;
        System.gc();
    }
}

class FinalTest {
    final int t;

    FinalTest(){
        t = 1;
    }
    //如果catch与try块中有return语句，finally块还会执行，会在try的return前执行，如果finally有return，则会优先执行finally的return
    public int method(){
        int num = 10;
        try{
            System.out.println("print try");
            num += 30;
            return num;
        }catch(Exception e){
            System.out.println("print error");
        }finally{
            if (num > 20){
                System.out.println("num: "+num);
            }
            System.out.println("print finally");
            num = 80;
            //return num;
        }
        return num;
    }
}

class Cake extends Object{
    private int id;
    Cake(int id){
        this.id = id;
        System.out.println("cake object "+id+" is created");
    }
    protected void finalize() throws java.lang.Throwable{
        super.finalize();
        System.out.println("cake object "+id+" is disposed");
    }
}