package newton.mathmania.models;

public class userLogin{
    public userLogin(){}

    @Override
    public String toString() {
        return (this.getUserName()+
        this.getUserName());}

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String password;
    public userLogin(String userName,String password){
        this.userName = userName;
        this.password = password;
    }
}