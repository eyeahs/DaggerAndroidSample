package com.rockhopper.daggerandroidsample.dagger;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
@Module(includes = FragmentBindModule.class)
public class BaseActivityModule {
	@ActivityScope
	@Provides
	AppCompatActivity provideAppCompatActivity(Activity activity) {
		return (AppCompatActivity)activity;
	}

	@ActivityScope
	@Provides
	FragmentManager provideFragmentManager(AppCompatActivity activity) {
		return activity.getSupportFragmentManager();
	}
}
