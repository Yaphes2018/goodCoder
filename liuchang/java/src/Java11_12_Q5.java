/*
-Q5：请尽可能多的写出遍历map元素的方法。请编写代码Demo说明。
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class Java11_12_Q5 {
/*
遍历Map的方式：

   1、将map 集合中所有的键取出存入set集合。
       Set<K> keySet()   返回所有的key对象的Set集合，再通过get方法获取键对应的值。
   2、 values() ，获取所有的值.
       Collection<V> values()不能获取到key对象
   3、 Map.Entry对象  推荐使用   重点
       Set<Map.Entry<k,v>> entrySet()   将map 集合中的键值映射关系打包成一个对象。
       Map.Entry对象通过Map.Entry 对象的getKey，getValue获取其键和值。
 */
    public static void main(String[] args){
        Map<Integer, String> map =new HashMap<Integer, String>();
        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "ccc");
        System.out.println(map);
        /*
            第一种方式：使用KeySet
            将Map转成Set集合（keySet()），通过Set的迭代器取出Set集合中的每一个元素（Iterator）就是Map集合中的所有的键，再通过get方法获取键对应的值。
        */
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> it1 = keySet.iterator();
        System.out.println("第一种方式：");
        while(it1.hasNext()){
            Integer key = it1.next();
            String value = map.get(key);
            System.out.println("key: "+key+" value: "+value);
        }

        /*
            第二种方式：通过values 获取所有值,不能获取到key对象
         */
        Collection<String> vs = map.values();
        Iterator<String> it2 = vs.iterator();
        System.out.println("第二种方式：");
        while(it2.hasNext()){
            String value = it2.next();
            System.out.println("value: "+value);
        }

        /*
            第三种方式：Map.Entry
            public static interface Map.Entry<K,V>   通过Map中的entrySet()方法获取存放Map.Entry<K,V>对象的Set集合。
            Set<Map.Entry<K,V>> entrySet()    面向对象的思想将map集合中的键和值映射关系打包为一个对象，就是Map.Entry，将该对象存入Set集合，Map.Entry是一个对象，那么该对象具备的getKey，getValue获得键和值。
         */
        // 返回的Map.Entry对象的Set集合 Map.Entry包含了key和value对象
        Set<Map.Entry<Integer, String>> es = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it3 = es.iterator();
        System.out.println("第三种方式：");
        while(it3.hasNext()){
            // 返回的是封装了key和value对象的Map.Entry对象
            Map.Entry<Integer, String> en = it3.next();
            // 获取Map.Entry对象中封装的key和value对象
            Integer key = en.getKey();
            String value = en.getValue();
            System.out.println("key: "+key+" value: "+value);
        }
    }


}
