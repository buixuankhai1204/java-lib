package qltv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import qltv.SuKien.DocGia.Them.ThemView;
import qltv.SuKien.NguoiDung.Them.ThemController;
import qltv.controller.QuanLyDocGiaController.Xoa;
import qltv.dao.TaiKhoanDao;
import qltv.entity.TaiKhoan;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyNguoiDungView;
import qltv.view.ThongKeView;

public class QuanLyNguoiDungController {
	public String tentk="";
	public int ThongKe=0;
	private QuanLyNguoiDungView quanLyNguoiDungView;
	ArrayList<TaiKhoan> dstk;
	int dem=0;
	
	public QuanLyNguoiDungController(QuanLyNguoiDungView quanLyNguoiDungView) {
		this.quanLyNguoiDungView = quanLyNguoiDungView;
		quanLyNguoiDungView.addListener(new Back());
		quanLyNguoiDungView.addListener1(new NguoiDung());
		quanLyNguoiDungView.addListener2(new Icon());
		quanLyNguoiDungView.addListener3(new Them());
		quanLyNguoiDungView.addListener4(new Xoa());
		quanLyNguoiDungView.addListener5(new Sua());
		
	}
	
	public void showQuanLyNguoiDungView() {
//		quanLyNguoiDungView.getmodal(true);
		quanLyNguoiDungView.setVisible(true);
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(ThongKe == 1)
			{
				ThongKeView tkv = new ThongKeView("Thống kê");
				ThongKeController tkc = new ThongKeController(tkv);
				tkc.tenTk = tentk;
				tkc.showThongKeView();
				quanLyNguoiDungView.dispose();
				ThongKe =0;
				return;
			}
			QuanLyAdminView qladv = new QuanLyAdminView("Trang Chủ Phần Mềm Quản Lý Thư Viện");
			QuanLyAdminController qladc = new QuanLyAdminController(qladv);
			qladc.tentk = tentk;
			qladc.showQuanlyAdminView();
			quanLyNguoiDungView.dispose();				
		}
	}
	class NguoiDung implements MouseListener{
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
			quanLyNguoiDungView.getpwdPass().setEchoChar('*');
			int n=quanLyNguoiDungView.gettblNguoiDung().getSelectedRow();
			String user=String.valueOf(quanLyNguoiDungView.getdtmNguoiDung().getValueAt(n, 0));
			TaiKhoanDao tksv = new TaiKhoanDao();
			dstk=tksv.layTaiKhoanTheoUser(user);
			for(TaiKhoan tk:dstk)
			{
				quanLyNguoiDungView.gettxtTaiKhoan().setText(tk.getUser());
				quanLyNguoiDungView.gettxtCMND().setText(tk.getCMND());
				quanLyNguoiDungView.gettxtHoVaTen().setText(tk.getTenND());
				int phanquyen=tk.getPhanQuyen();
				if(phanquyen == 1 )
				{
					quanLyNguoiDungView.gettxtPhanQuyen().setText("Admin");
				}
				else
					quanLyNguoiDungView.gettxtPhanQuyen().setText("Thủ thư");
					quanLyNguoiDungView.gettxtSoDienThoai().setText(tk.getSoDienThoai());
					quanLyNguoiDungView.getpwdPass().setText(tk.getPass());
			}		
		}
	}
	class Icon implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			if(dem % 2 == 0)
			{
				quanLyNguoiDungView.getpwdPass().setEchoChar((char)0);
			}
			if(dem % 2 != 0)
			{ 
				quanLyNguoiDungView.getpwdPass().setEchoChar('*');
			}
			dem++;
		}
	}
	class Xoa implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			qltv.SuKien.NguoiDung.Xoa.XoaView xv = new qltv.SuKien.NguoiDung.Xoa.XoaView("Xóa người dùng");
			qltv.SuKien.NguoiDung.Xoa.XoaController xc = new qltv.SuKien.NguoiDung.Xoa.XoaController(xv);
			xv.machon = quanLyNguoiDungView.gettxtTaiKhoan().getText();
			xv.hienThi();
			xc.showXoaView();
			quanLyNguoiDungView.hienThiQLND();
			quanLyNguoiDungView.gettxtSoDienThoai().setText(null);
			quanLyNguoiDungView.gettxtHoVaTen().setText(null);
			quanLyNguoiDungView.gettxtTaiKhoan().setText(null);
			quanLyNguoiDungView.gettxtCMND().setText(null);
			quanLyNguoiDungView.gettxtPhanQuyen().setText(null);
			quanLyNguoiDungView.getpwdPass().setText(null);
		}
	}
	class Them implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			qltv.SuKien.NguoiDung.Them.ThemView tv = new qltv.SuKien.NguoiDung.Them.ThemView("Thêm người dùng");
			qltv.SuKien.NguoiDung.Them.ThemController tc = new qltv.SuKien.NguoiDung.Them.ThemController(tv);
			tc.showThemView();
			quanLyNguoiDungView.hienThiQLND();
		}	
	}
	class Sua implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			qltv.SuKien.NguoiDung.Sua.SuaView xv = new qltv.SuKien.NguoiDung.Sua.SuaView("Xóa người dùng");
			qltv.SuKien.NguoiDung.Sua.SuaController xc = new qltv.SuKien.NguoiDung.Sua.SuaController(xv);
			xv.machon = quanLyNguoiDungView.gettxtTaiKhoan().getText();
			xv.hienThi();
			xc.showSuaView();
			quanLyNguoiDungView.hienThiQLND();
			quanLyNguoiDungView.gettxtSoDienThoai().setText(null);
			quanLyNguoiDungView.gettxtHoVaTen().setText(null);
			quanLyNguoiDungView.gettxtTaiKhoan().setText(null);
			quanLyNguoiDungView.gettxtCMND().setText(null);
			quanLyNguoiDungView.gettxtPhanQuyen().setText(null);
			quanLyNguoiDungView.getpwdPass().setText(null);
		}
	}
}
