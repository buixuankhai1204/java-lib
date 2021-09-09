package qltv.SuKien.Sach.Them;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.pdf.PdfPublicKeyRecipient;

import oracle.net.aso.s;
import qltv.dao.SachDao;
import qltv.entity.Sach;
import qltv.view.QuanLySachView;

public class ThemSachView extends JFrame {
	JTextField txtMaSach, txtTenSach, txtTenTG, txtNhaXB, txtTheLoai, txtSoLuong, txtGia;
	JButton btnThem;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	JLabel lblMaSach,lblTenSach,lblTenTG,lblNhaXB,lblTheLoai,lblSoLuong,lblGia;
	ArrayList<Sach> sachs;
	JTable tblSachJTable;
	private QuanLySachView quanLySachView;
	public ThemSachView(QuanLySachView quanLySachView) {
		this.quanLySachView = quanLySachView;
	}
	
	public ThemSachView(String title) {
		this.setTitle(title);
		addControls();
	}
	
	public int DemSach()
	{
		int SoLuongSach=0;
		SachDao sv=new SachDao();
		ArrayList<Sach> ds= sv.layToanBoSach();
		for(Sach s:ds)
		{
			SoLuongSach++;
		}
		return SoLuongSach;
	}
	private void addControls() 
	{
		int kqs=DemSach() + 1;
		Container con = getContentPane();
		
		JPanel pnThemSach = new JPanel();
		pnThemSach.setLayout(new BorderLayout());
		con.add(pnThemSach);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ SÁCH");
		pnTieuDe.add(lblTieuDe);
		pnThemSach.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemSach.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiThemSach = new JPanel();
		pnHienThiThemSach.setLayout(new BorderLayout());
		pnThemSach.add(pnHienThiThemSach, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/book.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiThemSach.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiThemSach.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblThemSach= new JLabel("THÊM SÁCH");
		pnTitle.add(lblThemSach);
		
		JPanel pnMaSach = new JPanel();
		pnMaSach.setLayout(new FlowLayout());
		JLabel lblMaSach = new JLabel("Mã sách: ");
		txtMaSach= new JTextField("MS"+kqs);
		txtMaSach.setPreferredSize(new Dimension(340, 30));
		pnMaSach.add(lblMaSach);
		pnMaSach.add(txtMaSach);
		txtMaSach.setEditable(false);
		
		JPanel pnTenSach = new JPanel();
		pnTenSach.setLayout(new FlowLayout());
		JLabel lblTenSach = new JLabel("Tên sách: ");
		txtTenSach = new JTextField();
		txtTenSach.setPreferredSize(new Dimension(340, 30));
		pnTenSach.add(lblTenSach);
		pnTenSach.add(txtTenSach);
		
		JPanel pnTenTG = new JPanel();
		pnTenTG.setLayout(new FlowLayout());
		JLabel lblTenTG = new JLabel("Tên tác giả: ");
		txtTenTG = new JTextField();
		txtTenTG.setPreferredSize(new Dimension(340, 30));
		pnTenTG.add(lblTenTG);
		pnTenTG.add(txtTenTG);
		
		JPanel pnNhaXB= new JPanel();
		pnNhaXB.setLayout(new FlowLayout());
		JLabel lblNhaXB = new JLabel("Nhà xuất bản: ");
		txtNhaXB = new JTextField();
		txtNhaXB.setPreferredSize(new Dimension(340, 30));
		pnNhaXB.add(lblNhaXB);
		pnNhaXB.add(txtNhaXB);
		
		JPanel pnTheLoai = new JPanel();
		pnTheLoai.setLayout(new FlowLayout());
		JLabel lblTheLoai = new JLabel("Thể loại: ");
		txtTheLoai = new JTextField();
		txtTheLoai.setPreferredSize(new Dimension(340, 30));
		pnTheLoai.add(lblTheLoai);
		pnTheLoai.add(txtTheLoai);
		
		JPanel pnSoLuong= new JPanel();
		pnSoLuong.setLayout(new FlowLayout());
		JLabel lblSoLuong = new JLabel("Số lượng: ");
		txtSoLuong = new JTextField();
		txtSoLuong.setPreferredSize(new Dimension(340, 30));
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		
		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout());
		JLabel lblGia = new JLabel("Giá tiền: ");
		txtGia = new JTextField();
		txtGia.setPreferredSize(new Dimension(340, 30));
		pnGia.add(lblGia);
		pnGia.add(txtGia);
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnMaSach);
		pnHienThiChiTiet.add(pnTenSach);
		pnHienThiChiTiet.add(pnTenTG);
		pnHienThiChiTiet.add(pnNhaXB);
		pnHienThiChiTiet.add(pnTheLoai);
		pnHienThiChiTiet.add(pnSoLuong);
		pnHienThiChiTiet.add(pnGia);
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblThemSach.setFont(font2);
		lblGia.setFont(font4);
		lblMaSach.setFont(font4);
		lblTenSach.setFont(font4);
		lblTenTG.setFont(font4);
		lblNhaXB.setFont(font4);
		lblSoLuong.setFont(font4);
		lblTheLoai.setFont(font4);
		lblLienHe.setFont(font4);
		
		txtMaSach.setFont(font4);
		txtTenSach.setFont(font4);
		txtTenTG.setFont(font4);
		txtNhaXB.setFont(font4);
		txtSoLuong.setFont(font4);
		txtTheLoai.setFont(font4);
		txtGia.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblThemSach.setForeground(new java.awt.Color(48, 51, 107));
		pnMaSach.setBackground(new java.awt.Color(241, 242, 246));
		pnTenSach.setBackground(new java.awt.Color(241, 242, 246));
		pnTenTG.setBackground(new java.awt.Color(241, 242, 246));
		pnNhaXB.setBackground(new java.awt.Color(241, 242, 246));
		pnSoLuong.setBackground(new java.awt.Color(241, 242, 246));
		pnTheLoai.setBackground(new java.awt.Color(241, 242, 246));
		pnGia.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));		
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnThem= new JButton("THÊM");
		btnThem.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnThem);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnThem.setFont(font5);
		
		btnThem.setBackground(new java.awt.Color(255, 177, 66));
		btnThem.setForeground(Color.white);
		btnThem.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiThemSach.setBorder(titleLogin);
		
		lblMaSach.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTenSach.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTenTG.setPreferredSize(lblNhaXB.getPreferredSize());
		lblSoLuong.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTheLoai.setPreferredSize(lblNhaXB.getPreferredSize());
		lblGia.setPreferredSize(lblNhaXB.getPreferredSize());
		
		this.setSize(900, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
//		this.setModal(true);
//		this.setVisible(true);
		
	}
	
	public void insert() {
		Sach sach = new Sach();
		sach.setMaSach(txtMaSach.getText());
		sach.setTenSach(txtTenSach.getText());
		sach.setTenTG(txtTenTG.getText());
		sach.setNhaXB(txtNhaXB.getText());
		sach.setTheLoai(txtTheLoai.getText());
		sach.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
		sach.setGiaTien(Double.parseDouble(txtGia.getText()));
		SachDao sachDao = new SachDao();
		if(sachDao.insert(sach) > 0) {
			JOptionPane.showMessageDialog(null, "Thêm Sách thành công");
		}
		else{
            JOptionPane.showMessageDialog(null, "Mã Sách [ "+txtMaSach.getText()+" ] đã tồn tại không thể thêm");
        } 
	}
	
	 public boolean valiform() {
	        if (txtMaSach.getText().equals("")) {
	            txtMaSach.requestFocus();
	            lblMaSach.setText("Chưa nhập Mã Sách");
	            return false;
	        }else if (txtTenSach.getText().equals("")) {
	            txtTenSach.requestFocus();
	            lblTenSach.setText("Chưa nhập Tên Sách");
	            return false;
	        }else if (txtNhaXB.getText().equals("")) {
	            txtNhaXB.requestFocus();
	            lblNhaXB.setText("Chưa nhập NXB");
	            return false;
	        }else if (txtTenTG.getText().equals("")) {
	            txtTenTG.requestFocus();
	            lblTenTG.setText("Chưa nhập Tác Giả");
	            return false;
	        }else if (txtSoLuong.getText().equals("")) {
	            txtSoLuong.requestFocus();
	            lblSoLuong.setText("Chưa nhập Số lượng");
	            return false;
	        }else if (!(txtSoLuong.getText().matches("\\d{1,3}"))) {
	            txtSoLuong.requestFocus();
	            lblSoLuong.setText("Số lượng phải là số, lớn hơn 0");
	            return false;
	        }else if ((!(Integer.parseInt(txtSoLuong.getText())> 0))) {
	            txtSoLuong.requestFocus();
	            lblSoLuong.setText("Số lượng phải lớn hơn 0");
	            return false;
	        }else if (txtGia.getText().equals("")) {
	        	txtGia.requestFocus();
	            return false;
	        }else 
	        return true;
	    };
	
	    public void load() {
	    	SachDao sachDao = new SachDao();
	    	sachs = sachDao.layToanBoSach();
	    	DefaultTableModel model = (DefaultTableModel) tblSachJTable.getModel();
	    	model.setRowCount(0);
	    	for(Sach s: sachs) {
	    		Object[] row = new Object[] {
	    				s.getMaSach(),s.getTenSach(),s.getTenTG(),s.getNhaXB(),s.getTheLoai(),s.getSoLuong(),s.getGiaTien()
	    		};
	    		model.addRow(row);
	    	}
	    }
	    
	public void addListener(ActionListener listener) {
		btnThem.addActionListener(listener);
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
		return txtTenTG;
	}
	public void setTxtTenTG(JTextField txtTenTG) {
		this.txtTenTG = txtTenTG;
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

	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
