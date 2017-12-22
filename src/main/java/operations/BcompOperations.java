package operations;

import daos.BcompDAO;
import daos.UserSessionDAO;
import entities.Bcomp;
import entities.UserSession;
import utils.DataReader;

import java.math.BigDecimal;

public class BcompOperations {

    public void createEmptyBcomp() {
        Bcomp bcomp = new Bcomp();
        BcompDAO bcompDAO = new BcompDAO();
        UserSessionDAO userSessionDAO = new UserSessionDAO();
        UserSession userSession = null;

        BigDecimal userSessionId = DataReader.readUserSessionId();
        try {
            // checking that session exists
            userSession = userSessionDAO.getUserSessionById(userSessionId);
            if (userSession == null) {
                throw new NullPointerException();
            }
            bcomp.setSessionId(userSession);
            bcompDAO.createEmptyBcomp(bcomp);
        } catch (NullPointerException exp) {
            System.out.println("The specified session was not created in the system. Check it out correctly and try again");
        }

    }

}