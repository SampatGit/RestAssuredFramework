package rest.methods;

import apiEngine.DataReaderWriter;
import apiEngine.EndPoints;
import io.restassured.response.Response;
import org.junit.Assert;

public class GetMethods {

    PostMethods postMethods = new PostMethods();
    DataReaderWriter dataWriterReader = new DataReaderWriter();
    EndPoints endPoints = new EndPoints();
    Response response;

    /***
     * This method will 1. Get the User Name, password and Post it in API, validate the response code 201
     *                  2. Post the User and password to generate token
     *                  3. Write the User and Token value in a spreadsheet
     * @param user
     * @param password
     */
    public void getTokenandWriteInExcel(String user, String password) {
        response = postMethods.postUserDetails(user, password);
        Assert.assertEquals(response.getStatusCode(), 201);
        String token = postMethods.getTokenAndStore();
        dataWriterReader.writeTokeIntoExcel(user, token);

    }

    public String getTitleOfBook(String bookIsbn){
         response = endPoints.getBookTitle(bookIsbn);
         String title = response.jsonPath().get("title");
         return title;
    }

}
