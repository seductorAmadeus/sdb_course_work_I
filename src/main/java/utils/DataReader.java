package utils;

import entities.RegistrationCodes;
import exceptions.NonComplianceWithConstraints;
import exceptions.PatternException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    // TODO: Move constraints in additional file
    // TODO: Add string size checking
    public static RegistrationCodes readRegistrationCode() {
        RegistrationCodes registrationCodes = new RegistrationCodes();

        System.out.println(MenuInputType.INVITE_CODE_STATUS);

        for (; ; ) {
            try {
                String inviteCodeStatus = scanner.nextLine();
                if (!inviteCodeStatus.equals("available") && !inviteCodeStatus.equals("not available")) {
                    throw new NonComplianceWithConstraints("invite_code_status", "available", "not available");
                }
                registrationCodes.setInviteCodeStatus(inviteCodeStatus);
                break;
            } catch (NonComplianceWithConstraints exp) {
                System.out.println(exp.getMessage());
            }
        }

        System.out.println(MenuInputType.EMAIL);

        for (; ; ) {
            try {
                String email = scanner.nextLine();
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
                if (!matcher.find()) {
                    throw new PatternException("email", VALID_EMAIL_ADDRESS_REGEX);
                }
                registrationCodes.setEmail(email);
                break;
            } catch (PatternException exp) {
                System.out.println(exp.getMessage());
                System.out.println("Повторите ввод: ");
            }
        }

        return registrationCodes;
    }


}
