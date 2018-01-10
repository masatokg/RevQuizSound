package com.example.masatokg.revquizsound;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SoundPool m_SpoolQ1;
    private int m_idpoolQ1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button btnAns = (Button)findViewById(R.id.btn_AnsSnd);

        m_SpoolQ1 = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        m_idpoolQ1 = m_SpoolQ1.load(this, R.raw.q1, 1);


        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 音をならす
                m_SpoolQ1.play(m_idpoolQ1, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        });
    }


    public void onPresentClick(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        m_SpoolQ1.release();
    }
}
