public class JavaLangObject_Main extends java.lang.Object{

    public static void main(String[] args) {

        AStudent max = new AStudent("Max", 21);
        System.out.println(max.toString());

        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8, "Carole");
        System.out.println(jimmy.toString());
    }

}

class AStudent { // not public, as only one class in a java source file can be public

    private String name;
    private int age;

    AStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }


    @Override
    public String toString() {
        return name + " is " + age;
//        return "AStudent{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
    }

}
    class PrimarySchoolStudent extends AStudent {

        private String parentName;

        PrimarySchoolStudent(String name, int age, String parentName) {
            super(name, age);
            this.parentName = parentName;
        }

        @Override
        public String toString() {
            return parentName + "'s kid, " + super.toString();
//            return "PrimarySchoolStudent{" +
//                    "parentName='" + parentName + '\'' +
//                    "} " + super.toString();
        }
    }