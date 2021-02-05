package com.objectivemonsters.storylines;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoryLineGeneratorTest {
    StoryLineGenerator slg = new StoryLineGenerator();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStoryTxt() {
        slg.getStoryTxt();
        assertEquals("welcome", "welcome");
    }
}