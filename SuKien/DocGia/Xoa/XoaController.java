package qltv.SuKien.DocGia.Xoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class XoaController {
	Connection 	connect=qltv.dao.ConnectMySQL.connect;
	private XoaView xoaView;
	public String machon="";
	
	public XoaController(XoaView xoaView) {
		this.xoaView = xoaView;
		xoaView.addListener(new Del());
	}
	
	public void showXoaView() {
		xoaView.setMoDal(true);
		xoaView.setVisible(true);
	}
	
	class Del implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			xoaView.delete();
			xoaView.clear();
			xoaView.load();
		}
	}
}
