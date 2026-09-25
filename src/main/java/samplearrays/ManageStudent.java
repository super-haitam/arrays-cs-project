package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (Student stud : students) if (stud.getAge() > oldest.getAge()) oldest = stud;

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student stud : students) count += stud.isAdult() ? 1 : 0;
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students.length == 0) return Double.NaN;

        int sumGrades = 0;
        for (Student stud : students) sumGrades += stud.getGrade();
        return sumGrades / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student stud : students) if (stud.getName().equalsIgnoreCase(name)) return stud;
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, (s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student stud : students) if (stud.getGrade() >= 15) System.out.println(stud.getName());
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student stud : students) if (stud.getId() == id) { stud.setGrade(newGrade); return true; }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length; ++i)
            for (int j = i+1; j < students.length; ++j)
                if (students[i].getName().equals(students[j].getName())) {
                    System.out.println("Duplicates found.");
                    return true;
                }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] copy =  Arrays.copyOf(students, students.length + 1);
        copy[copy.length-1] = newStudent;
        return copy;
    }

    // 11) Find the Top Student in multiple classes represented in a 2D array
    public static Student[] findTopStudents(Student[][] mt) {
        Student[] tops = new Student[mt.length];

        for (int i = 0; i < mt.length; ++i) {
            tops[i] = mt[i][0];
            for (Student stud : mt[i])
                if (stud.getGrade() > tops[i].getGrade())
                    tops[i] = stud;
        }

        return tops;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(0, "Haitam", 19, 13),
                new Student(1, "Douaae", 19, 17),
                new Student(2, "Yasser", 19, 16),
                new Student(3, "Youssef", 20, 18),
                new Student(4, "Anass", 19, 19)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        System.out.println();

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("Oldest: " + oldest);

        System.out.println();

        // 3) Count adults
        int count = countAdults(arr);
        System.out.println("The number of adults is " + count);

        System.out.println();

        // 4) Average grade
        double avg = averageGrade(arr);
        System.out.println("Average Grade: " + avg);

        // 5) Find by name
        System.out.println("Yasser found: " + findStudentByName(arr, "Yasser"));

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4, 10);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println("Student named 'Dina': " + findStudentByName(arr, "Dina"));

        System.out.println();

        // 9) Duplicate names
        hasDuplicateNames(arr);

        // 10) Append new student
        Student abdelmoughit = new Student(5, "Abdelmoughit", 19, 20);
        Student[] copy = appendStudent(arr, abdelmoughit);
        for (Student s : copy) System.out.println(s);

        // 11) 2D Matrix
        Student[][] mt = {
                {
                        new Student(0, "Haitam", 19, 13),
                        new Student(1, "Douaae", 19, 17),
                        new Student(2, "Yasser", 19, 16)
                },
                {
                        new Student(3, "Youssef", 20, 18),
                        new Student(4, "Anass", 19, 19),
                        new Student(5, "Abdelmoughit", 19, 20)
                }
        };

        Student[] tops = findTopStudents(mt);
        System.out.println("\n== Top Students In Each Class ==");
        for (Student s : tops) System.out.println(s);
        System.out.println();
    }
}

