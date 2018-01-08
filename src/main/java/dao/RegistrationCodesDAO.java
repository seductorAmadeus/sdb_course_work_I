package dao;

import entities.RegistrationCodes;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.math.BigDecimal;

public interface RegistrationCodesDAO extends GenericDAO<RegistrationCodes, BigDecimal> {

    RegistrationCodes getAvailableCode();

    default void update(RegistrationCodes transientObject) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // TODO: check this method!
            session.saveOrUpdate(transientObject);
            transaction.commit();
        } catch (HibernateException exp) {
            if (transaction != null) {
                transaction.rollback();
                exp.printStackTrace();
            }
        }
    }
}
