/* Copyright (C) 2023 Pimnara Panyalerdsattha - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the Apache license.
 */

package com.snatik.matches;

import android.content.Context;
import android.content.SharedPreferences;
import com.snatik.matches.common.Memory;
import com.snatik.matches.common.Shared;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MemoryTest {

    @Mock
    private Context mockContext;
    @Mock
    private SharedPreferences mockSharedPreferences;
    @Mock
    private SharedPreferences.Editor mockEditor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockContext.getSharedPreferences(Memory.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE))
                .thenReturn(mockSharedPreferences);
        when(mockSharedPreferences.edit()).thenReturn(mockEditor);
        Shared.context = mockContext;
    }

    @Test
    public void testGetBestTime() {
        int theme = 1;
        int difficulty = 1;
        int expectedBestTime = 25;
        String key = String.format(Memory.bestTimeKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, -1)).thenReturn(expectedBestTime);

        int bestTime = Memory.getBestTime(theme, difficulty);
        int expected = (theme >= 0 && difficulty >= 0) ? expectedBestTime : -1;
        assertEquals(expected, bestTime);
    }

    @Test
    public void testGetBestTime2() {
        int theme = 1;
        int difficulty = -1;
        int expectedBestTime = -1;
        String key = String.format(Memory.bestTimeKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, -1)).thenReturn(expectedBestTime);

        int bestTime = Memory.getBestTime(theme, difficulty);
        int expected = (theme >= 0 && difficulty >= 0) ? expectedBestTime : -1;
        assertEquals(expected, bestTime);
    }

    @Test
    public void testGetBestTime3() {
        int theme = -1;
        int difficulty = 1;
        int expectedBestTime = -1;
        String key = String.format(Memory.bestTimeKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, -1)).thenReturn(expectedBestTime);

        int bestTime = Memory.getBestTime(theme, difficulty);
        int expected = (theme >= 0 && difficulty >= 0) ? expectedBestTime : -1;
        assertEquals(expected, bestTime);
    }

    @Test
    public void testGetBestTime4() {
        int theme = -1;
        int difficulty = -1;
        int expectedBestTime = -1;
        String key = String.format(Memory.bestTimeKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, -1)).thenReturn(expectedBestTime);

        int bestTime = Memory.getBestTime(theme, difficulty);
        int expected = (theme >= 0 && difficulty >= 0) ? expectedBestTime : -1;
        assertEquals(expected, bestTime);
    }

    @Test
    public void testSaveTime() {
        int theme = 1;
        int difficulty = 2;
        int passedSecs = 50;
        int currentBestTime = 40;

        when(mockSharedPreferences.getInt(String.format(Memory.bestTimeKey, theme, difficulty), -1)).thenReturn(currentBestTime);

        Memory.saveTime(theme, difficulty, passedSecs);

        if (passedSecs < currentBestTime) {
            Mockito.verify(mockEditor).putInt(String.format(Memory.bestTimeKey, theme, difficulty), passedSecs);
            Mockito.verify(mockEditor).commit();
            when(mockSharedPreferences.getInt(String.format(Memory.bestTimeKey, theme, difficulty), -1)).thenReturn(passedSecs);
        } else {
            Mockito.verify(mockEditor, Mockito.times(0)).putInt(String.format(Memory.bestTimeKey, theme, difficulty), passedSecs);
            Mockito.verify(mockEditor, Mockito.times(0)).commit();
            when(mockSharedPreferences.getInt(String.format(Memory.bestTimeKey, theme, difficulty), -1)).thenReturn(currentBestTime);
        }
        int bestTime = Memory.getBestTime(theme, difficulty);
        if (passedSecs < currentBestTime) {
            assertEquals(passedSecs, bestTime);
        } else {
            assertEquals(currentBestTime, bestTime);
        }
    }

    @Test
    public void testgetHighStars(){
        // Define the test parameters
        int theme = 1;
        int difficulty = 2;
        int expectedStars = 5;

        String key = String.format(Memory.highStartKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, 0)).thenReturn(expectedStars);
        int highStars = Memory.getHighStars(theme, difficulty);
        
        int expected = 0;
        if (theme >= 0 && difficulty >= 0){
            expected = expectedStars;
        }else{
            expected = -1;
        }
        assertEquals(expected, highStars);
    }

    @Test
    public void testgetHighStars2(){
        // Define the test parameters
        int theme = 1;
        int difficulty = -1;
        int expectedStars = -1;

        String key = String.format(Memory.highStartKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, 0)).thenReturn(expectedStars);
        int highStars = Memory.getHighStars(theme, difficulty);

        int expected = 0;
        if (theme >= 0 && difficulty >= 0){
            expected = expectedStars;
        }else{
            expected = -1;
        }
        assertEquals(expected, highStars);
    }

    @Test
    public void testgetHighStars3(){
        // Define the test parameters
        int theme = -1;
        int difficulty = 1;
        int expectedStars = -1;

        String key = String.format(Memory.highStartKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, 0)).thenReturn(expectedStars);
        int highStars = Memory.getHighStars(theme, difficulty);

        int expected = 0;
        if (theme >= 0 && difficulty >= 0){
            expected = expectedStars;
        }else{
            expected = -1;
        }
        assertEquals(expected, highStars);
    }

    @Test
    public void testgetHighStars4(){
        // Define the test parameters
        int theme = -1;
        int difficulty = -1;
        int expectedStars = -1;

        String key = String.format(Memory.highStartKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, 0)).thenReturn(expectedStars);
        int highStars = Memory.getHighStars(theme, difficulty);

        int expected = 0;
        if (theme >= 0 && difficulty >= 0){
            expected = expectedStars;
        }else{
            expected = -1;
        }
        assertEquals(expected, highStars);
    }
}

