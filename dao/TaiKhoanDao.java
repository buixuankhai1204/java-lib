package qltv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;

import qltv.entity.TaiKhoan;
import qltv.SuKien.DocGia.Them.ThemView;
import qltv.SuKien.NguoiDung.Sua.SuaView;
import qltv.dao.ConnectMySQL;

public class TaiKhoanDao extends ConnectMySQL {
	private qltv.SuKien.NguoiDung.Them.ThemView themView;
	private SuaView suaView;
	public ArrayList<TaiKhoan> layTaiKhoan()
	{
		ArrayList<TaiKhoan> ds= new ArrayList<TaiKhoan>();
		try
		{
			String sql="Select * from taikhoan";
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				TaiKhoan tk= new TaiKhoan();
				tk.setUser(result.getString(1));
				tk.setPass(result.getString(2));
				tk.setPhanQuyen(result.getInt(3));
				tk.setTenND(result.getString(4));
				tk.setSoDienThoai(result.getString(5));
				tk.setCMND(result.getString(6));
				ds.add(tk);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
	
	public ArrayList<TaiKhoan> layTaiKhoanTheoUser(String User)
	{
		ArrayList<TaiKhoan> ds=new ArrayList<TaiKhoan>();
		try
		{
			String sql="Select * from taikhoan where user=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, User);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				TaiKhoan tk= new TaiKhoan();
				tk.setUser(result.getString(1));
				tk.setPass(result.getString(2));
				tk.setPhanQuyen(result.getInt(3));
				tk.setTenND(result.getString(4));
				tk.setSoDienThoai(result.getString(5));
				tk.setCMND(result.getString(6));
				ds.add(tk);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return ds;
	}
	
	public int insert(TaiKhoan taiKhoan) {
		try
		{
			int n=0;
			if(themView.getRadAdmin().isSelected())
			{
				n=1;
			}
			if(themView.getRadThuThu().isSelected())
			{
				n=2;
			}
			String sql="insert into taikhoan values (?,?,?,?,?,?)";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, taiKhoan.getUser());
			pre.setString(2, taiKhoan.getPass());
			pre.setInt(3,n);
			pre.setString(4, taiKhoan.getTenND());
			pre.setString(5, taiKhoan.getSoDienThoai());
			pre.setString(6, taiKhoan.getCMND());
			return pre.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,ex.getMessage()); 
		}
		return -1;
	}
	
	public boolean delete(String maNguoiDung) {
		try
		{
			String sql="Delete from taikhoan where user=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, maNguoiDung);
			return pre.executeUpdate() > 0;
			
		}
		catch( Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return false;
	}
	
	public int update(TaiKhoan taiKhoan) {
		try
		{
			String sql="Update taikhoan set Password=?,PhanQuyen=?,TenND=?,SDT=?,CMND=? where User=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, taiKhoan.getPass());
			if(suaView.getTxtPhanQuyen().getText().equals("Admin"))
			{
				pre.setInt(2,1);
			}
			else
				pre.setInt(2,2);
			pre.setString(3, suaView.getTxtHoTen().getText());
			pre.setString(4, suaView.getTxtSDT().getText());
			pre.setString(5, suaView.getTxtCMND().getText());
			pre.setString(6, suaView.getTxtTaiKhoan().getText());
			return pre.executeUpdate();
		}
		catch ( Exception ex )
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,ex.getMessage());

		}
		return -1;
	}
}
