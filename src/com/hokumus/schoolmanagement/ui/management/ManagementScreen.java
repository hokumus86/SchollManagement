package com.hokumus.schoolmanagement.ui.management;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.hokumus.schoolmanagement.ui.addteacher.AddTeacherFrame;
import com.hokumus.schoolmanagement.ui.course.CreateCourseFrame;
import com.hokumus.schoolmanagement.ui.main.MainScreen;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementScreen extends JFrame {
	private JMenuItem mn�tmNewMenuItem;

	public ManagementScreen() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new MainScreen().setVisible(true);
			}
		});
		initialize();
	}

	public void initialize() {
		setTitle("Y�netici Kontrol Ekran�");
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 586, 22);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ekle");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuitemAddCourse = new JMenuItem("Ders Ekle");
		menuitemAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateCourseFrame().setVisible(true);
				
				
			}
		});
		menuitemAddCourse.setFont(new Font("Arial", Font.BOLD, 13));
		mnNewMenu.add(menuitemAddCourse);
		
		JMenuItem menuitemAddTeacher = new JMenuItem("\u00D6\u011Fretmen Ekle");
		menuitemAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddTeacherFrame().setVisible(true);
			}
		});
		menuitemAddTeacher.setFont(new Font("Arial", Font.BOLD, 13));
		mnNewMenu.add(menuitemAddTeacher);
		
		JMenuItem menuitemAddStudent = new JMenuItem("\u00D6\u011Frenci Ekle");
		menuitemAddStudent.setFont(new Font("Arial", Font.BOLD, 13));
		mnNewMenu.add(menuitemAddStudent);
		
		JMenuItem menuitemAddClassroom = new JMenuItem("Derslik Ekle");
		menuitemAddClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddLessonClass().setVisible(true);
			}
		});
		menuitemAddClassroom.setFont(new Font("Arial", Font.BOLD, 13));
		mnNewMenu.add(menuitemAddClassroom);
		mnNewMenu.add(getMn�tmNewMenuItem());
		setSize(600, 600);

	}
	private JMenuItem getMn�tmNewMenuItem() {
		if (mn�tmNewMenuItem == null) {
			mn�tmNewMenuItem = new JMenuItem("New menu item");
		}
		return mn�tmNewMenuItem;
	}
}
