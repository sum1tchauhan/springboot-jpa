package springboot.data.jpa.Repository;

import springboot.data.jpa.entity.Course;
import springboot.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course course= Course.builder().title("DBA").credit(5).build();
        Course course1=Course.builder().title("Java").credit(6).build();
        Teacher teacher= Teacher.builder().firstName("Qutub").
                lastName("Khan")
                //courses(List.of(course,course1))
        .build();
        teacherRepository.save(teacher);
    }
}