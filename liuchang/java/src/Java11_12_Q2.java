/*
-Q2：请用Java实现斐波那契数列（递归+非递归方式）。
0 1 1 2 3 5 8 13 21 34 ...
因此公式为：
F(0) = 0
F(1) = 1
F(2) = F(0) + F(1)
F(3) = F(1) + F(2)
...
F(n) = F(n-2) + F(n-1)
 */
public class Java11_12_Q2 {
    //使用递归方式实现
    public static int feibonaci1(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return feibonaci1(n-2) + feibonaci1(n-1);
    }

    //使用非递归方式实现
    public static int feibonaci2(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }

    public static void main(String[] args){
        System.out.println(feibonaci1(9));
        System.out.println(feibonaci2(9));
    }
}
