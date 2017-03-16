package com.rockhopper.daggerandroidsample.ui.sharedfragment;

import com.rockhopper.daggerandroidsample.dagger.FragmentScope;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
@FragmentScope
@Subcomponent(modules = SharedFragmentComponent.Module.class)
public interface SharedFragmentComponent extends AndroidInjector<SharedFragment> {
	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<SharedFragment> {
	}

	@dagger.Module
	class Module {
		@FragmentScope
		@Provides
		SharedContract.View provideSharedFragment(SharedFragment fragment) {
			return fragment;
		}
	}
}
