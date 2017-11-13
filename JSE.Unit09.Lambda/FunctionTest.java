/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author PA
 */
public class FunctionTest {
    public static void main(String[] args) {
//        List<Student> students = new ArrayList<Student> ();
//        
//        Consumer<Student> c = (Student student) -> {
//            if(student.getAge() > 23) student.setAge(23);
//            students.add(student);
//        };
//        c.accept(new Student("Nguyen", 34));
//        
//        System.out.print(students.get(0));

        String names[] = {"A", "B", "C", "D"};
        Integer ages[] = {23, 45, 12, 67};
        IntStream intStream = IntStream.rangeClosed(0, names.length - 1);
        Stream<Student> stream = intStream.mapToObj(value -> new Student(names[value], ages[value]));
        
        Consumer<Student> c = System.out::println;
        //stream.forEach(c);
        
        Function<Student, String> jsonToFunction = (Student student) -> {
            StringBuilder builder = new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid:").append(student.getId()).append("\n");
            builder.append("\tname:").append(student.getName()).append("\n");
            builder.append("\tage:").append(student.getAge()).append("\n");
            builder.append("}");
            
            return builder.toString();
        };
//        
        c = (Student student) -> {System.out.println(jsonToFunction.apply(student));};
//        stream.forEach(c);

        Predicate<Student> predicate = (Student student) -> {return student.getAge() >30;};
        Stream<Student> older = stream.filter(predicate);
        older.forEach(c);
        
        Supplier<Student> supplier = () -> {return new Student("Tran Thi A", 27);};
        //System.out.println(jsonToFunction.apply(supplier.get()));
    }
}
