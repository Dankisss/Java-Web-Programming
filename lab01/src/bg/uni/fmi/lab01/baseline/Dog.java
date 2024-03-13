package bg.uni.fmi.lab01.baseline;

public class Dog implements Comparable<Dog>{
    private final String breed;
    private final int weight;

    public Dog() {
        breed = "Undefined";
        weight = -1;
    }

    public Dog(String breed, int weight) {
        this.breed = breed;
        this.weight = weight;
    }


    public String getBreed() {
        return breed;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public int compareTo(Dog o) {
        return Integer.compare(weight, o.getWeight());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }
}
