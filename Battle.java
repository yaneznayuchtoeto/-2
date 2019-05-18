import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Battle {
    public static void main(String[] args) {

        String[]arrsym= new String[]{"A","B","C","D","E","F","G","I","J","K"};
        ArrayList<String> arr= new <String>ArrayList();
        for (int index=0;index<10;index++){
            for (int jindex=0;jindex<10;jindex++){
                arr.add(arrsym[index]+(jindex+1));
            }
        }
        System.out.println(arr);
        JFrame frame= new JFrame("seabattle");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(1366/2,768/2,500,500);
        GridLayout grl= new GridLayout(10,10);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(grl);
        String sym="A";
        JButton[][] btn=new JButton[10][10];
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                JButton b=btn[i][j];
                panel.add(btn[i][j]=new JButton(arrsym[i]+(j+1)));

                btn[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (arr.contains(b.getText())){
                            arr.remove(b.getText());
                            b.setText("попал");
                        }
                    }


                });

            }
        }
        frame.setVisible(true);
    }
}