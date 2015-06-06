package com.learning.algorithm.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UnionIterator implements Iterator<String> {
	Collection<Iterator<String>> c;
	
	
	public UnionIterator(Collection<Iterator<String>> c) {
		this.c=c;
		}

	@Override
	public boolean hasNext() {
		
		if(!c.isEmpty()){
			for (Iterator iterator = c.iterator(); iterator.hasNext();) {
				Iterator<String> iterator2 = (Iterator<String>) iterator.next();
				 if(iterator2.hasNext()){
					 return true;
				 }
			}
		}
				
		return false;
	}

	@Override
	public String next() {
		
		for (Iterator iterator = c.iterator(); iterator.hasNext();) {
			Iterator<String> iterator2 = (Iterator<String>) iterator.next();
			 if(iterator2.hasNext()){
				 return iterator2.next();
			 }
			
		}
		
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		List l1 = new ArrayList<String>();
		List l2 = new ArrayList<String>();
		l1.add("abc");l1.add("def");
		l2.add("fer");l2.add("hgy");
		
		Collection<Iterator<String>> ct = new ArrayList<Iterator<String>>();
		ct.add(l1.iterator());
		ct.add(l2.iterator());
		
		UnionIterator ut = new UnionIterator(ct);
				
		while(ut.hasNext()){
			System.out.println(ut.next());
		}
		
		
		
	}
	
	
}
