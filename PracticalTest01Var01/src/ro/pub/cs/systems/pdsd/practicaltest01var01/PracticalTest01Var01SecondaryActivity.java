package ro.pub.cs.systems.pdsd.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class PracticalTest01Var01SecondaryActivity extends Activity {
	
	Button ok, cancel;
	EditText rez;
	
	private class AscultatorSec implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			
			switch (v.getId()) {
				case R.id.bOk:
					setResult(RESULT_OK, new Intent());
					finish();
					break;
					
				case R.id.bCancel:
					setResult(RESULT_CANCELED, new Intent());
					finish();
					break;	
			}
			
		}
		
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);
        
        ok = (Button)findViewById(R.id.bOk);
        cancel = (Button)findViewById(R.id.bCancel);
        
        rez = (EditText)findViewById(R.id.etSec);
        
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        rez.setText(data);
        
        AscultatorSec asculta = new AscultatorSec();
        
        ok.setOnClickListener(asculta);
        cancel.setOnClickListener(asculta);
        
    }

}
