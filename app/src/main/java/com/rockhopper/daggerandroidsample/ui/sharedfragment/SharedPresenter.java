package com.rockhopper.daggerandroidsample.ui.sharedfragment;

import javax.inject.Inject;

import com.rockhopper.daggerandroidsample.dagger.FragmentScope;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
@FragmentScope
public class SharedPresenter implements SharedContract.Presenter {
	private final SharedContract.View view;

	@Inject
	public SharedPresenter(SharedContract.View view) {
		this.view = view;
	}

	@Override
	public void onAttachedToView() {
		view.currentState("Presenter:onAttachedToView");
	}

	@Override
	public void onResume() {
		view.currentState("Presenter:onResume");
	}

	@Override
	public void onPause() {
		view.currentState("Presenter:onPause");
	}

	@Override
	public void onDetachedFromView() {
		view.currentState("Presenter:onDetachedFromView");
	}
}
