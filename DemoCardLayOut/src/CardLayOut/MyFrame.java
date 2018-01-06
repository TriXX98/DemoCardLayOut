package CardLayOut;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.List;
import java.util.Scanner;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {
	Panel TimePanel, NavPanel, Panel;
	Label label;
	Date clock;

	public MyFrame() {
		// TODO Auto-generated constructor stub
		super("Demo CardLayOut");
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setLocation(ABORT, ABORT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setVisible(true);
		this.DemoCard();

	}

	private void DemoCard() {
		// TODO Auto-generated method stub
		MyWord wordd = new MyWord();
		
		Panel = new Panel();
		CardLayout card = new CardLayout();
		Panel.setLayout(card);

		NavPanel = new Panel();
		TimePanel = new Panel();

		
		// thực hiện nút Next
		JButton b1 = new JButton("NEXT ==>");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next();

			}

			private void next() {
				// TODO Auto-generated method stub
				card.next(NavPanel);

			}
		});

		// Thực hiện nút Previous
		JButton b2 = new JButton("<== PREVIOUS");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				prev();

			}

			private void prev() {
				// TODO Auto-generated method stub
				card.previous(NavPanel);

			}
		});

		// Thực hiện nút Exit
		JButton b3 = new JButton("EXIT");
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exitPage();
			}

			private void exitPage() {
				// TODO Auto-generated method stub
				int exit = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ? ", "Chương trình hỏi bạn thoát !",
						JOptionPane.YES_NO_CANCEL_OPTION);

				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		NavPanel.add(b1);
		NavPanel.add(b2);
		NavPanel.add(b3);

		label = new Label("00:00");
		TimePanel.add(label);

		// để đoạn lệnh thời gian chay trong 10s
		// Thời gian sau 10s - Thời gian hiện tại

		try {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					int i = 10;
					int j = 0;
					while (true) {

						while (i > 0) {
							i--;
							int minute = i / 60;
							int second = i - 60 * minute;
							String time = minute + ":" + second;
							label.setText(time);
							try {
								j++;
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}
			});
			thread.start();
		} catch (Exception e) {
			e.getMessage();
		}

		this.add(NavPanel, BorderLayout.SOUTH);
		this.add(TimePanel, BorderLayout.NORTH);

		// Sử dụng Cardlayout
		Scanner scan = new Scanner(System.in);
		List<MyWord> list = new ArrayList<>();

		System.out.println("Word: ");
		String word = scan.nextLine();
		System.out.println("Mean: ");
		String mean = scan.nextLine();

		MyWord myWord = new MyWord(word, mean);
		list.add(myWord);
		
		ReadSaveFile readSaveFile = new ReadSaveFile();
		readSaveFile.saveFile(list);
	
		JPanel jPanel = new JPanel();
		jPanel.add(new JLabel(wordd.toString()));
		
		
		Panel.add(jPanel);


	}

	// protected void Time() {
	// // TODO Auto-generated method stub
	// Date clock = new Date();
	// SimpleDateFormat format = new SimpleDateFormat("ss");
	// this.label.setText(format.format(clock ));
	//
	//
	//
	//
	// }

}
