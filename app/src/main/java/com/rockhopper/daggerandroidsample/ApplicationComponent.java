package com.rockhopper.daggerandroidsample;

import javax.inject.Singleton;

import android.app.Application;
import android.content.res.Resources;
import com.rockhopper.daggerandroidsample.dagger.ActivityBindModule;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

/**
 * Created by hyunwoopark on 2017. 3. 16..
 */
@Singleton
@Component(modules = {ApplicationComponent.ApplicationModule.class,
	AndroidInjectionModule.class,
	ActivityBindModule.class})
interface ApplicationComponent {
	void inject(DaggerApplication application);

	@Module
	class ApplicationModule {
		private final DaggerApplication application;

		public ApplicationModule(DaggerApplication application) {
			this.application = application;
		}

		@Singleton
		@Provides
		Application provideApplication() {
			return application;
		}

		@Singleton
		@Provides
		DaggerApplication provideDaggerApplication() {
			return application;
		}

		@Singleton
		@Provides
		Resources provideResources() {
			return application.getResources();
		}
	}
}
