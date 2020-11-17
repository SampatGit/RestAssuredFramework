package responses;

public class PostUserResponseBooks
{
    private String isbn;

    private String title;

    private String subTitle;

    private String author;

    private String publish_date;

    private String publisher;

    private int pages;

    private String description;

    private String website;

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setSubTitle(String subTitle){
        this.subTitle = subTitle;
    }
    public String getSubTitle(){
        return this.subTitle;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setPublish_date(String publish_date){
        this.publish_date = publish_date;
    }
    public String getPublish_date(){
        return this.publish_date;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public void setPages(int pages){
        this.pages = pages;
    }
    public int getPages(){
        return this.pages;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setWebsite(String website){
        this.website = website;
    }
    public String getWebsite(){
        return this.website;
    }
}