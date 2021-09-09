package qltv.controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import qltv.view.DoiMatKhauView;
import qltv.view.LoGinView;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyDocGiaView;
import qltv.view.QuanLyNguoiDungView;
import qltv.view.QuanLyPhieuMuonView;
import qltv.view.QuanLyPhieuTraView;
import qltv.view.QuanLySachView;
import qltv.view.ThongKeView;
import qltv.entity.DocGia;
public class QuanLyAdminController {
	private QuanLyAdminView quanLyAdminView;
	public String tentk="";
	
	public QuanLyAdminController(QuanLyAdminView quanLyAdminView) {
		this.quanLyAdminView = quanLyAdminView;
		quanLyAdminView.addListener(new Listener());
		quanLyAdminView.addListener1(new QLSach());
		quanLyAdminView.addListener2(new QLDocGia());
		quanLyAdminView.addListener3(new QLNguoiDung());
		quanLyAdminView.addListener4(new QLPhieuMuon());
		quanLyAdminView.addListener5(new QLPhieuTra());
		quanLyAdminView.addListener6(new DoiMK());
		quanLyAdminView.addListener7(new ThongKe());
	}
	
	public void showQuanlyAdminView() {
		quanLyAdminView.setVisible(true);
    }
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LoGinView view = new LoGinView(null);
			LoGinController loGinController = new LoGinController(view);
			loGinController.showLoginView();
			quanLyAdminView.dispose();
		}

	}
	class QLSach implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			QuanLySachView qlsv = new QuanLySachView(null);
			QuanLySachController qlsc = new QuanLySachController(qlsv);
			qlsc.showQuanLySachView();
			qlsc.tentk = tentk;
			quanLyAdminView.dispose();
		}
	}
	class QLDocGia implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{			
	 		QuanLyDocGiaView qldgv = new QuanLyDocGiaView("Quản lý độc giả");
	 		QuanLyDocGiaController qldgc = new QuanLyDocGiaController(qldgv);
	 		qldgc.tentk = tentk;
	 		qldgc.showQuanLyDocGiaView();
	 		quanLyAdminView.dispose();
	 	}
	}
	class QLNguoiDung implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{
			QuanLyNguoiDungView qlndv = new QuanLyNguoiDungView("Quản lý người dùng");
			QuanLyNguoiDungController qlndc = new QuanLyNguoiDungController(qlndv);
			qlndc.tentk = tentk;
			qlndc.showQuanLyNguoiDungView();
			quanLyAdminView.dispose();
	 	}
	}
	class QLPhieuMuon implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{
			QuanLyPhieuMuonView qlndv = new QuanLyPhieuMuonView("Quản lý phiếu mượn");
			QuanLyPhieuMuonController qlndc = new QuanLyPhieuMuonController(qlndv);
			qlndc.tentk = tentk;
			qlndc.showQuanLyPhieuMuonView();
			quanLyAdminView.dispose();
	 	}
	}
	class QLPhieuTra implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{
			QuanLyPhieuTraView qlndv = new QuanLyPhieuTraView("Quản lý phiếu mượn");
			QuanLyPhieuTraController qlndc = new QuanLyPhieuTraController(qlndv);
			qlndc.tentk = tentk;
			qlndc.showQuanLyPhieuTraView();
			quanLyAdminView.dispose();
	 	}
	}
	class DoiMK implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{
			DoiMatKhauView dmkv = new DoiMatKhauView("Đổi mật khẩu");
			DoiMatKhauController dmkc = new DoiMatKhauController(dmkv);
			dmkc.tentk = tentk;
			dmkv.Hienthi();
			dmkc.showDoiMatKhauView();
			quanLyAdminView.dispose();
					
	 	}
	}
	class ThongKe implements ActionListener{
		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
			ThongKeView tkv = new ThongKeView("Thống kê");
			ThongKeController tkc = new ThongKeController(tkv);
			tkc.tenTk = tentk;
			tkc.showThongKeView();
			quanLyAdminView.dispose();
		}
	}
}
