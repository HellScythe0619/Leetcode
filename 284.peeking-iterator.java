/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Design by ArrayList
 * runtime: 75.5% (4 ms)
 * memory: 69.18% (42 MB)
 */
// class PeekingIterator implements Iterator<Integer> {
// 	List<Integer> list;
// 	int index = 0;

// 	public PeekingIterator(Iterator<Integer> iterator) {
// 		// initialize any member here.
// 		list = new ArrayList<>();
// 		while (iterator.hasNext()) {
// 			list.add(iterator.next());
// 		}
// 	}

// 	// Returns the next element in the iteration without advancing the iterator.
// 	public Integer peek() {
// 		return list.get(index);
// 	}

// 	// hasNext() and next() should behave the same as in the Iterator interface.
// 	// Override them if needed.
// 	@Override
// 	public Integer next() {
// 		Integer result = list.get(index);
// 		index++;
// 		return result;
// 	}

// 	@Override
// 	public boolean hasNext() {
// 		return index < list.size();
// 	}
// }

/**
 * Design by Iterator
 * runtime: 100% (3 ms)
 * memory: 37.9% (42.3 MB)
 */
class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer buffer;
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
		buffer = iterator.hasNext() ? iterator.next() : null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return buffer;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer next = buffer;
		// iterator 進下一位
		buffer = iterator.hasNext() ? iterator.next() : null;
		return next;
	}
	
	@Override
	public boolean hasNext() {
		return buffer != null;
	}
}
// @lc code=end

