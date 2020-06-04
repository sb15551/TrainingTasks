import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.hql.internal.ast.tree.Statement;

import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

//        Student student = session.get(Student.class, 1);
//        Course course = session.get(Course.class, 2);
//        Serializable subscription = session.get(Subscription.class, new SubscriptionPK(student, course));
//        System.out.println(subscription);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Subscription> query = builder.createQuery(Subscription.class);
        Root<Subscription> root = query.from(Subscription.class);
        query.select(root);
        List<Subscription> subscriptionList = session.createQuery(query).getResultList();

        session.beginTransaction();
        session.createQuery("delete from LinkedPurchaseList l").executeUpdate();
        for (Subscription subscription : subscriptionList) {
            int studentId = subscription.getId().getStudent().getId();
            int courseId = subscription.getId().getCourse().getId();
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(new LinkedPurchaseListPK(studentId, courseId));
            session.save(linkedPurchaseList);
        }
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
