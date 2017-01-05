package zipcode;

import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.html.StyleSheet.ListPainter;

import zipcode.dao.ZipcodeDao;
import zipcode.dto.ZipcodeDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Search extends JFrame {

	private JPanel contentPane;
	private List<String> list;
	private JTextField tfdoro;
	private JComboBox<String> cbsido;
	private JTable table_1;
	private JPanel listPanel;

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

		
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblsido = new JLabel("시도");
		panel.add(lblsido);

		cbsido = new JComboBox<>();
		panel.add(cbsido);

		JLabel lbldoro = new JLabel("도로명");
		panel.add(lbldoro);

		tfdoro = new JTextField();
		panel.add(tfdoro);
		tfdoro.setColumns(10);

		JButton btnsearch = new JButton("검색");
		panel.add(btnsearch);
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1.setModel(new DefaultTableModel(row(), col()));
				listPanel.add(new JScrollPane(table_1));
				listPanel.revalidate();
				listPanel.repaint();

			}
		});

		listPanel = new JPanel();
		contentPane.add(listPanel);
		listPanel.setLayout(new BorderLayout(0, 0));

	
		
		table_1 = new JTable();
		table_1.setBounds(8, 51, 421, 200);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String zip = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
				String doroname = (String) table_1.getValueAt(table_1.getSelectedRow(), 3);
				String sigunguname = (String) table_1.getValueAt(table_1.getSelectedRow(), 2);
				PostMain.tfzip.setText(zip+"");
				PostMain.tfaddr.setText(res().getSido()+" "+sigunguname+" "+doroname);
			}
		}); 
		List<ZipcodeDto> list = ZipcodeDao.getInstance().selectsido();
		for (ZipcodeDto zipdto : list) {
			cbsido.addItem(zipdto.getSido());
		}
	}
	private ZipcodeDto res() {
		String sidoooo = cbsido.getSelectedItem() + "";
		String doroooo = tfdoro.getText();
		return new ZipcodeDto(sidoooo, doroooo);
	}

	private String[][] row() {
		List<ZipcodeDto> list = ZipcodeDao.getInstance().selectdorosido(res());
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			String[] ar = list.get(i).toArray();
			rowDatas[i] = ar;
		}
		return rowDatas;
	}

	private String[] col() {
		return new String[] { "우편번호", "시도", "시군구", "도로명", "건물번호1", "건물번호2" };
	}
}
