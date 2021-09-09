package qltv.SuKien.PhieuMuon.ThemSach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import qltv.dao.ConnectMySQL;

public class ThemSachController {
	private ThemSachView themSachView;
	Connection conn = qltv.dao.ConnectMySQL.connect;
	
	public ThemSachController(ThemSachView themSachView) {
		this.themSachView = themSachView;
		themSachView.addListener(new Add());
	}
	
	public void showThemSachView() {
		themSachView.setMoDal(true);
		themSachView.setVisible(true);
	}
	
	class Add implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				String sql="insert into ctpm values(?,?,?,?,?,?,?)";
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1,themSachView.getTxtMaPM().getText());
				pre.setString(2, themSachView.getTxtMaSach().getText());
				pre.setDate(3, null);
				pre.setString(4, themSachView.getTxtTinhTrangSach().getText());
				pre.setString(5, null);
				pre.setString(6,null);
				pre.setString(7,null);
				int soluongsach=0;
				if( themSachView.getTxtMaSach().getText().length() == 0 || themSachView.getTxtTinhTrangSach().getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "Không được để trống");
					return;
				}
				try
				{
					String sqlss="Select SoLuong from sach where MaSach=?";
					PreparedStatement presach=ConnectMySQL.connect.prepareStatement(sqlss);
					presach.setString(1, themSachView.getTxtMaSach().getText());
					ResultSet rssach=presach.executeQuery();
					while(rssach.next())
					{
						soluongsach=rssach.getInt(1);
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				if(soluongsach == 0)
				{
					JOptionPane.showMessageDialog(null, "Sách hết.Xin vui lòng chọn cuốn khác !");
					themSachView.dispose();
					return;
				}
				soluongsach--;
				
				try
				{
					String sqlss1="update sach set SoLuong=? where MaSach=?";
					PreparedStatement presach1=ConnectMySQL.connect.prepareStatement(sqlss1);
					presach1.setInt(1, soluongsach);
					presach1.setString(2, themSachView.getTxtMaSach().getText());
					int c=presach1.executeUpdate();
					if(c>0)
					{
						JOptionPane.showMessageDialog(null, "Cập nhật số lượng sách thành công");
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				int x=pre.executeUpdate();
				if(x>0)
				{
					JOptionPane.showMessageDialog(null, "Thêm sách thành công");
					themSachView.dispose();
				}
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
	}
}
