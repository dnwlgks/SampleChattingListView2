package com.example.user.samplechattinglistview;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 2016-07-22.
 */
public class ChatItemView extends LinearLayout {

    TextView messageView;

    public ChatItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.chat_view, this);
        messageView = (TextView) findViewById(R.id.messageView);

    }

    public void setMessageView(String message) {
        messageView.setText(message);
    }
}
