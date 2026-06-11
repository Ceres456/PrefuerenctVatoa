package kr.ac.kopo.prefuerenctvatoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView textTitle;
    ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        int[] imgResArr = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] idolNameArr = intent.getStringArrayExtra("idolNameArr");

        TextView[] textArr = new TextView[idolNameArr.length];
        RatingBar[] ratingArr = new RatingBar[idolNameArr.length];

        textTitle = findViewById(R.id.text_title);
        imgv = findViewById(R.id.imgv);

        int maxIndex = 0;
        int maxValue = voteCount[0];

        for (int i = 0; i < voteCount.length; i++){
            if(voteCount[i] > maxValue) {
                maxValue = voteCount[i];
                maxIndex = i;
            }
        }

        textTitle.setText(idolNameArr[maxIndex]);
        imgv.setImageResource(imgResArr[maxIndex]);


        int[] textIdArr = {R.id.text1,R.id.text2,R.id.text3,R.id.text4,R.id.text5,R.id.text6,R.id.text7,R.id.text8,R.id.text9};
        int[] ratingIdArr = {R.id.rating1,R.id.rating2,R.id.rating3,R.id.rating4,R.id.rating5,R.id.rating6,R.id.rating7,R.id.rating8,R.id.rating9};

        for (int i = 0; i < textArr.length; i++){
            textArr[i] = findViewById(textIdArr[i]);
            ratingArr[i] = findViewById(ratingIdArr[i]);
        }

        for (int i = 0; i < textArr.length; i++){
            textArr[i].setText(idolNameArr[i]);
            ratingArr[i].setRating(voteCount[i]);
        }

        Button btncomeback = findViewById(R.id.btn_comeback);
        btncomeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}