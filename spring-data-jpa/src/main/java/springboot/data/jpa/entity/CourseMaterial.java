package springboot.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")//to exclude course and to prevent error related to it
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;
    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    optional = false)
    //which particular column does it belong to in course table
    @JoinColumn(
            name = "course_Id",
            referencedColumnName ="courseId"
    )
    private Course course;
}
