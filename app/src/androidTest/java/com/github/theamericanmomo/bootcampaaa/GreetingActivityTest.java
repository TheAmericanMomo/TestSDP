package com.github.theamericanmomo.bootcampaaa;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {

    @Rule
    public ActivityScenarioRule<GreetingActivity> activityScenarioRule =
            new ActivityScenarioRule<>(GreetingActivity.class);

    @Test
    public void testGreetingActivity() {
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra("key", "coucou lol");
        activityScenarioRule.getScenario().onActivity(activity -> {
            activity.startActivity(intent);
        });

        onView(withId(R.id.greetingMessage)).check(matches(isDisplayed()));
        onView(withId(R.id.greetingMessage)).check(matches(ViewMatchers.withText("coucou lol")));
    }
}