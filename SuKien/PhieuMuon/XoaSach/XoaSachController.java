package qltv.SuKien.PhieuMuon.XoaSach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import qltv.dao.ConnectMySQL;


public class XoaSachController {
	private XoaSachView xoaSachView;
	Connection conn = qltv.dao.ConnectMySQL.connect;
	
	public XoaSachController(XoaSachView xoaSachView) {
		this.xoaSachView = xoaSachView;
		xoaSachView.addListener(new Del());
	}
	
	public void showXoaSachView() {
		xoaSachView.setMoDal(true);
		xoaSachView.setVisible(true);
	}
	
	class Del implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			
			try
			{
				String sql="delete from ctpm where MaPM=? and MaSach=?";
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1,xoaSachView.getTxtMaPM().getText());
				pre.setString(2, String.valueOf(xoaSachView.getCbMaSach().getSelectedItem()));
				int soluongsach=0;
				try
				{
					String sqlss="Select SoLuong from sach where MaSach=?";
					PreparedStatement presach=ConnectMySQL.connect.prepareStatement(sqlss);
					presach.setString(1,String.valueOf(xoaSachView.getCbMaSach().getSelectedItem()));
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
				soluongsach++;
				
				try
				{
					String sqlss1="update sach set SoLuong=? where MaSach=?";
					PreparedStatement presach1=ConnectMySQL.connect.prepareStatement(sqlss1);
					presach1.setInt(1, soluongsach);
					presach1.setString(2, String.valueOf(xoaSachView.getCbMaSach().getSelectedItem()));
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
					JOptionPane.showMessageDialog(null, "Xóa sách thành công");
					xoaSachView.dispose();
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
