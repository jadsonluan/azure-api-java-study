package com.fgan.azure;

import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.compute.VirtualMachineImage;
import com.microsoft.azure.management.compute.VirtualMachinePublisher;
import com.microsoft.azure.management.compute.VirtualMachineSize;
import com.microsoft.azure.management.network.Network;
import com.microsoft.azure.management.network.NetworkInterface;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class PrintHolder {

    public static void printNetworksLines(PagedList<Network> networks) {
        PrintHolder.printSet(objects -> {
            for (Object object: objects) {
                Network network = (Network) object;
                PrintHolder.printLines(network::name, network::id, network::regionName);
            }
        } , networks);
    }

    public static void printNetworkInterfacessLines(PagedList<NetworkInterface> networkInterfaces) {
        PrintHolder.printSet(objects -> {
            for (Object object: objects) {
                NetworkInterface networkInterface = (NetworkInterface) object;
                PrintHolder.printLines(networkInterface::name, networkInterface::id, networkInterface::key);
            }
        } , networkInterfaces);
    }

    public static void printVirtualMachineImageLines(PagedList<VirtualMachineImage> vmImages) {
        PrintHolder.printSet(objects -> {
            for (Object object: objects) {
                VirtualMachineImage vmImage = (VirtualMachineImage) object;
                PrintHolder.printLines(vmImage::publisherName);
            }
        } , vmImages);
    }

    public static void printVirtualMachineSizeLines(PagedList<VirtualMachineSize> virtualMachineSizes) {
        PrintHolder.printSet(objects -> {
            for (Object object: objects) {
                VirtualMachineSize vmSizes = (VirtualMachineSize) object;
                PrintHolder.printLines(vmSizes::name, vmSizes::numberOfCores, vmSizes::memoryInMB);
            }
        }, virtualMachineSizes);
    }

    public static void printVirtualMachinePublishersLines(
            PagedList<VirtualMachinePublisher> virtualMachinePublishers) {

        PrintHolder.printSet(objects -> {
            for (Object object: objects) {
                VirtualMachinePublisher virtualMachinePublisher = (VirtualMachinePublisher) object;
                PrintHolder.printLines(virtualMachinePublisher::name);
            }
        }, virtualMachinePublishers);
    }

    private static void printSet(Consumer<PagedList<? extends Object>> consumer,
                                PagedList<? extends Object> list) {
        System.out.println("-------------------------");
        consumer.accept(list);
        System.out.println("-------------------------");
    }

    public static void printLines(Supplier<? extends Object>... suppliers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        for (int i = 0; i < suppliers.length; i++) {
            stringBuilder.append(suppliers[i].get());
            stringBuilder.append("|");
        }
        System.out.println(stringBuilder.toString());
    }
}
