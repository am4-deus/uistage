package se.virtualstores.nextstepstageui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int NUMBER_OF_FRAGMENTS = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = findViewById(R.id.View_Pager);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), NUMBER_OF_FRAGMENTS);
        viewPager.setAdapter(adapter);

    }


    public class FragmentAdapter extends FragmentPagerAdapter {

        private int numberOfFragments;

        public FragmentAdapter(FragmentManager fm, int numberOfFragments) {
            super(fm);
            this.numberOfFragments = numberOfFragments;
        }

        @Override
        public Fragment getItem(int i) {
            ImageFragment fragment = new ImageFragment();
            fragment.setUrl("file:///android_asset/" + i + ".png");
            return fragment;
        }

        @Override
        public int getCount() {
            return numberOfFragments;
        }
    }
}
