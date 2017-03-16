package com.rockhopper.daggerandroidsample;

import javax.inject.Inject;

import android.app.Activity;
import android.app.Application;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */

public class DaggerApplication extends Application implements HasDispatchingActivityInjector {
	@Inject
	DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

	@Override
	public DispatchingAndroidInjector<Activity> activityInjector() {
		return dispatchingActivityInjector;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		DaggerApplicationComponent.builder()
			.applicationModule(new ApplicationComponent.ApplicationModule(this))
			.build()
			.inject(this);
	}
}
