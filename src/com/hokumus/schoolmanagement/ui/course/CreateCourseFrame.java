package com.hokumus.schoolmanagement.ui.course;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hokumus.schoolmanagement.alldaos.CoursesDao;
import com.hokumus.schoolmanagement.model.management.Courses;
import com.hokumus.schoolmanagement.utils.Util;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateCourseFrame extends JFrame {
	protected static String CourseStatus = null;
	private JTextField textCourseName;
	private JTextField textTotalPrice;
	private JTable tableCourseList;
	public String DateFormat="dd MMM yyyy";
	
	public CreateCourseFrame( ) {
	//String CourseStatus;
		initialize();
		fillCourseTableList();
	}

	private void initialize() {
		
		getContentPane().setLayout(null);

		JPanel panelCreateCourse = new JPanel();
		panelCreateCourse.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelCreateCourse.setBounds(34, 40, 542, 141);
		getContentPane().add(panelCreateCourse);
		panelCreateCourse.setLayout(null);

		JLabel labelCourseName = new JLabel("Kurs \u0130smi:");
		labelCourseName.setFont(new Font("Arial", Font.BOLD, 13));
		labelCourseName.setBounds(5, 5, 111, 18);
		panelCreateCourse.add(labelCourseName);

		textCourseName = new JTextField();
		textCourseName.setBounds(149, 5, 112, 19);
		panelCreateCourse.add(textCourseName);
		textCourseName.setColumns(10);

		JLabel lblBalangTarihi = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi:");
		lblBalangTarihi.setFont(new Font("Arial", Font.BOLD, 13));
		lblBalangTarihi.setBounds(5, 33, 111, 18);
		panelCreateCourse.add(lblBalangTarihi);

		JLabel lblToplamFiyay = new JLabel("Toplam Fiyat:");
		lblToplamFiyay.setFont(new Font("Arial", Font.BOLD, 13));
		lblToplamFiyay.setBounds(5, 65, 111, 18);
		panelCreateCourse.add(lblToplamFiyay);

		textTotalPrice = new JTextField();
		textTotalPrice.setColumns(10);
		textTotalPrice.setBounds(149, 65, 112, 19);
		panelCreateCourse.add(textTotalPrice);

		JLabel lblDurum = new JLabel("Durum:");
		lblDurum.setFont(new Font("Arial", Font.BOLD, 13));
		lblDurum.setBounds(5, 102, 111, 18);
		panelCreateCourse.add(lblDurum);

		JToggleButton tglbtnStatus = new JToggleButton("Aktif");
		tglbtnStatus.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
			         CourseStatus = "Aktif";
			      } else if(e.getStateChange()==ItemEvent.DESELECTED){
			    	 CourseStatus = "Kapalý";
			     }
				
			}
		});
		tglbtnStatus.setFont(new Font("Arial", Font.BOLD, 13));
		tglbtnStatus.setSelected(true);
		tglbtnStatus.setBounds(146, 101, 115, 21);
		panelCreateCourse.add(tglbtnStatus);

		JDateChooser dateStartedDate = new JDateChooser();
		dateStartedDate.setBounds(149, 34, 112, 19);
		panelCreateCourse.add(dateStartedDate);

		JButton buttonAddCourse = new JButton("Ekle");
		buttonAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursesDao daocourse=new CoursesDao();
				Courses temp= new Courses();
				//String id=(String) tableCourseList.getModel().getValueAt(tableCourseList.getSelectedRow(), 0);
				//temp.setId(Long.parseLong(id));
				temp.setName(textCourseName.getText());
				temp.setStarteddate(dateStartedDate.getDate());
				temp.setTotalprice(new BigDecimal(Float.parseFloat(textTotalPrice.getText())));
				temp.setStatus(CourseStatus);
				//temp.setCreatedBy(createdBy);
				//temp.setCreatedBy(Util.loginedUser.getUsername());
				//temp.setCreatedDate(new Date());
				daocourse.kaydet(temp);
				fillCourseTableList();
			
			}
		});
		buttonAddCourse.setFont(new Font("Arial", Font.BOLD, 13));
		buttonAddCourse.setBounds(292, 5, 142, 32);
		panelCreateCourse.add(buttonAddCourse);

		JButton buttonUpdate = new JButton("G\u00FCncelle");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursesDao daocourse=new CoursesDao();
				Courses temp= new Courses();
				String id=(String) tableCourseList.getModel().getValueAt(tableCourseList.getSelectedRow(), 0);
				temp.setId(Long.parseLong(id));
				temp.setName(textCourseName.getText());
				temp.setStarteddate(dateStartedDate.getDate());
				temp.setTotalprice(new BigDecimal(Float.parseFloat(textTotalPrice.getText())));
				temp.setStatus(CourseStatus);
				//temp.getUpdatedBy()
				daocourse.guncelle(temp);
				fillCourseTableList();
				
			}
		});
		buttonUpdate.setFont(new Font("Arial", Font.BOLD, 13));
		buttonUpdate.setBounds(292, 47, 142, 32);
		panelCreateCourse.add(buttonUpdate);

		JButton buttonRemove = new JButton("Sil");
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursesDao daocourse=new CoursesDao();
				Courses temp= new Courses();
				String id=(String) tableCourseList.getModel().getValueAt(tableCourseList.getSelectedRow(), 0);
				temp.setId(Long.parseLong(id));
				daocourse.sil(temp);
				fillCourseTableList();
				
			}
		});
		buttonRemove.setFont(new Font("Arial", Font.BOLD, 13));
		buttonRemove.setBounds(292, 89, 142, 32);
		panelCreateCourse.add(buttonRemove);
		
		JScrollPane scrollPaneCourseList = new JScrollPane();
		scrollPaneCourseList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		scrollPaneCourseList.setBounds(34, 214, 552, 325);
		getContentPane().add(scrollPaneCourseList);
		
		tableCourseList = new JTable();
		tableCourseList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Date1=(String) tableCourseList.getModel().getValueAt(tableCourseList.getSelectedRow(), 2);
				System.out.println(Date1);				
				try {
					System.out.println(Date1);
					Date Date2=new SimpleDateFormat(DateFormat).parse(Date1);
					System.out.println(Date2);
					dateStartedDate.setDate(Date2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
	
				textCourseName.setText((String) tableCourseList.getModel().getValueAt(tableCourseList.getSelectedRow(), 1));		
				textTotalPrice.setText((String) tableCourseList.getModel().getValueAt(tableCourseList.getSelectedRow(), 3));
				String S1=(String) tableCourseList.getModel().getValueAt(tableCourseList.getSelectedRow(), 4);
				if (S1.equals(new String("Aktif"))) {
					tglbtnStatus.setSelected(true);
				}
				else {
					tglbtnStatus.setSelected(false);
				}	
				
				
				
				//tglbtnStatus.setText((String) );
				
				
			}
		});
		scrollPaneCourseList.setViewportView(tableCourseList);
		setTitle("Kurs Ekleme Ekraný");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void fillCourseTableList() {
		CoursesDao dao = new CoursesDao();
		List<Courses> liste = dao.getir(new Courses());
		String[] columnNames = {"id", "Adý","Baþlama Tarihi", "Toplam Fiyat", "Durum"};
		String [][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = liste.get(i).getId().toString();
			data[i][1] = liste.get(i).getName().toString();
			
			Format formatter = new SimpleDateFormat(DateFormat);
			String s = formatter.format(liste.get(i).getStarteddate());
			data[i][2] = s ;
			data[i][3] = liste.get(i).getTotalprice().toString();
			data[i][4] = liste.get(i).getStatus();
			
		}
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		tableCourseList.setModel(model);
	}
}
