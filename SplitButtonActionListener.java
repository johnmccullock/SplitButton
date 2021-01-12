package main.gui.custom;

import java.util.Enumeration;
import java.util.EventListener;
import java.util.Vector;

public class SplitButtonActionListener
{
	private static Vector<EventListener> mListeners = new Vector<EventListener>();
	
	public static void addListener(SplitButtonActionEventListener e)
	{
		mListeners.addElement(e);
		return;
	}
	
	public static void removeListener(SplitButtonActionEventListener e)
	{
		mListeners.removeElement(e);
		return;
	}
	
	public static void notifyAction(Object source, int side)
	{
		SplitButtonActionEvent e = new SplitButtonActionEvent(source, side);
		Enumeration<EventListener> en = mListeners.elements();
		
		while(en.hasMoreElements())
		{
			((SplitButtonActionEventListener)en.nextElement()).splitButtonLeftActionPerformed(e);
		}
		return;
	}
	
	public static void notifyAction(Object source, int side, int x, int y)
	{
		SplitButtonActionEvent e = new SplitButtonActionEvent(source, side, x, y);
		Enumeration<EventListener> en = mListeners.elements();
		
		while(en.hasMoreElements())
		{
			((SplitButtonActionEventListener)en.nextElement()).splitButtonRightActionPerformed(e);
		}
		return;
	}
}
