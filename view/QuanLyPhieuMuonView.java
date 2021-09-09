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
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import qltv.dao.ConnectMySQL;
import qltv.dao.PhieuMuonDao;
import qltv.entity.PhieuMuon;
public class QuanLyPhieuMuonView extends JFrame{
	JTextField txtMaPhieu, txtTenDG, txtNgayMuon, txtNgayHenTra, txtSoSachMuon, txtThuThu, txtMaDG;
	JButton btnThem, btnXoa, btnSua, btnQuayLai;
	DefaultTableModel dtmPhieuMuon, dtmSachMuon;
	JTable tblPhieuMuon, tblSachMuon;
	Connection conn=ConnectMySQL.connect;
	ArrayList<PhieuMuon> dspm;
	
	public QuanLyPhieuMuonView(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		hienThiPhieuMuon();
	}
	
	public void hienThiPhieuMuon() 
	{
		PhieuMuonDao pmsv = new PhieuMuonDao();
		dspm=pmsv.layThongTinPhieuMuon();
		dtmPhieuMuon.setRowCount(0);
		for(PhieuMuon pm: dspm)
		{
			Vector<Object> vec=new Vector<>();
			vec.add(pm.getMaPM());
			vec.add(pm.getMaDG());
			vec.add(pm.getNgayMuon());
			vec.add(pm.getNgayTra());
			vec.add(pm.getSoLuong());
			vec.add(pm.getUser());
			dtmPhieuMuon.addRow(vec);
		}
	}
	
	private void addControls() 
	{
		Container con= getContentPane();
		
		JPanel pnPhieuMuon = new JPanel();
		pnPhieuMuon.setLayout(new BorderLayout());
		con.add(pnPhieuMuon);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN L�? PHIẾU MƯỢN");
		pnTieuDe.add(lblTieuDe);
		pnPhieuMuon.add(pnTieuDe, BorderLayout.NORTH);
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnPhieuMuon.add(pnLienHe, BorderLayout.SOUTH);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(fontx);
		
		JPanel pnThongTin= new JPanel();
		pnThongTin.setLayout(new BorderLayout());
		pnPhieuMuon.add(pnThongTin, BorderLayout.CENTER);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BorderLayout());
		pnThongTin.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnThongTinChiTiet = new JPanel();
		pnThongTinChiTiet.setLayout(new BoxLayout(pnThongTinChiTiet, BoxLayout.Y_AXIS));
		pnHienThiChiTiet.add(pnThongTinChiTiet, BorderLayout.WEST);
		pnThongTinChiTiet.setPreferredSize(new Dimension(450,0));
		
		JPanel pnTieuDe1= new JPanel();
		JLabel lblTieuDe1= new JLabel("THÔNG TIN CHI TIẾT");
		pnTieuDe1.add(lblTieuDe1);
		pnThongTinChiTiet.add(pnTieuDe1, BorderLayout.NORTH);
		
		Font font2=new Font("SVN-Avo", Font.BOLD, 18); 
		lblTieuDe1.setFont(font2);
		pnTieuDe1.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe1.setForeground(Color.WHITE);
		
		JPanel pnMaPhieu = new JPanel();
		pnMaPhieu.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnMaPhieu);
		JLabel lblMaPhieu= new JLabel("Mã phiếu: ");
		txtMaPhieu= new JTextField();
		txtMaPhieu.setPreferredSize(new Dimension(240, 22));
		pnMaPhieu.add(lblMaPhieu);
		pnMaPhieu.add(txtMaPhieu);
		
		JPanel pnMaDG=new JPanel();
		pnMaDG.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnMaDG);
		JLabel lblMaDG=new JLabel("Mã độc giả: ");
		pnMaDG.add(lblMaDG);
		txtMaDG=new JTextField();
		txtMaDG.setPreferredSize(new Dimension(240, 22));
		pnMaDG.add(txtMaDG);
		
		JPanel pnTenDG=new JPanel();
		pnTenDG.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnTenDG);
		JLabel lblTenDG=new JLabel("Tên độc giả: ");
		pnTenDG.add(lblTenDG);
		txtTenDG=new JTextField();
		txtTenDG.setPreferredSize(new Dimension(240, 22));
		pnTenDG.add(txtTenDG);
		
		JPanel pnNgayMuon = new JPanel();
		pnNgayMuon.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnNgayMuon);
		JLabel lblNgayMuon= new JLabel("Ngày mượn: ");
		txtNgayMuon= new JTextField();
		txtNgayMuon.setPreferredSize(new Dimension(240, 22));
		pnNgayMuon.add(lblNgayMuon);
		pnNgayMuon.add(txtNgayMuon);
		
		JPanel pnNgayHenTra = new JPanel();
		pnNgayHenTra.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnNgayHenTra);
		JLabel lblNgayHenTra= new JLabel("Ngày hẹn trả: ");
		txtNgayHenTra= new JTextField();
		txtNgayHenTra.setPreferredSize(new Dimension(240, 22));
		pnNgayHenTra.add(lblNgayHenTra);
		pnNgayHenTra.add(txtNgayHenTra);
		
		JPanel pnSachMuon = new JPanel();
		pnSachMuon.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnSachMuon);
		JLabel lblSachMuon= new JLabel("Sách mượn: ");
		txtSoSachMuon= new JTextField();
		txtSoSachMuon.setPreferredSize(new Dimension(240, 22));
		pnSachMuon.add(lblSachMuon);
		pnSachMuon.add(txtSoSachMuon);
		
		JPanel pnThuThu= new JPanel();
		pnThuThu.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnThuThu);
		JLabel lblThuThu= new JLabel("Thủ thư: ");
		txtThuThu= new JTextField();
		txtThuThu.setPreferredSize(new Dimension(240, 22));
		pnThuThu.add(lblThuThu);
		pnThuThu.add(txtThuThu);
		
		JPanel pnThaoTac=new JPanel();
		pnThaoTac.setLayout(new BorderLayout());
		pnHienThiChiTiet.add(pnThaoTac, BorderLayout.CENTER);
		
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
		
		JPanel pnThongKeSachMuon=new JPanel();
		pnThongKeSachMuon.setLayout(new BorderLayout());
		pnHienThiChiTiet.add(pnThongKeSachMuon, BorderLayout.EAST);
		
		JPanel pnTieuDe2=new JPanel();
		pnThongKeSachMuon.add(pnTieuDe2,BorderLayout.NORTH);
		JLabel lblTieuDe2=new JLabel("DANH S�?CH S�?CH MƯỢN");
		lblTieuDe2.setFont(font2);
		pnTieuDe2.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe2.setForeground(Color.WHITE);
		pnTieuDe2.add(lblTieuDe2);
			
		dtmSachMuon=new DefaultTableModel();
		dtmSachMuon.addColumn("Mã sách");
		dtmSachMuon.addColumn("Tên sách");
		dtmSachMuon.addColumn("Thể loại");
		tblSachMuon=new JTable(dtmSachMuon);
		JScrollPane scSachMuon=new JScrollPane(tblSachMuon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scSachMuon.setPreferredSize(new Dimension(450,300));
		pnThongKeSachMuon.add(scSachMuon,BorderLayout.CENTER);

		JPanel pnBangThongKe = new JPanel();
		pnBangThongKe.setLayout(new BorderLayout());
		
		dtmPhieuMuon=new DefaultTableModel();
		dtmPhieuMuon.addColumn("Mã phiếu");
		dtmPhieuMuon.addColumn("Mã độc giả");
		dtmPhieuMuon.addColumn("Ngày mượn");
		dtmPhieuMuon.addColumn("Ngày hẹn trả");
		dtmPhieuMuon.addColumn("Số sách mượn");
		dtmPhieuMuon.addColumn("Thủ thư");
		
		tblPhieuMuon=new JTable(dtmPhieuMuon);
		JScrollPane sc=new JScrollPane(tblPhieuMuon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(400, 350));
		pnBangThongKe.add(sc, BorderLayout.CENTER);
		
		JPanel pnTieuDe3= new JPanel();
		JLabel lblTieuDe3= new JLabel("DANH S�?CH PHIẾU MƯỢN");
		pnTieuDe3.add(lblTieuDe3);
		pnBangThongKe.add(pnTieuDe3, BorderLayout.NORTH);
		lblTieuDe3.setFont(font2);
		pnTieuDe3.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe3.setForeground(Color.WHITE);
		
		pnThongTin.add(pnBangThongKe, BorderLayout.SOUTH);
		
		btnThem.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/themmoi.png"));
		btnXoa.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/xoa.png"));
		btnSua.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/chinhsua.png"));
		btnQuayLai.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnThem.setBorder(null);
		btnXoa.setBorder(null);
		btnSua.setBorder(null); 
		
		btnQuayLai.setPreferredSize(new Dimension(200,30));
		btnThem.setPreferredSize(new Dimension(210, 60));
		btnXoa.setPreferredSize(btnThem.getPreferredSize());
		btnSua.setPreferredSize(btnThem.getPreferredSize());
		
		Font font3=new Font("SVN-Avo", Font.BOLD, 14); 
		lblMaDG.setFont(font3);
		lblMaPhieu.setFont(font3);
		lblTenDG.setFont(font3);
		lblNgayMuon.setFont(font3);
		lblNgayHenTra.setFont(font3);
		lblSachMuon.setFont(font3);
		lblThuThu.setFont(font3); 
		
		lblMaPhieu.setPreferredSize(lblNgayHenTra.getPreferredSize());
		lblMaDG.setPreferredSize(lblNgayHenTra.getPreferredSize());
		lblNgayMuon.setPreferredSize(lblNgayHenTra.getPreferredSize());
		lblTenDG.setPreferredSize(lblNgayHenTra.getPreferredSize());
		lblThuThu.setPreferredSize(lblNgayHenTra.getPreferredSize());
		lblSachMuon.setPreferredSize(lblNgayHenTra.getPreferredSize());
		
		pnMaDG.setBackground(new java.awt.Color(255, 255, 255));
		pnTenDG.setBackground(new java.awt.Color(255, 255, 255));
		pnMaPhieu.setBackground(new java.awt.Color(255, 255, 255));
		pnNgayHenTra.setBackground(new java.awt.Color(255, 255, 255));
		pnNgayMuon.setBackground(new java.awt.Color(255, 255, 255));
		pnSachMuon.setBackground(new java.awt.Color(255, 255, 255));
		pnThuThu.setBackground(new java.awt.Color(255, 255, 255));
		
		
		txtMaPhieu.setEditable(false);
		txtTenDG.setEditable(false);
		txtMaDG.setEditable(false);
		txtNgayMuon.setEditable(false);
		txtNgayHenTra.setEditable(false);
		txtSoSachMuon.setEditable(false);
		txtThuThu.setEditable(false);
		
		this.setSize(1130,775);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public void addListener(ActionListener listener) {
		btnQuayLai.addActionListener(listener);
	}
	public void addListener1(MouseListener listener) {
		tblPhieuMuon.addMouseListener(listener);
	}
	public void addListener2(ActionListener listener) {
		btnThem.addActionListener(listener);
	}
	public void addListener3(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}
	public void addListener4(ActionListener listener) {
		btnSua.addActionListener(listener);
	}
	
	public JTextField gettxtMaPhieu() {
		return txtMaPhieu;
	}
	public void settxtMaPhieu(JTextField txtMaPhieu) {
		this.txtMaPhieu = txtMaPhieu;
	}
	public JTextField gettxtMaDG() {
		return txtMaDG;
	}
	public void settxtDG(JTextField txtDG) {
		this.txtMaDG = txtDG;
	}
	public JTextField gettxtNgayMuon() {
		return txtNgayMuon;
	}
	public void settxtNgayMuon(JTextField txtNgayMuon) {
		this.txtNgayMuon = txtNgayMuon;
	}
	public JTextField gettxtNgayHenTra() {
		return txtNgayHenTra;
	}
	public void settxtNgayHenTra(JTextField txtNgayHenTra) {
		this.txtNgayHenTra = txtNgayHenTra;
	}
	public JTextField gettxtSoSachMuon() {
		return txtSoSachMuon;
	}
	public void settxtSoSachMuon(JTextField txtSoSachMuon) {
		this.txtSoSachMuon = txtSoSachMuon;
	}
	public JTextField gettxtThuThu() {
		return txtThuThu;
	}
	public void settxtThuThu(JTextField txtThuThu) {
		this.txtThuThu = txtThuThu;
	}
	public JTextField gettxtTenDG() {
		return txtTenDG;
	}
	public void settxtTenDG(JTextField txtTenDG) {
		this.txtTenDG = txtTenDG;
	}
	public DefaultTableModel getdtmPhieuMuon() {
		return dtmPhieuMuon;
	}
	public void setdtmPhieuMuon(DefaultTableModel dtmPhieuMuon) {
		this.dtmPhieuMuon = dtmPhieuMuon;
	}
	public DefaultTableModel getdtmSachMuon() {
		return dtmSachMuon;
	}
	public void setdtmSachMuon(DefaultTableModel dtmSachMuon) {
		this.dtmSachMuon = dtmSachMuon;
	}
	public JTable gettblPhieuMuon() {
		return tblPhieuMuon;
	}
	public void settblPhieuMuon(JTable tblPhieuMuon) {
		this.tblPhieuMuon = tblPhieuMuon;
	}
}
