package me.free.sticky;

import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.TreeSet;

/**
 * Created by cpf on 2018/1/16.
 */

public class StickyItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 吸附的itemView
     */
    private View mStickyItemView;

    /**
     * 吸附itemView 距离顶部
     */
    private int mStickyItemViewMarginTop;

    /**
     * 吸附itemView 高度
     */
    private int mStickyItemViewHeight;

    /**
     * 通过它获取到需要吸附view的相关信息
     */
    private StickyView mStickyView;

    /**
     * adapter
     */
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    /**
     * viewHolder
     */
    private RecyclerView.ViewHolder mViewHolder;

    /**
     * 存放所有黏性标题坐标的集合
     * 从小到大有序不重复排列
     */
    private TreeSet<Integer> mStickyPositionSet = new TreeSet<>();

    /**
     * layout manager
     */
    private LinearLayoutManager mLayoutManager;

    /**
     * 绑定数据的position
     */
    private int mBindDataPosition = -1;


    public StickyItemDecoration(StickyView stickyView) {
        mStickyView = stickyView;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        getStickyViewHolder(parent);
        if (parent.getAdapter().getItemCount() <= 0) return;

        mLayoutManager = (LinearLayoutManager) parent.getLayoutManager();
        /**
         * 滚动过程中当前的UI是否可以找到吸附的view
         */
        boolean mCurrentUIFindStickView = false;

        for (int m = 0, size = parent.getChildCount(); m < size; m++) {
            //当前item的实际坐标
            int currentPosition = getStickyViewPositionOfRecyclerView(m);
            //如果是吸附的view
            if (mStickyPositionSet.contains(currentPosition)) {
                View view = parent.getChildAt(m);
                mCurrentUIFindStickView = true;

                if (view.getTop() <= 0) {
                    //当前标题没有完全显示，mStickyItemView和可见的第一个标题显示相同
                    bindDataForStickyView(currentPosition, parent.getMeasuredWidth());
                } else {
                    //当前标题完全显示，和上一个标题显示相同
                    bindDataForStickyView(getLastStickyPosition(currentPosition), parent.getMeasuredWidth());
                }

                if (view.getTop() > 0 && view.getTop() <= mStickyItemViewHeight) {
                    mStickyItemViewMarginTop = mStickyItemViewHeight - view.getTop();
                } else {
                    mStickyItemViewMarginTop = 0;

                    View nextStickyView = getNextStickyView(parent);
                    if (nextStickyView != null && nextStickyView.getTop() <= mStickyItemViewHeight) {
                        mStickyItemViewMarginTop = mStickyItemViewHeight - nextStickyView.getTop();
                    }

                }

                drawStickyItemView(c);
                break;
            }
        }

        if (!mCurrentUIFindStickView) {
            mStickyItemViewMarginTop = 0;
            if (mLayoutManager.findFirstVisibleItemPosition() + parent.getChildCount() == parent.getAdapter().getItemCount() && mStickyPositionSet.size() > 0) {
                bindDataForStickyView(mStickyPositionSet.last(), parent.getMeasuredWidth());
            }
            drawStickyItemView(c);
        }
    }

    /**
     * 获取上一个黏性item的位置
     */
    private int getLastStickyPosition(int position) {
        //lower()方法返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null。
        Integer lastStickyPosition = mStickyPositionSet.lower(position);
        if (lastStickyPosition == null) {
            lastStickyPosition = mStickyPositionSet.first();
        }
        return lastStickyPosition;
    }

    /**
     * 得到下一个吸附View
     *
     * @param parent
     * @return
     */
    private View getNextStickyView(RecyclerView parent) {
        int num = 0;
        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
        for (int m = 0, size = parent.getChildCount(); m < size; m++) {
            if (mAdapter.getItemViewType(firstVisibleItemPosition + m) == mStickyView.getStickViewType()) {
                num++;
                if (num == 2) return parent.getChildAt(m);
            }
        }
        return null;
    }

    /**
     * 给StickyView绑定数据
     *
     * @param position
     */
    private void bindDataForStickyView(int position, int width) {
        if (mBindDataPosition == position || mViewHolder == null) return;

        mBindDataPosition = position;
        mAdapter.onBindViewHolder(mViewHolder, mBindDataPosition);
        measureLayoutStickyItemView(width);
        mStickyItemViewHeight = mViewHolder.itemView.getBottom() - mViewHolder.itemView.getTop();
    }

    /**
     * 缓存吸附的view position
     */
    private void cacheStickViewPosition() {
        for (int i = 0; i < mAdapter.getItemCount(); i++) {
            if (mAdapter.getItemViewType(i) == mStickyView.getStickViewType()) {
                mStickyPositionSet.add(i);
            }
        }
    }

    /**
     * 得到吸附view在RecyclerView中 的position
     *
     * @param m
     * @return
     */
    private int getStickyViewPositionOfRecyclerView(int m) {
        return mLayoutManager.findFirstVisibleItemPosition() + m;
    }

    /**
     * 得到吸附viewHolder
     *
     * @param recyclerView
     */
    private void getStickyViewHolder(RecyclerView recyclerView) {
        if (mAdapter != null) return;

        mAdapter = recyclerView.getAdapter();
        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                reset();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                reset();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
                reset();
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                reset();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                reset();
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                reset();
            }
        });
        mViewHolder = mAdapter.onCreateViewHolder(recyclerView, mStickyView.getStickViewType());
        mStickyItemView = mViewHolder.itemView;
    }

    private void reset() {
        mBindDataPosition = -1;
        mStickyPositionSet.clear();
        cacheStickViewPosition();
    }

    /**
     * 计算布局吸附的itemView
     *
     * @param parentWidth
     */
    private void measureLayoutStickyItemView(int parentWidth) {
        if (mStickyItemView == null || !mStickyItemView.isLayoutRequested()) return;

        int widthSpec = View.MeasureSpec.makeMeasureSpec(parentWidth, View.MeasureSpec.EXACTLY);
        int heightSpec;

        ViewGroup.LayoutParams layoutParams = mStickyItemView.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            heightSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, View.MeasureSpec.EXACTLY);
        } else {
            heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }

        mStickyItemView.measure(widthSpec, heightSpec);
        mStickyItemView.layout(0, 0, mStickyItemView.getMeasuredWidth(), mStickyItemView.getMeasuredHeight());
    }

    /**
     * 绘制吸附的itemView
     *
     * @param canvas
     */
    private void drawStickyItemView(Canvas canvas) {
        if (mStickyItemView == null) return;

        int saveCount = canvas.save();
        canvas.translate(0, -mStickyItemViewMarginTop);
        mStickyItemView.draw(canvas);
        canvas.restoreToCount(saveCount);
    }
}
