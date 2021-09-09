package qltv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import qltv.dao.ConnectMySQL;

public class DoiMatKhauView extends JFrame{
	JButton btnLuu, btnQuayLai, btnLamLai;
    JPasswordField pwdMatKhauCu, pwdMatKhauMoi, pwdNhapLaiMKM;
    Connection connect= ConnectMySQL.connect;
    JTextField txtTaiKhoan, txtMatKhauCu, txtMatKhauMoi, txtNhapLaiMKM;
    public String tentk="";
    
    public DoiMatKhauView(String tieude){
        super(tieude);
        addControls();
        if(tentk.length() != 0){
            Hienthi();
        }
    }
    
    public void Hienthi(){
        txtTaiKhoan.setText(tentk);
    }
    
    private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnDoiMatKhau= new JPanel();
		pnDoiMatKhau.setLayout(new BorderLayout());
		con.add(pnDoiMatKhau);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("PHẦN MỀM QUẢN L�? THƯ VIỆN");
		pnTieuDe.add(lblTieuDe);
		pnDoiMatKhau.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnDoiMatKhau.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiDoiMatKhau = new JPanel();
		pnHienThiDoiMatKhau.setLayout(new BorderLayout());
		pnDoiMatKhau.add(pnHienThiDoiMatKhau, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/doimatkhau.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiDoiMatKhau.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiDoiMatKhau.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblDoiMatKhau= new JLabel("�?ỔI MẬT KHẨU");
		pnTitle.add(lblDoiMatKhau);
		
		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setPreferredSize(new Dimension(340, 30));
		pnTaiKhoan.add(txtTaiKhoan);
		txtTaiKhoan.setEditable(false);
		
		JPanel pnMatKhauCu = new JPanel();
		pnMatKhauCu.setLayout(new FlowLayout());
		pwdMatKhauCu = new JPasswordField("Mật khẩu cũ");
		pwdMatKhauCu.setEchoChar((char)0);
		pwdMatKhauCu.setPreferredSize(new Dimension(340, 30));
		pnMatKhauCu.add(pwdMatKhauCu);
		
		JPanel pnMatKhauMoi = new JPanel();
		pnMatKhauMoi.setLayout(new FlowLayout());
		pwdMatKhauMoi = new JPasswordField("Mật khẩu mới");
		pwdMatKhauMoi.setEchoChar((char)0);
		pwdMatKhauMoi.setPreferredSize(new Dimension(340, 30));
		pnMatKhauMoi.add(pwdMatKhauMoi);
		
		JPanel pnNhapLaiMKM = new JPanel();
		pnNhapLaiMKM.setLayout(new FlowLayout());
		pwdNhapLaiMKM= new JPasswordField("Nhập lại mật khẩu mới");
		pwdNhapLaiMKM.setEchoChar((char)0);
		pwdNhapLaiMKM.setPreferredSize(new Dimension(340, 30));
		pnNhapLaiMKM.add(pwdNhapLaiMKM);
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnTaiKhoan);
		pnHienThiChiTiet.add(pnMatKhauCu);
		pnHienThiChiTiet.add(pnMatKhauMoi);
		pnHienThiChiTiet.add(pnNhapLaiMKM);
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnLuu= new JButton("LƯU");
		btnLamLai= new JButton("LÀM LẠI");
		btnQuayLai= new JButton("TRANG CHỦ");
		btnQuayLai.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnLamLai);
		pnThaoTac.add(btnLuu);
		pnThaoTac.add(btnQuayLai);
		
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblDoiMatKhau.setFont(font2);
		txtTaiKhoan.setFont(font4);
		pwdMatKhauCu.setFont(font4);
		pwdNhapLaiMKM.setFont(font4);
		pwdMatKhauMoi.setFont(font4);
		lblLienHe.setFont(font4);
		
		btnLamLai.setFont(font5);
		btnQuayLai.setFont(font5);
		btnLuu.setFont(font5);
		
		// btnDangNhap.setIcon(new ImageIcon("Hinh/lock.png"));
		// btnThoat.setIcon(new ImageIcon("Hinh/close.png"));  
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblDoiMatKhau.setForeground(new java.awt.Color(48, 51, 107));
		pnTaiKhoan.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhauCu.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhauMoi.setBackground(new java.awt.Color(241, 242, 246));
		pnNhapLaiMKM.setBackground(new java.awt.Color(241, 242, 246));
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		
		btnLamLai.setBackground(new java.awt.Color(255, 177, 66));
		btnLamLai.setForeground(Color.white);
		btnLamLai.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		btnQuayLai.setBackground(new java.awt.Color(255, 177, 66));
		btnQuayLai.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		btnQuayLai.setForeground(Color.white);
		btnLuu.setBackground(new java.awt.Color(5, 196, 107));
		btnLuu.setForeground(Color.white);
		btnLuu.setBorder(BorderFactory.createLineBorder(new java.awt.Color(5, 196, 107)));
		
		
		btnLuu.setPreferredSize(btnQuayLai.getPreferredSize());
		btnLamLai.setPreferredSize(btnQuayLai.getPreferredSize());
		//lblMatKhau.setPreferredSize(lblTaiKhoan.getPreferredSize() ); */
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiDoiMatKhau.setBorder(titleLogin);
		
		this.setSize(780, 430);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
    
    public void addListener(ActionListener listener) {
    	btnQuayLai.addActionListener(listener);
    }
    public void addListener1(ActionListener listener) {
    	btnLuu.addActionListener(listener);
    }
    public void addListener2(ActionListener listener) {
    	btnLamLai.addActionListener(listener);
    }
    public void addListener3(MouseListener listener) {
    	pwdMatKhauCu.addMouseListener(listener);
    }
    public void addListener4(MouseListener listener) {
    	pwdMatKhauMoi.addMouseListener(listener);
    }
    public void addListener5(MouseListener listener) {
    	pwdNhapLaiMKM.addMouseListener(listener);
    }
    
    
    public JTextField gettxtMatKhauCu() {
    	return txtMatKhauCu;
    }
    public void settxtMatKhauCu(JTextField txtMatKhauCu) {
    	this.txtMatKhauCu = txtMatKhauCu;
    }
    public JTextField gettxtMatKhauMoi() {
    	return txtMatKhauMoi;
    }
    public void settxtMatKhauMoi(JTextField txtMatKhauMoi) {
    	this.txtMatKhauMoi = txtMatKhauMoi;
    }
    public JTextField gettxtNhapLaiMKM() {
    	return txtNhapLaiMKM;
    }
    public void settxtNhapLaiMKM(JTextField txtNhapLaiMKM) {
    	this.txtNhapLaiMKM = txtNhapLaiMKM;
    }
    public JTextField gettxtTaiKhoan() {
    	return txtTaiKhoan;
    }
    public void settxtTaiKhoan(JTextField txtTaiKhoan) {
    	this.txtTaiKhoan = txtTaiKhoan;
    }
    public JPasswordField getpwdMatKhauCu() {
    	return pwdMatKhauCu;
    }
    public void setpwdMatKhauCu(JPasswordField pwdMatKhauCu) {
    	this.pwdMatKhauCu = pwdMatKhauCu;
    }
    public JPasswordField getpwdMatKhauMoi() {
    	return pwdMatKhauMoi;
    }
    public void settxtMatKhauMoi(JPasswordField pwdMatKhauMoi) {
    	this.pwdMatKhauMoi = pwdMatKhauMoi;
    }
    public JPasswordField getpwdNhapLaiMKM() {
    	return pwdNhapLaiMKM;
    }
    public void settxtNhapLaiMKM(JPasswordField pwdNhapLaiMKM) {
    	this.pwdNhapLaiMKM = pwdNhapLaiMKM;
    }

	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
