package com.fgan.azure.api;

import com.fgan.azure.Constants;
import com.fgan.azure.PrintHolder;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.VirtualMachinePublisher;

public class ImageApi {

    public static void printInformation(Azure azure) {
        PagedList<VirtualMachinePublisher> imagePublishers = getImagePublishers(azure);
        PrintHolder.printVirtualMachinePublishersLines(imagePublishers);
    }

    public static PagedList<VirtualMachinePublisher> getImagePublishers(Azure azure) {
        return azure.virtualMachineImages().publishers().listByRegion(Constants.REGION_DEFAULT);
    }

}
