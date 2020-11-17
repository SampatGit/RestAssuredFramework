package rest.methods;

import apiEngine.DataReaderWriter;
import apiEngine.EndPoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import requests.CollectionOfIsbns;
import requests.GenerateToken;
import requests.PostBody;
import requests.UserWithBooks;
import responses.GenerateTokenResponse;
import responses.PostUserResponse;

import java.util.ArrayList;
import java.util.List;


public class PostMethods extends DataReaderWriter {


    EndPoints endpoint = new EndPoints();
    Response response;

    public String getTokenAndStore(){
        GenerateToken generateToken = new GenerateToken(getDynamicData("User Name"), getDynamicData("Password"));
        Response response = endpoint.authenticate(generateToken);
        String token = response.getBody().as(GenerateTokenResponse.class).getToken();
        return token;
    }

    public Response postUserDetails(String user, String password){
        PostBody postUser = new PostBody(user, password);
        Response response = endpoint.postUser(postUser);

        return response;
    }
    public Response postBookForUserBody(Response response, List<String> isbn, String token) throws JsonProcessingException {
        Response postresponse;
        String userId = response.getBody().as(PostUserResponse.class).getUserId();
        setDynamicData("User Id", userId);
        setDynamicArrayData("ISBN", isbn);
        List<CollectionOfIsbns> bookIsbns = new ArrayList<>();
        CollectionOfIsbns isbns = new CollectionOfIsbns();
        isbns.setIsbn(isbn);
        bookIsbns.add(isbns);
        UserWithBooks userBookBody = new UserWithBooks(userId, bookIsbns);
        postresponse = endpoint.postBookforUser(userBookBody,
                token);
        writeUserIdandIsbn(userId, isbn);
        return postresponse;
    }



}
