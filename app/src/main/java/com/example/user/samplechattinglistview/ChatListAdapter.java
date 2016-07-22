package com.example.user.samplechattinglistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016-07-22.
 */
public class ChatListAdapter extends BaseAdapter {

    List<String> items = new ArrayList<>();

    public void add(String message) {
        items.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // position 몆번째 아이템(뷰)이냐?,
        // convertview -내가 이전에 보고 지나간 view
        // parent-컨텍스트를 가져오기 위한 객체(parent.getContext())
        ChatItemView view = null;
        if (convertView != null) {//convertview!=null이면 내가 봤던 뷰가 들어옴
            view = (ChatItemView) convertView;
        } else {
            view = new ChatItemView(parent.getContext());
        }
        //뷰에 데이터를 세팅
        view.setMessageView(items.get(position));
        //리턴 해주면서 실질적으로 출력
        return view;
    }
}
