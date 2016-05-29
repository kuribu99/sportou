package sports2u.com.sportou;

/**
 * Created by Kong My on 28/5/2016.
 */
public class DataController {

    private static DataController instance;

    public static DataController getInstance() {
        if(instance == null)
            instance = new DataController();
        return instance;
    }

    public DataController() {
        isLoggedIn = false;
    }

    private boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoginStatus(boolean status) {
        isLoggedIn = status;
    }
}
