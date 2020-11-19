import java.util.Random;

public class JVMHeap {
    //测试GC以及JVM堆中 新生区 老年区 元空间 的物理空间位置和大小;
    //修改VM options : -Xms8m -Xmx8m -XX:+PrintGCDetails
    //JVM调优的常见参数;
    //-Xms: //堆内存初始化大小
    //-Xmx: //堆最大可用内存
    //-Xmn: //新生代堆最大可用内存
    //-XX:UseSerialGC //设置新生代中：Eden空间、SurvivorRadio From空间、SurvivorRadio To空间的占比
    //-XX:NewRatio //设置新生代空间和老年代空间的占比
    //-XX:+PrintGC //每次触发GC的时候打印相关日志
    //-XX:+UseSerialGC //串行回收
    //-XX:+PrintGCDetails //打印详细Gc日志
    public static void main(String[] args) {
        String string = "Mopo";
        while (true){
            string += string + new Random().nextInt(8888888) + new Random().nextInt(8888888);
        }
    }
    //D:\JDK\bin\java.exe -Xms8m -Xmx8m -XX:+PrintGCDetails "-javaagent:D:\IntelliJ IDEA 2020.1\lib\idea_rt.jar=61008:D:\IntelliJ IDEA 2020.1\bin" -Dfile.encoding=UTF-8 -classpath D:\JDK\jre\lib\charsets.jar;D:\JDK\jre\lib\deploy.jar;D:\JDK\jre\lib\ext\access-bridge-64.jar;D:\JDK\jre\lib\ext\cldrdata.jar;D:\JDK\jre\lib\ext\dnsns.jar;D:\JDK\jre\lib\ext\jaccess.jar;D:\JDK\jre\lib\ext\jfxrt.jar;D:\JDK\jre\lib\ext\localedata.jar;D:\JDK\jre\lib\ext\nashorn.jar;D:\JDK\jre\lib\ext\sunec.jar;D:\JDK\jre\lib\ext\sunjce_provider.jar;D:\JDK\jre\lib\ext\sunmscapi.jar;D:\JDK\jre\lib\ext\sunpkcs11.jar;D:\JDK\jre\lib\ext\zipfs.jar;D:\JDK\jre\lib\javaws.jar;D:\JDK\jre\lib\jce.jar;D:\JDK\jre\lib\jfr.jar;D:\JDK\jre\lib\jfxswt.jar;D:\JDK\jre\lib\jsse.jar;D:\JDK\jre\lib\management-agent.jar;D:\JDK\jre\lib\plugin.jar;D:\JDK\jre\lib\resources.jar;D:\JDK\jre\lib\rt.jar;D:\Project_IDEA\.idea\out\production\JVM JVMHeap
    //[GC (Allocation Failure) [PSYoungGen: 1536K->480K(2048K)] 1536K->692K(7680K), 0.0013667 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) [PSYoungGen: 1938K->504K(2048K)] 2150K->1131K(7680K), 0.0009523 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) [PSYoungGen: 1983K->504K(2048K)] 2611K->1435K(7680K), 0.0009489 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) [PSYoungGen: 1988K->488K(2048K)] 4072K->3203K(7680K), 0.0010858 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) [PSYoungGen: 1127K->488K(2048K)] 4995K->4371K(7680K), 0.0007562 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) [PSYoungGen: 488K->488K(2048K)] 4371K->4403K(7680K), 0.0004742 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[Full GC (Allocation Failure) [PSYoungGen: 488K->0K(2048K)] [ParOldGen: 3915K->2377K(5632K)] 4403K->2377K(7680K), [Metaspace: 3500K->3500K(1056768K)], 0.0057313 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) --[PSYoungGen: 1181K->1181K(2048K)] 5863K->5863K(7680K), 0.0047059 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[Full GC (Ergonomics) [PSYoungGen: 1181K->0K(2048K)] [ParOldGen: 4681K->1798K(5632K)] 5863K->1798K(7680K), [Metaspace: 3500K->3500K(1056768K)], 0.0061856 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) [PSYoungGen: 1212K->0K(2048K)] 5315K->4102K(7680K), 0.0006694 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4102K->4102K(7680K), 0.0006582 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4102K->4102K(5632K)] 4102K->4102K(7680K), [Metaspace: 3500K->3500K(1056768K)], 0.0066508 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
    //[GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4102K->4102K(7680K), 0.0004502 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4102K->4081K(5632K)] 4102K->4081K(7680K), [Metaspace: 3500K->3500K(1056768K)], 0.0063874 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    //Heap
    // PSYoungGen      total 2048K, used 46K [0x00000000ffd80000, 0x0000000100000000, 0x0000000100000000)
    //  eden space 1536K, 2% used [0x00000000ffd80000,0x00000000ffd8b810,0x00000000fff00000)
    //  from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
    //  to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
    // ParOldGen       total 5632K, used 4081K [0x00000000ff800000, 0x00000000ffd80000, 0x00000000ffd80000)
    //  object space 5632K, 72% used [0x00000000ff800000,0x00000000ffbfc780,0x00000000ffd80000)
    // Metaspace       used 3532K, capacity 4502K, committed 4864K, reserved 1056768K
    //  class space    used 391K, capacity 394K, committed 512K, reserved 1048576K
    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    //	at java.util.Arrays.copyOf(Arrays.java:3332)
    //	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
    //	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
    //	at java.lang.StringBuilder.append(StringBuilder.java:208)
    //	at JVMHeap.main(JVMHeap.java:9)

    //这里是运行结果,可以看出来
}
