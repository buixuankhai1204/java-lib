package qltv.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;

import qltv.controller.QuanLyAdminController.Listener;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLySachView;
import qltv.view.QuanLyThuThuView;
import qltv.view.ThongKeView;
import qltv.dao.ConnectMySQL;
public class QuanLySachController extends JFrame{
	private QuanLySachView quanLySachView;
	public String tentk = "";
	Connection conn=ConnectMySQL.connect;
	public int thongke=0;
	
	public QuanLySachController(QuanLySachView quanLySachView) {
		this.quanLySachView = quanLySachView;
		quanLySachView.addListener(new Back());
		quanLySachView.addListener1(new listTheLoai());
		quanLySachView.addListener2(new lblTable());
		quanLySachView.addListener3(new Add());
		quanLySachView.addListener4(new Del());
		quanLySachView.addListener5(new Search());
		quanLySachView.addListener6(new Sua());
	}
	
	public void showQuanLySachView() {
		quanLySachView.setVisible(true);
	}
	
	class Back implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int phanquyen = 0;
			if(thongke == 1)
			{
				ThongKeView tkv = new ThongKeView("Thống kê");
				ThongKeController tkc = new ThongKeController(tkv);
				tkc.tenTk = tentk;
				tkc.showThongKeView();
				quanLySachView.dispose();
				thongke = 0;
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
			if(phanquyen == 1) {
				QuanLyAdminView ql= new QuanLyAdminView("Trang Chủ Phần Mềm Quản Lý Thư Viện");
				QuanLyAdminController qla = new QuanLyAdminController(ql);
				qla.showQuanlyAdminView();
				qla.tentk = tentk;
				quanLySachView.dispose();
			}
			if(phanquyen == 2) {
				QuanLyThuThuView ql = new QuanLyThuThuView("Thủ thư");
				QuanLyThuThuController qla = new QuanLyThuThuController(ql);
				qla.showQuanLyThuThuView();
				qla.tentk = tentk;
				quanLySachView.dispose();
			}
		}
	}
	
	class listTheLoai implements MouseListener{
		public void actionPerformed(MouseAdapter e) {
			
		}
		public void mouseClicked(MouseEvent e) {
			JList<?> list = (JList<?>)e.getSource();
			if (e.getClickCount() == 2) 
	        {
	            int index = list.locationToIndex(e.getPoint());
	            quanLySachView.getDtmSach().setRowCount(0);
	            String theloai = (String) quanLySachView.getdefaultListTheLoai().get(index);
	            try {
					String sql = "select * from sach where theloai=?";
					PreparedStatement pre = conn.prepareStatement(sql);
					pre.setString(1, theloai);
					ResultSet rs = pre.executeQuery();
					while (rs.next()) {
						String ma = rs.getString(1);
						String ten = rs.getString(2);
						String tg = rs.getString(3);
						String nxb = rs.getString(4);
						String tl = rs.getString(5);
						String sl = String.valueOf(rs.getInt(6));
						String gia = String.valueOf(rs.getInt(7));

						Vector<String> vec = new Vector<String>();
						vec.add(ma);
						vec.add(ten);
						vec.add(tg);
						vec.add(nxb);
						vec.add(tl);
						vec.add(sl);
						vec.add(gia);
						quanLySachView.getDtmSach().addRow(vec);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
	        } 
	        else if (e.getClickCount() == 3) 
	        {
	            list.locationToIndex(e.getPoint());
	        }
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class lblTable implements MouseListener {
		public void actionPerformed(ActionEvent e) {
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = quanLySachView.getTblSach().rowAtPoint(e.getPoint());
			quanLySachView.getTblSach().columnAtPoint(e.getPoint());
			int numcols = quanLySachView.getTblSach().getColumnCount();

			for (int i = 0; i < numcols; i++) {
				String str = (String) quanLySachView.getDtmSach().getValueAt(row, i);
				if (i == 0)
					quanLySachView.getTxtMaSach().setText(str);
				if (i == 1)
					quanLySachView.getTxtTenSach().setText(str);
				if (i == 2)
					quanLySachView.getTxtTacGia().setText(str);
				if (i == 3)
					quanLySachView.getTxtNhaXB().setText(str);
				if (i == 4)
					quanLySachView.getTxtTheLoai().setText(str);
				if (i == 5)
					quanLySachView.getTxtSoLuong().setText(str);
				if (i == 6)
					quanLySachView.getTxtGia().setText(str);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class Add implements ActionListener{
		public void actionPerformed(ActionEvent e) {		
			qltv.SuKien.Sach.Them.ThemSachView tsv = new qltv.SuKien.Sach.Them.ThemSachView("");
			qltv.SuKien.Sach.Them.ThemSachController tsc = new qltv.SuKien.Sach.Them.ThemSachController(tsv);
			tsc.showThemSachView();
			quanLySachView.getDtmSach().setRowCount(0);
			quanLySachView.hienThiSach();
		}
	}
	
	class Del implements ActionListener{
		public void actionPerformed(ActionEvent e) {		
			qltv.SuKien.Sach.Xoa.XoaSachView tsv = new qltv.SuKien.Sach.Xoa.XoaSachView("Xóa thông tin sách");
			qltv.SuKien.Sach.Xoa.XoaSachController tsc = new qltv.SuKien.Sach.Xoa.XoaSachController(tsv);
			tsv.ma = quanLySachView.getTxtMaSach().getText();
			tsv.hienThi();
			tsc.showXoaSachView();
			quanLySachView.getDtmSach().setRowCount(0);
			quanLySachView.hienThiSach();
		}
	}
	
	class Sua implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			qltv.SuKien.Sach.Sua.SuaSachView sv = new qltv.SuKien.Sach.Sua.SuaSachView("Sửa thông tin sách");
			qltv.SuKien.Sach.Sua.SuaSachController sc = new qltv.SuKien.Sach.Sua.SuaSachController(sv);
			sv.ma = quanLySachView.getTxtMaSach().getText();
			sv.hienThi();
			sc.showSuaSachView();
			quanLySachView.getDtmSach().setRowCount(0);
			quanLySachView.hienThiSach();
		}
	}
	
	class Search implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{		
			qltv.SuKien.Sach.TimKiem.TimKiemSachView sv = new qltv.SuKien.Sach.TimKiem.TimKiemSachView("Tìm kiếm thông tin sách");
			qltv.SuKien.Sach.TimKiem.TimKiemSachController sc = new qltv.SuKien.Sach.TimKiem.TimKiemSachController(sv);
			sc.showTimKiemSachView();
			quanLySachView.getDtmSach().setRowCount(0);
			quanLySachView.hienThiSach();
		}
	}
}
