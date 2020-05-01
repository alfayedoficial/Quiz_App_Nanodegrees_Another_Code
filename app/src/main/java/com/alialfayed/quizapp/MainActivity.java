package com.alialfayed.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alialfayed.quizapp.util.SaveSharedPreferences;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_1;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_2;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_3;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_3_1;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_4;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_5;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_6;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_7;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_8;
import static com.alialfayed.quizapp.util.Constants.ANSWER_Q_9;
import static com.alialfayed.quizapp.util.SaveSharedPreferences.counterCorrect;
import static com.alialfayed.quizapp.util.SaveSharedPreferences.counterWrong;
import static com.alialfayed.quizapp.util.SaveSharedPreferences.saveCounterCorrect;
import static com.alialfayed.quizapp.util.SaveSharedPreferences.saveCounterWrong;
import static com.alialfayed.quizapp.util.SaveSharedPreferences.saveNameUser;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    private RelativeLayout rtlFirstScreen;
    private RelativeLayout rtlSecondScreen;
    private RelativeLayout rtlThirdScreen;

    private TextInputLayout textInputLayout_NameUser;

    private TextView txtCorrectAnswer;
    private TextView txtWongAnswer;
    private TextView txtStatusGame;
    private TextView txtMessage;
    private TextView txtUserName;

    private String nameUser;
    private String answerQ1;
    private String answerQ2;
    private String answerQ3;

    //////////////////// First Section
    // q1CheckBox
    private CheckBox cBox_1_ItemQuestionCheck1;
    private CheckBox cBox_2_ItemQuestionCheck1;
    private CheckBox cBox_3_ItemQuestionCheck1;

    // q2CheckBox
    private CheckBox cBox_1_ItemQuestionCheck2;
    private CheckBox cBox_2_ItemQuestionCheck2;
    private CheckBox cBox_3_ItemQuestionCheck2;

    // q3CheckBox
    private CheckBox cBox_1_ItemQuestionCheck3;
    private CheckBox cBox_2_ItemQuestionCheck3;
    private CheckBox cBox_3_ItemQuestionCheck3;

    //////////////////// Second Section
    // q1RadioButton
    private RadioButton rBtn_1_ItemQuestionRadio1;
    private RadioButton rBtn_2_ItemQuestionRadio1;
    private RadioButton rBtn_3_ItemQuestionRadio1;

    // q2RadioButton
    private RadioButton rBtn_1_ItemQuestionRadio2;
    private RadioButton rBtn_2_ItemQuestionRadio2;
    private RadioButton rBtn_3_ItemQuestionRadio2;

    // q3RadioButton
    private RadioButton rBtn_1_ItemQuestionRadio3;
    private RadioButton rBtn_2_ItemQuestionRadio3;
    private RadioButton rBtn_3_ItemQuestionRadio3;

    //////////////////// Third Section
    // q1EditText
    private EditText eTxt_ItemQuestionEdit1;

    // q2EditText
    private EditText eTxt_ItemQuestionEdit2;

    // q3EditText
    private EditText eTxt_ItemQuestionEdit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize Variables
        controlButton();

        if (SaveSharedPreferences.getFirstOnce(this)) {
            rtlFirstScreen.setVisibility(View.GONE);
            rtlSecondScreen.setVisibility(View.VISIBLE);
        } else {
            rtlFirstScreen.setVisibility(View.VISIBLE);
            rtlSecondScreen.setVisibility(View.GONE);
            rtlThirdScreen.setVisibility(View.GONE);
        }

        SaveSharedPreferences.saveFirstOnce(false, this);
        saveCounterCorrect(0, this);
        saveCounterWrong(0, this);
    }

    private void controlButton() {
        //initialize  Toolbar
        toolbar = findViewById(R.id.toolbar);

        inflateToolbar();
        inflateCheck();
        inflateRadio();
        inflateEdit();

        //initialize  Buttons
        Button btn_Next = findViewById(R.id.btn_Start);
        Button btn_Score = findViewById(R.id.btn_Score);
        Button btn_TryAgain = findViewById(R.id.btn_TryAgain);

        //initialize  RelativeLayout
        rtlFirstScreen = findViewById(R.id.rtlFirstScreen);
        rtlSecondScreen = findViewById(R.id.rtlSecondScreen);
        rtlThirdScreen = findViewById(R.id.rtlThirdScreen);

        //initialize  TextInputLayout
        textInputLayout_NameUser = findViewById(R.id.textInputLayout_NameUser);

        //initialize  TextView
        txtCorrectAnswer = findViewById(R.id.txtCorrectAnswer);
        txtWongAnswer = findViewById(R.id.txtWongAnswer);
        txtStatusGame = findViewById(R.id.txtStatusGame);
        txtMessage = findViewById(R.id.txtMessage);
        txtUserName = findViewById(R.id.txtUserName);

        // onClick Buttons
        btn_Next.setOnClickListener(this);
        btn_Score.setOnClickListener(this);
        btn_TryAgain.setOnClickListener(this);
    }

    private void inflateEdit() {
        // Q1
        TextView txtTitle_ItemQuestionEdit1 = findViewById(R.id.txtTitle_ItemQuestionEdit1);
        ImageView img_ItemQuestionEdit1 = findViewById(R.id.img_ItemQuestionEdit1);
        eTxt_ItemQuestionEdit1 = findViewById(R.id.eTxt_ItemQuestionEdit1);

        // Q2
        TextView txtTitle_ItemQuestionEdit2 = findViewById(R.id.txtTitle_ItemQuestionEdit2);
        ImageView img_ItemQuestionEdit2 = findViewById(R.id.img_ItemQuestionEdit2);
        eTxt_ItemQuestionEdit2 = findViewById(R.id.eTxt_ItemQuestionEdit2);

        // Q3
        TextView txtTitle_ItemQuestionEdit3 = findViewById(R.id.txtTitle_ItemQuestionEdit3);
        ImageView img_ItemQuestionEdit3 = findViewById(R.id.img_ItemQuestionEdit3);
        eTxt_ItemQuestionEdit3 = findViewById(R.id.eTxt_ItemQuestionEdit3);

        // Set Data
        // Q1
        txtTitle_ItemQuestionEdit1.setText(getString(R.string.q7_title));
        img_ItemQuestionEdit1.setImageResource(R.drawable.ic_question_1);

        // Q2
        txtTitle_ItemQuestionEdit2.setText(getString(R.string.q8_title));
        img_ItemQuestionEdit2.setImageResource(R.drawable.ic_question_2);

        // Q3
        txtTitle_ItemQuestionEdit3.setText(getString(R.string.q9_title));
        img_ItemQuestionEdit3.setImageResource(R.drawable.ic_question_3);
    }

    private void inflateRadio() {
        //Q1
        TextView txtTitle_ItemQuestionRadio1 = findViewById(R.id.txtTitle_ItemQuestionRadio1);
        ImageView img_ItemQuestionRadio1 = findViewById(R.id.img_ItemQuestionRadio1);
        rBtn_1_ItemQuestionRadio1 = findViewById(R.id.rBtn_1_ItemQuestionRadio1);
        rBtn_2_ItemQuestionRadio1 = findViewById(R.id.rBtn_2_ItemQuestionRadio1);
        rBtn_3_ItemQuestionRadio1 = findViewById(R.id.rBtn_3_ItemQuestionRadio1);

        //Q2
        TextView txtTitle_ItemQuestionRadio2 = findViewById(R.id.txtTitle_ItemQuestionRadio2);
        ImageView img_ItemQuestionRadio2 = findViewById(R.id.img_ItemQuestionRadio2);
        rBtn_1_ItemQuestionRadio2 = findViewById(R.id.rBtn_1_ItemQuestionRadio2);
        rBtn_2_ItemQuestionRadio2 = findViewById(R.id.rBtn_2_ItemQuestionRadio2);
        rBtn_3_ItemQuestionRadio2 = findViewById(R.id.rBtn_3_ItemQuestionRadio2);

        //Q3
        TextView txtTitle_ItemQuestionRadio3 = findViewById(R.id.txtTitle_ItemQuestionRadio3);
        ImageView img_ItemQuestionRadio3 = findViewById(R.id.img_ItemQuestionRadio3);
        rBtn_1_ItemQuestionRadio3 = findViewById(R.id.rBtn_1_ItemQuestionRadio3);
        rBtn_2_ItemQuestionRadio3 = findViewById(R.id.rBtn_2_ItemQuestionRadio3);
        rBtn_3_ItemQuestionRadio3 = findViewById(R.id.rBtn_3_ItemQuestionRadio3);

        // Set Data
        //Q1
        txtTitle_ItemQuestionRadio1.setText(getString(R.string.q4_title));
        img_ItemQuestionRadio1.setImageResource(R.drawable.ic_triangle);
        rBtn_1_ItemQuestionRadio1.setText(getString(R.string.q4_answer_1));
        rBtn_2_ItemQuestionRadio1.setText(getString(R.string.q4_answer_2));
        rBtn_3_ItemQuestionRadio1.setText(getString(R.string.q4_answer_3));

        //Q2
        txtTitle_ItemQuestionRadio2.setText(getString(R.string.q5_title));
        img_ItemQuestionRadio2.setImageResource(R.drawable.ic_square);
        rBtn_1_ItemQuestionRadio2.setText(getString(R.string.q5_answer_1));
        rBtn_2_ItemQuestionRadio2.setText(getString(R.string.q5_answer_2));
        rBtn_3_ItemQuestionRadio2.setText(getString(R.string.q5_answer_3));

        //Q3
        txtTitle_ItemQuestionRadio3.setText(getString(R.string.q6_title));
        img_ItemQuestionRadio3.setImageResource(R.drawable.ic_rectangle);
        rBtn_1_ItemQuestionRadio3.setText(getString(R.string.q6_answer_1));
        rBtn_2_ItemQuestionRadio3.setText(getString(R.string.q6_answer_2));
        rBtn_3_ItemQuestionRadio3.setText(getString(R.string.q6_answer_3));
    }

    private void inflateCheck() {
        // Q1
        TextView txtTitle_ItemQuestionCheck1 = findViewById(R.id.txtTitle_ItemQuestionCheck1);
        ImageView img_ItemQuestionCheck1 = findViewById(R.id.img_ItemQuestionCheck1);
        cBox_1_ItemQuestionCheck1 = findViewById(R.id.cBox_1_ItemQuestionCheck1);
        cBox_2_ItemQuestionCheck1 = findViewById(R.id.cBox_2_ItemQuestionCheck1);
        cBox_3_ItemQuestionCheck1 = findViewById(R.id.cBox_3_ItemQuestionCheck1);

        // Q2
        TextView txtTitle_ItemQuestionCheck2 = findViewById(R.id.txtTitle_ItemQuestionCheck2);
        ImageView img_ItemQuestionCheck2 = findViewById(R.id.img_ItemQuestionCheck2);
        cBox_1_ItemQuestionCheck2 = findViewById(R.id.cBox_1_ItemQuestionCheck2);
        cBox_2_ItemQuestionCheck2 = findViewById(R.id.cBox_2_ItemQuestionCheck2);
        cBox_3_ItemQuestionCheck2 = findViewById(R.id.cBox_3_ItemQuestionCheck2);

        // Set Data
        // Q3
        TextView txtTitle_ItemQuestionCheck3 = findViewById(R.id.txtTitle_ItemQuestionCheck3);
        ImageView img_ItemQuestionCheck3 = findViewById(R.id.img_ItemQuestionCheck3);
        cBox_1_ItemQuestionCheck3 = findViewById(R.id.cBox_1_ItemQuestionCheck3);
        cBox_2_ItemQuestionCheck3 = findViewById(R.id.cBox_2_ItemQuestionCheck3);
        cBox_3_ItemQuestionCheck3 = findViewById(R.id.cBox_3_ItemQuestionCheck3);

        // Q1
        txtTitle_ItemQuestionCheck1.setText(getString(R.string.q1_title));
        img_ItemQuestionCheck1.setImageResource(R.drawable.ic_android_logo);
        cBox_1_ItemQuestionCheck1.setText(getString(R.string.q1_answer_1));
        cBox_2_ItemQuestionCheck1.setText(getString(R.string.q1_answer_2));
        cBox_3_ItemQuestionCheck1.setText(getString(R.string.q1_answer_3));

        // Q2
        txtTitle_ItemQuestionCheck2.setText(getString(R.string.q2_title));
        img_ItemQuestionCheck2.setImageResource(R.drawable.ic_android_7);
        cBox_1_ItemQuestionCheck2.setText(getString(R.string.q2_answer_1));
        cBox_2_ItemQuestionCheck2.setText(getString(R.string.q2_answer_2));
        cBox_3_ItemQuestionCheck2.setText(getString(R.string.q2_answer_3));

        // Q3
        txtTitle_ItemQuestionCheck3.setText(getString(R.string.q3_title));
        img_ItemQuestionCheck3.setImageResource(R.drawable.ic_google);
        cBox_1_ItemQuestionCheck3.setText(getString(R.string.q3_answer_1));
        cBox_2_ItemQuestionCheck3.setText(getString(R.string.q3_answer_2));
        cBox_3_ItemQuestionCheck3.setText(getString(R.string.q3_answer_3));
    }

    // inflate Toolbar
    private void inflateToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Start:

                nameUser = Objects.requireNonNull(textInputLayout_NameUser.getEditText()).getText().toString();
                if (!nameUser.isEmpty()) {
                    rtlFirstScreen.setVisibility(View.GONE);
                    rtlSecondScreen.setVisibility(View.VISIBLE);

                    saveNameUser(nameUser, this);
                    saveCounterCorrect(0, this);
                    saveCounterWrong(0, this);
                    SaveSharedPreferences.saveFirstOnce(true, this);
                } else {
                    textInputLayout_NameUser.setErrorEnabled(false);
                    textInputLayout_NameUser.setError(getText(R.string.msg_answer_required));
                }
                break;
            case R.id.btn_Score:

                // Get text from EditText and convert them to strings
                answerQ1 = eTxt_ItemQuestionEdit1.getText().toString();
                answerQ2 = eTxt_ItemQuestionEdit2.getText().toString();
                answerQ3 = eTxt_ItemQuestionEdit3.getText().toString();

                if (answerQ1.isEmpty()) {
                    eTxt_ItemQuestionEdit1.setError(getString(R.string.msg_answer_required));
                    eTxt_ItemQuestionEdit1.requestFocus();
                } else if (answerQ2.isEmpty()) {
                    eTxt_ItemQuestionEdit2.setError(getString(R.string.msg_answer_required));
                    eTxt_ItemQuestionEdit2.requestFocus();
                } else if (answerQ3.isEmpty()) {
                    eTxt_ItemQuestionEdit3.setError(getString(R.string.msg_answer_required));
                    eTxt_ItemQuestionEdit3.requestFocus();
                } else if (!cBox_1_ItemQuestionCheck1.isChecked() && !cBox_2_ItemQuestionCheck1.isChecked() && !cBox_3_ItemQuestionCheck1.isChecked()) {
                    setError();
                } else if (!cBox_1_ItemQuestionCheck2.isChecked() && !cBox_2_ItemQuestionCheck2.isChecked() && !cBox_3_ItemQuestionCheck2.isChecked()) {
                    setError();
                } else if (!cBox_1_ItemQuestionCheck3.isChecked() && !cBox_2_ItemQuestionCheck3.isChecked() && !cBox_3_ItemQuestionCheck3.isChecked()) {
                    setError();
                } else if (!rBtn_1_ItemQuestionRadio1.isChecked() && !rBtn_2_ItemQuestionRadio1.isChecked() && !rBtn_3_ItemQuestionRadio1.isChecked()) {
                    setError();
                } else if (!rBtn_1_ItemQuestionRadio2.isChecked() && !rBtn_2_ItemQuestionRadio2.isChecked() && !rBtn_3_ItemQuestionRadio2.isChecked()) {
                    setError();
                } else if (!rBtn_1_ItemQuestionRadio3.isChecked() && !rBtn_2_ItemQuestionRadio3.isChecked() && !rBtn_3_ItemQuestionRadio3.isChecked()) {
                    setError();
                } else {
                    checkAnswers();
                    radioAnswers();
                    editAnswers();

                    int correctAnswer = SaveSharedPreferences.getCounterCorrect(this);
                    int wrongAnswer = SaveSharedPreferences.getCounterWrong(this);

                    txtCorrectAnswer.setText(String.valueOf(correctAnswer));
                    txtWongAnswer.setText(String.valueOf(wrongAnswer));
                    txtUserName.setText(SaveSharedPreferences.getNameUser(this));

                    if (correctAnswer > wrongAnswer) {
                        txtStatusGame.setText(getText(R.string.game_status_win));
                        txtMessage.setText(getText(R.string.msg_win));
                        setResult(getText(R.string.msg_win).toString(), nameUser, getText(R.string.game_status_win).toString());
                    } else if (correctAnswer < wrongAnswer || correctAnswer == 0) {
                        txtStatusGame.setText(getText(R.string.game_status_lose));
                        txtMessage.setText(getText(R.string.msg_lose));
                        setResult(getText(R.string.msg_lose).toString(), nameUser, getText(R.string.game_status_lose).toString());
                    }

                    rtlSecondScreen.setVisibility(View.GONE);
                    rtlThirdScreen.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_TryAgain:

                saveCounterCorrect(0, this);
                saveCounterWrong(0, this);

                Intent restartIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(restartIntent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    private void checkAnswers() {
        // q1CheckBox
        if (cBox_2_ItemQuestionCheck1.isChecked() || cBox_3_ItemQuestionCheck1.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_2_ItemQuestionCheck1.isChecked() && cBox_3_ItemQuestionCheck1.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_1_ItemQuestionCheck1.isChecked() && (cBox_2_ItemQuestionCheck1.isChecked() || cBox_3_ItemQuestionCheck1.isChecked())) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_1_ItemQuestionCheck1.isChecked() && cBox_2_ItemQuestionCheck1.isChecked() && cBox_3_ItemQuestionCheck1.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_1_ItemQuestionCheck1.isChecked()) {
            if (cBox_1_ItemQuestionCheck1.getText().toString().equals(ANSWER_Q_1)) {
                counterCorrect++;
                saveCounterCorrect(counterCorrect, this);
            }
        }

        // q2CheckBox
        if (cBox_1_ItemQuestionCheck2.isChecked() || cBox_3_ItemQuestionCheck2.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_1_ItemQuestionCheck2.isChecked() && cBox_3_ItemQuestionCheck2.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_1_ItemQuestionCheck2.isChecked() && (cBox_2_ItemQuestionCheck2.isChecked() || cBox_3_ItemQuestionCheck2.isChecked())) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_2_ItemQuestionCheck2.isChecked() && cBox_1_ItemQuestionCheck2.isChecked() && cBox_3_ItemQuestionCheck2.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_2_ItemQuestionCheck2.isChecked()) {
            if (cBox_2_ItemQuestionCheck2.getText().toString().equals(ANSWER_Q_2)) {
                counterCorrect++;
                saveCounterCorrect(counterCorrect, this);
            }
        }

        // q3CheckBox
        if (cBox_1_ItemQuestionCheck3.isChecked() && (cBox_2_ItemQuestionCheck3.isChecked() || cBox_3_ItemQuestionCheck3.isChecked())) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_1_ItemQuestionCheck3.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_2_ItemQuestionCheck3.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_3_ItemQuestionCheck3.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (cBox_2_ItemQuestionCheck2.isChecked() && cBox_1_ItemQuestionCheck2.isChecked() && cBox_3_ItemQuestionCheck2.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (!cBox_1_ItemQuestionCheck3.isChecked() && cBox_2_ItemQuestionCheck2.isChecked() && cBox_3_ItemQuestionCheck2.isChecked()) {
            if ((cBox_2_ItemQuestionCheck3.getText().toString().equals(ANSWER_Q_3) ||
                    cBox_2_ItemQuestionCheck3.getText().toString().equals(ANSWER_Q_3_1)) &&
                    (cBox_3_ItemQuestionCheck3.getText().toString().equals(ANSWER_Q_3) ||
                            cBox_2_ItemQuestionCheck3.getText().toString().equals(ANSWER_Q_3_1))) {
                counterCorrect++;
                saveCounterCorrect(counterCorrect, this);
            }
        }
    }

    private void radioAnswers() {
        // q1RadioBottom
        if (rBtn_2_ItemQuestionRadio1.isChecked() || rBtn_3_ItemQuestionRadio1.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (rBtn_1_ItemQuestionRadio1.isChecked()) {
            if (rBtn_1_ItemQuestionRadio1.getText().toString().equals(ANSWER_Q_4)) {
                counterCorrect++;
                saveCounterCorrect(counterCorrect, this);
            }
        }

        // q2RadioBottom
        if (rBtn_1_ItemQuestionRadio2.isChecked() || rBtn_3_ItemQuestionRadio2.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (rBtn_2_ItemQuestionRadio2.isChecked()) {
            if (rBtn_2_ItemQuestionRadio2.getText().toString().equals(ANSWER_Q_5)) {
                counterCorrect++;
                saveCounterCorrect(counterCorrect, this);
            }
        }

        // q3RadioBottom
        if (rBtn_1_ItemQuestionRadio3.isChecked() || rBtn_2_ItemQuestionRadio3.isChecked()) {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);

        } else if (rBtn_3_ItemQuestionRadio3.isChecked()) {
            if (rBtn_3_ItemQuestionRadio3.getText().toString().equals(ANSWER_Q_6)) {
                counterCorrect++;
                saveCounterCorrect(counterCorrect, this);
            }
        }
    }

    private void editAnswers() {
        // q1EditText
        if (answerQ1.equals(ANSWER_Q_7)) {
            counterCorrect++;
            saveCounterCorrect(counterCorrect, this);
        } else {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);
        }

        // q2EditText
        if (answerQ2.equals(ANSWER_Q_8)) {
            counterCorrect++;
            saveCounterCorrect(counterCorrect, this);
        } else {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);
        }

        // q3EditText
        if (answerQ3.equals(ANSWER_Q_9)) {
            counterCorrect++;
            saveCounterCorrect(counterCorrect, this);
        } else {
            counterWrong++;
            SaveSharedPreferences.saveCounterWrong(counterWrong, this);
        }
    }

    private void setError() {
        Toast.makeText(this, getText(R.string.msg_answer_all), Toast.LENGTH_SHORT).show();
    }

    private void setResult(String massage, String nameUSer, String statusGame) {
        Toast.makeText(this, massage + " " + nameUSer + "\n" + statusGame, Toast.LENGTH_LONG).show();
    }
}
