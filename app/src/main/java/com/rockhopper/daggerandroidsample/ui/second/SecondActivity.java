package com.rockhopper.daggerandroidsample.ui.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import com.annimon.stream.function.Supplier;
import com.rockhopper.daggerandroidsample.R;
import com.rockhopper.daggerandroidsample.base.BaseActivity;
import com.rockhopper.daggerandroidsample.ui.sharedfragment.SharedFragment;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */

public class SecondActivity extends BaseActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView textView = (TextView)findViewById(R.id.textView);
		textView.setText(resources.getString(R.string.second_activity));

		addFragment(SharedFragment.TAG, R.id.fragmentContainer, new Supplier<Fragment>() {
			@Override
			public Fragment get() {
				return SharedFragment.newInstance();
			}
		});
	}
}
