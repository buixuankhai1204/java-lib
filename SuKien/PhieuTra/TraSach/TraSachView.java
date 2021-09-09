package qltv.SuKien.PhieuTra.TraSach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class TraSachView extends JFrame{
	JTextField txtMaPhieu, txtMaDG, txtMaSach, txtNgayHenTra, txtNgayTra, txtTTSachMuon, txtTTSachTra, txtThuThuNhanSach, txtGhiChu;
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

	public JTextField getTxtMaSach() {
		return txtMaSach;
	}

	public void setTxtMaSach(JTextField txtMaSach) {
		this.txtMaSach = txtMaSach;
	}

	public JTextField getTxtNgayHenTra() {
		return txtNgayHenTra;
	}

	public void setTxtNgayHenTra(JTextField txtNgayHenTra) {
		this.txtNgayHenTra = txtNgayHenTra;
	}

	public JTextField getTxtNgayTra() {
		return txtNgayTra;
	}

	public void setTxtNgayTra(JTextField txtNgayTra) {
		this.txtNgayTra = txtNgayTra;
	}

	public JTextField getTxtTTSachMuon() {
		return txtTTSachMuon;
	}

	public void setTxtTTSachMuon(JTextField txtTTSachMuon) {
		this.txtTTSachMuon = txtTTSachMuon;
	}

	public JTextField getTxtTTSachTra() {
		return txtTTSachTra;
	}

	public void setTxtTTSachTra(JTextField txtTTSachTra) {
		this.txtTTSachTra = txtTTSachTra;
	}

	public JTextField getTxtThuThuNhanSach() {
		return txtThuThuNhanSach;
	}

	public void setTxtThuThuNhanSach(JTextField txtThuThuNhanSach) {
		this.txtThuThuNhanSach = txtThuThuNhanSach;
	}

	public JTextField getTxtGhiChu() {
		return txtGhiChu;
	}

	public void setTxtGhiChu(JTextField txtGhiChu) {
		this.txtGhiChu = txtGhiChu;
	}

	JButton btnTraSach;
	public String MaPM="", MaSach="", NgayHenTra="", TinhTrangSach="", tentk="", MaDG="";
	JDateChooser choosedate;
	
	public TraSachView(String tieude)
	 {
		 this.setTitle(tieude);
		 addControls();
		 hienThi();
	 }
	
	public void hienThi() 
	{
		txtMaPhieu.setText(MaPM);
		txtMaSach.setText(MaSach);
		txtMaDG.setText(MaDG);
		txtNgayHenTra.setText(NgayHenTra);
		txtTTSachMuon.setText(TinhTrangSach);
		txtThuThuNhanSach.setText(tentk);	
	}
	
	public void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnTraSach = new JPanel();
		pnTraSach.setLayout(new BorderLayout());
		con.add(pnTraSach);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ PHIẾU TRẢ");
		pnTieuDe.add(lblTieuDe);
		pnTraSach.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnTraSach.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiTraSach = new JPanel();
		pnHienThiTraSach.setLayout(new BorderLayout());
		pnTraSach.add(pnHienThiTraSach, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/sachmn.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiTraSach.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiTraSach.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTraSach= new JLabel("TRẢ SÁCH");
		pnTitle.add(lblTraSach);
		pnHienThiChiTiet.add(pnTitle);
		
		JPanel pnMaPhieu = new JPanel();
		pnMaPhieu.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnMaPhieu);
		JLabel lblMaPhieu= new JLabel("Mã phiếu: ");
		txtMaPhieu= new JTextField();
		txtMaPhieu.setPreferredSize(new Dimension(340, 30));
		pnMaPhieu.add(lblMaPhieu);
		pnMaPhieu.add(txtMaPhieu);
		
		JPanel pnMaDG=new JPanel();
		pnMaDG.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnMaDG);
		JLabel lblMaDG=new JLabel("Mã độc giả: ");
		pnMaDG.add(lblMaDG);
		txtMaDG=new JTextField();
		txtMaDG.setPreferredSize(new Dimension(340, 30));
		pnMaDG.add(txtMaDG);
		
		JPanel pnMaSach=new JPanel();
		pnMaSach.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnMaSach);
		JLabel lblMaSach=new JLabel("Mã sách: ");
		pnMaSach.add(lblMaSach);
		txtMaSach= new JTextField();
		txtMaSach.setPreferredSize(new Dimension(340, 30));
		pnMaSach.add(txtMaSach);
		
		JPanel pnNgayHenTra = new JPanel();
		pnNgayHenTra.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnNgayHenTra);
		JLabel lblNgayHenTra= new JLabel("Ngày hẹn trả: ");
		txtNgayHenTra= new JTextField();
		txtNgayHenTra.setPreferredSize(new Dimension(340, 30));
		pnNgayHenTra.add(lblNgayHenTra);
		pnNgayHenTra.add(txtNgayHenTra);
		
		JPanel pnNgayTra = new JPanel();
		pnNgayTra.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnNgayTra);
		JLabel lblNgayTra= new JLabel("Ngày trả: ");
		choosedate = new JDateChooser();
		choosedate.setPreferredSize(new Dimension(340, 30));
		choosedate.setDateFormatString("yyyy-MM-dd");
		pnNgayTra.add(lblNgayTra);
		pnNgayTra.add(choosedate);
		
		JPanel pnTinhTrangSach = new JPanel();
		pnTinhTrangSach.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnTinhTrangSach);
		JLabel lblTinhTrangSach= new JLabel("TT sách mượn: ");
		txtTTSachMuon= new JTextField();
		txtTTSachMuon.setPreferredSize(new Dimension(340, 30));
		pnTinhTrangSach.add(lblTinhTrangSach);
		pnTinhTrangSach.add(txtTTSachMuon);
		
		JPanel pnTinhTrangTra= new JPanel();
		pnTinhTrangTra.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnTinhTrangTra);
		JLabel lblTinhTrangTra= new JLabel("TT sách trả: ");
		txtTTSachTra= new JTextField();
		txtTTSachTra.setPreferredSize(new Dimension(340, 30));
		pnTinhTrangTra.add(lblTinhTrangTra);
		pnTinhTrangTra.add(txtTTSachTra);
		
		JPanel pnThuThuNhanSach= new JPanel();
		pnThuThuNhanSach.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThuThuNhanSach);
		JLabel lblThuThuNhanSach= new JLabel("Thủ thư nhận sách: ");
		txtThuThuNhanSach= new JTextField();
		txtThuThuNhanSach.setPreferredSize(new Dimension(340, 30));
		pnThuThuNhanSach.add(lblThuThuNhanSach);
		pnThuThuNhanSach.add(txtThuThuNhanSach);
		
		JPanel pnGhiChu= new JPanel();
		pnGhiChu.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnGhiChu);
		JLabel lblGhiChu= new JLabel("Ghi chú: ");
		txtGhiChu= new JTextField();
		txtGhiChu.setPreferredSize(new Dimension(340, 30));
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(txtGhiChu);
		
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		
		lblMaDG.setFont(font4);
		lblMaPhieu.setFont(font4);
		lblMaSach.setFont(font4);
		lblNgayTra.setFont(font4);
		lblNgayHenTra.setFont(font4);
		lblTinhTrangSach.setFont(font4);
		lblTinhTrangTra.setFont(font4);
		lblThuThuNhanSach.setFont(font4); 
		lblGhiChu.setFont(font4); 
		lblTraSach.setFont(font2);
		
		txtMaDG.setFont(font4);
		txtMaPhieu.setFont(font4);
		txtMaSach.setFont(font4);
		txtNgayHenTra.setFont(font4);
		choosedate.setFont(font4);
		txtTTSachMuon.setFont(font4);
		txtTTSachTra.setFont(font4);
		txtThuThuNhanSach.setFont(font4);
		txtGhiChu.setFont(font4);
		txtMaPhieu.setEditable(false);
		lblTieuDe.setFont(font1);
		lblLienHe.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblTraSach.setForeground(new java.awt.Color(48, 51, 107));
		pnMaDG.setBackground(new java.awt.Color(241, 242, 246));
		pnMaPhieu.setBackground(new java.awt.Color(241, 242, 246));
		pnMaSach.setBackground(new java.awt.Color(241, 242, 246));
		pnNgayTra.setBackground(new java.awt.Color(241, 242, 246));
		pnNgayHenTra.setBackground(new java.awt.Color(241, 242, 246));
		pnTinhTrangSach.setBackground(new java.awt.Color(241, 242, 246));
		pnTinhTrangTra.setBackground(new java.awt.Color(241, 242, 246));
		pnThuThuNhanSach.setBackground(new java.awt.Color(241, 242, 246));
		pnGhiChu.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));		
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnTraSach= new JButton("TRẢ SÁCH");
		btnTraSach.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnTraSach);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnTraSach.setFont(font5);
		
		btnTraSach.setBackground(new java.awt.Color(255, 177, 66));
		btnTraSach.setForeground(Color.white);
		btnTraSach.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiTraSach.setBorder(titleLogin);
		
		lblMaDG.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		lblMaPhieu.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		lblMaSach.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		lblNgayHenTra.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		lblNgayTra.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		lblGhiChu.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		lblTinhTrangSach.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		lblTinhTrangTra.setPreferredSize(lblThuThuNhanSach.getPreferredSize());
		
		txtMaDG.setEditable(false);
		txtMaPhieu.setEditable(false);
		txtMaSach.setEditable(false);
		txtNgayHenTra.setEnabled(false);
		txtThuThuNhanSach.setEditable(false);
		txtTTSachMuon.setEditable(false);
		
		this.setSize(940, 580);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnTraSach.addActionListener(listener);
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
