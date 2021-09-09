package qltv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import qltv.SuKien.DocGia.Sua.SuaView;
import qltv.SuKien.DocGia.Them.ThemView;
import qltv.entity.DocGia;
import qltv.entity.Sach;
import qltv.view.QuanLySachView;

public class DocGiaDao extends ConnectMySQL {
	private ThemView themView;
	SuaView suaView;
	public ArrayList<DocGia> layToanBoDocGia()
	{
		ArrayList<DocGia> dsdg=new ArrayList<DocGia>();
		try
		{
			String sql="select * from docgia";
			PreparedStatement pre=connect.prepareStatement(sql);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				DocGia dg=new DocGia();
				dg.setMaDG(result.getString(1));
				dg.setTenDG(result.getString(2));
				dg.setSoDienThoai(result.getString(3));
				dg.setDiaChi(result.getString(4));
				dg.setGioiTinh(result.getString(5));
				dg.setMatSach(result.getInt(6));	
				dsdg.add(dg);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dsdg;
	}
	public ArrayList<DocGia> timDocGiaTheoMaDG(String madg)
	{
		ArrayList<DocGia> dsdg=new ArrayList<DocGia>();
		try
		{
			String sql="select * from docgia where madg=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, madg);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				DocGia dg=new DocGia();
				dg.setMaDG(result.getString(1));
				dg.setTenDG(result.getString(2));
				dg.setDiaChi(result.getString(3));
				dg.setGioiTinh(result.getString(4));
				dg.setSoDienThoai(result.getString(5));
				dsdg.add(dg);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dsdg;
	}
	
	public int insert (DocGia docGia) {
		try {

			String sql = "insert into docgia values (?,?,?,?,?,0)";
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, docGia.getMaDG());
			pre.setString(2, docGia.getTenDG());
			pre.setString(3, docGia.getSoDienThoai());
			pre.setString(4, docGia.getDiaChi());
			pre.setString(5, (String) themView.getCb().getSelectedItem() );
			return pre.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public boolean delete(String maDocGia) {
		try {
			String sql = "delete from docgia where madg=?";
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, maDocGia);
			return pre.executeUpdate() > 0;
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return false;
	}
	
	public int update(DocGia docGia) {
		try {
			try 
			{
				String sql = "update docgia set  tendg=?, sdt=?, diachi=?, gioitinh=? where madg=?";
				PreparedStatement pre = connect.prepareStatement(sql);
				pre.setString(1, docGia.getTenDG());
				pre.setString(2, docGia.getSoDienThoai());
				pre.setString(3, docGia.getDiaChi());
				pre.setString(4, (String) suaView.getCb().getSelectedItem());
				pre.setString(5, docGia.getMaDG());	
				return pre.executeUpdate();
			} 
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			return -1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
}
