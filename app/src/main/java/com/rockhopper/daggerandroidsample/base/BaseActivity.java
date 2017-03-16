package com.rockhopper.daggerandroidsample.base;

import javax.inject.Inject;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.annimon.stream.function.Supplier;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasDispatchingSupportFragmentInjector;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */

public abstract class BaseActivity extends AppCompatActivity implements HasDispatchingSupportFragmentInjector {

	@Inject
	DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;

	@Inject
	protected Resources resources;

	@Inject
	protected FragmentManager fragmentManager;

	@Override
	public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
		return dispatchingFragmentInjector;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
	}

	protected void addFragment(String TAG, @IdRes int resourceId, Supplier<Fragment> supplier) {
		if (fragmentManager.findFragmentByTag(TAG) == null) {
			fragmentManager.beginTransaction()
				.add(resourceId, supplier.get(), TAG)
				.commitNow();
		}
	}
}
