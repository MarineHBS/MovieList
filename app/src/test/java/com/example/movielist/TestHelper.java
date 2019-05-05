package com.example.movielist;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    /*public static DaggerTestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        MovieListApplication application = (MovieListApplication) RuntimeEnvironment.application;
        MovieListApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return (DaggerTestComponent) injector;
    }*/
}
