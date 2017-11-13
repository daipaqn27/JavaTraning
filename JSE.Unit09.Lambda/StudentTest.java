/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author PA
 */
public class StudentTest {

    public static List<Student> filter(List<Student> students, Filter<Student> filter) {
        List<Student> list = new ArrayList<Student>();
        students.forEach(
                student -> {
                    if (filter.vaild(student)) {
                        list.add(student);
                    }
                });
        return list;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Tran Van A", 23));
        students.add(new Student("Tran Van B", 34));
        students.add(new Student("Tran Van C", 15));
        students.add(new Student("Tran Van D", 46));

//        Filter<Student> older = student -> student.getAge()>=30;
//        filter(students, older).forEach(
//                student -> System.out.println(student)
//        );
//        Stream<Student> stream = students.stream().filter(
//                student-> student.getAge() >= 30
//        );
//        stream.forEach(s -> System.out.println(s));
//        Collections.sort(students, 
//                (Student s1, Student s2) -> s1.getAge() - s2.getAge());
//        students.forEach(s -> System.out.println(s));
//        Stream<Student> stream = students.stream().sorted(
//                (Student s1, Student s2) -> s1.getAge() - s2.getAge()
//        );
//        stream.forEach(System.out::println);

        Comparator<Student> comparator = (Student s1, Student s2) -> s1.getAge() - s2.getAge();
        
        Stream<Student> stream = students.stream().sorted(comparator);
        stream.forEach(s -> System.out.println(s));
        
        System.out.println("Maxis " + students.stream().max(comparator));
        
        int sum = students.stream().mapToInt(Student::getAge).sum();
        System.out.println("Average of age is " + sum/students.size());
        
        students.parallelStream().forEach((it) -> System.out.println(Thread.currentThread().getName() + " Hello" + it.getName()));
    }
}
