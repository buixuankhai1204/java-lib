package qltv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import qltv.SuKien.DocGia.Xoa.XoaController;
import qltv.SuKien.PhieuMuon.Sua.SuaView;
import qltv.SuKien.PhieuMuon.Them.ThemController;
import qltv.SuKien.PhieuMuon.Them.ThemView;
import qltv.SuKien.PhieuMuon.ThemSach.ThemSachView;
import qltv.SuKien.PhieuMuon.Xoa.XoaView;
import qltv.dao.ConnectMySQL;
import qltv.dao.SachDao;
import qltv.entity.Sach;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyPhieuMuonView;
import qltv.view.QuanLyThuThuView;
import qltv.view.ThongKeView;

public class QuanLyPhieuMuonController {
	ArrayList<Sach> dssach;
	public String tentk="";
	public int thongke=0;
	private QuanLyPhieuMuonView quanLyPhieuMuonView;
	Connection conn=ConnectMySQL.connect;
	
	public QuanLyPhieuMuonController(QuanLyPhieuMuonView quanLyPhieuMuonView) {
		this.quanLyPhieuMuonView = quanLyPhieuMuonView;
		quanLyPhieuMuonView.addListener(new Back());
		quanLyPhieuMuonView.addListener1(new TblPhieuMuon());
		quanLyPhieuMuonView.addListener2(new Them());
		quanLyPhieuMuonView.addListener3(new Xoa());
		quanLyPhieuMuonView.addListener4(new Sua());
	}
	public void showQuanLyPhieuMuonView() {
		quanLyPhieuMuonView.setModal(true);
		quanLyPhieuMuonView.setVisible(true);
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
			int phanquyen=0;
			if(thongke == 1)
			{
				ThongKeView tkv = new ThongKeView("Thống kê");
				ThongKeController tkc = new ThongKeController(tkv);
				tkc.tenTk = tentk;
				tkc.showThongKeView();
				quanLyPhieuMuonView.dispose();
				thongke =0;
				return;
			}
			try 
			{

				String sql="select PhanQuyen from taikhoan where User=?";
				PreparedStatement pre=ConnectMySQL.connect.prepareStatement(sql);
				pre.setString(1, tentk);
				ResultSet rs=pre.executeQuery();
				while(rs.next())
				{
					phanquyen=rs.getInt(1);
				}
			}
			catch( Exception ex)
			{
				ex.printStackTrace();
			}
			if(phanquyen == 1)
			{
				
				QuanLyAdminView qladv = new QuanLyAdminView("Trang Chủ Phần Mềm Quản Lý Thư Viện");
				QuanLyAdminController qladc = new QuanLyAdminController(qladv);
				qladc.tentk = tentk;
				qladc.showQuanlyAdminView();
				quanLyPhieuMuonView.dispose();	
			}
			if(phanquyen == 2)
			{
				QuanLyThuThuView qladv = new QuanLyThuThuView("Thủ thư:" + tentk);
				QuanLyThuThuController qladc = new QuanLyThuThuController(qladv);
				qladc.tentk = tentk;
				qladc.showQuanLyThuThuView();;
				quanLyPhieuMuonView.dispose();
			}
		}
	}
	class TblPhieuMuon implements MouseListener{
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			int n=quanLyPhieuMuonView.gettblPhieuMuon().getSelectedRow();
			Object obj=quanLyPhieuMuonView.getdtmPhieuMuon().getValueAt(n,0);
			String mapm=String.valueOf(obj);
			SachDao sachsv=new SachDao();
			dssach=sachsv.laySachTheoPhieuMuon(mapm);
			quanLyPhieuMuonView.getdtmSachMuon().setRowCount(0);
			for(Sach s: dssach)
			{
				Vector<Object> vec=new Vector<>();
				vec.add(s.getMaSach());
				vec.add(s.getTenSach());
				vec.add(s.getTheLoai());
				quanLyPhieuMuonView.getdtmSachMuon().addRow(vec);
			}
			try
			{
				String sql="Select a.MaPM,a.MaDG,b.TenDG,NgayMuon,NgayHenTra,SoLuongMuon,c.TenND from PhieuMuon a,DocGia b,Taikhoan c where b.MaDG=? and c.User=?";		
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1,String.valueOf(quanLyPhieuMuonView.getdtmPhieuMuon().getValueAt(n, 1)));
				pre.setString(2,String.valueOf(quanLyPhieuMuonView.getdtmPhieuMuon().getValueAt(n, 5)));
				ResultSet rs=pre.executeQuery();
				while(rs.next())
				{
					quanLyPhieuMuonView.gettxtMaPhieu().setText(mapm);
					quanLyPhieuMuonView.gettxtMaDG().setText(String.valueOf(quanLyPhieuMuonView.getdtmPhieuMuon().getValueAt(n,1)));
					quanLyPhieuMuonView.gettxtTenDG().setText(rs.getString(3));
					quanLyPhieuMuonView.gettxtNgayMuon().setText(String.valueOf(quanLyPhieuMuonView.getdtmPhieuMuon().getValueAt(n,2)));
					quanLyPhieuMuonView.gettxtNgayHenTra().setText(String.valueOf(quanLyPhieuMuonView.getdtmPhieuMuon().getValueAt(n,3)));
					quanLyPhieuMuonView.gettxtSoSachMuon().setText(String.valueOf(quanLyPhieuMuonView.getdtmPhieuMuon().getValueAt(n,4)));
					quanLyPhieuMuonView.gettxtThuThu().setText(rs.getString(7));						
				}
				
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	class Them implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ThemView tView = new ThemView("Thêm phiếu mượn");
			ThemController tController = new ThemController(tView);
			tView.tentk = tentk;
			tView.hienThi();
			tController.showThemView();
			quanLyPhieuMuonView.hienThiPhieuMuon();
		}
	}
	class Xoa implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			XoaView tView = new XoaView("Xóa phiếu mượn");
			qltv.SuKien.PhieuMuon.Xoa.XoaController tController = new qltv.SuKien.PhieuMuon.Xoa.XoaController(tView);
			tView.machon = quanLyPhieuMuonView.gettxtMaPhieu().getText();
			tView.hienThi();
			tController.showXoaView();
			quanLyPhieuMuonView.getdtmPhieuMuon().setRowCount(0);
			quanLyPhieuMuonView.hienThiPhieuMuon();
		}
	}
	class Sua implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			SuaView tView = new SuaView("Xóa phiếu mượn");
			qltv.SuKien.PhieuMuon.Sua.SuaController tController = new qltv.SuKien.PhieuMuon.Sua.SuaController(tView);
			tView.maPM = quanLyPhieuMuonView.gettxtMaPhieu().getText();
			tView.hienThi();
			tController.showSuaView();
			quanLyPhieuMuonView.getdtmPhieuMuon().setRowCount(0);
			quanLyPhieuMuonView.hienThiPhieuMuon();
			
		}
		
	}
}
