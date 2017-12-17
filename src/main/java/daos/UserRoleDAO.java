package daos;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.math.BigDecimal;

public class UserRoleDAO {

    public BigDecimal addRootRole() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BigDecimal bigDecimal = null;
        try {
            transaction = session.beginTransaction();
            bigDecimal = (BigDecimal) session.createSQLQuery("SELECT USER_ROLE.USER_ROLE_ID FROM USER_ROLE \n" +
                    "WHERE USER_ROLE.TYPE = USER_T( :root, :admin, :teacher, :stud)")
                    .setParameter("root", "yes")
                    .setParameter("admin", "no")
                    .setParameter("teacher", "no")
                    .setParameter("stud", "no")
                    .setMaxResults(1).uniqueResult();
            transaction.commit();
        } catch (HibernateException exp) {
            if (transaction != null) {
                transaction.rollback();
                exp.printStackTrace();
            }
        } finally {
            session.close();
        }
        return bigDecimal;
    }

    public BigDecimal addAdminRole() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BigDecimal bigDecimal = null;
        try {
            transaction = session.beginTransaction();
            bigDecimal = (BigDecimal) session.createSQLQuery("SELECT USER_ROLE.USER_ROLE_ID FROM USER_ROLE \n" +
                    "WHERE USER_ROLE.TYPE = USER_T( :root, :admin, :teacher, :stud)")
                    .setParameter("root", "no")
                    .setParameter("admin", "yes")
                    .setParameter("teacher", "no")
                    .setParameter("stud", "no").setMaxResults(1).uniqueResult();
            transaction.commit();
        } catch (HibernateException exp) {
            if (transaction != null) {
                transaction.rollback();
                exp.printStackTrace();
            }
        } finally {
            session.close();
        }
        return bigDecimal;
    }

    public BigDecimal addTeacherRole() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BigDecimal bigDecimal = null;
        try {
            transaction = session.beginTransaction();
            bigDecimal = (BigDecimal)
                    session.createSQLQuery("SELECT USER_ROLE.USER_ROLE_ID FROM USER_ROLE \n" +
                            "WHERE USER_ROLE.TYPE = USER_T( :root, :admin, :teacher, :stud)")
                            .setParameter("root", "no")
                            .setParameter("admin", "no")
                            .setParameter("teacher", "yes")
                            .setParameter("stud", "no")
                            .setMaxResults(1).uniqueResult();
            transaction.commit();
        } catch (HibernateException exp) {
            if (transaction != null) {
                transaction.rollback();
                exp.printStackTrace();
            }
        } finally {
            session.close();
        }
        return bigDecimal;
    }

    public BigDecimal addStudRole() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BigDecimal bigDecimal = null;
        try {
            transaction = session.beginTransaction();
            bigDecimal = (BigDecimal) session.createSQLQuery("SELECT USER_ROLE.USER_ROLE_ID FROM USER_ROLE \n" +
                    "WHERE USER_ROLE.TYPE = USER_T( :root, :admin, :teacher, :stud)")
                    .setParameter("root", "no")
                    .setParameter("admin", "no")
                    .setParameter("teacher", "no")
                    .setParameter("stud", "yes").setMaxResults(1).uniqueResult();
            transaction.commit();
        } catch (HibernateException exp) {
            if (transaction != null) {
                transaction.rollback();
                exp.printStackTrace();
            }
        } finally {
            session.close();
        }
        return bigDecimal;
    }

    public void generateAllUsersRoles() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("INSERT INTO USER_ROLE (TYPE) values(USER_T('yes','no','no','no'))");
            query.executeUpdate();
            Query query2 = session.createSQLQuery("INSERT INTO USER_ROLE (TYPE) values(USER_T('no','yes','no','no'))");
            query2.executeUpdate();
            Query query3 = session.createSQLQuery("INSERT INTO USER_ROLE (TYPE) values(USER_T('no','no','yes','no'))");
            query3.executeUpdate();
            Query query4 = session.createSQLQuery("INSERT INTO USER_ROLE (TYPE) values(USER_T('no','no','no','yes'))");
            query4.executeUpdate();
            transaction.commit();
        } catch (HibernateException exp) {
            if (transaction != null) {
                transaction.rollback();
                exp.printStackTrace();
            }
        } finally {
            session.close();
        }
    }
}
