package ainor.com.my.downloadwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    // a way the code run in different thread
    // <1st, 2nd, 3rd>
    // 1st is type of variable that will send to DownloadTask (the string of URL)
    // 2nd a method may or may not use to show the progress of this task
    // 3rd type of variable that will return by DownloadTask class

    public class DownloadTask extends AsyncTask<String,Void, String> {


        @Override
        protected String doInBackground(String... strings) {

            Log.i("URL", strings[0]);
            return "Done";
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        String result = null;
        try {
            result = task.execute("http://www.ainor.com.my/", "https://www.instagram.com/ainorsyahrizal/").get();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } catch (ExecutionException e) {

            e.printStackTrace();
        }

        Log.i("Result", result);
    }
}
