package qltv.SuKien.DocGia.Sua;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class SuaController {
	Connection conn=qltv.dao.ConnectMySQL.connect;
	private SuaView suaView;
	public SuaController(SuaView suaView) {
		this.suaView = suaView;
		suaView.adddListener(new Sua());
	}
	
	public void showSuaView() {
		suaView.setMoDal(true);
		suaView.setVisible(true);
	}
	
	class Sua implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			if(suaView.valiform() == true) {
				suaView.update();
				suaView.load();
			}
		}
	}
}
