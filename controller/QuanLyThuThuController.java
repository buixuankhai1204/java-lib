package qltv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import qltv.controller.QuanLyAdminController.DoiMK;
import qltv.controller.QuanLyAdminController.Listener;
import qltv.controller.QuanLyAdminController.QLDocGia;
import qltv.controller.QuanLyAdminController.QLNguoiDung;
import qltv.controller.QuanLyAdminController.QLPhieuMuon;
import qltv.controller.QuanLyAdminController.QLPhieuTra;
import qltv.controller.QuanLyAdminController.QLSach;
import qltv.controller.QuanLyAdminController.ThongKe;
import qltv.view.DoiMatKhauView;
import qltv.view.LoGinView;
import qltv.view.QuanLyDocGiaView;
import qltv.view.QuanLyPhieuMuonView;
import qltv.view.QuanLyPhieuTraView;
import qltv.view.QuanLySachView;
import qltv.view.QuanLyThuThuView;

public class QuanLyThuThuController {
	private QuanLyThuThuView quanLyThuThuView;
	public String tentk;
	
	public void showQuanLyThuThuView() {
		quanLyThuThuView.setVisible(true);
	}
	
	public QuanLyThuThuController(QuanLyThuThuView quanLyThuThuView) {
		this.quanLyThuThuView = quanLyThuThuView;
		quanLyThuThuView.addListener(new Back());
		quanLyThuThuView.addListener1(new QLSach());
		quanLyThuThuView.addListener2(new QLDocGia());
		quanLyThuThuView.addListener4(new QLPhieuMuon());
		quanLyThuThuView.addListener5(new QLPhieuTra());
		quanLyThuThuView.addListener6(new DoiMK());
	}
	
	class Back implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoGinView view = new LoGinView(null);
			LoGinController loGinController = new LoGinController(view);
			loGinController.showLoginView();
			quanLyThuThuView.dispose();
		}
	}
	
	class QLSach implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			QuanLySachView qlsv = new QuanLySachView(null);
			QuanLySachController qlsc = new QuanLySachController(qlsv);
			qlsc.showQuanLySachView();
			quanLyThuThuView.dispose();
		}
	}
	class QLDocGia implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{			
			QuanLyDocGiaView qldgv = new QuanLyDocGiaView("Quản lý độc giả");
	 		QuanLyDocGiaController qldgc = new QuanLyDocGiaController(qldgv);
	 		qldgc.tentk = tentk;
	 		qldgc.showQuanLyDocGiaView();
	 		quanLyThuThuView.dispose();
	 	}
	}
	class QLPhieuMuon implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{
			QuanLyPhieuMuonView qlndv = new QuanLyPhieuMuonView("Quản lý phiếu mượn");
			QuanLyPhieuMuonController qlndc = new QuanLyPhieuMuonController(qlndv);
			qlndc.tentk = tentk;
			qlndc.showQuanLyPhieuMuonView();
			quanLyThuThuView.dispose();
	 	}
	}
	class QLPhieuTra implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{
			QuanLyPhieuTraView qlndv = new QuanLyPhieuTraView("Quản lý phiếu mượn");
			QuanLyPhieuTraController qlndc = new QuanLyPhieuTraController(qlndv);
			qlndc.tentk = tentk;
			qlndc.showQuanLyPhieuTraView();
			quanLyThuThuView.dispose();
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
			quanLyThuThuView.dispose();
					
	 	}
	}
}
