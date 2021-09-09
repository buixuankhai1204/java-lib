package qltv.SuKien.Sach.TimKiem;

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

import qltv.view.QuanLySachView;

public class TimKiemSachController {
	Connection conn=qltv.dao.ConnectMySQL.connect;
	private TimKiemSachView timKiemSachView;
	private QuanLySachView quanLySachView;
	
	public TimKiemSachController(TimKiemSachView timKiemSachView) {
		this.timKiemSachView = timKiemSachView;
		timKiemSachView.addListener(new Search());
//		timKiemSachView.addListener1(new TblSach());
//		timKiemSachView.addListener3(new KeySearch());
//		timKiemSachView.addListener4(new MouSearch());
	}
	
	public void showTimKiemSachView() {
		timKiemSachView.setMoDal(true);
		timKiemSachView.setVisible(true);
	}
	
	class Search implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			timKiemSachView.loadTen();
//			timKiemSachView.getdtmSach().setRowCount(0);
//			String tensach = timKiemSachView.getTxtTimKiem().getText();
//			try {
//				String sql = "select * from sach where tensach like ?";
//				PreparedStatement pre = conn.prepareStatement(sql);
//				pre.setString(1, '%'+tensach+'%');
//				ResultSet rs = pre.executeQuery();
//				while (rs.next()) {
//					String ma = rs.getString(1);
//					String ten = rs.getString(2);
//					String tg = rs.getString(3);
//					String nxb = rs.getString(4);
//					String tl = rs.getString(5);
//					String sl = String.valueOf(rs.getInt(6));
//					String gia = String.valueOf(rs.getInt(7));
//
//					Vector<String> vec = new Vector<String>();
//					vec.add(ma);
//					vec.add(ten);
//					vec.add(tg);
//					vec.add(nxb);
//					vec.add(tl);
//					vec.add(sl);
//					vec.add(gia);
//
//					timKiemSachView.getdtmSach().addRow(vec);
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		}
	}
	class TblSach implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = timKiemSachView.gettblSach().rowAtPoint(e.getPoint());
			int col = timKiemSachView.gettblSach().columnAtPoint(e.getPoint());
			int numcols = timKiemSachView.gettblSach().getColumnCount();

			for (int i = 0; i < numcols; i++) {
				String str = (String) timKiemSachView.getdtmSach().getValueAt(row, i);
				if (i == 0)
					timKiemSachView.getTxtMaSach().setText(str);
				if (i == 1)
					timKiemSachView.getTxtTenSach().setText(str);
				if (i == 2)
					timKiemSachView.getTxtTenTG().setText(str);
				if (i == 3)
					timKiemSachView.getTxtNhaXB().setText(str);
				if (i == 4)
					timKiemSachView.getTxtTheLoai().setText(str);
				if (i == 5)
					timKiemSachView.getTxtSoLuong().setText(str);
				if (i == 6)
					timKiemSachView.getTxtGia().setText(str);
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
				timKiemSachView.getdtmSach().setRowCount(0);
				String tensach = timKiemSachView.getTxtTimKiem().getText();
				try {
					String sql = "select * from sach where tensach like ?";
					PreparedStatement pre = conn.prepareStatement(sql);
					pre.setString(1, '%'+tensach+'%');
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

						timKiemSachView.getdtmSach().addRow(vec);
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
			timKiemSachView.getTxtTimKiem().setText(null);
			
		}
	}
	}
}