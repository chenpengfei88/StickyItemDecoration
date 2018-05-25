package me.free.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.free.sticky.StickyItemDecoration;

/**
 *  cpf
 */

public class MainActivity extends AppCompatActivity {

    /**
     *  recyclerView
     */
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new StickyItemDecoration());
        mRecyclerView.addItemDecoration(new ListDividerItemDecoration());
        mRecyclerView.setAdapter(new PerformerListAdapter(this, getData()));
    }

    private List<Performer> getData() {
        List<Performer> performers = new ArrayList<>();

//        Performer performer = new Performer("香港明星");
//        performers.add(performer);
//
//        Performer ldh = new Performer("刘德华", 10);
//        performers.add(ldh);
//        Performer zxy = new Performer("张学友", 10);
//        performers.add(zxy);
//        Performer zrf = new Performer("周润发", 10);
//        performers.add(zrf);
//        Performer lcw = new Performer("梁朝伟", 10);
//        performers.add(lcw);
//        Performer wyj = new Performer("吴毅将", 10);
//        performers.add(wyj);
//        Performer lm = new Performer("黎明", 10);
//        performers.add(lm);
//        Performer cgx = new Performer("陈冠希", 10);
//        performers.add(cgx);
//        Performer gfc = new Performer("郭富城", 10);
//        performers.add(gfc);
//        Performer xtf = new Performer("谢霆锋", 10);
//        performers.add(xtf);
//
//        Performer performerTw = new Performer("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
//        performers.add(performerTw);
//
//        Performer rxq = new Performer("任贤齐", 10);
//        performers.add(rxq);
//        Performer mtw = new Performer("孟庭苇", 10);
//        performers.add(mtw);
//        Performer ldy = new Performer("罗大佑", 10);
//        performers.add(ldy);
//        Performer lzs = new Performer("李宗盛", 10);
//        performers.add(lzs);
//        Performer xc = new Performer("小虫", 10);
//        performers.add(xc);
//        Performer zhj = new Performer("周华健", 10);
//        performers.add(zhj);
//        Performer zhl = new Performer("周杰伦", 10);
//        performers.add(zhl);
//
//        Performer performerNl = new Performer("内陆明星");
//        performers.add(performerNl);
//
//        Performer lh = new Performer("鹿晗", 10);
//        performers.add(lh);
//        Performer wzw = new Performer("王志文", 10);
//        performers.add(wzw);
//        Performer yq = new Performer("羽泉", 10);
//        performers.add(yq);
//        Performer lxl = new Performer("李小璐", 10);
//        performers.add(lxl);
//        Performer hh = new Performer("韩红", 10);
//        performers.add(hh);
//        Performer ny = new Performer("那英", 10);
//        performers.add(ny);
//        Performer lhh = new Performer("刘欢", 10);
//        performers.add(lhh);
//        Performer yk = new Performer("杨坤", 10);
//        performers.add(yk);
//        Performer zj = new Performer("周杰", 10);
//        performers.add(zj);
//
//        Performer performerOm = new Performer("美国明星");
//        performers.add(performerOm);
//        Performer mm = new Performer("梅梅", 10);
//        performers.add(mm);
//        Performer ade = new Performer("Gaga", 10);
//        performers.add(ade);
//        Performer hff = new Performer("黑寡妇", 10);
//        performers.add(hff);
//        Performer xlz = new Performer("小李子", 10);
//        performers.add(xlz);
//
//        Performer performerNba = new Performer("NBA明星");
//        performers.add(performerNba);
//        Performer xhd = new Performer("小皇帝", 10);
//        performers.add(xhd);
//        Performer kb = new Performer("科比", 10);
//        performers.add(kb);
//        Performer ym = new Performer("姚明", 10);
//        performers.add(ym);
//        Performer md = new Performer("麦迪", 10);
//        performers.add(md);
//        Performer dlt = new Performer("杜兰特", 10);
//        performers.add(dlt);
//        Performer kl = new Performer("库里", 10);
//        performers.add(kl);
//        Performer ouw = new Performer("欧文", 10);
//        performers.add(ouw);
//        Performer qd = new Performer("乔丹", 10);
//        performers.add(qd);
//        Performer alzw = new Performer("奥拉朱旺", 10);
//        performers.add(alzw);
//        Performer pp = new Performer("皮蓬", 10);
//        performers.add(pp);
//        Performer ldm = new Performer("罗德曼", 10);
//        performers.add(ldm);
//        Performer ke = new Performer("科尔", 10);
//        performers.add(ke);
//        Performer pesi = new Performer("皮尔斯", 10);
//        performers.add(pesi);
//        Performer jnt = new Performer("加内特", 10);
//        performers.add(jnt);
//        Performer lal = new Performer("雷阿伦", 10);
//        performers.add(lal);
//        Performer zmg = new Performer("字母哥", 10);
//        performers.add(zmg);
//        Performer adn = new Performer("安东尼", 10);
//        performers.add(adn);
//
//        Performer performerDy = new Performer("导演");
//        performers.add(performerDy);
//        Performer jzk = new Performer("贾樟柯", 10);
//        performers.add(jzk);
//        Performer ly = new Performer("李杨", 10);
//        performers.add(ly);
//        Performer fxg = new Performer("冯小刚", 10);
//        performers.add(fxg);
//        Performer lyy = new Performer("娄烨", 10);
//        performers.add(lyy);
//        Performer zym = new Performer("张艺谋", 10);
//        performers.add(zym);


        Performer performer = new Performer("香港明星");
        performers.add(performer);

        Performer ldh = new Performer("刘德华", 10);
        performers.add(ldh);
        Performer zxy = new Performer("张学友", 10);
        performers.add(zxy);
        Performer zrf = new Performer("周润发", 10);
        performers.add(zrf);
        Performer lcw = new Performer("梁朝伟", 10);
        performers.add(lcw);
        Performer wyj = new Performer("吴毅将", 10);
        performers.add(wyj);
        Performer lm = new Performer("黎明", 10);
        performers.add(lm);
        Performer cgx = new Performer("陈冠希", 10);
        performers.add(cgx);
        Performer gfc = new Performer("郭富城", 10);
        performers.add(gfc);
        Performer xtf = new Performer("谢霆锋", 10);
        performers.add(xtf);

        Performer performerTw = new Performer("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
        performers.add(performerTw);

        Performer rxq = new Performer("任贤齐", 10);
        performers.add(rxq);
        Performer mtw = new Performer("孟庭苇", 10);
        performers.add(mtw);

        Performer performerTw2 = new Performer("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
        performers.add(performerTw2);

        Performer rxq2 = new Performer("罗志祥", 10);
        performers.add(rxq2);

        Performer performerTw3 = new Performer("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
        performers.add(performerTw3);

        Performer rxq3 = new Performer("李宗盛", 10);
        performers.add(rxq3);

        Performer performerNl = new Performer("内陆明星");
        performers.add(performerNl);

        Performer lh = new Performer("鹿晗", 10);
        performers.add(lh);
        Performer wzw = new Performer("王志文", 10);
        performers.add(wzw);
        Performer yq = new Performer("羽泉", 10);
        performers.add(yq);
        Performer lxl = new Performer("李小璐", 10);
        performers.add(lxl);
        Performer hh = new Performer("韩红", 10);
        performers.add(hh);
        Performer ny = new Performer("那英", 10);
        performers.add(ny);
        Performer lhh = new Performer("刘欢", 10);
        performers.add(lhh);
        Performer yk = new Performer("杨坤", 10);
        performers.add(yk);
        Performer zj = new Performer("周杰", 10);
        performers.add(zj);

        Performer performerOm = new Performer("美国明星");
        performers.add(performerOm);
        Performer mm = new Performer("梅梅", 10);
        performers.add(mm);
        Performer ade = new Performer("Gaga", 10);
        performers.add(ade);
        Performer hff = new Performer("黑寡妇", 10);
        performers.add(hff);
        Performer xlz = new Performer("小李子", 10);
        performers.add(xlz);

        Performer performerNba = new Performer("NBA明星");
        performers.add(performerNba);
        Performer xhd = new Performer("小皇帝", 10);
        performers.add(xhd);
        Performer kb = new Performer("科比", 10);
        performers.add(kb);
        Performer ym = new Performer("姚明", 10);
        performers.add(ym);
        Performer md = new Performer("麦迪", 10);
        performers.add(md);
        Performer dlt = new Performer("杜兰特", 10);
        performers.add(dlt);
        Performer kl = new Performer("库里", 10);
        performers.add(kl);
        Performer ouw = new Performer("欧文", 10);
        performers.add(ouw);
        Performer qd = new Performer("乔丹", 10);
        performers.add(qd);
        Performer alzw = new Performer("奥拉朱旺", 10);
        performers.add(alzw);
        Performer pp = new Performer("皮蓬", 10);
        performers.add(pp);
        Performer ldm = new Performer("罗德曼", 10);
        performers.add(ldm);
        Performer ke = new Performer("科尔", 10);
        performers.add(ke);
        Performer pesi = new Performer("皮尔斯", 10);
        performers.add(pesi);
        Performer jnt = new Performer("加内特", 10);
        performers.add(jnt);
        Performer lal = new Performer("雷阿伦", 10);
        performers.add(lal);
        Performer zmg = new Performer("字母哥", 10);
        performers.add(zmg);
        Performer adn = new Performer("安东尼", 10);
        performers.add(adn);

        Performer performerDy = new Performer("导演");
        performers.add(performerDy);
        Performer jzk = new Performer("贾樟柯", 10);
        performers.add(jzk);
        Performer ly = new Performer("李杨", 10);
        performers.add(ly);
        Performer fxg = new Performer("冯小刚", 10);
        performers.add(fxg);
        Performer lyy = new Performer("娄烨", 10);
        performers.add(lyy);
        Performer zym = new Performer("张艺谋", 10);
        performers.add(zym);

        return performers;
    }

}
