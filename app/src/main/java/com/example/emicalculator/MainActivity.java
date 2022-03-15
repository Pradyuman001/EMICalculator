package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {
    // ID Building:
    EditText Amount_edt, Interest_edt, Year_edt, Month_edt;
    Button Calculate_btn, Reset_btn, Details_btn;
    TextView ans_txt, monthly_emi, total_interest, total_payment;
    private TableLayout table_tbl;

    // Variables :
    double Loan_Amount = 0;
    double Interest = 0;
    double Emi=0;
    int Month;
    int Year = 0;
    double NewMonth = 0;
    double InterestFind = 0;
    double Answer = 0;


    // Emi Calculation Process :
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Binding();
        table_tbl.setVisibility(View.INVISIBLE);
        Calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Month_edt.getText().toString().length() != 0)
                {
                    Loan_Amount = Double.parseDouble(Amount_edt.getText().toString());
                    Interest = Double.parseDouble(Interest_edt.getText().toString());
                    Year = Integer.parseInt(Year_edt.getText().toString());
                    Month = Integer.parseInt(Month_edt.getText().toString());

                    if (Month >= 12)
                    {
                        Toast.makeText(MainActivity.this, "Please Enter The Valid Month", Toast.LENGTH_LONG).show();
                    }

                    NewMonth = Year * 12;
                    NewMonth += Month;
                    InterestFind = (Loan_Amount * Interest) / 100;
                    Answer = (Loan_Amount + InterestFind);
                    Emi = Answer / NewMonth;
                    ans_txt.setText("" + Emi);


                    //Toast.makeText(MainActivity.this, ""+f_emi, Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Loan_Amount = Double.parseDouble(Amount_edt.getText().toString());
                    Interest = Double.parseDouble(Interest_edt.getText().toString());
                    Year = Integer.parseInt(Year_edt.getText().toString());
                    Month = 0;

                    if (Month >= 12)
                    {
                        Toast.makeText(MainActivity.this, "Please Enter The Valid Month", Toast.LENGTH_LONG).show();
                    }

                    NewMonth = Year * 12;
                    NewMonth += Month;
                    Month_edt.setText("0");
                    InterestFind = (Loan_Amount * Interest) / 100;
                    Answer = (Loan_Amount + InterestFind);
                    Emi = Answer / NewMonth;
                    ans_txt.setText("" + Emi);
                }
            }
        });

        // Clear All Data :
        Reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount_edt.setText("");
                Interest_edt.setText("");
                Year_edt.setText("");
                Month_edt.setText("");
                ans_txt.setText("");
                monthly_emi.setText("");
                total_interest.setText("");
                total_payment.setText("");
                InterestFind = 0;
                Answer = 0;
                Loan_Amount = 0;
                Emi=0;
                table_tbl.setVisibility(View.INVISIBLE);


            }
        });

        // Show Details :
        Details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table_tbl.setVisibility(View.VISIBLE);
                monthly_emi.setText("" + Emi );
                total_interest.setText("" + InterestFind);
                total_payment.setText("" + (Loan_Amount+InterestFind));
            }
        });

    }


    void Binding() {
        Amount_edt = findViewById(R.id.Amount_edt);
        Interest_edt = findViewById(R.id.Interest_edt);
        Year_edt = findViewById(R.id.Year_edt);
        Month_edt = findViewById(R.id.Month_edt);
        Calculate_btn = findViewById(R.id.Calculate_btn);
        ans_txt = findViewById(R.id.ans_txt);
        Reset_btn = findViewById(R.id.Reset_btn);
        Details_btn = findViewById(R.id.Details_btn);
        monthly_emi = findViewById(R.id.monthly_emi);
        total_interest = findViewById(R.id.total_interest);
        total_payment = findViewById(R.id.total_payment);
        table_tbl = findViewById(R.id.table_tbl);
    }
}