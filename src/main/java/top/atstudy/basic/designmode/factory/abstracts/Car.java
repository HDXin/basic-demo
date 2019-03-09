package top.atstudy.basic.designmode.factory.abstracts;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/9 10:18
 */
public class Car {

    protected Brand brand;

    private Gearbox gearbox;

    private Edition edition;

    public Car(Brand brand, Gearbox gearbox, Edition edition) {
        this.brand = brand;
        this.gearbox = gearbox;
        this.edition = edition;
    }

    public void run(){

        System.out.println(" ===>> 品牌：" + this.brand.getBrand()
                + " ,变速箱：" + this.gearbox.getGearbox()
                + " ,版本：" + this.edition.getEdition());
    }
}
