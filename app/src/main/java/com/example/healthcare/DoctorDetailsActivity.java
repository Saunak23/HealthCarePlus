package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Rohan Biswal", "Hospital Address:Bhubaneswar", "Exp: 10yrs", "Mobile No. 9956785465", "₹1000"},
                    {"Doctor Name : Rohit Tawde", "Hospital Address:Mumbai", "Exp: 15yrs", "Mobile No. 9656785565", "₹1500"},
                    {"Doctor Name : Sourav Bose", "Hospital Address:Kolkata", "Exp: 6yrs", "Mobile No. 9959785105", "₹500"},
                    {"Doctor Name : Yash Teja", "Hospital Address:Bangalore", "Exp: 2yrs", "Mobile No. 9456735460", "₹200"},
                    {"Doctor Name : Mohit Talpade", "Hospital Address:Pune", "Exp: 27yrs", "Mobile No. 9906785185", "₹3000"}

            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dinesh Mishra", "Hospital Address:Bhubaneswar", "Exp: 10yrs", "Mobile No. 9956785465", "₹1000"},
                    {"Doctor Name : Mohit Tawde", "Hospital Address:Mumbai", "Exp: 15yrs", "Mobile No. 9656785565", "₹1500"},
                    {"Doctor Name : Sourav Ghosh", "Hospital Address:Kolkata", "Exp: 6yrs", "Mobile No. 9959785105", "₹500"},
                    {"Doctor Name : Rohit Kartikey", "Hospital Address:Bangalore", "Exp: 2yrs", "Mobile No. 9456735460", "₹200"},
                    {"Doctor Name : Ram Talpade", "Hospital Address:Pune", "Exp: 27yrs", "Mobile No. 9906785185", "₹3000"}

            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Arpit Dash", "Hospital Address:Bhubaneswar", "Exp: 10yrs", "Mobile No. 9956785465", "₹1000"},
                    {"Doctor Name : Rohit Kale", "Hospital Address:Mumbai", "Exp: 15yrs", "Mobile No. 9656785565", "₹1500"},
                    {"Doctor Name : Mohan Chatterjee", "Hospital Address:Kolkata", "Exp: 6yrs", "Mobile No. 9959785105", "₹500"},
                    {"Doctor Name : Yash Narayan", "Hospital Address:Bangalore", "Exp: 2yrs", "Mobile No. 9456735460", "₹200"},
                    {"Doctor Name : Mahesh Tawde", "Hospital Address:Pune", "Exp: 27yrs", "Mobile No. 9906785185", "₹3000"}

            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Deep Mohapatra", "Hospital Address:Bhubaneswar", "Exp: 10yrs", "Mobile No. 9956785465", "₹1000"},
                    {"Doctor Name : Rakesh Tawde", "Hospital Address:Mumbai", "Exp: 15yrs", "Mobile No. 9656785565", "₹1500"},
                    {"Doctor Name : Vikrant Bose", "Hospital Address:Kolkata", "Exp: 6yrs", "Mobile No. 9959785105", "₹500"},
                    {"Doctor Name : Dinesh Teja", "Hospital Address:Bangalore", "Exp: 2yrs", "Mobile No. 9456735460", "₹200"},
                    {"Doctor Name : Mohit Jain", "Hospital Address:Pune", "Exp: 27yrs", "Mobile No. 9906785185", "₹3000"}

            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Sarthak Panda", "Hospital Address:Bhubaneswar", "Exp: 10yrs", "Mobile No. 9956785465", "₹1000"},
                    {"Doctor Name : Udit Tawde", "Hospital Address:Mumbai", "Exp: 15yrs", "Mobile No. 9656785565", "₹1500"},
                    {"Doctor Name : Rahul Bose", "Hospital Address:Kolkata", "Exp: 6yrs", "Mobile No. 9959785105", "₹500"},
                    {"Doctor Name : Vikash Teja", "Hospital Address:Bangalore", "Exp: 2yrs", "Mobile No. 9456735460", "₹200"},
                    {"Doctor Name : Vicky Jain", "Hospital Address:Pune", "Exp: 27yrs", "Mobile No. 9906785185", "₹3000"}

            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textView_logo6);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Neurologists")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Cardiologists")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentists")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}