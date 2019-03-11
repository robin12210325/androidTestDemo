package com.yongxingg.mydemo.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.yongxingg.mydemo.R;
import com.yongxingg.mydemo.UI.androidUI.AndroidFragment;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BottomNavigationActivity extends AppCompatActivity {
    private List<Fragment> fragmentList;
    private List<Integer> iconList;
    private Integer[] bottomTabIcon = {R.mipmap.home,R.mipmap.home,R.mipmap.home,R.mipmap.home};
    private List<Integer> iconPressList;
    private Integer[] bottomIconPress = {R.mipmap.home_press,R.mipmap.home_press,
            R.mipmap.home_press,R.mipmap.home_press};
    private WeakReference<FragmentTransaction> ft;
    private Integer pos_tab = null;

    private static boolean enableExit = false;
//    private static MyHandler myHandler = new MyHandler();

//    @BindView(R.id.bottom_tab_layout)
    TabLayout bottmeTab;


    DrawerLayout drawerLayout;

    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        bottmeTab = (TabLayout) findViewById(R.id.bottom_tab_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_left);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        initView();
    }
    public View getTabView(String title, int image_src) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_item_view, null);
        TextView textView = (TextView) v.findViewById(R.id.textview);
        textView.setText(title);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageview);
        imageView.setImageResource(image_src);
        return v;
    }
    private void initView() {
        iconList = Arrays.asList(bottomTabIcon);
        iconPressList = Arrays.asList(bottomIconPress);
        fragmentList = new ArrayList<>();
        fragmentList.add(new WeakReference<>(AndroidFragment.newInstance("android")).get());
        fragmentList.add(new WeakReference<>(BaseFragment.newInstance("发现")).get());
        fragmentList.add(new WeakReference<>(BaseFragment.newInstance("个人")).get());
        fragmentList.add(new WeakReference<>(BaseFragment.newInstance("我")).get());

        bottmeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ft = new WeakReference<>(getSupportFragmentManager().beginTransaction());
                if(pos_tab != null) {
                    bottmeTab.getTabAt(pos_tab).setIcon(iconList.get(pos_tab));
                    Fragment preFragment = fragmentList.get(pos_tab);
                    Fragment fragment = fragmentList.get(tab.getPosition());
                    if(fragment.isAdded()) {
                        ft.get().hide(preFragment).show(fragment).commit();
                    }else {
                        ft.get().hide(preFragment)
                                .add(R.id.fragment_content,fragment).commit();
                    }
                }else {
                    ft.get().add(R.id.fragment_content,fragmentList.get(0))
                            .commit();
                }
                pos_tab = tab.getPosition();
                bottmeTab.getTabAt(pos_tab).setIcon(iconPressList.get(pos_tab));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.home).setText("首页"));
        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.home).setText("关注"));
        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.home).setText("好友"));
        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.home).setText("我"));

        bottmeTab.getTabAt(0).setCustomView(getTabView("关注",R.mipmap.home));
        bottmeTab.getTabAt(1).setCustomView(getTabView("发现",R.mipmap.home));
        bottmeTab.getTabAt(2).setCustomView(getTabView("个人",R.mipmap.home));
        bottmeTab.getTabAt(3).setCustomView(getTabView("我",R.mipmap.home));



        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_android:
                        Toast.makeText(BottomNavigationActivity.this,"asacdasc",Toast.LENGTH_LONG).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
