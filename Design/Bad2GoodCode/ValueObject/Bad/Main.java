import java.util.Currency;

/**
 * データクラスの使われる例.
 */
public class Main {
    public static void main(String arg[]) {
        
        Money money = new Money();

        /**
         * 生焼けオブジェクト.
         * このタイミングでcurrencuyのtoStringを実行すると、
         * currencyはまだnullなのでNullPointerExceptionが発生する.
         */
        // System.out.println(money.currency.toString());

        /**
         * 初期化が散在する.
         * データを扱うクラスに初期化を任せるので、初期化処理が複数の場所に散在する.
         * 仕様変更の際、直すのが大変になり、修正漏れリスクも発生する.
         */
        money.amount = 100;
        money.currency = Currency.getInstance("JPN");

        /**
         * 不正値の混入.
         * 仕様上ありえない値で初期化できてしまう.
         * バグの原因になる.
         */
        money.currency = null;

        /**
         * 他の意味合いを取る値との不正な計算.
         * 下記のような「金額 + 購入数」といった不正な計算が許容されてしまう.
         * バグの原因や可読性低下に繋がる.
         */
        int purchaceAmount = 3;
        money.amount += purchaceAmount;

    }
}
