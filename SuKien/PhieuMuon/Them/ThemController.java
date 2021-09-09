package qltv.SuKien.PhieuMuon.Them;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import qltv.dao.ConnectMySQL;

public class ThemController {
	private ThemView themView;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	public String MaPM="",tentk="";
	
	public ThemController(ThemView themView) {
		this.themView = themView;
		themView.addListener(new Add());
	}
	
	public void showThemView() {
		themView.setMoDal(true);
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
