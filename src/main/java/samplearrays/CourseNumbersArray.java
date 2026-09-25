package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int newCourse = 6767;

        int[] updatedCourses = Arrays.copyOf(registeredCourses, registeredCourses.length + 1);
        updatedCourses[updatedCourses.length-1] = newCourse;

        System.out.println("Courses: {");
        for (int course : updatedCourses) System.out.println("\t" + course);
        System.out.println("}");

        int searchCourse;
        boolean found;

        searchCourse = 1020;

        found = false;
        for (int course : updatedCourses) if (course == searchCourse) { System.out.println(searchCourse + " is a valid course."); found = true; }
        if (!found) System.out.println(searchCourse + " is not a valid course.");

        searchCourse = 67;

        found = false;
        for (int course : updatedCourses) if (course == searchCourse) { System.out.println(searchCourse + " is a valid course."); found = true; }
        if (!found) System.out.println(searchCourse + " is not a valid course.");
    }
}
