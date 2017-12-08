package entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * This class is an entity (just user, don't worry) and it's necessary for further use as an entity.
 *
 * @author Rayla Martin
 * @version 0.1
 * @since 0.1
 */
@Entity
@Table(name = "users")
public class Users {

    /**
     * This field contains user identifier from the database
     */
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private BigDecimal userId;

    /**
     * This field contains user's name in system (username)
     */
    @Column(name = "username")
    private String username;

    /**
     * This field contains user's password
     */
    @Column(name = "password")
    private String password;

    /**
     * This field contains user's unique invite code
     */
    @Column(name = "invite_code")
    private BigDecimal inviteCode;


    /**
     * Function to get the value of the field {@link Users#userId}
     *
     * @return a BigDecimal contains value for representation user's id number.
     * @since 0.1
     */
    public BigDecimal getUserId() {
        return userId;
    }

    /**
     * Procedure for determining the BigDecimal value {@link Users#userId}
     *
     * @param userId - It's just user's personal identifier (in oracle database)
     * @since 0.1
     */
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    /**
     * Function to get the value of the field {@link Users#username}
     *
     * @return a String contains value for representation username.
     * @since 0.1
     */
    public String getUsername() {
        return username;
    }

    /**
     * Procedure for determining the String value {@link Users#username}
     *
     * @param username - It's just username
     * @since 0.1
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Function to get the value of the field {@link Users#password}
     *
     * @return a String contains value for representation user's password
     * @since 0.1
     */
    public String getPassword() {
        return password;
    }

    /**
     * Procedure for determining the String value {@link Users#password}
     *
     * @param password - It's just user's password
     * @since 0.1
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Function to get the value of the field {@link Users#inviteCode}
     *
     * @return a BigDecimal contains value for representation user's unique invite code.
     * @since 0.1
     */
    public BigDecimal getInviteCode() {
        return inviteCode;
    }

    /**
     * Procedure for determining the BigDecimal value {@link Users#inviteCode}
     *
     * @param inviteCode - It's just user's unique invite code
     * @since 0.1
     */
    public void setInviteCode(BigDecimal inviteCode) {
        this.inviteCode = inviteCode;
    }
}
