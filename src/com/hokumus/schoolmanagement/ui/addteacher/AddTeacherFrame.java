package com.hokumus.schoolmanagement.ui.addteacher;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.hokumus.schoolmanagement.dao.management.CoursesDao;
import com.hokumus.schoolmanagement.dao.management.TeacherDao;
import com.hokumus.schoolmanagement.model.management.Courses;
import com.hokumus.schoolmanagement.model.teacher.Teacher;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextMeasurer;

public class AddTeacherFrame extends JFrame {
	private JTextField textName;
	private JTextField textSurname;
	private JTable tableTeacherList;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textRegisterdate;
	public String DateFormat = "dd MMM yyyy";
	private JTextField textSalary;
	private JTextPane textAdress;

	public AddTeacherFrame() {
		// String CourseStatus;
		initialize();
		 fillTeacherTableList();
	}

	private void initialize() {
		setTitle("Öðretmen Ekleme Ekraný");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel.setBounds(34, 26, 542, 278);
		getContentPane().add(panel);

		JLabel labelName = new JLabel("\u0130sim:");
		labelName.setFont(new Font("Arial", Font.BOLD, 13));
		labelName.setBounds(5, 5, 111, 18);
		panel.add(labelName);
		// Set Registration Date

		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 12));
		textName.setColumns(10);
		textName.setBounds(149, 5, 112, 19);
		panel.add(textName);

		JLabel labelSurname = new JLabel("Soyisim:");
		labelSurname.setFont(new Font("Arial", Font.BOLD, 13));
		labelSurname.setBounds(5, 35, 111, 18);
		panel.add(labelSurname);

		textSurname = new JTextField();
		textSurname.setFont(new Font("Arial", Font.PLAIN, 12));
		textSurname.setColumns(10);
		textSurname.setBounds(149, 35, 112, 19);
		panel.add(textSurname);

		JButton buttonAddTeacher = new JButton("Ekle");
		buttonAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherDao daoteacher = new TeacherDao();
				Teacher temp = new Teacher();
				temp.setName(textName.getText());
				temp.setSurname(textSurname.getText());
				temp.setPhone(textPhone.getText());
				temp.setEmail(textEmail.getText());
				
				 //System.out.println(DateTimeFormatter.ofPattern(DateFormat).format(localDate));
				
				SimpleDateFormat df = new SimpleDateFormat(DateFormat);
			     Date dateobj = new Date();
			     System.out.println(dateobj.toString());
			    temp.setMemberdate(dateobj);
				temp.setAdress(textAdress.getText());
				// System.out.println();
				// temp.setAdress();
				temp.setSalary(new BigDecimal(Float.parseFloat(textSalary.getText())));
				daoteacher.kaydet(temp);
				fillTeacherTableList();

			}
		});
		buttonAddTeacher.setFont(new Font("Arial", Font.BOLD, 13));
		buttonAddTeacher.setBounds(292, 5, 142, 32);
		panel.add(buttonAddTeacher);

		JButton button_1 = new JButton("G\u00FCncelle");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherDao daoteacher = new TeacherDao();
				Teacher temp = new Teacher();
				String id=(String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 0);
				temp.setId(Long.parseLong(id));
				temp.setName(textName.getText());
				temp.setSurname(textSurname.getText());
				temp.setPhone(textPhone.getText());
				temp.setEmail(textEmail.getText());
				
				 //System.out.println(DateTimeFormatter.ofPattern(DateFormat).format(localDate));
				
				 String temp2=(String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 4);
			     Date date1 = null;
				try {
					date1 = new SimpleDateFormat(DateFormat).parse(temp2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    temp.setMemberdate(date1);
				temp.setAdress(textAdress.getText());
				// System.out.println();
				// temp.setAdress();
				temp.setSalary(new BigDecimal(Float.parseFloat(textSalary.getText())));
				daoteacher.guncelle(temp);
				fillTeacherTableList();	
				
				
			}
		});
		button_1.setFont(new Font("Arial", Font.BOLD, 13));
		button_1.setBounds(292, 47, 142, 32);
		panel.add(button_1);

		JButton button_2 = new JButton("Sil");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherDao daoteacher=new TeacherDao();
				Teacher temp= new Teacher();
				String id=(String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 0);
				temp.setId(Long.parseLong(id));
				daoteacher.sil(temp);
				fillTeacherTableList();
				
				
			}
		});
		button_2.setFont(new Font("Arial", Font.BOLD, 13));
		button_2.setBounds(292, 89, 142, 32);
		panel.add(button_2);

		textPhone = new JTextField();
		textPhone.setFont(new Font("Arial", Font.PLAIN, 12));
		textPhone.setColumns(10);
		textPhone.setBounds(149, 63, 112, 19);
		panel.add(textPhone);

		JLabel labelTelefon = new JLabel("Telefon:");
		labelTelefon.setFont(new Font("Arial", Font.BOLD, 13));
		labelTelefon.setBounds(5, 63, 111, 18);
		panel.add(labelTelefon);

		JLabel labelEmail = new JLabel("e-mail:");
		labelEmail.setFont(new Font("Arial", Font.BOLD, 13));
		labelEmail.setBounds(5, 89, 111, 18);
		panel.add(labelEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(149, 89, 112, 19);
		panel.add(textEmail);

		JLabel labelRegisterdate = new JLabel("Kay\u0131t Tarihi:");
		labelRegisterdate.setFont(new Font("Arial", Font.BOLD, 13));
		labelRegisterdate.setBounds(5, 117, 111, 18);
		panel.add(labelRegisterdate);

		textRegisterdate = new JTextField();
		textRegisterdate.setEnabled(false);
		textRegisterdate.setFont(new Font("Arial", Font.PLAIN, 12));
		textRegisterdate.setColumns(10);
		textRegisterdate.setBounds(149, 118, 112, 19);
		panel.add(textRegisterdate);
		Format formatter = new SimpleDateFormat(DateFormat);
		java.util.Date Regdate = new java.util.Date();
		String strDate = formatter.format(Regdate);
		textRegisterdate.setText(strDate);
		JLabel labelAdress = new JLabel("Adres:");
		labelAdress.setFont(new Font("Arial", Font.BOLD, 13));
		labelAdress.setBounds(5, 181, 111, 18);
		panel.add(labelAdress);

		textAdress = new JTextPane();
		textAdress.setFont(new Font("Arial", Font.PLAIN, 12));
		textAdress.setBounds(149, 181, 117, 72);
		panel.add(textAdress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(34, 314, 542, 239);
		getContentPane().add(scrollPane);

		tableTeacherList = new JTable();
		tableTeacherList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textName.setText((String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 1));
				textSurname.setText((String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 2));
				textSalary.setText((String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 3));
				textRegisterdate.setText((String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 4));
				textPhone.setText((String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 5));
				textEmail.setText((String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 6));
				textAdress.setText((String) tableTeacherList.getModel().getValueAt(tableTeacherList.getSelectedRow(), 7));
				
			}
		});
		scrollPane.setViewportView(tableTeacherList);

		JLabel labelSalary = new JLabel("Maa\u015F:");
		labelSalary.setFont(new Font("Arial", Font.BOLD, 13));
		labelSalary.setBounds(5, 145, 111, 18);
		panel.add(labelSalary);

		textSalary = new JTextField();
		textSalary.setFont(new Font("Arial", Font.PLAIN, 12));
		textSalary.setColumns(10);
		textSalary.setBounds(149, 145, 112, 19);
		panel.add(textSalary);

		//

	}

	private void fillTeacherTableList() {
		TeacherDao dao = new TeacherDao();
		List<Teacher> liste = dao.getir(new Teacher());
		String[] columnNames = { "id", "Adý", "Soyadý", "Maaþ", "Kayýt Tarihi", "Telefon", "E-Mail" ,"Adress"};
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = liste.get(i).getId().toString();
			data[i][1] = liste.get(i).getName().toString();
			data[i][2] = liste.get(i).getSurname().toString();
			data[i][3] = liste.get(i).getSalary().toString();
			Format formatter = new SimpleDateFormat(DateFormat);
			String strDate = formatter.format(liste.get(i).getMemberdate());
			data[i][4] = strDate;
			data[i][5] = liste.get(i).getPhone().toString();
			data[i][6] = liste.get(i).getEmail().toString();
			data[i][7] = liste.get(i).getAdress().toString();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tableTeacherList.setModel(model);
	}

}
