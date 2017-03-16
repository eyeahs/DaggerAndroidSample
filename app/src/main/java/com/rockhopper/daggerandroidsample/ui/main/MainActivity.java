package com.rockhopper.daggerandroidsample.ui.main;

import javax.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import com.annimon.stream.function.Supplier;
import com.rockhopper.daggerandroidsample.R;
import com.rockhopper.daggerandroidsample.base.BaseActivity;
import com.rockhopper.daggerandroidsample.ui.second.SecondActivity;
import com.rockhopper.daggerandroidsample.ui.sharedfragment.SharedFragment;

public class MainActivity extends BaseActivity {
	@Inject
	Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView textView = (TextView)findViewById(R.id.textView);
		textView.setText(resources.getString(R.string.click_here_to_show_second_activity));
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(activity, SecondActivity.class));
			}
		});

		addFragment(SharedFragment.TAG, R.id.fragmentContainer, new Supplier<Fragment>() {
			@Override
			public Fragment get() {
				return SharedFragment.newInstance();
			}
		});
	}
}
