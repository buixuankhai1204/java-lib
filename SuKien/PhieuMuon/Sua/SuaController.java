package qltv.SuKien.PhieuMuon.Sua;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import qltv.SuKien.PhieuMuon.Them.ThemController;
import qltv.SuKien.PhieuMuon.Them.ThemView;
import qltv.SuKien.PhieuMuon.ThemSach.ThemSachController;
import qltv.SuKien.PhieuMuon.ThemSach.ThemSachView;
import qltv.SuKien.PhieuMuon.Xoa.XoaController;
import qltv.SuKien.PhieuMuon.Xoa.XoaView;
import qltv.SuKien.PhieuMuon.XoaSach.XoaSachController;
import qltv.SuKien.PhieuMuon.XoaSach.XoaSachView;

public class SuaController {
	private SuaView suaView;
	int soluongsau=0;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	public String MaPM="";
	
	public SuaController(SuaView suaView) {
		this.suaView = suaView;
		suaView.addListener(new Sua());
	}
	
	public void showSuaView() {
		suaView.setMoDal(true);
		suaView.setVisible(true);
	}
	
	class Sua implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 suaView.update();
			 suaView.load();
		}
	}
}
