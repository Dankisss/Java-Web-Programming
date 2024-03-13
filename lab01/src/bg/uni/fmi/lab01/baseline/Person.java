package bg.uni.fmi.lab01.baseline;
public class Person {
    private String name;
    private  int age;

    public Person() {
        name = new String("No name");
        age = -1;
    }

    public Person(String name) {
        this.name = name;
        age = -1;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        if (age == -1) {
            return "Hello, I am " + name;
        }

        if (name.equals("No name")) {
            return "I am John Doe";
        }

        return "Hello, I am " + name + ". I am " + age + " years old.";
    }

    public static void main(String[] args) {
        Person brat = new Person("Nikita Lozanova", 18);
        brat.setName("Nikita Petkunkova");
        System.out.println(brat.toString());
    }
}
