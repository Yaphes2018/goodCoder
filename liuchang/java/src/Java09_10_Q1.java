/*
-Q1：请写一个程序模拟几种常见的Exception，如果catch与try块中有return语句，finally块还会执行吗？
 */
public class Java09_10_Q1 {
    public static void main(String[] args){
        //空指针引用异常：NullPointerException
        String n = null;

        ExceptionDemo tt = new ExceptionDemo();
        //tt.checkEqual(n); //引用了空对象

        //数字格式异常：NumberFormatExecption
        //int i = java.lang.Integer.parseInt("abcdefg");
        //System.out.println(i);

        //类型强制转换异常：ClassCastExecption
        Object obj = new Object();
        //String o = (String)obj;

        //传递非法参数异常：IllegalArgumentException
        //tt.backInt("123");

        //数组越界：ArrayIndexOutOfBoundsException
        int a[] = new int[3];
        //a[3] = 3;

        //字符串越界：StringIndexOutOfBoundsException
        String s = "hello";
        //char c = s.charAt(5);

        //算数错误：ArithmeticException
        int k = 0;
        //int kk = 5/k;
    }
}

class ExceptionDemo{
    public boolean checkEqual(String str){
        if(str == null) throw new NullPointerException("参数不能为空");
        if(str.equals("A")) return true;
        else return false;
    }
    public int backInt(int i){
        return i;
    }

}