package springboot.data.jpa.Repository;

import springboot.data.jpa.entity.Course;
import springboot.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;
    @Test
    public void SaveCourseMaterial(){
        Course course= Course.builder().title(".net").credit(5).build();
        CourseMaterial courseMaterial= CourseMaterial.builder().
                url("www.dailycodebuffer.com").course(course)
                .build();
        repository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=repository.findAll();
        System.out.println(courseMaterials);
    }
}