package qltv.SuKien.Sach.Sua;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class SuaSachController {
	Connection conn=qltv.dao.ConnectMySQL.connect;
	private SuaSachView suaSachView;
	
	public SuaSachController(SuaSachView suaSachView) {
		this.suaSachView = suaSachView;
		suaSachView.addListener(new Sua());
	}
	
	public void showSuaSachView() {
		suaSachView.setMoDal(true);
		suaSachView.setVisible(true);
	}
	
	class Sua implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			String ma = suaSachView.getTxtMaSach().getText();
			if(suaSachView.valiform() == true) {
				suaSachView.update();
				suaSachView.load();
			}
		}
	}
}
	
