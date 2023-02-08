package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import starter.ui.LoginUI;
import starter.ui.SwagLabsStoreUI;

public class SwagLabsStoreQuestions {

    public static Question<String> productsAvailable(){
        return actor -> Text.of(SwagLabsStoreUI.PRODUCTS_TITLE).answeredBy(actor);
    }

    public static Question<Boolean> successLogOut(){
        return actor -> Enabled.of(LoginUI.LOGIN_BUTTON).answeredBy(actor);
    }
}
