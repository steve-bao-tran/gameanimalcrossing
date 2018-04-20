package com.example.dell.gamemini;

import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Khai báo biến
    TextView tvDiem;
    ImageButton imgbtPlay;
    RadioGroup rgDatCuot;
    CheckBox cbCat, cbFish, cbMonkey;
    SeekBar sbCat, sbFish, sbMonkey;

    public static Boolean t1;
    public static Boolean t2;
    public static Boolean t3;
    public static int diem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ biến
        AnhXa();

        diem = 100;
        // int cat = 0; int fish = 0; int monkey = 0;

        tvDiem.setText(diem + "");

        /* Xử lý Game */
        imgbtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1 = false;
                t2 = false;
                t3 = false;

                sbCat.setProgress(0);
                sbFish.setProgress(0);
                sbMonkey.setProgress(0);

                if (! cbCat.isChecked() && ! cbFish.isChecked() && ! cbMonkey.isChecked() && diem <= 100) {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cượt", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Chơi nào", Toast.LENGTH_SHORT).show();

                    CountDownTimer countDownTimer = new CountDownTimer(12000, 200) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            Random random = new Random();
                            int chochay = random.nextInt(3);

                            switch (chochay){
                                case 0:
                                    if (t1 == false) {
                                        if (sbCat.getProgress() == sbCat.getMax() && t2 == false && t3 == false) {
                                            t1 = true;
                                            Toast.makeText(MainActivity.this, "Mèo thắng", Toast.LENGTH_SHORT).show();
                                            if (cbCat.isChecked()) {
                                                diem += 10;
                                                Toast.makeText(MainActivity.this, "Bạn đoán ĐÚNG, +10 điểm", Toast.LENGTH_SHORT).show();
                                            } else {
                                                diem -= 10;
                                                Toast.makeText(MainActivity.this, "Bạn đoán SAI, -10 điểm", Toast.LENGTH_SHORT).show();
                                            }
                                            tvDiem.setText(diem + "");
                                        } else if (sbCat.getProgress() < sbCat.getMax()) {
                                            sbCat.setProgress(sbCat.getProgress() + 5);
                                        }
                                    }
                                    break;
                                case 1:
                                    if (t2 == false) {
                                        if (sbFish.getProgress() == sbFish.getMax() && t1 == false && t3 == false) {
                                            t2 = true;
                                            Toast.makeText(MainActivity.this, "Cá thắng", Toast.LENGTH_SHORT).show();
                                            if (cbFish.isChecked()) {
                                                diem += 10;
                                                Toast.makeText(MainActivity.this, "Bạn đoán ĐÚNG, +10 điểm", Toast.LENGTH_SHORT).show();
                                            } else {
                                                diem -= 10;
                                                Toast.makeText(MainActivity.this, "Bạn đoán SAI, -10 điểm", Toast.LENGTH_SHORT).show();
                                            }
                                            tvDiem.setText(diem + "");
                                        } else if (sbFish.getProgress() < sbFish.getMax()) {
                                            sbFish.setProgress(sbFish.getProgress() + 5);
                                        }
                                    }
                                    break;
                                case 2:
                                    if (t3 == false) {
                                        if (sbMonkey.getProgress() == sbMonkey.getMax() && t1 == false && t2 == false) {
                                            t3 = true;
                                            Toast.makeText(MainActivity.this, "Khỉ thắng", Toast.LENGTH_SHORT).show();
                                            if (cbMonkey.isChecked()) {
                                                diem += 10;
                                                Toast.makeText(MainActivity.this, "Bạn đoán ĐÚNG, +10 điểm", Toast.LENGTH_SHORT).show();
                                            } else {
                                                diem -= 10;
                                                Toast.makeText(MainActivity.this, "Bạn đoán SAI, -10 điểm", Toast.LENGTH_SHORT).show();
                                            }
                                            tvDiem.setText(diem + "");
                                        } else if (sbMonkey.getProgress() < sbMonkey.getMax()) {
                                            sbMonkey.setProgress(sbMonkey.getProgress() + 5);
                                        }
                                    }
                                    break;
                                    default: break;
                            }
                        }

                        @Override
                        public void onFinish() {
                            Toast.makeText(MainActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
                        }
                    };
                    countDownTimer.start();
                }


            }
        });

        cbCat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbFish.setChecked(false);
                    cbMonkey.setChecked(false);
                }
            }
        });

        cbFish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbCat.setChecked(false);
                    cbMonkey.setChecked(false);
                }
            }
        });

        cbMonkey.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbFish.setChecked(false);
                    cbCat.setChecked(false);
                }
            }
        });
    }

    private void AnhXa() {
        tvDiem = (TextView) findViewById(R.id.textViewMark);
        imgbtPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        rgDatCuot = (RadioGroup) findViewById(R.id.radioGroupDatCuot);
        cbCat = (CheckBox) findViewById(R.id.checkBoxCat);
        cbFish = (CheckBox) findViewById(R.id.checkBoxFish);
        cbMonkey = (CheckBox) findViewById(R.id.checkBoxMonkey);
        sbCat = (SeekBar) findViewById(R.id.seekBarCat);
        sbFish = (SeekBar) findViewById(R.id.seekBarFish);
        sbMonkey = (SeekBar) findViewById(R.id.seekBarMonkey);
    }
}
