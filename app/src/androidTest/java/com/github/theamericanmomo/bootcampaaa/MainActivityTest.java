package com.github.theamericanmomo.bootcampaaa;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.view.View;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.github.theamericanmomo.bootcampaaa.GreetingActivity;
import com.github.theamericanmomo.bootcampaaa.MainActivity;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setup() {
        Intents.init();
    }

    @After
    public void cleanup() {
        Intents.release();
    }

    @Test
    public void firstTest() {
        Matcher<View> viewMatcher = withId(R.id.TextPersonName);
        onView(viewMatcher).perform(typeText("coucou"));
        onView(withId(R.id.button)).perform(click());
        intended(allOf(IntentMatchers.hasComponent(GreetingActivity.class.getName()),
                IntentMatchers.hasExtra("key", "coucou")
        ));

        onView(withId(R.id.greetingMessage)).check(matches(withText("coucou")));
    }
}