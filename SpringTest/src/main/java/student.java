public class student {
    private String name;
    private int age;
    public school school;

    public student() {
        System.out.println("调用到了无参构造方法!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(school school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
