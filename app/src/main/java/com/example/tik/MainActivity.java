package com.example.tik;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,p+"Move",Toast.LENGTH_LONG).show();
    }
    int p=0;
    //int w=0;
    int [] b={2,2,2,2,2,2,2,2,2};
    int [][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void tap(View view){
        ImageView img=(ImageView)view;
        int t=Integer.parseInt(img.getTag().toString());
        if(b[t]==2)
        {
            b[t]=p;

            img.setTranslationY(-1000f);
            if(p==0)
            img.setImageResource(R.drawable.o);
            else
                img.setImageResource(R.drawable.x);
            p=~p;

            img.animate().translationYBy(1000f).setDuration(300);
            Toast.makeText(MainActivity.this,p+"Move",Toast.LENGTH_LONG).show();
        }
        int i;
        for(i = 0; i<8; i++)
        {

                if(b[win[i][0]]==b[win[i][1]]&&b[win[i][1]]==b[win[i][2]]&&b[win[i][0]]!=2) {
                  System.out.println("Win....");
                    Toast.makeText(MainActivity.this,"Winner :"+~p,Toast.LENGTH_LONG).show();

                }
        }

    }
}
