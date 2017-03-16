package com.rockhopper.daggerandroidsample.dagger;

import android.support.v4.app.Fragment;
import com.rockhopper.daggerandroidsample.ui.sharedfragment.SharedFragment;
import com.rockhopper.daggerandroidsample.ui.sharedfragment.SharedFragmentComponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
@Module(subcomponents = {SharedFragmentComponent.class})
public abstract class FragmentBindModule {
	@Binds
	@IntoMap
	@FragmentKey(SharedFragment.class)
	abstract AndroidInjector.Factory<? extends Fragment>
	bindSharedFragmentInjectorFactory(SharedFragmentComponent.Builder builder);
}
