package qltv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import qltv.entity.PhieuMuon;
import qltv.SuKien.PhieuMuon.Sua.SuaView;
import qltv.SuKien.PhieuMuon.Them.ThemController;
import qltv.SuKien.PhieuMuon.Them.ThemView;
import qltv.SuKien.PhieuMuon.ThemSach.ThemSachController;
import qltv.SuKien.PhieuMuon.ThemSach.ThemSachView;
import qltv.SuKien.PhieuMuon.XoaSach.XoaSachController;
import qltv.SuKien.PhieuMuon.XoaSach.XoaSachView;
import qltv.dao.ConnectMySQL;
public class PhieuMuonDao extends ConnectMySQL {
	ThemView themView;
	SuaView suaView;
	public ArrayList<PhieuMuon> layThongTinPhieuMuon()
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon";
			PreparedStatement pre=connect.prepareStatement(sql);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
				pm.setMaPM(result.getString(1));
				pm.setMaDG(result.getString(2));
				pm.setNgayMuon(result.getDate(3));
				pm.setNgayTra(result.getDate(4));
				pm.setSoLuong(result.getInt(5));
				pm.setUser(result.getString(6));
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}
	public ArrayList<PhieuMuon> timKiemPhieuMuonTheoMaKH(String ma) 
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon where makh=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, ma);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
			
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}
	public ArrayList<PhieuMuon> timKiemPhieuMuonTheoMaPM(String mapm) 
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon where maphieu=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, mapm);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
			
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}
	public ArrayList<PhieuMuon> timKiemPhieuMuonTheoMaSach(String masach) 
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon where masach=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, masach);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
			
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}
	
	public int insert(PhieuMuon phieuMuon) {
		try	
		{
			int soluong2=0;
			DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
			String datemuon=df.format(themView.getChoosedate().getDate());
	        String datehentra=df.format(themView.getChoosedate1().getDate());
			String sql="insert into phieumuon values(?,?,?,?,?,?)";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, phieuMuon.getMaPM());
			pre.setString(2, phieuMuon.getMaDG());
			pre.setString(3, datemuon);
			pre.setString(4, datehentra);
			pre.setString(5, themView.getTxtSachMuon().getText());
			pre.setString(6, themView.getTxtThuThu().getText());		
			try
			{
				String sqldocgia1="Select MatSach from docgia where MaDG=?";
				PreparedStatement prex=ConnectMySQL.connect.prepareStatement(sqldocgia1);
				prex.setString(1, themView.getTxtMaDG().getText());
				ResultSet b=prex.executeQuery();
				while(b.next())
				{
					soluong2=b.getInt(1);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(soluong2 == 3)
			{
				JOptionPane.showMessageDialog(null, "Bạn đã làm mất sách 3 lần. Bạn không được mượn sách nữa.Thanks!");
				themView.dispose();
			}
			return pre.executeUpdate();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return -1;
	}
	
	public boolean delete(String ma) {
		try
		{
			String sql="Delete from phieumuon where mapm=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, ma);
			try
			{
				String sql1="Delete from ctpm where mapm=?";
				PreparedStatement pre1=connect.prepareStatement(sql1);
				pre1.setString(1, ma);
				int x1=pre1.executeUpdate();
				if(x1>0)
				{
					JOptionPane.showMessageDialog(null, "Xóa phiếu trả thành công");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
			return pre.executeUpdate() > 0;
			
		}
		catch( Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return false;
	}
	
	public int update(PhieuMuon phieuMuon) {
		try
		{
			DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
	        String datemuon=df.format(suaView.getChoosedate().getDate());
	        String datehantra=df.format(suaView.getChoosedate1().getDate());
			String sql="update phieumuon set MaDg=?,NgayMuon=?,NgayHenTra=?,SoLuongMuon=?,User=? where MaPM=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, phieuMuon.getMaDG());
			pre.setString(2,datemuon);
			pre.setString(3, datehantra);
			pre.setString(4,suaView.getTxtSachMuon().getText());
			pre.setString(5,suaView.getTxtThuThu().getText());
			pre.setString(6, suaView.getTxtMaPhieu().getText());
			return pre.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return -1;
	}
}
