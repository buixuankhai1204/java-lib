package qltv.SuKien.PhieuMuon.Xoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import qltv.dao.PhieuMuonDao;
import qltv.dao.SachDao;
import qltv.entity.PhieuMuon;
import qltv.entity.Sach;
import qltv.view.QuanLyPhieuMuonView;

public class XoaView extends JFrame {
	JTextField txtMaPhieu, txtMaDG, txtTenDG, txtNgayMuon, txtNgayHenTra, txtSachMuon, txtThuThu;
	ArrayList<PhieuMuon> phieuMuons;
	QuanLyPhieuMuonView quanLyPhieuMuonView;
	public JTextField getTxtMaPhieu() {
		return txtMaPhieu;
	}

	public void setTxtMaPhieu(JTextField txtMaPhieu) {
		this.txtMaPhieu = txtMaPhieu;
	}

	public JTextField getTxtMaDG() {
		return txtMaDG;
	}

	public void setTxtMaDG(JTextField txtMaDG) {
		this.txtMaDG = txtMaDG;
	}

	public JTextField getTxtTenDG() {
		return txtTenDG;
	}

	public void setTxtTenDG(JTextField txtTenDG) {
		this.txtTenDG = txtTenDG;
	}

	public JTextField getTxtNgayMuon() {
		return txtNgayMuon;
	}

	public void setTxtNgayMuon(JTextField txtNgayMuon) {
		this.txtNgayMuon = txtNgayMuon;
	}

	public JTextField getTxtNgayHenTra() {
		return txtNgayHenTra;
	}

	public void setTxtNgayHenTra(JTextField txtNgayHenTra) {
		this.txtNgayHenTra = txtNgayHenTra;
	}

	public JTextField getTxtSachMuon() {
		return txtSachMuon;
	}

	public void setTxtSachMuon(JTextField txtSachMuon) {
		this.txtSachMuon = txtSachMuon;
	}

	public JTextField getTxtThuThu() {
		return txtThuThu;
	}

	public void setTxtThuThu(JTextField txtThuThu) {
		this.txtThuThu = txtThuThu;
	}

	public JTextField getTxtMaPM() {
		return txtMaPM;
	}

	public void setTxtMaPM(JTextField txtMaPM) {
		this.txtMaPM = txtMaPM;
	}

	JButton btnXoa,btnXoa1;
	JDateChooser choosedate,choosedate1;
	JComboBox<Object> cbMaSach;
	JTextField txtMaPM;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	public String machon="";
	int soluongtruoc=0;
	int soluongsau=0;
	
	public XoaView(String tieude) {
		this.setTitle(tieude);
		addControls();
		hienThi();
	}
	
	public void hienThi() 
	{	
		try
		{
			String sql="select * from phieumuon where MaPM=?";
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, machon);
			ResultSet rs=pre.executeQuery();
			if(rs.next())
			{
				txtMaPhieu.setText(rs.getString(1));
				txtMaDG.setText(rs.getString(2));
				choosedate.setDate(rs.getDate(3));
				choosedate1.setDate(rs.getDate(4));
				txtSachMuon.setText(rs.getString(5));
				soluongtruoc=rs.getInt(5);
				txtThuThu.setText(rs.getString(6));
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnThemPhieuMuon = new JPanel();
		pnThemPhieuMuon.setLayout(new BorderLayout());
		con.add(pnThemPhieuMuon);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ PHIẾU MƯỢN");
		pnTieuDe.add(lblTieuDe);
		pnThemPhieuMuon.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemPhieuMuon.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiThemPM = new JPanel();
		pnHienThiThemPM.setLayout(new BorderLayout());
		pnThemPhieuMuon.add(pnHienThiThemPM, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/kha2.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiThemPM.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiThemPM.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblThemPM= new JLabel("XÓA PHIẾU MƯỢN");
		pnTitle.add(lblThemPM);
		
		JPanel pnMaPM = new JPanel();
		pnMaPM.setLayout(new FlowLayout());
		JLabel lblMaPM = new JLabel("Mã phiếu: ");
		txtMaPhieu= new JTextField();
		txtMaPhieu.setPreferredSize(new Dimension(340, 30));
		pnMaPM.add(lblMaPM);
		pnMaPM.add(txtMaPhieu);
		
		JPanel pnMaDG = new JPanel();
		pnMaDG.setLayout(new FlowLayout());
		JLabel lblMaDG = new JLabel("Mã độc giả: ");
		txtMaDG= new JTextField();
		txtMaDG.setPreferredSize(new Dimension(340, 30));
		pnMaDG.add(lblMaDG);
		pnMaDG.add(txtMaDG);
		
		JPanel pnTenDG = new JPanel();
		pnTenDG.setLayout(new FlowLayout());
		JLabel lblTenDG = new JLabel("Tên độc giả: ");
		txtTenDG = new JTextField();
		txtTenDG.setPreferredSize(new Dimension(340, 30));
		pnTenDG.add(lblTenDG);
		pnTenDG.add(txtTenDG);
		
		JPanel pnNgayMuon= new JPanel();
		pnNgayMuon.setLayout(new FlowLayout());
		JLabel lblNgayMuon = new JLabel("Ngày mượn: ");
		choosedate = new JDateChooser();
		choosedate.setPreferredSize(new Dimension(340, 30));
		choosedate.setDateFormatString("yyyy-MM-dd");
		pnNgayMuon.add(lblNgayMuon);
		pnNgayMuon.add(choosedate);
		
		JPanel pnNgayHenTra= new JPanel();
		pnNgayHenTra.setLayout(new FlowLayout());
		JLabel lblNgayHenTra = new JLabel("Ngày hẹn trả: ");
		choosedate1 = new JDateChooser();
		choosedate1.setPreferredSize(new Dimension(340, 30));
		choosedate1.setDateFormatString("yyyy-MM-dd");
		pnNgayHenTra.add(lblNgayHenTra);
		pnNgayHenTra.add(choosedate1);
		 
		JPanel pnSoSachCM= new JPanel();
		pnSoSachCM.setLayout(new FlowLayout());
		JLabel lblSoSachCM = new JLabel("Số sách mượn: ");
		txtSachMuon= new JTextField();
		txtSachMuon.setPreferredSize(new Dimension(340, 30));
		pnSoSachCM.add(lblSoSachCM);
		pnSoSachCM.add(txtSachMuon);
		
		JPanel pnThuThu = new JPanel();
		pnThuThu.setLayout(new FlowLayout());
		JLabel lblThuThu = new JLabel("Thủ thư: ");
		txtThuThu = new JTextField();
		txtThuThu.setPreferredSize(new Dimension(340, 30));
		pnThuThu.add(lblThuThu);
		pnThuThu.add(txtThuThu);
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnMaPM);
		pnHienThiChiTiet.add(pnMaDG);
		//pnHienThiChiTiet.add(pnTenDG);
		pnHienThiChiTiet.add(pnNgayMuon);
		pnHienThiChiTiet.add(pnNgayHenTra);
		pnHienThiChiTiet.add(pnSoSachCM);
		pnHienThiChiTiet.add(pnThuThu);
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		
		lblTieuDe.setFont(font1);
		lblThemPM.setFont(font2);
		lblMaPM.setFont(font4);
		lblMaDG.setFont(font4);
		lblTenDG.setFont(font4);
		lblNgayMuon.setFont(font4);
		lblNgayHenTra.setFont(font4);
		lblSoSachCM.setFont(font4);
		lblThuThu.setFont(font4);
		lblLienHe.setFont(font4);
		
		txtMaDG.setFont(font4);
		txtMaPhieu.setFont(font4);
		txtTenDG.setFont(font4);
		choosedate.setFont(font4);
		choosedate1.setFont(font4);
		txtSachMuon.setFont(font4);
		txtThuThu.setFont(font4);
		
		txtMaDG.setEditable(false);
		txtMaPhieu.setEditable(false);
		txtTenDG.setEditable(false);
		choosedate.setEnabled(false);
		choosedate1.setEnabled(false);
		txtSachMuon.setEditable(false);
		txtThuThu.setEditable(false);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblThemPM.setForeground(new java.awt.Color(48, 51, 107));
		pnMaPM.setBackground(new java.awt.Color(241, 242, 246));
		pnMaDG.setBackground(new java.awt.Color(241, 242, 246));
		pnTenDG.setBackground(new java.awt.Color(241, 242, 246));
		pnNgayMuon.setBackground(new java.awt.Color(241, 242, 246));
		pnNgayHenTra.setBackground(new java.awt.Color(241, 242, 246));
		pnThuThu.setBackground(new java.awt.Color(241, 242, 246));
		pnSoSachCM.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));		
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnXoa= new JButton("XÓA");
		btnXoa.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnXoa);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnXoa.setFont(font5);
		
		btnXoa.setBackground(new java.awt.Color(255, 177, 66));
		btnXoa.setForeground(Color.white);
		btnXoa.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiThemPM.setBorder(titleLogin);
		
		lblMaDG.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblMaPM.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblTenDG.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblNgayHenTra.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblNgayMuon.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblThuThu.setPreferredSize(lblSoSachCM.getPreferredSize());
		
		this.setSize(900, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public void delete() {
//		int index = quanLySachView.getTblSach().getSelectedRow();
//		if(index == -1) {
//			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 Sách trong bảng để xóa", "Thông Báo", 1);
//			return;
//		}
		PhieuMuonDao phieuMuonDao = new PhieuMuonDao();
		int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
		if(tk == JOptionPane.YES_OPTION) {
			if(phieuMuonDao.delete(txtMaPhieu.getText())) {
				JOptionPane.showMessageDialog(this, "Xóa Sách thành công", "Thông Báo", 1);
			}
			else {
	            JOptionPane.showMessageDialog(this, "Lỗi hệ thống", "Thông Báo", 0);
	        }
		}
		else {
			return;
		}
	}
	public void clear(){	
        txtMaDG.setText("");
        txtMaPhieu.setText("");
        txtMaPM.setText("");
        txtNgayHenTra.setText("");
        txtNgayMuon.setText("");
        txtSachMuon.setText("");
        txtTenDG.setText("");
        txtThuThu.setText("");
        setStatus(true);
    }
	public void setStatus(boolean insertable){
	    txtMaPhieu.setEditable(insertable);
//	    btnThem.setEnabled(insertable);
//	    btnSua.setEnabled(!insertable);
	    btnXoa.setEnabled(!insertable);
	    }
	
	
	public void load() {
    	PhieuMuonDao phieuMuonDao = new PhieuMuonDao();
    	phieuMuons = phieuMuonDao.layThongTinPhieuMuon();
    	DefaultTableModel model = (DefaultTableModel) quanLyPhieuMuonView.gettblPhieuMuon().getModel();
    	model.setRowCount(0);
    	for(PhieuMuon s: phieuMuons) {
    		Object[] row = new Object[] {
    				s.getMaPM(),s.getMaDG(),s.getNgayMuon(),s.getNgayTra(),s.getSoLuong(),s.getUser()
    		};
    		model.addRow(row);
    	}
    }
	
}
