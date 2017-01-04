package zipcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;

import zipcode.dao.ZipcodeDao;
import zipcode.dto.ZipcodeDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<String> list;
	private JTextField tfdoro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setTitle("도로명검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblsido = new JLabel("시도");
		lblsido.setBounds(12, 17, 40, 16);
		contentPane.add(lblsido);

		JComboBox<String> cbsido = new JComboBox<>();

		List<ZipcodeDto> list = ZipcodeDao.getInstance().selectsido();
		for (ZipcodeDto zipdto : list) {
			cbsido.addItem(zipdto.getSido());
		}

		cbsido.setBounds(43, 12, 127, 27);
		contentPane.add(cbsido);

		JLabel lbldoro = new JLabel("도로명");
		lbldoro.setBounds(183, 16, 54, 16);
		contentPane.add(lbldoro);

		JButton btnsearch = new JButton("검색");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"우편번호", "시도", "도로명", "건물번호1", "건물번호2"
					}
				));
				table.setBounds(8, 51, 412, 200);
				contentPane.add(table);
			}
		});

		tfdoro = new JTextField();
		tfdoro.setBounds(227, 14, 116, 21);
		contentPane.add(tfdoro);
		tfdoro.setColumns(10);
		btnsearch.setBounds(351, 10, 73, 29);
		contentPane.add(btnsearch);
		
//		DefaultTableModel model = new DefaultTableModel();	
//		model = (DefaultTableModel) table.getModel();
		
		
	}

	
	
}
