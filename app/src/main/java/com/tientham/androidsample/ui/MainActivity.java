package com.tientham.androidsample.ui;

import android.os.Bundle;
import android.widget.Button;

import com.tientham.androidsample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_start)
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start)
    void navigateToTodoList() {
        this.navigator.navigateToTodoList(this);
    }
}
