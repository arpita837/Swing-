import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.ImageIcon;

public class DoublyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField rearelement;
	private JTextField frontelement;
	private JTextField displaybox;
	private Node first;

	/**
	 * Launch the application.
	 */
	private static  void speech_Button_Action(String text)
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.speak(text);
    }
	class Node
	{
		Node prelink;
		int data;
		Node nextlink;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedList frame = new DoublyLinkedList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("Welcome To Doubly Linked List ");
	}

	/**
	 * Create the frame.
	 */
	public DoublyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOUBLY LINKED LIST DATASTRUCTURE");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBackground(new Color(128, 64, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(55, 0, 430, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER THE ELEMENT");
		lblNewLabel_1.setForeground(new Color(255, 128, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 47, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ENTER THE ELEMENT");
		lblNewLabel_1_1.setForeground(new Color(255, 128, 128));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 92, 140, 14);
		contentPane.add(lblNewLabel_1_1);
		
		rearelement = new JTextField();
		rearelement.setBounds(154, 42, 86, 20);
		contentPane.add(rearelement);
		rearelement.setColumns(10);
		
		frontelement = new JTextField();
		frontelement.setBounds(154, 89, 86, 20);
		contentPane.add(frontelement);
		frontelement.setColumns(10);
		
		JButton insertrear = new JButton("INSERT REAR");
		insertrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to insert rear
				Node temp;
				int elem = Integer.valueOf(rearelement.getText());
				Node newnode  = new Node();
				newnode.data = elem;
				newnode.prelink = null;
				newnode.nextlink = null;
				if(first==null)
				{
					first = newnode;
					JOptionPane.showMessageDialog(contentPane, "Insert rear Successfull");
					rearelement.setText("");
				}
				else
				{
					temp = first;
					while(temp.nextlink!=null)
					{
						temp=temp.nextlink;
					}
					temp.nextlink=newnode;
					newnode.prelink=temp;
					JOptionPane.showMessageDialog(contentPane, "Insert rear Successfull");
					rearelement.setText("");
				}
			}
		});
		insertrear.setForeground(new Color(0, 0, 0));
		insertrear.setFont(new Font("Times New Roman", Font.BOLD, 13));
		insertrear.setBounds(267, 43, 120, 23);
		contentPane.add(insertrear);
		
		JButton insertfront = new JButton("INSERT FRONT");
		insertfront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert front
				int elem = Integer.valueOf(frontelement.getText());
				Node newnode = new Node();
				newnode.data = elem;
				newnode.nextlink = null;
				newnode.prelink = null;
				if(first == null)
				{
					first = newnode;
					JOptionPane.showMessageDialog(contentPane, "Insert front Successfull");
					frontelement.setText("");
				}
				else
				{
					newnode.nextlink=first;
					first.prelink=newnode;
					first=newnode;
					JOptionPane.showMessageDialog(contentPane, "Insert front Successfull");
					frontelement.setText("");
				}
			}
		});
		insertfront.setForeground(new Color(0, 0, 0));
		insertfront.setFont(new Font("Times New Roman", Font.BOLD, 13));
		insertfront.setBounds(267, 88, 137, 25);
		contentPane.add(insertfront);
		
		JButton deleterear = new JButton("DELETE REAR");
		deleterear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Delete rear
				Node temp;
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane,"Delete not possible");
				}
				else if(first.nextlink==null)
				{
					JOptionPane.showMessageDialog(contentPane,"element deleted is"+first.data);
					first=null;
				}
				else
				{
					temp = first;
					while(temp.nextlink.nextlink!=null)
					{
						temp = temp.nextlink;
					}
					JOptionPane.showMessageDialog(contentPane,"element deleted is"+temp.nextlink.data);
					temp.nextlink=null;
				}
				
			}
		});
		deleterear.setForeground(new Color(0, 0, 0));
		deleterear.setFont(new Font("Times New Roman", Font.BOLD, 13));
		deleterear.setBounds(131, 117, 145, 23);
		contentPane.add(deleterear);
		
		JButton deletefront = new JButton("DELETE FRONT");
		deletefront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Delete Front
				Node temp;
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane,"deletion not possible");
				}
				else if(first.nextlink == null)
				{
					JOptionPane.showMessageDialog(contentPane,"Element deleted is"+first.data);
					first=null;
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane,"element deleted is"+first.data);
					first = first.nextlink;
					first.prelink=null;
				}
			}
		});
		deletefront.setForeground(new Color(0, 0, 0));
		deletefront.setFont(new Font("Times New Roman", Font.BOLD, 13));
		deletefront.setBounds(131, 151, 145, 23);
		contentPane.add(deletefront);
		
		JButton displayforward = new JButton("DISPLAY FORWARD");
		displayforward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Display forward
				String msg = "";
				Node temp;
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane,"display not possible");
				}
				else if(first.nextlink==null)
				{
					msg= msg + first.data;
					displaybox.setText(msg);
				}
				else
				{
					temp = first;
					while(temp!=null)
					{
						msg=msg +temp.data+" ";
						temp=temp.nextlink;
					}
					
				}
				displaybox.setText(msg);
			}
		});
		displayforward.setForeground(new Color(0, 0, 0));
		displayforward.setFont(new Font("Times New Roman", Font.BOLD, 13));
		displayforward.setBounds(10, 185, 175, 23);
		contentPane.add(displayforward);
		
		JButton displayreverse = new JButton("DISPLAY REVERSE");
		displayreverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Display reverse
				String msg = "";
				Node temp;
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane,"display not possible");
				}
				else if(first.nextlink==null)
				{
					msg = msg + first.data;
					displaybox.setText(msg);
				}
				else
				{
					temp=first;
					while(temp.nextlink!=null)
					{
						temp = temp.nextlink;
					}
					while(temp!=null)
					{
						
						msg = msg + temp.data+" ";
								temp =temp.prelink;
					}
						
				}
				displaybox.setText(msg);
			}
		});
		displayreverse.setForeground(new Color(0, 0, 0));
		displayreverse.setFont(new Font("Times New Roman", Font.BOLD, 13));
		displayreverse.setBounds(229, 185, 175, 23);
		contentPane.add(displayreverse);
		
		displaybox = new JTextField();
		displaybox.setBounds(34, 230, 370, 20);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton back = new JButton("back");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 Home h=new Home();
				 h.setVisible(true);
			}
		});
		back.setBounds(155, 263, 85, 21);
		contentPane.add(back);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Doubly-linked-list-in-Data-Structure.jpg"));
		lblNewLabel_2.setBounds(0, 0, 471, 306);
		contentPane.add(lblNewLabel_2);
	}

}