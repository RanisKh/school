package sky.pro.school.service;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import sky.pro.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private long count = 0;

    public Student addStudent(Student student){
        student.setId(count++);
        students.put(student.getId(),student);
        return student;
    }

    public Student findStudent(Long id){
        return students.get(id);
    }

    public Student editStudent (Student student){
        if (!students.containsKey(student.getId())){
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id){
        return students.remove(id);
    }

    public @Nullable Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()){
            if (student.getAge() == age){
                result.add(student);
            }
        }
        return result;
    }
}
