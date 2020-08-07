public class school {
    private String name;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "school{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
