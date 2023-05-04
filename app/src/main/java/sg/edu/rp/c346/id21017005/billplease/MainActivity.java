package sg.edu.rp.c346.id21017005.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amtEntered;
    EditText paxEntered;
    EditText discountEntered;
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
        discountEntered=findViewById(R.id.etDiscount);
        tbService=findViewById(R.id.tbService);
        tbGST=findViewById(R.id.tbGST);
        rgPaymentMethod=findViewById(R.id.rg);
        btnSplit =findViewById(R.id.btnSplit);
        btnReset=findViewById(R.id.btnReset);
        tvDisplayTotalAmt=findViewById(R.id.tvDisplayTotalAmt);
        tvDisplayAmtSplit=findViewById(R.id.tvDisplayAmtPerPerson);

        btnSplit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (amtEntered.getText().toString().trim().length() != 0 && paxEntered.getText().toString().trim().length() != 0 && discountEntered.getText().toString().trim().length() != 0) {
                    double totalAmount = 0;

                    // convert the numerical values entered to string
                    String inputAmount = amtEntered.getText().toString();
                    String inputPeople = paxEntered.getText().toString();
                    String inputDiscount = discountEntered.getText().toString();

                    // convert the string values into float
                    int amountBefore = Integer.parseInt(inputAmount);
                    int noOfPeople = Integer.parseInt(inputPeople);
                    int discount = Integer.parseInt(inputDiscount);
                    totalAmount += amountBefore;
                    double svsCharge = 0;
                    double gstCharge = 0;
                    // check if SVS charge is applied (toggle button)
                    if (tbService.isChecked()) {
                        svsCharge = 0.1 * amountBefore;
                    }
                    totalAmount += svsCharge;
                    // check if GST charge is applied (toggle button)
                    if (tbGST.isChecked()) {
                        gstCharge = totalAmount * 0.08;
                    }
                    totalAmount += gstCharge;
                    // calculate discount
                    double discountedPrice = (discount / 100) * totalAmount;
                    totalAmount -= discountedPrice;
                    // split price
                    double splitAmount = totalAmount / noOfPeople;
                    // print values to textView
                    String displayTotalAmount = "Total Bill: $" + totalAmount;
                    tvDisplayTotalAmt.setText(displayTotalAmount);
                    String displaySplitAmt = "Each to pay $" + splitAmount;
                    int checkedRadioId = rgPaymentMethod.getCheckedRadioButtonId();
                    if (checkedRadioId == R.id.rbCash) {
                        tvDisplayAmtSplit.setText(displaySplitAmt);
                    } else {
                        tvDisplayAmtSplit.setText(displaySplitAmt + " via PayNow");
                    }
                }
                else{
                    tvDisplayTotalAmt.setText("ERROR");
                    tvDisplayAmtSplit.setText("Please enter correct values");
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amtEntered.getText().toString().trim().length() != 0 && paxEntered.getText().toString().trim().length() != 0 && discountEntered.getText().toString().trim().length() != 0) {
                    amtEntered.setText(0);
                    paxEntered.setText(0);
                    discountEntered.setText(0);
                    tvDisplayTotalAmt.setText("");
                    tvDisplayAmtSplit.setText("");
                }
            }
        });
    }

}