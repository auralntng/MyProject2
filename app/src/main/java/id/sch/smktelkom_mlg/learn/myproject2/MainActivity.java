package id.sch.smktelkom_mlg.learn.myproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etNIS;
    RadioButton rbR, rbT;
    Spinner spKelas;
    CheckBox cbP, cbPMR, cbPA;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNIS = (EditText) findViewById(R.id.editTextNIS);
        rbR = (RadioButton) findViewById(R.id.radioButtonRPL);
        rbT = (RadioButton) findViewById(R.id.radioButtonTKJ);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        cbP = (CheckBox) findViewById(R.id.checkBoxP);
        cbPMR = (CheckBox) findViewById(R.id.checkBoxPMR);
        cbPA = (CheckBox) findViewById(R.id.checkBoxPA);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
                //doJurusan();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        int NIS = Integer.parseInt(etNIS.getText().toString());

        String hasil = null;
        if(rbR.isChecked())
        {
            hasil = rbR.getText().toString();
        }
        else if(rbT.isChecked())
        {
            hasil = rbT.getText().toString();
        }

        String kelas = spKelas.getSelectedItem().toString();

        String sub = "Anda Mengikuti Sub : \n";
        int startlen = sub.length();
        if(cbP.isChecked()) sub+=cbP.getText()+"\n";
        if(cbPMR.isChecked()) sub+=cbPMR.getText()+"\n";
        if(cbPA.isChecked()) sub+=cbPA.getText();
        if(sub.length()==startlen)sub+="Tidak Ada Pada Pilihan";

        tvHasil.setText("Nama : "+nama+"\nNIS : "+NIS+"\nJurusan : "+hasil+"\nKelas : "+kelas+"\n"+sub);
    }
}
