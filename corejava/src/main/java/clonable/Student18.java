package clonable;

class Student18 implements Cloneable {
    int rollno;
    String name;

    Student18(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            Student18 s1 = new Student18(101, "amit");

            Student18 s2 = (Student18) s1.clone();

            System.out.println(s1.rollno + " " + s1.name + " " + s1);
            System.out.println(s2.rollno + " " + s2.name + " " + s2);

        } catch (CloneNotSupportedException c) {
        }

    }

//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}  