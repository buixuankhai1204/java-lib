package qltv.SuKien.NguoiDung.Xoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import qltv.dao.DocGiaDao;
import qltv.dao.TaiKhoanDao;
import qltv.entity.TaiKhoan;
import qltv.view.QuanLyNguoiDungView;

public class XoaView extends JFrame{
	JTextField txtTaiKhoan, txtHoTen, txtSDT, txtCMND, txtPhanQuyen;
	ArrayList<TaiKhoan> taiKhoans;
	QuanLyNguoiDungView quanLyNguoiDungView;
	public JTextField getTxtTaiKhoan() {
		return txtTaiKhoan;
	}
	public void setTxtTaiKhoan(JTextField txtTaiKhoan) {
		this.txtTaiKhoan = txtTaiKhoan;
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
	public JTextField getTxtCMND() {
		return txtCMND;
	}
	public void setTxtCMND(JTextField txtCMND) {
		this.txtCMND = txtCMND;
	}
	public JTextField getTxtPhanQuyen() {
		return txtPhanQuyen;
	}
	public void setTxtPhanQuyen(JTextField txtPhanQuyen) {
		this.txtPhanQuyen = txtPhanQuyen;
	}
	public JPasswordField getPwdMatKhau() {
		return pwdMatKhau;
	}
	public void setPwdMatKhau(JPasswordField pwdMatKhau) {
		this.pwdMatKhau = pwdMatKhau;
	}
	JPasswordField pwdMatKhau;
	JButton btnXoa;
	public String machon="";
	Connection connect = qltv.dao.ConnectMySQL.connect;
	
	public XoaView(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		if(machon.length() != 0)
		{
			hienThi();
		}
	}
	
	public void hienThi() 
	{
		TaiKhoanDao tksv=new TaiKhoanDao();
		ArrayList<TaiKhoan> dstk= new ArrayList<TaiKhoan>();
		dstk=tksv.layTaiKhoanTheoUser(machon);
		for(TaiKhoan tk: dstk)
		{
			txtTaiKhoan.setText(tk.getUser());
			txtCMND.setText(tk.getCMND());
			txtHoTen.setText(tk.getTenND());
			int phanquyen = tk.getPhanQuyen();
			if(phanquyen == 1 )
			{
				txtPhanQuyen.setText("Admin");
			}
			else
				txtPhanQuyen.setText("Thủ thư");
			txtSDT.setText(tk.getSoDienThoai());
			pwdMatKhau.setText(tk.getPass());
		}
		
	}
	
	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnXoaNguoiDung= new JPanel();
		pnXoaNguoiDung.setLayout(new BorderLayout());
		con.add(pnXoaNguoiDung);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ NGƯỜI DÙNG");
		pnTieuDe.add(lblTieuDe);
		pnXoaNguoiDung.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnXoaNguoiDung.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiNguoiDung = new JPanel();
		pnHienThiNguoiDung.setLayout(new BorderLayout());
		pnXoaNguoiDung.add(pnHienThiNguoiDung, BorderLayout.CENTER);
		
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/xoand.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiNguoiDung.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiNguoiDung.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblXoaNguoiDung= new JLabel("XÓA NGƯỜI DÙNG");
		pnTitle.add(lblXoaNguoiDung);
		
		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		JLabel lblTaiKhoan = new JLabel("Tài khoản: ");
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setPreferredSize(new Dimension(340, 30));
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		
		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setLayout(new FlowLayout());
		JLabel lblMatKhau = new JLabel("Mật khẩu: ");
		pwdMatKhau = new JPasswordField();
		pwdMatKhau.setEchoChar((char)0);
		pwdMatKhau.setPreferredSize(new Dimension(340, 30));
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(pwdMatKhau);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		JLabel lblHoTen = new JLabel("Họ và tên: ");
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
		
		JPanel pnCMND= new JPanel();
		pnCMND.setLayout(new FlowLayout());
		JLabel lblCMND = new JLabel("Số CMND: ");
		txtCMND = new JTextField();
		txtCMND.setPreferredSize(new Dimension(340, 30));
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		
		JPanel pnPhanQuyen=new JPanel();
		pnPhanQuyen.setLayout(new FlowLayout());
		JLabel lblPhanQuyen = new JLabel("Phân quyền: ");
		txtPhanQuyen = new JTextField();
		txtPhanQuyen.setPreferredSize(new Dimension(340, 30));
		pnPhanQuyen.add(lblPhanQuyen);
		pnPhanQuyen.add(txtPhanQuyen);
		
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnTaiKhoan);
		pnHienThiChiTiet.add(pnMatKhau);
		pnHienThiChiTiet.add(pnHoTen);
		pnHienThiChiTiet.add(pnSoDienThoai);
		pnHienThiChiTiet.add(pnCMND);
		pnHienThiChiTiet.add(pnPhanQuyen);
		
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblXoaNguoiDung.setFont(font2);
		lblTaiKhoan.setFont(font4);
		lblSoDienThoai.setFont(font4);
		lblCMND.setFont(font4);
		lblHoTen.setFont(font4);
		lblMatKhau.setFont(font4);
		lblLienHe.setFont(font4);
		lblPhanQuyen.setFont(font4);
		
		txtTaiKhoan.setFont(font4);
		txtCMND.setFont(font4);
		txtHoTen.setFont(font4);
		txtSDT.setFont(font4);
		pwdMatKhau.setFont(font4);
		txtPhanQuyen.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblXoaNguoiDung.setForeground(new java.awt.Color(48, 51, 107));
		pnTaiKhoan.setBackground(new java.awt.Color(241, 242, 246));
		pnCMND.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhau.setBackground(new java.awt.Color(241, 242, 246));
		pnPhanQuyen.setBackground(new java.awt.Color(241, 242, 246));
		pnSoDienThoai.setBackground(new java.awt.Color(241, 242, 246));
		pnHoTen.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnXoa= new JButton("XÓA");
		btnXoa.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnXoa);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnXoa.setFont(font5);
		
		btnXoa.setBackground(new java.awt.Color(255, 177, 66));
		btnXoa.setForeground(Color.white);
		btnXoa.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiNguoiDung.setBorder(titleLogin);
		
		lblTaiKhoan.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblMatKhau.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblHoTen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblCMND.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblPhanQuyen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		
		txtCMND.setEditable(false);
		txtSDT.setEditable(false);
		txtHoTen.setEditable(false);
		txtTaiKhoan.setEditable(false);
		pwdMatKhau.setEditable(false);
		txtPhanQuyen.setEditable(false);
		
		this.setSize(900, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	}
	
	public void delete() {
		TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
		int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
		if(tk == JOptionPane.YES_OPTION) {
			if(taiKhoanDao.delete(txtTaiKhoan.getText())) {
				JOptionPane.showMessageDialog(this, "Xóa Sách thành công", "Thông Báo", 1);
			}
			else {
	            JOptionPane.showMessageDialog(this, "Lỗi hệ thống", "Thông Báo", 0);
	        }
		}
		else {
			return;
		}
	}
	
	public void clear(){	
        txtTaiKhoan.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        pwdMatKhau.setText("");
        txtCMND.setText("");
        setStatus(true);
    }
	public void setStatus(boolean insertable){
	    txtTaiKhoan.setEditable(insertable);
//	    btnThem.setEnabled(insertable);
//	    btnSua.setEnabled(!insertable);
	    btnXoa.setEnabled(!insertable);
	    }
	
	public void load() {
    	TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
    	taiKhoans = taiKhoanDao.layTaiKhoan();
    	DefaultTableModel model = (DefaultTableModel) quanLyNguoiDungView.gettblNguoiDung().getModel();
    	model.setRowCount(0);
    	for(TaiKhoan s: taiKhoans) {
    		Object[] row = new Object[] {
    				s.getUser(),s.getPass(),s.getSoDienThoai(),s.getCMND(),s.getTenND()
    		};
    		model.addRow(row);
    	}
    }
	
	public void addListener(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}
	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub	
	}
}
