package requests;

import java.util.List;

public class CollectionOfIsbns
{
    private List<String> isbn;

    public void setIsbn(List<String> isbn){
        this.isbn = isbn;
    }
    public List<String> getIsbn(){
        return this.isbn;
    }
}
