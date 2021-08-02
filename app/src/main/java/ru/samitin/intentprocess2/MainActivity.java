package ru.samitin.intentprocess2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TEXT = "PARAM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text=findViewById(R.id.editText);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("digitalkeyboard://intent");
                Intent runEchoIntent=new Intent(Intent.ACTION_VIEW,uri);
                runEchoIntent.putExtra(TEXT,text.getText().toString());
                ActivityInfo activityInfo =
                        runEchoIntent.resolveActivityInfo(getPackageManager(),
                                runEchoIntent.getFlags());
                if (activityInfo != null) {
                    startActivity(runEchoIntent);
                }
                
            }
        });
    }
}