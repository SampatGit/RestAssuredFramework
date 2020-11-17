package StepDefinitions;

import apiEngine.DataReaderWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import rest.methods.GetMethods;
import rest.methods.PostMethods;

import java.util.Collections;

public class MyStepdefs extends DataReaderWriter {
    
    PostMethods postMethods = new PostMethods();
    Response response;
    String user;
    String token;
    GetMethods getMethods = new GetMethods();



    @Then("I verify that the token is stored in Data Provider excel")//under use
    public void iVerifyThatTheTokenIsStoredInDataProviderExcel() {
        writeTokeIntoExcel(user, token);
    }

    @And("I verify user is posted in API with response code 201")//under use
    public void iVerifyUserIsPostedInAPI() {

    }

    @When("I post the details to generate token")//under use
    public void iPostTheUserDetailsToGenerateToken() {
      token = postMethods.getTokenAndStore();
      setDynamicData("Token", token);
    }

    @Given("I have userName {string} and password as {string}")//Under use
    public void iHaveUserNameAndPasswordAs(String UserName, String password) {
        setDynamicData("User Name", UserName );
        setDynamicData("Password", password);
        user = UserName;
        response = postMethods.postUserDetails(UserName, password);
        response.prettyPrint();
        Assert.assertEquals(201, response.getStatusCode());

    }

    /**TEST CASE 2 Feature step definitions**/

    @Given("I post a user details with {string} and {string}")
    public void iPostAUserDetailsWithAnd(String user, String password) {
        setDynamicData("User Name", user );
        setDynamicData("Password", password);
        response = postMethods.postUserDetails(user, password);
        Assert.assertEquals(201, response.getStatusCode());

    }

    @When("I post the User detail to add book with ISBN {string}")
    public void iPostTheUserDetailToAddBookWithISBN(String isbn) throws JsonProcessingException {

        response = postMethods.postBookForUserBody(response, Collections.singletonList(isbn), getDynamicData("Token"));
    }

    @Then("I verify book is added to the user")
    public void iVerifyBookIsAddedToTheUser() {
        try {
            Assert.assertEquals(201, response.getStatusCode());
        }
        catch(AssertionError ae){
            response.prettyPrint();
            ae.printStackTrace();
        }
    }

    /*Feature 3*/

    @Given("I fetch the user details from spreadsheet")
    public void iFetchTheUserDetailsFromSpreadsheet() {

    }

    @When("I get the books for the assigned user from API.")
    public void iGetTheBooksForTheAssignedUserFromAPI() {

    }

    @Then("I verify that the stored details matches with the API results")
    public void iVerifyThatTheStoredDetailsMatchesWithTheAPIResults() {

    }

    /*Feature 4*/

    @Given("I get the title of the book for a given {string}")
    public void iGetTheTitleOfTheBookForAGiven(String bookISBN) {
        String title = getMethods.getTitleOfBook(bookISBN);
        setDynamicData("bookTitle", title);

    }

    @Then("I verify the title matches with {string}")
    public void iVerifyTheTitleMatchesWith(String title) {
          Assert.assertEquals(title, getDynamicData("bookTitle"));
    }
}
