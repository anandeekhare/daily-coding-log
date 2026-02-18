class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    void introduce() {
        System.out.println("Hi, I am " + name + " and I am " + age + " years old.");
    }
}

Student s1 = new Student("Anandee", 18);
s1.introduce();

public class Day07 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Anandee";
        s1.age = 18;

        s1.introduce();
    }
}
