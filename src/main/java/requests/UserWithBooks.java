package requests;

import java.util.List;

public class UserWithBooks {

        private String userID;

        private List<CollectionOfIsbns> collectionOfIsbns;


    public UserWithBooks(String userId, List<CollectionOfIsbns> isbns){
            this.userID = userId;
            this.collectionOfIsbns = isbns;
        }

        public void setUserId(String userId){
        this.userID = userId;
    }
        public String getUserId(){
        return this.userID;
    }
        public void setCollectionOfIsbns(List<CollectionOfIsbns> collectionOfIsbns){
        this.collectionOfIsbns = collectionOfIsbns;
    }
        public List<CollectionOfIsbns> getCollectionOfIsbns(){
        return this.collectionOfIsbns;
    }
}

