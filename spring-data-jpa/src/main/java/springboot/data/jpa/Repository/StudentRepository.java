package springboot.data.jpa.Repository;

import springboot.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student>findByFirstName(String firstName);
    List<Student>findByFirstNameContaining(String firstName);
    List<Student>findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName,String lastName);
    //JPQL
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL first name only
    @Query("select s.firstName from Student s where s.emailId= ?1")
    String getStudentByFirstName(String emailId);

    //Native query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address= ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdAddressNative(String emailId);

    //Native named param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    //method to update the record
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name= ?1 where email_address= ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);
}
