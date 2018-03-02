import java.io.IOException;

/**
 * Utility class the handle various tasks for application
 *
 * @author PK
 */
public class MiscUtils {

    private MiscUtils() {
    }

    /**
     * Checks if a user is valid in the administrators.csv file
     *
     * @param username
     * @param password
     * @return true or false
     * @throws IOException
     */
    public static boolean isValidUser(String username, String password) throws IOException {
        String[] users = FileUtils.fileLines("files/administrators.csv");

        for (String user : users) {
            String[] userData = user.split(","); //id, username, password
            if (userData.length == 3) {
                if (userData[1].trim().equals(username) && userData[2].trim().equals(password)) {
                    return true;
                }
            }
        }

        return false;
    }
}
