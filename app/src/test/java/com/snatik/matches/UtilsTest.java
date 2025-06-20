/* Copyright (C) 2023 Tunyarat Nitihirunpattana - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the Apache license.
 */

package com.snatik.matches;

import androidx.test.core.app.ApplicationProvider;
import com.snatik.matches.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import android.content.Context;
import com.snatik.matches.common.Shared;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class UtilsTest {

    @Test
    public void testPxConversion() {
        // Mock Shared.context สำหรับทดสอบ
        Context context = ApplicationProvider.getApplicationContext();
        Shared.context = context;

        // T1
        int dpValue1 = -5;
        int pxValue1 = -5;
        int actualPxValue1 = Utils.px(dpValue1);
        assertTrue(pxValue1 == actualPxValue1);

        // T2
        int dpValue2 = 1;
        int pxValue2 = 1;
        int actualPxValue2 = Utils.px(dpValue2);
        assertTrue(pxValue2 == actualPxValue2);

        // T3
        int dpValue3 = 20;
        int pxValue3 = 20;
        int actualPxValue3 = Utils.px(dpValue3);
        assertTrue(pxValue3 == actualPxValue3);

        // T4
        int dpValue4 = 0;
        int pxValue4 = -5;
        int actualPxValue4 = Utils.px(dpValue4);
        assertFalse(pxValue4 == actualPxValue4);

        // T7
        int dpValue7 = -5;
        int pxValue7 = 2;
        int actualPxValue7 = Utils.px(dpValue7);
        assertFalse(pxValue7 == actualPxValue7);

        // T8
        int dpValue8 = 1;
        int pxValue8 = 2;
        int actualPxValue8 = Utils.px(dpValue8);
        assertFalse(pxValue8 == actualPxValue8);

        // T9
        int dpValue9 = 20;
        int pxValue9 = 40;
        int actualPxValue9 = Utils.px(dpValue9);
        assertFalse(pxValue9 == actualPxValue9);

    }
}
