package qltv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.transaction.jta.JtaAfterCompletionSynchronization;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import qltv.entity.TaiKhoan;
import qltv.dao.TaiKhoanDao;

public class QuanLyNguoiDungView extends JFrame{
	JButton btnThem, btnXoa, btnSua, btnQuayLai, btnIcon;
	JTable tblNguoiDung;
	DefaultTableModel dtmNguoiDung;
	JTextField txtTaiKhoạn, txtHoVaTen, txtPhanQuyen, txtCMND, txtSoDienThoai;
	JPasswordField pwdPass;
	ArrayList<TaiKhoan> dstk;
	int dem=2;
	public int ThongKe=0;
	
	public QuanLyNguoiDungView(String title)
	{
		this.setTitle(title);
		addControls();
		hienThiQLND();
	}
	
	public void hienThiQLND() 
	{
		TaiKhoanDao  tksv =new TaiKhoanDao();
		dstk=tksv.layTaiKhoan();
		dtmNguoiDung.setRowCount(0);
		for(TaiKhoan tk:dstk)
		{
			Vector<Object> vec=new Vector<Object>();
			vec.add(tk.getUser());
			vec.add(tk.getTenND());
			vec.add(tk.getSoDienThoai());
			vec.add(tk.getPhanQuyen());
			dtmNguoiDung.addRow(vec);
		}
	}
	
	public void addControls() 
	{
			Container con= getContentPane();
			
			JPanel pnNguoiDung = new JPanel();
			pnNguoiDung.setLayout(new BorderLayout());
			con.add(pnNguoiDung);
			
			JPanel pnTieuDe = new JPanel();
			JLabel lblTieuDe= new JLabel("QUẢN L�? NGƯỜI DÙNG");
			pnTieuDe.add(lblTieuDe);
			pnNguoiDung.add(pnTieuDe, BorderLayout.NORTH);
			Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
			lblTieuDe.setFont(font1);
			pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
			lblTieuDe.setForeground(Color.WHITE);
			
			
			JPanel pnLienHe = new JPanel();
			JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
			pnLienHe.add(lblLienHe);
			pnNguoiDung.add(pnLienHe, BorderLayout.SOUTH);
			pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
			lblLienHe.setForeground(Color.WHITE);
			Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
			lblLienHe.setFont(fontx);
			
			JPanel pnThongTin = new JPanel();
			pnThongTin.setLayout(new BorderLayout());
			pnNguoiDung.add(pnThongTin, BorderLayout.CENTER);
			
			JPanel pnChiTietNguoiDung = new JPanel();
			pnChiTietNguoiDung.setLayout(new BorderLayout());
			
			JPanel pnTieuDe1= new JPanel();
			JLabel lblTieuDe1= new JLabel("THÔNG TIN CHI TIẾT");
			pnTieuDe1.add(lblTieuDe1);
			pnChiTietNguoiDung.add(pnTieuDe1, BorderLayout.NORTH);
			Font font2=new Font("SVN-Avo", Font.BOLD, 18); 
			lblTieuDe1.setFont(font2);
			pnTieuDe1.setBackground(new java.awt.Color(255, 177, 66));
			lblTieuDe1.setForeground(Color.WHITE);
			
			JPanel pnHienThiChiTiet = new JPanel();
			pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
			pnChiTietNguoiDung.add(pnHienThiChiTiet, BorderLayout.CENTER);
			
			JPanel pnTaiKhoan = new JPanel();
			pnTaiKhoan.setLayout(new FlowLayout());
			pnHienThiChiTiet.add(pnTaiKhoan);
			JLabel lblTaiKhoan= new JLabel("Tài khoản: ");
			txtTaiKhoạn= new JTextField();
			txtTaiKhoạn.setPreferredSize(new Dimension(240, 22));
			pnTaiKhoan.add(lblTaiKhoan);
			pnTaiKhoan.add(txtTaiKhoạn);
			
			JPanel pnMatKhau=new JPanel();
			pnMatKhau.setLayout(new FlowLayout());
			pnHienThiChiTiet.add(pnMatKhau);
			JLabel lblMatKhau=new JLabel("Mật khẩu: ");
			pnMatKhau.add(lblMatKhau);
			pwdPass=new JPasswordField();
			pwdPass.setPreferredSize(new Dimension(208, 22));
			pnMatKhau.add(pwdPass);
			btnIcon=new JButton("");
			btnIcon.setIcon(new ImageIcon("Hinh/eye.png"));
			btnIcon.setPreferredSize(new Dimension(29,20));
			btnIcon.setBackground(Color.WHITE);
			btnIcon.setBorder(null);
			pnMatKhau.add(btnIcon);
			
			JPanel pnHoVaTen = new JPanel();
			pnHoVaTen.setLayout(new FlowLayout());
			pnHienThiChiTiet.add(pnHoVaTen);
			JLabel lblHoVaTen= new JLabel("H�? và tên: ");
			txtHoVaTen= new JTextField();
			txtHoVaTen.setPreferredSize(new Dimension(240, 22));
			pnHoVaTen.add(lblHoVaTen);
			pnHoVaTen.add(txtHoVaTen);
			
			JPanel pnSoDienThoai = new JPanel();
			pnSoDienThoai.setLayout(new FlowLayout());
			pnHienThiChiTiet.add(pnSoDienThoai);
			JLabel lblSoDienThoai= new JLabel("Số điện thoại: ");
			txtSoDienThoai= new JTextField();
			txtSoDienThoai.setPreferredSize(new Dimension(240, 22));
			pnSoDienThoai.add(lblSoDienThoai);
			pnSoDienThoai.add(txtSoDienThoai);
			
			JPanel pnCMND = new JPanel();
			pnCMND.setLayout(new FlowLayout());
			pnHienThiChiTiet.add(pnCMND);
			JLabel lblCMND= new JLabel("CMND: ");
			txtCMND= new JTextField();
			txtCMND.setPreferredSize(new Dimension(240, 22));
			pnCMND.add(lblCMND);
			pnCMND.add(txtCMND);
			
			JPanel pnPhanQuyen = new JPanel();
			pnPhanQuyen.setLayout(new FlowLayout());
			pnHienThiChiTiet.add(pnPhanQuyen);
			JLabel lblPhanQuyen= new JLabel("Phân quy�?n: ");
			txtPhanQuyen= new JTextField();
			txtPhanQuyen.setPreferredSize(new Dimension(240, 22));
			pnPhanQuyen.add(lblPhanQuyen);
			pnPhanQuyen.add(txtPhanQuyen);
	
			JPanel pnThaoTac=new JPanel();
			pnThaoTac.setLayout(new BorderLayout());
			
			JPanel pnQuayLai = new JPanel();
			pnQuayLai.setLayout(new FlowLayout());
			btnQuayLai= new JButton("QUAY LẠI");
			btnQuayLai.setBackground(new java.awt.Color(255, 177, 66));
			Font font4= new Font("SVN-Avo", Font.BOLD, 15);
			btnQuayLai.setFont(font4);
			pnQuayLai.add(btnQuayLai);
			btnQuayLai.setForeground(Color.WHITE);
			pnQuayLai.setBackground(new java.awt.Color(255, 177, 66));
			pnThaoTac.add(pnQuayLai, BorderLayout.NORTH);
			
			JPanel pnChucNang= new JPanel();
			pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
			
			JPanel pnThem= new JPanel();
			pnThem.setLayout(new FlowLayout());
			btnThem= new JButton();
			pnThem.add(btnThem);
			btnThem.setBackground(new java.awt.Color(255, 177, 66));
			pnThem.setBackground(new java.awt.Color(255, 177, 66));
			
			JPanel pnXoa= new JPanel();
			pnXoa.setLayout(new FlowLayout());
			btnXoa= new JButton();
			btnXoa.setBackground(new java.awt.Color(255, 177, 66));
			pnXoa.add(btnXoa);
			pnXoa.setBackground(new java.awt.Color(255, 177, 66));
			
			JPanel pnSua= new JPanel();
			pnSua.setLayout(new FlowLayout());
			btnSua= new JButton();
			btnSua.setBackground(new java.awt.Color(255, 177, 66));
			pnSua.add(btnSua);
			pnSua.setBackground(new java.awt.Color(255, 177, 66));
			
			pnChucNang.add(pnThem);
			pnChucNang.add(pnXoa);
			pnChucNang.add(pnSua);
			
			pnThaoTac.add(pnChucNang, BorderLayout.CENTER);
			
			Border borderHienThi= BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66));
			TitledBorder titleBorderHienThi= new TitledBorder(borderHienThi);
			titleBorderHienThi.setTitleJustification(TitledBorder.LEFT);
			pnHienThiChiTiet.setBorder(titleBorderHienThi);
			
			JPanel pnBangThongKe = new JPanel();
			pnBangThongKe.setLayout(new BorderLayout());
			
			dtmNguoiDung=new DefaultTableModel();
			dtmNguoiDung.addColumn("Tài khoản");
			dtmNguoiDung.addColumn("H�? và tên");
			dtmNguoiDung.addColumn("Số điện thoại");
			dtmNguoiDung.addColumn("Phân quy�?n");
			tblNguoiDung=new JTable(dtmNguoiDung);
			JScrollPane sc=new JScrollPane(tblNguoiDung, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sc.setPreferredSize(new Dimension(400, 380));
			pnBangThongKe.add(sc, BorderLayout.CENTER);
			
			JPanel pnTieuDe2= new JPanel();
			JLabel lblTieuDe2= new JLabel("DANH S�?CH NGƯỜI DÙNG");
			pnTieuDe2.add(lblTieuDe2);
			pnBangThongKe.add(pnTieuDe2, BorderLayout.NORTH);
			lblTieuDe2.setFont(font2);
			pnTieuDe2.setBackground(new java.awt.Color(48, 51, 107));
			lblTieuDe2.setForeground(Color.WHITE);
			
			btnQuayLai.setPreferredSize(new Dimension(220,30));
			btnThem.setPreferredSize(new Dimension(210, 60));
			btnXoa.setPreferredSize(btnThem.getPreferredSize());
			btnSua.setPreferredSize(btnThem.getPreferredSize());
			
			pnThongTin.add(pnChiTietNguoiDung, BorderLayout.CENTER);
			pnThongTin.add(pnBangThongKe, BorderLayout.SOUTH);
			pnThongTin.add(pnThaoTac, BorderLayout.EAST);
			
			Font font3=new Font("SVN-Avo", Font.BOLD, 15); 
			lblTaiKhoan.setFont(font3);
			lblHoVaTen.setFont(font3);
			lblPhanQuyen.setFont(font3);
			lblSoDienThoai.setFont(font3);
			lblCMND.setFont(font3);
			lblMatKhau.setFont(font3);
			
			lblCMND.setPreferredSize(lblSoDienThoai.getPreferredSize());
			lblMatKhau.setPreferredSize(lblSoDienThoai.getPreferredSize());
			lblPhanQuyen.setPreferredSize(lblSoDienThoai.getPreferredSize());
			lblHoVaTen.setPreferredSize(lblSoDienThoai.getPreferredSize());
			lblTaiKhoan.setPreferredSize(lblSoDienThoai.getPreferredSize());
			
			pnMatKhau.setBackground(new java.awt.Color(255, 255, 255));
			pnHoVaTen.setBackground(new java.awt.Color(255, 255, 255));
			pnPhanQuyen.setBackground(new java.awt.Color(255, 255, 255));
			pnSoDienThoai.setBackground(new java.awt.Color(255, 255, 255));
			pnTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
			pnCMND.setBackground(new java.awt.Color(255, 255, 255));
	
			txtSoDienThoai.setEditable(false);
			txtTaiKhoạn.setEditable(false);
			txtHoVaTen.setEditable(false);
			txtPhanQuyen.setEditable(false);
			pwdPass.setEditable(false);
			txtCMND.setEditable(false);
			
			btnThem.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/themmoi.png"));
			btnXoa.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/xoa.png"));
			btnSua.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/sua.png"));
			btnQuayLai.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			btnThem.setBorder(null);
			btnXoa.setBorder(null);
			btnSua.setBorder(null);
			
			this.setSize(865,780);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnQuayLai.addActionListener(listener);
	}
	public void addListener1(MouseListener listener) {
		tblNguoiDung.addMouseListener(listener);
	}
	public void addListener2(ActionListener listener) {
		btnIcon.addActionListener(listener);
	}
	public void addListener3(ActionListener listener) {
		btnThem.addActionListener(listener);
	}
	public void addListener4(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}
	public void addListener5(ActionListener listener) {
		btnSua.addActionListener(listener);
	}
	
	
	public JTable gettblNguoiDung() {
		return tblNguoiDung;
	}
	public void settblNguoiDung(JTable tblNguoiDung) {
		this.tblNguoiDung = tblNguoiDung;
	}
	public DefaultTableModel getdtmNguoiDung() {
		return dtmNguoiDung;
	}
	public void setdtmNguoiDung(DefaultTableModel dtmNguoiDung) {
		this.dtmNguoiDung = dtmNguoiDung;
	}
	public JTextField gettxtTaiKhoan() {
		return txtTaiKhoạn;
	}
	public void settxtTaiKhoan(JTextField txtTaiKhoan) {
		this.txtTaiKhoạn = txtTaiKhoan;
	}
	public JTextField gettxtHoVaTen() {
		return txtHoVaTen;
	}
	public void settxtHoVaTen(JTextField txtHoVaTen) {
		this.txtHoVaTen = txtHoVaTen;
	}
	public JTextField gettxtPhanQuyen() {
		return txtPhanQuyen;
	}
	public void settxtPhanQuyen(JTextField txtPhanQuyen) {
		this.txtPhanQuyen = txtPhanQuyen;
	}
	public JTextField gettxtSoDienThoai() {
		return txtSoDienThoai;
	}
	public void settxtSoDienThoai(JTextField txtSoDienThoai) {
		this.txtSoDienThoai = txtSoDienThoai;
	}
	public JTextField gettxtCMND() {
		return txtCMND;
	}
	public void settxtCMND(JTextField txtCMND) {
		this.txtCMND = txtCMND;
	}
	public JPasswordField getpwdPass() {
		return pwdPass;
	}
	public void setpwdPass(JPasswordField pwdPass) {
		this.pwdPass = pwdPass;
	}

//	public void getmodal(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
}
