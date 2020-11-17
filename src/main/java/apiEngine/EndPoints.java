package apiEngine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requests.GenerateToken;
import requests.PostBody;
import requests.UserWithBooks;
import responses.GenerateTokenResponse;

public class EndPoints {

    private static final String BASE_URL = "https://bookstore.toolsqa.com";
    public Response response;
    GenerateTokenResponse tokenResponse = new GenerateTokenResponse();
    String token;
    RequestSpecification reqSpec;
    DataReaderWriter dataReaderWriter = new DataReaderWriter();


    public Response postUser(PostBody postUser){
        response = reqSpecGenerate().body(postUser).post(Routes.user());
        return response;
    }

    public RequestSpecification reqSpecGenerate(){
        RestAssured.baseURI = BASE_URL;
        reqSpec = RestAssured.given().relaxedHTTPSValidation();
        reqSpec.header("Content-Type", "application/json");
        return reqSpec;
    }

    public RequestSpecification basicAuth(RequestSpecification reqspec){
        reqSpec.auth().basic("Sampat21", "Sampat@1236").auth().oauth2(dataReaderWriter.getDynamicData("Token"));
        return reqspec;
    }

    public RequestSpecification reqSpecGenerate2(){
        RestAssured.baseURI = BASE_URL;
        reqSpec = RestAssured.given().relaxedHTTPSValidation();
        basicAuth(reqSpec);
        reqSpec.header("Content-Type", "application/json");
        return reqSpec;
    }


    public Response authenticate(GenerateToken tokenRequestBody){
        response =  reqSpecGenerate().body(tokenRequestBody).post(Routes.generateToken());
        return response;

    }



    public Response postBookforUser(UserWithBooks userWithBooks, String token) throws JsonProcessingException {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(userWithBooks);
        response = reqSpecGenerate2().
              header("Authorization", "Bearer " + token)
                                   .body(userWithBooks).post(Routes.books());
       return response;
    }

    public Response getBookTitle(String isbn){
        response = reqSpecGenerate().queryParam("ISBN", isbn).get(Routes.book());
        return response;
    }


}
