package qltv.SuKien.Sach.TimKiem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

import qltv.dao.SachDao;
import qltv.entity.Sach;
import qltv.view.QuanLySachView;

public class TimKiemSachView extends JFrame {
	JButton btnTimKiem;
	JTextField txtTimKiem, txtMaSach, txtTenSach, txtTacGia, txtNhaXB, txtTheLoai, txtSoLuong, txtGia;
	DefaultTableModel dtmSach;
	JTable tblSach;
	JLabel lblMaSach,lblTenSach,lblTenTG,lblNhaXB,lblTheLoai,lblSoLuong,lblGia;
	ArrayList<Sach> sachs;
	private QuanLySachView quanLySachView;
//	public TimKiemSachView(QuanLySachView quanLySachView) {
//		this.quanLySachView = quanLySachView;
//	}
	
	public TimKiemSachView(String tieude)
	{
		this.setTitle(tieude);
		addControls();
	}
	
	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnTimKiemSach = new JPanel();
		pnTimKiemSach.setLayout(new BorderLayout());
		con.add(pnTimKiemSach);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ SÁCH");
		pnTieuDe.add(lblTieuDe);
		pnTimKiemSach.add(pnTieuDe, BorderLayout.NORTH);
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnTimKiemSach.add(pnLienHe, BorderLayout.SOUTH);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		Font font2= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(font2);
		
		JPanel pnHienThiTimKiemSach = new JPanel();
		pnHienThiTimKiemSach.setLayout(new BorderLayout());
		pnTimKiemSach.add(pnHienThiTimKiemSach, BorderLayout.CENTER);
		
		JPanel pnThanhTimKiem= new JPanel();
		pnThanhTimKiem.setLayout(new BorderLayout());
		
		
		JPanel pnTimKiem= new JPanel();
		pnTimKiem.setLayout(new FlowLayout());
		btnTimKiem= new JButton("TÌM KIẾM");
		pnTimKiem.add(btnTimKiem);
		pnThanhTimKiem.add(pnTimKiem, BorderLayout.EAST);
		btnTimKiem.setPreferredSize(new Dimension(130, 35));
		pnTimKiem.setBackground(new java.awt.Color(48, 51, 107));
		btnTimKiem.setBackground(new java.awt.Color(48, 51, 107));
		btnTimKiem.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		Font font7= new Font("SVN-Avo", Font.BOLD, 15);
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(font7);
		
		JPanel pnTextTimKiem =  new JPanel();
		pnTextTimKiem.setLayout(new BorderLayout());
		txtTimKiem = new JTextField("Nhập tên sách...");
		pnTextTimKiem.add(txtTimKiem);
		pnThanhTimKiem.add(pnTextTimKiem, BorderLayout.CENTER);
		txtTimKiem.setPreferredSize(new Dimension(100, 20));
		Font font6= new Font("SVN-Avo", Font.BOLD, 18);
		txtTimKiem.setFont(font6);
		txtTimKiem.setBorder(BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107)));
		
		JPanel pnIcon = new JPanel();
		pnIcon.setLayout(new FlowLayout());
		JLabel lblIcon= new JLabel();
		pnIcon.add(lblIcon);
		pnIcon.setBackground(new java.awt.Color(48, 51, 107));
		lblIcon.setIcon(new ImageIcon("Hinh/tim.png"));
		pnThanhTimKiem.add(pnIcon, BorderLayout.WEST);
		
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BorderLayout());
		pnHienThiTimKiemSach.add(pnThongTin, BorderLayout.CENTER); 

		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTimKiemSach= new JLabel("TÌM KIẾM SÁCH");
		pnTitle.add(lblTimKiemSach);
		pnHienThiTimKiemSach.add(pnTitle, BorderLayout.NORTH);
		Font font5= new Font("SVN-Avo", Font.BOLD, 25);
		lblTimKiemSach.setFont(font5);
		lblTimKiemSach.setForeground(new java.awt.Color(48, 51, 107));
		
		
		pnThongTin.add(pnThanhTimKiem, BorderLayout.NORTH);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnThongTin.add(pnHienThiChiTiet, BorderLayout.WEST);
		
		JPanel pnTieuDe1= new JPanel();
		pnTieuDe1.setLayout(new FlowLayout());
		JLabel lblTieuDe1= new JLabel("THÔNG TIN CHI TIẾT");
		pnTieuDe1.add(lblTieuDe1);
		pnHienThiChiTiet.add(pnTieuDe1, BorderLayout.NORTH);
		Font font4= new Font("SVN-Avo", Font.BOLD, 16);
		lblTieuDe1.setFont(font4);
		pnTieuDe1.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe1.setForeground(Color.WHITE);
		
		
		JPanel pnMaSach = new JPanel();
		pnMaSach.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnMaSach);
		JLabel lblMaSach= new JLabel("Mã sách: ");
		txtMaSach= new JTextField();
		txtMaSach.setPreferredSize(new Dimension(240, 22));
		pnMaSach.add(lblMaSach);
		pnMaSach.add(txtMaSach);

		
		JPanel pnTenSach = new JPanel();
		pnTenSach.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnTenSach);
		JLabel lblTenSach= new JLabel("Tên sách: ");
		txtTenSach= new JTextField();
		txtTenSach.setPreferredSize(new Dimension(240, 22));
		pnTenSach.add(lblTenSach);
		pnTenSach.add(txtTenSach);
		
		JPanel pnTacGia = new JPanel();
		pnTacGia.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnTacGia);
		JLabel lblTacGia = new JLabel("Tác giả: ");
		txtTacGia= new JTextField();
		txtTacGia.setPreferredSize(new Dimension(240, 22));
		pnTacGia.add(lblTacGia);
		pnTacGia.add(txtTacGia);
		
		JPanel pnNhaXB = new JPanel();
		pnNhaXB.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnNhaXB);
		JLabel lblNhaXB= new JLabel("Nhà xuất bản: ");
		txtNhaXB= new JTextField();
		txtNhaXB.setPreferredSize(new Dimension(240, 22));
		pnNhaXB.add(lblNhaXB);
		pnNhaXB.add(txtNhaXB);
		
		JPanel pnTheLoai = new JPanel();
		pnTheLoai.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnTheLoai);
		JLabel lblTheLoai= new JLabel("Thể loại: ");
		txtTheLoai= new JTextField();
		txtTheLoai.setPreferredSize(new Dimension(240, 22));
		pnTheLoai.add(lblTheLoai);
		pnTheLoai.add(txtTheLoai);
		
		JPanel pnSoLuong = new JPanel();
		pnSoLuong.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnSoLuong);
		JLabel lblSoLuong= new JLabel("Số lượng: ");
		txtSoLuong= new JTextField();
		txtSoLuong.setPreferredSize(new Dimension(240, 22));
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		
		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnGia);
		JLabel lblGia= new JLabel("Giá: ");
		txtGia = new JTextField();
		txtGia.setPreferredSize(new Dimension(240, 22));
		pnGia.add(lblGia);
		pnGia.add(txtGia);
		
		JPanel pnAN3 = new JPanel();
		pnAN3.setLayout(new FlowLayout());
		JLabel lblAN3= new JLabel();
		pnAN3.add(lblAN3);
		pnAN3.setBackground(new java.awt.Color(255, 255, 255));
		lblAN3.setIcon(new ImageIcon("Hinh/an3.png"));
		pnHienThiChiTiet.add(pnAN3);
		
		
		JPanel pnBangThongKe = new JPanel();
		pnBangThongKe.setLayout(new BorderLayout());
		
		dtmSach=new DefaultTableModel();
		dtmSach.addColumn("Mã sách");
		dtmSach.addColumn("Tên sách");
		dtmSach.addColumn("Tác giả");
		dtmSach.addColumn("Nhà xuất bản");
		dtmSach.addColumn("Thể loại");
		dtmSach.addColumn("Số lượng");
		dtmSach.addColumn("Giá");
		tblSach=new JTable(dtmSach);
		JScrollPane sc=new JScrollPane(tblSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(400, 320));
		pnBangThongKe.add(sc, BorderLayout.CENTER);
		pnThongTin.add(pnBangThongKe, BorderLayout.CENTER);
		
		JPanel pnTieuDe2= new JPanel();
		JLabel lblTieuDe2= new JLabel("DANH MỤC SÁCH TÌM KIẾM");
		pnTieuDe2.add(lblTieuDe2);
		pnBangThongKe.add(pnTieuDe2, BorderLayout.NORTH);
		lblTieuDe2.setFont(font4);
		pnTieuDe2.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe2.setForeground(Color.WHITE);
		
		
		Font font3=new Font("SVN-Avo", Font.BOLD, 15); 
		lblTenSach.setFont(font3);
		lblMaSach.setFont(font3);
		lblTacGia.setFont(font3);
		lblNhaXB.setFont(font3);
		lblSoLuong.setFont(font3);
		lblTheLoai.setFont(font3);
		lblGia.setFont(font3);

		lblMaSach.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTenSach.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTacGia.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTheLoai.setPreferredSize(lblNhaXB.getPreferredSize());
		lblSoLuong.setPreferredSize(lblNhaXB.getPreferredSize());
		lblGia.setPreferredSize(lblNhaXB.getPreferredSize());
		
		pnMaSach.setBackground(new java.awt.Color(255, 255, 255));
		pnTenSach.setBackground(new java.awt.Color(255, 255, 255));
		pnTacGia.setBackground(new java.awt.Color(255, 255, 255));
		pnTheLoai.setBackground(new java.awt.Color(255, 255, 255));
		pnNhaXB.setBackground(new java.awt.Color(255, 255, 255));
		pnSoLuong.setBackground(new java.awt.Color(255, 255, 255));
		pnGia.setBackground(new java.awt.Color(255, 255, 255));		
		
		txtMaSach.setEditable(false);
		txtTenSach.setEditable(false);
		txtGia.setEditable(false);
		txtSoLuong.setEditable(false);
		txtNhaXB.setEditable(false);
		txtTheLoai.setEditable(false);
		txtTacGia.setEditable(false);
		
		this.setSize(1200, 710);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnTimKiem.addActionListener(listener);
	}
	public void addListener1(MouseListener listener) {
		tblSach.addMouseListener(listener);
	}
	public void addListener3(KeyListener listener) {
		txtTimKiem.addKeyListener(listener);
	}
	public void addListener4(MouseListener listener) {
		txtTimKiem.addMouseListener(listener);
	}
	
	public JTextField getTxtMaSach() {
		return txtMaSach;
	}
	public void setTxtMaSach(JTextField txtMaSach) {
		this.txtMaSach = txtMaSach;
	}
	public JTextField getTxtTenSach() {
		return txtTenSach;
	}
	public void setTxtTenSach(JTextField txtTenSach) {
		this.txtTenSach = txtTenSach;
	}
	public JTextField getTxtTenTG() {
		return txtTacGia;
	}
	public void setTxtTenTG(JTextField txtTenTG) {
		this.txtTacGia = txtTenTG;
	}
	public JTextField getTxtNhaXB() {
		return txtNhaXB;
	}
	public void setTxtNhaXB(JTextField txtNhaXB) {
		this.txtNhaXB = txtNhaXB;
	}
	public JTextField getTxtTheLoai() {
		return txtTheLoai;
	}
	public void setTxtTheLoai(JTextField txtTheLoai) {
		this.txtTheLoai = txtTheLoai;
	}
	public JTextField getTxtSoLuong() {
		return txtSoLuong;
	}
	public void setTxtSoLuong(JTextField txtSoLuong) {
		this.txtSoLuong = txtSoLuong;
	}
	public JTextField getTxtGia() {
		return txtGia;
	}
	public void setTxtGia(JTextField txtGia) {
		this.txtGia = txtGia;
	}
	public JTextField getTxtTimKiem() {
		return txtTimKiem;
	}
	public void setTxtTimKiem(JTextField txtGia) {
		this.txtTimKiem = txtGia;
	}
	
	public DefaultTableModel getdtmSach() {
		return dtmSach;
	}
	public void setdtmSach(DefaultTableModel dtmSach) {
		this.dtmSach = dtmSach;
	}
	public JTable gettblSach() {
		return tblSach;
	}
	public void settblSach(JTable tblSach) {
		this.tblSach = tblSach;
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public void loadTen() {
		SachDao sachDao = new SachDao();
		sachs = sachDao.timKiemSachTheoTenSach(txtTimKiem.getText());
		DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
		model.setRowCount(0);
		for(Sach s:sachs) {
			Object[] row = new Object[]{
                    s.getMaSach(),s.getTenSach(),s.getTenTG(),s.getNhaXB(),s.getTheLoai(),s.getSoLuong(),s.getGiaTien()
                };
		model.addRow(row);
		}
	}
}
