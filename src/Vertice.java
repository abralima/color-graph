public class Vertice {
    private String name;
    private Integer cor = -1;

    public Vertice(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCor() {
        return this.cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

}
