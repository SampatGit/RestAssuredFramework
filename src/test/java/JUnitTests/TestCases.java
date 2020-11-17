package JUnitTests;


import apiEngine.DataReaderWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import rest.methods.GetMethods;
import rest.methods.PostMethods;

public class TestCases extends DataReaderWriter {

    PostMethods postMethods = new PostMethods();
    String isbn = "9781491950296";
    GetMethods getMethods = new GetMethods();


    public void testCaseTwo() throws JsonProcessingException {
       Response response = postMethods.postUserDetails("Sampat35", "Sampat@1236");
       response.prettyPrint();


    }

    public void testCaseThree(){
        readUserIdAndIsbn("a5d92448-5c8f-4f72-921a-5d9623bd64d5");
    }

    @Test
    public void testCaseFour(){
        Assert.assertEquals("Programming JavaScript Applications", getMethods.getTitleOfBook("9781491950296"));
    }

}
