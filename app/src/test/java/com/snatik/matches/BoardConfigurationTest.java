/* Copyright (C) 2023 Chanyanuch Nuangjumnong - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the Apache license.
 */

package com.snatik.matches.model;

import org.junit.Assert;
import org.junit.Test;


public class BoardConfigurationTest {
    // Test 1
    @Test
    public void testValidDifficulty1() {
        BoardConfiguration boardConfig = new BoardConfiguration(1);
        Assert.assertEquals(6, boardConfig.numTiles);
        Assert.assertEquals(3, boardConfig.numTilesInRow);
        Assert.assertEquals(2, boardConfig.numRows);
        Assert.assertEquals(60, boardConfig.time);
    }

    // Test 2
    @Test
    public void testValidDifficulty2() {
        BoardConfiguration boardConfig = new BoardConfiguration(2);
        Assert.assertEquals(12, boardConfig.numTiles);
        Assert.assertEquals(4, boardConfig.numTilesInRow);
        Assert.assertEquals(3, boardConfig.numRows);
        Assert.assertEquals(90, boardConfig.time);
    }

    // Test 3
    @Test
    public void testValidDifficulty3() {
        BoardConfiguration boardConfig = new BoardConfiguration(3);
        Assert.assertEquals(18, boardConfig.numTiles);
        Assert.assertEquals(6, boardConfig.numTilesInRow);
        Assert.assertEquals(3, boardConfig.numRows);
        Assert.assertEquals(120, boardConfig.time);
    }

    // Test 4
    @Test
    public void testValidDifficulty4() {
        BoardConfiguration boardConfig = new BoardConfiguration(4);
        Assert.assertEquals(28, boardConfig.numTiles);
        Assert.assertEquals(7, boardConfig.numTilesInRow);
        Assert.assertEquals(4, boardConfig.numRows);
        Assert.assertEquals(150, boardConfig.time);
    }

    // Test 5
    @Test
    public void testValidDifficulty5() {
        BoardConfiguration boardConfig = new BoardConfiguration(5);
        Assert.assertEquals(32, boardConfig.numTiles);
        Assert.assertEquals(8, boardConfig.numTilesInRow);
        Assert.assertEquals(4, boardConfig.numRows);
        Assert.assertEquals(180, boardConfig.time);
    }

    // Test 6
    @Test
    public void testValidDifficulty6() {
        BoardConfiguration boardConfig = new BoardConfiguration(6);
        Assert.assertEquals(50, boardConfig.numTiles);
        Assert.assertEquals(10, boardConfig.numTilesInRow);
        Assert.assertEquals(5, boardConfig.numRows);
        Assert.assertEquals(210, boardConfig.time);
    }

    private void fail(String s) {
    }

}
