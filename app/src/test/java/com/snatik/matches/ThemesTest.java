/* Copyright (C) 2023 Chanyanuch Nuangjumnong - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the Apache license.
 */

package com.snatik.matches;

import com.snatik.matches.themes.Theme;
import com.snatik.matches.themes.Themes;
import org.junit.Test;
import static org.junit.Assert.*;

public class ThemesTest {

    // Test 1
    @Test
    public void testCreateAnimalsTheme() {

        Theme animalsTheme = Themes.createAnimalsTheme();

        assertNotNull(animalsTheme);

        assertEquals(1, animalsTheme.id);
        assertEquals("Animals", animalsTheme.name);
        assertEquals(Themes.URI_DRAWABLE + "back_animals", animalsTheme.backgroundImageUrl);
        assertEquals(28, animalsTheme.tileImageUrls.size());

    }

    // Test 2
    @Test
    public void testcreateMonsterTheme() {

        Theme monsterTheme = Themes.createMonsterTheme();

        assertNotNull(monsterTheme);

        assertEquals(2, monsterTheme.id);
        assertEquals("Monsters", monsterTheme.name);
        assertEquals(Themes.URI_DRAWABLE + "back_horror", monsterTheme.backgroundImageUrl);
        assertEquals(40, monsterTheme.tileImageUrls.size());

    }

    // Test 3
    @Test
    public void testCreateEmojiTheme() {

        Theme EmojiTheme = Themes.createEmojiTheme();

        assertNotNull(EmojiTheme);

        assertEquals(3, EmojiTheme.id);
        assertEquals("Emoji", EmojiTheme.name);
        assertEquals(Themes.URI_DRAWABLE + "background", EmojiTheme.backgroundImageUrl);
        assertEquals(40, EmojiTheme.tileImageUrls.size());

    }

}
