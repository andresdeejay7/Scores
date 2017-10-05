package com.example.danceculture.score;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;
    private EditText et9;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    private TextView tv44;

    private EditText et11;
    private EditText et22;
    private EditText et33;

    private Button bt1;
    private Button btcargar;
    private Button btguardar;
    private Button btclear;

    private String v1;
    private String v2;
    private String retorne;
    private String semestral;

    private double vr;
    private double vrr;
    private double nota1;
    private double nota2;
    private double nota3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context=this;
        SharedPreferences sharprefs= getSharedPreferences("ArchivoSP",context.MODE_PRIVATE);



        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
        et6=(EditText)findViewById(R.id.et6);
        et7=(EditText)findViewById(R.id.et7);
        et8=(EditText)findViewById(R.id.et8);
        et9=(EditText)findViewById(R.id.et9);

        et11=(EditText)findViewById(R.id.et11);
        et22=(EditText)findViewById(R.id.et22);
        et33=(EditText)findViewById(R.id.et33);

        tv44=(TextView)findViewById(R.id.tv44);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);

        bt1=(Button)findViewById(R.id.bt1);
        btcargar=(Button)findViewById(R.id.btcargar);
        btguardar=(Button)findViewById(R.id.btguardar);
        btclear=(Button)findViewById(R.id.btclear);

        SharedPreferences sharpref=getPreferences(context.MODE_PRIVATE);
        et11.setText(sharpref.getString("St1",""));
        et22.setText(sharpref.getString("St2",""));
        et33.setText(sharpref.getString("St3",""));

        et1.setText(sharpref.getString("nt1",""));
        et2.setText(sharpref.getString("nt2",""));
        et3.setText(sharpref.getString("nt3",""));
        et4.setText(sharpref.getString("nt4",""));
        et5.setText(sharpref.getString("nt5",""));
        et6.setText(sharpref.getString("nt6",""));
        et7.setText(sharpref.getString("nt7",""));
        et8.setText(sharpref.getString("nt8",""));
        et9.setText(sharpref.getString("nt9",""));






        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
                et8.setText("");
                et9.setText("");
                et11.setText("");
                et22.setText("");
                et33.setText("");


            }
        });

        btguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharpref= getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharpref.edit();

                editor.putString("St1",et11.getText().toString());
                editor.putString("St2",et22.getText().toString());
                editor.putString("St3",et33.getText().toString());

                editor.putString("nt1",et1.getText().toString());
                editor.putString("nt2",et2.getText().toString());
                editor.putString("nt3",et3.getText().toString());
                editor.putString("nt4",et4.getText().toString());
                editor.putString("nt5",et5.getText().toString());
                editor.putString("nt6",et6.getText().toString());
                editor.putString("nt7",et7.getText().toString());
                editor.putString("nt8",et8.getText().toString());
                editor.putString("nt9",et9.getText().toString());

                editor.commit();

                Toast toart= Toast.makeText(getApplicationContext(),getResources().getString(R.string.guardado),Toast.LENGTH_LONG);
                toart.show();

            }
        });

        btcargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharpref=getPreferences(context.MODE_PRIVATE);
                et11.setText(sharpref.getString("St1",""));
                et22.setText(sharpref.getString("St2",""));
                et33.setText(sharpref.getString("St3",""));

                et1.setText(sharpref.getString("nt1",""));
                et2.setText(sharpref.getString("nt2",""));
                et3.setText(sharpref.getString("nt3",""));
                et4.setText(sharpref.getString("nt4",""));
                et5.setText(sharpref.getString("nt5",""));
                et6.setText(sharpref.getString("nt6",""));
                et7.setText(sharpref.getString("nt7",""));
                et8.setText(sharpref.getString("nt8",""));
                et9.setText(sharpref.getString("nt9",""));

                Toast toart= Toast.makeText(getApplicationContext(),getResources().getString(R.string.cargado),Toast.LENGTH_LONG);
                toart.show();


            }
        });

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());
                tv1.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);





            }
        });
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());
                tv1.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);





            }
        });
        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());
                tv1.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);






            }
        });
        et4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et4.getText().toString(),et5.getText().toString(),et6.getText().toString());
                tv2.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);





            }
        });
        et5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et4.getText().toString(),et5.getText().toString(),et6.getText().toString());
                tv2.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);




            }
        });
        et6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et4.getText().toString(),et5.getText().toString(),et6.getText().toString());
                tv2.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);






            }
        });
        et7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et7.getText().toString(),et8.getText().toString(),et9.getText().toString());
                tv3.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);






            }
        });
        et8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et7.getText().toString(),et8.getText().toString(),et9.getText().toString());
                tv3.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);






            }
        });
        et9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




                retorne=cnotas(et7.getText().toString(),et8.getText().toString(),et9.getText().toString());
                tv3.setText(retorne);
                semestral=cprom(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
                tv44.setText(semestral);






            }
        });

    }

    private String  cnotas(String n1,String n2,String n3){

        v2="0";
        v1=n1;
        if (!v1.equals("")){
            v1=n2;
            if (!v1.equals("")){
                v1=n3;
                if (!v1.equals("")){
                    try {
                        nota1=Double.valueOf(n1).doubleValue();
                        nota2=Double.valueOf(n2).doubleValue();
                        nota3=Double.valueOf(n3).doubleValue();
                        vr=(nota1*0.3)+(nota2*0.3)+(nota3*0.4);
                        vrr = Math.round( vr * 100.0 ) / 100.0;
                        v1=String.valueOf(vrr);
                        return v1;

                    }catch (NumberFormatException e){
                        Toast toart= Toast.makeText(getApplicationContext(),getResources().getString(R.string.errorconvert),Toast.LENGTH_LONG);
                        toart.show();
                        return v2;
                    }


                }else{

                    return v2;


                }


            }else{

                return v2;

            }


        }else{
            
            return v2;
        }
    }

    private String cprom(String p1,String p2,String p3){
        v2="0";
        v1=p1;
        if (!v1.equals("")){

            v1=p2;
            if (!v1.equals("")){
                v1=p3;
                if (!v1.equals("")){
                    nota1=Double.valueOf(p1).doubleValue();
                    nota2=Double.valueOf(p2).doubleValue();
                    nota3=Double.valueOf(p3).doubleValue();
                    vr=((nota1+nota2+nota3)/3);
                    vrr = Math.round( vr * 100.0 ) / 100.0;

                    v1=String.valueOf(vrr);
                    return v1;


                }else{
                    return v2;
                }

            }else{
                return v2;
            }

        }else{
            return v2;

        }


    }

    public Void acercade(View view){
        Intent i=new Intent(this,AcercaDe.class);
        startActivity(i);
        return null;
    }

}
