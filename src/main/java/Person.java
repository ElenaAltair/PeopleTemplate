import java.util.Objects;

public class Person {
    /*
    Имя (String). Каждый человек обязан иметь имя, причём с момента создания объекта изменить его нельзя.

    Фамилия (String). Каждый человек обязан иметь фамилию, причём с момента создания объекта изменить её нельзя.

    Возраст (int). Если возраст человека известен,
    то с момента создания объекта он может быть изменён только увеличением на единицу через вызов метода happyBirthday().
    Возраст человека может быть неизвестен, в этом случае метод boolean hasAge() должен вернуть false, иначе - true.
    Подумайте, как эффективнее хранить в объекте информацию о том, известен ли возраст человека.

    Текущий город жительства (String). Может быть известен (в этом случае метод boolean hasAddress() должен вернуть true,
    иначе - false) и выставлен в любой через setAddress(String city).
     */
    private String name;
    private String surname;
    private int age = 1000; // 1000 - возраст неизвестен
    private String currentCityOfResidence = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.currentCityOfResidence = personBuilder.getCurrentCityOfResidence();
    }

    public void happyBirthday() {
        age++;
    }

    public boolean hasAge() {
        return age != 1000;
    }

    public boolean hasAddress() {
        return currentCityOfResidence != null;
    }

    public void setAddress(String city) {
        this.currentCityOfResidence = city;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", currentCityOfResidence='" + currentCityOfResidence + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(currentCityOfResidence, person.currentCityOfResidence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, currentCityOfResidence);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder();
    }
}


