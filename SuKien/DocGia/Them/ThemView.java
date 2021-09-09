package qltv.SuKien.DocGia.Them;

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

import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import qltv.dao.DocGiaDao;
import qltv.entity.DocGia;
import qltv.view.QuanLyDocGiaView;

public class ThemView extends JFrame{
	private static final String String = null;
	JTextField txtMaDocGia, txtHoTen, txtSDT, txtDiaChi, txtGioiTinh;
	JLabel lblMaDG,lblHoTen,lblSoDienThoai,lblDiaChi,lblGioiTinh;
	ArrayList<DocGia> docGias;
	QuanLyDocGiaView quanLyDocGiaView;
	public JTextField getTxtMaDocGia() {
		return txtMaDocGia;
	}
	public void setTxtMaDocGia(JTextField txtMaDocGia) {
		this.txtMaDocGia = txtMaDocGia;
	}
	public JTextField getTxtHoTen() {
		return txtHoTen;
	}
	public void setTxtHoTen(JTextField txtHoTen) {
		this.txtHoTen = txtHoTen;
	}
	public JTextField getTxtSDT() {
		return txtSDT;
	}
	public void setTxtSDT(JTextField txtSDT) {
		this.txtSDT = txtSDT;
	}
	public JTextField getTxtDiaChi() {
		return txtDiaChi;
	}
	public void setTxtDiaChi(JTextField txtDiaChi) {
		this.txtDiaChi = txtDiaChi;
	}
	public JTextField getTxtGioiTinh() {
		return txtGioiTinh;
	}
	public void setTxtGioiTinh(JTextField txtGioiTinh) {
		this.txtGioiTinh = txtGioiTinh;
	}
	public JRadioButton getRadNam() {
		return radNam;
	}
	public void setRadNam(JRadioButton radNam) {
		this.radNam = radNam;
	}
	public JRadioButton getRadNu() {
		return radNu;
	}
	public void setRadNu(JRadioButton radNu) {
		this.radNu = radNu;
	}

	JRadioButton radNam, radNu;
	JButton btnThem;
	JComboBox<String> cb;
	public JComboBox<String> getCb() {
		return cb;
	}
	public void setCb(JComboBox<String> cb) {
		this.cb = cb;
	}

	Connection connect = qltv.dao.ConnectMySQL.connect;
	public String tentk="";
	
	public ThemView(String tieude)
	{
		this.setTitle(tieude);
		addControls();
	}
	public int DemDocGia()
	{
		int SoLuongDG=0;
		DocGiaDao dgsv=new DocGiaDao();
		ArrayList<DocGia> ds=dgsv.layToanBoDocGia();
		for(DocGia dg:ds)
		{
			SoLuongDG++;
		}
		return SoLuongDG;
	} 
	
	private void addControls() 
	{
		int kqdg=DemDocGia()+1;
		Container con = getContentPane();
		
		JPanel pnThemDocGia = new JPanel();
		pnThemDocGia.setLayout(new BorderLayout());
		con.add(pnThemDocGia);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ ĐỘC GIẢ");
		pnTieuDe.add(lblTieuDe);
		pnThemDocGia.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemDocGia.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiThemDocGia = new JPanel();
		pnHienThiThemDocGia.setLayout(new BorderLayout());
		pnThemDocGia.add(pnHienThiThemDocGia, BorderLayout.CENTER);
		
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/themnd.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiThemDocGia.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiThemDocGia.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblThemDocGia= new JLabel("THÊM ĐỘC GIẢ");
		pnTitle.add(lblThemDocGia);
		
		JPanel pnMaDG = new JPanel();
		pnMaDG.setLayout(new FlowLayout());
		JLabel lblMaDG = new JLabel("Mã độc giả: ");
		txtMaDocGia = new JTextField("DG"+kqdg);
		txtMaDocGia.setPreferredSize(new Dimension(340, 30));
		pnMaDG.add(lblMaDG);
		pnMaDG.add(txtMaDocGia);
		txtMaDocGia.setEditable(false);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		JLabel lblHoTen = new JLabel("Tên độc giả: ");
		txtHoTen = new JTextField();
		txtHoTen.setPreferredSize(new Dimension(340, 30));
		pnHoTen.add(lblHoTen);
		pnHoTen.add(txtHoTen);
		
		JPanel pnSoDienThoai= new JPanel();
		pnSoDienThoai.setLayout(new FlowLayout());
		JLabel lblSoDienThoai = new JLabel("Số điện thoại: ");
		txtSDT = new JTextField();
		txtSDT.setPreferredSize(new Dimension(340, 30));
		pnSoDienThoai.add(lblSoDienThoai);
		pnSoDienThoai.add(txtSDT);
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		txtDiaChi = new JTextField();
		txtDiaChi.setPreferredSize(new Dimension(340, 30));
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		
		JPanel pnGioiTinh= new JPanel();
		pnGioiTinh.setLayout(new FlowLayout());
		JLabel lblGioiTinh = new JLabel("Giới tính: ");
		txtGioiTinh = new JTextField();
		txtGioiTinh.setPreferredSize(new Dimension(340, 30));
		cb = new JComboBox<String>();
		cb.addItem("Nam");
		cb.addItem("Nữ");
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(cb);
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnMaDG);
		pnHienThiChiTiet.add(pnHoTen);
		pnHienThiChiTiet.add(pnSoDienThoai);
		pnHienThiChiTiet.add(pnDiaChi);
		pnHienThiChiTiet.add(pnGioiTinh);
		
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblThemDocGia.setFont(font2);
		lblMaDG.setFont(font4);
		lblSoDienThoai.setFont(font4);
		lblDiaChi.setFont(font4);
		lblHoTen.setFont(font4);
		lblGioiTinh.setFont(font4);
		lblLienHe.setFont(font4);
		txtMaDocGia.setFont(font4);
		txtDiaChi.setFont(font4);
		txtHoTen.setFont(font4);
		txtSDT.setFont(font4);
		txtGioiTinh.setFont(font4);
		cb.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblThemDocGia.setForeground(new java.awt.Color(48, 51, 107));
		pnMaDG.setBackground(new java.awt.Color(241, 242, 246));
		pnDiaChi.setBackground(new java.awt.Color(241, 242, 246));
		pnGioiTinh.setBackground(new java.awt.Color(241, 242, 246));
		pnSoDienThoai.setBackground(new java.awt.Color(241, 242, 246));
		pnHoTen.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		cb.setBackground(new java.awt.Color(241, 242, 246));
		cb.setForeground(Color.BLACK);
		
		
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
		//btnLuu.setBackground(new java.awt.Color(5, 196, 107));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiThemDocGia.setBorder(titleLogin);
		
		lblMaDG.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblHoTen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSoDienThoai.getPreferredSize());
		cb.setPreferredSize(txtDiaChi.getPreferredSize());
		
		this.setSize(900, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnThem.addActionListener(listener);
	}
	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public void insert() {
		int flag = 1;
		try {

			String sql = "select * from docgia where madg=?";
			PreparedStatement pre = connect.prepareStatement(sql);
			pre.setString(1, txtMaDocGia.getText());
			ResultSet rs = pre.executeQuery();

			if (rs.next()) 
			{
				flag = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "Mã đọc giả trùng");
			//dispose();
			return;
		}

		if (txtMaDocGia.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã đọc giả không được để trống");
			//dispose();
			return;
		}
		DocGia dGia = new DocGia();
		dGia.setMaDG(txtMaDocGia.getText());
		dGia.setTenDG(txtHoTen.getText());
		dGia.setSoDienThoai(txtSDT.getText());
		dGia.setDiaChi(txtDiaChi.getText());
		dGia.setGioiTinh(txtGioiTinh.getText());
		DocGiaDao dao = new DocGiaDao();
		if(dao.insert(dGia) > 0) {
			JOptionPane.showMessageDialog(null, "Thêm Sinh Viên thành công");
		}
	}
	
	 public boolean valiform() {
	        if (txtMaDocGia.getText().equals("")) {
	            txtMaDocGia.requestFocus();
	            lblMaDG.setText("Chưa nhập Mã Độc Giả");
	            return false;
	        }else if (txtHoTen.getText().equals("")) {
	            txtHoTen.requestFocus();
	            lblHoTen.setText("Chưa nhập Tên");
	            return false;
	        }else if (!(txtSDT.getText()).matches("\\w{3,50}")) {
	            txtSDT.requestFocus();
	            lblSoDienThoai.setText("Mật khẩu ít nhất 3 kí tự");
	            return false;
	        }else if (txtDiaChi.getText().equals("")) {
	            txtDiaChi.requestFocus();
	            lblDiaChi.setText("Chưa nhập Địa chỉ");
	            return false;
	        }else if (txtSDT.getText().equals("")) {
	            txtSDT.setText("Chưa nhập SĐT");
	            lblSoDienThoai.requestFocus();     
	            return false;

	        }else 
	        return true;
	    };
	    
	    public void load(){
	        DocGiaDao svdao = new DocGiaDao();
	        docGias = svdao.layToanBoDocGia();
	        DefaultTableModel model = (DefaultTableModel) quanLyDocGiaView.getTblDocGia().getModel();
	        model.setRowCount(0);
	        for(DocGia sv:docGias){
	            Object[] row = new Object[5];
	                row[0] = sv.getMaDG();
	                row[1] = sv.getTenDG();
	                row[2] = sv.getSoDienThoai();
	                if(sv.isGioiTinh() == true){
	                    row[4] = "Nam";
	                }else if(sv.isGioiTinh() == false){
	                    row[4] = "Nữ";
	                }
	            model.addRow(row);
	        }      
	    }
}
