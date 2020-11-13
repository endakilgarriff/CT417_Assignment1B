import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Student s1 = new Student("Valteri Bottas", 21, "05/01/1999");
        Student s2 = new Student("Charles Leclerc", 22, "06/07/1998");
        Student s3 = new Student("Rebecca Black", 24, "25/02/1996");
        Student s4 = new Student("Lewis Hamilton", 21, "17/06/1999");
        Student s5 = new Student("Max Verstappen", 23, "30/09/1997");
        Student s6 = new Student("Lando Norris", 20, "13/01/2000");

        ArrayList<Student> allStudentList = new ArrayList<>();
        allStudentList.add(s1);
        allStudentList.add(s2);
        allStudentList.add(s3);
        allStudentList.add(s4);
        allStudentList.add(s5);
        allStudentList.add(s6);

        Module m1 = new Module("Digital Signal Processing", "EE445");
        Module m2 = new Module("System On Chip 1", "EE401");
        Module m3 = new Module("Statistics", "MA101");
        Module m4 = new Module("Software Engineering 3", "CT417");
        Module m5 = new Module("Microbiology 1", "EV107");
        Module m6 = new Module("Into to MatLab", "CT230");

        Course c1 = new Course("Electronic and Computer Engineering", "BP", "28/08/2020", "31/05/2021");
        Course c2 = new Course("Computer Science", "CT", "28/08/2020", "31/05/2021");
        Course c3 = new Course("Environmental Science", "EV", "03/09/2020", "28/05/2021");

        ArrayList<Course> allCourseList = new ArrayList<>();
        allCourseList.add(c1);
        allCourseList.add(c2);
        allCourseList.add(c3);

        //Engineering Course standard modules
        c1.addModuleToCourse(m1);
        c1.addModuleToCourse(m2);
        c1.addModuleToCourse(m4);

        //Computer Science standard modules
        c2.addModuleToCourse(m4);
        c2.addModuleToCourse(m6);

        //Environmental Science standard modules
        c3.addModuleToCourse(m3);
        c3.addModuleToCourse(m5);

        //Enroll Engineering Students
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);

        //Enroll Computer Science Student
        c2.enrollStudent(s3);
        c2.enrollStudent(s6);

        //Enroll Environmental Science student
        c3.enrollStudent(s4);
        c3.enrollStudent(s5);

        //Register Student s3 for elective module
        m3.addStudents(s3);

        //Remove Student s1 from software engineering
        m2.removeStudent(s1);

        //Print out standard modules and registered students for each course
        for(Course c: allCourseList){
            System.out.println("Course: " + c.getCourseID() + " - " + c.getCourseName() + "\n" +
                    "Standard Modules: " );
            for(Module m : c.getListOfModules()){
                System.out.println("Module: " + m.getModuleID() + " - " + m.getName() );
            }
            for(Student s: c.getStudentsRegistered()){
                System.out.println("Student: " + s.getName() + " Username: " + s.getUserName());
            }
            System.out.println("\n");
        }

        //Print out username, modules taken and course for each student
        for(Student s: allStudentList){
            System.out.println();
            System.out.println("STUDENT: " + s.getName() + "\nUserName: " + s.getUserName());
            System.out.println("Enrolled in Course: ");
            for(Course c : s.getCourses()){
                System.out.println(c.getCourseID() + " - " + c.getCourseName());
            }
            System.out.println("Modules Registered in :");
            for(Module m : s.getModules()){
                System.out.println(m.getModuleID() + " - " + m.getName());
            }
            System.out.println("\n");
        }
    }

}


