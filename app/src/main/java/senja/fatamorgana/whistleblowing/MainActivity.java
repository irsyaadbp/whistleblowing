package senja.fatamorgana.whistleblowing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import senja.fatamorgana.whistleblowing.Config.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    Button bt_logout;
    SharedPrefManager SP_Help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SP_Help = new SharedPrefManager(this);

        bt_logout = (Button)findViewById(R.id.bt_logout);

        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SP_Help.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                Intent i = new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in_animation, R.anim.fade_out_animation);
                finish();
            }
        });

    }
}