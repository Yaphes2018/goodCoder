/*
-Q5：请写出以下程序的输出结果？（ps：结合Java对象初始化执行优先级）
 */
public class Java04_05_Q5 {
    public static void main(String args[]) {
        new InitializeDemo("init");
    }
}

class InitializeDemo {
    private static int k = 1;
    private static InitializeDemo t1 = new InitializeDemo("t1");
    private static InitializeDemo t2 = new InitializeDemo("t2");
    private static int i = print("i");
    private static int n = 99;
    static {
        print("静态块");
    }
    private int j = print("j"); {
        print("构造块");
    }
    public InitializeDemo(String str) {
        System.out.println((k++) + ":" + str + " i=" + i + " n=" + n);
        ++i;
        ++n;
    }
    public static int print(String str) {
        System.out.println((k++) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        return ++i;
    }
}

/*
答案：（此题同Q3）
1:j i=0 n=0
2:构造块 i=1 n=1
3:t1 i=2 n=2
4:j i=3 n=3
5:构造块 i=4 n=4
6:t2 i=5 n=5
7:i i=6 n=6
8:静态块 i=7 n=99
9:j i=8 n=100
10:构造块 i=9 n=101
11:init i=10 n=102
 */
