package com.liukun.androideasymvp.ui.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.hjq.toast.ToastUtils;
import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.commom.BaseAdapter;
import com.liukun.androideasymvp.commom.ViewHolder;
import com.liukun.base.BaseDialog;
import com.liukun.base.action.AnimAction;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 *
 *  单选或者多选对话框
 */
public final class SelectDialog {

    public static final class Builder
            extends BaseDialog.Builder<Builder> {

        private OnListener mListener;

        private final SelectAdapter mAdapter;

        private Button btnOk;
        private Button btnCancel;

        public Builder(Context context) {
            super(context);
            setContentView(R.layout.dialog_select);
            RecyclerView recyclerView = findViewById(R.id.rv_select_list);
            btnOk = findViewById(R.id.btn_ok);
            btnCancel = findViewById(R.id.btn_cancel);
            setAnimStyle(AnimAction.BOTTOM);
            setGravity(Gravity.BOTTOM);
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            mAdapter = new SelectAdapter(R.layout.item_select, null);
            recyclerView.setAdapter(mAdapter);

            btnOk.setOnClickListener(v -> {
                HashMap<Integer, Object> data = mAdapter.getSelectSet();
                if (data.size() >= mAdapter.getMinSelect()) {
                    dismiss();
                    if (mListener != null) {
                        mListener.onSelected(getDialog(), data);
                    }
                } else {
                    ToastUtils.show(String.format(getString(R.string.select_min_hint), mAdapter.getMinSelect()));
                }
            });

            btnCancel.setOnClickListener(v -> {
                dismiss();
                if (mListener != null) {
                    mListener.onCancel(getDialog());
                }
            });
        }

        public Builder setList(int... ids) {
            List<String> data = new ArrayList<>(ids.length);
            for (int id : ids) {
                data.add(getString(id));
            }
            return setList(data);
        }

        public Builder setList(String... data) {
            return setList(Arrays.asList(data));
        }

        @SuppressWarnings("all")
        public Builder setList(List data) {
            Log.d("22222", "setList: "+data.get(0));
            mAdapter.setList(data);
            return this;
        }

        /**
         * 设置默认选中的位置
         */
        public Builder setSelect(int... positions) {
            mAdapter.setSelect(positions);
            return this;
        }

        /**
         * 设置最大选择数量
         */
        public Builder setMaxSelect(int count) {
            mAdapter.setMaxSelect(count);
            return this;
        }

        /**
         * 设置最小选择数量
         */
        public Builder setMinSelect(int count) {
            mAdapter.setMinSelect(count);
            return this;
        }

        /**
         * 设置单选模式
         */
        public Builder setSingleSelect() {
            mAdapter.setSingleSelect();
            return this;
        }

        public Builder setListener(OnListener listener) {
            mListener = listener;
            return this;
        }

    }


    public static final class SelectAdapter extends BaseAdapter<String> implements
            OnItemClickListener {
        /**
         * 最小选择数量
         */
        private int mMinSelect = 1;
        /**
         * 最大选择数量
         */
        private int mMaxSelect = Integer.MAX_VALUE;

        /**
         * 选择对象集合
         */
        @SuppressLint("UseSparseArrays")
        private final HashMap<Integer, Object> mSelectSet = new HashMap<>();

        public SelectAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
            setOnItemClickListener(this);
        }

        public SelectAdapter(int layoutResId, @Nullable List<String> data, boolean showEmpty) {
            super(layoutResId, data, showEmpty);
        }



        @Override
        public void onBindViewHolder(@NotNull ViewHolder holder, int position, @NotNull List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);
            TextView textView = holder.itemView.findViewById(R.id.tv_select_text);
            CheckBox mCheckBox = (CheckBox) holder.itemView.findViewById(R.id.tv_select_checkbox);
            textView.setText(getItem(position).toString());
            mCheckBox.setChecked(mSelectSet.containsKey(position));

        }

        private void setSelect(int... positions) {
            for (int position : positions) {
                mSelectSet.put(position, getItem(position));
            }
            notifyDataSetChanged();
        }

        private void setMaxSelect(int count) {
            mMaxSelect = count;
        }

        private void setMinSelect(int count) {
            mMinSelect = count;
        }

        private int getMinSelect() {
            return mMinSelect;
        }

        private void setSingleSelect() {
            setMaxSelect(1);
            setMinSelect(1);
        }

        private boolean isSingleSelect() {
            return mMaxSelect == 1 && mMinSelect == 1;
        }

        private HashMap<Integer, Object> getSelectSet() {
            return mSelectSet;
        }

        @Override
        public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {

            if (mSelectSet.containsKey(position)) {
                // 当前必须不是单选模式才能取消选中
                if (!isSingleSelect()) {
                    mSelectSet.remove(position);
                    notifyItemChanged(position);
                }
            } else {
                if (mMaxSelect == 1) {
                    mSelectSet.clear();
                    notifyDataSetChanged();
                }

                if (mSelectSet.size() < mMaxSelect) {
                    mSelectSet.put(position, getItem(position));
                    notifyItemChanged(position);
                } else {
                    ToastUtils.show(String.format(getRecyclerView().getContext()
                            .getString(R.string.select_max_hint), mMaxSelect));
                }
            }
        }
        @Override
        public void bind(ViewHolder holder, String item) {

        }
    }


    public interface OnListener<T> {

        /**
         * 选择回调
         *
         * @param data 选择的位置和数据
         */
        void onSelected(BaseDialog dialog, HashMap<Integer, T> data);

        /**
         * 取消回调
         */
        default void onCancel(BaseDialog dialog) {
        }
    }
}