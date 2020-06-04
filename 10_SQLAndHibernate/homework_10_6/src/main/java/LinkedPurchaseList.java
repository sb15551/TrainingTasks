import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListPK id;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(LinkedPurchaseListPK id) {
        this.id = id;
    }

    public LinkedPurchaseListPK getId() {
        return id;
    }

    public void setId(LinkedPurchaseListPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseList that = (LinkedPurchaseList) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
