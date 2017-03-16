package com.rockhopper.daggerandroidsample.base;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */

public interface BasePresenter {
	void onAttachedToView();

	void onResume();

	void onPause();

	void onDetachedFromView();
}
