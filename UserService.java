package bharat.com.stackoverflow;

import bharat.com.stackoverflow.ResObj;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("login/{client_id}/{Scope}/{redirect_uri}")
    Call login(@Path("username") String client_id, @Path("password") String Scope, @Path("redirect_uri") String redirect_uri);
}