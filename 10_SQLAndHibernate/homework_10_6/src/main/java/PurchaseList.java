import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
@IdClass(PurchaseListPK.class)
public class PurchaseList {

    @Id
    @Column(name = "student_name")
    private String student;

    @Id
    @Column(name = "course_name")
    private String course;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return String.format("|\t%s\t|\t%s\t|\t%-15s\t|", student, course, subscriptionDate);

    }
}
