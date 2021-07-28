package br.univali.petri;

public class Place {
    private final Integer id;
    private Integer tokenCount;

    public Place(Integer id, Integer tokenCount) {
        this.id = id;
        this.tokenCount = tokenCount;
    }

    void setTokenCount(Integer count) {
        this.tokenCount = count;
    }

    public void incrementTokenCount(Integer amount) {
        this.tokenCount += amount;
    }

    public void decrementTokenCount(Integer amount) {
        this.tokenCount -= amount;
    }

    public Integer getTokenCount() {
        return tokenCount;
    }

    public Integer getId() {
        return id;
    }
}
