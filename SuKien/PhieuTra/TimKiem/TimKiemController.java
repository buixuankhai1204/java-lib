package qltv.SuKien.PhieuTra.TimKiem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import qltv.SuKien.PhieuTra.TraSach.TraSachController;
import qltv.SuKien.PhieuTra.TraSach.TraSachView;

public class TimKiemController {
	private TimKiemView timKiemView;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	public String tentk="";
	
	public TimKiemController(TimKiemView timKiemView) {
		this.timKiemView = timKiemView;
		timKiemView.addListener(new Search());
		timKiemView.addListener1(new TblPhieuMuon());
		timKiemView.addListener2(new KeySearch());
		timKiemView.addListener3(new MouSearch());
		timKiemView.addListener4(new TraSach());
	}
	
	public void showTimKiemView() {
		timKiemView.setMoDal(true);
		timKiemView.setVisible(true);
	}
	
	class Search implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			timKiemView.getDtmPhieuMuon().setRowCount(0);
			String phieutra = timKiemView.getTxtTimKiem().getText();
			try {
				String sql="Select c.MaPM,a.MaDG,c.MaSach,c.NgayTra,a.NgayHenTra,c.TinhTrangSach,c.TinhTrangTra,c.GhiChu,b.TenND FROM ctpm c,phieumuon a,taikhoan b  where a.MaPM=c.MaPM and b.User=c.User HAVING c.MaPM like ?";
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setString(1, '%'+timKiemView.getTxtTimKiem().getText()+'%');
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					String maphieu = rs.getString(1);
					String madocgia = rs.getString(2);
					String masach = rs.getString(3);
					String ngayhentra = rs.getString(4);
					String ngaytra = rs.getString(5);
					String ttsachmuon = rs.getString(6);
					String ttsachtra = rs.getString(7);
					String thuthu = rs.getString(9);
					String ghichu = rs.getString(8);

					Vector<String> vec = new Vector<String>();
					vec.add(maphieu);
					vec.add(madocgia);
					vec.add(masach);
					vec.add(ngayhentra);
					vec.add(ngaytra);
					vec.add(ttsachmuon);
					vec.add(ttsachtra);
					vec.add(thuthu);
					vec.add(ghichu);
					timKiemView.getDtmPhieuMuon().addRow(vec);
				}
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Hi");

				ex.printStackTrace();
			}
		}
	}
	class KeySearch implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER) 
			{
				timKiemView.getDtmPhieuMuon().setRowCount(0);
				String tensach = timKiemView.getTxtTimKiem().getText();
				try {
					String sql="Select c.MaPM,a.MaDG,c.MaSach,c.NgayTra,a.NgayHenTra,c.TinhTrangSach,c.TinhTrangTra,c.GhiChu,b.TenND FROM ctpm c,phieumuon a,taikhoan b  where a.MaPM=c.MaPM and b.User=c.User HAVING c.MaPM like ?";
					PreparedStatement pre = conn.prepareStatement(sql);
					pre.setString(1, '%'+timKiemView.getTxtTimKiem().getText()+'%');
					ResultSet rs = pre.executeQuery();
					while (rs.next()) {
						String maphieu = rs.getString(1);
						String madocgia = rs.getString(2);
						String masach = rs.getString(3);
						String ngayhentra = rs.getString(4);
						String ngaytra = rs.getString(5);
						String ttsachmuon = rs.getString(6);
						String ttsachtra = rs.getString(7);
						String thuthu = rs.getString(9);
						String ghichu = rs.getString(8);

						Vector<String> vec = new Vector<String>();
						vec.add(maphieu);
						vec.add(madocgia);
						vec.add(masach);
						vec.add(ngayhentra);
						vec.add(ngaytra);
						vec.add(ttsachmuon);
						vec.add(ttsachtra);
						vec.add(thuthu);
						vec.add(ghichu);


						timKiemView.getDtmPhieuMuon().addRow(vec);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	class MouSearch implements MouseListener{
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
		public void mouseClicked(MouseEvent e) {
			timKiemView.getTxtTimKiem().setText(null);
			
		}
	}
	class TraSach implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(timKiemView.getTxtNgayTra().getText().length()  != 0)
			{
				JOptionPane.showMessageDialog(null, "Phiếu mượn đã trả sách rồi");
				return;
			}
			TraSachView tsv = new TraSachView("Trả sách");
			TraSachController tsc = new TraSachController(tsv);
			tsc.tentk = tentk;
			tsc.MaDG = timKiemView.getTxtMaDG().getText();
			tsc.MaPM=timKiemView.getTxtMaPhieu().getText();
			tsc.MaSach=timKiemView.getTxtMaSach().getText();
			tsc.NgayHenTra=timKiemView.getTxtNgayHenTra().getText();
			tsc.TinhTrangSach=timKiemView.getTxtTTSachMuon().getText();
			tsv.hienThi();
			tsc.showTraSachView();
		}
	}
	
	class TblPhieuMuon implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = timKiemView.getTblPhieuMuon().rowAtPoint(e.getPoint());
			int col = timKiemView.getTblPhieuMuon().columnAtPoint(e.getPoint());
			int numcols = timKiemView.getTblPhieuMuon().getColumnCount();

			for (int i = 0; i < numcols; i++) {
				String str = (String) timKiemView.getDtmPhieuMuon().getValueAt(row, i);
				if (i == 0)
					timKiemView.txtMaPhieu.setText(str);
				if (i == 1)
					timKiemView.getTxtMaDG().setText(str);
				if (i == 2)
					timKiemView.getTxtMaSach().setText(str);
				if (i == 3)
					timKiemView.getTxtNgayHenTra().setText(str);
				if (i == 4)
					timKiemView.getTxtNgayTra().setText(str);
				if (i == 5)
					timKiemView.getTxtTTSachMuon().setText(str);
				if (i == 6)
					timKiemView.getTxtTTSachTra().setText(str);
				if (i == 7)
					timKiemView.getTxtThuThu().setText(str);
				if (i == 8)
					timKiemView.getTxtGhiChu().setText(str);
			}
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
}
