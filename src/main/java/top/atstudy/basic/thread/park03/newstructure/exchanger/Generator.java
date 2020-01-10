package top.atstudy.basic.thread.park03.newstructure.exchanger;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 14:49
 */
public interface Generator<T> {
    T next();
}
