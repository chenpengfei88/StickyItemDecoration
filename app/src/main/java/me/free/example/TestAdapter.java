package me.free.example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpf on 2018/1/16.
 */

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context context;

    public List<Test> testList = new ArrayList<>();

    public TestAdapter(Context context) {
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 10) {
            return new TestOneVH(LayoutInflater.from(context).inflate(R.layout.adapter_test_one, parent, false));
        }
        return new TestTwoVH(LayoutInflater.from(context).inflate(R.layout.adapter_test_two, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Test test = testList.get(position);
        if (holder instanceof TestOneVH) {
            ((TestOneVH) holder).bindData(test);
        }
        if (holder instanceof TestTwoVH) {
            ((TestTwoVH) holder).bindData(test);
        }
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return testList.get(position).viewType;
    }


    static class TestTwoVH extends RecyclerView.ViewHolder {

        TextView mTv;

        public TestTwoVH(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.text);
            itemView.setTag(true);
        }

        public void bindData(Test test) {
            mTv.setText(test.content);
        }

    }

    static class TestOneVH extends RecyclerView.ViewHolder {

        TextView mTv;

        public TestOneVH(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.text);
            itemView.setTag(false);
        }

        public void bindData(Test test) {
            mTv.setText(test.content);
        }

    }
}
