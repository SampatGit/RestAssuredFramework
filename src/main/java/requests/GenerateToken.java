package requests;

public class GenerateToken {
        private String userName;
        private String password;


    public GenerateToken(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public GenerateToken() {

    }

        public void setUserName(String userName){
            this.userName = userName;
        }
        public String getUserName(){
            return this.userName;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public String getPassword(){
            return this.password;
        }

}
