package us.syh.shareoperationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;

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
        //分享文字（默认有选择分享到...）
        findViewById(R.id.button_1_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"This is a share text.");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent,"选择分享到"));
            }
        });
        //二进制分享
        //图片分享
        //图片分享必须要有Uri
        TextView textView_3=findViewById(R.id.textView_3);
        textView_3.setText("请先确保以下文件存在："+getExternalFilesDir(Environment.DIRECTORY_PICTURES)+"/1.jpg");
        findViewById(R.id.button_2_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file=new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+"/1.jpg");
                Uri uri= FileProvider.getUriForFile(MainActivity.this,"us.syh.shareoperationtest.filerpovider",file);
                Intent shareIntent=new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM,uri);
                shareIntent.setType("image/jpeg");
                startActivity(Intent.createChooser(shareIntent,"选择分享到"));
            }
        });
        //分享多块内容（多图）
        /*
        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        imageUris.add(imageUri1); // Add your image URIs here
        imageUris.add(imageUri2);

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "Share images to.."));
         */
 }
}
