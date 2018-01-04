package operations;

import daos.RegistrationCodesDAO;
import entities.RegistrationCodes;
import utils.DataReader;

import java.math.BigDecimal;
import java.util.List;

public class RegistrationCodesOperations {
    public void addNewRegistrationCode() {
        RegistrationCodesDAO dao = new RegistrationCodesDAO();
        RegistrationCodes registrationCodes = DataReader.readRegistrationCode();
        // TODO: Remove print action!
        System.out.println((dao.create(registrationCodes)));
    }

    public void getRegistrationCode() {

    }

    public void printAllRegistrationCodes() {
        RegistrationCodesDAO dao = new RegistrationCodesDAO();
        List<RegistrationCodes> tempList = dao.getList();
        System.out.println("invite_code" + " " + "invite_code_status" + " " + "email");
        for (RegistrationCodes registrationCodes : tempList) {
            System.out.println(registrationCodes.toString());
        }
    }

    public void updateRegistrationCodeStatus() {
        RegistrationCodesDAO dao = new RegistrationCodesDAO();
        String newInviteCodeStatus = DataReader.readNewStatusForRegistrationCode();
        BigDecimal oldInviteCode = DataReader.readInviteCode();
        RegistrationCodes tempRegistrationCode = new RegistrationCodes();
        tempRegistrationCode.setInviteCode(oldInviteCode);
        tempRegistrationCode.setInviteCodeStatus(newInviteCodeStatus);
        try {
            dao.update(tempRegistrationCode);
        } catch (NullPointerException exp) {
            System.out.println("Invite code not found. Check input and try again");
        }
    }

    public void deleteRegistrationCode() {
        RegistrationCodesDAO dao = new RegistrationCodesDAO();
        BigDecimal inviteCode = DataReader.readInviteCode();
        dao.delete(inviteCode);
    }
}
