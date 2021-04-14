public class Lampada {
    
    private Modo modo;
    private double consumoON;
    private double consumoECO;
    private double consumoTotal;
    // inicio do estado mais recente
    private double inicioEstado;

    public Lampada() {
        this.modo = Modo.OFF;
        this.consumoON = 2;
        this.consumoECO = 1;
        this.consumoTotal = 0;
        this.inicioEstado = System.currentTimeMillis();
    }

    public Lampada(Modo modo, double consumoON, double consumoECO, double consumoTotal, double inicioEstado){
        this.modo = modo;
        this.consumoON = consumoON;
        this.consumoECO = consumoECO;
        this.consumoTotal = consumoTotal;
        this.inicioEstado = inicioEstado;
    }

    public Lampada(Lampada lampada) {
        this.modo = lampada.getModo();
        this.consumoON = lampada.getConsumoON();
        this.consumoECO = lampada.getConsumoECO();
        this.consumoTotal = lampada.getConsumoTotal();
        this.inicioEstado = lampada.getInicioEstado();
    }

    public Modo getModo() {
        return this.modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public double getConsumoON() {
        return this.consumoON;
    }

    public void setConsumoON(double consumoON) {
        this.consumoON = consumoON;
    }

    public double getConsumoECO() {
        return this.consumoECO;
    }

    public void setConsumoECO(double consumoECO) {
        this.consumoECO = consumoECO;
    }
    
    public double getConsumoTotal() {
        return this.consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }
    
    public double getInicioEstado(){
        return this.inicioEstado;
    }
    
    public void setInicioEstado( double inicioEstado){
        this.inicioEstado = inicioEstado;
    }
    
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append("Lampada modo: ").append(this.modo.toString());;
        sb.append(" | Consumo ON por segundo: ").append(this.consumoON);
        sb.append(" | Consumo ECO por segundo: ").append(this.consumoECO);
        sb.append(" | Consumo Total: ").append(this.consumoTotal);
        sb.append(" | Ultimo Reset: ").append(this.inicioEstado);
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Lampada lampada = (Lampada) o;
        return this.modo == lampada.getModo() && 
                lampada.getConsumoON() == this.consumoON &&
                lampada.getConsumoECO() == this.consumoECO && 
                lampada.getConsumoTotal() == this.consumoTotal &&
                lampada.getInicioEstado() == this.inicioEstado;
                
    }

    public Lampada clone() {
        return new Lampada(this);
    }
    
    private void calculaECO(){
        double periodoDeTempo = System.currentTimeMillis() - inicioEstado;
        this.consumoTotal += periodoDeTempo * consumoECO;
    }
    
    private void calculaON(){
        double periodoDeTempo = System.currentTimeMillis() - inicioEstado;
        this.consumoTotal += periodoDeTempo * consumoON;
    }
    
  
    public void lampON() {
        if(this.modo == Modo.ECO){
            calculaECO();
        }
        inicioEstado = System.currentTimeMillis();
        this.modo = Modo.ON;
    }
    
    public void lampECO() {
        if(this.modo == Modo.ON){
            calculaON();
        }
        inicioEstado = System.currentTimeMillis();
        this.modo = Modo.ECO;
    }

    public void lampOFF() {
        if(this.modo == Modo.ECO){
            calculaECO();
        }
        if(this.modo == Modo.ON){
            calculaON();
        }
        inicioEstado = System.currentTimeMillis();
        this.modo = Modo.OFF;
    }
    
    public double totalConsumo(){
        return this.consumoTotal + periodoConsumo();
    }
    
    public double periodoConsumo(){
        double consumoAtual = 0;
        if(this.modo == Modo.ON){
            consumoAtual = (System.currentTimeMillis() - inicioEstado)*this.consumoON;
        }
        if(this.modo == Modo.ECO){
            consumoAtual = (System.currentTimeMillis() - inicioEstado)*this.consumoECO;
        }
        return consumoAtual;
    }
    
    
}
