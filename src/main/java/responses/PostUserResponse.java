package responses;

import java.util.List;


public class PostUserResponse
{
    public String userID;

    private String username;

    private List<PostUserResponseBooks> books;

    public void setUserId(String userId){
        this.userID = userId;
    }
    public String getUserId(){
        return this.userID;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setBooks(List<PostUserResponseBooks> books){
        this.books = books;
    }
    public List<PostUserResponseBooks> getBooks(){
        return this.books;
    }
}
