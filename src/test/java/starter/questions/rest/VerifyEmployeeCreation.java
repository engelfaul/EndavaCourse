package starter.questions.rest;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static starter.utils.rest.RestUtils.convertJsonMap;

public class VerifyEmployeeCreation {

    public static Question<Integer> responseCodeOfService(){
        return actor -> lastResponse().statusCode();
    }

    public static Question<String> nameEmployeeCreated(){
        String test = lastResponse().getBody().prettyPrint();

        return actor -> lastResponse().jsonPath().getString("name");
    }

}
