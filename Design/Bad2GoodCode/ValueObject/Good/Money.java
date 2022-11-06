import java.util.Currency;

/**
 * 値オブジェクト化した金額クラス.
 */
public class Money {
    
    /** 金額 */
    public final int amount;
    /** 通貨単位 */
    public final Currency currency;

    // コンストラクタを利用して、インスタンス生成時に初期化を要求する.
    public Money(final int amount, final Currency currency) {
        // ガード節で不正値の混入を防ぐ
        if (currency == null) {
            throw new IllegalArgumentException("currencyは必須入力です.");
        }
        this.amount = amount;
        this.currency = currency;
    }

    // 金額の計算を同じクラスにまとめることで、凝集度を上げる.
    // 引数に自身のクラスを指定することで、別の意味合いの値と計算されることを防ぐ.
    public Money add(final Money addAmount) {
        // ガード節で不正な引数を弾くことも忘れずに
        if (addAmount == null) {
            throw new IllegalArgumentException("addAmountは必須入力です.");
        }
        if (!this.currency.equals(addAmount.currency)) {
            throw new IllegalArgumentException("通貨単位の異なる金額の加算はできません.");
        }
        // 引数やローカル変数はfinal修飾子を付与して不変化し、誤代入を防ぐ.
        final int added = this.amount + addAmount.amount;
        // インスタンス生成で返すことで不変を維持する.
        return new Money(added, this.currency);
    }

    public Money sub(final Money subAmount) {
        if (subAmount == null) {
            throw new IllegalArgumentException("subAmountは必須入力です.");
        }
        if (!this.currency.equals(subAmount.currency)) {
            throw new IllegalArgumentException("通貨単位の異なる金額の減算はできません.");
        }
        final int subbed = this.amount - subAmount.amount;
        return new Money(subbed, currency);
    }
}
