package pl.pjatk.danmak.four;

public class Pojoclass {
    private int exampleInt;
    private String exampleString;

    public String getExampleString() {
        return exampleString;
    }

    public void setExampleString(String exampleString) {
        this.exampleString = exampleString;
    }

    public int getExampleInt() {
        return exampleInt;
    }

    public void setExampleInt(int exampleInt) {
        this.exampleInt = exampleInt;
    }

    public Pojoclass(int exampleInt, String exampleString){
        this.exampleInt = exampleInt;
        this.exampleString = exampleString;
    }
    public Pojoclass(){}
}
