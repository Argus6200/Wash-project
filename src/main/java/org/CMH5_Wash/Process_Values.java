package org.CMH5_Wash;

import java.util.List;
import java.util.ArrayList;

public class Process_Values {
    public static List<List<String>> fix(List<List<String>> iterated){
        List<List<String>> fixed = new ArrayList<>();
        for (List<String> row : iterated){
            //System.out.println(row);//raw rows
            if (row.size() == 14){
                row.add(4, "None");
            }
            if(
                !row.get(5) .equals("0.0") ||
                !row.get(6) .equals("0.0") ||
                !row.get(7) .equals("0.0") ||
                !row.get(8) .equals("0.0") ||
                !row.get(9) .equals("0.0") ||
                        !row.get(11) .equals("0.0") ||
                        !row.get(12) .equals("0.0") ||
                        !row.get(13) .equals("0.0") ||
                        !row.get(14) .equals("0.0")){
                fixed.add(row);
            }
        }
        return fixed;
    }
    public static List<List<String>> process(List<List<String>> fixed) {
        float CoreOpsH = 0;
        float FluidUnloadH = 0, ContainerUnloadH = 0, JamBreakerH = 0, TDRh = 0;
        float ContainerBuildPalletH = 0, OutboundContainerBuildH = 0, OutboundWaterspiderH = 0, OutboundStagerH = 0;
        float SmallsSortSupportH = 0, ContainerBuildShuttleH = 0, ContainerBuildBag_xs_sH = 0, SmallsStagingH = 0, WaterspiderShuttleBagH = 0;
        float NonConProcessingPickoffH = 0, NonConWSH = 0, ContainerBuildBagNCH = 0, StagerNonConH = 0;
        float ProblemSolveProcessingH = 0, GatekeeperH = 0, ICQAH = 0;
        float nonInvintoryH = 0, TOTH = 0;
        //System.out.println(fixed.get(5));
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for(List<String> row : fixed){
            if (row.get(0).equals("Core Ops")){
                if(!temp.contains(row.get(7))){
                    temp.add(row.get(7));
                }
            }

            try {
                String ID = row.get(3);
                String attributes = row.get(4);
                if (ID.contains("100366")) {
                    FluidUnloadH += Float.parseFloat(row.get(7));
                }

                if (ID.contains("100233")) {
                    ContainerUnloadH += Float.parseFloat(row.get(7));
                }

                if (ID.contains("100372")) {
                    JamBreakerH += Float.parseFloat(row.get(7));
                }

                if (ID.contains("100371")) {
                    TDRh += Float.parseFloat(row.get(7));
                }

                if (row.get(2).equals("Container Building")) {
                    if (!(attributes.contains("Non-Conveyable"))) {
                        if (attributes.contains("Pallet")) {
                            ContainerBuildPalletH += Float.parseFloat(row.get(7));
                        }
                    }
                }

                //TODO Outbound container build Hours

                if(ID.contains("100511")){
                    if(attributes.contains("Pallet")){
                        OutboundWaterspiderH += Float.parseFloat(row.get(7));
                    }
                }
                if(ID.contains("100022")){
                    if(attributes.contains("Pallet")){
                        OutboundStagerH += Float.parseFloat(row.get(7));
                    }
                }
            }catch(NumberFormatException e){}
        }
        CoreOpsH = AddValues.addListValues(temp);
        System.out.println(CoreOpsH);
        System.out.println(
                "INBOUND" +
                "\nFluid Unload Hours: " + FluidUnloadH +
                "\nContainer Unload Hours: " + ContainerUnloadH +
                "\nJam breaker Hours: " + JamBreakerH +
                "\nTDR Hours: " + TDRh +
                "\n\nSORTATION" +
                "\n Container Build Pallet Hours: " + ContainerBuildPalletH +
                "\n Outbound Container Build Hours: " + OutboundContainerBuildH +
                "\n Outbound Waterspider Hours: " + OutboundWaterspiderH +
                "\n Outbound Staging Hours: " + OutboundStagerH);
        System.out.println(temp);
        return result;
    }
}
