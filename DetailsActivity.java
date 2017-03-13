package helloworld.advprog.mmu.ac.uk.advancedprogramming2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // get the intent
        Bundle extras = getIntent().getExtras();
        // create a cheese object from the cheese object that was passed over from // the MainActivity. Notice you use the key ('cheese') to retrieve the value/variable needed.
        Employee theEmp = (Employee) extras.get("emp");
        System.out.println("received from the intent: "+ theEmp.getName());
        TextView t = (TextView)findViewById(R.id.titleTextView);
        TextView t2 = (TextView)findViewById(R.id.descTextView);
        t.setText(theEmp.getName());
        t2.setText("ID: " + theEmp.getId() + "\nGender: " + theEmp.getGender() + "\nDOB: " + theEmp.getDob() + "\nAddress: " + theEmp.getAddress() +  "\nSalary: £" + theEmp.getSalary());
    }
}
