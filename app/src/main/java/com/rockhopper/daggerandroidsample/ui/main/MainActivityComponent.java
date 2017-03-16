package com.rockhopper.daggerandroidsample.ui.main;

import android.app.Activity;
import com.rockhopper.daggerandroidsample.dagger.ActivityScope;
import com.rockhopper.daggerandroidsample.dagger.BaseActivityModule;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
@ActivityScope
@Subcomponent(modules = {MainActivityComponent.Module.class})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<MainActivity> {
	}

	@dagger.Module(includes = {BaseActivityModule.class})
	class Module {
		@ActivityScope
		@Provides
		public Activity provideActivity(MainActivity activity) {
			return activity;
		}
	}
}
