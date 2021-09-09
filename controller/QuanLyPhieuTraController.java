package qltv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import qltv.dao.ConnectMySQL;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyPhieuTraView;
import qltv.view.QuanLyThuThuView;
import qltv.view.ThongKeView;

public class QuanLyPhieuTraController {
	public String tentk="";
	Connection conn=ConnectMySQL.connect;
	public int thongke=0;
	private QuanLyPhieuTraView quanLyPhieuTraView;
	
	public QuanLyPhieuTraController(QuanLyPhieuTraView quanLyPhieuTraView) {
		this.quanLyPhieuTraView = quanLyPhieuTraView;
		quanLyPhieuTraView.addListener(new Back());
		quanLyPhieuTraView.addListener1(new TblPhieuChuaTra());
		quanLyPhieuTraView.addListener2(new TblPhieuTra());
	}
	
	public void showQuanLyPhieuTraView() {
		quanLyPhieuTraView.setModal();
		quanLyPhieuTraView.setVisible(true);
	}
	
	class Back implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int phanquyen=0;
			if(thongke == 1)
			{
				ThongKeView tkv = new ThongKeView("Thống kê");
				ThongKeController tkc = new ThongKeController(tkv);
				tkc.tenTk = tentk;
				tkc.showThongKeView();
				quanLyPhieuTraView.dispose();
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
				quanLyPhieuTraView.dispose();
			}
			if(phanquyen == 2)
			{
				QuanLyThuThuView qladv = new QuanLyThuThuView("Thủ thư:" + tentk);
				QuanLyThuThuController qladc = new QuanLyThuThuController(qladv);
				qladc.tentk = tentk;
				qladc.showQuanLyThuThuView();;
				quanLyPhieuTraView.dispose();
			}
		}
	}
	class TblPhieuChuaTra implements MouseListener{
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
			int n=quanLyPhieuTraView.gettblPhieuChuaTra().getSelectedRow();			
			try {
				String sql="Select c.MaPM,a.MaDG,c.MaSach,c.NgayTra,a.NgayHenTra,c.TinhTrangSach,c.TinhTrangTra,c.GhiChu,b.TenND FROM ctpm c,phieumuon a,taikhoan b  where a.MaPM=c.MaPM and b.User=a.User HAVING c.MaSach=? and c.MaPM=?";
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1, String.valueOf(quanLyPhieuTraView.getdtmPhieuChuaTra().getValueAt(n,1)));
				pre.setString(2, String.valueOf(quanLyPhieuTraView.getdtmPhieuChuaTra().getValueAt(n,0)));
				ResultSet rs=pre.executeQuery();
				while(rs.next())
				{
					quanLyPhieuTraView.gettxtMaPhieu().setText(rs.getString(1));
					quanLyPhieuTraView.gettxtMaDG().setText(rs.getString(2));
					quanLyPhieuTraView.gettxtMaSach().setText(rs.getString(3));
					quanLyPhieuTraView.gettxtNgayTra().setText(rs.getString(4));
					quanLyPhieuTraView.gettxtNgayHenTra().setText(rs.getString(5));
					quanLyPhieuTraView.gettxtTTSachMuon().setText(rs.getString(6));
					quanLyPhieuTraView.gettxtTTSachTra().setText(rs.getString(7));
					quanLyPhieuTraView.gettxtGhiChu().setText(rs.getString(8));
					quanLyPhieuTraView.gettxtThuThuNhanSach().setText(null);
				}
			}
			catch( Exception ex)
			{
				ex.printStackTrace();
			}
			quanLyPhieuTraView.gettblPhieuTra().setSelectionMode(0);
			
		}
	}
	class TblPhieuTra implements MouseListener{
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
			int n=quanLyPhieuTraView.gettblPhieuTra().getSelectedRow();
		
			try {
				String sql="Select c.MaPM,a.MaDG,c.MaSach,c.NgayTra,a.NgayHenTra,c.TinhTrangSach,c.TinhTrangTra,c.GhiChu,b.TenND FROM ctpm c,phieumuon a,taikhoan b  where a.MaPM=c.MaPM and b.User=c.User HAVING c.MaSach=? and c.MaPM=?";
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1, String.valueOf(quanLyPhieuTraView.getdtmPhieuTra().getValueAt(n,1)));
				pre.setString(2, String.valueOf(quanLyPhieuTraView.getdtmPhieuTra().getValueAt(n,0)));
				ResultSet rs=pre.executeQuery();
				while(rs.next())
				{
					quanLyPhieuTraView.gettxtMaPhieu().setText(rs.getString(1));
					quanLyPhieuTraView.gettxtMaDG().setText(rs.getString(2));
					quanLyPhieuTraView.gettxtMaSach().setText(rs.getString(3));
					quanLyPhieuTraView.gettxtNgayTra().setText(rs.getString(4));
					quanLyPhieuTraView.gettxtNgayHenTra().setText(rs.getString(5));
					quanLyPhieuTraView.gettxtTTSachMuon().setText(rs.getString(6));
					quanLyPhieuTraView.gettxtTTSachTra().setText(rs.getString(7));
					quanLyPhieuTraView.gettxtGhiChu().setText(rs.getString(8));
					quanLyPhieuTraView.gettxtThuThuNhanSach().setText(null);
				}
			}
			catch( Exception ex)
			{
				ex.printStackTrace();
			}
			quanLyPhieuTraView.gettblPhieuChuaTra().setSelectionMode(0);
		}
	}
	
}
