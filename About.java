import java.awt.Font;
import javax.swing.*;//used for JFrame
import java.awt.event.*;//used for actionListener


public class About extends JFrame implements ActionListener {
    JButton b1;
	About(){
		setBounds(600,200,700,600);
		setLayout(null);//it is necessary because without that we are not able to use setBounds()
		
//	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("location");//this will help to get the image in the program
//		Image i2 = i1.getImage().getScaleInstance(400,80,Image.SCALE_DEFAULT);//this will help to change the size of the image icon
	JLabel i3 = new JLabel("<html>Code by tuff coders<br>version. 1 git hub repo<br>,All Rights Reserved.<br>Notepad is a word processing<br>program which allows Changing of text in computer files,<br>Notepad is simple text editor for vasic text editing program<br>which enables computer users to create documents</html>");
	i3.setBounds(150, 130, 500, 300);
	i3.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	add(i3);
	
	b1= new JButton("OK");
	b1.setBounds(580, 500, 80, 20);
	b1.addActionListener(this);
	add(b1);
		
	}
	
	//help to disable the window
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
	}
    public static void main(String[] args) {
        new About().setVisible(true);
    }
    
}
