public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            this.age = 0;
            return;
        }
        this.age = age;
    }

    public boolean isTeen() {
        return (this.age > 12 && this.age < 20);
    }

    public String getFullName() {
        boolean emptyFirstName = this.firstName.isEmpty();
        boolean emptyLastName = this.lastName.isEmpty();

        if (emptyLastName && emptyFirstName) {
            return "";
        }

        if (emptyFirstName) {
            return this.lastName;
        }

        if (emptyLastName) {
            return this.firstName;
        }

        return this.firstName + " " + this.lastName;
    }
}
