package qltv.SuKien.Sach.Them;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
public class ThemSachController {
	private ThemSachView themSachView;
	String ma = "";
	Connection conn=qltv.dao.ConnectMySQL.connect;
	
	public ThemSachController(ThemSachView themSachView) {
		this.themSachView = themSachView;
		themSachView.addListener(new Add());
	}
	
	public void showThemSachView() {
		themSachView.setModal(true);
		themSachView.setVisible(true);
	}
	
	class Add implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int flag = 1;
			try 
			{

				String sql = "select * from sach where masach=?";
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setString(1, themSachView.getTxtMaSach().getText());
				ResultSet rs = pre.executeQuery();

				if (rs.next()) 
				{
					flag = 0;
				}
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}

			if (flag == 0) 
			{
				JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại!");
				return;
			}

			if (themSachView.getTxtMaSach().getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "Mã sách không được để trống");
				return;
			}
			
			if(themSachView.valiform()==true) {
				themSachView.insert();
				themSachView.load();
			}
//			try 
//			{
//				String sql = "insert into sach values (?,?,?,?,?,?,?)";
//				PreparedStatement pre = conn.prepareStatement(sql);
//				pre.setString(1, themSachView.getTxtMaSach().getText());
//				pre.setString(2, themSachView.getTxtTenSach().getText());
//				pre.setString(3, themSachView.getTxtTenTG().getText());
//				pre.setString(4, themSachView.getTxtNhaXB().getText());
//				pre.setString(5, themSachView.getTxtTheLoai().getText());
//				pre.setInt(6, Integer.parseInt(themSachView.getTxtSoLuong().getText()));
//				pre.setInt(7, Integer.parseInt(themSachView.getTxtGia().getText()));
//				int x = pre.executeUpdate();
//				if (x > 0) 
//				{
//					JOptionPane.showMessageDialog(null, "Thêm thành công");
//				}
//
//			} 
//			catch (Exception ex)
//			{
//				ex.printStackTrace();
//			}
		}
	}
}
