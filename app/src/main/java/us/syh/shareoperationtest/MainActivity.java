package us.syh.shareoperationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //分享文字（普通的）
        findViewById(R.id.button_1_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"This is a share text.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        //分享文字（有选择）
        findViewById(R.id.button_1_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"This is a share text.");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent,"发送到"));
            }
        });
    }
}
