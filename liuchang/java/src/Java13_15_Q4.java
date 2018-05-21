/*
-Q4：请解释enum（枚举）的用法，且请编写代码Demo说明。
 */
public class Java13_15_Q4 {
/*
Enum 一般用来表示一组相同类型的常量。如性别、日期、月份、颜色等。
对这些属性用常量的好处是显而易见的，不仅可以保证单例，且比较时候可以用 ”==” 来替换 equals 。
JDK1.5 之前没有 Enum 这个类型，那时候一般用接口常量来替代。有了 JavaEnum 之后，可以更贴近的表示这种常量。
 */

    public static void main(String[] args){
        for(WeekDay day : WeekDay.values()){
            System.out.println(day+"======>"+day.getDay());
        }
        WeekDay.printDay(5);
    }
}

enum WeekDay{
    Mon("Monday"), Tue("Tuesday"), Wed("Wednesday"), Thu("Thursday"), Fri("Friday"), Sat("Saturday"), Sun("Sunday");
    private final String day;
    WeekDay(String day){
        this.day = day;
    }

    public static void printDay(int i){
        switch(i){
            case 1 : System.out.println(WeekDay.Mon);break;
            case 2 : System.out.println(WeekDay.Tue);break;
            case 3 : System.out.println(WeekDay.Wed);break;
            case 4 : System.out.println(WeekDay.Thu);break;
            case 5 : System.out.println(WeekDay.Fri);break;
            case 6 : System.out.println(WeekDay.Sat);break;
            case 7 : System.out.println(WeekDay.Sun);break;
            default : System.out.println("error");
        }
    }

    public String getDay(){
        return day;
    }
}



