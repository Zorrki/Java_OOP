public class MainMarket {
    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        Market myMarket = new Market();
        System.out.println();
        myMarket.acceptToMarket(new Human("Иван"));

        myMarket.update();

        myMarket.acceptToMarket(new Human("Василий"));
        myMarket.acceptToMarket(new Human("Игорь"));

        myMarket.update();

    }
}