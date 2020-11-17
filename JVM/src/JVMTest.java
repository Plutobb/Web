public class JVMTest {
    static class student{

    }
    public static void main(String[] args) {
        student student = new student();
        student student1 = new student();
        student student2 = new student();
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student.hashCode());
        System.out.println(student.getClass().hashCode());
        System.out.println(student1.getClass().hashCode());
        System.out.println(student2.getClass().hashCode());
    }
}
