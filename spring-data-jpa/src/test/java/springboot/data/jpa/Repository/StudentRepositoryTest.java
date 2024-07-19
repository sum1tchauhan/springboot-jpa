package springboot.data.jpa.Repository;

import springboot.data.jpa.entity.Guardian;
import springboot.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

            @Test
    public void saveStudent(){
                Student student=Student.builder().emailId("shabbir@gmail.com").
                        firstName("Shabbir").lastName("Dawoodi").
                       // guardianName("Arun").
                        //guardianEmail("sumit@gmail.com").
                        //guardianMobile("9999999999").
                         build();
                studentRepository.save(student);
            }
            @Test
            public void saveStudentWithGuardian(){
                Guardian guardian=Guardian.builder().email("nikhil@gmail.com").name("Nikhil").
                        mobile("9999999999").build();

                Student student=Student.builder().firstName("shivam").
                        emailId("shivam@gmail.com").lastName("Kumar").guardian(guardian).build();
                studentRepository.save(student);
            }
            @Test
    public void printAllStudent(){
                List<Student> studentList=studentRepository.findAll();
                System.out.println("studentList="+studentList);
            }
            @Test
            public void printStudentByFirstName(){
                studentRepository.findByFirstName("shivam");
            }
            @Test
            public void printStudentByFirstNameContaining(){
                List<Student> studentList=studentRepository.findByFirstNameContaining("sh");
                System.out.println(studentList);
            }
            @Test
            public void printStudentBasedOnGuardianName(){
                List<Student> students=studentRepository.findByGuardianName("Nikhil");
                System.out.println(students);
            }
            @Test
        public void printgetStudentByEmailAddress(){
                Student student=studentRepository.getStudentByEmailAddress("shabbir@gmail.com");
                System.out.println(student);
            }
            @Test
    public void getStudentByFirstName(){
                String student=studentRepository.getStudentByFirstName("shabbir@gmail.com");
                System.out.println(student);
            }
            @Test
    public void getStudentByEmailIdAddressNative(){
                Student student=studentRepository.getStudentByEmailIdAddressNative("shabbir@gmail.com");
                System.out.println(student);
            }
            @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
                Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("shabbir@gmail.com");
                System.out.println(student);
            }
            @Test
    public void updateStudentNameByEmailIdTest(){
                studentRepository.updateStudentNameByEmailId("sumit","shabbir@gmail.com");
            }
}