import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

/*
-Q5：请编写一段代码，实现合并两个排序的链表。
 */
public class Java13_15_Q5 {

    public static void main(String[] args){
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);

        LinkedList list = Merge(list1, list2);
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    static LinkedList Merge(LinkedList list1, LinkedList list2){
        LinkedList<Integer> result = new LinkedList<>();
        ListIterator<Integer> it1 = list1.listIterator();
        ListIterator<Integer> it2 = list2.listIterator();
        while(it1.hasNext() || it2.hasNext()){
            if(it1.hasNext() && it2.hasNext()){
                int val1 = it1.next();
                int val2 = it2.next();
                if(val1 < val2){
                    result.add(val1);
                    it2.previous();
                } else {
                    result.add(val2);
                    it1.previous();
                }
            } else if(!it1.hasNext()){
                int val = it2.next();
                result.add(val);
            } else {
                int val = it1.next();
                result.add(val);
            }
        }
        return result;
    }
}
