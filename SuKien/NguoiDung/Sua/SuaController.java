package qltv.SuKien.NguoiDung.Sua;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import qltv.view.QuanLyNguoiDungView;

public class SuaController {
	private SuaView suaView;
	Connection connect = qltv.dao.ConnectMySQL.connect;
	
	public SuaController(SuaView suaView) {
		this.suaView = suaView;
		suaView.addListener(new Sua());
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
