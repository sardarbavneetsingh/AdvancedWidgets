package pm.covertjustice.advancedwidgets;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Button b,b1;
    TextView tv;
    TimePicker tp;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.textview);
        tp=(TimePicker)findViewById(R.id.timePick);
        b=(Button)findViewById(R.id.button);
        tv.setText(getCurrentTime());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(getCurrentTime());
            }
        });

        b1=(Button)findViewById(R.id.alertw);
        builder = new AlertDialog.Builder(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to exit?").setCancelable(false).setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog ad = builder.create();
                ad.setTitle("Exit Portal");
                ad.show();
            }
        });
    }
    public String getCurrentTime()
    {
        String time="Current Time is "+tp.getCurrentHour()+":"+tp.getCurrentMinute();

        return time;
    }
}
