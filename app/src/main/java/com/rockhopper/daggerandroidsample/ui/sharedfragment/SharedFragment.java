package com.rockhopper.daggerandroidsample.ui.sharedfragment;

import javax.inject.Inject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rockhopper.daggerandroidsample.R;
import com.rockhopper.daggerandroidsample.base.BaseFragment;
import com.rockhopper.daggerandroidsample.base.BasePresenter;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
public class SharedFragment extends BaseFragment implements SharedContract.View {
	public static final String TAG = SharedFragment.class.getCanonicalName();

	@Inject
	SharedPresenter presenter;

	@Inject
	Activity activity;

	//region Factory
	public static SharedFragment newInstance() {
		return new SharedFragment();
	}

	public SharedFragment() {
	}
	//endregion

	@Override
	protected BasePresenter getPresenter() {
		return presenter;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_shared, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		currentState("View:onViewCreated");
	}

	@Override
	public void currentState(String state) {
		if (getView() != null) {
			final TextView textView = findViewBydId(getView(), R.id.textView);
			textView.setText(textView.getText() + "\n" + state);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T findViewBydId(@NonNull View view, @IdRes int resourceId) {
		return (T)view.findViewById(resourceId);
	}
}