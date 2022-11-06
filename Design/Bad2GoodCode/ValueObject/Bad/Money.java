import java.util.Currency;

/**
 * データクラスと呼ばれる、よろしくない構造.
 * 外部からインスタンス変数を変更できてしまう.
 */
public class Money {

    /** 金額 */
    public int amount;
    /** 通貨単位 */
    public Currency currency;
}
