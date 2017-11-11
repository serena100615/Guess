package guess.fju.com.guess;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n = new Random().nextInt(10)+1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt_secret = (TextView) findViewById(R.id.txt_secret);
        txt_secret.setText(Integer.toString(n));
    }

    public void guess(View view){
        EditText ed_enter = (EditText) findViewById(R.id.ed_enter);
        TextView txt_mess = (TextView) findViewById(R.id.txt_mess);
        int enter = Integer.parseInt(ed_enter.getText().toString());
        if(enter<n){
            Toast.makeText(this, R.string.bigger,Toast.LENGTH_LONG).show();
        }else if (enter>n){
            txt_mess.setText(R.string.smaller);
        }else{
            new AlertDialog.Builder(this)
                    .setMessage(R.string.right)
                    .setPositiveButton(R.string.ok,null)
                    .show();
        }
    }
}
