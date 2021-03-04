package entities;

public class CoinFactory {

    public static Coin getCoinInstance(Coins coin) {

        switch (coin) {
            case USD:
                return new Usd();
            default:
                return new Ils();
        }
    }
}
