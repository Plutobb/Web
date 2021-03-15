import java.lang.reflect.Constructor;

public class Instance {
    static Instance instance = new Instance();

    private Instance() { }

    public Instance getInstance() {
        return instance;
    }

    @lombok.SneakyThrows
    public static void main(String[] args) {
        Instance instance = new Instance();
        Class<? extends Instance> aClass = instance.getClass();
        Constructor<? extends Instance> instance1 = aClass.getDeclaredConstructor(null);
        instance1.setAccessible(true);
        Instance instance2 = instance1.newInstance();
        System.out.println(instance == instance2);
    }
}
