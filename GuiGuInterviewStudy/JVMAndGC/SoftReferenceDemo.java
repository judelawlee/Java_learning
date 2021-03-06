package JVMAndGC;

import java.lang.ref.SoftReference;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  16:48
 * @description: 软引用 内存够用，就保留
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        softRef_Memory_Enough();
        System.out.println("++++++++++++++++++++++++++++++++");
        softRef_Memory_NotEnough();
    }

    private static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }
    /**
     *  模拟内存不够用的软引用
     * JVM配置，故意产生大对象并配置小的内存，让它的内存不够用了导致OOM，看软引用的回收的情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     * */
    private static void softRef_Memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        try{
            byte[] bytes = new byte[30*1024*1024];
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

}
