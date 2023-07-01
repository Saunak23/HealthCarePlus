package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Uprise-D3 1000 Capsule","","","","350"},
                    {"Crocin 650 Advance Capsule","","","","250"},
                    {"Vitamin B Complex Capsule","","","","448"},
                    {"Inlife Vitamin E Germ Oil Capsules","","","","539"},
                    {"Dolo 650 Capsule","","","","300"}

    };
    private String[] package_details= {
            "Building and Keeping the Bones and Teeth Strong\n" +
                    "Reducing Fatique and muscular pain\n"+
                    "Boosting Immunity and Resistance against Diseases",
            "Helps relieve fever and bringing down temperature\n"+
                    "Suitable for people with heart condition or high BP",
            "Provides relief from Vitamin B deficiencies\n"+
                    "Helps in formation of RBC\n"+
                    "Maintains healthy nervous system",
            "It promotes health and skin benefit.\n"+
                    "It helps reduce skin blemish and pigmentation.\n"+
                    "It safeguards skin from UV sun rays.",
            "Dolo 650 Tablet helps relieve pain and fever by releasing chemical messenger"

    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack, btnGoToCart;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        listView = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost: ₹"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}