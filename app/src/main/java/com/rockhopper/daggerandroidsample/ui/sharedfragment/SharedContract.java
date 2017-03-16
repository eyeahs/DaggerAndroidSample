package com.rockhopper.daggerandroidsample.ui.sharedfragment;

import com.rockhopper.daggerandroidsample.base.BasePresenter;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */

public interface SharedContract {
	interface View {
		void currentState(String state);
	}

	interface Presenter extends BasePresenter {

	}
}
