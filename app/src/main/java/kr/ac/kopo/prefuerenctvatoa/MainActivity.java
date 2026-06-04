package kr.ac.kopo.prefuerenctvatoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setTitle("아이돌 선호도 투표");
        final int voteCount[] = new int[9];
        for (int i = 0; i < voteCount.length; i++) {
            voteCount[i] = 0;
        }

        ImageView[] imgvArr = new ImageView[9];
        int[] imgvIdArr = {R.id.imgv1, R.id.imgv2, R.id.imgv3, R.id.imgv4, R.id.imgv5, R.id.imgv6, R.id.imgv7, R.id.imgv8, R.id.imgv9};

        final String[] idolNameArr = {"고춧가루", "김치", "영수증1","영수증2","사모예드","영수증3","가보자구","꽃1","꽃2"};

        for (int i = 0; i < imgvArr.length; i++) {
            final int index;
            index = i;
            imgvArr[index] = findViewById(imgvIdArr[index]);
            imgvArr[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), "총 "+ voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("idolNameArr", idolNameArr);
                startActivity(intent); //  's'를 지운 단수형 메서드로 변경!
            }
        });


    }
}