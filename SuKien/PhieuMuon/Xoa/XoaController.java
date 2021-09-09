package qltv.SuKien.PhieuMuon.Xoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class XoaController {
	private XoaView xoaView;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	public String MaPM="";
	
	public XoaController(XoaView xoaView) {
		this.xoaView = xoaView;
		xoaView.addListener(new Del());
	}
	
	public void showXoaView() {
		xoaView.setMoDal(true);
		xoaView.setVisible(true);
	}
	
	class Del implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			xoaView.delete();
			xoaView.load();
		}
	}
}
