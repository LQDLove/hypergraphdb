package org.hypergraphdb.atom;

import java.util.HashSet;
import java.util.Set;

import org.hypergraphdb.HGHandle;
import org.hypergraphdb.HGPlainLink;

/**
 * 
 * <p>
 * A <code>HGBergeLink</code> represent a <em>hyperarc</em> or <em>hyperedge</em> in the 
 * mathematical theory of hypergraphs. A hyperarc has a target set that is partitioned
 * into a <em>head</em> and a <em>tail</em>. 
 * </p>
 * 
 * @author Borislav Iordanov
 */
public class HGBergeLink extends HGPlainLink
{
	private int tailIndex = -1;
	
	public HGBergeLink(int tailIndex, HGHandle...targets)
	{
		super(targets);
		this.tailIndex = tailIndex;
	}
	
	public HGBergeLink(HGHandle [] head, HGHandle [] tail)
	{
		HGHandle [] targets = new HGHandle[head.length + tail.length];
		System.arraycopy(head, 0, targets, 0, head.length);
		System.arraycopy(tail, 0, targets, head.length, tail.length);
		tailIndex = head.length;
	}

	public Set<HGHandle> getHead()
	{
		HashSet<HGHandle> set = new HashSet<HGHandle>();
		for (int i = 0; i < tailIndex; i++)
			set.add(getTargetAt(i));
		return set;
	}
	
	public Set<HGHandle> getTail()
	{
		HashSet<HGHandle> set = new HashSet<HGHandle>();
		for (int i = tailIndex; i < getArity(); i++)
			set.add(getTargetAt(i));
		return set;		
	}
	
	public int getTailIndex()
	{
		return tailIndex;
	}

	public void setTailIndex(int tailIndex)
	{
		this.tailIndex = tailIndex;
	}	
}