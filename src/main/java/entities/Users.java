package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * This class is an entity (just user, don't worry) and it's necessary for further use as an entity.
 *
 * @author Rayla Martin
 * @version 0.1
 * @since 0.1
 */

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")})
public class Users implements Serializable {

    /**
     * This field contains user identifier from the database
     */
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "user_id", nullable = false, unique = true)
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
     * This field contains entity that represents user's unique invite code
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "reg_code_id")
    private RegistrationCodes registrationCode;

    /**
     * This field contains set of entities that represents user's sessions
     */
    @OneToMany(mappedBy = "userID")
    private Set<UserSession> userSessions;

    /**
     * This field contains entity that represents user's profile
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private UserProfile profile;

    /**
     * Sole constructor.
     * For Hibernate code that creates objects via reflection using Class<T>.newInstance().
     * This method requires a public no-arg constructor to be able to instantiate the object
     */
    public Users() {
    }

    /**
     * Constructor.
     *
     * @param registrationCode (required) {@link RegistrationCodes} entity, that represents invite code
     *                         for particular user
     * @param username         (required) user name in the system
     * @param password         (required) user password in the system
     * @param userSessions     (optional) user sessions in the system
     * @param profile          (required) user profile in the system
     */
    public Users(RegistrationCodes registrationCode, String username, String password, Set<UserSession> userSessions, UserProfile profile) {
        this.registrationCode = registrationCode;
        this.username = username;
        this.password = password;
        this.userSessions = userSessions;
        this.profile = profile;
    }

    /**
     * Function to get the value of the field {@link Users#userId}
     *
     * @return bigDecimal BigDecimal contains value for representation user's id number.
     * @since 0.1
     */
    public BigDecimal getUserId() {
        return userId;
    }

    /**
     * Procedure for determining the BigDecimal value {@link Users#userId}
     *
     * @param userId - It's just user's personal identifier
     * @since 0.1
     */
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    /**
     * Function to get the value of the field {@link Users#username}
     *
     * @return String contains value for representation username.
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
     * @return String contains value for representation user's password
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
     * Function to get the value of the field {@link Users#registrationCode}
     *
     * @return {@link RegistrationCodes} entity contains value for representation user's unique invite code.
     * @see RegistrationCodes
     * @since 0.1
     */
    public RegistrationCodes getRegistrationCode() {
        return registrationCode;
    }

    /**
     * Procedure for determining the RegistrationCodes value {@link Users#registrationCode}
     *
     * @param inviteCode - It's just user's unique invite code
     * @since 0.1
     */
    public void setRegistrationCode(RegistrationCodes inviteCode) {
        this.registrationCode = inviteCode;
    }

    /**
     * Function to get the value of the field {@link Users#userSessions}
     *
     * @return set of user sessions in the system.
     * @see UserSession
     * @since 0.1
     */
    public Set<UserSession> getUserSessions() {
        return userSessions;
    }

    /**
     * Procedure for determining the Set of user sessions {@link Users#userSessions}
     *
     * @param userSession - It's set of user sessions in the system.
     * @since 0.1
     */
    public void setUserSessions(Set<UserSession> userSession) {
        this.userSessions = userSession;
    }

    /**
     * Function to get the value of the field {@link Users#profile}
     *
     * @return user's profile that represents a particular user in the system
     * @see UserProfile
     * @since 0.1
     */
    public UserProfile getProfile() {
        return profile;
    }

    /**
     * Procedure for determining the UserProfile value {@link Users#profile}
     *
     * @param profile - It's user's profile that represents a particular user in the system
     * @since 0.1
     */
    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}
