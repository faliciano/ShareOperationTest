package us.syh.shareoperationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        TextView textView=findViewById(R.id.textView_2);
        ImageView imageView=findViewById(R.id.imageView_1);
        Intent intent=getIntent();
        String action=intent.getAction();
        String type=intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type!=null){
            if("text/plain".equals(type)){
                textView.setText("分享的内容为： "+intent.getStringExtra(Intent.EXTRA_TEXT));
            }else if(type.startsWith("images/")){
                Uri imageUri=(Uri)intent.getParcelableExtra(Intent.EXTRA_STREAM);
                FileInputStream inputStream= null;
                try {
                    inputStream = openFileInput(imageUri.toString());
                    Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
