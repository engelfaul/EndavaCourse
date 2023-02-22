package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;
import starter.models.Employee;
import starter.questions.rest.VerifyEmployeeCreation;
import starter.tasks.rest.CreateEmployee;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static starter.utils.Constants.*;

public class EmployeeStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Given("{actor} hired {} with the {} role")
    public void userHiredNewEmployee(Actor actor, String employeeName, String jobPosition) {
        actor.whoCan(
                CallAnApi.at(environmentVariables.getProperty(BASE_URL))
        );

        actor.remember(EMPLOYEE_NAME, employeeName);
        actor.remember(JOB_POSITION, jobPosition);
    }

    @When("{actor} creates his information in the company")
    public void companyCreatesHisInformationInTheCompany(Actor actor) {
        String employeName = actor.recall(EMPLOYEE_NAME);
        actor.attemptsTo(
                CreateEmployee.inTheApp(
                       Employee.with().name(actor.recall(EMPLOYEE_NAME)
                       ).job(actor.recall(JOB_POSITION)).build()
                )
        );

    }

    @Then("{actor} should be able to see {}'s id")
    public void endavaShouldBeAbleToSeeCarlosSId(Actor actor, String expectedName) {
        actor.should(
                seeThat("response code",
                        VerifyEmployeeCreation.responseCodeOfService(), equalTo(HttpStatus.SC_CREATED)
                ),
                seeThat("user name created",
                        VerifyEmployeeCreation.nameEmployeeCreated(), equalTo(expectedName)
                )
        );
    }
}
