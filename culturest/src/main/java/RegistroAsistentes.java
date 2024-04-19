
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.JSONArray;
import org.json.JSONObject;

public class RegistroAsistentes {
    private List<Asistente> asistentes = new ArrayList<>();
    private JFrame frame;
    private JTextField nombreInput;
    private JTextField emailInput;

    public RegistroAsistentes() {
        prepareGUI();
    }

    private void prepareGUI() {
        frame = new JFrame("Registro de Asistentes Culturest");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        nombreInput = new JTextField(20);
        emailInput = new JTextField(20);
        JButton addButton = new JButton("Registrar Asistente");
        JButton exportButton = new JButton("Exportar a JSON");

        frame.add(new JLabel("Nombre:"));
        frame.add(nombreInput);
        frame.add(new JLabel("Email:"));
        frame.add(emailInput);
        frame.add(addButton);
        frame.add(exportButton);

        addButton.addActionListener(this::addAsistente);
        exportButton.addActionListener(this::exportarAsistentesJSON);

        frame.setVisible(true);
    }

    private void addAsistente(ActionEvent e) {
        asistentes.add(new Asistente(nombreInput.getText(), emailInput.getText()));
        nombreInput.setText("");
        emailInput.setText("");
        JOptionPane.showMessageDialog(frame, "Asistente registrado con éxito.");
    }

    private void exportarAsistentesJSON(ActionEvent e) {
    JSONArray jsonArray = new JSONArray();
    for (Asistente asistente : asistentes) {
        JSONObject obj = new JSONObject();
        obj.put("nombre", asistente.getNombre());
        obj.put("email", asistente.getEmail());
        jsonArray.put(obj); // Usa put en lugar de add para JSONArray en org.json
    }

    try (FileWriter file = new FileWriter("asistentes.json")) {
        file.write(jsonArray.toString()); // Usa toString() en lugar de toJSONString()
        file.flush();
        JOptionPane.showMessageDialog(frame, "Datos exportados a JSON con éxito.");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(frame, "Error al exportar datos: " + ex.getMessage());
    }
}

    public static void main(String[] args) {
        new RegistroAsistentes();
    }
}
