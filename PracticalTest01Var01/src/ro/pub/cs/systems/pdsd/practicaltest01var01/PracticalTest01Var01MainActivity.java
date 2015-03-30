package ro.pub.cs.systems.pdsd.practicaltest01var01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends Activity {

	Button sec;
	CheckBox chp, che, chi;
	EditText etdr;
	
	private class Ascultator implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			
			int nr2 = 0;
			if (chp.isChecked())
				nr2++;
			if (che.isChecked())
				nr2++;
			if (chi.isChecked())
				nr2++;
			
			etdr.setText(Integer.toString(nr2));
			
			if (v.getId() == R.id.bSec) {
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var01SecondaryActivity");
				String s = "";
				if (chp.isChecked()) {
					s += "Phone ";
				}
				if (che.isChecked()) {
					s += "Email ";
				}
				if (chi.isChecked()) {
					s += "InstantMessaging";
				}
				
				intent.putExtra("data", s);
				
				startActivityForResult(intent, 2015);
			}
		}
		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);
        
        sec = (Button)findViewById(R.id.bSec);
        
        chp = (CheckBox)findViewById(R.id.chP);
        che = (CheckBox)findViewById(R.id.chE);
        chi = (CheckBox)findViewById(R.id.chI);
        
        etdr = (EditText)findViewById(R.id.etDr);
        
        Ascultator asculta = new Ascultator();
        
        chp.setOnClickListener(asculta);
        che.setOnClickListener(asculta);
        chi.setOnClickListener(asculta);
        
        sec.setOnClickListener(asculta);
        
        if (savedInstanceState != null) {
        	chp.setChecked(savedInstanceState.getBoolean("chp"));
        	che.setChecked(savedInstanceState.getBoolean("che"));
        	chi.setChecked(savedInstanceState.getBoolean("chi"));
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var01_main, menu);
        return true;
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
    	savedInstanceState.putBoolean("chp", chp.isChecked());
    	savedInstanceState.putBoolean("che", che.isChecked());
    	savedInstanceState.putBoolean("chi", chi.isChecked());
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
      Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
    }
    
}
