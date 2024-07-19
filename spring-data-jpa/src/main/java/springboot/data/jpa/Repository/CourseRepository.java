package springboot.data.jpa.Repository;

import springboot.data.jpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    //custom method for sorting
    //so whatever page request I pass over here I would be getting data as a page request over here
    Page<Course>findByTitleContaining(String title, Pageable pageable);
}
