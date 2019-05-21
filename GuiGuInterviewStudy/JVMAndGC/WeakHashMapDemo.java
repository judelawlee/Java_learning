package JVMAndGC;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  19:48
 * @description:
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("==================================");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";
        weakHashMap.put(key,value);
        System.out.println(weakHashMap);//{2=WeakHashMap}
        key = null;
        System.out.println(weakHashMap);//{2=WeakHashMap}
        System.gc();
        System.out.println(weakHashMap + "\t" + weakHashMap.size());//{}	0

    }

    private static void myHashMap() {
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key,value);
        System.out.println(map);//{1=HashMap}
        key = null;
        System.out.println(map);//{1=HashMap}

        System.gc();
        System.out.println(map + "\t" + map.size());//{1=HashMap}	1
    }


}
