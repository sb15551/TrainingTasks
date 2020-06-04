import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable {

    @EmbeddedId
    private SubscriptionPK id;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public SubscriptionPK getId() {
        return id;
    }

    public void setId(SubscriptionPK id) {
        this.id = id;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return String.format("|\t%s\t|\t%s\t|\t%-15s\t|", id.getStudent().getName(), id.getCourse().getName(), subscriptionDate);
    }
}
