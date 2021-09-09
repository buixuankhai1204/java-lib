package qltv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import qltv.entity.ChiTietPhieuMuon;
import qltv.entity.Sach;
import qltv.SuKien.Sach.TimKiem.TimKiemSachView;
import qltv.dao.ConnectMySQL;
import qltv.dao.SachDao;

public class QuanLySachView extends JFrame {
	JTextField txtMaSach, txtTenSach, txtTacGia, txtNhaXB, txtTheLoai, txtSoLuong, txtGia;
	JButton btnThem, btnXoa, btnSua, btnQuayLai, btnTimKiem;
	DefaultTableModel dtmSach;
	public JTable tblSach;
	ArrayList<ChiTietPhieuMuon> dssach;
	Connection conn=ConnectMySQL.connect;
	ArrayList<Sach> sachs;
	
	DefaultListModel<String> defaultListTheLoai;
	JList<String> listTheLoai;
	private TimKiemSachView timKiemSachView;
	
	public QuanLySachView(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		hienThiSach();
	}
	
	public void hienThiSach() 
	{
		try {
			String sql = "select * from sach";
			PreparedStatement pre= conn.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while (result.next()) 
			{
				String ma = result.getString(1);
				String ten = result.getString(2);
				String tg = result.getString(3);
				String nxb = result.getString(4);
				String tl = result.getString(5);
				String sl = String.valueOf(result.getInt(6));
				String gia = String.valueOf(result.getInt(7));
				
				Vector<Object> vec = new Vector<>();
				vec.add(ma);
				vec.add(ten);
				vec.add(tg);
				vec.add(nxb);
				vec.add(tl);
				vec.add(sl);
				vec.add(gia);
				
				dtmSach.addRow(vec);
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	private void addControls() 
	{
		Container con= getContentPane();
		
		JPanel pnSach = new JPanel();
		pnSach.setLayout(new BorderLayout());
		con.add(pnSach);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN L�? S�?CH");
		pnTieuDe.add(lblTieuDe);
		pnSach.add(pnTieuDe, BorderLayout.NORTH);
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnSach.add(pnLienHe, BorderLayout.SOUTH);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(fontx);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BorderLayout());
		pnSach.add(pnThongTin, BorderLayout.CENTER);
		
		JPanel pnChiTietSach = new JPanel();
		pnChiTietSach.setLayout(new BorderLayout());
		pnThongTin.add(pnChiTietSach, BorderLayout.CENTER);
		
		JPanel pnTongHopTheLoai= new JPanel();
		pnTongHopTheLoai.setLayout(new BorderLayout());
		pnThongTin.add(pnTongHopTheLoai, BorderLayout.WEST);
		pnTongHopTheLoai.setPreferredSize(new Dimension(300,0));
		
		JPanel pnTieuDeTheLoai= new JPanel();
		JLabel lblTieuDeTheLoai= new JLabel("THỂ LOẠI");
		pnTieuDeTheLoai.add(lblTieuDeTheLoai);
		pnTongHopTheLoai.add(pnTieuDeTheLoai, BorderLayout.NORTH);
		Font font2=new Font("SVN-Avo", Font.BOLD, 18); 
		lblTieuDeTheLoai.setFont(font2);
		pnTieuDeTheLoai.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDeTheLoai.setForeground(Color.WHITE);
		
		defaultListTheLoai = new DefaultListModel<String>();
		try
		{
			String sql="select theloai from sach group by theloai";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next())
			{
				defaultListTheLoai.addElement(rs.getString(1));
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		listTheLoai = new JList<String>(defaultListTheLoai);
		listTheLoai.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTheLoai.setSelectedIndex(0);
		listTheLoai.setVisibleRowCount(6);
		listTheLoai.setBackground(new java.awt.Color(241, 242, 246));
		pnTongHopTheLoai.add(listTheLoai, BorderLayout.CENTER);
		
		
		JPanel pnTieuDe1= new JPanel();
		JLabel lblTieuDe1= new JLabel("THÔNG TIN CHI TIẾT");
		pnTieuDe1.add(lblTieuDe1);
		pnChiTietSach.add(pnTieuDe1, BorderLayout.NORTH);
		lblTieuDe1.setFont(font2);
		pnTieuDe1.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe1.setForeground(Color.WHITE);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnChiTietSach.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
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
		
		JPanel pnTimKiem= new JPanel();
		pnTimKiem.setLayout(new FlowLayout());
		btnTimKiem= new JButton();
		btnTimKiem.setBackground(new java.awt.Color(255, 177, 66));
		pnTimKiem.add(btnTimKiem);
		pnTimKiem.setBackground(new java.awt.Color(255, 177, 66));
		
		pnChucNang.add(pnThem);
		pnChucNang.add(pnXoa);
		pnChucNang.add(pnSua);
		pnChucNang.add(pnTimKiem);
		
		pnThaoTac.add(pnChucNang, BorderLayout.CENTER);
		
		/* Border borderHienThi= BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66));
		TitledBorder titleBorderHienThi= new TitledBorder(borderHienThi);
		titleBorderHienThi.setTitleJustification(TitledBorder.LEFT);
		pnHienThiChiTiet.setBorder(titleBorderHienThi); */
		
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
		
		JPanel pnTieuDe2= new JPanel();
		JLabel lblTieuDe2= new JLabel("DANH S�?CH S�?CH");
		pnTieuDe2.add(lblTieuDe2);
		pnBangThongKe.add(pnTieuDe2, BorderLayout.NORTH);
		lblTieuDe2.setFont(font2);
		pnTieuDe2.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe2.setForeground(Color.WHITE);
		
		btnQuayLai.setPreferredSize(new Dimension(220,30));
		btnThem.setPreferredSize(new Dimension(210, 60));
		btnXoa.setPreferredSize(btnThem.getPreferredSize());
		btnTimKiem.setPreferredSize(btnThem.getPreferredSize());
		btnSua.setPreferredSize(btnThem.getPreferredSize());
		
		pnThongTin.add(pnChiTietSach, BorderLayout.CENTER);
		pnThongTin.add(pnThaoTac, BorderLayout.EAST);
		pnThaoTac.setPreferredSize(new Dimension(250, 0));
		pnThongTin.add(pnBangThongKe, BorderLayout.SOUTH);
		
		
		Font font3=new Font("SVN-Avo", Font.BOLD, 15); 
		lblTenSach.setFont(font3);
		lblMaSach.setFont(font3);
		lblTacGia.setFont(font3);
		lblNhaXB.setFont(font3);
		lblSoLuong.setFont(font3);
		lblTheLoai.setFont(font3);
		lblGia.setFont(font3);
		listTheLoai.setFont(font4);
		
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
		
		btnThem.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/themmoi.png"));
		btnXoa.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/xoa.png"));
		btnSua.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/sua.png"));
		btnTimKiem.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/timkiem.png"));
		btnQuayLai.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnThem.setBorder(null);
		btnXoa.setBorder(null);
		btnSua.setBorder(null);
		btnTimKiem.setBorder(null);
		
		this.setSize(1130,775);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
	}
	
	public DefaultTableModel getDtmSach() {
		return dtmSach;
	}
	public void setDtmSach(DefaultTableModel dtmSach) {
		this.dtmSach = dtmSach;
	}
	public DefaultListModel<String> getdefaultListTheLoai() {
		return defaultListTheLoai;
	}
	public void setdefaultListTheLoai(DefaultListModel<String> defaultListTheLoai) {
		this.defaultListTheLoai = defaultListTheLoai;
	}
	public JTable getTblSach() {
		return tblSach;
	}
	public void setTblSach(JTable tblSach) {
		this.tblSach = tblSach;
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
	public JTextField getTxtTacGia() {
		return txtTacGia;
	}
	public void setTxtTacGia(JTextField txtTacGia) {
		this.txtTacGia = txtTacGia;
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
	public void setTblSach(JTextField txtGia) {
		this.txtGia = txtGia;
	}
	
	public void addListener(ActionListener listener) {
		btnQuayLai.addActionListener(listener);
	}
	public void addListener1(MouseListener listener) {
		listTheLoai.addMouseListener(listener);
	}
	public void addListener2(MouseListener listener) {
		tblSach.addMouseListener(listener);
	}
	public void addListener3(ActionListener listener) {
		btnThem.addActionListener(listener);
	}
	public void addListener4(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}
	public void addListener5(ActionListener listener) {
		btnTimKiem.addActionListener(listener);
	}
	public void addListener6(ActionListener listener) {
		btnSua.addActionListener(listener);
	}
	
	public void loadTen() {
		SachDao sachDao = new SachDao();
		sachs = sachDao.timKiemSachTheoTenSach(timKiemSachView.getTxtTimKiem().getText());
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
