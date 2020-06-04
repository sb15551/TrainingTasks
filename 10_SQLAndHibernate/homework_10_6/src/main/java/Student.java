import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private java.lang.String name;

    private int age;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "Subscriptions",
//            joinColumns = {@JoinColumn(name = "student_id")},
//            inverseJoinColumns = {@JoinColumn(name = "course_id")})
//    private List<Course> courses;

    public int getId() {
        return id;
    }

    public java.lang.String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }

    @Override
    public java.lang.String toString() {
        return java.lang.String.format("|\t%s\t|\t%-30s\t|\t%s\t|\t%-20s\t|", id, name, age, registrationDate);
    }

}
