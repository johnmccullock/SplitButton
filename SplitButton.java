package main.gui.custom;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class SplitButton extends JButton
{
	private HashMap<String, ImageIcon> mLeftImages = new HashMap<String, ImageIcon>();
	private ImageIcon mRightIcon = null;
	private Insets mLeftInsets = new Insets(0, 0, 0, 0);
	private Insets mRightInsets = new Insets(0, 0, 0, 0);
	private String mLeftCaption = null;
	private String mRightCaption = null;
	private JPanel mBasePanel = null;
	private JLabel mLeftSide = null;
	private JLabel mRightSide = null;
	private JSeparator mSeparator = null;
	private Point mMousePos = new Point();
	private JPopupMenu mPopupMenu = null;
	
	public SplitButton(ImageIcon rightIcon, String leftCaption, String rightCaption, Insets leftInsets, Insets rightInsets)
	{
		this.setRightIcon(rightIcon);
		this.setLeftCaption(leftCaption);
		this.setRightCaption(rightCaption);
		this.setLeftInsets(leftInsets);
		this.setRightInsets(rightInsets);
		this.initializeMain();
		return;
	}
	
	private void initializeMain()
	{
		this.setMargin(new Insets(0, 0, 0, 0));
		this.mBasePanel = new JPanel();
		return;
	}
	
	public void layoutPanel(String initialKey)
	{
		this.mBasePanel.setLayout(new GridBagLayout());
		this.mBasePanel.setOpaque(false);
		
		this.layoutLeftSide(initialKey);
		this.mBasePanel.add(this.mLeftSide, new GridBagConstraints(0, 0, 1, 1, 0.5, 0.0,
				GridBagConstraints.WEST,
				GridBagConstraints.BOTH,
				this.mLeftInsets,
				0, 0));
		
		this.mSeparator = new JSeparator();
		this.mSeparator.setOrientation(JSeparator.VERTICAL);
		this.mBasePanel.add(this.mSeparator, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
		
		this.layoutRightSide();
		this.mBasePanel.add(this.mRightSide, new GridBagConstraints(2, 0, 1, 1, 0.5, 0.0,
				GridBagConstraints.EAST,
				GridBagConstraints.BOTH,
				this.mRightInsets,
				0, 0));
		this.add(this.mBasePanel);
		return;
	}
	
	private void layoutLeftSide(String initialKey)
	{
		this.mLeftSide = new JLabel();
		this.mLeftSide.setIcon(this.mLeftImages.get(initialKey));
		this.mLeftSide.setText(this.mLeftCaption);
		return;
	}
	
	private void layoutRightSide()
	{
		this.mRightSide = new JLabel();
		this.mRightSide.setIcon(this.mRightIcon);
		this.mRightSide.setText(this.mRightCaption);
	}
	
	@Override
	public Dimension getMinimumSize()
	{
		return this.getPreferredSize();
	}
	
	@Override
	public Dimension getMaximumSize()
	{
		return this.getPreferredSize();
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		int width = this.mLeftSide.getIcon().getIconWidth() + this.mLeftInsets.left + this.mLeftInsets.right;
		width += this.mRightIcon.getIconWidth() + this.mRightInsets.left + this.mRightInsets.right;
		width += this.mSeparator.getWidth() + this.mSeparator.getInsets().left + this.mSeparator.getInsets().right;
		int height = Math.max(this.mLeftSide.getIcon().getIconHeight() + this.mLeftInsets.top + this.mLeftInsets.bottom,
				this.mRightIcon.getIconHeight() + this.mRightInsets.top + this.mRightInsets.bottom);
		return new Dimension(width + 10, height + 6); // I don't understand where this extra 10 or 6 is hiding.
	}
	
	public void setRightIcon(ImageIcon icon)
	{
		this.mRightIcon = icon;
		return;
	}
	
	public ImageIcon getRightIcon()
	{
		return this.mRightIcon;
	}
	
	public void setLeftInsets(Insets margin)
	{
		this.mLeftInsets = margin;
		return;
	}
	
	public Insets getLeftInsets()
	{
		return this.mLeftInsets;
	}
	
	public void setRightInsets(Insets margin)
	{
		this.mRightInsets = margin;
		return;
	}
	
	public Insets getRightInsets()
	{
		return this.mRightInsets;
	}
	
	public void setLeftCaption(String caption)
	{
		this.mLeftCaption = caption;
		return;
	}
	
	public String getLeftCaption()
	{
		return this.mLeftCaption;
	}
	
	public void setRightCaption(String caption)
	{
		this.mRightCaption = caption;
		return;
	}
	
	public String getRightCaption()
	{
		return this.mRightCaption;
	}
	
	public void setMousePos(Point p)
	{
		this.mMousePos = p;
		return;
	}
	
	public Point getMousePos()
	{
		return this.mMousePos;
	}
	
	public JSeparator getSeparator()
	{
		return this.mSeparator;
	}
	
	public void setButtonPopupMenu(JPopupMenu popup)
	{
		this.mPopupMenu = popup;
		return;
	}
	
	public void showButtonPopupMenu(int x, int y)
	{
		this.mPopupMenu.show(this, x, y);
		return;
	}
	
	public void addLeftIcon(String key, ImageIcon icon)
	{
		this.mLeftImages.put(key, icon);
		return;
	}
	
	public void switchImageIcon(String key)
	{
		this.mLeftSide.setIcon(this.mLeftImages.get(key));
		this.repaint();
		return;
	}
}
