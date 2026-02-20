class Student {
    private String name;
    private int age;

    // setter
    public void setName(String n) {
        name = n;
    }

    public void setAge(int a) {
        age = a;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Day08 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Anandee");
        s.setAge(18);

        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
