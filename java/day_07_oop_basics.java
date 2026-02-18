class Student {
    String name;
    int age;

    void introduce() {
        System.out.println("Hi, I am " + name + " and I am " + age + " years old.");
    }
}

public class Day07 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Anandee";
        s1.age = 18;

        s1.introduce();
    }
}
