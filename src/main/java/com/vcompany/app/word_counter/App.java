package com.vcompany.app.word_counter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Reader reader = new Reader();
		Long wordsCount = 0l;
		String fileText = reader.readFile(args[0]);
		if (fileText != null) {
			try {
				wordsCount = Long.parseLong(args[1]);
				if (wordsCount > 0) {
					fileText = prepareText(fileText);
					countWords(fileText, wordsCount);
				} else {
					System.out.println("Words count must be > 0");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Wrong argument format!");
			}

		} else {
			System.out.println("File not found or something went wrong, try one more time");
		}
	}

	public static String prepareText(String text) {
		text = text.toLowerCase();
		text = text.replaceAll(",", " ");
		text = text.replaceAll("\\.", " ");
		text = text.replaceAll(";", " ");
		return text.trim().replaceAll(" +", " ");
	}

	public static String countWords(String text, Long wordsCount) {
		String words[] = text.split(" ");
		Map<String, Integer> mapForCounting = new HashMap<>();
		for (String word : words) {
			if (mapForCounting.get(word) == null) {
				mapForCounting.put(word, 1);
			} else {
				mapForCounting.put(word, (mapForCounting.get(word) + 1));
			}
		}
		Set<Entry<String, Integer>> set = mapForCounting.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>();
		list.addAll(set);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int i = o2.getValue().compareTo(o1.getValue());
				if (i != 0) {
					return i;
				}
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		Iterator<Entry<String, Integer>> iterator = list.iterator();
		String result = "";
		while (iterator.hasNext()) {
			Entry<String, Integer> mentry = iterator.next();
			if (mentry.getValue() > wordsCount) {
				System.out.println(mentry.getKey() + "=" + mentry.getValue());
				result += mentry.getKey() + "=" + mentry.getValue();
			} else {
				break;
			}
		}
		return result;
	}
}
