package helloworld.advprog.mmu.ac.uk.advancedprogramming2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> empNames = new ArrayList<>(); // the array of employee names to put into the list view
    ArrayList <Employee> allEmps = new ArrayList<Employee>();
    ListView listEmp; // the list view variable

    public class myTask extends AsyncTask<URL,Void,Void> {

        @Override
        protected Void doInBackground(URL... urls) {
            HttpURLConnection urlConnection;
            InputStream in = null;
            try {
                URL url = new URL("http://10.0.2.2:8005/json"); // connect to the json output page
                urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream()); // get the response from the server in an input stream
            } catch (IOException e) {
                e.printStackTrace();
            }
            String response = convertStreamToString(in); // covert the input stream to a string
            System.out.println("Server response = " + response); // print the response to log cat

            try {
                JSONArray jsonArray = new JSONArray(response); // make a json array and put the server response into it
                for (int i = 0; i < jsonArray.length(); i++) { // iterate over all the objects in the array
                    String id = jsonArray.getJSONObject(i).get("id").toString(); // put each part of the json object into local variables
                    String name = jsonArray.getJSONObject(i).get("name").toString();
                    String gender = jsonArray.getJSONObject(i).get("gender").toString();
                    String dob = jsonArray.getJSONObject(i).get("dob").toString();
                    String address = jsonArray.getJSONObject(i).get("address").toString();
                    String postcode = jsonArray.getJSONObject(i).get("postcode").toString();
                    String nin = jsonArray.getJSONObject(i).get("natInscNo").toString();
                    String title = jsonArray.getJSONObject(i).get("title").toString();
                    String start = jsonArray.getJSONObject(i).get("startDate").toString();
                    String salary = jsonArray.getJSONObject(i).get("salary").toString();
                    String email = jsonArray.getJSONObject(i).get("email").toString();

                    Employee e1 = new Employee (id, name, gender, dob, address, postcode, nin, title, start, salary, email); // make an employee object and enter the data in
                    allEmps.add(e1);
                    empNames.add(e1.getName()); // add the name of the employee into empNames to display in the list view
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listEmp = (ListView) findViewById(R.id.empList);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<> (getApplicationContext(), android.R.layout.simple_list_item_1, empNames);  // make a list view of the employee names
            listEmp.setAdapter(arrayAdapter); // put the arrayAdapter onto the list view

            listEmp.setOnItemClickListener(new AdapterView.OnItemClickListener() { @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class); // go to the details activity when a record is selected
                intent.putExtra("emp", allEmps.get(i));
                startActivity(intent);
            }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            URL url1 = new URL("http://10.0.2.2:8005/json"); // declare the url
            new myTask().execute(url1); // start the Async task with the url passed in
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertStreamToString(InputStream is) { // this converts the input stream from the server into a String
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
