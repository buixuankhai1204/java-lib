package qltv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import java.security.PublicKey;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oracle.net.aso.l;
import qltv.dao.ChiTietPhieuMuonDao;
import qltv.dao.DocGiaDao;
import qltv.dao.PhieuMuonDao;
import qltv.dao.SachDao;
import qltv.entity.ChiTietPhieuMuon;
import qltv.entity.DocGia;
import qltv.entity.PhieuMuon;
import qltv.entity.Sach;


public class ThongKeView extends JFrame{
	JButton btnQLDG, btnQLPM, btnQLPT, btnQLS, btnQuayLai, btnChiTietSach, btnChiTietDG, btnChiTietPM, btnChiTietPT;
	DefaultTableModel dtmPM;
	JTable tbPM;
	
	public ThongKeView(String title)
	{
		super(title);
		addControls();
		hienThi();
	}
	
	public void hienThi() {
		// TODO Auto-generated method stubad
		
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
	public int DemPhieuMuon()
	{
		int SoLuongPM=0;
		PhieuMuonDao pmsv=new PhieuMuonDao();
		ArrayList<PhieuMuon> ds=pmsv.layThongTinPhieuMuon();
		for(PhieuMuon pm: ds)
		{
			SoLuongPM++;
		}
		return SoLuongPM;
	}
	public int DemPhieuPhieuTra(){
		int SoLuongPT=0;
		ChiTietPhieuMuonDao ctsv=new ChiTietPhieuMuonDao();
		ArrayList<ChiTietPhieuMuon> ds=ctsv.layChiTietPhieuMuon();
		for(ChiTietPhieuMuon ctpm :ds)
		{
			if(ctpm.getNgayTra() != null )
			{
				SoLuongPT++;
			}
		}
		
		return SoLuongPT;
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
	public void addControls()
	{
	Container con= getContentPane();
		
		JPanel pnTrangChu = new JPanel();
		pnTrangChu.setLayout(new BorderLayout());
		con.add(pnTrangChu);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("TH�?NG KÊ");
		pnTieuDe.add(lblTieuDe);
		pnTrangChu.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnTrangChu.add(pnLienHe, BorderLayout.SOUTH);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(fontx);
		
		
		JPanel pnQuanLy = new JPanel();
		pnQuanLy.setLayout(new BoxLayout(pnQuanLy, BoxLayout.Y_AXIS));
		
		JPanel pnHang1= new JPanel();
		pnHang1.setLayout(new FlowLayout());
		pnHang1.setBackground(Color.WHITE);
		
		int kqs=DemSach();
		int kqpm=DemPhieuMuon();
		int kqpt=DemPhieuPhieuTra();
		int kqdg=DemDocGia();
		
		JPanel pnChiTietSach = new JPanel();
		pnChiTietSach.setLayout(new BorderLayout());
		btnChiTietSach = new JButton("Chi tiết");
		pnChiTietSach.add(btnChiTietSach, BorderLayout.EAST);
		pnChiTietSach.setBackground(new java.awt.Color(51, 217, 178));
		
		JPanel pnThongKeSach = new JPanel();
		pnThongKeSach.setLayout(new BoxLayout(pnThongKeSach, BoxLayout.Y_AXIS));
		btnQLS = new JButton();
		JLabel lblTKSach= new JLabel("Có "+kqs+" đầu sách");
		pnThongKeSach.add(btnQLS);
		pnThongKeSach.add(lblTKSach);
		pnThongKeSach.add(pnChiTietSach);
		
		JPanel pnChiTietDocGia= new JPanel();
		pnChiTietDocGia.setLayout(new BorderLayout());
		btnChiTietDG = new JButton("Chi tiết");
		pnChiTietDocGia.add(btnChiTietDG, BorderLayout.EAST);
		pnChiTietDocGia.setBackground(new java.awt.Color(204, 142, 53));
		
		JPanel pnThongKeDocGia = new JPanel();
		pnThongKeDocGia.setLayout(new BoxLayout(pnThongKeDocGia, BoxLayout.Y_AXIS));
		btnQLDG = new JButton();
		JLabel lblTKDocGia= new JLabel("Có "+kqdg+" độc giả");
		pnThongKeDocGia.add(btnQLDG);
		pnThongKeDocGia.add(lblTKDocGia);
		pnThongKeDocGia.add(pnChiTietDocGia);
		
		JPanel pnHang2= new JPanel();
		pnHang2.setLayout(new FlowLayout());
		pnHang2.setBackground(Color.WHITE);

		
		JPanel pnChiTietPhieuMuon= new JPanel();
		pnChiTietPhieuMuon.setLayout(new BorderLayout());
		btnChiTietPM = new JButton("Chi tiết");
		pnChiTietPhieuMuon.add(btnChiTietPM, BorderLayout.EAST);
		pnChiTietPhieuMuon.setBackground(new java.awt.Color(37, 204, 247));
		
		JPanel pnThongKePhieuMuon = new JPanel();
		pnThongKePhieuMuon.setLayout(new BoxLayout(pnThongKePhieuMuon, BoxLayout.Y_AXIS));
		btnQLPM = new JButton();
		JLabel lblTKPM= new JLabel("Có "+kqpm+" phiếu mượn");
		pnThongKePhieuMuon.add(btnQLPM);
		pnThongKePhieuMuon.add(lblTKPM);
		pnThongKePhieuMuon.add(pnChiTietPhieuMuon);
		
		JPanel pnChiTietPhieuTra= new JPanel();
		pnChiTietPhieuTra.setLayout(new BorderLayout());
		btnChiTietPT = new JButton("Chi tiết");
		pnChiTietPhieuTra.add(btnChiTietPT, BorderLayout.EAST);
		pnChiTietPhieuTra.setBackground(new java.awt.Color(237, 76, 103));
		
		JPanel pnThongKePhieuTra = new JPanel();
		pnThongKePhieuTra.setLayout(new BoxLayout(pnThongKePhieuTra, BoxLayout.Y_AXIS));
		btnQLPT = new JButton();
		JLabel lblTKPT= new JLabel("Có "+kqpt+" phiếu trả");
		pnThongKePhieuTra.add(btnQLPT);
		pnThongKePhieuTra.add(lblTKPT);
		pnThongKePhieuTra.add(pnChiTietPhieuTra);
		
		
		btnQLS.setPreferredSize(new Dimension(270,150));
		btnQLPM.setPreferredSize(btnQLS.getPreferredSize());
		btnQLDG.setPreferredSize(btnQLS.getPreferredSize());
		btnQLPT.setPreferredSize(btnQLS.getPreferredSize());
		
		pnThongKeSach.setBackground(new java.awt.Color(51, 217, 178));
		pnThongKePhieuMuon.setBackground(new java.awt.Color(37, 204, 247));
		pnThongKePhieuTra.setBackground(new java.awt.Color(237, 76, 103));
		pnThongKeDocGia.setBackground(new java.awt.Color(204, 142, 53));
		
		btnQLS.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/tksach.png"));
		btnQLPM.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/tkphieumuon.png"));
		btnQLDG.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/tkdocgia.png"));
		btnQLPT.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/tkphieutra.png"));
		
		btnQLS.setBackground(new java.awt.Color(51, 217, 178));
		btnQLPM.setBackground(new java.awt.Color(37, 204, 247));
		btnQLPT.setBackground(new java.awt.Color(237, 76, 103));
		btnQLDG.setBackground(new java.awt.Color(204, 142, 53));
		
		pnHang1.add(pnThongKeSach);
		pnHang1.add(pnThongKeDocGia);
		pnHang2.add(pnThongKePhieuMuon);
		pnHang2.add(pnThongKePhieuTra);
		
		pnQuanLy.add(pnHang1);
		pnQuanLy.add(pnHang2);
		
		pnTrangChu.add(pnQuanLy, BorderLayout.EAST);		
		 
	
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("C:/Users/Admin/eclipse-workspace/QuanLyThuVien/src/quanlythuvien/Hinh/tkgd.png"));
		pnHinhAnh.add(lblHinhAnh);
		
		JPanel pnQuayLai = new JPanel();
		pnQuayLai.setLayout(new FlowLayout());
		btnQuayLai = new JButton("QUAY LẠI TRANG CHỦ");
		pnQuayLai.add(btnQuayLai);
		btnQuayLai.setPreferredSize(new Dimension(300,40));
		pnQuayLai.setBackground(Color.WHITE);
		btnQuayLai.setBackground(new java.awt.Color(255, 177, 66));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		btnChiTietSach.setBackground(new java.awt.Color(51, 217, 178));
		btnChiTietPM.setBackground(new java.awt.Color(37, 204, 247));
		btnChiTietPT.setBackground(new java.awt.Color(237, 76, 103));
		btnChiTietDG.setBackground(new java.awt.Color(204, 142, 53));
		
		btnChiTietSach.setForeground(Color.WHITE);
		btnChiTietPM.setForeground(Color.WHITE);
		btnChiTietPT.setForeground(Color.WHITE);
		btnChiTietDG.setForeground(Color.WHITE);
	
		Font font3=new Font("SVN-Avo", Font.BOLD, 19); 
		lblTKSach.setFont(font3);
		lblTKPM.setFont(font3);
		lblTKPT.setFont(font3);
		lblTKDocGia.setFont(font3);
		lblTKSach.setForeground(Color.WHITE);
		lblTKDocGia.setForeground(Color.WHITE);
		lblTKPM.setForeground(Color.WHITE);
		lblTKPT.setForeground(Color.WHITE);
		
		Font font2= new Font("SVN-Avo", Font.BOLD, 18);
		btnQuayLai.setFont(font2);
		
		Font font4= new Font("SVN-Avo", Font.CENTER_BASELINE, 18);
		btnChiTietDG.setFont(font4);
		btnChiTietSach.setFont(font4);
		btnChiTietPM.setFont(font4);
		btnChiTietPT.setFont(font4);
		
		pnChucNang.add(pnHinhAnh);
		pnChucNang.add(pnQuayLai);
		
		pnTrangChu.add(pnChucNang, BorderLayout.WEST);
		
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		btnQLDG.setBorder(null);
		btnQLPM.setBorder(null);
		btnQLPT.setBorder(null);
		btnQLS.setBorder(null);
		
		btnChiTietDG.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnChiTietPM.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnChiTietPT.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnChiTietSach.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		btnChiTietSach.setPreferredSize(new Dimension(120,38));
		btnChiTietDG.setPreferredSize(new Dimension(120,38));
		btnChiTietPT.setPreferredSize(new Dimension(120,38));
		btnChiTietPM.setPreferredSize(new Dimension(120,38));
		
		this.setSize(1025,580);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);		
	}
	
	public void addListener(ActionListener listener) {
		btnQuayLai.addActionListener(listener);
	}
	public void addListener1(ActionListener listener) {
		btnQLS.addActionListener(listener);
	}
	public void addListener2(ActionListener listener) {
		btnQLPT.addActionListener(listener);
	}
	public void addListener3(ActionListener listener) {
		btnQLPM.addActionListener(listener);
	}
	public void addListener4(ActionListener listener) {
		btnQLDG.addActionListener(listener);
	}
	public void addListener5(ActionListener listener) {
		btnChiTietSach.addActionListener(listener);
	}
	public void addListener6(ActionListener listener) {
		btnChiTietPT.addActionListener(listener);
	}
	public void addListener7(ActionListener listener) {
		btnChiTietPM.addActionListener(listener);
	}
	public void addListener8(ActionListener listener) {
		btnChiTietDG.addActionListener(listener);
	}
	public DefaultTableModel getdtmPM() {
		return dtmPM;
	}
	public void setdtmPM(DefaultTableModel dtmPM) {
		this.dtmPM = dtmPM;
	}
	public JTable gettblPM() {
		return tbPM;
	}
	public void settblPM(JTable tbPM) {
		this.tbPM = tbPM;
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
