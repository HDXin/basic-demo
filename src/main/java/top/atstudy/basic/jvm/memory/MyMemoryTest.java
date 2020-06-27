package top.atstudy.basic.jvm.memory;

/**
 * Java虚拟机栈：Stack Frame 栈帧
 * 程序计数器：
 * 本地方法栈：主要用于处理本地方法
 * 堆（heap)：JVM管理的最大的一块内存空间
 * 方法区（Method Area)：存储元信息。永久代（Permanent Generation), 从 JDK1.8开始，已经撤底废弃了永久代，使用元空间（meta space）
 * 运行时常量池：方法区的一部分内容
 * 直接内存：Direct Memory
 *
 * 指针碰撞：假如Java堆中内存是绝对规整的，所有用过的内存都放在一边，空闲的内存放在另一边，中间放着一个指针作为分界点的指示器，
 * 那分配内存就是仅仅把那个指针指向空闲空间那边挪动一段与对象大小相等距离；
 * 空闲列表：假如Java堆中的内存不是规整的，已使用的内存与空闲内存相互交错，那就没有办法进行简单的指针碰撞了，虚拟机就必须维护一块
 * 内存列表，记录上哪些内存块是可用的，再分配的时候在列表中找到一块足够大的空间划分给对象实例，并更新列表上的记录；
 *
 * 注意：采用哪种垃圾收集器由Java堆是否规整决定，而Java堆是否规整又由所采用的垃圾收集器是否带有压缩整理功能决定；
 *
 * 对象的内存布局
 * 1、对象头：
 * 2、实例数据：
 * 3、对齐填充：
 */
public class MyMemoryTest {

    public static void main(String[] args) {

        String a = "abcdefghijklmnopqrstuvwxyz";

        while (true){
            a.intern();
        }


    }



}
