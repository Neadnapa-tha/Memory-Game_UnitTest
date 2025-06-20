/* Copyright (C) 2023 Tunyarat Nitihirunpattana - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the Apache license.
 */

package com.snatik.matches;

import android.support.v4.app.FragmentActivity;
import com.snatik.matches.common.Shared;
import com.snatik.matches.engine.ScreenController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
//@Config(sdk = 28)
public class ScreenControllerTest {

    private ScreenController screenController;

    @Before
    public void setUp() {
        // Mock Shared.activity สำหรับทดสอบ
        Shared.activity = Robolectric.setupActivity(FragmentActivity.class);
        screenController = ScreenController.getInstance();
    }

    @Test
    public void testOpenScreen() {

        // T1
        assertEquals(true, ScreenController.openedScreens.isEmpty());
        screenController.openScreen(ScreenController.Screen.MENU);
        assertFalse(0==ScreenController.openedScreens.size());
        ScreenController.openedScreens.clear();

        // T3
        screenController.openScreen(ScreenController.Screen.MENU);
        assertFalse(ScreenController.openedScreens.isEmpty());
        screenController.openScreen(ScreenController.Screen.GAME);
        assertFalse(0==ScreenController.openedScreens.size());
        ScreenController.openedScreens.clear();

        // T4
        screenController.openScreen(ScreenController.Screen.MENU);
        assertFalse(ScreenController.openedScreens.isEmpty());
        screenController.openScreen(ScreenController.Screen.GAME);
        assertTrue(2==ScreenController.openedScreens.size());
        ScreenController.openedScreens.clear();

        // T5
        assertTrue(ScreenController.openedScreens.isEmpty());
        screenController.openScreen(ScreenController.Screen.MENU);
        assertTrue(1==ScreenController.openedScreens.size());
        ScreenController.openedScreens.clear();

        // T8
        assertTrue(ScreenController.openedScreens.isEmpty());
        screenController.openScreen(ScreenController.Screen.THEME_SELECT);
        assertTrue(1==ScreenController.openedScreens.size());
        ScreenController.openedScreens.clear();

    }
}
