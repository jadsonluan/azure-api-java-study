package com.fgan.azure.fogbowmock.executions;

import cloud.fogbow.ras.core.models.UserData;
import cloud.fogbow.ras.core.models.orders.ComputeOrder;
import com.fgan.azure.fogbowmock.image.AzureImageOperation;
import com.fgan.azure.util.PropertiesUtil;

import java.util.ArrayList;

/**
 * This section is dedicated to Azure Fogbow Plugin
 */
public class AppFogbowPlugin {

    public static void main( String[] args ) throws Exception {
        System.out.println("Hello Azure/Fogbow Plugins Api!");

        String filePropertiesPath = System.getenv(PropertiesUtil.COMPUTE_PLUGIN_PROPERTIES_ENV);

        String imageId = new StringBuilder()
                .append("Canonical")
                .append(AzureImageOperation.IMAGE_SUMMARY_ID_SEPARETOR)
                .append("UbuntuServer")
                .append(AzureImageOperation.IMAGE_SUMMARY_ID_SEPARETOR)
                .append("18.04-LTS")
                .toString();

        String id = "123456789101112131415";
        ComputeOrder computeOrder = new ComputeOrder(
                id, null, "", "", "", "", 0, 0, 0, imageId, new ArrayList<UserData>(), "", new ArrayList<>());
        SampleExecutionFogbowPlugin.start()
                .compute(filePropertiesPath)
                    .start()
                        .create(computeOrder)
                    .end()
                .finish();

        runningForeverUntilYouStopIt();
    }

    public static void runningForeverUntilYouStopIt() throws InterruptedException {
        final int SLEEP_TIME = 10000;
        while (true) {
            Thread.sleep(SLEEP_TIME);
            System.out.println("I am alive !!");
        }
    }

}
