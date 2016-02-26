import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientForm extends JFrame {
    private JButton JoinButton;
    private JLabel SA;
    private JLabel Nick;
    private JTextField SAText;
    private JTextField NickText;

    public ClientForm() {
        initComponents();
    }

    public ClientForm(String address, String name) {
        initComponents();
        SAText.setText(address);
        NickText.setText(name);
    }

    private void initComponents() {
        setTitle("UNO Client");

        SA = new JLabel();
        SAText = new JTextField();
        Nick = new JLabel();
        NickText = new JTextField();
        JoinButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SA.setText("Введите адрес сервера:");

        SAText.setText("");

        Nick.setText("Введите свой Nickname:");

        NickText.setText("");

        JoinButton.setText("Присоединиться");
        JoinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nickname = NickText.getText();
                    if (nickname.length() > 0) {
                        if (nickname.length() < 50) {
                            int port = 3456;
                            String host = SAText.getText();
                            Socket socket = new Socket(host, port);
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                            oos.flush();
                            oos.writeObject(nickname);
                            oos.flush();
                            Player me = (Player) ois.readObject();
                            new GameWindow(ois, oos, me, SAText.getText());
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Слишком много символов");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Имя не должно быть пустым!");
                    }
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Сервер не найден!\n" + SAText.getText());
                } catch (ClassNotFoundException e1) {

                }
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JoinButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(Nick, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(SA, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(SAText)
                                                        .addComponent(NickText, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(SA)
                                        .addComponent(SAText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Nick)
                                        .addComponent(NickText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JoinButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        new ClientForm().setVisible(true);
    }


}
