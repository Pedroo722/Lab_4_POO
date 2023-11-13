package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstoqueWindow {
    private final JFrame frame;
//    private final JList<Produto> list;
    private final JPopupMenu menu;
//    private final DefaultListModel<Produto> listModel;

    public EstoqueWindow() {
        frame = new JFrame("Estoque");
     //   list = new JList<>();
     //   listModel = new DefaultListModel<>();
     //   list.setModel(listModel);
        menu = new JPopupMenu();

        JButton adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(e -> {
            // add prod
        });

        JButton editarButton = new JButton("Editar Produto");
        editarButton.addActionListener(e -> {
            // edit prd
        });

        JButton excluirButton = new JButton("Excluir Produto");
        excluirButton.addActionListener(e -> {
            // del prod
        });

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(2, 2, 10, 10));
        panelButtons.setPreferredSize(new Dimension(400, 50));
        panelButtons.add(adicionarButton);
        panelButtons.add(editarButton);
        panelButtons.add(excluirButton);
        panelButtons.add(voltarButton);

//        list.setPreferredSize(new Dimension(400, 200));

//        list.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
//                    // abrir janela edição prod
//                }
//            }

//            @Override
//            public void mousePressed(MouseEvent e) {
//                showContextMenu(e);
//            }

//            @Override
//            public void mouseReleased(MouseEvent e) {
//                showContextMenu(e);
//            }
//        });

//        JScrollPane listScroller = new JScrollPane(list);

        frame.setLayout(new BorderLayout());
        frame.add(panelButtons, BorderLayout.PAGE_START);
//        frame.add(listScroller, BorderLayout.CENTER);
    }

//    private void showContextMenu(MouseEvent e) {
//        if (e.isPopupTrigger()) {
//            int index = list.locationToIndex(e.getPoint());
//            if (index >= 0 && index < listModel.size()) {
//                list.setSelectedIndex(index);
//                menu.show(e.getComponent(), e.getX(), e.getY());
//            }
//        }
//    }

    public void show() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
