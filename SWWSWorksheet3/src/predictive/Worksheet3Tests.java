package predictive;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Worksheet3Tests {
	ListDictionary d = new ListDictionary();
	/*
	 * Testing word to Signature method - empty string
	 */
	@Test
	public void ex1test1() {
		String word = "";
		String expected = "";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - space
	 */
	@Test
	public void ex1test2() {
		String word = " ";
		String expected = " ";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - expected string lowercase
	 */
	@Test
	public void ex1test3() {
		String word = "abcdefghijklmnopqrstuvwxyz";
		String expected = "22233344455566677778889999";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - expected string uppercase
	 */
	@Test
	public void ex1test4() {
		String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String expected = "22233344455566677778889999";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
	/*
	 * Testing word to Signature method - non-/alphabetical mixed 
	 */
	@Test
	public void ex1test5() {
		String word = "h&m";
		String expected = "4 6";
		assertEquals(expected, PredictivePrototype.wordToSignature(word));
	}
//////////////////////////////////////////////////////////////////////////
	/*
	 * Testing isValidWord(String word)
	 */
	@Test
	public void isValidWordtest1(){
		String word = "hello's";
		assertFalse(PredictivePrototype.isValidWord(word));
	}
	/*
	 * Testing isValidWord(String word)
	 */
	@Test
	public void isValidWordtest2(){
		String word = "Boo";
		assertTrue(PredictivePrototype.isValidWord(word));
	}
	/*
	 * Testing isValidWord(String word)
	 */
	@Test
	public void isValidWordtest3(){
		String word = "";
		assertTrue(PredictivePrototype.isValidWord(word));
	}
//////////////////////////////////////////////////////////////////////////
	/*
	 * Testing signatureToWords() 
	 */
	@Test
	public void ex2test1() {
		String sig = "2";
		HashSet<String> expected = new HashSet<String>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	/*
	 * Testing signatureToWords()  empty string
	 */
	@Test
	public void ex2test2() {
		String sig = "";
		HashSet<String> expected = new HashSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	/*
	 * Testing signatureToWords() invalid signature
	 */
	@Test
	public void ex2test3() {
		String sig = "1";
		HashSet<String> expected = new HashSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	/*
	 * Testing signatureToWords() "4663" - "home"
	 */
	@Test
	public void ex2test4() {
		String sig = "4663";
		HashSet<String> expected = new HashSet<String>();
		expected.add("good");
		expected.add("home");
		expected.add("gone");
		expected.add("hood");
		expected.add("hone");
		expected.add("goof");
		expected.add("hoof");
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	///////////////////////////////////////////////////////////
	/*
	 * Testing Word2SigProto class 
	 * VISUAL TEST
	 */
	@Test
    public void verifyParamsForWords2SigProto() {
		System.out.println("Test: Words2SigProto Class");
        Words2SigProto.main(new String[]{"home", "cat"});
        System.out.println();
    }
	/*
	 * Testing Sigs2WordsProto
	 * VISUAL TEST
	 */
	@Test
    public void verifyParamsForSigs2WordsProto() {
		System.out.println("Test: Sigs2WordsProto Class");
        Sigs2WordsProto.main(new String[]{"4663", "228"});
        System.out.println();
    }
	////////////////////////////////////////////////////////
	/**
	 * Testing signatureToWords(String sig) - sig exists
	 */
	@Test
	public void ListDictionaryTest1() {
		String test = "4663";
		ArrayList<String> words = (ArrayList<String>) d.signatureToWords(test);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("home");
		expected.add("hoof");
		expected.add("good");
		expected.add("goof");
		expected.add("gone");
		expected.add("hood");
		expected.add("hone");
		Collections.sort(words);
		Collections.sort(expected);
		assertEquals(words, expected);
 	}
	/**
	 * Testing signatureToWords(String sig) - sig exists again
	 */
	@Test
	public void ListDictionaryTest1_1() {
		String test = "2";
		ArrayList<String> words = (ArrayList<String>) d.signatureToWords(test);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		Collections.sort(words);
		Collections.sort(expected);
		assertEquals(words, expected);
 	}
	/**
	 * Testing signatureToWords(String sig) - sig does not exists
	 */
	@Test
	public void ListDictionaryTest2() {
		String test = "111";
		Collection<String> words = d.signatureToWords(test);
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(words, expected);
 	}
////////////////////////////////////////////////////////////////////
	/**
	 * Testing WordSig(String word)
	 */
	@Test
	public void WordSigTest1() {
		WordSig test = new WordSig("home");
		String expected = "4663";
		String result = test.getSignature();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig(String word) - empty
	 */
	@Test
	public void WordSigTest2() {
		WordSig test = new WordSig("");
		String expected = "";
		String result = test.getSignature();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig(String word, String sig) - testing getSignature
	 */
	@Test
	public void WordSigTest3() {
		WordSig test = new WordSig("home", "123");
		String expected = "123";
		String result = test.getSignature();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig(String word, String sig) - testing getWord
	 */
	@Test
	public void WordSigTest4() {
		WordSig test = new WordSig("home", "123");
		String expected = "home";
		String result = test.getWord();
		assertEquals(expected, result);
	}
	///////////////////////////////////////////////////////////////////////
	/**
	 * Testing WordSig toString()
	 */
	@Test
	public void WordSigTest5() {
		WordSig test = new WordSig("home", "123");
		String expected = "home : 123";
		String result = test.toString();
		assertEquals(expected, result);
	}
	/**
	 * Testing WordSig equals - identical
	 */
	@Test
	public void WordSigTest6() {
		WordSig test = new WordSig("home", "123");
		WordSig test2 = new WordSig("home", "123");
		assertTrue(test.equals(test2));
	}
	/**
	 * Testing WordSig equals - same sigs, diff word
	 */
	@Test
	public void WordSigTest7() {
		WordSig test = new WordSig("hello", "123");
		WordSig test2 = new WordSig("home", "123");
		assertTrue(test.equals(test2));
	}
	/**
	 * Testing WordSig equals - same word, diff sigs
	 */
	@Test
	public void WordSigTest8() {
		WordSig test = new WordSig("home", "2345");
		WordSig test2 = new WordSig("home", "123");
		assertFalse(test.equals(test2));
	}
	/**
	 * Testing WordSig compareTo - more than
	 */
	@Test
	public void WordSigTest9() {
		WordSig test = new WordSig("home", "2345");
		WordSig test2 = new WordSig("home", "123");
		int result = test.compareTo(test2);
		int expected = 1;
		assertEquals(result, expected);
	}
	/**
	 * Testing WordSig compareTo - less than
	 */
	@Test
	public void WordSigTest10() {
		WordSig test = new WordSig("home", "23");
		WordSig test2 = new WordSig("home", "123");
		int result = test.compareTo(test2);
		int expected = -1;
		assertEquals(result, expected);
	}
	/**
	 * Testing WordSig compareTo - same
	 */
	@Test
	public void WordSigTest11() {
		WordSig test = new WordSig("home", "123");
		WordSig test2 = new WordSig("home", "123");
		int result = test.compareTo(test2);
		int expected = 0;
		assertEquals(result, expected);
	}



}
