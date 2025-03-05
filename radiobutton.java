import javax.swing.*;//provide classes for GUI components eg. JRadioButton.
import java.awt.*;//layout management ang graphical components.
import java.awt.event.ActionEvent;//user interaction(UI) eg. button clicks.
import java.awt.event.ActionListener;//responds when button is clicked
import java.net.URL;

//main class
public class radiobutton extends JFrame implements ActionListener{


//declaring GUI components.
    private JLabel imageLabel;//display image.
    private JRadioButton birdButton,catButton,dogButton,rabbitButton,pigButton;//radiobuttons
    

    public radiobutton(){
        setTitle("RadioButton");//title
        setSize(400,400);//size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close program
        setLayout(new FlowLayout());//organize components from left to right
    

    //creating Radio buttons
    birdButton=new JRadioButton("Bird");
    catButton=new JRadioButton("Cat");
    dogButton=new JRadioButton("Dog");
    rabbitButton=new JRadioButton("Rabbit");
    pigButton=new JRadioButton("Pig");

    //group the radio buttons...ensures one button is selected.
    ButtonGroup group=new ButtonGroup();
    group.add(birdButton);
    group.add(catButton);
    group.add(dogButton);
    group.add(rabbitButton);
    group.add(pigButton);


    //creating image label
    imageLabel = new JLabel();
    add(imageLabel);
    imageLabel.setPreferredSize(new Dimension(200,200));


    //adding action listeners to radio buttons //ImageChanger calls helper class that changes image
    birdButton.addActionListener(this);
    catButton.addActionListener(this);
    dogButton.addActionListener(this);
    rabbitButton.addActionListener(this);
    pigButton.addActionListener(this);

    //adding components to window
    add(birdButton);
    add(catButton);
    add(dogButton);
    add(rabbitButton);
    add(pigButton);
    add(imageLabel);//ensures label is added


    }


        @Override
        public void actionPerformed(ActionEvent e){//runs button is clicked.
            String imagePath="image";
            if (birdButton.isSelected()) {
                imagePath="/image/bird.png";
            }else if (catButton.isSelected()) {
                imagePath="/image/cat.png";
            }else if (dogButton.isSelected()) {
                imagePath="/image/dog.png";
            }else if (rabbitButton.isSelected()) {
                imagePath="/image/rabbit.png";
            }else if (pigButton.isSelected()) {
                imagePath="/image/pig.png";
            }
            URL imageUrl=getClass().getResource(imagePath);
            if (imageUrl!=null) {
                ImageIcon icon=new ImageIcon(imagePath);
                imageLabel.setIcon(icon);
            JOptionPane.showMessageDialog(this, "you selected"+ ((JRadioButton)e.getSource()).getText(),"selection",JOptionPane.INFORMATION_MESSAGE, icon);
            }else{
                imageLabel.setIcon(null);
                JOptionPane.showMessageDialog(this, "Image not found!","error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
          radiobutton selector=new radiobutton();
          selector.setVisible(true);
        });
    }
        

    
        
    }