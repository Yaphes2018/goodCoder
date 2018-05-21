/*
-Q2：请解释HashMap的工作原理是什么？HashMap与HashTable的区别是什么？
 */
public class Java13_15_Q2 {
/*
一、HashMap的工作原理
采用数组+链表的数据结构，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的，如果定位到的数组位置不含链表（当前entry的next指向null）,那么对于查找，添加等操作很快，仅需一次寻址即可；
如果定位到的数组包含链表，对于添加操作，其时间复杂度依然为O(1)，因为最新的Entry会插入链表头部，仅需简单改变引用链即可，而对于查找操作来讲，此时就需要遍历链表，然后通过key对象的equals方法逐一比对查找。
所以，性能考虑，HashMap中的链表出现越少，性能才会越好。

HashMap通过put()和get()方法储存和获取对象。
当我们将键值对传递给put()方法时，它调用键对象的hashCode()方法来计算hashcode，让后找到bucket位置来储存值对象。
当获取对象时，通过键对象的equals()方法找到正确的键值对，然后返回值对象。
HashMap使用链表来解决碰撞问题，当发生碰撞了，对象将会储存在链表的下一个节点中。 HashMap在每个链表节点中储存键值对对象。

下面详细介绍put()个get()的工作原理
put():
a) 先获取key对象的hashcode之进行处理
b) 将处理后的hashcode对table的length-1进行取余获得index即在数组中的索引位置
c) 然后对该位置的Entry进行判断，若该位置为空，那么插入新的Entry
d) 若当前的Entry不为空，那么根据key.equals()对该链表进行遍历，若是该key对象存在，则用新值代替旧值，否则在链表尾端插入新的Entry

get():
跟put()里面的原理大致相同，根据key.hashcode()值找到相应的index，再根据key.equals()遍历该Index中的Entry链表，找到则返回对应的value，否则返回null。

HashMap与HashTable的区别是什么？

1、两者最主要的区别在于Hashtable是线程安全，而HashMap则非线程安全。Hashtable的实现方法里面都添加了synchronized关键字来确保线程同步，因此相对而言HashMap性能会高一些，
我们平时使用时若无特殊需求建议使用HashMap，在多线程环境下若使用HashMap需要使用Collections.synchronizedMap()方法来获取一个线程安全的集合
（Collections.synchronizedMap()实现原理是Collections定义了一个SynchronizedMap的内部类，这个类实现了Map接口，在调用方法时使用synchronized来保证线程同步,
当然了实际上操作的还是我们传入的HashMap实例，简单的说就是Collections.synchronizedMap()方法帮我们在操作HashMap时自动添加了synchronized来实现线程同步，类似的其它Collections.synchronizedXX方法也是类似原理。
2、HashMap可以使用null作为key，不过建议还是尽量避免这样使用。HashMap以null作为key时，总是存储在table数组的第一个节点上。而Hashtable则不允许null作为key。
3、HashMap继承了AbstractMap，HashTable继承Dictionary抽象类，两者均实现Map接口。
4、HashMap的初始容量为16，Hashtable初始容量为11，两者的填充因子默认都是0.75。
5、HashMap扩容时是当前容量翻倍即:capacity*2，Hashtable扩容时是容量翻倍+1即:capacity*2+1。
6、HashMap和Hashtable的底层实现都是数组+链表结构实现。
7、两者计算hash的方法不同：Hashtable计算hash是直接使用key的hashcode对table数组的长度直接进行取模：
 */
}
