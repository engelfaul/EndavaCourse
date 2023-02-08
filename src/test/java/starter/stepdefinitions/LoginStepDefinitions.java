package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.navigation.NavigateTo;
import starter.questions.OnThePrincipalPage;
import starter.questions.SwagLabsStoreQuestions;
import starter.tasks.DoLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinitions {

    @Given("{actor} is a {}")
    public void userNavigatesToHomePage(Actor actor, String customerType) {
        actor.wasAbleTo(NavigateTo.theSauceHomePage());

    }

    @When("{actor} tries to login")
    public void userTriesToLogin (Actor actor){
        actor.attemptsTo(
                DoLogin.withCredentials("standard_user",
                        "secret_sauce")
        );
    }

    @When("{actor} tries to login with user name {} and password {}")
    public void userTriesToLoginWithCredentials (Actor actor, String userName, String pasword){
        actor.attemptsTo(
                DoLogin.withCredentials(userName, pasword)
        );
    }


    @Then("{actor} should see to products list")
    public void userShouldSeeToProductsList(Actor actor) {
       actor.should(
               seeThat("the display title",
                       OnThePrincipalPage.theTitleIs(), equalTo("PRODUCTS")
               )
       );

       theActorInTheSpotlight().should(
               seeThat(
                       "the display title", SwagLabsStoreQuestions.productsAvailable(), equalTo("PRODUCTS")
               )
       );

    }


    @When("{actor} tries to log out")
    public void heTriesToLogOut(Actor actor) {
        userTriesToLogin(actor);
        actor.attemptsTo(
                DoLogin.logOut()
        );
    }

    @Then("{actor} should see the log in page")
    public void heShouldSeeTheLogInPage(Actor actor) {
        actor.should(
                seeThat("The login page",
                        SwagLabsStoreQuestions.successLogOut(), equalTo(true)
                )
        );
    }
}
