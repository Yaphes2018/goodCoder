/*
-Q4：请解释Java中List、Set和Map的区别和应用场景？
 */
public class Java11_12_Q4 {
/*
　　List：有序，可重复，常用于增删改
　　　　|——ArrayList：底层的数据结构是数组,线程不同步，ArrayList替代了Vector，查询元素的速度非常快。
　　　　|——LinkedList：底层的数据结构是链表，线程不同步，增删元素的速度非常快。
　　　　|——Vector：底层的数据结构就是数组，线程同步的，Vector无论查询和增删都巨慢。

　　Set：无序，不可重复，常用于比较和查询
　　　　|——HashSet：底层数据结构是哈希表，线程是不同步的。无序，高效；
　　　　　　　　HashSet集合保证元素唯一性：通过元素的hashCode方法，和equals方法完成的。
　　　　　　　　当元素的hashCode值相同时，才继续判断元素的equals是否为true。
　　　　　　　　如果为true，那么视为相同元素，不存。如果为false，那么存储。
　　　　　　　　如果hashCode值不同，那么不判断equals，从而提高对象比较的速度。
　　　　　　|——LinkedHashSet：有序，hashset的子类。
　　　　|——TreeSet：对Set集合中的元素的进行指定顺序的排序。不同步。TreeSet底层的数据结构就是二叉树。

　　Map：键值对
　　　　|——Hashtable：底层是哈希表数据结构，是线程同步的。不可以存储null键，null值。
　　　　|——HashMap：底层是哈希表数据结构，是线程不同步的。可以存储null键，null值。替代了Hashtable.
　　　　|——TreeMap：底层是二叉树结构，可以对map集合中的键进行指定顺序的排序。

使用集合的技巧：

看到Array就是数组结构，有角标，查询速度很快。
看到link就是链表结构：增删速度快，而且有特有方法。addFirst； addLast； removeFirst()； removeLast()； getFirst()；getLast()；
看到hash就是哈希表，就要想要哈希值，就要想到唯一性，就要想到存入到该结构的中的元素必须覆盖hashCode，equals方法。
看到tree就是二叉树，就要想到排序，就想要用到比较。

LinkedHashSet，LinkedHashMap:这两个集合可以保证哈希表有存入顺序和取出顺序一致，保证哈希表有序。

集合什么时候用：当存储的是一个元素时，就用Collection。当存储对象之间存在着映射关系时，就使用Map集合。
              保证唯一，就用Set。不保证唯一，就用List。
 */
}
