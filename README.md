# AndroidEasyMVP
Android 快速MVP开发框架  只是自己练手 和开发用的
   
 # 使用
 ```
      //单选多选框
     
                 SelectDialog.Builder builder = new SelectDialog.Builder(getContext());
                 builder.setList("星期一", "星期二", "星期三", "星期四", "星期五");
                 builder.setMaxSelect(3);
                 builder.setSelect(2, 3, 4);
                 builder.setListener(new SelectDialog.OnListener<String>() {
                     @Override
                     public void onSelected(BaseDialog dialog, HashMap data) {
                         HashMap<Integer, Object> map = data;
                         for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                             System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                             Log.d("ssss", "key= " + entry.getKey() + " and value= " + entry.getValue());
                         }
                     }
     
                     @Override
                     public void onCancel(BaseDialog dialog) {
     
                     }
                 });
                 builder.show();

```
 
 ```
            //网络请求
            RetrofitFactory.getInstance()
                    .create(Api.class)
                    .getChapters()
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<BaseResponse<Object>>() {
                        @Override
                        public void onCompleted() {
                            Log.d("ssss", "onCompleted: ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("ssss", "e"+e.getMessage());
                        }

                        @Override
                        public void onNext(BaseResponse<Object> objectBaseResponse) {
                            Log.d("ssss", "onCompleted:ww ");
                        }
                    });


        Rx2
                
                 RetrofitFactory.getInstance()
                                .create(ApiService.class)
                                .getArticleList(page)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<BaseResponse<ArticleListBean>>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                
                                    }
                
                                    @Override
                                    public void onNext(BaseResponse<ArticleListBean> articleListBeanBaseResponse) {
                
                                    }
                
                                    @Override
                                    public void onError(Throwable e) {
                
                                    }
                
                                    @Override
                                    public void onComplete() {
                
                                    }
                                });
```

```
                //隐私协议弹框
               PrivacyDialog.Builder builder  = new PrivacyDialog.Builder(getContext());
                    builder.setOnClickListener(new PrivacyDialog.Builder.OnClickListener() {
                        @Override
                        public void OnClickOkListener(View view) {
                            ToastUtils.show("okokokok");
                        }
        
                        @Override
                        public void OnClickCancelListener(View view) {
                            ToastUtils.show("cancelcancel");
                        }
                    });
                    builder.show();
                    startActivity(TestActivity.class);

```