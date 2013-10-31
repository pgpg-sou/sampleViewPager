package com.example.sampleviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(new MyPagerAdapter());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private class MyPagerAdapter extends PagerAdapter {
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((View) object);
		}
		@Override
		public Object instantiateItem(View container, int position) {
            int[] pages = { R.layout.activity_name, R.layout.activity_event};
            int[] lists = {R.id.somethingList, R.id.eventList};

            View layout ;
			List<String> items = new ArrayList<String>();
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if(position == 0) {
				items.add("日本");
				items.add("アメリカ");
				items.add("中国");
				items.add("イギリス");
			} else if(position == 1) {
				items.add("東京");
				items.add("ワシントン D.C");
				items.add("北京");
				items.add("ロンドン");
			} 
            layout = inflater.inflate(pages[position], null);
            ((ViewPager) container).addView(layout);

			ListView list = (ListView) findViewById(lists[position]);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>( MainActivity.this, R.layout.data_list, R.id.row_textview1, items);

			list.setAdapter(adapter);

			return layout;
		}

		@Override
		public int getCount() {
			return 2;
		}
		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view.equals(object);
		}
	}

}
