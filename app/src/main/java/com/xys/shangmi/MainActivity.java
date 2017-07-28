package com.xys.shangmi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sunmi.printerhelper.utils.AidlUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button scanBarCodeButton = (Button) this.findViewById(R.id.button);

        Context context = getApplicationContext();
        AidlUtil.getInstance().connectPrinterService(context);
        scanBarCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(){

                    @Override

                    public void run() {
                        String a = "AAAAA\nAAAAAAAAAAAAAAA\nAAAAAAAAA\nAAAA";
                        byte[] send = a.getBytes();
                        //send = BytesUtil.getBaiduTestBytes();
                        Log.d("TAG", "1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        Log.d("TAG", "2aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        AidlUtil.getInstance().print3Line();
                        Log.d("TAG", "3aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        AidlUtil.getInstance().sendRawData(send);
                        AidlUtil.getInstance().print3Line();
                        AidlUtil.getInstance().print3Line();
                        Log.d("TAG", "4aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                       /* AidlUtil.getInstance().disconnectPrinterService(context);*/
                    }

                }.start();

            }
        });
    }
}
