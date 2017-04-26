package com.vcompany.app.word_counter;

import org.junit.*;

public class AppTest {

	@Test
	public void countWordsTest() {
		String result = App.countWords(
				"hark how the bells sweet silver bells all seem to say throw cares away christmas is here bringing good cheer to young and old meek and the bold ding dong ding dong that is their song with joyful ring all caroling one seems to hear words of good cheer from everywhere filling the air oh how they pound raising their sound over hill and dale telling their tale gaily they ring while people sing songs of good cheer christmas is here merry merry merry merry christmas merry merry merry merry christmas on on they send on without end their joyful tone to every home hark how the bells sweet silver bells all seem to say throw cares away christmas is here bringing good cheer to young and old meek and the bold ding dong ding dong that is their song with joyful ring all caroling one seems to hear words of good cheer from everywhere filling the air o how they pound raising their sound over hill and dale telling their tale gaily they ring while people sing songs of good cheer christmas is here merry merry merry merry christmas merry merry merry merry christmas on on they send on without end their joyful tone to every home ding dong ding dong",
				7l);
		Assert.assertEquals("merry=16christmas=8their=8to=8", result);
	}
}
