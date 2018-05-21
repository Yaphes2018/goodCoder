/*
-Q3：JAVA语言如何进行异常处理，关键字：throws,throw,try,catch,finally分别代表什么意义？在try块中可以抛出异常吗？
 */
public class Java09_10_Q3 {
    /*
Java通过面向对象的方法进行异常处理，把各种不同的异常进行分类，并提供了良好的接口。
在Java中，每个异常都是一个对象，它是Throwable类或其子类的实例。当一个方法出现异常后便抛出一个异常对象，该对象中包含有异常信息，调用这个对象的方法可以捕获到这个异常并可以对其进行处理。

Java的异常处理是通过5个关键词来实现的：try、catch、throw、throws和finally。
一般情况下是用try来执行一段程序，如果系统会抛出（throw）一个异常对象，可以通过它的类型来捕获（catch）它，或通过总是执行代码块（finally）来处理；try用来指定一块预防所有异常的程序；

catch子句紧跟在try块后面，用来指定你想要捕获的异常的类型；

throw语句用来明确地抛出一个异常；

throws用来声明一个方法可能抛出的各种异常（当然声明异常时允许无病呻吟）；

finally为确保一段代码不管发生什么异常状况都要被执行；
在try中可以抛异常
     */
    public static void main(String[] args) throws Exception{
        System.out.println("main:"+TryCatchTest());
        System.out.println("计算"+throwTest(3,0));
    }

    static int TryCatchTest(){
        int value = 10;
        try{
            //这里放可能会发生异常的语句
            for(int i=10; i<11; i--){
                if(i>0){
                    value = value - i;
                    System.out.println("for i="+i+" value:"+value);
                }
            }
            System.out.println("---------try value:"+value);
            throw new Exception("只是测试用...");
            //return value;
        } catch(Exception e){
            //这里处理异常
            System.err.println(e.toString()+"\n---------- catch value:"+value);
            return value;
        } finally{
            //这里的语句必然会得到执行，不管异常发生与否，一般用户关闭数据库链接，释放资源等操作
            System.out.println("---------- finally value:"+value);
            return 7;
        }
    }

    static int throwTest(int y, int n) throws Exception{
        int temp = 0;
        try{
            temp = y/n;
        } catch(Exception e){
        }
        return temp;
    }
}
