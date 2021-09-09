package qltv.SuKien.DocGia.Them;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ThemController {
	private ThemView themView;
	Connection connect = qltv.dao.ConnectMySQL.connect;
	
	public ThemController(ThemView themView) {
		this.themView = themView;
		themView.addListener(new Add());
	}
	
	public void showThemView() {
		themView.setModal(true);
		themView.setVisible(true);
	}
	
	class Add implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			if(themView.valiform() == true) {
				themView.insert();
				themView.load();
			}
		}
	}
}
