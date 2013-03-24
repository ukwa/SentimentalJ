
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

import java.util.ArrayList;
import java.util.List;

public class SentimentalJ {


	private int hits  = 0;
	private List<String> words = new ArrayList<String>();
	private List<String> adjectives = new ArrayList<String>();
	private String[] tokens;


	private void addPush(String t, int score){
		hits += score;
		words.add(t);
	}

	private void multiply(String t, int score){
		hits *= score;
		adjectives.add(t);
	}

	private void init( String phrase) {
		hits  = 0;
		words = new ArrayList<String>();
		adjectives = new ArrayList<String>();

		String noPunctuation = phrase.replaceAll("[^a-zA-Z ]+", "").replaceAll(" {2,}"," ");
		tokens = noPunctuation.toLowerCase().split(" ");		 
	}

	// Calculates the negative sentiment of a sentence
	// -------------------------------------------------- //

	public Sentiment negativity( String phrase ) {

		init(phrase);

		for(String t : tokens) {
			if (SentimentStrings.neg5.indexOf(t) > -1) {
				addPush(t,5);
			} else if (SentimentStrings.neg4.indexOf(t) > -1) {
				addPush(t,4);
			} else if (SentimentStrings.neg3.indexOf(t) > -1) {
				addPush(t,3);
			} else if (SentimentStrings.neg2.indexOf(t) > -1) {
				addPush(t,2);
			} else if (SentimentStrings.neg1.indexOf(t) > -1) {
				addPush(t,1);
			}
		}

		for(String t : tokens) {
			if (SentimentStrings.int3.indexOf(t) > -1) {
				multiply(t, 4);
			} else if (SentimentStrings.int2.indexOf(t) > -1) {
				multiply(t, 3);
			} else if (SentimentStrings.int1.indexOf(t) > -1) {
				multiply(t, 2);
			}
		}
		return new Sentiment(hits, tokens.length, words, adjectives );

	}


	// Calculates the positive sentiment  of a sentence
	// -------------------------------------------------- //

	public Sentiment positivity( String phrase) {
		
		init(phrase);

		for(String t : tokens) {
			if (SentimentStrings.pos5.indexOf(t) > -1) {
				addPush(t,5);
			} else if (SentimentStrings.pos4.indexOf(t) > -1) {
				addPush(t,4);
			} else if (SentimentStrings.pos3.indexOf(t) > -1) {
				addPush(t,3);
			} else if (SentimentStrings.pos2.indexOf(t) > -1) {
				addPush(t,2);
			} else if (SentimentStrings.pos1.indexOf(t) > -1) {
				addPush(t,1);
			}
		}

		for(String t : tokens) {
			if (SentimentStrings.int3.indexOf(t) > -1) {
				multiply(t, 4);
			} else if (SentimentStrings.int2.indexOf(t) > -1) {
				multiply(t, 3);
			} else if (SentimentStrings.int1.indexOf(t) > -1) {
				multiply(t, 2);
			}
		}

		return new Sentiment(hits, tokens.length, words, adjectives );
	}


	// Calculates overall sentiment
	// -------------------------------------------------- //

	public Sentiment analyze( String phrase ) {
		Sentiment pos = positivity(phrase);
		Sentiment neg = negativity(phrase);
		return new Sentiment( pos.getScore() - neg.getScore(), 
				pos.getComparative() - neg.getComparative(), pos, neg );  
	}


}
