package operations;

import utils.MenuInputType;

import java.util.Scanner;

public class HibernateOperationsManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getMenu());

        RegistrationCodesOperations registrationCodesOperations = new RegistrationCodesOperations();
        UsersOperations usersOperations = new UsersOperations();
        UserRoleOperations userRoleOperations = new UserRoleOperations();
        UserStudyingOperations userStudyingOperations = new UserStudyingOperations();
        UserSessionOperations userSessionOperations = new UserSessionOperations();
        BcompOperations bcompOperations = new BcompOperations();
        BcompSettingsOperations bcompSettingsOperations = new BcompSettingsOperations();
        SessionSettingsOperations sessionSettingsOperations = new SessionSettingsOperations();

        int menuNumber = Integer.parseInt(scanner.nextLine());

        switch (menuNumber) {
            case 1:
                registrationCodesOperations.addNewRegistrationCode();
                break;
            case 2:
                registrationCodesOperations.printAllRegistrationCodes();
                break;
            case 3:
                registrationCodesOperations.updateRegistrationCodeStatus();
                break;
            case 4:
                registrationCodesOperations.deleteRegistrationCode();
                break;
            case 5:
                usersOperations.addUser();
                break;
            case 6:
                usersOperations.deleteUser();
                break;
            case 7:
                userRoleOperations.generateAllUsersRoles();
                break;
            case 8:
                userStudyingOperations.createNewUserGroup();
                break;
            case 9:
                userSessionOperations.createUserSession();
                break;
            case 10:
                bcompOperations.createEmptyBcomp();
                break;
            case 11:
                bcompSettingsOperations.createBcompSettings();
                break;
            case 12:
                sessionSettingsOperations.assignUserSettings();
            default:
                break;
        }
    }

    private static String getMenu() {
        return new StringBuilder(MenuInputType.ENTER_REGISTRATION_CODES.toString())
                .append(MenuInputType.PRINT_REGISTRATION_CODES)
                .append(MenuInputType.UPDATE_REGISTRATION_CODES)
                .append(MenuInputType.DELETE_REGISTRATION_CODES)
                .append(MenuInputType.ENTER_USERS)
                .append(MenuInputType.DELETE_USERS)
                .append(MenuInputType.GENERATE_USER_ROLE)
                .append(MenuInputType.ENTER_USER_GROUP)
                .append(MenuInputType.CREATE_USER_SESSION)
                .append(MenuInputType.CREATE_BCOMP)
                .append(MenuInputType.CREATE_BCOMP_SETTINGS)
                .append(MenuInputType.ASSING_USER_SETTINGS)
                .toString();
    }

}
