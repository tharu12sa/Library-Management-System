package contollers.login;

public class LoginContoller {
    public static boolean cheakUserNameAndPassword(String UserName, String Password) {
        if (UserName.equals("saman") && Password.equals("saman12")){
            return true;
        }
    return false;
    }
}
