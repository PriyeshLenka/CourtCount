package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int score1=0,score2=0;
    String result;
    String resultMessage;

    public void increment3a(View view){
    score1=score1+3;
    displayForTeamA(score1);
    }
    public void increment2a(View view){
        score1=score1+2;
        displayForTeamA(score1);
    }
    public void incrementFTa(View view){
        score1=score1+1;
        displayForTeamA(score1);
    }
    public void Reset(View view){
        score1=0;
        score2=0;
        resultMessage="";
        displayForTeamA(score1);
        displayForTeamB(score2);
        displayMessage(resultMessage);
    }
    public void increment3b(View view){
        score2=score2+3;
        displayForTeamB(score2);
    }
    public void increment2b(View view){
        score2=score2+2;
        displayForTeamB(score2);
    }
    public void incrementFTb(View view){
        score2=score2+1;
        displayForTeamB(score2);
    }
    public void displayForTeamA(int score1) {

        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA);
        scoreView.setText(String.valueOf(score1));
    }
    public void displayForTeamB(int score2) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreB);
        scoreView.setText(String.valueOf(score2));
    }
    public void Result(View view) {

        if(score1>score2){
            result="Team A has won the Match";
        }else if(score1<score2){
            result="Team B has won the Match";
        } else {
            result="DRAW";
        }
        resultMessage="Team A has scored: "+score1+"\nTeam B has scored: "+score2+"\nResult: "+result;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", resultMessage);
        intent.putExtra(Intent.EXTRA_STREAM, resultMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayMessage(resultMessage);
    }
    private void displayMessage(String message){
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText(message);
    }
}