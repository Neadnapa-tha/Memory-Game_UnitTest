/* Copyright (C) 2023 Neadnapa Thawontaweekul - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the Apache license.
 */

package com.snatik.matches;

import com.snatik.matches.model.GameState;
import com.snatik.matches.ui.PopupWonView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import android.content.Context;
import android.view.View;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class PopupWonViewTest {

    private PopupWonView popupView;

    @Before
    public void setUp() {

        Context context = Robolectric.buildActivity(MainActivity.class).get();


        popupView = new PopupWonView(context);
    }

    @Test
    public void testSetGameState() {

        // T1

        GameState gameState1 = new GameState();
        gameState1.remainedSeconds = 60;
        gameState1.achievedScore = 10;
        gameState1.achievedStars = 3;


        popupView.setGameState(gameState1);


        assertEquals("01:00", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());



        popupView.animateStars(gameState1.achievedStars);
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar2.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar3.getVisibility());

        // T3

        GameState gameState3 = new GameState();
        gameState3.remainedSeconds = 0;
        gameState3.achievedScore = 10;
        gameState3.achievedStars = 3;


        popupView.setGameState(gameState3);


        assertEquals("00:00", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());



        popupView.animateStars(gameState3.achievedStars);
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar2.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar3.getVisibility());

        // T4

        GameState gameState4 = new GameState();
        gameState4.remainedSeconds = 100;
        gameState4.achievedScore = -1;
        gameState4.achievedStars = 3;


        popupView.setGameState(gameState4);


        assertEquals("01:40", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());



        popupView.animateStars(gameState4.achievedStars);
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar2.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar3.getVisibility());

        // T5

        GameState gameState5 = new GameState();
        gameState5.remainedSeconds = 120;
        gameState5.achievedScore = 0;
        gameState5.achievedStars = 3;


        popupView.setGameState(gameState5);


        assertEquals("02:00", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());



        popupView.animateStars(gameState5.achievedStars);
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar2.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar3.getVisibility());

        // T9

        GameState gameState9 = new GameState();
        gameState9.remainedSeconds = 250;
        gameState9.achievedScore = 40;
        gameState9.achievedStars = 0;


        popupView.setGameState(gameState9);


        assertEquals("04:10", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());


        popupView.animateStars(gameState9.achievedStars);
        assertEquals(View.GONE, popupView.mStar1.getVisibility());
        assertEquals(View.GONE, popupView.mStar2.getVisibility());
        assertEquals(View.GONE, popupView.mStar3.getVisibility());

        // T10

        GameState gameState10 = new GameState();
        gameState10.remainedSeconds = 300;
        gameState10.achievedScore = 41;
        gameState10.achievedStars = 1;


        popupView.setGameState(gameState10);


        assertEquals("05:00", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());


        popupView.animateStars(gameState10.achievedStars);
        assertEquals(View.GONE, popupView.mStar2.getVisibility());
        assertEquals(View.GONE, popupView.mStar3.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());

        // T11

        GameState gameState11 = new GameState();
        gameState11.remainedSeconds = 347;
        gameState11.achievedScore = 42;
        gameState11.achievedStars = 2;


        popupView.setGameState(gameState11);


        assertEquals("05:47", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());

        popupView.animateStars(gameState11.achievedStars);
        assertEquals(View.GONE, popupView.mStar3.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar2.getVisibility());
    }
}
