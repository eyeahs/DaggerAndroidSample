package com.rockhopper.daggerandroidsample.dagger;

import android.app.Activity;
import com.rockhopper.daggerandroidsample.ui.main.MainActivity;
import com.rockhopper.daggerandroidsample.ui.main.MainActivityComponent;
import com.rockhopper.daggerandroidsample.ui.second.SecondActivity;
import com.rockhopper.daggerandroidsample.ui.second.SecondActivityComponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
@Module(subcomponents = {MainActivityComponent.class, SecondActivityComponent.class})
public abstract class ActivityBindModule {
	@Binds
	@IntoMap
	@ActivityKey(MainActivity.class)
	abstract AndroidInjector.Factory<? extends Activity>
	bindMainActivityInjectorFactory(MainActivityComponent.Builder builder);

	@Binds
	@IntoMap
	@ActivityKey(SecondActivity.class)
	abstract AndroidInjector.Factory<? extends Activity>
	bindSecondActivityInjectorFactory(SecondActivityComponent.Builder builder);
}
