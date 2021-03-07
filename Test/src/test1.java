public class test1 {
    static {
        System.out.println("外部类静态代码块");
    }


    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
        static{
            System.out.println("静态内部类静态块加载时间：" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        //test1 test1 = new test1();
        InnerStaticClass innerStaticClass = new InnerStaticClass();
    }

}
