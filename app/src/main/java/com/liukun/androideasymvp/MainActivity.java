package com.liukun.androideasymvp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RetrofitFactory.getInstance().create(Api.class)
//                .getChapters()
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BaseSubscriber<Object>(MainActivity.this) {
//                    @Override
//                    public void onSuccess(BaseResponse<Object> baseResponse) {
////                        Log.d("MainActivityTAG", "onSuccess: " + baseResponse.getData().toString());
//
//                    }
//
//                    @Override
//                    public void onCodeError(BaseResponse baseResponse) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Throwable e, String message) {
//
//                    }
//                });


    }
}