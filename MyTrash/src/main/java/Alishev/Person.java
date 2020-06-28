package Alishev;

public class Person {
    String name, firstName, lastName;
    public int id, age, money;
    private double dollars;

    public Person() {
        this.id = -1;
        this.name = "No name";
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void sayHello() {
        System.out.println("id is: " + id + "and name: " + name + " says hello!");
    }

    public void printAny(String any) {
        System.out.println(any);
    }

    @Deprecated
    public double dollarsOutOld(double amount) {
        return dollars -= amount;
    }

    private double dollarsOut(double amount) {
        return dollars -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
