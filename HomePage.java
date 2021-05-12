import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener{
    private double temperature = 19.5;
    private double lightSensor = 0.8;
    private double airPressure = 1024;
    private double humidity = 0.45;

    private boolean lights;
    private boolean heating;

    String[] userList = new String[] {};
 
    private JComboBox<String> userComboBox;
    private JButton temperatureButton, lightSensorButton, airPressureButton, humidityButton;
    private JLabel lightStatusLabel, heatingStatusLabel;


    Color accentColor = new Color(140,180,220);

    GridBagConstraints gbc = new GridBagConstraints();
   

    public HomePage(String[] userList) {
        this.userList = userList;

        this.setLayout(new GridBagLayout());
        this.setTitle("Home Page");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(240,240,240));

        JPanel sensorPanel = new JPanel();
        sensorPanel.setLayout(new GridLayout(2,2,20,20));
        sensorPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(accentColor,2,true),"Sensor Data"), BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        temperatureButton = new JButton("NAN");
        sensorPanel.add(temperatureButton);
        temperatureButton.addActionListener(this);
        buttonAppearance(temperatureButton);

        lightSensorButton = new JButton("NAN");
        sensorPanel.add(lightSensorButton);
        lightSensorButton.addActionListener(this);
        buttonAppearance(lightSensorButton);

        airPressureButton = new JButton("NAN");
        sensorPanel.add(airPressureButton);
        airPressureButton.addActionListener(this);
        buttonAppearance(airPressureButton);

        humidityButton = new JButton("NAN");
        sensorPanel.add(humidityButton);
        humidityButton.addActionListener(this);
        buttonAppearance(humidityButton);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout());
        statusPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(accentColor,2,true),"Status"));

        lightStatusLabel = new JLabel("NAN");
        statusPanel.add(lightStatusLabel);
        heatingStatusLabel = new JLabel("NAN");
        statusPanel.add(heatingStatusLabel);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(2,2,20,20));
        userPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(accentColor,2,true),"Users"));

        userComboBox = new JComboBox<>(userList);
        userComboBox.setBackground(new Color(255,255,255));
       
        userComboBox.setSize(200, 200);
        userPanel.add(userComboBox);
        
        JPanel musicPanel = new JPanel();
        musicPanel.setLayout(new GridLayout(2,2,20,20));
        musicPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(accentColor,2,true),"music"));
       

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5,5,5,5);
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.gridheight = 10;
        add(sensorPanel,gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 12;
        gbc.gridheight = 2;
        add(statusPanel,gbc);

        gbc.gridx = 12;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        add(userPanel,gbc);
        
        gbc.gridx = 12;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.gridheight = 10;
        add(musicPanel,gbc);
        
        this.setVisible(true);
    }
    
    //getters and setters:
    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        temperatureButton.setText(buttonHtml("Temperature",temperature));
    }

    public double getLightSensor() {
        return this.lightSensor;
    }

    public void setLightSensor(double lightSensor) {
        this.lightSensor = lightSensor;
        lightSensorButton.setText(buttonHtml("Light Sensor",lightSensor));
    }

    public double getAirPressure() {
        return this.airPressure;
    }

    public void setAirPressure(double airPressure) {
        this.airPressure = airPressure;
        airPressureButton.setText(buttonHtml("Air Pressure",airPressure));
    }

    public double getHumidity() {
        return this.humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
        humidityButton.setText(buttonHtml("Humidity",humidity));
    }

    public boolean isLights() {
        return this.lights;
    }

    public boolean getLights() {
        return this.lights;
    }

    public void setLights(boolean lights) {
        this.lights = lights;
        if (lights) { lightStatusLabel.setText("| lights are turned on |"); }
        else { lightStatusLabel.setText("| lights are turned off |"); }
    }

    public boolean isHeating() {
        return this.heating;
    }

    public boolean getHeating() {
        return this.heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
        if (heating) { heatingStatusLabel.setText("| heating is turned on |"); }
        else { heatingStatusLabel.setText("| heating is turned off |"); }
    }


    //button actions TODO 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.temperatureButton) {
            //TODO
        }
    }

    //returns button text appearance in html
    private String buttonHtml(String text, Double value){
        return "<html><b style=\"color:#ffffff;color:#72b2f2;font-size:12px;\">"+text+"<b><br/><b style=\"color:#ffffff;color:#404040;font-size:28px;\">"+value+"</b></html>";
    }

    //set the button appearance
    private void buttonAppearance(JButton button) {
        button.addActionListener(this);
        button.setBackground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    public void addUserList(String user) {
        userComboBox.addItem(user);
    }

    //gets the slected user
    public String getSeletedUser() {
        String selectedUser = (String) userComboBox.getSelectedItem();
        System.out.println("user " + selectedUser + " is currently sellected");
        return selectedUser;
    }
}