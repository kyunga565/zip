package zipcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField tfzip;
	private JTextField tfaddr;
	private JTextField tfaddr2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("우편번호검색하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblzip = new JLabel("우편번호");
		lblzip.setBounds(56, 21, 61, 16);
		contentPane.add(lblzip);
		
		tfzip = new JTextField();
		tfzip.setBounds(142, 16, 130, 26);
		contentPane.add(tfzip);
		tfzip.setColumns(10);
		
		JButton btnsearch = new JButton("우편번호검색");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search s = new Search();
				s.setVisible(true);
			//	revalidate();  
			}
		});
		btnsearch.setBounds(284, 16, 117, 29);
		contentPane.add(btnsearch);
		
		JLabel lbladdress = new JLabel("주소");
		lbladdress.setBounds(56, 88, 61, 16);
		contentPane.add(lbladdress);
		
		tfaddr = new JTextField();
		tfaddr.setBounds(142, 83, 259, 26);
		contentPane.add(tfaddr);
		tfaddr.setColumns(10);
		
		JLabel lbladdress2 = new JLabel("세부주소");
		lbladdress2.setBounds(56, 153, 61, 16);
		contentPane.add(lbladdress2);
		
		tfaddr2 = new JTextField();
		tfaddr2.setBounds(142, 148, 259, 26);
		contentPane.add(tfaddr2);
		tfaddr2.setColumns(10);
		
		JButton btnadd = new JButton("등록");
		btnadd.setBounds(142, 222, 117, 29);
		contentPane.add(btnadd);
	}
}
