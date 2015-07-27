package com.datmedia.mediaplayer.androidrequestresponse;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import eneter.messaging.dataprocessing.serializing.ISerializer;
import eneter.messaging.diagnostic.EneterTrace;
import eneter.messaging.endpoints.typedmessages.*;
import eneter.messaging.messagingsystems.messagingsystembase.*;
import eneter.messaging.messagingsystems.tcpmessagingsystem.TcpMessagingSystemFactory;
import eneter.messaging.messagingsystems.websocketmessagingsystem.WebSocketClient;
import eneter.messaging.messagingsystems.websocketmessagingsystem.WebSocketMessage;
import eneter.messaging.messagingsystems.websocketmessagingsystem.WebSocketMessagingSystemFactory;
import eneter.net.system.EventHandler;
import eneter.protobuf.ProtoBufSerializer;

public class MainActivity extends Activity {
    private IDuplexTypedMessageSender<ProtocolBufferEntities.ChatMessage, ProtocolBufferEntities.ChatMessage> mSender;
private WebSocketClient client;
    TextView mNameTextview;
    TextView mMessage;
    Button mBtnSend;
    Button mBtnOpenConnection;
    Button mBtnCloseConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameTextview = (TextView)findViewById(R.id.txtName);
        mBtnSend = (Button)findViewById(R.id.btnSend);
        mMessage = (TextView)findViewById(R.id.txtMessage);
        mBtnOpenConnection = (Button)findViewById(R.id.btnOpenConnection);
        mBtnCloseConnection = (Button)findViewById(R.id.btnCloseConnection);
        mBtnCloseConnection.setEnabled(false);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProtocolBufferEntities.ChatMessage chatMessage = ProtocolBufferEntities.ChatMessage.newBuilder()
                        .setDateTime(System.currentTimeMillis())
                        .setName(mMessage.getText().toString())
                        .setText("hello ")
                        .build();

                try {
                    mSender.sendRequestMessage(chatMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mBtnOpenConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConnection();
                mBtnOpenConnection.setEnabled(false);
                mBtnCloseConnection.setEnabled(true);
            }
        });

        mBtnCloseConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeConnection();
                mBtnOpenConnection.setEnabled(true);
                mBtnCloseConnection.setEnabled(false);
            }
        });


    }

    private void openConnection(){
        if(mSender == null){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ISerializer protoBufSerializer = new ProtoBufSerializer();

                    IDuplexTypedMessagesFactory senderFactory = new DuplexTypedMessagesFactory(protoBufSerializer);

                    mSender = senderFactory.createDuplexTypedMessageSender(ProtocolBufferEntities.ChatMessage.class, ProtocolBufferEntities.ChatMessage.class);
                    mSender.responseReceived().subscribe(mOnResponseHandler);

                    IMessagingSystemFactory messaging = new WebSocketMessagingSystemFactory();
                    try {
                        IDuplexOutputChannel outputChannel = messaging.createDuplexOutputChannel("ws://192.168.15.124:8091/");
                        mSender.attachDuplexOutputChannel(outputChannel);
                    } catch (Exception e) {
                        Log.e("Chen", e.getMessage());
                    }
                }
            }).start();
        }
    }

    private void closeConnection(){
          if(mSender != null){
              mSender.detachDuplexOutputChannel();
          }
    }



    private void onResponseReceived(Object sender, final TypedResponseReceivedEventArgs<ProtocolBufferEntities.ChatMessage> e){

        final ProtocolBufferEntities.ChatMessage response = e.getResponseMessage();
        String lineBreak = System.getProperty("line.separator");

        runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              mNameTextview.setText(response.getName());
                          }
                      }
        );


    }

    private EventHandler<TypedResponseReceivedEventArgs<ProtocolBufferEntities.ChatMessage>> mOnResponseHandler = new EventHandler<TypedResponseReceivedEventArgs<ProtocolBufferEntities.ChatMessage>>() {
        @Override
        public void onEvent(Object o, TypedResponseReceivedEventArgs<ProtocolBufferEntities.ChatMessage> testResponseTypedResponseReceivedEventArgs) {
            onResponseReceived(o,testResponseTypedResponseReceivedEventArgs);

        }
    };

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
