package bharat.com.stackoverflow;

public class ApiUtils {

    public static final String BASE_URL = "https://stackoverflow.com/oauth";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
