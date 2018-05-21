/*
-Q1：请解释单例模式及其应用场景，且编写代码Demo说明。
 */
public class Java16_Q1 {
/*
单例模式：类只有一个实例，提供一个全局访问点（外部通过这个访问入口来访问该类的唯一实例）
懒汉式单例模式：类加载时不初始化
饿汉式单例模式：类加载时就完成了初始化，所以类加载比较满，但获取类对象的速度快

适用场景：
    单例模式只允许创建一个对象，因此节省内存，加快对象访问速度，因此对象需要被公用的场合适合使用，如多个模块使用同一个数据源连接对象等等。如：
    1.需要频繁实例化然后销毁的对象。
    2.创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
    3.有状态的工具类对象。
    4.频繁访问数据库或文件的对象。
以下都是单例模式的经典使用场景：
    1.资源共享的情况下，避免由于资源操作时导致的性能或损耗等。如上述中的日志文件，应用配置。
    2.控制资源的情况下，方便资源之间的互相通信。如线程池等。
应用场景举例：
    1.外部资源：每台计算机有若干个打印机，但只能有一个PrinterSpooler，以避免两个打印作业同时输出到打印机。内部资源：大多数软件都有一个（或多个）属性文件存放系统配置，这样的系统应该有一个对象管理这些属性文件
    2. Windows的Task Manager（任务管理器）就是很典型的单例模式（这个很熟悉吧），想想看，是不是呢，你能打开两个windows task manager吗？ 不信你自己试试看哦~
    3. windows的Recycle Bin（回收站）也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
    4. 网站的计数器，一般也是采用单例模式实现，否则难以同步。
    5. 应用程序的日志应用，一般都何用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
    6. Web应用的配置对象的读取，一般也应用单例模式，这个是由于配置文件是共享的资源。
    7. 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。数据库软件系统中使用数据库连接池，主要是节省打开或者关闭数据库连接所引起的效率损耗，这种效率上的损耗还是非常昂贵的，因为何用单例模式来维护，就可以大大降低这种损耗。
    8. 多线程的线程池的设计一般也是采用单例模式，这是由于线程池要方便对池中的线程进行控制。
    9. 操作系统的文件系统，也是大的单例模式实现的具体例子，一个操作系统只能有一个文件系统。
    10. HttpApplication 也是单位例的典型应用。熟悉ASP.Net(IIS)的整个请求生命周期的人应该知道HttpApplication也是单例模式，所有的HttpModule都共享一个HttpApplication实例.
 */
    public static void main(String[] args){
        SingletonE e1 = SingletonE.getE();
        SingletonE e2 = SingletonE.getE();
        System.out.println(e1.equals(e2));
        SingletonL l1 = SingletonL.getL();
        SingletonL l2 = SingletonL.getL();
    }
}

//饿汉式单例模式
class SingletonE{
    private static SingletonE e = new SingletonE();
    private SingletonE(){}  //私有化构造函数
    public static SingletonE getE(){
        System.out.println("饿汉式单例模式");
        return e;
    }
}

//懒汉式单例模式
class SingletonL{
    private static SingletonL l;
    private SingletonL(){}
    public static SingletonL getL(){
        if(l == null){
            l = new SingletonL();
            System.out.println("饿汉式单例模式");
        } else {
            System.out.println("已经创建过实例！");
        }
        return l;
    }
}

