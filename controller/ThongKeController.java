package qltv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyDocGiaView;
import qltv.view.QuanLyPhieuMuonView;
import qltv.view.QuanLyPhieuTraView;
import qltv.view.QuanLySachView;
import qltv.view.ThongKeView;
import qltv.dao.ConnectMySQL;

public class ThongKeController {
	public String tenTk="";
	public int thongke=1;
	private ThongKeView thongKeView;
	
	public ThongKeController(ThongKeView thongKeView) {
		this.thongKeView = thongKeView;
		thongKeView.addListener(new Back());
		thongKeView.addListener1(new ThongKeSach());
		thongKeView.addListener2(new ThongKePT());
		thongKeView.addListener3(new ThongKePM());
		thongKeView.addListener4(new ThongKeDG());
		thongKeView.addListener5(new ThongKeCTS());
		thongKeView.addListener6(new ThongKeCTPT());
		thongKeView.addListener7(new ThongKeCTPM());
		thongKeView.addListener8(new ThongKeCTDG());
	}
	
	public void showThongKeView() {
		thongKeView.setMoDal(true);
		thongKeView.setVisible(true);
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			QuanLyAdminView qladv = new QuanLyAdminView("Trang Chủ Phần Mềm Quản Lý Thư Viện");
			QuanLyAdminController qladc = new QuanLyAdminController(qladv);
			qladc.tentk = tenTk;
			qladc.showQuanlyAdminView();
			thongKeView.dispose();	
		}
	}
	class ThongKeSach implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
			       String report="SachReport.jrxml";
			       JasperReport jr=JasperCompileManager.compileReport(report);
			       JasperPrint jp=JasperFillManager.fillReport(jr, null,ConnectMySQL.connect);
			       new JasperViewer( jp, false );	
			       JasperViewer.viewReport(jp,false);				}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	}
	class ThongKePT implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
			       String report="PhieuTraReport.jrxml";
			       JasperReport jr=JasperCompileManager.compileReport(report);
			       JasperPrint jp=JasperFillManager.fillReport(jr, null,ConnectMySQL.connect);
			       new JasperViewer( jp, false );	
			       JasperViewer.viewReport(jp,false);				}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	}
	class ThongKePM implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
			       String report="PhieuMuonReport.jrxml";
			       JasperReport jr=JasperCompileManager.compileReport(report);
			       JasperPrint jp=JasperFillManager.fillReport(jr, null,ConnectMySQL.connect);
			       new JasperViewer( jp, false );	
			       JasperViewer.viewReport(jp,false);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	}
	class ThongKeDG implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)  {
			// TODO Auto-generated method stub
			try {
			       String report="DocGiaReport.jrxml";
			       JasperReport jr=JasperCompileManager.compileReport(report);
			       JasperPrint jp=JasperFillManager.fillReport(jr, null,ConnectMySQL.connect);
			       new JasperViewer( jp, false );	
			       JasperViewer.viewReport(jp,false);				}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
		} 
	}
	class ThongKeCTS implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			QuanLySachView qlsv = new QuanLySachView(null);
			QuanLySachController qlsc = new QuanLySachController(qlsv);
			qlsc.thongke = thongke;
			qlsc.showQuanLySachView();
			qlsc.tentk = tenTk;
			thongKeView.dispose();
		}
	}
	class ThongKeCTPM implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			QuanLyPhieuMuonView qlndv = new QuanLyPhieuMuonView("Quản lý phiếu mượn");
			QuanLyPhieuMuonController qlndc = new QuanLyPhieuMuonController(qlndv);
			qlndc.tentk = tenTk;
			qlndc.thongke = thongke;
			qlndc.showQuanLyPhieuMuonView();
			thongKeView.dispose();
		}
	}
	class ThongKeCTPT implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{
			QuanLyPhieuTraView qlndv = new QuanLyPhieuTraView("Quản lý phiếu mượn");
			QuanLyPhieuTraController qlndc = new QuanLyPhieuTraController(qlndv);
			qlndc.tentk = tenTk;
			qlndc.thongke = thongke;
			qlndc.showQuanLyPhieuTraView();
			thongKeView.dispose();
	 	}
	}
	class ThongKeCTDG implements ActionListener{
		public void actionPerformed(ActionEvent e) 
	 	{			
	 		QuanLyDocGiaView qldgv = new QuanLyDocGiaView("Quản lý độc giả");
	 		QuanLyDocGiaController qldgc = new QuanLyDocGiaController(qldgv);
	 		qldgc.tentk = tenTk;
	 		qldgc.thongke = thongke;
	 		qldgc.showQuanLyDocGiaView();
	 		thongKeView.dispose();
	 	}
	}
}
