package qltv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

//import qltv.controller.LoGinController.LoginListener;
import qltv.dao.ConnectMySQL;
import qltv.entity.TaiKhoan;

public class LoGinView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton btnDangNhap, btnThoat;
	JTextField txtTaiKhoan;
	JPasswordField pwdMatKhau;
	JLabel lblTaiKhoan;
	Connection connect=ConnectMySQL.connect;
	
	public LoGinView (String title) {
		super(title);
		addControls();
	}
	private void addControls() {
		Container con = getContentPane();
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(new BorderLayout());
		con.add(pnDangNhap);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("PHẦN MỀM QUẢN LÝ THƯ VIỆN");
		pnTieuDe.add(lblTieuDe);
		pnDangNhap.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setLayout(new BoxLayout(pnLogin, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblLogin= new JLabel("ĐĂNG NHẬP");
		pnTitle.add(lblLogin);
		
		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		lblTaiKhoan = new JLabel("TÀI KHOẢN  ");
		txtTaiKhoan = new JTextField("User name");
		txtTaiKhoan.setPreferredSize(new Dimension(350, 30));
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		
		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setLayout(new FlowLayout());
		JLabel lblMatKhau = new JLabel("MẬT KHẨU  ");
		pwdMatKhau = new JPasswordField("Password");
		pwdMatKhau.setEchoChar((char)0);
		pwdMatKhau.setPreferredSize(new Dimension(350, 30));
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(pwdMatKhau);
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		btnDangNhap= new JButton("Đăng nhập");
		btnThoat= new JButton("Thoát");
		btnDangNhap.setPreferredSize(new Dimension(130,35));
		pnThaoTac.add(btnDangNhap);
		pnThaoTac.add(btnThoat);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnDangNhap.add(pnLienHe, BorderLayout.SOUTH);
		Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(fontx);
		
		pnLogin.add(pnTitle);
		pnLogin.add(pnTaiKhoan);
		pnLogin.add(pnMatKhau);
		pnLogin.add(pnThaoTac);
		pnDangNhap.add(pnLogin, BorderLayout.CENTER);
		
		
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.TRUETYPE_FONT, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 10);
		lblTieuDe.setFont(font1);
		lblLogin.setFont(font1);
		lblTaiKhoan.setFont(font3);
		lblMatKhau.setFont(font3);
		txtTaiKhoan.setFont(font4);
		pwdMatKhau.setFont(font4);
		btnThoat.setFont(font5);
		btnDangNhap.setFont(font5);
		
		btnDangNhap.setIcon(new ImageIcon("Hinh/lock.png"));
		btnThoat.setIcon(new ImageIcon("Hinh/close.png"));
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblLogin.setForeground(new java.awt.Color(48, 51, 107));
		pnTaiKhoan.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhau.setBackground(new java.awt.Color(241, 242, 246));
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnDangNhap.setBackground(new java.awt.Color(48, 51, 107));
		btnDangNhap.setForeground(Color.white);
		btnThoat.setBackground(new java.awt.Color(48, 51, 107));
		btnThoat.setForeground(Color.white);
		
		
		btnThoat.setPreferredSize(btnDangNhap.getPreferredSize());
		lblMatKhau.setPreferredSize(lblTaiKhoan.getPreferredSize() );
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnLogin.setBorder(titleLogin);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(540, 350);
        this.setResizable(false);
	}
	
	
	public void actionPerformed(ActionEvent e) {
    }
    
     
    public void addLoginListener(ActionListener listener) {
        btnDangNhap.addActionListener(listener);
    }
    
    public void addMouseListener(MouseListener listener) {
    	txtTaiKhoan.addMouseListener(listener);
    }
    public void addMouseListenerr(MouseListener listener) {
    	pwdMatKhau.addMouseListener(listener);
    }
    
    public JTextField getUserNameField() {
    	return txtTaiKhoan;
    }
    public void setUserNameField(JTextField userNameField) {
    	this.txtTaiKhoan = userNameField;
    }
    
    public JPasswordField getPasswordField() {
    	return pwdMatKhau;
    }
    public void setPasswordField(JPasswordField passwordField) {
    	this.pwdMatKhau = passwordField;
    }

	public TaiKhoan getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
