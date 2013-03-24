package uk.bl.wa.sentimentalj;

/*
 * #%L
 * SentimentalJ
 * %%
 * Copyright (C) 2012 - 2013 The British Library
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SentimentalJTest {

	private SentimentalJ sentimental;

	@Before
	public void setUp() throws Exception {
		sentimental = new SentimentalJ();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNegativity() {
		assertEquals( sentimental.negativity("bastard").getScore(), 5);
	     assertEquals( sentimental.negativity("scumbag").getScore(), 4);
	      assertEquals( sentimental.negativity("evil").getScore(), 3);
	      assertEquals( sentimental.negativity("ache").getScore(), 2);
	      assertEquals( sentimental.negativity("anti").getScore(), 1);
	      assertEquals( sentimental.negativity("such bastard").getScore(), 10);
	      assertEquals( sentimental.negativity("complete bastard").getScore(), 15);
	      assertEquals( sentimental.negativity("extremely bastard").getScore(), 20);
	      assertEquals( sentimental.negativity("such scumbag").getScore(), 8);
	      assertEquals( sentimental.negativity("complete scumbag").getScore(), 12);
	      assertEquals( sentimental.negativity("extremely scumbag").getScore(), 16);
	      assertEquals( sentimental.negativity("such evil").getScore(), 6);
	      assertEquals( sentimental.negativity("complete evil").getScore(), 9);
	      assertEquals( sentimental.negativity("extremely evil").getScore(), 12);
	      assertEquals( sentimental.negativity("such ache").getScore(), 4);
	      assertEquals( sentimental.negativity("complete ache").getScore(), 6);
	      assertEquals( sentimental.negativity("extremely ache").getScore(), 8);
	      assertEquals( sentimental.negativity("such anti").getScore(), 2);
	      assertEquals( sentimental.negativity("complete anti").getScore(), 3);
	      assertEquals( sentimental.negativity("extremely anti").getScore(), 4);
	      assertEquals( sentimental.negativity("Hey scumbag").getComparative(), 2, 0.01 );
	      assertEquals( sentimental.negativity("This is two anti evil words").getWords().size(), 2);

	}

	@Test
	public void testPositivity() {
		assertEquals( sentimental.positivity("superb").getScore(), 5);
		assertEquals( sentimental.positivity("amazing").getScore(), 4);
		assertEquals( sentimental.positivity("admire").getScore(), 3);
		assertEquals( sentimental.positivity("amaze").getScore(), 2);
		assertEquals( sentimental.positivity("cool").getScore(), 1);
		assertEquals( sentimental.positivity("such breathtaking").getScore(), 10);
		assertEquals( sentimental.positivity("complete breathtaking").getScore(), 15);
		assertEquals( sentimental.positivity("extremely breathtaking").getScore(), 20);
		assertEquals( sentimental.positivity("such fun").getScore(), 8);
		assertEquals( sentimental.positivity("complete fun").getScore(), 12);
		assertEquals( sentimental.positivity("extremely fun").getScore(), 16);
		assertEquals( sentimental.positivity("such delight").getScore(), 6);
		assertEquals( sentimental.positivity("complete delight").getScore(), 9);
		assertEquals( sentimental.positivity("extremely delight").getScore(), 12);
		assertEquals( sentimental.positivity("such eager").getScore(), 4);
		assertEquals( sentimental.positivity("complete eager").getScore(), 6);
		assertEquals( sentimental.positivity("extremely eager").getScore(), 8);
		assertEquals( sentimental.positivity("such trust").getScore(), 2);
		assertEquals( sentimental.positivity("complete trust").getScore(), 3);
		assertEquals( sentimental.positivity("extremely trust").getScore(), 4);
		assertEquals( sentimental.positivity("Hey amazing").getComparative(), 2.0, 0.01 );
		assertEquals( sentimental.positivity("This is two amazing cool words").getWords().size(), 2);
	}

	@Test
	public void testAnalyze() {
		assertEquals( sentimental.analyze("Hey Amazing Scumbag").getScore(), 0);		
		assertEquals( sentimental.analyze("Cool beans").getScore(), 1);
		assertEquals( sentimental.analyze("Hey scumbag").getScore(), -4);
		assertEquals( sentimental.analyze("Fearless!").getScore(), 2);
		assertEquals( sentimental.analyze("Crash!").getScore(), -2);
		assertEquals( sentimental.analyze("#fearless").getScore(), 2);
		assertEquals( sentimental.analyze("#crash").getScore(), -2);
		assertEquals( sentimental.analyze("An amazing anti").getComparative(), 1.0, 0.01 );
	}
}
