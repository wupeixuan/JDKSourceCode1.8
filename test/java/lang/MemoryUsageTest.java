package java.lang;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * @author wupx
 * @date 2020/04/28
 */
public class MemoryUsageTest {

    public static void main(String[] args) {
        MemoryMXBean memoryMxBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = memoryMxBean.getHeapMemoryUsage();
        System.out.println(memoryUsage);
        List<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
        for (MemoryManagerMXBean memoryManagerMXBean : memoryManagerMXBeans) {
            System.out.println(memoryManagerMXBean.getName());
        }
    }

}
