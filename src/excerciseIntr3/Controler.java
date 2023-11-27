package excerciseIntr3;

public class Controler implements Runnable{

  private Model model;

  private Double gross, net, proyectedLost;
  private Integer utilDays;

  public Controler(Model model) {
    this.model = model;
  }

  private Double groosAmount() {
    return model.getPrice() * model.getAmount();
  }

  private Double netAmount(Double g) {
    return g * 0.83;
  }

  private Double lost(Double n) {
    return n / 12;
  }

  private Integer diff() {
    return model.getExpirationDate().compareTo(model.getCreationDate());
  }

public Model getModel() {
    return model;
}

public void setModel(Model model) {
    this.model = model;
}

public Double getGross() {
    return gross;
}

public void setGross(Double gross) {
    this.gross = gross;
}

public Double getNet() {
    return net;
}

public void setNet(Double net) {
    this.net = net;
}

public Double getProyectedLost() {
    return proyectedLost;
}

public void setProyectedLost(Double proyectedLost) {
    this.proyectedLost = proyectedLost;
}

public Integer getUtilDays() {
    return utilDays;
}

public void setUtilDays(Integer utilDays) {
    this.utilDays = utilDays;
}

@Override
public String toString() {
    return "Controler [model=" + model.toString() + ", gross=" + gross + ", net=" + net + ", proyectedLost=" + proyectedLost
            + ", utilDays=" + utilDays + "]";
}

@Override
public void run() {
    gross = groosAmount();
    net = netAmount(gross);
    proyectedLost = lost(net);
    utilDays = diff();
}
}
