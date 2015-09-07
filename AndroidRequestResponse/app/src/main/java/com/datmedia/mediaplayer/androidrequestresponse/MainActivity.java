package com.datmedia.mediaplayer.androidrequestresponse;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.datmedia.mediaplayer.messages.MessageOuterClass;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


import javax.crypto.NoSuchPaddingException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {
    @Bind(R.id.logRows) TableLayout mLogTable;
    @Bind(R.id.btnEnroll) Button mBtnEnroll;
    @Bind(R.id.txtEnrollmentCode) EditText mTxtEnrollmentCode;
    @Bind(R.id.txtDeviceId) TextView mTextViewDeviceId;
    @Bind(R.id.linerLayoutEnrollmentSuccessful) LinearLayout mLinerLayoutEnrollmentSuccessful;


    EnrollmentClient mEnrollmentClient;
    ClientRequestDispatcher mClientRequestDispatcher;
    ClientCryptoServiceProvider mClientCryptoServiceProvider;
    ILogUpdate mLogUpdate;
    SimpleDateFormat mDateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");
    ArrayList<LogRow> logs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        try {
            mClientCryptoServiceProvider = new ClientCryptoServiceProvider();
        } catch (NoSuchAlgorithmException e) {
            addLog("Error", "MainActivity.onCreate", e.getMessage());
        } catch (NoSuchPaddingException e) {
            addLog("Error", "MainActivity.onCreate", e.getMessage());
        }

        mLogUpdate = new ILogUpdate() {
            @Override
            public void logUpdated(String level, String source, String message) {
              addLog(level, source,  message);
            }
        };

        mClientRequestDispatcher = new ClientRequestDispatcher(mLogUpdate, new IEnrollmentResponse() {
            @Override
            public void enrollmentResponse(MessageOuterClass.Message message) throws Exception {
                mEnrollmentClient.handleEnrollmentResponse(message.getMessageContents().toByteArray());
            }
        });

        mEnrollmentClient = new EnrollmentClient(mClientCryptoServiceProvider, new IEnrollmentRequestCodeReceived() {
            @Override
            public void EnrollmentRequestCodeReceived(final String enrollmentCode) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTxtEnrollmentCode.setText(enrollmentCode);
                    }
                });

            }
        }, mLogUpdate, new IEnrollmentCompleted() {
            @Override
            public void enrollmentCompleted(final int deviceId) {
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         mLinerLayoutEnrollmentSuccessful.setVisibility(View.VISIBLE);
                         mTextViewDeviceId.setText("Device Id: " + deviceId);
                     }
                 });
            }
        }, new ISendMessage() {
            @Override
            public void sendMessage(final MessageOuterClass.Message message) throws Exception {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mClientRequestDispatcher.sendMessage(message);
                        } catch (Exception e) {
                            addLog("Error","ClientRequestDispatcher.sendMessage", e.getMessage());
                        }
                    }
                });

            }
        });
    }

    public void addLog(final String Level,final String source, final String Message){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TableRow row = new TableRow(MainActivity.this);
                row.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                TextView time = new TextView(MainActivity.this);
                time.setText(mDateFormatter.format(Calendar.getInstance().getTime()));
                row.addView(time);

                TextView txtLevel = new TextView(MainActivity.this);
                txtLevel.setText(Level);
                row.addView(txtLevel);

                TextView txtSource = new TextView(MainActivity.this);
                txtSource.setText(source);
                row.addView(txtSource);

                TextView txtMessage = new TextView(MainActivity.this);
                txtMessage.setText(Message);
                row.addView(txtMessage);

                mLogTable.addView(row);
            }
        });
    }

    @OnClick(R.id.btnEnroll)
    public void btnEnrollmentClick(){
        mBtnEnroll.setEnabled(false);
        try {
            mEnrollmentClient.beginEnrollment();
        } catch (Exception e) {
            addLog("Error","mEnrollmentClient.beginEnrollment()", e.getMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
