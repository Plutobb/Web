public class test1 {
//    static {
//        System.out.println("外部类静态代码块");
//    }


    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
        static{
            System.out.println("静态内部类静态块加载时间：" + System.currentTimeMillis());
        }
    }

    public static synchronized void print(int n){
        System.out.println(n);
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        //test1 test1 = new test1();
////        InnerStaticClass innerStaticClass = new InnerStaticClass();
////        System.out.println(ClassLoader.getSystemClassLoader());
////        Class<?> aClass = Class.forName("InnerStaticClass");
//        Thread thread1 = new Thread(()->{
//            print(1);
//        });
//        Thread thread2 = new Thread(()->{
//            print(2);
//        });
//        Thread thread3 = new Thread(()->{
//           print(3);
//        });

    }

    public static void StackOver(){
        int i = 1;
        StackOver();
    }

}
