import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerForm extends JFrame {
    Server server;
    JButton StartButton;
    JLabel SLabel;
    JLabel Plabel;
    JTextField ServerName;
    JTextField PlayersWindow;

    public ServerForm(Server server) throws IOException, ClassNotFoundException {
        this.server = server;
        initComponents();
    }

    private void initComponents() throws IOException, ClassNotFoundException {
        setTitle("UNO Server");
        SLabel = new JLabel();
        ServerName = new JTextField();
        PlayersWindow = new JTextField();
        Plabel = new JLabel();
        StartButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SLabel.setText("Наименование и адрес сервера");

        ServerName.setText(InetAddress.getLocalHost() + "");
        ServerName.setEditable(false);

        PlayersWindow.setText("");
        PlayersWindow.setEditable(false);

        Plabel.setText("Подключенные игроки:");

        StartButton.setText("Начать игру");
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (server.connections.size() >= 2) {
                        server.thread.sc.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Слишком мало игроков!");
                    }
                } catch (SocketException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(SLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Plabel)
                                        .addComponent(StartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(PlayersWindow, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                        .addComponent(ServerName))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(SLabel)
                                        .addComponent(ServerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(PlayersWindow)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Plabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(StartButton, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }
}
