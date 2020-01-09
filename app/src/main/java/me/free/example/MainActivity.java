package me.free.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.free.sticky.StickyItemDecoration;

/**
 * cpf
 */

public class MainActivity extends AppCompatActivity {

    /**
     * recyclerView
     */
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new StickyItemDecoration(Performer.TYPE_TITLE));
        mRecyclerView.addItemDecoration(new ListDividerItemDecoration());
        mRecyclerView.setAdapter(new PerformerListAdapter(this, getData()));
    }

    private List<Performer> getData() {
        List<Performer> performers = new ArrayList<>();

        Performer performer = new Performer("香港明星");
        performers.add(performer);

        Performer ldh = new Performer("刘德华", Performer.TYPE_CONTENT);
        performers.add(ldh);
        Performer zxy = new Performer("张学友", Performer.TYPE_CONTENT);
        performers.add(zxy);
        Performer zrf = new Performer("周润发", Performer.TYPE_CONTENT);
        performers.add(zrf);
        Performer lcw = new Performer("梁朝伟", Performer.TYPE_CONTENT);
        performers.add(lcw);
        Performer wyj = new Performer("吴毅将", Performer.TYPE_CONTENT);
        performers.add(wyj);
        Performer lm = new Performer("黎明", Performer.TYPE_CONTENT);
        performers.add(lm);
        Performer cgx = new Performer("陈冠希", Performer.TYPE_CONTENT);
        performers.add(cgx);
        Performer gfc = new Performer("郭富城", Performer.TYPE_CONTENT);
        performers.add(gfc);
        Performer xtf = new Performer("谢霆锋", Performer.TYPE_CONTENT);
        performers.add(xtf);

        Performer performerTw = new Performer("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
        performers.add(performerTw);

        Performer rxq = new Performer("任贤齐", Performer.TYPE_CONTENT);
        performers.add(rxq);
        Performer mtw = new Performer("孟庭苇", Performer.TYPE_CONTENT);
        performers.add(mtw);

        Performer performerTw2 = new Performer("台湾新生代明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
        performers.add(performerTw2);

        Performer rxq2 = new Performer("罗志祥", Performer.TYPE_CONTENT);
        performers.add(rxq2);

        Performer performerTw3 = new Performer("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
        performers.add(performerTw3);

        Performer rxq3 = new Performer("李宗盛", Performer.TYPE_CONTENT);
        performers.add(rxq3);

        Performer performerNl = new Performer("内陆明星");
        performers.add(performerNl);

        Performer lh = new Performer("鹿晗", Performer.TYPE_CONTENT);
        performers.add(lh);
        Performer wzw = new Performer("王志文", Performer.TYPE_CONTENT);
        performers.add(wzw);
        Performer yq = new Performer("羽泉", Performer.TYPE_CONTENT);
        performers.add(yq);
        Performer lxl = new Performer("李小璐", Performer.TYPE_CONTENT);
        performers.add(lxl);
        Performer hh = new Performer("韩红", Performer.TYPE_CONTENT);
        performers.add(hh);
        Performer ny = new Performer("那英", Performer.TYPE_CONTENT);
        performers.add(ny);
        Performer lhh = new Performer("刘欢", Performer.TYPE_CONTENT);
        performers.add(lhh);
        Performer yk = new Performer("杨坤", Performer.TYPE_CONTENT);
        performers.add(yk);
        Performer zj = new Performer("周杰", Performer.TYPE_CONTENT);
        performers.add(zj);

        Performer performerOm = new Performer("美国明星");
        performers.add(performerOm);
        Performer mm = new Performer("梅梅", Performer.TYPE_CONTENT);
        performers.add(mm);
        Performer ade = new Performer("Gaga", Performer.TYPE_CONTENT);
        performers.add(ade);
        Performer hff = new Performer("黑寡妇", Performer.TYPE_CONTENT);
        performers.add(hff);
        Performer xlz = new Performer("小李子", Performer.TYPE_CONTENT);
        performers.add(xlz);

        Performer performerNba = new Performer("NBA明星");
        performers.add(performerNba);
        Performer xhd = new Performer("小皇帝", Performer.TYPE_CONTENT);
        performers.add(xhd);
        Performer kb = new Performer("科比", Performer.TYPE_CONTENT);
        performers.add(kb);
        Performer ym = new Performer("姚明", Performer.TYPE_CONTENT);
        performers.add(ym);
        Performer md = new Performer("麦迪", Performer.TYPE_CONTENT);
        performers.add(md);
        Performer dlt = new Performer("杜兰特", Performer.TYPE_CONTENT);
        performers.add(dlt);
        Performer kl = new Performer("库里", Performer.TYPE_CONTENT);
        performers.add(kl);
        Performer ouw = new Performer("欧文", Performer.TYPE_CONTENT);
        performers.add(ouw);
        Performer qd = new Performer("乔丹", Performer.TYPE_CONTENT);
        performers.add(qd);
        Performer alzw = new Performer("奥拉朱旺", Performer.TYPE_CONTENT);
        performers.add(alzw);
        Performer pp = new Performer("皮蓬", Performer.TYPE_CONTENT);
        performers.add(pp);
        Performer ldm = new Performer("罗德曼", Performer.TYPE_CONTENT);
        performers.add(ldm);
        Performer ke = new Performer("科尔", Performer.TYPE_CONTENT);
        performers.add(ke);
        Performer pesi = new Performer("皮尔斯", Performer.TYPE_CONTENT);
        performers.add(pesi);
        Performer jnt = new Performer("加内特", Performer.TYPE_CONTENT);
        performers.add(jnt);
        Performer lal = new Performer("雷阿伦", Performer.TYPE_CONTENT);
        performers.add(lal);
        Performer zmg = new Performer("字母哥", Performer.TYPE_CONTENT);
        performers.add(zmg);
        Performer adn = new Performer("安东尼", Performer.TYPE_CONTENT);
        performers.add(adn);

        Performer performerDy = new Performer("导演");
        performers.add(performerDy);
        Performer jzk = new Performer("贾樟柯", Performer.TYPE_CONTENT);
        performers.add(jzk);
        Performer ly = new Performer("李杨", Performer.TYPE_CONTENT);
        performers.add(ly);
        Performer fxg = new Performer("冯小刚", Performer.TYPE_CONTENT);
        performers.add(fxg);
        Performer lyy = new Performer("娄烨", Performer.TYPE_CONTENT);
        performers.add(lyy);
        Performer zym = new Performer("张艺谋", Performer.TYPE_CONTENT);
        performers.add(zym);


        return performers;
    }

}
