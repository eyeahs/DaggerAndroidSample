package com.rockhopper.daggerandroidsample.ui.second;

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
@Subcomponent(modules = {SecondActivityComponent.Module.class})
public interface SecondActivityComponent extends AndroidInjector<SecondActivity> {
	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<SecondActivity> {
	}

	@dagger.Module(includes = BaseActivityModule.class)
	class Module {
		@ActivityScope
		@Provides
		public Activity provideActivity(SecondActivity activity) {
			return activity;
		}
	}
}
