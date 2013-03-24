/**
 * 
 */
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

import java.util.List;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class Sentiment {

	private int score;
	private double comparative;
	private List<String> words;
	private List<String> adjectives;

	public Sentiment(int hits, int length, List<String> words2, List<String> adjectives2 ) {
		this.score = hits;
		this.comparative = hits / length;
		this.words       = words2;
		this.adjectives  = adjectives2;
	}

	public Sentiment(int hits, double d, Sentiment pos, Sentiment neg) {
		this.score = hits;
		this.comparative = d;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the comparative
	 */
	public double getComparative() {
		return comparative;
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getWords() {
		return this.words;
	}

	/**
	 * @return the adjectives
	 */
	public List<String> getAdjectives() {
		return adjectives;
	}

}
