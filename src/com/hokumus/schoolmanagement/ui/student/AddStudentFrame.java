package com.hokumus.schoolmanagement.ui.student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.hokumus.schoolmanagement.alldaos.StudentDao;
import com.hokumus.schoolmanagement.model.student.GenderEnums;
import com.hokumus.schoolmanagement.model.student.Student;
import com.hokumus.schoolmanagement.model.teacher.Teacher;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddStudentFrame extends JFrame {
	private JPanel panel;
	private JLabel labelName;
	private JTextField textName;
	private JLabel labelSurname;
	private JTextField textSurname;
	private JButton buttonAdd;
	private JButton buttonUpdate;
	private JButton buttonDelete;
	private JTextField textPhone;
	private JLabel labelPhone;
	private JLabel labelEmail;
	private JTextField textEmail;
	private JLabel labelRegisterdate;
	private JTextField textRegister;
	private JLabel labelAdress;
	private JTextPane textAdress;
	private JLabel LabelCinsiyet;
	private JScrollPane scrollPane;
	private JRadioButton radiobuttonMale;
	private JRadioButton radiobuttonFemale;
	public String DateFormat = "dd MMM yyyy";
	private JTable tableStudentList;

	public AddStudentFrame() {
		// String CourseStatus;
		initialize();
		// fillTeacherTableList();
	}

	private void initialize() {
		setTitle("Öðrenci Ekleme Ekraný");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getScrollPane());
		fillStudentTableList();
		
		
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
			panel.setBounds(25, 23, 542, 278);
			panel.add(getLabelName());
			panel.add(getTextName());
			panel.add(getLabelSurname());
			panel.add(getTextSurname());
			panel.add(getButtonAdd());
			panel.add(getButtonUpdate());
			panel.add(getButtonDelete());
			panel.add(getTextPhone());
			panel.add(getLabelPhone());
			panel.add(getLabelEmail());
			panel.add(getTextEmail());
			panel.add(getLabelRegisterdate());
			panel.add(getTextRegister());
			panel.add(getLabelAdress());
			panel.add(getTextAdress());
			panel.add(getLabelCinsiyet());
			panel.add(getRadiobuttonMale());
			panel.add(getRadiobuttonFemale());
		}
		return panel;
	}

	private JLabel getLabelName() {
		if (labelName == null) {
			labelName = new JLabel("\u0130sim:");
			labelName.setFont(new Font("Arial", Font.BOLD, 13));
			labelName.setBounds(5, 5, 111, 18);
		}
		return labelName;
	}

	private JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setFont(new Font("Arial", Font.PLAIN, 12));
			textName.setColumns(10);
			textName.setBounds(149, 5, 112, 19);
		}
		return textName;
	}

	private JLabel getLabelSurname() {
		if (labelSurname == null) {
			labelSurname = new JLabel("Soyisim:");
			labelSurname.setFont(new Font("Arial", Font.BOLD, 13));
			labelSurname.setBounds(5, 35, 111, 18);
		}
		return labelSurname;
	}

	private JTextField getTextSurname() {
		if (textSurname == null) {
			textSurname = new JTextField();
			textSurname.setFont(new Font("Arial", Font.PLAIN, 12));
			textSurname.setColumns(10);
			textSurname.setBounds(149, 35, 112, 19);
		}
		return textSurname;
	}

	private JButton getButtonAdd() {
		if (buttonAdd == null) {
			buttonAdd = new JButton("Ekle");
			buttonAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					StudentDao daostudent = new StudentDao();
					Student temp = new Student();
					temp.setName(textName.getText());
					temp.setSurname(textSurname.getText());
					temp.setPhone(textPhone.getText());
					temp.setEmail(textEmail.getText());

					// System.out.println(DateTimeFormatter.ofPattern(DateFormat).format(localDate));

					SimpleDateFormat df = new SimpleDateFormat(DateFormat);
					Date dateobj = new Date();
					System.out.println(dateobj.toString());
					temp.setRegisterdate(dateobj);

					temp.setAdress(textAdress.getText());

					if (radiobuttonFemale.isSelected())
						temp.setGender(GenderEnums.KADIN);
					//System.out.println(GenderEnums.KADIN);
					else if (radiobuttonMale.isSelected())
						temp.setGender(GenderEnums.ERKEK);
					System.out.println(temp.getGender());
					daostudent.kaydet(temp);
					fillStudentTableList();

				}
			});
			buttonAdd.setFont(new Font("Arial", Font.BOLD, 13));
			buttonAdd.setBounds(292, 5, 142, 32);
		}
		return buttonAdd;
	}

	private JButton getButtonUpdate() {
		if (buttonUpdate == null) {
			buttonUpdate = new JButton("G\u00FCncelle");
			buttonUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StudentDao daostudent = new StudentDao();
					Student temp = new Student();
					String id=(String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 0);
					temp.setId(Long.parseLong(id));
					temp.setName(textName.getText());
					temp.setSurname(textSurname.getText());
					temp.setPhone(textPhone.getText());
					temp.setEmail(textEmail.getText());

					// System.out.println(DateTimeFormatter.ofPattern(DateFormat).format(localDate));

					SimpleDateFormat df = new SimpleDateFormat(DateFormat);
					Date dateobj = new Date();
					System.out.println(dateobj.toString());
					temp.setRegisterdate(dateobj);

					temp.setAdress(textAdress.getText());

					if (radiobuttonFemale.isSelected())
						temp.setGender(GenderEnums.KADIN);
					//System.out.println(GenderEnums.KADIN);
					else if (radiobuttonMale.isSelected())
						temp.setGender(GenderEnums.ERKEK);
					System.out.println(temp.getGender());
					daostudent.guncelle(temp);
					fillStudentTableList();
					
					
					
				}
			});
			buttonUpdate.setFont(new Font("Arial", Font.BOLD, 13));
			buttonUpdate.setBounds(292, 47, 142, 32);
		}
		return buttonUpdate;
	}

	private JButton getButtonDelete() {
		if (buttonDelete == null) {
			buttonDelete = new JButton("Sil");
			buttonDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentDao daostudent=new StudentDao();
					Student temp= new Student();
					String id=(String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 0);
					temp.setId(Long.parseLong(id));
					daostudent.sil(temp);
					fillStudentTableList();
					
					
					
				}
			});
			buttonDelete.setFont(new Font("Arial", Font.BOLD, 13));
			buttonDelete.setBounds(292, 89, 142, 32);
		}
		return buttonDelete;
	}

	private JTextField getTextPhone() {
		if (textPhone == null) {
			textPhone = new JTextField();
			textPhone.setFont(new Font("Arial", Font.PLAIN, 12));
			textPhone.setColumns(10);
			textPhone.setBounds(149, 63, 112, 19);
		}
		return textPhone;
	}

	private JLabel getLabelPhone() {
		if (labelPhone == null) {
			labelPhone = new JLabel("Telefon:");
			labelPhone.setFont(new Font("Arial", Font.BOLD, 13));
			labelPhone.setBounds(5, 63, 111, 18);
		}
		return labelPhone;
	}

	private JLabel getLabelEmail() {
		if (labelEmail == null) {
			labelEmail = new JLabel("e-mail:");
			labelEmail.setFont(new Font("Arial", Font.BOLD, 13));
			labelEmail.setBounds(5, 89, 111, 18);
		}
		return labelEmail;
	}

	private JTextField getTextEmail() {
		if (textEmail == null) {
			textEmail = new JTextField();
			textEmail.setFont(new Font("Arial", Font.PLAIN, 12));
			textEmail.setColumns(10);
			textEmail.setBounds(149, 89, 112, 19);
		}
		return textEmail;
	}

	private JLabel getLabelRegisterdate() {
		if (labelRegisterdate == null) {
			labelRegisterdate = new JLabel("Kay\u0131t Tarihi:");
			labelRegisterdate.setFont(new Font("Arial", Font.BOLD, 13));
			labelRegisterdate.setBounds(5, 117, 111, 18);
		}
		return labelRegisterdate;
	}

	private JTextField getTextRegister() {
		if (textRegister == null) {
			textRegister = new JTextField();
			
			textRegister.setFont(new Font("Arial", Font.PLAIN, 12));
			textRegister.setEnabled(false);
			textRegister.setColumns(10);
			textRegister.setBounds(149, 118, 112, 19);
			Format formatter = new SimpleDateFormat(DateFormat);
			java.util.Date Regdate = new java.util.Date();
			String strDate = formatter.format(Regdate);
			textRegister.setText(strDate);
		}
		return textRegister;
	}

	private JLabel getLabelAdress() {
		if (labelAdress == null) {
			labelAdress = new JLabel("Adres:");
			labelAdress.setFont(new Font("Arial", Font.BOLD, 13));
			labelAdress.setBounds(5, 191, 111, 18);
		}
		return labelAdress;
	}

	private JTextPane getTextAdress() {
		if (textAdress == null) {
			textAdress = new JTextPane();
			textAdress.setFont(new Font("Arial", Font.PLAIN, 12));
			textAdress.setBounds(149, 191, 117, 72);
		}
		return textAdress;
	}

	private JLabel getLabelCinsiyet() {
		if (LabelCinsiyet == null) {
			LabelCinsiyet = new JLabel("Cinsiyet:");
			LabelCinsiyet.setFont(new Font("Arial", Font.BOLD, 13));
			LabelCinsiyet.setBounds(5, 146, 111, 34);
		}
		return LabelCinsiyet;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(25, 323, 542, 239);
			scrollPane.setViewportView(getTableStudentList());
		}
		return scrollPane;
	}

	private JRadioButton getRadiobuttonMale() {
		if (radiobuttonMale == null) {
			radiobuttonMale = new JRadioButton("Erkek");
			radiobuttonMale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					radiobuttonFemale.setSelected(false);
				}

			});
			radiobuttonMale.setBounds(215, 153, 78, 23);
		}
		return radiobuttonMale;
	}

	private JRadioButton getRadiobuttonFemale() {
		if (radiobuttonFemale == null) {
			radiobuttonFemale = new JRadioButton("Kad\u0131n");
			radiobuttonFemale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					radiobuttonMale.setSelected(false);

				}
			});
			radiobuttonFemale.setBounds(149, 153, 64, 23);
		}
		return radiobuttonFemale;
	}

	private void fillStudentTableList() {
		StudentDao dao = new StudentDao();
		List<Student> liste = dao.getir(new Student());
		String[] columnNames = { "id", "Adý", "Soyadý", "Cinsiyet", "Kayýt Tarihi", "Telefon", "E-Mail", "Adress" };
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = liste.get(i).getId().toString();
			data[i][1] = liste.get(i).getName().toString();
			data[i][2] = liste.get(i).getSurname().toString();
			System.out.println(liste.get(i).getGender());
			data[i][3] = liste.get(i).getGender().toString();
			Format formatter = new SimpleDateFormat(DateFormat);
			String strDate = formatter.format(liste.get(i).getRegisterdate());
			data[i][4] = strDate;
			data[i][5] = liste.get(i).getPhone().toString();
			data[i][6] = liste.get(i).getEmail().toString();
			data[i][7] = liste.get(i).getAdress().toString();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tableStudentList.setModel(model);
	}
	private JTable getTableStudentList() {
		if (tableStudentList == null) {
			tableStudentList = new JTable();
			tableStudentList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					textName.setText((String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 1));
					textSurname.setText((String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 2));
					
					String GenderString=(String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 3);
					
					if (GenderString.equals("ERKEK")) {
						radiobuttonMale.setSelected(true);
						radiobuttonFemale.setSelected(false);
					}
					else if (GenderString.equals("KADIN")) {
						radiobuttonMale.setSelected(false);
						radiobuttonFemale.setSelected(true);
					}
			
					
					textRegister.setText((String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 4));
					textPhone.setText((String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 5));
					textEmail.setText((String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 6));
					textAdress.setText((String) tableStudentList.getModel().getValueAt(tableStudentList.getSelectedRow(), 7));
					
					
					
				}
			});
		}
		return tableStudentList;
	}
}
