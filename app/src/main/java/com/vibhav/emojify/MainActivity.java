package com.vibhav.emojify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    static String finalText;
    static String skew="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] unicode =new int[]{0x1F601,0x1F602,0x1F603,0x1F604,0x1F605,0x1F606,0x1F609,0x1F60A,0x1F60B,0x1F60C,0x1F60D,0x1F60F,0x1F612,0x1F613,0x1F614,0x1F616,0x1F618,0x1F61A,0x1F61C,0x1F61D,0x1F61E,0x1F620,0x1F621,0x1F622,0x1F623,0x1F624,0x1F625,0x1F628,0x1F629,0x1F62A,0x1F62B,0x1F62D,0x1F630,0x1F631,0x1F632,0x1F633,0x1F635,0x1F637,0x1F638,0x1F639,0x1F63A,0x1F63B,0x1F63C,0x1F63D,0x1F63E,0x1F63F,0x1F640,0x1F645,0x1F646,0x1F647,0x1F648,0x1F649,0x1F64A,0x1F64B,0x1F64C,0x1F64D,0x1F64E,0x1F64F};
        String[] emojis =new String[]{"grinning   smiling eyes","  tears of joy","smiling   open mouth","smiling   open mouth and smiling eyes","smiling   open mouth and cold sweat","smiling   open mouth and tightly-closed eyes","winking ","smiling   smiling eyes"," savouring delicious food","relieved ","smiling   heart-shaped eyes","smirking ","unamused ","  cold sweat","pensive ","confounded "," throwing a kiss","kissing   closed eyes","  stuck-out tongue and winking eye","  stuck-out tongue and tightly-closed eyes","disappointed ","angry ","pouting ","crying ","persevering ","  look of triumph","disappointed but relieved ","fearful ","weary ","sleepy ","tired ","loudly crying ","  open mouth and cold sweat"," screaming in fear","astonished ","flushed ","dizzy ","  medical mask","grinning cat   smiling eyes","cat   tears of joy","smiling cat   open mouth","smiling cat   heart-shaped eyes","cat   wry smile","kissing cat   closed eyes","pouting cat ","crying cat ","weary cat ","  no good gesture","  ok gesture"," bowing deeply","see-no-evil monkey","hear-no-evil monkey","speak-no-evil monkey","happy  raising one hand","raising both hands in celebration", "frowning", "pouting" , "folded hands"};
        finalText="";

        TextView textView=(TextView) findViewById(R.id.textView);
        int[] presentUnicode =new int[10];

        EditText et=(EditText) findViewById(R.id.editText);

        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=et.getText().toString();
                StringTokenizer textTokenizer=new StringTokenizer(text);
                while (textTokenizer.hasMoreTokens())
                {
                    String str=textTokenizer.nextToken().toString();
                    finalText+=str+" ";
                    Log.i("dbg","this is your input"+ str);
                    for (int i=0,k=0;i<emojis.length;i++)
                    {
                        String emojiString=emojis[i];
                        StringTokenizer emojiTokenizer=new StringTokenizer(emojiString);
                        while (emojiTokenizer.hasMoreTokens())
                        {
                            String token=emojiTokenizer.nextToken();
                            Log.i("dbg","this is"+i+"evaluate with token"+ token);
                            if (str.equals(token))
                            {   presentUnicode[k]=i;
                                skew+=i;

                                Log.i("dbg","if output true");
                                Log.i("dbg2", "sending unicode "+i);
                                Log.i("dbg2", "sending unicode in present"+presentUnicode[k]);
                                finalText+=getEmojiByUnicode(unicode[i]);
                                Log.i("dbg","if "+finalText);
                                Log.i("dbgtt","if "+skew);
                                k++;
                                continue;
                            }

                        }
                    }
                }
//                String s="";
//                Log.i("dbgtt", "present unicode"+skew);
//                for (int j=0;j<4;j++)
//                {
//                    Log.i("dbgt","unicode output"+ presentUnicode[j]);
//                    s+=getEmojiByUnicode(unicode[presentUnicode[j]]);
//                }
//                textView.setText(s);
                textView.setText(finalText);
            }

        });


    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

}
