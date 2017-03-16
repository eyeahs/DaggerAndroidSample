package com.rockhopper.daggerandroidsample.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */

public abstract class BaseFragment extends Fragment {

	protected abstract BasePresenter getPresenter();

	@Override
	public void onAttach(Context context) {
		AndroidSupportInjection.inject(this);
		super.onAttach(context);
	}

	@Override
	public void onStart() {
		super.onStart();
		getPresenter().onAttachedToView();
	}

	@Override
	public void onResume() {
		super.onResume();
		getPresenter().onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		getPresenter().onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
		getPresenter().onDetachedFromView();
	}
}
