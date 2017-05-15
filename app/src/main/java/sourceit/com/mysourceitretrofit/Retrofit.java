package sourceit.com.mysourceitretrofit;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by Lenovo on 13.05.2017.
 */

public class Retrofit {

    private static final String ENDPOINT = "http://restcountries.eu/rest";
    private static ApiInterface apiInterface;

    static {
        initialize();
    }

    interface ApiInterface {
        @GET("/v1/all")
        void getCountries(Callback<List<Country>> callback);
    }

    private static void initialize() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiInterface = restAdapter.create(ApiInterface.class);
    }

    public static void getCountries(Callback<List<Country>> callback) {
        apiInterface.getCountries(callback);
    }

}
