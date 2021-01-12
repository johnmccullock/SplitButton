package main.gui.custom;

import java.util.EventListener;

public interface SplitButtonActionEventListener extends EventListener
{
	abstract void splitButtonLeftActionPerformed(SplitButtonActionEvent e);
	abstract void splitButtonRightActionPerformed(SplitButtonActionEvent e);
}
