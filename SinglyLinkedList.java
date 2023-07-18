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

public class SinglyLinkedList extends JFrame {

	private JPanel contentPane;
	private JTextField insertelement;
	private JTextField insertfront;
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
		int data;
		Node link;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("Welcome To Singly Linked List");
	}

	/**
	 * Create the frame.
	 */
	public SinglyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SINGLY LINKED LIST DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(38, 24, 388, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER THE ELEMENT :");
		lblNewLabel_1.setForeground(new Color(255, 255, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 54, 132, 16);
		contentPane.add(lblNewLabel_1);
		
		insertelement = new JTextField();
		insertelement.setBounds(169, 52, 86, 20);
		contentPane.add(insertelement);
		insertelement.setColumns(10);
		
		JButton insertrear = new JButton("INSERT REAR");
		insertrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for insert  rear
				Node temp;
				
				int elem = Integer.valueOf(insertelement.getText());
				Node newnode = new Node();
				newnode.data = elem;
				newnode.link = null;
				if(first==null)
				{
					first=newnode;
					JOptionPane.showMessageDialog(contentPane, "Insert rear Successfull");
					insertelement.setText("");
				}
				else
				{
					temp = first;
					while(temp.link!=null)
					{
						temp = temp.link;
					}
					temp.link=newnode;
					JOptionPane.showMessageDialog(contentPane, "Insert rear Successfull");
					insertelement.setText("");
				}
			}
		});
		insertrear.setForeground(new Color(0, 0, 255));
		insertrear.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		insertrear.setBounds(280, 51, 132, 23);
		contentPane.add(insertrear);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER THE ELEMENT");
		lblNewLabel_2.setForeground(new Color(255, 255, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 81, 132, 14);
		contentPane.add(lblNewLabel_2);
		
		insertfront = new JTextField();
		insertfront.setBounds(169, 83, 86, 20);
		contentPane.add(insertfront);
		insertfront.setColumns(10);
		
		JButton inserfront = new JButton("INSERT FRONT");
		inserfront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to insert front
			
				int elem = Integer.valueOf(insertfront.getText());
				Node newnode = new Node();
				newnode.data = elem;
				newnode.link=null;
				if(first==null)
				{
					first=newnode;
				}
				else
				{
					newnode.link=first;
					first=newnode;
					JOptionPane.showMessageDialog(contentPane, "Insert front Successfull");
					insertfront.setText("");
				}
				
			}
		});
		inserfront.setForeground(new Color(0, 0, 255));
		inserfront.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		inserfront.setBounds(290, 85, 122, 23);
		contentPane.add(inserfront);
		
		JButton deleterear = new JButton("DELETE REAR");
		deleterear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to delete rear
				Node temp;
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane,"Delete not possible");
				}
				else if(first.link ==null)
				{
					JOptionPane.showMessageDialog(contentPane,"element deleted is"+first.data);
					first = null;
				}
				else
				{
					temp = first;
					while(temp.link.link!=null)
					{
						temp = temp.link;
					}
					JOptionPane.showMessageDialog(contentPane,"elmnt deleted is "+temp.link.data);
					temp.link=null;
				}
			}
		});
		deleterear.setForeground(new Color(0, 0, 255));
		deleterear.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		deleterear.setBounds(106, 114, 132, 23);
		contentPane.add(deleterear);
		
		JButton deletefront = new JButton("DELETE FRONT");
		deletefront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Delete Front
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible");
				}
				else if(first.link == null)
				{
					JOptionPane.showMessageDialog(contentPane,"Element delete is "+first.data);
					first=null;
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane,"element deleted is"+first.data);
					first=first.link;
				}
			}
		});
		deletefront.setForeground(new Color(0, 0, 255));
		deletefront.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		deletefront.setBounds(106, 148, 132, 25);
		contentPane.add(deletefront);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code Display
				Node temp;
				String msg = "";
				if(first == null)
				{
					JOptionPane.showMessageDialog(contentPane,"Display not possible");
				}
				else if(first.link==null)
				{
					msg = msg+ first.data;
					displaybox.setText(msg);
				}
				else
				{
					temp = first;
					while(temp!=null)
					{
						msg=msg+temp.data+" ";
						temp=temp.link;
					}
				}
				displaybox.setText(msg);
			}
		});
		display.setForeground(Color.BLUE);
		display.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		display.setBounds(106, 184, 132, 25);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBounds(10, 230, 414, 20);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 Home h=new Home();
				 h.setVisible(true);
			}
		});
		back.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		back.setBounds(304, 186, 85, 21);
		contentPane.add(back);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Singlylink.jpg"));
		lblNewLabel_3.setBounds(0, 0, 439, 263);
		contentPane.add(lblNewLabel_3);
	}

}