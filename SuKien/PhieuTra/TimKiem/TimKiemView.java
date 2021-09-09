package qltv.SuKien.PhieuTra.TimKiem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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

import qltv.dao.ChiTietPhieuMuonDao;
import qltv.entity.ChiTietPhieuMuon;


public class TimKiemView extends JFrame{
	JButton btnTimKiem, btnTraSach;
	JTextField txtTimKiem, txtMaPhieu, txtMaDG, txtMaSach, txtNgayHenTra, txtNgayTra, txtTTSachMuon, txtTTSachTra, txtThuThu, txtGhiChu;
	
	DefaultTableModel dtmPhieuMuon;
	JTable tblPhieuMuon;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	DefaultTableModel dtmPhieuTra, dtmPhieuChuaTra;
	JTable tblPhieuTra, tblPhieuChuaTra;
	ArrayList<ChiTietPhieuMuon> dsctpm;
	
	public TimKiemView(String tieude) {
		this.setTitle(tieude);
		addControls();
	}
	
	public void hienThiPhieuMuonDaTra() {
		ChiTietPhieuMuonDao ctpmsv = new ChiTietPhieuMuonDao();
		dsctpm = ctpmsv.layChiTietPhieuMuon();
		dtmPhieuTra.setRowCount(0);
		for(ChiTietPhieuMuon ctpm:dsctpm) {
			if(ctpm.getNgayTra() != null);
			{
				Vector<Object> vec = new Vector<Object>();
				vec.add(ctpm.getMaPM());
				vec.add(ctpm.getMaSach());
				vec.add(ctpm.getGhiChu());
				dtmPhieuTra.addRow(vec);
			}
		}
	}
	
	public void hienThiPhieuMuonChuaTra() 
	{
		ChiTietPhieuMuonDao ctpmsv=new ChiTietPhieuMuonDao();
		dsctpm=ctpmsv.layChiTietPhieuMuon();
		dtmPhieuChuaTra.setRowCount(0);
		for(ChiTietPhieuMuon ctpm: dsctpm)
		{
			if(ctpm.getNgayTra() == null)
			{
				Vector<Object> vec=new Vector<Object>();
				vec.add(ctpm.getMaPM());
				vec.add(ctpm.getMaSach());
				vec.add(null);
				vec.add(ctpm.getTinhTrangSach());
				vec.add(null);
				vec.add(null);
				vec.add(ctpm.getGhiChu());
				dtmPhieuChuaTra.addRow(vec);
			}
		}
		
	}
	
	private void addControls() {
		Container con = getContentPane();
		
		JPanel pnTimKiemPhieuMuon = new JPanel();
		pnTimKiemPhieuMuon.setLayout(new BorderLayout());
		con.add(pnTimKiemPhieuMuon);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe = new JLabel("QUẢN LÝ PHIẾU TRẢ");
		pnTieuDe.add(lblTieuDe);
		pnTimKiemPhieuMuon.add(pnTieuDe , BorderLayout.NORTH);
		Font font1 = new Font("SVN-Avo",Font.BOLD,24);
		lblTieuDe.setFont(font1);
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe = new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnTimKiemPhieuMuon.add(pnLienHe,BorderLayout.SOUTH);
		Font font2 = new Font("SVN-Avo",Font.BOLD, 13);
		lblLienHe.setFont(font2);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		JPanel pnHienThiTimKiemPhieu = new JPanel();
		pnHienThiTimKiemPhieu.setLayout(new BorderLayout());
		pnTimKiemPhieuMuon.add(pnHienThiTimKiemPhieu,BorderLayout.CENTER);
		
		JPanel pnThanhTimKiem = new JPanel();
		pnThanhTimKiem.setLayout(new BorderLayout());
		
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new FlowLayout());
		btnTimKiem = new JButton("TÌM KIẾM");
		pnTimKiem.add(btnTimKiem);
		pnThanhTimKiem.add(pnTimKiem,BorderLayout.EAST);
		btnTimKiem.setPreferredSize(new Dimension(130,35));
		btnTimKiem.setBackground(new java.awt.Color(48, 51, 107));
		pnTimKiem.setBackground(new java.awt.Color(48, 51, 107));
		btnTimKiem.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		Font font7= new Font("SVN-Avo", Font.BOLD, 15);
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(font7);
		
		JPanel pnTextTimKiem = new JPanel();
		pnTextTimKiem.setLayout(new BorderLayout());
		txtTimKiem = new JTextField("Nhập Mã Phiếu...");
		pnTextTimKiem.add(txtTimKiem);
		pnThanhTimKiem.add(pnTextTimKiem,BorderLayout.CENTER);
		txtTimKiem.setPreferredSize(new Dimension(100,20));
		Font font6= new Font("SVN-Avo", Font.BOLD, 18);
		txtTimKiem.setFont(font6);
		txtTimKiem.setBorder(BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107)));
		
		JPanel pnIcon = new JPanel();
		pnIcon.setLayout(new BorderLayout());
		JLabel lblIcon = new JLabel();
		pnIcon.add(lblIcon);
		pnIcon.setBackground(new java.awt.Color(48, 51, 107));
		lblIcon.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/tim.png"));
		pnThanhTimKiem.add(pnIcon,BorderLayout.WEST);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BorderLayout());
		pnHienThiTimKiemPhieu.add(pnThongTin);
		
		pnThongTin.add(pnThanhTimKiem,BorderLayout.NORTH);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTimKiemSach = new JLabel("TÌM KIẾM PHIẾU TRẢ");
		pnTitle.add(lblTimKiemSach);
		pnHienThiTimKiemPhieu.add(pnTitle,BorderLayout.NORTH);
		Font font5= new Font("SVN-Avo", Font.BOLD, 25);
		lblTimKiemSach.setFont(font5);
		lblTimKiemSach.setForeground(new java.awt.Color(48, 51, 107));
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnThongTin.add(pnHienThiChiTiet,BorderLayout.WEST);
		
		JPanel pnTieuDe1 = new JPanel();
		pnTieuDe1.setLayout(new FlowLayout());
		JLabel lblTieuDe1 = new JLabel("THÔNG TIN CHI TIẾT");
		pnTieuDe1.add(lblTieuDe1);
		pnHienThiChiTiet.add(pnTieuDe1,BorderLayout.NORTH);
		Font font4 = new Font("SVN-Avo", Font.BOLD, 16);
		lblTieuDe1.setForeground(Color.WHITE);
		lblTieuDe1.setFont(font4);
		pnTieuDe1.setBackground(new java.awt.Color(255, 177, 66));
		
		JPanel pnMaPhieu = new JPanel();
		pnMaPhieu.setLayout(new FlowLayout());
		JLabel lblMaPhieu  = new JLabel("Mã Phiếu");
		pnMaPhieu.add(lblMaPhieu);
		pnHienThiChiTiet.add(pnMaPhieu);
		txtMaPhieu = new JTextField();
		txtMaPhieu.setPreferredSize(new Dimension(240,22));
		pnMaPhieu.add(txtMaPhieu);
		
		JPanel pnMaDG = new JPanel();
		pnMaDG.setLayout(new FlowLayout());
		JLabel lblMaDG  = new JLabel("Mã độc giả");
		pnMaDG.add(lblMaDG);
		pnHienThiChiTiet.add(pnMaDG);
		txtMaDG = new JTextField();
		txtMaDG.setPreferredSize(new Dimension(240,22));
		pnMaDG.add(txtMaDG);
		
		JPanel pnMaSach = new JPanel();
		pnMaSach.setLayout(new FlowLayout());
		JLabel lblMaSach  = new JLabel("Mã Sách");
		pnMaSach.add(lblMaSach);
		pnHienThiChiTiet.add(pnMaSach);
		txtMaSach = new JTextField();
		txtMaSach.setPreferredSize(new Dimension(240,22));
		pnMaSach.add(txtMaSach);
		
		JPanel pnNgayHenTra = new JPanel();
		pnNgayHenTra.setLayout(new FlowLayout());
		JLabel lblNgayHenTra  = new JLabel("Ngày hẹn trả");
		pnNgayHenTra.add(lblNgayHenTra);
		pnHienThiChiTiet.add(pnNgayHenTra);
		txtNgayHenTra = new JTextField();
		txtNgayHenTra.setPreferredSize(new Dimension(240,22));
		pnNgayHenTra.add(txtNgayHenTra);
		
		JPanel pnNgayTra = new JPanel();
		pnNgayTra.setLayout(new FlowLayout());
		JLabel lblNgayTra  = new JLabel("Ngày Trả");
		pnNgayTra.add(lblNgayTra);
		pnHienThiChiTiet.add(pnNgayTra);
		txtNgayTra = new JTextField();
		txtNgayTra.setPreferredSize(new Dimension(240,22));
		pnNgayTra.add(txtNgayTra);
		
		JPanel pnTTSachMuon = new JPanel();
		pnTTSachMuon.setLayout(new FlowLayout());
		JLabel lblTTSachMuon  = new JLabel("Tình trạng sách mượn");
		pnTTSachMuon.add(lblTTSachMuon);
		pnHienThiChiTiet.add(pnTTSachMuon);
		txtTTSachMuon = new JTextField();
		txtTTSachMuon.setPreferredSize(new Dimension(240,22));
		pnTTSachMuon.add(txtTTSachMuon);
		
		JPanel pnTTSachTra = new JPanel();
		pnTTSachTra.setLayout(new FlowLayout());
		JLabel lblTTSachTra  = new JLabel("Tình Trạng sách trả");
		pnTTSachTra.add(lblTTSachTra);
		pnHienThiChiTiet.add(pnTTSachTra);
		txtTTSachTra = new JTextField();
		txtTTSachTra.setPreferredSize(new Dimension(240,22));
		pnTTSachTra.add(txtTTSachTra);
		
		JPanel pnThuThu = new JPanel();
		pnThuThu.setLayout(new FlowLayout());
		JLabel lblThuThu  = new JLabel("Thủ thư");
		pnThuThu.add(lblThuThu);
		pnHienThiChiTiet.add(pnThuThu);
		txtThuThu = new JTextField();
		txtThuThu.setPreferredSize(new Dimension(240,22));
		pnThuThu.add(txtThuThu);
		
		JPanel pnGhiChu = new JPanel();
		pnGhiChu.setLayout(new FlowLayout());
		JLabel lblGhiChu  = new JLabel("Ghi chú");
		pnGhiChu.add(lblGhiChu);
		pnHienThiChiTiet.add(pnGhiChu);
		txtGhiChu = new JTextField();
		txtGhiChu.setPreferredSize(new Dimension(240,22));
		pnGhiChu.add(txtGhiChu);
		
		JPanel pnAN3 = new JPanel();
		pnAN3.setLayout(new FlowLayout());
		JLabel lblAN3= new JLabel();
		pnAN3.add(lblAN3);
		pnAN3.setBackground(new java.awt.Color(255, 255, 255));
		lblAN3.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/suy.png"));
		pnHienThiChiTiet.add(pnAN3);
		
		JPanel pnTraSach = new JPanel();
		pnTraSach.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnTraSach);
		btnTraSach = new JButton("TRẢ SÁCH");
		pnTraSach.add(btnTraSach);
		btnTraSach.setBackground(new java.awt.Color(255, 177, 66));
		pnTraSach.setBackground(new java.awt.Color(255, 255, 255));
		btnTraSach.setPreferredSize(new Dimension(180, 30));
		Font font8=new Font("SVN-Avo", Font.BOLD, 17); 
		btnTraSach.setFont(font8);
		btnTraSach.setForeground(Color.white);
		btnTraSach.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		JPanel pnBangThongKe = new JPanel();
		pnBangThongKe.setLayout(new BorderLayout());
		
		dtmPhieuMuon=new DefaultTableModel();
		dtmPhieuMuon.addColumn("Mã phiếu");
		dtmPhieuMuon.addColumn("Mã độc giả");
		dtmPhieuMuon.addColumn("Mã sách");
		dtmPhieuMuon.addColumn("Ngày hẹn trả");
		dtmPhieuMuon.addColumn("Ngày trả");
		dtmPhieuMuon.addColumn("TT Sách mượn");
		dtmPhieuMuon.addColumn("TT Sách trả");
		dtmPhieuMuon.addColumn("Thủ thư nhận sách");
		dtmPhieuMuon.addColumn("Ghi chú");
		tblPhieuMuon=new JTable(dtmPhieuMuon);
		JScrollPane sc=new JScrollPane(tblPhieuMuon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(400, 320));
		pnBangThongKe.add(sc, BorderLayout.CENTER);
		pnThongTin.add(pnBangThongKe, BorderLayout.CENTER);
		
		JPanel pnTieuDe2= new JPanel();
		JLabel lblTieuDe2= new JLabel("DANH MỤC PHIẾU TÌM KIẾM");
		pnTieuDe2.add(lblTieuDe2);
		pnBangThongKe.add(pnTieuDe2, BorderLayout.NORTH);
		lblTieuDe2.setFont(font4);
		pnTieuDe2.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe2.setForeground(Color.WHITE);
		
		new Font("SVN-Avo", Font.BOLD, 15); 
		lblMaDG.setFont(font4);
		lblMaPhieu.setFont(font4);
		lblMaSach.setFont(font4);
		lblNgayTra.setFont(font4);
		lblNgayHenTra.setFont(font4);
		lblTTSachTra.setFont(font4);
		lblTTSachMuon.setFont(font4);
		lblThuThu.setFont(font4); 
		lblGhiChu.setFont(font4); 
		
		lblMaDG.setPreferredSize(lblTTSachMuon.getPreferredSize());
		lblMaPhieu.setPreferredSize(lblTTSachMuon.getPreferredSize());
		lblMaSach.setPreferredSize(lblTTSachMuon.getPreferredSize());
		lblNgayHenTra.setPreferredSize(lblTTSachMuon.getPreferredSize());
		lblNgayTra.setPreferredSize(lblTTSachMuon.getPreferredSize());
		lblGhiChu.setPreferredSize(lblTTSachMuon.getPreferredSize());
		lblThuThu.setPreferredSize(lblTTSachMuon.getPreferredSize());
		lblTTSachTra.setPreferredSize(lblTTSachMuon.getPreferredSize());
		
		pnMaSach.setBackground(new java.awt.Color(255, 255, 255));
		pnMaDG.setBackground(new java.awt.Color(255, 255, 255));
		pnMaPhieu.setBackground(new java.awt.Color(255, 255, 255));
		pnNgayHenTra.setBackground(new java.awt.Color(255, 255, 255));
		pnNgayTra.setBackground(new java.awt.Color(255, 255, 255));
		pnGhiChu.setBackground(new java.awt.Color(255, 255, 255));
		pnTTSachMuon.setBackground(new java.awt.Color(255, 255, 255));
		pnThuThu.setBackground(new java.awt.Color(255, 255, 255));
		pnTTSachTra.setBackground(new java.awt.Color(255, 255, 255));	
		
		txtMaDG.setEditable(false);
		txtMaPhieu.setEditable(false);
		txtMaSach.setEditable(false);
		txtNgayHenTra.setEditable(false);
		txtNgayTra.setEditable(false);
		txtThuThu.setEditable(false);
		txtTTSachMuon.setEditable(false);
		txtTTSachTra.setEditable(false);
		txtGhiChu.setEditable(false);
		
		this.setSize(1300, 780);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnTimKiem.addActionListener(listener);
	}
	public void addListener1(MouseListener listener) {
		tblPhieuMuon.addMouseListener(listener);
	}
	public void addListener2(KeyListener listener) {
		txtTimKiem.addKeyListener(listener);
	}
	public void addListener3(MouseListener listener) {
		txtTimKiem.addMouseListener(listener);
	}
	public void addListener4(ActionListener listener) {
		btnTraSach.addActionListener(listener);
	}
	
	public JTextField getTxtTimKiem() {
		return txtTimKiem;
	}

	public void setTxtTimKiem(JTextField txtTimKiem) {
		this.txtTimKiem = txtTimKiem;
	}

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

	public JTextField getTxtThuThu() {
		return txtThuThu;
	}

	public void setTxtThuThu(JTextField txtThuThu) {
		this.txtThuThu = txtThuThu;
	}

	public JTextField getTxtGhiChu() {
		return txtGhiChu;
	}

	public void setTxtGhiChu(JTextField txtGhiChu) {
		this.txtGhiChu = txtGhiChu;
	}

	public DefaultTableModel getDtmPhieuMuon() {
		return dtmPhieuMuon;
	}

	public void setDtmPhieuMuon(DefaultTableModel dtmPhieuMuon) {
		this.dtmPhieuMuon = dtmPhieuMuon;
	}

	public JTable getTblPhieuMuon() {
		return tblPhieuMuon;
	}

	public void setTblPhieuMuon(JTable tblPhieuMuon) {
		this.tblPhieuMuon = tblPhieuMuon;
	}

	public DefaultTableModel getDtmPhieuTra() {
		return dtmPhieuTra;
	}

	public void setDtmPhieuTra(DefaultTableModel dtmPhieuTra) {
		this.dtmPhieuTra = dtmPhieuTra;
	}

	public DefaultTableModel getDtmPhieuChuaTra() {
		return dtmPhieuChuaTra;
	}

	public void setDtmPhieuChuaTra(DefaultTableModel dtmPhieuChuaTra) {
		this.dtmPhieuChuaTra = dtmPhieuChuaTra;
	}

	public JTable getTblPhieuTra() {
		return tblPhieuTra;
	}

	public void setTblPhieuTra(JTable tblPhieuTra) {
		this.tblPhieuTra = tblPhieuTra;
	}

	public JTable getTblPhieuChuaTra() {
		return tblPhieuChuaTra;
	}

	public void setTblPhieuChuaTra(JTable tblPhieuChuaTra) {
		this.tblPhieuChuaTra = tblPhieuChuaTra;
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
