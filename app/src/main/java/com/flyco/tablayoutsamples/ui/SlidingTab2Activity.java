package com.flyco.tablayoutsamples.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.flyco.tablayout.SlidingTabLayout2;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.flyco.tablayoutsamples.R;
import com.flyco.tablayoutsamples.utils.ViewFindUtils;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class SlidingTab2Activity extends AppCompatActivity implements OnTabSelectListener {
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tab2);

        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }


        View decorView = getWindow().getDecorView();
        ViewPager2 vp = ViewFindUtils.find(decorView, R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(), getLifecycle());
        vp.setAdapter(mAdapter);

        /** 默认 */
//        SlidingTabLayout2 tabLayout_1 = ViewFindUtils.find(decorView, R.id.tl_1);
        /**自定义部分属性*/
        SlidingTabLayout2 tabLayout_2 = ViewFindUtils.find(decorView, R.id.tl_2);
        /** 字体加粗,大写 */
//        SlidingTabLayout2 tabLayout_3 = ViewFindUtils.find(decorView, R.id.tl_3);
//        /** tab固定宽度 */
//        SlidingTabLayout2 tabLayout_4 = ViewFindUtils.find(decorView, R.id.tl_4);
//        /** indicator固定宽度 */
//        SlidingTabLayout2 tabLayout_5 = ViewFindUtils.find(decorView, R.id.tl_5);
//        /** indicator圆 */
//        SlidingTabLayout2 tabLayout_6 = ViewFindUtils.find(decorView, R.id.tl_6);
//        /** indicator矩形圆角 */
//        final SlidingTabLayout2 tabLayout_7 = ViewFindUtils.find(decorView, R.id.tl_7);
//        /** indicator三角形 */
//        SlidingTabLayout2 tabLayout_8 = ViewFindUtils.find(decorView, R.id.tl_8);
//        /** indicator圆角色块 */
//        SlidingTabLayout2 tabLayout_9 = ViewFindUtils.find(decorView, R.id.tl_9);
//        /** indicator圆角色块 */
//        SlidingTabLayout2 tabLayout_10 = ViewFindUtils.find(decorView, R.id.tl_10);

        tabLayout_2.setOnTabSelectListener(this);
        tabLayout_2.setViewPager(vp, mTitles);
        tabLayout_2.showDot(1);
        vp.setCurrentItem(1);
    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragments.size();
        }
    }


}
