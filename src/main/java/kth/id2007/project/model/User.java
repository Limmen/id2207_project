package kth.id2007.project.model;

/**
 * Class representing a user of the system, i.e an employee of SEP
 *
 * Created by kim on 2016-10-05.
 */
public class User {

    private String username;
    private String password;
    private String role;
    private String team;

    /**
     * Class constructor
     *
     * @param username username of the user
     * @param password password of the user
     * @param role role of the user
     * @param team team of the user
     */
    public User(String username, String password, String role, String team) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.team = team;
    }

    /**
     * getPassword
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Updates the password of the user.
     *
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getUsername
     *
     * @return username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Updates the username of the user.
     *
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getRole
     *
     * @return role of the user
     */
    public String getRole() {
        return role;
    }

    /**
     * Updates the role of the user.
     *
     * @param role new role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * getTeam
     *
     * @return team of the user
     */
    public String getTeam() {
        return team;
    }

    /**
     * Updates the team of the user
     *
     * @param team new team
     */
    public void setTeam(String team) {
        this.team = team;
    }
}
