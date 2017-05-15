package sourceit.com.mysourceitretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);


        Retrofit.getCountries(new Callback<List<Country>>() {
            @Override
            public void success(List<Country> countries, Response response) {
                Toast.makeText(getApplicationContext(), countries.get(0).name, Toast.LENGTH_SHORT).show();
                tv.setText(countries.get(236).name);
            }

            @Override
            public void failure(RetrofitError error) {
                if(error.getKind() == RetrofitError.Kind.HTTP){
                    Toast.makeText(getApplicationContext(), "HTTP error", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
