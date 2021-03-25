public class Lampada {
    private State state;
    private double powerNormal;
    private double powerEco;
    private long ligadoNormal;
    private long ligadoEco;

    public Lampada() {
        this.state = State.OFF;
        this.powerNormal = 0;
        this.powerEco = 0;
        this.ligadoNormal = 0;
        this.ligadoEco = 0;
    }

    public Lampada(double powerNormal, double powerEco, State state) {
        this.state = state;
        this.powerNormal = powerNormal;
        this.powerEco = powerEco;
    }

    public Lampada(Lampada lampada) {
        this.state = lampada.getState();
        this.powerNormal = lampada.getPowerNormal();
        this.powerEco = lampada.getPowerEco();
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getPowerNormal() {
        return this.powerNormal;
    }

    public void setPowerNormal(double powerNormal) {
        this.powerNormal = powerNormal;
    }

    public double getPowerEco() {
        return this.powerEco;
    }

    public void setPowerEco(double powerEco) {
        this.powerEco = powerEco;
    }

    public void lampON() {
        this.state = State.ON;
    }

    public void lampECO() {
        this.state = State.ECO;
    }
    
  

    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append("State: ").append(this.state.toString());;
        sb.append(" | Normal power: ").append(this.powerNormal);
        sb.append(" | Eco power = ").append(this.powerEco);
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Lampada lampada = (Lampada) o;
        return this.state.equals(lampada.getState()) &&
                Double.compare(lampada.getPowerNormal(), this.powerNormal) == 0 &&
                Double.compare(lampada.getPowerEco(), this.powerEco) == 0;
    }

    public Lampada clone() {
        return new Lampada(this);
    }
}
