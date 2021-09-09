package qltv.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.sf.jasperreports.data.AbstractClasspathAwareDataAdapter;
import oracle.net.nt.TcpNTAdapter;
import qltv.dao.ConnectMySQL;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyDocGiaView;
import qltv.view.QuanLyThuThuView;
import qltv.view.ThongKeView;


public class QuanLyDocGiaController {
	Connection conn = ConnectMySQL.connect;
	public int thongke=0;	
	public String tentk = "";
	private QuanLyDocGiaView quanLyDocGiaView;
	
	public QuanLyDocGiaController(QuanLyDocGiaView quanLyDocGiaView) {
		this.quanLyDocGiaView = quanLyDocGiaView;
		quanLyDocGiaView.addListener(new Back());
		quanLyDocGiaView.addListener1(new TblDocGia());
		quanLyDocGiaView.addListener2(new ThongTin() );
		quanLyDocGiaView.addListener3(new Them() );
		quanLyDocGiaView.addListener4(new Xoa() );
		quanLyDocGiaView.addListener5(new Sua() );
	}
	
	public void showQuanLyDocGiaView() {
		quanLyDocGiaView.setModal(true);
		quanLyDocGiaView.setVisible(true);
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int phanquyen=0;
			if(thongke == 1)
			{
				ThongKeView tkv = new ThongKeView("Thống kê");
				ThongKeController tkc = new ThongKeController(tkv);
				tkc.tenTk = tentk;
				tkc.showThongKeView();
				quanLyDocGiaView.dispose();
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
				QuanLyAdminView qlav = new QuanLyAdminView("Trang Chủ Phần Mềm Quản Lý Thư Viện");
				QuanLyAdminController qlac = new QuanLyAdminController(qlav);
				qlac.tentk = tentk;
				qlac.showQuanlyAdminView();
				quanLyDocGiaView.dispose();
			}
			if(phanquyen == 2)
			{
				QuanLyThuThuView ql=new QuanLyThuThuView("Thủ thư: "+tentk);
				QuanLyThuThuController qlttc = new QuanLyThuThuController(ql);
				qlttc.tentk = tentk;
				qlttc.showQuanLyThuThuView();
				quanLyDocGiaView.dispose();
			}
		}
		
	}
	
	class TblDocGia implements MouseListener 
	{
		public void mouseClicked(MouseEvent e) 
		{
			int row = quanLyDocGiaView.getTblDocGia().rowAtPoint(e.getPoint());
			int col = quanLyDocGiaView.getTblDocGia().columnAtPoint(e.getPoint());
			int numcols = quanLyDocGiaView.getDtmDocGia().getColumnCount();

			for (int i = 0; i < numcols; i++) {
				String str = (String) quanLyDocGiaView.getDtmDocGia().getValueAt(row, i);
				if (i == 0)
					quanLyDocGiaView.getTxtMaDocGia().setText(str);
				if (i == 1)
					quanLyDocGiaView.getTxtTenDocGia().setText(str);
				if (i == 2)
					quanLyDocGiaView.getTxtSDT().setText(str);
				if (i == 3)
					quanLyDocGiaView.getTxtDiaChi().setText(str);
				if (i == 4)
					quanLyDocGiaView.getTxtGioiTinh().setText(str);
				if (i == 5)
					quanLyDocGiaView.getTxtLanMatSach().setText(str);
			}
			String ma = quanLyDocGiaView.getTxtMaDocGia().getText();
			quanLyDocGiaView.getDtmPhieuMuon().setRowCount(0);
			quanLyDocGiaView.lietKePhieuMuonTheoDocGia(ma);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
	class ThongTin implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			String ma = "";
			int row = quanLyDocGiaView.getTblPhieuMuon().getSelectedRow();
			if (row == -1) 
			{
				JOptionPane.showMessageDialog(null, "M�?i bạn ch�?n phiếu mượn");
				return;
			}
			ma = (String) quanLyDocGiaView.getDtmPhieuMuon().getValueAt(row, 0);
			qltv.SuKien.DocGia.ChiTiet.ChiTietView a = new qltv.SuKien.DocGia.ChiTiet.ChiTietView("Chi tiết phiếu mượn");
			qltv.SuKien.DocGia.ChiTiet.ChiTietController aa = new qltv.SuKien.DocGia.ChiTiet.ChiTietController(a);
			a.ma = ma;
			a.hienThi();
			aa.showChiTietView();
		}
	}
	
	class Them implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			qltv.SuKien.DocGia.Them.ThemView  tv = new qltv.SuKien.DocGia.Them.ThemView("Thêm độc giả");
			qltv.SuKien.DocGia.Them.ThemController tc = new qltv.SuKien.DocGia.Them.ThemController(tv);
			tc.showThemView();
			quanLyDocGiaView.getDtmDocGia().setRowCount(0);
			quanLyDocGiaView.lietKeDocGia();
		}
	}
	
	class Xoa implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			qltv.SuKien.DocGia.Xoa.XoaView xv = new qltv.SuKien.DocGia.Xoa.XoaView("Xóa độc giả");
			qltv.SuKien.DocGia.Xoa.XoaController xc = new qltv.SuKien.DocGia.Xoa.XoaController(xv);
			xv.machon = quanLyDocGiaView.getTxtMaDocGia().getText();
			xv.hienThi();
			xc.showXoaView();
			quanLyDocGiaView.getDtmDocGia().setRowCount(0);
			quanLyDocGiaView.lietKeDocGia();
		}
	}
	
	class Sua implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			qltv.SuKien.DocGia.Sua.SuaView sv = new qltv.SuKien.DocGia.Sua.SuaView("Sửa độc giả");
			qltv.SuKien.DocGia.Sua.SuaController sc = new qltv.SuKien.DocGia.Sua.SuaController(sv);
			sv.ma = quanLyDocGiaView.getTxtTenDocGia().getText();
			sv.hienThi();
			sc.showSuaView();
			quanLyDocGiaView.getDtmDocGia().setRowCount(0);
			quanLyDocGiaView.lietKeDocGia();
		}
	}
}
