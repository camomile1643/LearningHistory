import java.util.Currency;

public class Main {
    public static void main(String args[]) {
        
        Money money = new Money(100, Currency.getInstance("JPN"));
        
        // インスタンス生成時点で初期化しているので、生成直後に参照してもOK
        System.out.println(money.currency.toString());
        
        // 同じ型同士の計算のみ許容するので、異なる意味合いの値での計算がなくなる
        Money addMoney = new Money(50, Currency.getInstance("JPN"));
        Money totalMoney = money.add(addMoney);
        System.out.println(totalMoney.amount);
        
        // こういった計算をしようとするとコンパイル時点でエラーになるので、誤りにすぐ気づける
        // int purchaseAmount = 3;
        // Money totalMoney = money.add(purchaseAmount);
    }
}
