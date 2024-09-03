package com.unilabs.agenda.App;

// Se importan las librerias
import com.toedter.calendar.JDateChooser; // Para el selector de calendario
import com.unilabs.agenda.Modal.Agenda;
import com.unilabs.agenda.Modal.Contacto;
import com.unilabs.agenda.Modal.Grupo;
import com.unilabs.agenda.Modal.Reunion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class GUI extends JFrame {

    private Agenda agenda;

    public GUI() {
        agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        this.setTitle("Agenda");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 500);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        // Crear componentes
        JButton agregarContactoButton = new JButton("Agregar Contacto");
        JButton eliminarContactoButton = new JButton("Eliminar Contacto");
        JButton agregarGrupoButton = new JButton("Agregar Grupo");
        JButton eliminarGrupoButton = new JButton("Eliminar Grupo");
        JButton agregarReunionButton = new JButton("Agregar Reunion");
        JButton eliminarReunionButton = new JButton("Eliminar Reunion");
        JButton verContactosButton = new JButton("Ver Contactos");
        JButton verGruposButton = new JButton("Ver Grupos");
        JButton verReunionesButton = new JButton("Ver Reuniones");

        // Agregar componentes al frame
        this.add(agregarContactoButton);
        this.add(eliminarContactoButton);
        this.add(agregarGrupoButton);
        this.add(eliminarGrupoButton);
        this.add(agregarReunionButton);
        this.add(eliminarReunionButton);
        this.add(verContactosButton);
        this.add(verGruposButton);
        this.add(verReunionesButton);

        // Agregar ActionListener a los botones
        agregarContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaAgregarContacto();
            }
        });

        eliminarContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaEliminarContactos();
            }
        });

        agregarGrupoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaAgregarGrupo();
            }
        });

        eliminarGrupoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaEliminarGrupos();
            }
        });

        agregarReunionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaAgregarReunion();
            }
        });

        eliminarReunionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaEliminarReuniones();
            }
        });

        verContactosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarContactos();
            }
        });

        verGruposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGrupos();
            }
        });

        verReunionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarReuniones();
            }
        });

        // Layout
        this.setLayout(new GridLayout(4, 3));
    }

    private void mostrarVentanaAgregarContacto() {
        // Crear panel para los campos de entrada
        JPanel panel = new JPanel(new GridLayout(0, 2));

        // Crear campos de entrada
        JTextField nombreField = new JTextField();
        JTextField telefonoField = new JTextField();
        JTextField aliasField = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField emailField = new JTextField();

        // Agregar etiquetas y campos de entrada al panel
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Telefono:"));
        panel.add(telefonoField);
        panel.add(new JLabel("Alias:"));
        panel.add(aliasField);
        panel.add(new JLabel("Direccion:"));
        panel.add(direccionField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        // Crear ventana
        JFrame ventana = new JFrame("Agregar Contacto");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(300, 200);

        // Agregar panel y botón Guardar a la ventana
        ventana.add(panel, BorderLayout.CENTER);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos de los campos de entrada
                String nombre = nombreField.getText();
                String telefono = telefonoField.getText();
                String alias = aliasField.getText();
                String direccion = direccionField.getText();
                String email = emailField.getText();

                // Validar que no haya contactos duplicados
                for (Contacto c : agenda.getListaContactos()) {
                    if (c.getNombre().equals(nombre) && c.getTelefono().equals(telefono)) {
                        JOptionPane.showMessageDialog(ventana, "Ya existe un contacto con ese nombre y teléfono.");
                        return;
                    }
                }

                // Crear contacto
                Contacto contacto = new Contacto(nombre, telefono, alias, direccion, email);

                // Agregar contacto a la agenda
                String resultado = agenda.agregarContacto(contacto);

                // Mostrar resultado
                JOptionPane.showMessageDialog(ventana, resultado);

                // Cerrar la ventana
                ventana.dispose();
            }
        });
        ventana.add(guardarButton, BorderLayout.SOUTH);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void mostrarVentanaEliminarContactos() {
        // Crear tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tabla = new JTable(modeloTabla);
        modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Telefono", "Alias", "Direccion", "Email"});
        for (Contacto contacto : agenda.getListaContactos()) {
            modeloTabla.addRow(new Object[]{contacto.getNombre(), contacto.getTelefono(), contacto.getAlias(), contacto.getDireccion(), contacto.getEmail()});
        }

        // Crear ventana
        JFrame ventana = new JFrame("Eliminar Contactos");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(600, 400);

        // Agregar tabla a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventana.add(scrollPane, BorderLayout.CENTER);

        // Agregar botón Eliminar
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarContactosSeleccionados(tabla);
                ventana.dispose(); // Cerrar la ventana después de eliminar
            }
        });
        ventana.add(eliminarButton, BorderLayout.SOUTH);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void eliminarContactosSeleccionados(JTable tabla) {
        int[] filasSeleccionadas = tabla.getSelectedRows();
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();

        for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
            String nombre = (String) modeloTabla.getValueAt(filasSeleccionadas[i], 0);
            String telefono = (String) modeloTabla.getValueAt(filasSeleccionadas[i], 1);

            // Buscar contacto
            Contacto contacto = null;
            for (Contacto c : agenda.getListaContactos()) {
                if (c.getNombre().equals(nombre) && c.getTelefono().equals(telefono)) {
                    contacto = c;
                    break;
                }
            }

            if (contacto != null) {
                // Eliminar contacto de la agenda
                agenda.eliminarContacto(contacto);
            }
        }

        // Actualizar la tabla de contactos
        mostrarContactos();
    }


    private void mostrarVentanaAgregarGrupo() {
        // Crear panel para los campos de entrada
        JPanel panel = new JPanel(new GridLayout(0, 2));

        // Crear campos de entrada
        JTextField nombreField = new JTextField();
        JComboBox<String> categoriaComboBox = new JComboBox<>(new String[]{"Amigos", "Familia", "Trabajo", "Emergencia", "Otro"});
        JButton agregarIntegrantesButton = new JButton("Añadir Integrantes (0)");

        // Lista para almacenar los contactos seleccionados
        List<Contacto> integrantesSeleccionados = new ArrayList<>();

        // Agregar etiquetas y campos de entrada al panel
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Categoria:"));
        panel.add(categoriaComboBox);
        panel.add(new JLabel("Integrantes:"));
        panel.add(agregarIntegrantesButton);

        // ActionListener para el botón "Añadir Integrantes"
        agregarIntegrantesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaSeleccionarContactos(integrantesSeleccionados, agregarIntegrantesButton);
            }
        });

        // Crear ventana
        JFrame ventana = new JFrame("Agregar Grupo");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(300, 150);

        // Agregar panel y botón Guardar a la ventana
        ventana.add(panel, BorderLayout.CENTER);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos de los campos de entrada
                String nombre = nombreField.getText();
                String categoria = (String) categoriaComboBox.getSelectedItem();

                // Validar que el grupo no tenga más de 5 integrantes
                if (integrantesSeleccionados.size() > 5) {
                    JOptionPane.showMessageDialog(ventana, "Un grupo no puede tener más de 5 integrantes.");
                    return;
                }

                // Crear grupo
                Grupo grupo = new Grupo(nombre, new ArrayList<>(integrantesSeleccionados), categoria);

                // Agregar grupo a la agenda
                String resultado = agenda.agregarGrupo(grupo);

                // Mostrar resultado
                JOptionPane.showMessageDialog(ventana, resultado);

                // Cerrar la ventana
                ventana.dispose();
            }
        });
        ventana.add(guardarButton, BorderLayout.SOUTH);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void mostrarVentanaEliminarGrupos() {
        // Crear tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tabla = new JTable(modeloTabla);
        modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Categoria", "Integrantes"});
        for (Grupo grupo : agenda.getListaGrupos()) {
            String integrantes = "";
            for (Contacto contacto : grupo.getIntegrantes()) {
                integrantes += contacto.getNombre() + ", ";
            }
            if (integrantes.length() > 2) {
                integrantes = integrantes.substring(0, integrantes.length() - 2);
            }
            modeloTabla.addRow(new Object[]{grupo.getNombre(), grupo.getCategoria(), integrantes});
        }

        // Crear ventana
        JFrame ventana = new JFrame("Eliminar Grupos");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(600, 400);

        // Agregar tabla a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventana.add(scrollPane, BorderLayout.CENTER);

        // Agregar botón Eliminar
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarGruposSeleccionados(tabla);
                ventana.dispose(); // Cerrar la ventana después de eliminar
            }
        });
        ventana.add(eliminarButton, BorderLayout.SOUTH);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void eliminarGruposSeleccionados(JTable tabla) {
        int[] filasSeleccionadas = tabla.getSelectedRows();
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();

        for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
            String nombre = (String) modeloTabla.getValueAt(filasSeleccionadas[i], 0);

            // Buscar grupo
            Grupo grupoAEliminar = null;
            for (Grupo g : agenda.getListaGrupos()) {
                if (g.getNombre().equals(nombre)) {
                    grupoAEliminar = g;
                    break;
                }
            }

            if (grupoAEliminar != null) {
                // Eliminar grupo de la agenda
                agenda.eliminarGrupo(grupoAEliminar);
            }
        }

        // Actualizar la tabla de grupos
        mostrarGrupos();
    }

    private void mostrarVentanaAgregarReunion() {
        // Crear panel para los campos de entrada
        JPanel panel = new JPanel(new GridLayout(0, 2));

        // Crear campos de entrada
        JTextField descripcionField = new JTextField();

        // Para la fecha, usando JDateChooser
        JDateChooser fechaChooser = new JDateChooser();

        // Para el tiempo, usando JSpinner
        SpinnerDateModel modeloTiempo = new SpinnerDateModel();
        JSpinner tiempoSpinner = new JSpinner(modeloTiempo);
        JSpinner.DateEditor editorTiempo = new JSpinner.DateEditor(tiempoSpinner, "HH:mm"); // Formato de hora:minutos
        tiempoSpinner.setEditor(editorTiempo);
        JButton agregarIntegrantesButton = new JButton("Añadir Integrantes (0)");

        // Lista para almacenar los contactos seleccionados
        List<Contacto> integrantesSeleccionados = new ArrayList<>();

        // Agregar etiquetas y campos de entrada al panel
        panel.add(new JLabel("Descripcion:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Fecha:"));
        panel.add(fechaChooser); // Se añade el JDateChooser
        panel.add(new JLabel("Tiempo:"));
        panel.add(tiempoSpinner); // Se añade el JSpinner
        panel.add(new JLabel("Integrantes:"));
        panel.add(agregarIntegrantesButton);

        // ActionListener para el botón "Añadir Integrantes"
        agregarIntegrantesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Permitir al usuario corregir la selección
                integrantesSeleccionados.clear();
                agregarIntegrantesButton.setText("Añadir Integrantes (0)");
                mostrarVentanaSeleccionarContactos(integrantesSeleccionados, agregarIntegrantesButton);
            }
        });

        // Crear ventana
        JFrame ventana = new JFrame("Agregar Reunion");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(300, 200);

        // Agregar panel y botón Guardar a la ventana
        ventana.add(panel, BorderLayout.CENTER);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos de los campos de entrada
                String descripcion = descripcionField.getText();
                String fecha = ((JTextField)fechaChooser.getDateEditor().getUiComponent()).getText(); // Obtener la fecha del JDateChooser
                Date tiempo = (Date) tiempoSpinner.getValue(); // Obtener la hora del JSpinner

                // Formatear la fecha y hora a String
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
                String fechaString = formatoFecha.format(fecha);
                String horaString = formatoHora.format(tiempo);

                // Crear reunion
                Reunion reunion = new Reunion(descripcion, fechaString, new ArrayList<>(integrantesSeleccionados), horaString);

                // Agregar reunion a la agenda
                String resultado = agenda.agregarReunion(reunion);

                // Mostrar resultado
                JOptionPane.showMessageDialog(ventana, resultado);

                // Cerrar la ventana
                ventana.dispose();
            }
        });
        ventana.add(guardarButton, BorderLayout.SOUTH);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void mostrarVentanaEliminarReuniones() {
        // Crear tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tabla = new JTable(modeloTabla);
        modeloTabla.setColumnIdentifiers(new Object[]{"Descripcion", "Fecha", "Tiempo", "Integrantes"});
        for (Reunion reunion : agenda.getListaReuniones()) {
            String integrantes = "";
            for (Contacto contacto : reunion.getIntegrantesReunion()) {
                integrantes += contacto.getNombre() + ", ";
            }
            if (integrantes.length() > 2) {
                integrantes = integrantes.substring(0, integrantes.length() - 2);
            }
            modeloTabla.addRow(new Object[]{reunion.getDescripcion(), reunion.getFechaReunion(), reunion.getTiempoReunion(), integrantes});
        }

        // Crear ventana
        JFrame ventana = new JFrame("Eliminar Reuniones");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(600, 400);

        // Agregar tabla a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventana.add(scrollPane, BorderLayout.CENTER);

        // Agregar botón Eliminar
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarReunionesSeleccionadas(tabla);
                ventana.dispose(); // Cerrar la ventana después de eliminar
            }
        });
        ventana.add(eliminarButton, BorderLayout.SOUTH);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void eliminarReunionesSeleccionadas(JTable tabla) {
        int[] filasSeleccionadas = tabla.getSelectedRows();
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();

        for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
            String descripcion = (String) modeloTabla.getValueAt(filasSeleccionadas[i], 0);

            // Buscar reunion
            Reunion reunionAEliminar = null;
            for (Reunion r : agenda.getListaReuniones()) {
                if (r.getDescripcion().equals(descripcion)) {
                    reunionAEliminar = r;
                    break;
                }
            }

            if (reunionAEliminar != null) {
                // Eliminar reunion de la agenda
                agenda.eliminarReunion(reunionAEliminar);
            }
        }

        // Actualizar la tabla de reuniones
        mostrarReuniones();
    }

    private void mostrarVentanaSeleccionarContactos(List<Contacto> integrantesSeleccionados, JButton agregarIntegrantesButton) {
        // Crear tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tabla = new JTable(modeloTabla);
        modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Telefono", "Alias", "Direccion", "Email"});
        for (Contacto contacto : agenda.getListaContactos()) {
            modeloTabla.addRow(new Object[]{contacto.getNombre(), contacto.getTelefono(), contacto.getAlias(), contacto.getDireccion(), contacto.getEmail()});
        }

        // Crear ventana
        JFrame ventana = new JFrame("Seleccionar Contactos");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(600, 400);

        // Agregar tabla a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventana.add(scrollPane, BorderLayout.CENTER);

        // Agregar botón Añadir
        JButton añadirButton = new JButton("Añadir");
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar la lista de integrantesSeleccionados para permitir correcciones
                integrantesSeleccionados.clear();

                // Obtener contactos seleccionados
                int[] filasSeleccionadas = tabla.getSelectedRows();
                for (int fila : filasSeleccionadas) {
                    String nombre = (String) modeloTabla.getValueAt(fila, 0);
                    String telefono = (String) modeloTabla.getValueAt(fila, 1);
                    // Buscar contacto
                    Contacto contacto = null;
                    for (Contacto c : agenda.getListaContactos()) {
                        if (c.getNombre().equals(nombre) && c.getTelefono().equals(telefono)) {
                            contacto = c;
                            break;
                        }
                    }
                    if (contacto != null) {
                        integrantesSeleccionados.add(contacto);
                    }
                }

                // Actualizar el texto del botón "Añadir Integrantes"
                agregarIntegrantesButton.setText("Añadir Integrantes (" + integrantesSeleccionados.size() + ")");

                // Cerrar la ventana
                ventana.dispose();
            }
        });
        ventana.add(añadirButton, BorderLayout.SOUTH);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void mostrarContactos() {
        // Crear tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tabla = new JTable(modeloTabla);
        modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Telefono", "Alias", "Direccion", "Email"});
        for (Contacto contacto : agenda.getListaContactos()) {
            modeloTabla.addRow(new Object[]{contacto.getNombre(), contacto.getTelefono(), contacto.getAlias(), contacto.getDireccion(), contacto.getEmail()});
        }

        // Crear ventana
        JFrame ventana = new JFrame("Contactos");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(600, 400);

        // Agregar tabla a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventana.add(scrollPane);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void mostrarGrupos() {
        // Crear tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tabla = new JTable(modeloTabla);
        modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Categoria", "Integrantes"});
        for (Grupo grupo : agenda.getListaGrupos()) {
            String integrantes = "";
            for (Contacto contacto : grupo.getIntegrantes()) {
                integrantes += contacto.getNombre() + ", ";
            }
            if (integrantes.length() > 2) {
                integrantes = integrantes.substring(0, integrantes.length() - 2);
            }
            modeloTabla.addRow(new Object[]{grupo.getNombre(), grupo.getCategoria(), integrantes});
        }

        // Crear ventana
        JFrame ventana = new JFrame("Grupos");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(600, 400);

        // Agregar tabla a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventana.add(scrollPane);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    private void mostrarReuniones() {
        // Crear tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tabla = new JTable(modeloTabla);
        modeloTabla.setColumnIdentifiers(new Object[]{"Descripcion", "Fecha", "Tiempo", "Integrantes"});
        for (Reunion reunion : agenda.getListaReuniones()) {
            String integrantes = "";
            for (Contacto contacto : reunion.getIntegrantesReunion()) {
                integrantes += contacto.getNombre() + ", ";
            }
            if (integrantes.length() > 2) {
                integrantes = integrantes.substring(0, integrantes.length() - 2);
            }
            modeloTabla.addRow(new Object[]{reunion.getDescripcion(), reunion.getFechaReunion(), reunion.getTiempoReunion(), integrantes});
        }

        // Crear ventana
        JFrame ventana = new JFrame("Reuniones");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(600, 400);

        // Agregar tabla a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventana.add(scrollPane);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    // Función principal
    public static void main(String[] args) {
        new GUI();
    }
}