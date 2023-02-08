package starter.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LoginUI {

    public static final By USER_NAME = By.id("user-name");
    public static final By USER_PASSWORD = By.id("password");
    //public static final Target LOGIN_BUTTON = Target.the("Login button").located(By.id("login-button"));
    public static final Target LOGIN_BUTTON = Target.the("Login button").located(By.id("login-button"));

}
