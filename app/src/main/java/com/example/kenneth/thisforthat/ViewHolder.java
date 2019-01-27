package com.example.kenneth.thisforthat;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ViewHolder {

    private TextView textView, textView1;
    private CheckBox checkBox;
    public View base;

    public ViewHolder(View base){
        this.base = base;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public TextView getTextView1() {
        return textView1;
    }

    public void setTextView1(TextView textView1) {
        this.textView1 = textView1;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
