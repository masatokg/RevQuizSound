package com.example.masatokg.revquizsound;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class QuestionActivity extends AppCompatActivity {

    private SoundPool m_Spool;

    private int m_idpoolPresent;
    private int m_idpoolWrong;
    private int m_idpoolCorrect;
    private int m_idpoolHakushu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }

    @Override
    protected void onResume() {
        super.onResume();

        m_Spool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        // 出題
        Button btnPresen = (Button)findViewById(R.id.btnPresen);
        m_idpoolPresent = m_Spool.load(this, R.raw.present, 1);
        btnPresen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 音をならす
                m_Spool.play(m_idpoolPresent, 0.3f, 0.3f, 0, 0, 1.0f);
            }
        });
        // まちがい
        Button btnWrong = (Button)findViewById(R.id.btnWrong);
        m_idpoolWrong = m_Spool.load(this, R.raw.incorrect1, 1);
        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 音をならす
                m_Spool.play(m_idpoolWrong, 0.4f, 0.4f, 0, 0, 1.0f);
            }
        });
        // せいかい
        Button btnCorrect = (Button)findViewById(R.id.btnCorrect);
        m_idpoolCorrect = m_Spool.load(this, R.raw.correct1, 1);
        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 音をならす
                m_Spool.play(m_idpoolCorrect, 0.4f, 0.4f, 0, 0, 1.0f);
            }
        });
        // はくしゅ
        Button btnHakushu = (Button)findViewById(R.id.btnHakushu);
        m_idpoolHakushu = m_Spool.load(this, R.raw.people_cheer1, 1);
        btnHakushu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 音をならす
                m_Spool.play(m_idpoolHakushu, 0.4f, 0.4f, 0, 0, 1.0f);
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
        m_Spool.release();
    }


    public void onAnsClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
