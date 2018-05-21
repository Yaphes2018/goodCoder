/*
-Q4：请写出以下程序的输出结果？（ps：结合Java内部类）
 */

/*
答案：InterClass Create
     OuterClass Create
 */
public class Java09_10_Q4 {

        public static void main(String[] args){
            OuterClass oc = new OuterClass();
        }
}

    class OuterClass {
        private class InterClass {
            public InterClass() {
                System.out.println("InterClass Create");
            }
        }

        public OuterClass() {
            InterClass ic = new InterClass();
            System.out.println("OuterClass Create");
        }
    }

