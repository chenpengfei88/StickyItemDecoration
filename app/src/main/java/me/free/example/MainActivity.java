package me.free.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.free.sticky.StickyItemDecoration;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Test> testList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestAdapter testAdapter = new TestAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new StickyItemDecoration());
        recyclerView.setAdapter(testAdapter);

        Test test = new Test();
        test.content = "测试数据我测试One";
        test.viewType = 11;
        testList.add(test);

        addTestContent();

        Test testTwo = new Test();
        testTwo.content = "测试Two";
        testTwo.viewType = 11;
        testList.add(testTwo);

        addTestContent();

        Test testThree = new Test();
        testThree.content = "测试Three";
        testThree.viewType = 11;
        testList.add(testThree);

        addTestContent();

        Test testFour = new Test();
        testFour.content = "测试Four";
        testFour.viewType = 11;
        testList.add(testFour);

        addTestContent();

        testAdapter.testList = testList;
        testAdapter.notifyDataSetChanged();
    }

    private void addTestContent() {
        for (int i = 0; i < 10; i++) {
            Test test = new Test();
            test.content = "测试内容："+i;
            test.viewType = 10;
            testList.add(test);
        }
    }
}
