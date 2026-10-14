package Bai8;
import java.util.*;

abstract class SmartDevice {
    protected String id;
    protected String name;
    protected boolean isOn;

    public SmartDevice(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = true;
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " turned off");
    }
}
interface Wifi {
    void connectWifi();
}

interface Adjustable {
    void adjustLevel();
}

class Light extends SmartDevice implements Adjustable {
    public Light(String id, String name) {
        super(id, name);
    }

    @Override
    public void adjustLevel() {
        System.out.println(name + " adjusted brightness");
    }
}

class AirConditioner extends SmartDevice implements Wifi {
    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class Speaker extends SmartDevice implements Wifi, Adjustable {
    public Speaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }

    @Override
    public void adjustLevel() {
        System.out.println(name + " adjusted volume");
    }
}

class Curtain extends SmartDevice {
    public Curtain(String id, String name) {
        super(id, name);
    }
}

class Hub {
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public void setupWifi() {
        System.out.println("\nSetup Wifi:");
        for (SmartDevice device : devices) {
            if (device instanceof Wifi) {
                ((Wifi) device).connectWifi();
            }
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Hub hub = new Hub();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            SmartDevice device = null;

            if (type.equals("L")) {
                device = new Light(id, name);
            } else if (type.equals("AC")) {
                device = new AirConditioner(id, name);
            } else if (type.equals("S")) {
                device = new Speaker(id, name);
            } else if (type.equals("C")) {
                device = new Curtain(id, name);
            }

            if (device != null) {
                hub.addDevice(device);
            }
        }

        hub.turnOffAll();
        hub.setupWifi();

        sc.close();
    }
}
