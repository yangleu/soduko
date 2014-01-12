package testpackage;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class FakeEditor extends AbstractCellEditor
implements TableCellEditor,
ActionListener  {

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println( ((new Exception()).getStackTrace())[1].getMethodName() + "I'm called");
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1,
			boolean arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		System.out.println( ((new Exception()).getStackTrace())[1].getMethodName() + "I'm called");

		return null;
	}

}
