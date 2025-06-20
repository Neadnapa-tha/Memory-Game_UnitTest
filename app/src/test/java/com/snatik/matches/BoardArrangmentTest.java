/* Copyright (C) 2023 Neadnapa Thawontaweekul - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the Apache license.
 */

package com.snatik.matches;

import com.snatik.matches.model.BoardArrangment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BoardArrangmentTest {

    private BoardArrangment boardArrangment;

    @Before
    public void setUp() {
        boardArrangment = new BoardArrangment();
        Map<Integer, Integer> pairs = new HashMap<>();
        pairs.put(1, 2);
        pairs.put(2, -1);
        pairs.put(3, 0);
        pairs.put(-2, 4);
        pairs.put(0, 5);
        boardArrangment.pairs = pairs;
    }

    @Test
    public void testIsPairWhenIdsArePresentThenReturnTrue1() {
        assertTrue(boardArrangment.isPair(1, 2));
    }

    @Test
    public void testIsPairWhenIdsArePresentThenReturnTrue2() {
        assertTrue(boardArrangment.isPair(2, -1));
    }

    @Test
    public void testIsPairWhenIdsArePresentThenReturnTrue3() {
        assertTrue(boardArrangment.isPair(3, 0));
    }
    @Test
    public void testIsPairWhenIdsArePresentThenReturnTrue4() {
        assertTrue(boardArrangment.isPair(-2, 4));
    }

    @Test
    public void testIsPairWhenIdsArePresentThenReturnTrue5() {
        assertTrue(boardArrangment.isPair(0, 5));
    }

    @Test
    public void testIsPairWhenIdsAreNotPresentThenReturnFalse() {
        assertFalse(boardArrangment.isPair(6, 7));
    }

}
