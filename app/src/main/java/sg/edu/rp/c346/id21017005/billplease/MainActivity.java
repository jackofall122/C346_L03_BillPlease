package sg.edu.rp.c346.id21017005.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amtEntered;
    EditText paxEntered;
    ToggleButton tbService;
    ToggleButton tbGST;
    RadioGroup rgPaymentMethod;
    Button btnSplit;
    Button btnReset;
    TextView tvDisplayTotalAmt;
    TextView tvDisplayAmtSplit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amtEntered=findViewById(R.id.etAmt);
        paxEntered=findViewById(R.id.etPax);
        tbService=findViewById(R.id.tbService);
        tbGST=findViewById(R.id.tbGST);
        rgPaymentMethod=findViewById(R.id.rg);
        btnSplit =findViewById(R.id.btnSplit);
        btnReset=findViewById(R.id.btnReset);
        tvDisplayTotalAmt=findViewById(R.id.tvDisplayTotalAmt);
        tvDisplayAmtSplit=findViewById(R.id.tvDisplayAmtPerPerson);

    }
}