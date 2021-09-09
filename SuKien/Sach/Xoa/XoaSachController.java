package qltv.SuKien.Sach.Xoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class XoaSachController extends JFrame{
	public String ma = "";
	private XoaSachView xoaSachView;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	
	public XoaSachController(XoaSachView xoaSachView) {
		this.xoaSachView = xoaSachView;
		xoaSachView.addListener(new Del());
	}
	
	public void showXoaSachView() {
		xoaSachView.setModal(true);
		xoaSachView.setVisible(true);
	}
	
	class Del implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ma = xoaSachView.getTxtMaSach().getText();
			int flag = 1;
			try {

				String sql = "select * from ctpm where masach=?";
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setString(1, ma);
				ResultSet rs = pre.executeQuery();

				if (rs.next()) {
					flag = 0;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (flag == 0) {
				JOptionPane.showMessageDialog(null, "Sách còn tồn tại trong phiếu mượn");
				return;
			}
			xoaSachView.delete();
			xoaSachView.clear();
			xoaSachView.load();
//			try {
//
//				String sql = "delete from sach where masach=?";
//				PreparedStatement pre = conn.prepareStatement(sql);
//				pre.setString(1, ma);
//
//				int x = pre.executeUpdate();
//
//				if (x > 0) {
//					JOptionPane.showMessageDialog(null, "Xóa thành công");
//					xoaSachView.dispose();
//				}
//
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
		}
	}
}
