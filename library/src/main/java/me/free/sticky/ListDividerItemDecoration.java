package me.free.sticky;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/1/11.
 */

public class ListDividerItemDecoration extends RecyclerView.ItemDecoration  {

    /**
     * paint
     */
    private Paint mPaint;

    int height;

    Bitmap newBitmap;

    int top = 0;


    boolean first=false, move=true, shang=true;

    private List<Integer> integers = new ArrayList<>();

    View gView;

    RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;

    RecyclerView.ViewHolder rv;

    int resutl = 0;

    int p=-1;

    boolean find;

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    private int getCurrent(int fistVisibleItem, int m) {
        return fistVisibleItem + m;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        initPaint();

        find = false;

        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) parent.getLayoutManager();
        parent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0) {
                    shang = true;
                }else{
                    shang = false;
                }
            }
        });
        for (int m = 0, size = parent.getChildCount(); m < size; m++) {
            View view = parent.getChildAt(m);
            if (gView != null) {
                //gView.layout(0, -top, gView.getMeasuredWidth(), gView.getMeasuredHeight());
              //  ensurePinnedHeaderLayout(gView,parent.getMeasuredWidth(),c);
            }
            if (((Boolean) view.getTag())) {
                find = true;
                height = view.getBottom() - view.getTop();

                if (gView == null) {
                    adapter = parent.getAdapter();
                    rv = adapter.onCreateViewHolder(parent, 11);
                    gView = rv.itemView;
                 //   parent.addView(gView);
                }

                int current = getCurrent(linearLayoutManager.findFirstVisibleItemPosition(), m);
                if (!integers.contains(current)) {
                    integers.add(current);
                    p = p+1;
                    move = false;
                }

                if (view.getTop() <= 0) {
                    if (shang) {
                        adapter.onBindViewHolder(rv, linearLayoutManager.findFirstVisibleItemPosition());
                    } else {
                      //  if (integers.size()>0) adapter.onBindViewHolder(rv, integers.get(p));
                        adapter.onBindViewHolder(rv, linearLayoutManager.findFirstVisibleItemPosition());
                    }

//                    if (!integers.contains(linearLayoutManager.findFirstVisibleItemPosition())) {
//                        integers.add(linearLayoutManager.findFirstVisibleItemPosition());
//                        p = p+1;
//                        move = false;
//                    }
                    first = true;
                    resutl = 1;
                   // top = 0;
                } else {
                    if (!move && integers.size() > 1) {
                     //   integers.remove(integers.size()-1);
                        move = true;
                    }
                    if (integers.size()>0) {
                        if(integers.size() == 1) {
                            adapter.onBindViewHolder(rv, integers.get(shang ? 0 :0));
                        } else {
                            int currenthh = getCurrent(linearLayoutManager.findFirstVisibleItemPosition(), m);
                            int pso = integers.lastIndexOf(currenthh);
                            adapter.onBindViewHolder(rv, integers.get(pso - 1));
                        }
                    }
                }

                if (view.getTop() >= 0 && view.getTop() <=height) {
                    resutl = 2;
                    top = height - view.getTop();
                  //  break;
                } else {
                    top = 0;
                }
                if (gView != null) {
                    //gView.layout(0, -top, gView.getMeasuredWidth(), gView.getMeasuredHeight());
                    ensurePinnedHeaderLayout(gView,parent.getMeasuredWidth(),c);
                }
                break;
            }
        }
 //       System.out.println("==========parent.getLayoutManager().getChildCount()================"+parent.getLayoutManager().getChildCount());
        if (!find) {
            top = 0;
            if (linearLayoutManager.findFirstVisibleItemPosition() + parent.getChildCount() == parent.getAdapter().getItemCount()) {
                adapter.onBindViewHolder(rv, integers.get(integers.size() - 1));
                ensurePinnedHeaderLayout(gView,parent.getMeasuredWidth(), c);
            }
        }
    }

    private Bitmap getBgBmp(View itemView) {
        itemView.setDrawingCacheEnabled(true);
        Bitmap bitmap = itemView.getDrawingCache();
        return bitmap;
    }

    private void ensurePinnedHeaderLayout(View header, int width, Canvas canvas) {
       // if (header.isLayoutRequested()) {
            int widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);

            int heightSpec;
            ViewGroup.LayoutParams layoutParams = header.getLayoutParams();
            if (layoutParams != null && layoutParams.height > 0) {
                heightSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, View.MeasureSpec.EXACTLY);
            } else {
                heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            }
            header.measure(widthSpec, heightSpec);
            header.layout(0, 0, header.getMeasuredWidth(), header.getMeasuredHeight());
     //   }

        int saveCount = canvas.save();
        canvas.translate(0, -top);
        header.draw(canvas);
        canvas.restoreToCount(saveCount);
    }
}
