package main.gui.custom;

import java.util.EventObject;

@SuppressWarnings("serial")
public class SplitButtonActionEvent extends EventObject
{
	public static final int LEFT_SIDE = 0;
	public static final int RIGHT_SIDE = 1;
	
	private int mSide = LEFT_SIDE;
	private int mParentX = 0;
	private int mParentY = 0;
	
	public SplitButtonActionEvent(Object source, int side)
	{
		super(source);
		this.mSide = side;
		return;
	}
	
	public SplitButtonActionEvent(Object source, int side, int x, int y)
	{
		super(source);
		this.mSide = side;
		this.mParentX = x;
		this.mParentY = y;
		return;
	}
	
	public int getSide()
	{
		return this.mSide;
	}
	
	public int getParentX()
	{
		return this.mParentX;
	}
	
	public int getParentY()
	{
		return this.mParentY;
	}
}
