public class PersonBuilder {
    private String name;
    private String surname;
    private int age = 1000; // 1000 - возраст неизвестен
    private String currentCityOfResidence = null;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.currentCityOfResidence = address;
        return this;
    }

    public Person build() {
        return new Person(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCurrentCityOfResidence() {
        return currentCityOfResidence;
    }
}
