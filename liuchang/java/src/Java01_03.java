public class Java01_03 {
    public static void main(String[] args){
        // -Q1：下面的代码执行后，i和j分别是多少？int i = 0;int j = i++;int k = --i。
        int i = 0;
        int j = i++;
        int k = --i;
        //i=0 j=0 k=0
        System.out.println("01-03 Q1答案："+"\n"+"i的值为："+i+"\n"+"j的值为："+j+"\n"+"k的值为："+k);

        //-Q2：Java中&与&&的区别是什么？
        //&和&&都是逻辑运算符，都是判断两边同时为真则为真，否则为假；但是&&当第一个条件不成立之后，后面的条件就都不执行了，而&还是继续执行，直到整个条件语句执行完为止，举例说明：
        int q01 = 3;
        if((q01++ > 5) & (q01++ < 9)){
            System.out.println("&测试执行完毕");
        }
        //&条件两边都执行了，q01的值为5
        System.out.println("q01的值为："+q01);

        int q02 = 3;
        if((q02++ > 5) && (q02++ < 9)){
            System.out.println("&&测试执行完毕");
        }
        //&&只执行了前面的条件表达式，不成立后，不会执行后面的，q02的值为4
        System.out.println("q02的值为："+q02);

        //-Q3：Java中break和continue的用法及区别？
        /*
           1. break :
            (1) 结束当前整个循环，执行当前循环下边的语句。忽略循环体中任何其它语句和循环条件测试。
            (2) 只能跳出一层循环，如果你的循环是嵌套循环，那么你需要按照你嵌套的层次，逐步使用break来跳出。[逐层判断，逐步跳出]
            (3) break在循环体内，强行结束循环的执行，也就是结束整个循环过程，不在判断执行循环的条件是否成立，直接转向循环语句下面的语句。
            (4) 当break出现在循环体中的switch语句体内时，其作用只是跳出该switch语句体。
            总的来说：就近原则，结束当前的整个循环。
           2. return：
            (1) return从当前的方法中退出,返回到该调用的方法的语句处,继续执行。
            (2) return返回一个值给调用该方法的语句，返回值的数据类型必须与方法的声明中的返回值的类型一致。
            (3) return后面也可以不带参数，不带参数就是返回空，其实主要目的就是用于想中断函数执行，返回调用函数处。
           3. continue：
            (1) 终止本次循环的执行，即跳过当前这次循环中continue语句后尚未执行的语句，接着进行下一次循环条件的判断。
            (2) 结束当前循环，进行下一次的循环判断。
            (3) 终止当前的循环过程，但他并不跳出循环,而是继续往下判断循环条件执行语句.他只能结束循环中的一次过程,但不能终止循环继续进行.
         */
        //break输出：0 1 2 --结束循环--
        loopBreak();
        //continue输出：0 1 2 4 5 6 7 8 9 --结束循环--
        loopContinue();
        //return输出：0 1 2
        loopReturn();

        //-Q4：JDK和JRE的区别是什么？
        /*
        1、JRE
            java运行时环境，包含了java虚拟机，java基础类库。是使用java语言编写的程序运行所需要的软件环境，是提供给想运行java程序的用户使用的。
        2、JDK
            java开发工具包，是程序员使用java语言编写java程序所需的开发工具包，是提供给程序员使用的。
            JDK包含了JRE，同时还包含了编译java源码的编译器javac，还包含了很多java程序调试和分析的工具：jconsole，jvisualvm等工具软件，还包含了java程序编写所需的文档和demo例子程序。
        3、JDK与JRE的区别
            JDK是Java的开发工具，它不仅提供了Java程序运行所需的JRE，还提供了一系列的编译，运行等工具，如javac，java，javaw等。
            JRE只是Java程序的运行环境，它最核心的内容就是JVM（Java虚拟机）及核心类库。
         */

        //-Q5：Java支持的数据类型有哪些？什么是自动拆装箱？并请编写代码Demo说明。
        /*
        java支持8中基本的数据类型，每一种都有对应的封装类型：
        （1）int -- Integer
        （2）float -- Float
        （3）double -- Double
        （4）byte -- Byte
        （5）long -- Long
        （6）char -- Character
        （7）boolean -- Boolean
        （8）short -- Short

        基本数据类型和它对应的封装类型（对象包装类型）之间可以相互转换，从基本数据类型到封装类型叫做装箱，从封装类型到基本数据类型叫拆箱。
        自动装拆箱是jdk5。0提供的新特性，它可以自动实现类型的转换。
         */
        Integer m = 10; // 装箱，装箱时候自动调用Integer.valueOf(int)方法
        int n = m; //拆箱，拆箱时候自动调用Integer.intValue方法

        //但需要注意的是再通过valueOf(int)方法创建Integer对象时，如果数值在[-128,127]之间，返回的便是指向IntegerCache.cache中已经存在的对象的引用；否则创建一个新的Integer对象。
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2);  //返回true
        System.out.println(i3==i4);  //返回false

    }
    public static void loopBreak(){
        for(int i = 0; i<10; i++){
            if(i==3){
                break;
            }
            System.out.print(i+" ");
        }
        System.out.println("--结束循环--");
    }

    public static void loopContinue(){
        for(int i = 0; i<10; i++){
            if(i==3){
                continue;
            }
            System.out.print(i+" ");
        }
        System.out.println("--结束循环--");
    }

    public static void loopReturn(){
        for(int i = 0; i<10; i++){
            if(i==3){
                return;
            }
            System.out.print(i+" ");
        }
        System.out.println("--结束循环--");
    }
}
